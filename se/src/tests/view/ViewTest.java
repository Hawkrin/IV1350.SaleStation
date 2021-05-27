package tests.view;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import main.controller.Controller;
import main.integration.CatalogHandler;
import main.integration.ReceiptPrinter;
import main.integration.SalesLog;
import main.integration.SystemHandler;
import main.util.Amount;
import main.view.SampleHelpMethods;
import main.view.View;

public class ViewTest {
    private Controller controller = new Controller(CatalogHandler.getCatalogHandler(), SystemHandler.getSystemHandler(), ReceiptPrinter.getReceiptPrinter(), SalesLog.getSalesLog());
    private SampleHelpMethods sample = new SampleHelpMethods(controller);
    private View view = new View(controller, sample);
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;

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
    }

    @Test
    public void testSampleRunWithExceptions() {
        print("New Sale Started:");
        controller.startNewSale();
        print("\nCashier enter items:\n");
        sample.registerItem(11111, new Amount(2));
        sample.registerItem(11112, new Amount(3));
        print("\nCashier displays the total price with taxes:");
        print(controller.displaySummary());
        print("\nCashier enters the amount paid by the customer.\n");
        print("\nA Receipt is Printed: \n");
        print(controller.salePayment(new Amount(1500)));
        String expResult = "New Sale Started:" + "\nCashier enter items:\n" + 
                           "\nCashier displays the total price with taxes:" +
                           "\nCashier enters the amount paid by the customer.\n" +
                           "\nA Receipt is Printed: \n";
        String result = outContent.toString();
        assertEquals(expResult, result);
    }

    private void print(String output) {
        System.out.println(output);
    }

    
}
