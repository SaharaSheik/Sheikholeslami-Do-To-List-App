/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sahar Sheikholeslami
 */

package ucf.assignments;

import java.util.ArrayList;

public class ToDo {
    // each to do list will consist of a to do description and Arraylist of Items

    String toDoDescription;
    ArrayList<Item> itemList = new ArrayList<Item>();

    public String getToDoDescription() {

        // will use get Description to display results of to Do name on main page
        // will use  get Description to display results on to do list page
        return toDoDescription;
    }

    public void setToDoDescription(String toDoDescription) {

        // use keyword this. to set the To Do Description from text field getNameOfToDoList GUI
        // this.toDoDescription == toDoDescription in ToDoList
    }

    public ArrayList<Item> getItemList() {

        // will use this function to do two things:
        //a) sort the item list by due date.  Will use collection sort and a custom comprator
        //b) save and display the lists when prompted by the uses
        return itemList;
    }

    public void setItemList(Item newItem) {
        // will add Items to Array list of items
       // this.itemList == add.newItem in ToDoListPage
    }
}
