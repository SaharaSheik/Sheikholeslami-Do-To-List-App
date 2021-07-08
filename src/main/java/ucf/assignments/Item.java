/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sahar Sheikholeslami
 */

package ucf.assignments;


import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

public class Item implements Serializable {

    // each item object will have 3 filed, an item desc, due date, boolean Itemdone
    // boolean itemDone will always automatically be set to false
    // when the users click on markItemAsDone button in ToDoListPage this value will change to true

    String itemDescription;
    String dueDate;
    Boolean itemDone = false;

    public Item(){

    }
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {

        // use keyword this. to set the item Description from text field additemName GUI
        //this.itemDescription == itemDescription ToDoListPage
        this.itemDescription = itemDescription;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        // use keyword this. to set the due date from date filed addItemDueDate GUI
        // this.dueDate == dueDate in ToDoListPage
        this.dueDate = dueDate;
    }

    public void setItemDone(Boolean itemDone) {
        // use keyword this. to set the itemDone from markItemAsDone button in  ToDoListPage GUI
        //this.itemDone == itemDone ToDoListPage
        this.itemDone = itemDone;
    }

    public Boolean getItemDone() {
        return itemDone;
    }

    @Override
    public String toString() {

        // if get itemDone is set to True -> item is complete
        // if get itemDone is set to false -> items is incomplete

        if(getItemDone()){
            return itemDescription + "\n" + dueDate + "\n" + "Complete";
        }else{
            return itemDescription + "\n" + dueDate + "\n" + "Incomplete";
        }
    }
}
