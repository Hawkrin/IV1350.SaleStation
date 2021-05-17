package main.integration;

import main.model.Receipt;
/**
 * A class that represent the reciept printer
 */
public class ReceiptPrinter {
    private Receipt receipt;

    /**
     * Creates an instance, represented as a printer
     */
    public ReceiptPrinter() {
    }

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
