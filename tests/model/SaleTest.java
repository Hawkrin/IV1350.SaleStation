package tests.model;

import src.model.Sale;
import src.integration.Item;
import src.integration.ItemDTO;
import src.util.Amount;
import org.junit.Test;
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
        String expectedResult = item.getItemDTO().toString();
    }
}
