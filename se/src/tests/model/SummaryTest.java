package tests.model;

import main.integration.Item;

import main.model.Summary;
import main.util.Amount;
import main.integration.ItemDTO;
import org.junit.jupiter.api.Disabled;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SummaryTest {
    Summary summary;

    @Before
    public void setUp() throws Exception {
        summary = new Summary();
    }

    @After
    public void tearDown() throws Exception {
        summary = null;
    }

    @Test
    public void testGetSummary() {
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        ItemDTO itemInformation = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        Amount itemQuantity = new Amount(1);
        Item item = new Item(itemInformation, itemQuantity, itemID);
        summary.summarizeSale(item);
        Amount expResult = itemPrice.add(taxRate);
        Amount result = summary.getSummary();
        assertEquals("The sums doesn't match", expResult, result);
    }

    @Disabled
    public void testSummarizeSale() {
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        ItemDTO itemInformation = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        Amount itemQuantity = new Amount(1);
        Item item = new Item(itemInformation, itemQuantity, itemID);
        summary.summarizeSale(item);

        Amount expectedSummary = itemPrice.multiply(itemQuantity);
        Amount expectedTax = taxRate.multiply(itemQuantity);
        Amount resultSummary = summary.getSummary();
        Amount resultTax = summary.getTotalTax();
        assertEquals("Total amount not equal to identical amount.", expectedSummary, resultSummary);
        assertEquals("Tax amount not equal to identical amount.", expectedTax, resultTax);


    }
        
}
