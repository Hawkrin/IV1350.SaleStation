package tests.controller;

import src.controller.Controller;
import src.controller.RegisterFailedException;
import src.integration.CatalogHandler;
import src.integration.InvalidIDException;
import src.integration.ReceiptPrinter;
import src.integration.SystemHandler;
import src.integration.SalesLog;
import src.util.Amount;
import src.integration.ItemDTO;
import src.integration.Item;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;


public class ControllerTest {
    private Controller controller = new Controller(new CatalogHandler(), new SystemHandler(), new ReceiptPrinter(), new SalesLog());

    @Test
    public void testSearchForItem() throws InvalidIDException, RegisterFailedException {
        controller.startNewSale();
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(2);
        Amount runningTotal = itemPrice.multiply(itemQuantity).add(taxRate.multiply(itemQuantity));
        ItemDTO itemDTO = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        String expResult = "Item Name: " + itemName + "\nItem Price: " + itemPrice + "\ntaxRate: " + taxRate + "\nItem ID: " + itemID + "\nItem Quantity: " + itemQuantity + "the total price after taxes are: " + runningTotal;
        String result = controller.registerItem(itemDTO, itemQuantity, itemID);
        assertEquals("Strings doesnt match.", expResult, result);
    }

    @Test
    public void testDisplaySummary() throws InvalidIDException, RegisterFailedException {
        controller.startNewSale();
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(1);
        ItemDTO itemDTO = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        controller.registerItem(itemDTO, itemQuantity, itemID);
        String expResult = "the total price after taxes are: " + itemPrice.add(taxRate);
        String result = controller.displaySummary();
        assertEquals("The sums doesnt match.", expResult, result);
    }

    @Disabled
    public void testSalePayment() throws InvalidIDException, RegisterFailedException {
        controller.startNewSale();
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(1);
        Amount runningTotal = itemPrice.multiply(itemQuantity).add(taxRate.multiply(itemQuantity));
        ItemDTO itemDTO = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        controller.registerItem(itemDTO, itemQuantity, itemID);
        Amount paidAmount = new Amount(500);
        String expResult = "Change the return: " + paidAmount.subtract(runningTotal);
        String result = controller.salePayment(paidAmount);
        assertEquals("The change returned doesnt match", expResult, result);
    }


}
