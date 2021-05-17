package tests.integration;

import main.integration.ItemCatalog;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class ItemCatalogTest {
    private int testItemIDTrue = 11111;
    private int testItemIDFalse = 22222;
    private int testItemIDZero = 0;

    @Test
    public void testItemInStock(){
        ItemCatalog itemCatalog = new ItemCatalog();
        boolean expResult = true;
        boolean result = itemCatalog.itemInStock(testItemIDTrue);
        assertEquals("The expected item does not  exist in the catalog.", expResult, result);
    }

    @Test
    public void testItemNotInStock() {
        ItemCatalog itemCatalog = new ItemCatalog();;
        boolean expResult = false;
        boolean result = itemCatalog.itemInStock(testItemIDFalse);
        assertEquals("The expected item does not  exist in the catalog", expResult, result);
    }

    @Test
    public void testItemWithIDZero() {
        ItemCatalog itemCatalog = new ItemCatalog();;
        boolean expResult = false;
        boolean result = itemCatalog.itemInStock(testItemIDZero);
        assertEquals("The expected item does not  exist in the catalog", expResult, result);
    }
    

}
