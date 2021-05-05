package integration;

import java.util.List;
import java.util.ArrayList;
import model.Sale;
import util.*;

/**
 * Represents a database for discounts
 */
public class DiscountCatalog {
    private List <Amount> discountLevel = new ArrayList();
    private double discountPercent;

    /**
     * Gets the discount percent
     * 
     * @return the discount percent for the customer
     */
    public float getDiscountPercent() { return this.discountPercent; }

    public Discount checkForDiscount(int customerID){
        return null;
    }


    

}

