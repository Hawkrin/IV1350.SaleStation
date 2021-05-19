package tests.integration;

import main.integration.ReceiptPrinter;
import main.model.Receipt;
import main.integration.Item;
import main.model.Sale;
import main.util.Amount;
import main.integration.ItemDTO;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        LocalDateTime saleTime = LocalDateTime.now();
        ReceiptPrinter receiptPrinter = ReceiptPrinter.getReceiptPrinter();
        receiptPrinter.printReceipt(receipt);
        String result = outContent.toString();
        assertEquals("Output is not equal to string with the same state.", result);


    }
    
}
