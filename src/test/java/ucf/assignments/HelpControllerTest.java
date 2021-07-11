package ucf.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelpControllerTest {


    @Test
    void helpPageContent() {

        String expectedText= "1. This Application will automatically load all the previously saved items from the external storage during startup.\n\n" +
                "2. user can add an item to the list by filling out an item description and choosing an item due date and pressing the \"+\" button on the screen.\n\n" +
                "3. User can modify an item as \"complete\" or \"incomplete\" by selecting the item first and then clicking on the checkMark button\n\n "+
                "4. User can remove an item from the list by selecting the item first and then clicking on the  \"-\" button\n\n" +
                "5. User can edit an item's description or due date by by selecting the item first and then clicking on \"edit\" button annotated by the \"pen\" symbol.\n\n" +
                "6. User can save all items by clicking the heart button at the bottom of the screen.\n\n" +
                "7. User can delete all items by clicking on the trashcan button at the bottom of the screen.\n\n" +
                "8. User can sort all the items in the list by due date by clicking the sort button at the bottom of the screen.\n\n"+
                "9. User can display all items, completed items and incomplete items respectively by clicking on the appropriate pink buttons on the screen.\n\n"+
                "10. User shall save all the items by pressing the \"heart\" button before closing the app so their final ietms can be save for future loading\n\n"+
                "11. Error screens will be displayed if:\n"+
                "\tan item is missing due date\n" +
                "\tan item is missing description\n" +
                "\tan item's description exceeds 256 character limit\n" +
                "\tmore than 100 items have been added to the list\n\n" +
                "This page is dedicated to 'Ray' for his awesome idea! :) \n\n";


        HelpController helpController = new HelpController();
        String actualText = helpController.helpPageContent();

        Assertions.assertTrue(actualText.equals(expectedText));


    }


}