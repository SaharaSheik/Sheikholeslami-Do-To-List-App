package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sahar Sheikholeslami
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class EditItemPageController {

    @FXML
    public void changeItemDueDate(ActionEvent actionEvent) {

        //this method will receive the new due date from EditItemPage GUI and sets the new date for the item
        // Date newDueDate = current value in changeItemDueDate date field
        // if newDueDate != Item.dueDate
        // Item.DueDate == new DueDate
    }


    @FXML
    public void getItemDescription(ActionEvent actionEvent) {

        //this method displays the old item description on top of the EditItemPage GUI
        //String newDesc = current value in getNameOfToDoList field
        //if toDoDesc != ""
           // Use setter in To Do class to set the
        // Item.setItemDescription(newDesc)
        // <input type ="text" class="Item>



    }
    @FXML
    public void editItemDescription(ActionEvent actionEvent) {

        //this method will receive the new item desc from editItemDescription filed in EditItemPage GUI
        // and sets the new desc for the item
        // String newDesc = current value in itemDescription field in in EditItemPage GUI
        // if newDesc != ""
        // Item.itemDescription == newDesc
    }
}
