/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sahar Sheikholeslami
 */

package ucf.assignments;

import java.text.DateFormat;
import java.util.Date;

public class Item {

    // each item object will have 3 filed, an item desc, due date, boolean itemdone

    String itemDescription;
    Date dueDate = new Date();

    // boolean itemDone will always automatically be set to false
    // when the users click on markItemAsDone button in ToDoListPage this value will change to true
    Boolean itemDone = false;


    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {

        // use keyword this. to set the item Description from text field additemName GUI
         //this.itemDescription == itemDescription ToDoListPage
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {

        // use keyword this. to set the due date from date filed addItemDueDate GUI

       // this.dueDate == dueDate in ToDoListPage
    }

    public void setItemDone(Boolean itemDone) {

        // use keyword this. to set the itemDone from markItemAsDone button in  ToDoListPage GUI
        //this.itemDone == itemDone ToDoListPage
    }
}
