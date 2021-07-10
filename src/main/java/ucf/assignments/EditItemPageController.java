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
import java.text.ParseException;
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
    private void loadItem() throws ParseException {

            itemDescription.setText(item.getItemDescription());
            itemDate.setValue(dateFormatter(item));

            }

    // this test will receive an item, retrieve its due date
    // changes the due to he correct format and returns a local date in the form of what is available in the date picker
    // in the app
    public LocalDate dateFormatter (Item item) throws ParseException {


        SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat date2 = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date2.format(date1.parse(item.getDueDate())), formatter);


        return localDate;
    }

    @FXML

    public void setItem(Item item) throws ParseException {
        this.item = item;
        loadItem();
    }
    @FXML
    public void saveItem() {

        // trim the blanks so we can count the num of chars for each description

        String description = itemDescription.getText().trim();


        if(!descriptionChecker(description))
            return;
/*
        // check if the item entered is empty and if so, show an error message

        if(description.isEmpty()){
            showErrorAlert("Error", "Please enter a valid item name.");
            return;
        }

        // check if the item entered length is outside 256 char limit and if so show an error message

        if(description.length() > 256){
            showErrorAlert("Error", "Max description length is 256.");
            return;
        }
*/
        // if item description matches the format check the due date

        //SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        LocalDate localDate = itemDate.getValue();
        if(localDate == null){
            showErrorAlert("Error", "Please select a valid due date.");
            return;
        }
        //Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        //Date date = Date.from(instant);
       // String due_date = ft.format(date);

        String due_date = dueDateGetter(localDate);
        item.setItemDescription(description);
        item.setDueDate(due_date);

        Stage stage = (Stage) itemDate.getScene().getWindow();
        showSuccessAlert("Success", "Your item was successfully saved.");
        stage.close();
    }


    public String dueDateGetter(LocalDate localDate){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        String due_date = dateFormat.format(date);

        return due_date;
    }


// this method will check a description to confirm if 1) it is not empty 2) its length wont exceed 256 chars

    public boolean descriptionChecker (String description){


        // check if the item entered is empty and if so, show an error message

        if(description.isEmpty()){
            showErrorAlert("Error", "Please enter a valid item description.");
            return false;
        }

        // check if the item entered length is outside 256 char limit and if so show an error message

        if(description.length() > 256){
            showErrorAlert("Error", "Max item description length is 256.");
            return false;
        }

        return true;
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
