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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ToDoListController {
    public void getNameOfToDoList(ActionEvent actionEvent) {



        //this method will receive the new toDoListName desc from text filed in ToDoList GUI
         //and sets the new desc for the ToDol
        // String newDesc = current value in itemDescription field in in toDolist GUI
         //if newDesc != ""
         // To Do Desc == new Desc

    }


    @FXML
    public void toDoListNewPage(ActionEvent actionEvent) throws IOException {

        // this method opens a new page to modify, save, load,... and do different operations on each
        //individual to do list

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ToDoListPage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("ToDoListPage");
            stage.setScene(new Scene(root1));
            stage.show();

        }

    @FXML

    public void addNewToDoList(ActionEvent actionEvent) {

        // this method will create a new To Do Object
         //String toDoDesc = current value in getNameOfToDoList field
         //if toDoDesc != ""
        // instantiate a To Do Object   -> To Do list = new To Do
        // Use setter in To Do class to set the
        // list.setToDoDescription(newDesc)
        // <input type ="text" class="ToDo>


    }

    public ToDo AddToDo (){

        ToDo newToDo =new ToDo();
        // this function will append each added to do so a list of to dos can be displayed
        //create a to do DIV  const ToDODiv -> create an element "div"
        // add  each to do to the class -> ToDoDiv.classList.add("ToDo")
        // To Do Div . append a child (new To Do)
      return newToDo;
    }


    @FXML

    public void saveAllLists(ActionEvent actionEvent) {

        // check if we have anything in the saved list or not
        //if we have the list in local storage create an empty ToDO list
        // if (localStorage.getItem(ToDO) == NULL -> create a ToDo List
        // else get the ToDos from JSON.Parse.LocalStorage.getitem(ToDo)
        // after wards ToDo.push(todo)
        //afterwards push it back to the Json Storage -> localStorage.setItem(TODO, Json.Stringfy(TODO)
    }



    public void viewList(ActionEvent actionEvent) {
        //const ToDoInput == queryselector from our To Do input
        // const todoAddButton == queryselector from the add button on ToDoList Controller
        // const todoList == append each to do we create to next one for viewing -> queryselector ToDoList
        // create a div class ToDo-containter
        // use ul class pass array of ToDolist on to it
        // the container will have some li so that each to do list will have the button
        // to open to the new page


    }
}
