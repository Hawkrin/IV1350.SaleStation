package tests.startup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import main.controller.Controller;
import main.integration.Item;
import main.integration.ItemDTO;
import main.integration.ReceiptPrinter;
import main.integration.SalesLog;
import main.integration.SystemHandler;
import main.integration.catalogs.CatalogHandler;
import main.integration.catalogs.CatalogInformationDisplayer;
import main.integration.catalogs.CompleteCatalog;
import main.integration.catalogs.CustomerCatalog;
import main.integration.catalogs.DiscountCatalog;
import main.integration.catalogs.ItemCatalog;
import main.model.Sale;
import main.startup.Main;
import main.util.Amount;
import main.util.DateAndTime;
import main.util.Discount;
import main.view.SampleHelpMethods;
import main.view.TotalRevenueView;
import main.view.View;
import main.model.ObserverTemplateClass;
import main.model.Payment;
import main.model.Receipt;

public class MainTest {
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;
    View view;
    Sale sale; 
    DateAndTime saleTime;
    Receipt receipt;
    TotalRevenueView totalRevenueView;
    Controller controller;
    Payment payment;
    Amount paidAmount;
    Main instance;
    
    

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
        view = new View(controller, sample);
        paidAmount = new Amount();
        payment = new Payment(paidAmount, sale.getSummary());
        totalRevenueView = new TotalRevenueView();
    }

    @After
    public void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
        view = null;
    }

    @Test
    public void testSampleRunWithExceptionsRegisterItem() {
        view.sampleRunWithExceptions();
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
    public void testSampleRunWithExceptionsRegisterItemViaMethods() {
        view.sampleRunWithExceptions();
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(2);
        ItemDTO itemDTO = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        Item item = new Item(itemDTO, itemQuantity);
        String printout = outContent.toString();
        String expResult = item.toString(); 
        assertTrue(printout.contains(expResult));
    }

    @Test
    public void testSampleRunDisplayTotal(){
        view.sampleRunWithExceptions();
        String printout = outContent.toString();
        String expRes = "\nCashier displays the total price with taxes:" + "\n" +
                         controller.displaySummary();
        assertTrue(printout.contains(expRes));
    }

    @Test
    public void testSampleRunConsoleLog(){
        view.sampleRunWithExceptions();
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
        view.sampleRunWithExceptions();
        String printout = outContent.toString();
        String expRes = "********RECIEPT*********\n" + "\n" +
                        "Purchase was made: " + saleTime.getDateAndTime().toString() + "\n" +
                        "\nItems Bought: \n\n" + sale.getShoppingCart().toString();
        assertTrue(printout.contains(expRes));
    }

    @Test
    public void testSampleRunChangeToReturn(){
        view.sampleRunWithExceptions();
        String printout = outContent.toString();
        String expRes = "Change to return: " + "749.32";
        assertTrue(printout.contains(expRes));
    }

    @Test
    public void testSampleRunChangeToReturnViaMethods(){
        view.sampleRunWithExceptions();
        String printout = outContent.toString();
        String expRes = payment.getChange().toString();
        assertTrue(printout.contains(expRes));
    }

    @Test
    public void testPrintCatalogInformation() {
        CatalogInformationDisplayer infoDisplayer = new CatalogInformationDisplayer();
        CustomerCatalog customerCatalog = new CustomerCatalog();
        ItemCatalog itemCatalog = new ItemCatalog();
        DiscountCatalog discountCatalog = new DiscountCatalog();
        infoDisplayer.printData();
        String printout = outContent.toString();
        String expRes = "\n\nThe current members of the store: \n\n" +
                        customerCatalog.getData().toString() +
                        "\n\nThe current items in stock: \n\n" +
                        itemCatalog.getData().toString() +
                        "\n\nThe current discount levels available: \n\n" +
                        discountCatalog.getData().toString(); 
        assertTrue(printout.contains(expRes));

    }
  
}
    

