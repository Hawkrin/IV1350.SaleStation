package src.integration;

import java.util.List;

import src.model.Sale;
import src.util.*;

import java.util.ArrayList;

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
    public double getDiscountPercent() { return this.discountPercent; }

    public Discount checkForDiscount(int customerID){
        return null;
    }


    

}

