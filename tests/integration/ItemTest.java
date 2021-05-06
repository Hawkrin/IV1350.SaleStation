package tests.integration;

import src.integration.Item;
import src.integration.ItemDTO;
import src.util.Amount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


public class ItemTest {
    private Item testItemHammerWithoutQuantity;
    private Item testItemNailsWithQuantity;

    @BeforeEach
    void setUp() {
        testItemHammerWithoutQuantity = new Item(new ItemDTO("Hammer", new Amount(300), new Amount(0.25), 11111));
        testItemNailsWithQuantity = new Item(new ItemDTO("Nails", new Amount(50), new Amount(0.06), 11112), new Amount(5));
    }

    @AfterEach
    void tearDown() {
        testItemHammerWithoutQuantity = null;
        testItemNailsWithQuantity = null;
    }

    @Test
    void testToString() {
        String itemName = "Hammer";
        Amount price = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(20);
        ItemDTO itemDTO = new ItemDTO(itemName, price, taxRate, itemID);
        Item testItem = new Item(itemDTO, itemQuantity, itemID);
        String expectedResult = itemDTO.toString() + "item Quantity: " + itemQuantity;
        String result = testItem.toString();
        assertEquals("Strings are not equal.", expectedResult, result);
    }

    @Test
    void testToStringDifferentStrings() {
        String itemName = "Hammer";
        Amount price = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(20);
        ItemDTO itemDTO = new ItemDTO(itemName, price, taxRate, itemID);
        Item testItem = new Item(itemDTO, itemQuantity, itemID);
        String expectedResult = itemDTO.toString() + "HEJ item Quantity: " + itemQuantity;
        String result = testItem.toString();
        assertNotEquals("Strings are not equal.", expectedResult, result);
    }

    @Test
    void testToStringEmptyString() {
        String itemName = "";
        Amount price = new Amount(300);
        Amount taxRate = new Amount(0.25);
        int itemID = 11111;
        Amount itemQuantity = new Amount(20);
        ItemDTO itemDTO = new ItemDTO(itemName, price, taxRate, itemID);
        Item testItem = new Item(itemDTO, itemQuantity, itemID);
        String expectedResult = itemDTO.toString() + "HEJ item Quantity: " + itemQuantity;
        String result = testItem.toString();
        assertNotEquals("Strings are not empty.", expectedResult, result);
    }

    @Test
    void testIncreaseQuantity() {
        Amount operand1 = new Amount(5);
        Amount operand2 = new Amount(10);
        Amount expectedResult = operand1.add(operand2);
        testItemNailsWithQuantity.increaseQuantity(operand2);
        Amount result = testItemNailsWithQuantity.getItemQuantity();
        assertEquals("The increased amount of an Item doesn't match the expected increase", expectedResult, result);
    }  

    @Test
    void testIncreaseQuantityWithNegativeNumber() {
        Amount operand1 = new Amount(5);
        Amount operand2 = new Amount(-10);
        Amount expectedResult = operand1.add(operand2);
        testItemNailsWithQuantity.increaseQuantity(operand2);
        Amount result = testItemNailsWithQuantity.getItemQuantity();
        assertEquals("The increased amount of an Item doesn't match the expected increase", expectedResult, result);
    }  

    @Test
    void testDecreaseQuantity() {
        Amount operand1 = new Amount(5);
        Amount operand2 = new Amount(5);
        Amount expectedResult = operand1.subtract(operand2);
        testItemNailsWithQuantity.decreaseQuantity(operand2);
        Amount result = testItemNailsWithQuantity.getItemQuantity();
        assertEquals("The deacresed amount of an Item doesn't match the expected decrease", expectedResult, result);
    } 

    @Test
    void testDecreaseQuantityWithNegativeNumber() {
        Amount operand1 = new Amount(5);
        Amount operand2 = new Amount(-15);
        Amount expectedResult = operand1.subtract(operand2);
        testItemNailsWithQuantity.decreaseQuantity(operand2);
        Amount result = testItemNailsWithQuantity.getItemQuantity();
        assertEquals("The deacresed amount of an Item doesn't match the expected decrease", expectedResult, result);
    }
}
