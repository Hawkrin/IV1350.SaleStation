package tests.model;

import src.model.Payment;
import src.util.Amount;
import src.integration.ItemDTO;
import src.integration.Item;
import src.model.Summary;
import src.model.CashRegister;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class CashRegisterTest {
    CashRegister cashRegister = new CashRegister();
    
    @Test
    void testAddPayment(){
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
        cashRegister.addPayment(payment);
        Amount expResult = new Amount(0).add(payment.getFinalSum().getSummary());
        Amount result = cashRegister.getCurrentBalance();
        assertEquals("The balances does not match.", expResult, result);
    }
        
    }

