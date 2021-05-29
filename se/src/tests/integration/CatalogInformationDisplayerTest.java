package tests.integration;

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
import main.integration.catalogs.CatalogInformationDisplayer;
import main.integration.catalogs.CompleteCatalog;

public class CatalogInformationDisplayerTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;
    private CatalogInformationDisplayer instance;
    private CompleteCatalog completeCatalog;

    @Before
    public void setUp() {
        Controller controller = new Controller(CatalogHandler.getCatalogHandler(), SystemHandler.getSystemHandler(), ReceiptPrinter.getReceiptPrinter(), SalesLog.getSalesLog());
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        instance = new CatalogInformationDisplayer();
        completeCatalog = new CompleteCatalog();
    }

    @After
    public void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
        instance = null;
    }

    @Test
    public void testPrintData(){
        instance.printData();
        String printout = outContent.toString();
        String expRes = completeCatalog.getData().toString();
        assertTrue(printout.contains(expRes));
    }
    
}
