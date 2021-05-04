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

    /**
     * Gets the discount percent
     * 
     * @return the discount percent for the customer
     */
    public float getDiscountPercent() { return this.discountPercent; }

    public void calculateDiscountPercent() {
       if(customerInRegister(customerID)) {
           switch(Sale.shoppingCart().getItemQuantity()) {
               case "2":
               

           }

       } 
    }

    private void discounts() {
        discountLevel.put(new Amount(0.05));
        discountLevel.put(new Amount(0.10));
        discountLevel.put(new Amount(0.15));
    }

}

