package src.integration;

import src.model.Reciept;
/**
 * A class that represent the reciept printer
 */
public class RecieptPrinter {

    /**
     * Creates an instance, represented as a printer
     */
    public RecieptPrinter() {
    }

    /**
     * Test prints a reciept for the user
     * It prints to <code>System.out</code>, not an actual receipt
     * 
     * @param reciept the reciept made after a sale {@link Reciept}
     */
    public void printReciept(Reciept reciept) {
        System.out.println(reciept.toString());
    }
     
}
