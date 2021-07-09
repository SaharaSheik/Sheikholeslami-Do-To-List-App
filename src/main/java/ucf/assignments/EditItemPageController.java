/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sahar Sheikholeslami
 */


package ucf.assignments;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class EditItemPageController implements Initializable {

    @FXML
    TextField itemDescription;
    @FXML
    DatePicker itemDate;
    @FXML
    Item item;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML

    private void loadItem(){
        try{
            itemDescription.setText(item.getItemDescription());
            //get the date date
            SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            SimpleDateFormat date2 = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(date2.format(date1.parse(item.getDueDate())), formatter);
            itemDate.setValue(localDate);
        }catch (Exception e){

        }
    }
    @FXML

    public void setItem(Item item){
        this.item = item;
        loadItem();
    }
    @FXML
    public void saveItem() {
        String description = itemDescription.getText().trim();
        // check if the item entered is empty
        if(description.isEmpty()){
            showErrorAlert("Error", "Please enter a valid item name.");
            return;
        }
        // check if the item entered length is within 256 char limit

        if(description.length() > 256){
            showErrorAlert("Error", "Max description length is 256.");
            return;
        }


        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        LocalDate localDate = itemDate.getValue();
        if(localDate == null){
            showErrorAlert("Error", "Please select a valid due date.");
            return;
        }
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        String due_date = ft.format(date);

        item.setItemDescription(description);
        item.setDueDate(due_date);

        Stage stage = (Stage) itemDate.getScene().getWindow();

        stage.close();
    }

    // error message
    private void showErrorAlert(String title, String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(text);
        alert.showAndWait();
    }

    // successful message
    private void showSuccessAlert(String title, String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
