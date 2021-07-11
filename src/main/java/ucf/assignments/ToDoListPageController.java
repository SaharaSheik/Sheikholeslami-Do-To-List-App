/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sahar Sheikholeslami
 */

package ucf.assignments;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class ToDoListPageController implements Initializable {

    @FXML
    private TextField itemName ;
    @FXML
    private DatePicker itemDueDate ;
    @FXML
    private ListView<Item> itemListView ;
    @FXML
    private TextField displayItem ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // create a list of Item objects
        List<Item> items = loadItems();
        if(items != null){
            itemListView.getItems().addAll(items);
        }
    }

    @FXML
    // addItem method
    public void addItem(){
        // in case of extra spaces, trim the text so its fits within 256 char requirement
        String description = itemName.getText().trim();

        if(descriptionChecker(description)==0) {
            showErrorAlert("Error", "Please enter a valid item description.");
            return;
        }

        if(descriptionChecker(description)==-1) {
            showErrorAlert("Error", "Max item description length is 256.");
            return;
        }


        // formatting date YYYY-MM-DD
        LocalDate localDate = itemDueDate.getValue();


        // handle the case if the user does not enter a date
        if(localDate == null){
            showErrorAlert("Error", "Please select a valid due date.");
            return;
        }


        String due_date = dueDateGetter(localDate);

        Item item = new Item();
        item.setItemDescription(description);
        item.setDueDate(due_date);
        item.setItemDone(false);


        //check item list capacity each time before adding an item

        if(itemListView.getItems().size() >= 100){
            showErrorAlert("Error", "Maximum item capacity is 100.\nYou can not add anymore items.");
            return;
        }

        itemListView.getItems().add(item);

        //clear the itemName field in GUI to be ready to enter new item
        itemName.setText("");
    }




