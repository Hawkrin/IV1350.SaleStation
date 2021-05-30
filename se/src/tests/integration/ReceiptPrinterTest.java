package tests.integration;

import main.integration.ReceiptPrinter;

import main.model.Receipt;
import main.integration.Item;
import main.model.Sale;
import main.util.Amount;
import main.integration.ItemDTO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
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
        saleTime = new DateAndTime();
        sale = new Sale();
        receipt = new Receipt(sale);
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        instance = ReceiptPrinter.getReceiptPrinter();
    }

    @After
    public void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
        instance = null;
    }

    @Test
    public void testCreateReciept(){
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount itemTaxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(1);
        ItemDTO itemInformation = new ItemDTO(itemName, itemPrice, itemTaxRate, itemID);
        Item item = new Item(itemInformation, itemQuantity, itemID);
        sale.updateItems(item);
        instance.printReceipt(receipt);
        String result = outContent.toString();
        String expResult = "********RECIEPT*********\n" + "\n" +
                           "Purchase was made: " + saleTime.getDateAndTime().toString() + "\n" +
                           "\nItems Bought: \n\n" + sale.getShoppingCart().toString() + "\n" +
                           "\n*******RECIEPT END*******";
        assertEquals("Output is not equal to string with the same state.", expResult, result);
    }

    @Test
    public void testCreateRecieptWithMethods(){
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount itemTaxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(1);
        ItemDTO itemInformation = new ItemDTO(itemName, itemPrice, itemTaxRate, itemID);
        Item item = new Item(itemInformation, itemQuantity, itemID);
        sale.updateItems(item);
        instance.printReceipt(receipt);
        String result = outContent.toString();
        String expResult = receipt.createReceipt().toString();
        assertEquals("Output is not equal to string with the same state.", expResult, result);
    }

    @Test
    public void testPrintReceiptOutput(){
        instance.printReceipt(receipt);
        String printout = outContent.toString();
        String expResult = "********RECIEPT*********\n" + "\n" +
                        "Purchase was made: " + saleTime.getDateAndTime().toString() + "\n" +
                        "\nItems Bought: \n\n" + sale.getShoppingCart().toString() + "\n" +
                        "\n*******RECIEPT END*******";
        assertTrue("A wrong print out is made", printout.contains(expResult));
    }

    @Test
    public void testPrintReceiptOutputViaMethods(){
        instance.printReceipt(receipt);
        String printout = outContent.toString();
        String expResult = receipt.createReceipt().toString();
        assertTrue("A wrong print out is made", printout.contains(expResult));
    }



    
    
}
