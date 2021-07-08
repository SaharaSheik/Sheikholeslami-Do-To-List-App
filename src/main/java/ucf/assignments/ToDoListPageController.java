/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sahar Sheikholeslami
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ToDoListPageController {

    public void modifyListName(ActionEvent actionEvent) {

        //this method will receive the new list desc from modifyListName filed in toDoListPage GUI
        // and sets the new desc for the List using setters in the To Do class
        // String newDesc = current value in modifyListName field in in toDoListPag GUI
        // if newDesc != ""
        // ToDoDescription textfield == newDesc
    }


    @FXML

    public void addItemName(ActionEvent actionEvent) {

        // this method will create a new item object
        //String itemDesc = current value in additemName field
        //if  itemDesc != ""
        // instantiate a item Object   -> Item item = new Item
        // Use setter in Item class to set the description
        // Item.setItemDescription(String newDesc);

    }
    @FXML

    public void addItemDueDate(ActionEvent actionEvent) {

        // this method will create a new due date for an already existing item object
        // Date newDueDate = current value in addItemDueDate date field
        // if newDueDate != ""
        // Item.DueDate == new DueDate
    }
    @FXML

    public void displayItem (ActionEvent actionEvent) {

        //const ItemInput == queryselector from our item input
        // const ItemAddButton == queryselector from the add button on ToDoList Controller
        // const ItemList == append each item we create to next one for viewing -> queryselector item List
        // create a div class Item-containter
        // use ul class pass array of Itemlist on to it
        // the container will have some li so that each itemlist will have the button
        // to open to the new page
    }
    @FXML

    public void deletItem(ActionEvent actionEvent) {

        //this method will delete an item from a To Do list
        // create a trash button that changes the boolean value of each item to True
        //create a const element -> document.createElement('trash')
        // then we'll append the button action to the Item -> ItemDiv.AppendChild
        //deletItemFromToDo (Item)
    }

    public void deletItemFromToDo (Item item){

        // check the array of items in the Item List
        //console.log(Item List)
        //we will get the index of Item
        // Splice the Item Array by 1 -> Splice , ToDoList, 1
        // Update Json file -> localStrorage.setItem("ToDo -> List of items", Jason.Stringfy(ToDo)

    }
    @FXML

    public void markItemAsDone(ActionEvent actionEvent) {

        // create a check mark button that changes the boolean value of each item to True
        //create a const element -> document.createElement('checked')
        // then we'll append the button action to the Item -> ItemDiv.AppendChild

    }


    @FXML

    public void deleteEntireToDoList(ActionEvent actionEvent) {

        // check the array of items in the ToDo Array
        //console.log(ToDO)
        //we will get the indext of To Do
        // Splice the ToDoA Array by 1 -> Splice , ToDoList, 1
        // Update Json file -> localStrorage.setItem("todos", Jason.Stringfy(ToDo)


    }

    @FXML

    public void addItemtoList(ActionEvent actionEvent) {

        // this method uses the addItemName and addItemDueDate functions to create a new item object and
        // add it to list item Array
        //
    }
    @FXML

    public void saveList(ActionEvent actionEvent) {

        // this method will save the to do list
        //String toDoDesc = current value in getNameOfToDoList field
        //if toDoDesc != ""
        // instantiate a To Do Object   -> To Do list = new To Do
        // Use setter in To Do class to set the
        // list.setToDoDescription(newDesc)
        // <input type ="text" class="ToDo>
       // SaveLocalStirage(todo)


    }

    public void SaveLocalStirage(ToDo todo){

        // check if we have anything in the saved list or not
        //if we have the list in local storage create an empty ToDO list
        // if (localStorage.getItem(ToDO) == NULL -> create a ToDo List
        // else get the ToDos from JSON.Parse.LocalStorage.getitem(ToDo)
        // after wards ToDo.push(todo)
        //afterwards push it back to the Json Storage -> localStorage.setItem(TODO, Json.Stringfy(TODO)
    }

    @FXML

    public void displayOptions(ActionEvent actionEvent) {
        ///this function will let user pick among 4 options
        // completed
        // incomepleted
        // sorted


    }
    @FXML
    public void openEditItemPage(ActionEvent actionEvent) throws IOException {

        // this method is to open new window for editItemPage

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditItemPage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("EditItemPage");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void displayAll(ActionEvent actionEvent) throws IOException {
//        // this method is to open new window for DisplayAll page
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayAll.fxml"));

        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("displayAll");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void displayCompleted(ActionEvent actionEvent) throws IOException {
        // this method is to open new window for diplaycompleteditem page


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayCompleted.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("displayCompleted");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void displayIncomplete(ActionEvent actionEvent) throws IOException {
        // this method is to open new window for siplay incomplete list

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayIncompletedList.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("displayIncompletedList");
        stage.setScene(new Scene(root1));
        stage.show();


    }
}
