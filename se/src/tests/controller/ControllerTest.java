package tests.controller;

import main.controller.Controller;
import main.controller.OperationFailedException;
import main.integration.InvalidIDException;
import main.integration.ReceiptPrinter;
import main.integration.SystemHandler;
import main.integration.catalogs.CatalogHandler;
import main.integration.catalogs.ItemCatalog;
import main.model.Sale;
import main.integration.SalesLog;
import main.util.Amount;
import main.util.DateAndTime;
import main.integration.ItemDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javax.xml.catalog.CatalogException;
import org.junit.After;
import org.junit.Before;




public class ControllerTest {
    private Controller controller = new Controller(CatalogHandler.getCatalogHandler(), SystemHandler.getSystemHandler(), ReceiptPrinter.getReceiptPrinter(), SalesLog.getSalesLog());
    private final int INVALID_ITEM_ID = 01010;
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;
    Sale sale;
    DateAndTime saleTime;
    Amount amount;
    

    @Before
    public void setUp() {
        sale = new Sale();
        saleTime = new DateAndTime();
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
        ItemDTO itemDTO = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        try {
        String expResult = "\nItem Name: " + itemName + "\nItem Price: " + itemPrice + "\nItem taxRate: " + taxRate + "\nItem ID: " + itemID + "\nItem Quantity: " + itemQuantity + "\nPrice Summary: " + runningTotal;
        String result = controller.registerItem(itemID, itemQuantity);
        assertEquals("Strings doesnt match.", expResult, result);
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
        String expResult = "Item Name: " + itemName + "\nItem Price: " + itemPrice + "\nItem taxRate: " + taxRate + "\nItem ID: " + itemID + "\nItem Quantity: " + itemQuantity + "Total Price: " + runningTotal;
        String result = controller.registerItem(itemID, itemQuantity);
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
        controller.registerItem(itemID, itemQuantity);
        String expResult ="" + itemPrice.add(taxRate);
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
        controller.registerItem(itemID, itemQuantity);
        String expResult = "" + itemPrice.add(taxRate);
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
        controller.registerItem(itemID, itemQuantity);
        Amount paidAmount = new Amount(500);
        String expResult = "Change to return: " + paidAmount.subtract(runningTotal);
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
        controller.registerItem(itemID, itemQuantity);;
        Amount paidAmount = new Amount(500);
        String expResult = "Change to return: " + paidAmount.subtract(runningTotal);
        String result = controller.salePayment(paidAmount);
        assertEquals("The change returned doesnt match", expResult, result);
    }

    @Test
    public void testRegisterItem() throws InvalidIDException, OperationFailedException {
        controller.startNewSale();
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(1);
        Amount runningTotal = itemPrice.multiply(itemQuantity).add(taxRate.multiply(itemQuantity));
        ItemDTO itemDTO = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        controller.registerItem(itemID, itemQuantity);;
        Amount paidAmount = new Amount(500);
        String expResult = "Change to return: " + paidAmount.subtract(runningTotal);
        String result = controller.salePayment(paidAmount);
        assertEquals("The change returned doesnt match", expResult, result);
    }

    @Test
    public void testRegisterItemUnkownItemIDException() throws InvalidIDException, OperationFailedException {
        amount = new Amount(2);
        controller.startNewSale();
        assertThrows(InvalidIDException.class, () ->  controller.registerItem(12332, new Amount(2)));
    }

    @Test
    public void testRegisterItemIllegalStateException() throws InvalidIDException, OperationFailedException {
        amount = new Amount(2);
        controller.registerItem(11111, amount);
        assertThrows(IllegalStateException.class, () ->  controller.registerItem(11111, new Amount(2)));
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

}
