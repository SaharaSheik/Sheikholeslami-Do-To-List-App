
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Sahar Sheikholeslami
 */


package ucf.assignments;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class DisplayController {

    // this controller will display a lit of items based on the List of items that was passed on to it
    //
    @FXML
    ListView<Item> dispplayAllitems;

    public void loadItems(List<Item> items)
    {
        dispplayAllitems.getItems().addAll(items);
    }
}

