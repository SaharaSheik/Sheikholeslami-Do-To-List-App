package ucf.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    protected static Item item = new Item();



    @Test
    void setItemDescription() {

        // setting an item description based on a test value
        // I expect my test value will be the same as item description
        // I get the item description via item's get description method
        // compare if test string and item description are equal

        String test = "test item";
        item.setItemDescription(test);
        String itemDescription = item.getItemDescription();
        Assertions.assertTrue(test.equals(itemDescription));

    }
    @Test
    void getItemDescription() {
        // getting an item description based on a test value
        // I expect my test value will be the same as item description
        // I first set the item description based on the test value and then get the item description via item's get description method
        // compare if test string and item description are equal

        String test = "test item";
        item.setItemDescription(test);
        String itemDescription = item.getItemDescription();
        Assertions.assertTrue(test.equals(itemDescription));

    }

    @Test
    void setDueDate() {
         // setting an item due date based on a testDueDate value
        // I expect my testDueDate value will be the same as item dueDate
        // I first set the item due date via setDueDate, then
        // get the item due date via item's getDueDate method
        // compare if testDueDate string and item dueDate string are equal

        String testDueDate = "2021-07-11";
        item.setDueDate(testDueDate);
        String itemDueDate = item.getDueDate();
        Assertions.assertTrue(testDueDate.equals(itemDueDate));
    }

    @Test
    void getDueDate() {

        // getting an item due date based on a testDueDate value
        // I expect my testDueDate value will be the same as item dueDate
        // I first set the item due date via setDueDate, then
        // get the item due date via item's getDueDate method
        // compare if testDueDate string and item dueDate string are equal

        String testDueDate = "2021-07-11";
        item.setDueDate(testDueDate);
        String itemDueDate = item.getDueDate();
        Assertions.assertTrue(testDueDate.equals(itemDueDate));
    }



    @Test
    void setItemDone() {
        // I expect the item done value to be true when boolean true has been passed to setItemDone
        item.setItemDone(true);
        assertTrue(item.itemDone);

        // I expect the itemDone value to be false when boolean false has been passed to setItemDone

        item.setItemDone(false);
        assertFalse(item.itemDone);
    }

    @Test
    void getItemDone() {

        // I expect the getItemDone value to be true when boolean true has been passed to setItemDone

        item.setItemDone(true);
        boolean result1 = item.getItemDone();
        assertTrue(result1);

        // I expect the getItemDone value to be false  when boolean false has been passed to setItemDone
        item.setItemDone(false);
        boolean result2 = item.getItemDone();
        assertFalse(result2);


    }

    @Test
    void testToString() {

        //I expect  the Override ToString to return:
        //a) if itemDone -> true ToString will return: itemDescription + "\n" + dueDate + "\n" + "Complete"
        //b) if itemDone -> false  ToString will return: itemDescription + "\n" + dueDate + "\n" + "Incomplete"

        String itemDescription = "test item";
        String dueDate = "2021-07-11";
        item.setItemDescription(itemDescription);
        item.setDueDate(dueDate);
        item.setItemDone(true);

        String test1 = itemDescription + "\n" + dueDate + "\n" + "Complete";
        // case a) item complete
        Assertions.assertTrue(test1.equals(item.toString()));

        // case b) item incomplete
        item.setItemDone(false);
        String test2 = itemDescription + "\n" + dueDate + "\n" + "Incomplete";
        Assertions.assertTrue(test2.equals(item.toString()));


    }
}