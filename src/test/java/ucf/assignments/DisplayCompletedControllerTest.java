package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayCompletedControllerTest {

    @Test
    void loadCompletedList() {

        // load all available items within a list
        // since there is no way of testing the loaded information, we can test to see if the number of
        // lines loaded will match the number of the items in the To Do list array of Items with complete Boolean value equal to True
        // by cross checking against the stored in Json local storage
        // Assert.Equal if num of (List<Item.completed> == true) == num of lines displayed lines on to the screen
    }
}