// this method will check a description to confirm if 1) it is not empty 2) its length wont exceed 256 chars
    // it returns 0 if empty
    // it return -1 if 256 chars+
    // it return 1 if neither which means the description was acceptable

    public int descriptionChecker (String description){


        // check if the item entered is empty and if so, show an error message

        if(description.isEmpty()){
            return 0;
        }

        // check if the item entered length is outside 256 char limit and if so show an error message

        if(description.length() > 256){
            return -1;
        }

        return 1;
    }

    //this item will sey the due date and turns it into a string formatted in YYYY-MM-DD

    public String dueDateGetter(LocalDate localDate){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        String due_date = dateFormat.format(date);

        return due_date;
    }


    @FXML
    // choosing an item to show the result in the display text field

    public void chooseItem(){
        Item selected_item = itemListView.getSelectionModel().getSelectedItem();
        if(selected_item == null)
            return;
        displayItem.setText(selected_item.getItemDescription());  // show the selected item in the display text filed at the bottom
    }
    @FXML

    // deleting an entire list and starting a new list

    public void deleteList(){
        itemListView.getItems().clear();
        itemListView.refresh();
        List<Item> items = new ArrayList<>();
        if(saveItemList(items)){
            showSuccessAlert("Successful", "All items are successfully deleted.");
        }

    }

    // checkmark function for itemDone and not done
    @FXML
    public void checkItemDone(){
        int index = itemListView.getSelectionModel().getSelectedIndex();
        if(index < 0)
            return;
        // if the item has itemDone value of true , change that to false
        if(itemListView.getItems().get(index).getItemDone()){
            itemListView.getItems().get(index).setItemDone(false);

            //otherwise, meaning if the getItemDone value is false, change it to true
        }else {
            itemListView.getItems().get(index).setItemDone(true);
        }
        //refresh the list view to show the correct status of item done
        itemListView.refresh();
    }

    // delete one item function
    @FXML
    public void deleteItem(){
        //find the index of the selected item from the itemsListView
        int index = itemListView.getSelectionModel().getSelectedIndex();
        if(index < 0)
            return;

        //remove the item at the selected index
        itemListView.getItems().remove(index);
    }

    // editItem Page opening function
    @FXML
    public void editItem() throws Exception{

        Item item = itemListView.getSelectionModel().getSelectedItem();
        if(item == null)
            return;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditItemPage.fxml"));
        Parent root1 =  fxmlLoader.load();

        EditItemPageController controller = fxmlLoader.getController();
        controller.setItem(item);

        Stage stage = new Stage();
        stage.setTitle("Edit Item Page");
        stage.setResizable(false);
        stage.setScene(new Scene(root1));
        stage.showAndWait();
        itemListView.refresh();
        displayItem.setText(item.getItemDescription());
    }

    // saving an entire list function
    @FXML
    public void saveList() {
        List<Item> items = new ArrayList<>(itemListView.getItems());
        if(saveItemList(items)){
            showSuccessAlert("Successful", "All items are successfully saved.");
        }

    }


    // displayAll page opener function
    @FXML
    public void displayAll() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayItems.fxml"));
        Parent root1 = fxmlLoader.load();

        DisplayController controller = fxmlLoader.getController();
        controller.loadItems(itemListView.getItems());

        Stage stage = new Stage();
        stage.setTitle("Display All Window");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void displayCompleted(ActionEvent actionEvent) throws IOException {
        // this method opens new window to display complete list
        // Create a List of items

        List<Item> complete_items = completeAndIncompleteArrayMaker(true, itemListView);


        // completed items list is now available
        // open the DisplayItems Page
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayItems.fxml"));
        Parent root1 = fxmlLoader.load();

        DisplayController controller = fxmlLoader.getController();
        controller.loadItems(complete_items);

        Stage stage = new Stage();
        stage.setTitle("Display Complete Window");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void displayIncomplete() throws IOException {
        // this method is to open new window for display  incomplete list
        // create a new List of Items
        List<Item> incomplete_items = completeAndIncompleteArrayMaker(false, itemListView);


        // inComplete list is completed
        // open the display window to show the incomplete list

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayItems.fxml"));
        Parent root1 = fxmlLoader.load();

        DisplayController controller = fxmlLoader.getController();
        controller.loadItems(incomplete_items);

        Stage stage = new Stage();
        stage.setTitle("Display Incomplete Window");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

    public List<Item> completeAndIncompleteArrayMaker (boolean x, ListView<Item> items) {
        List<Item> listOfItems = new ArrayList<>();


        if (x) {
            // loop through the item list , whenever item is done is true add it to the complete list

            for (Item item : items.getItems()) {
                if (item.getItemDone()) {
                    listOfItems.add(item);
                }

            }
                return listOfItems;


        }
        // loop through the list and see when getitemdone is ->false
        // when false, add it to the incomplete list

        else {
            for (Item item : items.getItems()) {
                if (!item.getItemDone()) {
                    listOfItems.add(item);
                }
            }
        }

        return listOfItems;

    }

    @FXML

    // load items from the saved list

    public List<Item> loadItems(){
        try{
            FileInputStream fileInput = new FileInputStream("Database/items");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);

            // Read objects
            List<Item> items = (List<Item>) objectInput.readObject();
            objectInput.close();
            fileInput.close();

            return items;
        }catch (Exception e){
            return null;
        }
    }

    @FXML

    // Help window opener function

    private void showHelp() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("help.fxml"));
        Parent root1 = fxmlLoader.load();

        Stage stage = new Stage();
        stage.setTitle("Help");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }
    @FXML

    // error message method
    private void showErrorAlert(String title, String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(text);
        alert.showAndWait();
    }
    @FXML

    // successful message alert
    private void showSuccessAlert(String title, String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(text);
        alert.showAndWait();
    }

    @FXML

    //comparator for sorting the items based on their dates
    public void sortItems(){
        itemListView.getItems().sort((item1,item2)->{
            if(item1.equals(item2)) return 0;
            if(item1.getDueDate().compareTo(item2.getDueDate()) > 0)
                return 1;
            else
                return 0;
        });
    }

    @FXML

    // saving item list

    public boolean saveItemList(List<Item> item_list){
        try{
            File dataBasefolder = new File("Database/");
            if(!dataBasefolder.exists()){
                dataBasefolder.mkdir();
            }
            FileOutputStream fileOutput1 = new FileOutputStream("Database/items");
            ObjectOutputStream objectInput1 = new ObjectOutputStream(fileOutput1);
            // Write item objects to the out file
            objectInput1.writeObject(item_list);
            objectInput1.close();
            fileOutput1.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



}

