package tests.integration;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import main.integration.InvalidIDException;
import main.integration.ItemDTO;
import main.integration.catalogs.CatalogException;
import main.integration.catalogs.ItemCatalog;
import main.util.Amount;
import static org.junit.Assert.*;

public class ItemCatalogTest {
    private int testItemIDTrue = 11111;
    private int testItemIDFalse = 22222;
    private int testItemIDZero = 0;
    ItemDTO validItem;
    ItemDTO invalidItem;
    ItemCatalog itemCatalog;

    @Test
    public void testItemInStock(){
        invalidItem = new ItemDTO("Godis", new Amount(100), new Amount(0.9), 123123123);
        validItem = new ItemDTO("Hammer", new Amount(300), new Amount(0.25), 11111);
        itemCatalog = new ItemCatalog();
        boolean expResult = true;
        boolean result = itemCatalog.itemInStock(testItemIDTrue);
        assertEquals("The expected item does not  exist in the catalog.", expResult, result);
    }

    @Test
    public void testItemNotInStock() {
        ItemCatalog itemCatalog = new ItemCatalog();
        boolean expResult = false;
        boolean result = itemCatalog.itemInStock(testItemIDFalse);
        assertEquals("The expected item does not  exist in the catalog", expResult, result);
    }

    @Test
    public void testItemWithIDZero() {
        ItemCatalog itemCatalog = new ItemCatalog();
        boolean expResult = false;
        boolean result = itemCatalog.itemInStock(testItemIDZero);
        assertEquals("The expected item does not  exist in the catalog", expResult, result);
    }

    @Test
    public void testGetItemInvalidIDException() {
        ItemCatalog customerCatalogA = new ItemCatalog();
        int itemID = 111111111;
        Amount quantity = new Amount(2);
        assertThrows(InvalidIDException.class, () ->  customerCatalogA.getItem(itemID, quantity));   
    }

    @Test
    public void testGetItemCatalogException() {
        ItemCatalog customerCatalogA = new ItemCatalog();
        boolean oldItemID = false;
        int itemID = 11111;
        Amount quantity = new Amount(2);
        assertThrows(CatalogException.class, () ->  customerCatalogA.getItem(itemID, quantity));   
    }

   
    
   

}
