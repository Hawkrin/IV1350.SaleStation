package tests.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AmountTest {
    private src.util.Amount amountZero;
    private src.util.Amount amountFive;

    @BeforeEach
    public void setUp() {
        amountZero = new src.util.Amount();
        amountFive = new src.util.Amount(5);
    }

    @AfterEach
    public void tearDown() {
        amountZero = null;
        amountFive = null;
    }

    @Test
    void testSubtract() {
        double amount1 = 10;
        double amount2 = 3;
        src.util.Amount operand1 = new src.util.Amount(amount1);
        src.util.Amount operand2 = new src.util.Amount(amount2);
        src.util.Amount expResult = new src.util.Amount(amount1 - amount2);
        src.util.Amount result = operand1.subtract(operand2);
        assertEquals(expResult, result, "Wrong difference");
    }

    @Test
    void testSubtractNegativeResult() {
        double amount1 = 10;
        double amount2 = 3;
        src.util.Amount operand1 = new src.util.Amount(amount1);
        src.util.Amount operand2 = new src.util.Amount(amount2);
        src.util.Amount expResult = new src.util.Amount(amount2 - amount1);
        src.util.Amount result = operand2.subtract(operand1);
        assertEquals(expResult, result, "Wrong difference");
    }

    @Test
    void testSubtractWithNegativeNumbers() {
        double amount1 = -10;
        double amount2 = -5;
        src.util.Amount operand1 = new src.util.Amount(amount1);
        src.util.Amount operand2 = new src.util.Amount(amount2);
        src.util.Amount expResult = new src.util.Amount(amount2 - amount1);
        src.util.Amount result = operand2.subtract(operand1);
        assertEquals(expResult, result, "Wrong difference");
    }

    @Test
    void testAdd() {
        double amount1 = 10;
        double amount2 = 3;
        src.util.Amount operand1 = new src.util.Amount(amount1);
        src.util.Amount operand2 = new src.util.Amount(amount2);
        src.util.Amount expResult = new src.util.Amount(amount1 + amount2);
        src.util.Amount result = operand1.add(operand2);
        assertEquals(expResult, result, "Wrong summary");
    }

    @Test
    void testAddNegativeNumbers() {
        double amount1 = -10;
        double amount2 = -3;
        src.util.Amount operand1 = new src.util.Amount(amount1);
        src.util.Amount operand2 = new src.util.Amount(amount2);
        src.util.Amount expResult = new src.util.Amount(amount1 + amount2);
        src.util.Amount result = operand1.add(operand2);
        assertEquals(expResult, result, "Wrong summary");
    }

    @Test
    void testAddNumbersWithSumOfZero() {
        double amount1 = 3;
        double amount2 = -3;
        src.util.Amount operand1 = new src.util.Amount(amount1);
        src.util.Amount operand2 = new src.util.Amount(amount2);
        src.util.Amount expResult = new src.util.Amount(amount1 + amount2);
        src.util.Amount result = operand1.add(operand2);
        assertEquals(expResult, result, "Wrong summary");
    }

    @Test
    void testMultiply() {
        double amount1 = 3;
        double amount2 = 5;
        src.util.Amount operand1 = new src.util.Amount(amount1);
        src.util.Amount operand2 = new src.util.Amount(amount2);
        src.util.Amount expResult = new src.util.Amount(amount1 * amount2);
        src.util.Amount result = operand1.multiply(operand2);
        assertEquals(expResult, result, "Wrong product");
    }

    @Test
    void testMultiplyWithOneNegativeNumber() {
        double amount1 = 3;
        double amount2 = -5;
        src.util.Amount operand1 = new src.util.Amount(amount1);
        src.util.Amount operand2 = new src.util.Amount(amount2);
        src.util.Amount expResult = new src.util.Amount(amount1 * amount2);
        src.util.Amount result = operand1.multiply(operand2);
        assertEquals(expResult, result, "Wrong product");
    }

    @Test
    void testMultiplyWithTwoNegativeNumbers() {
        double amount1 = -3;
        double amount2 = -5;
        src.util.Amount operand1 = new src.util.Amount(amount1);
        src.util.Amount operand2 = new src.util.Amount(amount2);
        src.util.Amount expResult = new src.util.Amount(amount1 * amount2);
        src.util.Amount result = operand1.multiply(operand2);
        assertEquals(expResult, result, "Wrong product");
    }

    @Test
    void testMultiplyWithZero() {
        double amount1 = 3;
        double amount2 = 0;
        src.util.Amount operand1 = new src.util.Amount(amount1);
        src.util.Amount operand2 = new src.util.Amount(amount2);
        src.util.Amount expResult = new src.util.Amount(amount1 * amount2);
        src.util.Amount result = operand1.multiply(operand2);
        assertEquals(expResult, result, "Wrong product");
    }

    @Test
    public void toStringPositiveNumber() {
        double StringNumber = 20;
        src.util.Amount amount = new src.util.Amount(StringNumber);
        String expResult = Double.toString(StringNumber);
        String result = amount.toString();
        assertEquals(expResult, result, "Wrong String returned");
    }

    @Test
    public void toStringNegativeNumber() {
        double StringNumber = -20;
        src.util.Amount amount = new src.util.Amount(StringNumber);
        String expResult = Double.toString(StringNumber);
        String result = amount.toString();
        assertEquals(expResult, result, "Wrong String returned");
    }

    @Test
    public void toStringZeroNumber() {
        double StringNumber = 0;
        src.util.Amount amount = new src.util.Amount(StringNumber);
        String expResult = Double.toString(StringNumber);
        String result = amount.toString();
        assertEquals(expResult, result, "Wrong String returned");
    }
    
}
