package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListPageControllerTest {

    @Test
    void modifyListName() {

        // we can create tester function for this to check if the new Item Description is not equal to the old one
        //Asser.NotEqual
    }

    @Test
    void addItemName() {

        // we can check the array of Item List
        // to see if the value that was appended to the DoTo List Array has been added.
        // Assert.True if (List.Contains(new To Do)
    }

    @Test
    void addItemDueDate() {

        // we can check the nee Item Object Due Date to make sure the Due Date taken from the filed is properly set
       // Assert.True if (Item.DueDate == additemduedate Date filed)
    }

    @Test
    void displayItem() {

        // load all available items within a list
        // since there is no way of testing the loaded information, we can test to see if the value of items
        // matches what we have in our array list of Items the last indext
        // Assert.Equal if (List<Item>.last indext).equal ( current value of text field in item display)


    }

     @Test
    void deletItemFromToDo() {

         //this method will delete an item from a To Do list
         // we can check array of Items in the To Do list
         // assert.false if (List <Item>.contains.deletedItem)
    }

    @Test
    void markItemAsDone() {

        // check to see if the itemDone is the array list of Items in ToDo Listequal to true
        // assert.true if (List<Item>.item.Completed == true)
    }


    @Test
    void addItemtoList() {
///this method will add  an item from a To Do list
//         // we can check array of Items in the To Do list
//         // assert.true if (List <Item>.contains.deletedItem)
    }



}