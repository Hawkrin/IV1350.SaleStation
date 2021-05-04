package integration;

import java.util.HashMap;
import model.Sale;
import util.Customer;

/**
 * Represents a database for discounts
 */
public class DiscountCatalog {
    private HashMap <String> discountLevel = new HashMap();
    private CustomerDTO customer;
    private float discountPercent;
    private int customerID;
    private Item itemsToPurchase;

    /**
     * Gets the discount percent
     * 
     * @return the discount percent for the customer
     */
    public float getDiscountPercent() { return this.discountPercent; }

    public void calculateDiscountPercent() {
        if(customerInRegister(customerID)) {
            itemsToPurchase.getShoppingCart().getItemQuantity();
            int itemCounter;
            for(int i = 0; i < itemsToPurchase; i++) {
                itemCounter++;
            }
            if(itemCounter>1 && itemCounter<=3) {
    
            }
            if(itemCounter>3 && itemCounter<=5) {

            }
            if(itemCounter>=10) {

            }
        }

       
    }

    private void discounts() {
        discountLevel.put(new Amount(0.05));
        discountLevel.put(new Amount(0.10));
        discountLevel.put(new Amount(0.15));
    }

}

