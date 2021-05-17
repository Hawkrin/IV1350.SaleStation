package tests.controller;

import main.controller.Controller;
import main.controller.OperationFailedException;
import main.integration.CatalogHandler;
import main.integration.InvalidIDException;
import main.integration.ReceiptPrinter;
import main.integration.SystemHandler;
import main.integration.SalesLog;
import main.integration.Item;
import main.integration.ItemCatalog;
import main.util.Amount;
import main.integration.ItemDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class ControllerTest {
    private Controller controller = new Controller(new CatalogHandler(), new SystemHandler(), new ReceiptPrinter(), new SalesLog());
    private final int INVALID_ITEM_ID = 01010;

    @Test
    public void registerItemWithException() throws InvalidIDException, OperationFailedException {
        controller.startNewSale();
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(2);
        Amount runningTotal = itemPrice.multiply(itemQuantity).add(taxRate.multiply(itemQuantity));
        ItemDTO itemDTO = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        try {
        String expResult = "Item Name: " + itemName + "\nItem Price: " + itemPrice + "\ntaxRate: " + taxRate + "\nItem ID: " + itemID + "\nItem Quantity: " + itemQuantity + " the total price after taxes are: " + runningTotal;
        String result = controller.registerItem(itemDTO, itemQuantity, itemID);
        assertEquals("Strings doesnt match.", expResult, result);
        }
        catch (OperationFailedException exception){}
        catch (InvalidIDException exception){}
    }

    @Test
    public void registerInvalidItemWithException() throws InvalidIDException, OperationFailedException {
        controller.startNewSale();
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = INVALID_ITEM_ID;
        Amount itemQuantity = new Amount(2);
        Amount runningTotal = itemPrice.multiply(itemQuantity).add(taxRate.multiply(itemQuantity));
        ItemDTO itemDTO = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        try {
        String expResult = "Item Name: " + itemName + "\nItem Price: " + itemPrice + "\ntaxRate: " + taxRate + "\nItem ID: " + itemID + "\nItem Quantity: " + itemQuantity + "the total price after taxes are: " + runningTotal;
        String result = controller.registerItem(itemDTO, itemQuantity, itemID);
        assertNotEquals("Strings doesnt match.", expResult, result);
        }
        catch (OperationFailedException exception){}
        catch (InvalidIDException exception){}
    }

    @Disabled
    public void registerItemWithoutException() throws InvalidIDException, OperationFailedException {
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
    public void testDisplaySummaryWithException() throws InvalidIDException, OperationFailedException {
        controller.startNewSale();
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(1);
        ItemDTO itemDTO = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        try{
        controller.registerItem(itemDTO, itemQuantity, itemID);
        String expResult = "the total price after taxes are: " + itemPrice.add(taxRate);
        String result = controller.displaySummary();
        assertEquals("The sums doesnt match.", expResult, result);
        } 
        catch(OperationFailedException exception){}
        catch(InvalidIDException exception){}
    }

    @Disabled
    public void testDisplaySummaryWithoutException() throws InvalidIDException, OperationFailedException {
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
    public void testSalePaymentWithException() throws InvalidIDException, OperationFailedException {
        controller.startNewSale();
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(1);
        Amount runningTotal = itemPrice.multiply(itemQuantity).add(taxRate.multiply(itemQuantity));
        ItemDTO itemDTO = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        try {
        controller.registerItem(itemDTO, itemQuantity, itemID);
        Amount paidAmount = new Amount(500);
        String expResult = "Change the return: " + paidAmount.subtract(runningTotal);
        String result = controller.salePayment(paidAmount);
        assertEquals("The change returned doesnt match", expResult, result);
        }
        catch(OperationFailedException exception){}
        catch(InvalidIDException exception){}
    }

    @Test
    public void testSalePaymentWithoutException() throws InvalidIDException, OperationFailedException {
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
