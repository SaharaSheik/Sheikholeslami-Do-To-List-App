package ucf.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.LocalDate;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class EditItemPageControllerTest {

    protected static Item item = new Item();
    protected static String dueDate = "2021-07-09";
    EditItemPageController editItemPageController = new EditItemPageController();





    @Test
    void dateFormatter() throws ParseException {

        // I expect the dateFormatter to return a localDate type formatted in YYYY-MM-DD

        item.setDueDate(dueDate);
        LocalDate localDate = new EditItemPageController().dateFormatter(item);
       // convert localDate to String
        String dateToString = localDate.toString();

        assertEquals(dateToString, dueDate);

    }

    @Test
    void setItem() {
    }

    @Test
    void saveItem() {
    }

    @Test
    void dueDateGetter (){

        // I expect the value of localDate now converted into String will be equal to the value returned from
        // dueDateGetter function

        LocalDate localDate = LocalDate.now();

        String due_date = new EditItemPageController().dueDateGetter(localDate);

        Assertions.assertTrue(due_date.equals(localDate.toString()));

    }

    @Test
    void descriptionChecker() {

        // I expect descriptionChecker method to :
        // a) return false if the String passed to it is empty
        // b) return false if the String length passed to it is exceeds 256 chars
        // c) return true if the the String passed to it is not empty and less than 256 chars


        String emptyString = "";
        String longString = "javaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        String acceptableString = "Acceptable item description shall not exceed 256 chars";

      boolean result = editItemPageController.descriptionChecker(emptyString);
      Assertions.assertTrue(result);


    }

    }
