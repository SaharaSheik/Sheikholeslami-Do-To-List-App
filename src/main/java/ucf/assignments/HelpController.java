
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sahar Sheikholeslami
 */


package ucf.assignments;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class HelpController implements Initializable {

    @FXML
    TextArea helpView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadHelp();
    }

    private void loadHelp(){
        String help = "1. This Application will automatically load all the previously saved items from the external storage during startup.\n\n" +
                "2. user can add an item to the list by filling out an item description and choosing an item due date and pressing the \"+\" button on the screen.\n\n" +
                "3. User can modify an item as \"complete\" or \"incomplete\" by selecting the item first and then clicking on the checkMark button\n\n "+
                "4. User can remove an item from the list by selecting the item first and then clicking on the  \"-\" button\n\n" +
                "5. User can edit an item's description or due date by by selecting the item first and then clicking on \"edit\" button annotated by the \"pen\" symbol.\n\n" +
                "6. User can save all items by clicking the heart button at the bottom of the screen.\n\n" +
                "7. User can delete all items by clicking on the trashcan button at the bottom of the screen.\n\n" +
                "8. User can sort all the items in the list by due date by clicking the sort button at the bottom of the screen.\n\n"+
                "9. User can display all items, completed items and incomplete items respectively by clicking on the appropriate pink buttons on the screen.\n\n"+
                "10. Error screens will be displayed if:\n"+
                "\tan item is missing due date\n" +
                "\tan item is missing description\n" +
                "\tan item's description exceeds 256 character limit\n" +
                "\tmore than 100 items have been added to the list\n\n" +
                "This page is dedicated to 'Ray' for his awesome idea! :) \n\n";
        helpView.setText(help);
    }
}
