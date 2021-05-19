package main.integration;

import main.model.Receipt;
/**
 * A class that represent the reciept printer. Created as a singelton
 */
public class ReceiptPrinter {
    private static ReceiptPrinter INSTANCE = new ReceiptPrinter();

    private ReceiptPrinter() {}

    /**
     * Gets the instance of a ReceiptPrinter
     * 
     * @return The <code>RecieptPrinter</code>
     */
    public static ReceiptPrinter getReceiptPrinter() { return INSTANCE; }

    /**
     * Test prints a receipt for the user
     * It prints to <code>System.out</code>, not an actual receipt
     * 
     * @param receipt the reciept made after a sale {@link Receipt}
     */
    public void printReceipt(Receipt receipt) {
        System.out.println(receipt.createReceipt());
    }
     
}
