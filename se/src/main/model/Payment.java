package main.model;

import main.util.Amount;
/**
 * Represents the payment done when a product is purchased
 */
public class Payment {
    private Amount paidAmount;
    private Summary totalPrice;

    /**
     * Creates an instance, an amount has been used as payment
     * 
     * @param paidAmount the {@link Amount} of cash used to pay
     */
    public Payment(Amount paidAmount, Summary totalPrice){
        this.paidAmount = paidAmount;
        this.totalPrice = totalPrice;
    }

    /**
     * Get the price of the purchase
     * 
     * @return the {@link Amount} of the purchase 
     */
    public Summary getFinalSum(){ return totalPrice; }

    /**
     * Calculates the change to return
     * 
     * @return the change to return as a {@link Amount}
     */
    public Amount getChange() {
        return paidAmount.subtract(totalPrice.getSummary());
    }
    
}

   
