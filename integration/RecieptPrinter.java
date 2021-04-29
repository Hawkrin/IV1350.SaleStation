package integration;

import jdk.internal.module.SystemModuleFinders;

/**
 * A class that represent the reciept printer
 */
public class RecieptPrinter {
    private Reciept reciept;

    /**
     * Creates an instance, represented as a printer
     */
    public RecieptPrinter() {
        this.reciept = reciept;
    }

    /**
     * Test prints a reciept for the user
     * It prints to <code>System.out</code>
     * 
     * @param reciept the reciept made after a sale
     */
    public void printReciept(Reciept reciept) {
        System.out.println(reciept.toString);
    }
    

    
    
}
