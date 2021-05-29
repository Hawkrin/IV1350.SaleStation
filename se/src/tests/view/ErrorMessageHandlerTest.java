package tests.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import main.controller.Controller;
import main.integration.ReceiptPrinter;
import main.integration.SalesLog;
import main.integration.SystemHandler;
import main.integration.catalogs.CatalogHandler;
import main.util.DateAndTime;
import main.view.ErrorMessageHandler;
import main.view.SampleHelpMethods;
import main.view.View;

public class ErrorMessageHandlerTest {
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;
    ErrorMessageHandler instance;
    String string;
    DateAndTime errorTime;

    @Before
    public void setUp() {
        Controller controller = new Controller(CatalogHandler.getCatalogHandler(), SystemHandler.getSystemHandler(), ReceiptPrinter.getReceiptPrinter(), SalesLog.getSalesLog());
        SampleHelpMethods sample = new SampleHelpMethods(controller);
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        instance = new ErrorMessageHandler();
        string = new String();
        errorTime = new DateAndTime();
    }

    @After
    public void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
        instance = null;
    }

    @Test
    public void testDisplayErrorMessage(){
        instance.displayErrorMessage(string);
        String printout = outContent.toString();
        String expRes = "******WARNING******\n" +
                        errorTime.getDateAndTime() + "\n" +
                        "ERROR OCCURED " + "\n" +
                        string + "\n" +
                        "*******************";
        assertTrue("A wrong print out is made", printout.contains(expRes));
    }  

}
