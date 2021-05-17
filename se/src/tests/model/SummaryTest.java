package tests.model;

import main.integration.Item;

import main.model.Summary;
import main.util.Amount;
import main.integration.Item;
import main.integration.ItemDTO;
import org.junit.jupiter.api.Disabled;
import static org.junit.Assert.*;

public class SummaryTest {


    @Disabled
    public void testSummarizeSale() {
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        ItemDTO itemInformation = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        Amount itemQuantity = new Amount(1);
        Item item = new Item(itemInformation, itemQuantity, itemID);
        Amount expectedSummaryResult = itemPrice.multiply(itemQuantity);
        Amount expectedTotalTaxResult = taxRate.multiply(itemQuantity);
        //Amount resultSummary = summarizeSale(item).getTotal();
        //Amount resultTotalTax = summarizeSale(item).getTotalTax();
    }
    
}
