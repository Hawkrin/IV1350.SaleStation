package tests.integration;

import src.integration.ReceiptPrinter;
import src.model.Receipt;
import src.integration.Item;
import src.model.Sale;
import src.util.Amount;
import src.integration.ItemDTO;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReceiptPrinterTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;

    @BeforeEach
    public void setUp() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void cleanUp() {
        outContent = null;
        System.setOut(originalSysOut);
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
        Sale sale = new Sale();
        sale.updateItems(item);
        Receipt receipt = new Receipt(sale);
        LocalDateTime saleTime = LocalDateTime.now();
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        receiptPrinter.printReceipt(receipt);
        String result = outContent.toString();
        //assertEquals("Output is not equal to string with the same state.", result);


    }
    
}
