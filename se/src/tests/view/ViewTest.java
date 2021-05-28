package tests.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.rules.ExpectedException;
import main.controller.Controller;
import main.integration.ReceiptPrinter;
import main.integration.SalesLog;
import main.integration.SystemHandler;
import main.integration.catalogs.CatalogHandler;
import main.model.Sale;
import main.util.Amount;
import main.util.DateAndTime;
import main.view.SampleHelpMethods;
import main.view.View;
import main.model.ObserverTemplateClass;
import main.model.Payment;
import main.model.Receipt;

public class ViewTest {
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;
    View instance;
    Sale sale; 
    DateAndTime saleTime;
    Receipt receipt;
    ObserverTemplateClass otc;
    Controller controller;
    Payment payment;
    Amount paidAmount;

    @Before
    public void setUp() {
        controller = new Controller(CatalogHandler.getCatalogHandler(), SystemHandler.getSystemHandler(), ReceiptPrinter.getReceiptPrinter(), SalesLog.getSalesLog());
        SampleHelpMethods sample = new SampleHelpMethods(controller);
        sale = new Sale();
        saleTime = new DateAndTime();
        receipt = new Receipt(sale);
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        instance = new View(controller, sample);
        paidAmount = new Amount();
        payment = new Payment(paidAmount, sale.getSummary());
    }

    @After
    public void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
        instance = null;
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testSampleRunWithExceptionsRegisterItem() {
        instance.sampleRunWithExceptions();
        String printout = outContent.toString();
        String expResult =  "\nItem Name: Hammer" +
                            "\nItem Price: 300.0" +
                            "\nItem taxRate: 0.25" +
                            "\nItem ID: 11111" + 
                            "\nItem Quantity: 2.0" + "\n" +
                            "Price Summary: 600.5";
        assertTrue(printout.contains(expResult));
    }

    @Test
    public void testSampleRunDisplayTotal(){
        instance.sampleRunWithExceptions();
        String printout = outContent.toString();
        String expRes = "\nCashier displays the total price with taxes:" + "\n" +
                         controller.displaySummary();
        assertTrue(printout.contains(expRes));
    }

    @Test
    public void testSampleRunConsoleLog(){
        instance.sampleRunWithExceptions();
        String printout = outContent.toString();
        String expRes = "***************CONSOLE LOGGER****************" + "\n\n" +
        "A sale was made at: " + saleTime.getDateAndTime() + "\n\n" +
        "Total Revenue After Sale: " +  "751.3599999999999" +
        "\n\n" +
        "*************CONSOLE LOGGER ENDS************\n";     
        assertTrue(printout.contains(expRes));
    }

    @Test
    public void testSampleRunRecieptCreation(){
        instance.sampleRunWithExceptions();
        String printout = outContent.toString();
        String expRes = "********RECIEPT*********\n" + "\n" +
                        "Purchase was made: " + saleTime.getDateAndTime().toString() + "\n" +
                        "\nItems Bought: \n\n" + sale.getShoppingCart().toString();
        assertTrue(printout.contains(expRes));
    }

    @Test
    public void testSampleRunChangeToReturn(){
        instance.sampleRunWithExceptions();
        String printout = outContent.toString();
        String expRes = "Change to return: " + "749.32";
        assertTrue(printout.contains(expRes));
    }

    @Test
    public void testSampleRunWithExceptionsIllegalStateException() {
        //controller.startNewSale();
        exception.expect(IllegalStateException.class);
        instance.sampleRunWithExceptions();
    }


  
}
