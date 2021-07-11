/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sahar Sheikholeslami
 */

package ucf.assignments;

import javafx.scene.control.ListView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
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
    void completeAndIncompleteArrayMaker() {
        //create a list of item of 10 items

        List<Item> testItems = new ArrayList<Item>();
        for (int i = 0; i < 10; i++) {

            Item item = new Item();
        // for the even index, set itemDone to true
            if (i % 2 == 0)
                item.setItemDone(true);
            // for off index set itemDine to false
            else
                item.setItemDone(false);

            testItems.add(item);
        }

        // pass the Test Items Array to completeAndIncompleteArrayMaker and make complete and incomplete Item Lists

        List <Item> completed = toDoListPageController.completeAndIncompleteArrayMaker(true, testItems);
        List<Item> notCompleted = toDoListPageController.completeAndIncompleteArrayMaker(false, testItems);

        System.out.println(notCompleted.get(0).getItemDone());

        // check if all items returned by completeAndIncompleteArrayMaker in the complete list have itemDone -> true

        for (int i = 0; i <completed.size(); i++)
            Assertions.assertTrue(completed.get(i).getItemDone());

        // check if all items returned by completeAndIncompleteArrayMaker in the Incomplete list have itemDone -> false

        for (int i = 0; i <notCompleted.size(); i++)
        Assertions.assertFalse(notCompleted.get(i).getItemDone());

    }

}