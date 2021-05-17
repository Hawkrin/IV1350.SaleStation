package tests.model;

import main.model.Payment;
import main.model.Summary;
import main.integration.Item;
import main.integration.ItemDTO;
import main.util.Amount;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
public class PaymentTest {

    @Test
    public void testGetChange() {
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        ItemDTO itemInformation = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        Amount itemQuantity = new Amount(1);
        Item item = new Item(itemInformation, itemQuantity, itemID);
        Summary totalPrice = new Summary();
        totalPrice.summarizeSale(item);
        Amount paidAmount = new Amount(500);
        Payment payment = new Payment(paidAmount, totalPrice);
        Amount expResult = paidAmount.subtract(itemPrice.multiply(itemQuantity).add(taxRate.multiply(itemQuantity)));
        Amount result = payment.getChange();
        assertEquals("The returned change is not the same", expResult, result);
    }

    @Test
    public void testGetChangeWithNoChangeReturned() {
        String itemName = "Hammer";
        Amount itemPrice = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        ItemDTO itemInformation = new ItemDTO(itemName, itemPrice, taxRate, itemID);
        Amount itemQuantity = new Amount(1);
        Item item = new Item(itemInformation, itemQuantity, itemID);
        Summary totalPrice = new Summary();
        totalPrice.summarizeSale(item);
        Amount paidAmount = new Amount(300.25);
        Payment payment = new Payment(paidAmount, totalPrice);
        Amount expResult = paidAmount.subtract(itemPrice.multiply(itemQuantity).add(taxRate.multiply(itemQuantity)));
        Amount result = payment.getChange();
        assertEquals("The returned change is not the same", expResult, result);
    }
    
}
