package tests.view;

import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import main.controller.Controller;
import main.integration.InvalidIDException;
import main.integration.Item;
import main.integration.ReceiptPrinter;
import main.integration.SalesLog;
import main.integration.SystemHandler;
import main.integration.catalogs.CatalogHandler;
import main.integration.catalogs.ItemCatalog;
import main.model.Sale;
import main.model.Summary;
import main.view.SampleHelpMethods;
import main.util.Amount;
import main.util.DateAndTime;

public class SampleHelpMethodTest {
    SampleHelpMethods instance;
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;
    Amount quantity;
    Sale sale;
    Summary summary;
    Controller controller;
    ItemCatalog itemCatalog;
    DateAndTime logTime;
    Amount amount;
    

    @Before
    public void setUp() {
        controller = new Controller(CatalogHandler.getCatalogHandler(), SystemHandler.getSystemHandler(), ReceiptPrinter.getReceiptPrinter(), SalesLog.getSalesLog());
        instance = new SampleHelpMethods(controller);
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        sale = new Sale();
        summary = new Summary();
        itemCatalog = new ItemCatalog();
        logTime = new DateAndTime();   
    }

    @After
    public void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
        instance = null;
    }

    @Test
    public void testRegisterItem() throws InvalidIDException {
        controller.startNewSale();
        quantity = new Amount(2);
        Item newItem = itemCatalog.getItem(11111, quantity);
        instance.registerItem(11111, quantity);
        String printout = outContent.toString();
        String expRes = sale.updateItems(newItem) + "\nItem Quantity: " + 
                        quantity.toString() + "\nPrice Summary: " + 
                        controller.displaySummary();
        assertTrue("A wrong print out is made", printout.contains(expRes));
    }

    @Test
    public void testRegisterItemBeforeSaleStarted() {
        //controller.startNewSale();
        quantity = new Amount(2);
        instance.registerItem(11111, quantity);
        String printout = outContent.toString();
        String expRes = "***************CONSOLE LOGGER****************\n\n" +
        "An error occured @ " + logTime.getDateAndTime() + "\n\n" +
        "The following happend: \n"  + "Call to registerItem was made before initiating a new sale." + "\n\n" +
        "*************CONSOLE LOGGER ENDS************\n";
        assertTrue("A wrong print out is made", printout.contains(expRes));
    }

    @Test
    public void testRegisterItemBeforeSaleStartedErrorMessageHandlerMessage() {
        //controller.startNewSale();
        quantity = new Amount(2);
        instance.registerItem(11111, quantity);
        String printout = outContent.toString();
        String expRes = "******WARNING******\n" +
                        logTime.getDateAndTime() + "\n" +
                        "ERROR OCCURED " + "\n" +
                        "A new sale have to be started." + "\n" +
                        "*******************";
        assertTrue("A wrong print out is made", printout.contains(expRes));
    }

    @Disabled
    public void testRegisterItemUnknownItemRegistered() {
        controller.startNewSale();
        quantity = new Amount(2);
        instance.registerItem(11111, quantity);
        String printout = outContent.toString();
        String expRes = "The item with ID: 12343 doesn't exist in the database";          
        assertTrue("A wrong print out is made", printout.contains(expRes));
    }
   
}
