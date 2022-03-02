package controller;

import model.Item;
import model.Transaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static data.ItemDummy.getDummyItems;
import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {
    private final List<Item> expectedItems = getDummyItems();
    private final MainController mainController = new MainController();
    private final Item expectedItem = new Item("3", "New Smartwatch", 800, 8, 12);
    private final Date date = new Date();
    private final Transaction expectedTransaction = new Transaction("", expectedItem, date, 2);

    @Test
    @DisplayName("Get List Item")
    void getListItem() {
        assertEquals(expectedItems.size(), mainController.getListItem().size());
    }

    @Test
    @DisplayName("Get Sold Report")
    void getSoldReport() {
        String expectedReport = "id='1', name='Tumblr', sold=10\n" +
                "id='2', name='Backpack', sold=10\n" +
                "id='3', name='Smartwatch', sold=10\n" +
                "id='4', name='Body Scale', sold=10\n" +
                "id='5', name='Arm Rest', sold=10\n";
        assertEquals(expectedReport, mainController.getSoldReport());
    }

    @Test
    @DisplayName("Buy One Item")
    void buyItem() {
        assertEquals(expectedTransaction.getItem().getStock(), mainController.buyItem(date, "3", 2).getItem().getStock());
    }

    @Test
    @DisplayName("Manage Item")
    void manageItem() {
        assertEquals(expectedItem.getName(), mainController.manageItem("3", "New Smartwatch", 810).getName());
    }
}