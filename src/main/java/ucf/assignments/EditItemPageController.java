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

    // this function will receive an item, retrieve its due date
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

    //set item to the item that is passed to the function
    //use load item to load the items
    public void setItem(Item item) throws ParseException {
        this.item = item;
        loadItem();
    }

    @FXML
    public void saveItem() {

        // trim the blanks so we can count the num of chars for each description against the 256 requirement

        String description = itemDescription.getText().trim();

        // check if the item description is blank using descriptionChecker function
        // show error if it is
        if(descriptionChecker(description)==0) {
            showErrorAlert("Error", "Please enter a valid item description.");
            return;
        }

        // check if the item description exceeds 256 chars using descriptionChecker function
        // show error if it is
        if(descriptionChecker(description)==-1) {
            showErrorAlert("Error", "Max item description length is 256.");
            return;
        }

        // if item description matches the format check the due date

        LocalDate localDate = itemDate.getValue();

        // if date is empty show an error message
        if(localDate == null){
            showErrorAlert("Error", "Please select a valid due date.");
            return;
        }

        // set due date using dueDateGetter converter
        String due_date = dueDateGetter(localDate);

        // set the item using the description and date
        item.setItemDescription(description);
        item.setDueDate(due_date);


        Stage stage = (Stage) itemDate.getScene().getWindow();

        // display success alert if the hit the use saves the item
        showSuccessAlert("Success", "Your item was successfully saved.");
        stage.close();
    }


    // this function formats the date to the YYYY-MM-DD
    public String dueDateGetter(LocalDate localDate){
            // create the desired pattern for the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        // get the instant from local Date from Start of the day
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));

        // create a date from the instant
        Date date = Date.from(instant);

        // dateFormat style of dueDate using the date
        String due_date = dateFormat.format(date);

        return due_date;
    }


// this method will check a description to confirm if 1) it is not empty 2) its length wont exceed 256 chars

    public int descriptionChecker (String description){


        // check if the item entered is empty and if so return 0 to show an error message

        if(description.isEmpty()){
            return 0;
        }

        // check if the item entered length is outside 256 char limit and if so return -1 and show an error message

        if(description.length() > 256){
            return -1;
        }

        // if none of the above applies that means description is acceptable -> return 1
        return 1;
    }

    // error message function
    private void showErrorAlert(String title, String text){

        // type of this Alert is ERROR
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(text);
        alert.showAndWait();
    }

    // successful message function
    private void showSuccessAlert(String title, String text){

        //Type of this Alert is Informational, showing success of an operation
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
