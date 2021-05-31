package tests.integration;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import main.integration.InvalidIDException;
import main.integration.catalogs.CatalogException;
import main.integration.catalogs.ItemCatalog;
import main.util.Amount;
import static org.junit.Assert.*;

public class ItemCatalogTest {
    private int testItemIDTrue = 11111;
    private int testItemIDFalse = 22222;
    private int testItemIDZero = 0;
    private static final int DATABASE_UNREACHABLE = 1337;

    @Test
    public void testItemInStock(){
        ItemCatalog itemCatalog = new ItemCatalog();
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
        ItemCatalog itemCatalogA = new ItemCatalog();
        Amount quantity = new Amount(2);
        assertThrows(InvalidIDException.class, () ->  itemCatalogA.getItem(testItemIDFalse, quantity));   
    }

    @Test
    public void testGetItemCatalogException() throws CatalogException {
        ItemCatalog itemCatalogB = new ItemCatalog();
        Amount quantity = new Amount(2);
        assertThrows(CatalogException.class, () ->  itemCatalogB.getItem(DATABASE_UNREACHABLE, quantity));   
    }

   
    
   

}
