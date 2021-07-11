/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sahar Sheikholeslami
 */

package ucf.assignments;

import javafx.scene.control.ListView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListPageControllerTest {

    protected static Item item = new Item();
    protected static String dueDate = "2021-07-09";
   // protected static ListView<Item> itemListView = new ListView<>();



    ToDoListPageController toDoListPageController = new ToDoListPageController();

    String emptyString = "";
    String longString = "javaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    String acceptableString = "Acceptable item description shall not exceed 256 chars";



    @Test
    void addItem() {
    }

    @Test
    void descriptionChecker() {



        // I expect descriptionChecker method to :
        // a) return 0 if the String passed to it is empty
        // b) return -1 if the String length passed to it is exceeds 256 chars
        // c) return 1 if the the String passed to it is not empty and less than 256 chars

        //test a


        int resultA = toDoListPageController.descriptionChecker(emptyString);

        int resultB = toDoListPageController.descriptionChecker(longString);

        int resultC = toDoListPageController.descriptionChecker(acceptableString);

        //test a)
        Assertions.assertEquals(0, resultA);
        Assertions.assertEquals(-1, resultB);
        Assertions.assertEquals(1, resultC);
    }

    @Test
    void dueDateGetter() {
        // I expect the value of localDate now converted into String will be equal to the value returned from
        // dueDateGetter function

        LocalDate localDate = LocalDate.now();

        String due_date = new EditItemPageController().dueDateGetter(localDate);

        Assertions.assertTrue(due_date.equals(localDate.toString()));
    }

    @Test
    void chooseItem() {
    }

    @Test
    void deleteList() {
    }

    @Test
    void checkItemDone() {
    }

    @Test
    void deleteItem() {
    }

    @Test
    void editItem() {
    }

    @Test
    void saveList() {
    }

    @Test
    void displayAll() {
    }

    @Test
    void displayCompleted() {
    }

    @Test
    void displayIncomplete() {
    }

    @Test
    void loadItems() {
    }

    @Test
    void sortItems() {
    }

    @Test
    void saveItemList() {
    }


    @Test
    void completeAndIncompleteArrayMaker() {
        Item item1 = new Item();
        item1.setItemDone(true);

        Item item2 = new Item();
        item2.setItemDone(false);

       // ListView<Item> itemListView = new ListView<>();

       // itemListView.getItems().add(item1);
       // itemListView.getItems().add(item2);

        //System.out.println(itemListView.getItems().get(0).getItemDone());

        // I expect the indext 0, 2,4,6 -> have item checked as done
        // I expcpect index 1,3,5 -> have items checked as notdone
        //List<Item> complete_items = toDoListPageController.completeAndIncompleteArrayMaker(true, itemListView);
        //List<Item> incomplete_items = toDoListPageController.completeAndIncompleteArrayMaker(false, itemListView);

        // Assertions.assertTrue(complete_items.get(0).getItemDone());
    }

}