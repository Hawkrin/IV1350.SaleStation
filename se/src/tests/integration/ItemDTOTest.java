package tests.integration;

import main.util.Amount;
import main.integration.ItemDTO;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class ItemDTOTest {

    @Test
    void testToString() {
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        ItemDTO itemDTO = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        String expResult = "\nItem Name: " + itemName + "\nItem Price: " + itemPrice + "\nItem taxRate: " + taxRate + "\nItem ID: " + itemID;
        String result = itemDTO.toString();
        assertEquals("ItemDTO string doesnt match the other String", expResult, result);
    }

    @Test
    void testToStringWithNullParameters() {
        String itemName = null;
        Amount itemPrice = null;
        Amount taxRate = null;
        int itemID = 0;
        ItemDTO itemDTO = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        String expResult = "\nItem Name: " + itemName + "\nItem Price: " + itemPrice + "\nItem taxRate: " + taxRate + "\nItem ID: " + itemID;
        String result = itemDTO.toString();
        assertEquals("ItemDTO string doesnt match the other String", expResult, result);
    }

    @Test
    void testToStringEmptyStringParameter() {
        String itemName = "";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        ItemDTO itemDTO = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        String expResult = "\nItem Name: " + itemName + "\nItem Price: " + itemPrice + "\nItem taxRate: " + taxRate + "\nItem ID: " + itemID;
        String result = itemDTO.toString();
        assertEquals("ItemDTO string doesnt match the other String", expResult, result);
    }
    
}
