package integration;

import model.Sale;
import util.Customer;

/**
 * Represents a database for discounts
 */
public class DiscountCatalog {
    private CustomerDTO customer;
    private float discountPercent;
    private int customerID;

    /**
     * Gets the discount percent
     * 
     * @return the discount percent for the customer
     */
    public float getDiscountPercent() { return this.discountPercent; }
    
}
