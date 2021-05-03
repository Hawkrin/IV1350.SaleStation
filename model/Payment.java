package model;

import util.Amount;
/**
 * Represents the payment done when a product is purchased
 */
public class Payment {
    private Amount paidAmount;
    private Amount totalCost;

    /**
     * Creates an instance, an amount has been used as payment
     * 
     * @param paidAmount the amount of cash used to pay
     */
    public Payment(Amount paidAmount){
        this.paidAmount = paidAmount;
    }
    
}
