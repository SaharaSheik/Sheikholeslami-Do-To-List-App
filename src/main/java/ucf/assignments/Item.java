/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sahar Sheikholeslami
 */

package ucf.assignments;



import java.io.Serializable;
import java.time.LocalDate;


@SuppressWarnings("serial")
public class Item implements Serializable
{
    private LocalDate dueDate;
    private String itemDescription;
    private boolean completed;
    private boolean notCompleted;

    public Item (String itemDescription, LocalDate dueDate, boolean notCompleted)
    {
        this.itemDescription = itemDescription;
        this.dueDate = dueDate;
        this.completed = false;
        this.notCompleted = true;
    }

    @Override
    public String toString()
    {
        String[] dateArray = null;
        if(dueDate != null)
        dateArray = dueDate.toString().split("-");

        return itemDescription + dateArray[0] + "-"+ dateArray[1] + "-" +  dateArray[2];

    }


    public LocalDate getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate)
    {
        this.dueDate = dueDate;
    }

    public String getItemDescription()
    {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }

    public boolean Completed()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public boolean notCompleted()
    {
        return completed;
    }

    public void setNotCompleted(boolean notCompleted)
    {
        this.notCompleted = notCompleted;
    }
}

/*
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
*/
