package tests.integration;

import src.util.Amount;
import src.integration.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
public class ItemDTOTest {

    @Test
    void testToString() {
        String itemName = "Hammer";
        Amount price = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        src.integration.ItemDTO itemDTO = new src.integration.ItemDTO(itemName, price, taxRate, itemID);
        String expectedResult = "ItemName: " + itemName + "\nPrice of item: " + price + "\nTaxrate of item: " + taxRate + "\nItemID: " + itemID;
        String result = itemDTO.toString();
        assertEquals("ItemDTO string doesnt match the other String", expectedResult, result);
    }

    @Test
    void testToStringWithNullParameters() {
        String itemName = null;
        Amount price = null;
        Amount taxRate = null;
        int itemID = 0;
        src.integration.ItemDTO itemDTO = new src.integration.ItemDTO(itemName, price, taxRate, itemID);
        String expectedResult = "ItemName: " + itemName + "\nPrice of item: " + price + "\nTaxrate of item: " + taxRate + "\nItemID: " + itemID;
        String result = itemDTO.toString();
        assertEquals("ItemDTO string doesnt match the other String", expectedResult, result);
    }

    @Test
    void testToStringEmptyStringParameter() {
        String itemName = "";
        Amount price = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        src.integration.ItemDTO itemDTO = new src.integration.ItemDTO(itemName, price, taxRate, itemID);
        String expectedResult = "ItemName: " + itemName + "\nPrice of item: " + price + "\nTaxrate of item: " + taxRate + "\nItemID: " + itemID;
        String result = itemDTO.toString();
        assertEquals("ItemDTO string doesnt match the other String", expectedResult, result);
    }
    
}
