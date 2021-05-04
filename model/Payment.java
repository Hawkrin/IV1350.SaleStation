package model;

import util.Amount;
/**
 * Represents the payment done when a product is purchased
 */
public class Payment {
    private Amount paidAmount;
    private Amount totalPrice;

    /**
     * Creates an instance, an amount has been used as payment
     * 
     * @param paidAmount the {@link Amount} of cash used to pay
     */
    public Payment(Amount paidAmount, Amount totalPrice){
        this.paidAmount = paidAmount;
        this.totalPrice = totalPrice;
    }

    /**
     * Calculates the change to return
     * 
     * @return the change to return as a {@link Amount}
     */
    public Amount getChange() {
        return paidAmount.subtract(totalPrice.getSummary());
    }

    /**
     * Get the price of the purchase
     * 
     * @return the {@link Amount} of the purchase 
     */
    public Amount getSum(){ return totalPrice; }
    
}
