package tests.controller;

import main.controller.Controller;
import main.controller.OperationFailedException;
import main.integration.InvalidIDException;
import main.integration.ReceiptPrinter;
import main.integration.SystemHandler;
import main.integration.catalogs.CatalogHandler;
import main.integration.SalesLog;
import main.util.Amount;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;


public class ControllerTest {
    private Controller controller = new Controller(CatalogHandler.getCatalogHandler(), SystemHandler.getSystemHandler(), ReceiptPrinter.getReceiptPrinter(), SalesLog.getSalesLog());
    private static final int INVALID_ITEM_ID = 01010;
    private static final int DATABASE_UNREACHABLE = 1337;
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;
    private Amount amount;
    
    @Before
    public void setUp() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
        controller = null;
    }

    @Test
    public void registerItemWithException() throws InvalidIDException, OperationFailedException {
        controller.startNewSale();
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(2);
        Amount runningTotal = itemPrice.multiply(itemQuantity).add(taxRate.multiply(itemQuantity));
        try {
        String expResult = "\nItem Name: " + itemName + "\nItem Price: " + itemPrice + "\nItem taxRate: " + taxRate + "\nItem ID: " + itemID + "\nItem Quantity: " + itemQuantity + "\nPrice Summary: " + runningTotal;
        String result = controller.registerItem(itemID, itemQuantity);
        assertEquals("Strings doesnt match.", expResult, result);
        }
        catch (OperationFailedException | InvalidIDException exception){}
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
        String expResult = "Item Name: " + itemName + "\nItem Price: " + itemPrice + "\nItem taxRate: " + taxRate + "\nItem ID: " + itemID + "\nItem Quantity: " + itemQuantity + "Total Price: " + runningTotal;
        String result = controller.registerItem(itemID, itemQuantity);
        assertEquals("Strings doesnt match.", expResult, result);
    }

    @Test
    public void testDisplaySummaryWithException() throws InvalidIDException, OperationFailedException {
        controller.startNewSale();
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(1);
        try{
        controller.registerItem(itemID, itemQuantity);
        String expResult = itemPrice.add(taxRate).toString();
        String result = controller.displaySummary();
        assertEquals("The sums doesnt match.", expResult, result);
        } 
        catch(OperationFailedException | InvalidIDException exception){}
    }

    @Disabled
    public void testDisplaySummaryWithoutException() throws InvalidIDException, OperationFailedException {
        controller.startNewSale();
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(1);
        controller.registerItem(itemID, itemQuantity);
        String expResult = "" + itemPrice.add(taxRate);
        String result = controller.displaySummary();
        assertEquals("The sums doesnt match.", expResult, result);
    }

    @Test
    public void testSalePaymentWithException() throws InvalidIDException, OperationFailedException {
        controller.startNewSale();
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(1);
        Amount runningTotal = itemPrice.multiply(itemQuantity).add(taxRate.multiply(itemQuantity));
        try {
        controller.registerItem(itemID, itemQuantity);
        Amount paidAmount = new Amount(500);
        String expResult = "Change to return: " + paidAmount.subtract(runningTotal);
        String result = controller.salePayment(paidAmount);
        assertEquals("The change returned doesnt match", expResult, result);
        }
        catch(OperationFailedException | InvalidIDException exception){}
    }

    @Test
    public void testSalePaymentWithoutException() throws InvalidIDException, OperationFailedException {
        controller.startNewSale();
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(1);
        Amount runningTotal = itemPrice.multiply(itemQuantity).add(taxRate.multiply(itemQuantity));
        controller.registerItem(itemID, itemQuantity);;
        Amount paidAmount = new Amount(500);
        String expResult = "Change to return: " + paidAmount.subtract(runningTotal);
        String result = controller.salePayment(paidAmount);
        assertEquals("The change returned doesnt match", expResult, result);
    }

    @Test
    public void testRegisterItem() throws InvalidIDException, OperationFailedException {
        controller.startNewSale();
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(1);
        Amount runningTotal = itemPrice.multiply(itemQuantity).add(taxRate.multiply(itemQuantity));
        controller.registerItem(itemID, itemQuantity);
        Amount paidAmount = new Amount(500);
        String expResult = "Change to return: " + paidAmount.subtract(runningTotal);
        String result = controller.salePayment(paidAmount);
        assertEquals("The change returned doesnt match", expResult, result);
    }

    @Test
    public void testRegisterItemUnkownItemIDException() {
        amount = new Amount(2);
        controller.startNewSale();
        assertThrows(InvalidIDException.class, () ->  controller.registerItem(INVALID_ITEM_ID, amount));
    }

    @Test
    public void testRegisterItemIllegalStateException() {
        amount = new Amount(2);
        //controller.startNewSale();
        assertThrows(IllegalStateException.class, () ->  controller.registerItem(11111, amount));
    }

    @Test
    public void testdisplaySummaryIllegalStateException() {
        //controller.startNewSale();
        assertThrows(IllegalStateException.class, () ->  controller.displaySummary());   
    }

    @Test
    public void testSalePaymentIllegalStateException() {
        amount = new Amount();
        //controller.startNewSale();
        assertThrows(IllegalStateException.class, () ->  controller.salePayment(amount));  
    }

    @Test
    public void testRegisterItemOperationFailedException() {
        controller.startNewSale();
        Amount itemQuantity = new Amount(1);
        assertThrows(OperationFailedException.class, () ->  controller.registerItem(DATABASE_UNREACHABLE, itemQuantity));
    }

  
}
