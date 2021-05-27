package tests.view;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import main.controller.Controller;
import main.integration.ReceiptPrinter;
import main.integration.SalesLog;
import main.integration.SystemHandler;
import main.integration.catalogs.CatalogHandler;
import main.model.ObserverTemplateClass;
import main.model.Receipt;
import main.model.Sale;
import main.util.DateAndTime;
import main.view.TotalRevenueView;

public class TotalRevenueViewTest {
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;
    TotalRevenueView instance;
    Sale sale; 
    DateAndTime logTime;
    Receipt receipt;
    ObserverTemplateClass otc;
    

    @Before
    public void setUp() {
        Controller controller = new Controller(CatalogHandler.getCatalogHandler(), SystemHandler.getSystemHandler(), ReceiptPrinter.getReceiptPrinter(), SalesLog.getSalesLog());
        sale = new Sale();
        logTime = new DateAndTime();
        receipt = new Receipt(sale);
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        instance = new TotalRevenueView();
    }

    @After
    public void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
        instance = null;
    }

    @Test
    public void testdoShowTotalIncome(){
        instance.doShowTotalIncome();
        String printout = outContent.toString();
        String expRes = "***************CONSOLE LOGGER****************\n\n" +
                        "A sale was made at: " + logTime.getDateAndTime();
                        /*"Total Revenue After Sale: " +  otc.getCalculatedIncome().getSummary().toString() +  "\n" +
                        "*************CONSOLE LOGGER ENDS************\n"*/               
        assertTrue(printout.contains(expRes));
    }

   
    
}
