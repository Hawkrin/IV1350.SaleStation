package tests.integration;

import main.integration.ReceiptPrinter;
import main.integration.SalesLog;
import main.integration.SystemHandler;
import main.integration.catalogs.CatalogHandler;
import main.model.Receipt;
import main.controller.Controller;
import main.integration.Item;
import main.model.Sale;
import main.util.Amount;
import main.integration.ItemDTO;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import main.util.DateAndTime;

public class ReceiptPrinterTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;
    private ReceiptPrinter instance;
    private Sale sale;
    private Receipt receipt;
    private DateAndTime saleTime;

    @Before
    public void setUp() {
        Controller controller = new Controller(CatalogHandler.getCatalogHandler(), SystemHandler.getSystemHandler(), ReceiptPrinter.getReceiptPrinter(), SalesLog.getSalesLog());
        saleTime = new DateAndTime();
        sale = new Sale();
        receipt = new Receipt(sale);
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        instance = new ReceiptPrinter();
    }

    @After
    public void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
        instance = null;
    }

    @Disabled
    public void testCreateReciept(){
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount itemTaxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(1);
        ItemDTO itemInformation = new ItemDTO(itemName, itemPrice, itemTaxRate, itemID);
        Item item = new Item(itemInformation, itemQuantity, itemID);
        Sale sale = new Sale();
        sale.updateItems(item);
        Receipt receipt = new Receipt(sale);
        ReceiptPrinter receiptPrinter = ReceiptPrinter.getReceiptPrinter();
        receiptPrinter.printReceipt(receipt);
        String expResult = "********RECIEPT*********\n" +
                "Purchase was made: " + saleTime.getDateAndTime().toString() +
                "\nItems Bought: \n\n" + sale.getShoppingCart().toString() +
                "\n*******RECIEPT END*******";
        String result = outContent.toString();
        Assert.assertEquals("Output is not equal to string with the same state.", expResult, result);
    }

    @Test
    public void testPrintReceipt(){
        instance.printReceipt(receipt);
        String printout = outContent.toString();
        String expRes = "********RECIEPT*********\n" + "\n" +
                        "Purchase was made: " + saleTime.getDateAndTime().toString() + "\n" +
                        "\nItems Bought: \n\n" + sale.getShoppingCart().toString() + "\n" +
                        "\n*******RECIEPT END*******";
        assertTrue(printout.contains(expRes));
    }

    
    
}
