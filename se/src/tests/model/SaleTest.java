package tests.model;

import src.model.Sale;
import src.integration.Item;
import src.integration.ItemDTO;
import src.util.Amount;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
public class SaleTest {
    
    @Test
    public void testUpdateItems(){
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        ItemDTO itemInformation = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        Amount itemQuantity = new Amount(1);
        Item item = new Item(itemInformation, itemQuantity, itemID);
        Sale sale = new Sale();
        String result = sale.updateItems(item);
        String expResult = item.getItemDTO().toString();
        assertEquals("The Strings are not equal.", expResult, result);
    }

    @Test
    public void testUpdateItemsWithNoParameters(){
        String itemName = "";
        Amount itemPrice = new Amount(0);
        Amount taxRate = new Amount(0);
        int itemID = 0;
        ItemDTO itemInformation = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        Amount itemQuantity = new Amount(1);
        Item item = new Item(itemInformation, itemQuantity, itemID);
        Sale sale = new Sale();
        String result = sale.updateItems(item);
        String expResult = item.getItemDTO().toString();
        assertEquals("The Strings are not equal.", expResult, result);
    }
}
