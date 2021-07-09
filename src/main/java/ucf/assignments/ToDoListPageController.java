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
    public void initialize(URL url, ResourceBundle rb) {
        // create a list of Item objects
        List<Item> items = loadItems();
        if(items != null){
            itemListView.getItems().addAll(items);
        }
    }

    @FXML
    // addItem method
    public void addItem(){
        String description = itemName.getText().trim();  // in case of extra spaces, trim the text so its fits

        // handling the case if the user does not enter a description give them an error
        if(description.isEmpty()){
            showErrorAlert("Error", "Please enter a valid item name.");
            return;
        }
        //handle the length requirement.
        // check if length is  more than 256 chars display an error
        if(description.length() > 256){
            showErrorAlert("Error", "Max description length is 256.");
            return;
        }
        // formatting date YYYY-MM-DD
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        LocalDate localDate = itemDueDate.getValue();
        // handle the case if the user does not enter a date
        if(localDate == null){
            showErrorAlert("Error", "Please select a valid due date.");
            return;
        }
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        String due_date = formatDate.format(date);

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

        //ready to enter new item
        itemName.setText("");
    }
    @FXML
    // choosing an item method

    public void chooseItem(){
        Item selected_item = itemListView.getSelectionModel().getSelectedItem();
        if(selected_item == null) return;
        displayItem.setText(selected_item.getItemDescription());  // show the selected item in the display window
    }
    @FXML

    // deleting an entire list and starting a new list

    public void deleteList(){
        itemListView.getItems().clear();
        itemListView.refresh();
        List<Item> items = new ArrayList<>();
        saveItemList(items);
    }

    // checkmark function for itemDone
    @FXML
    public void checkItemDone(){
        int index = itemListView.getSelectionModel().getSelectedIndex();
        if(index < 0) return;
        if(itemListView.getItems().get(index).getItemDone()){
            itemListView.getItems().get(index).setItemDone(false);
        }else {
            itemListView.getItems().get(index).setItemDone(true);
        }
        itemListView.refresh();
    }

    // delete one item function
    @FXML
    public void deleteItem(){
        int index = itemListView.getSelectionModel().getSelectedIndex();
        if(index < 0) return;
        itemListView.getItems().remove(index);
    }

    // edit item window opening function
    @FXML
    public void editItem() throws Exception{
        Item item = itemListView.getSelectionModel().getSelectedItem();
        if(item == null) return;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditItemPage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

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
        saveItemList(items);
    }


    // displayAll page opener function
    @FXML
    public void displayAll() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayItems.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

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
        // this method is to open new window to display incomplete list
        // Creat a List of items
        List<Item> complete_items = new ArrayList<>();

        // loop through the item list view, whenever item is done is true add it to the complete list
        for(Item item : itemListView.getItems()){
            if(item.getItemDone()){
                complete_items.add(item);
            }
        }

        // completed items list is now available
        // open the DisplayItems Page
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayItems.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

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
        List<Item> incomplete_items = new ArrayList<>();

        // loop through the list and see when getitemdone is ->false
        // when false, add it to the incomplete list
        for(Item item : itemListView.getItems()){
            if(!item.getItemDone()){
                incomplete_items.add(item);
            }
        }

        // incomeplete list is completed
        // open the display window to show the incomplete list

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayItems.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        DisplayController controller = fxmlLoader.getController();
        controller.loadItems(incomplete_items);

        Stage stage = new Stage();
        stage.setTitle("Display Incomplete Window");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }
    @FXML

    // Help window opener function

    private void showHelp() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("help.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

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

    //comparator for dates
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

    public void saveItemList(List<Item> item_list){
        try{
            File dataBasefolder = new File("Database/");
            if(!dataBasefolder.exists()){
                dataBasefolder.mkdir();
            }
            FileOutputStream fileOutput1 = new FileOutputStream("Database/items");
            ObjectOutputStream objectInput1 = new ObjectOutputStream(fileOutput1);
            // Write item objects to the o file
            objectInput1.writeObject(item_list);
            objectInput1.close();
            fileOutput1.close();
            showSuccessAlert("Successful", "Items are successfully saved.");
        }catch (Exception e){
            e.printStackTrace();
            showErrorAlert("Error", "Fail to save items.");
        }
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


}

