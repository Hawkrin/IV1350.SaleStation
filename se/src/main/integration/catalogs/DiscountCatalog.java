package main.integration.catalogs;

import java.util.HashMap;
import main.util.Amount;

/**
 * Represents a database for discounts
 */
public class DiscountCatalog implements CatalogTemplate {
    private HashMap<String, Amount> discountList = new HashMap<>();
    DiscountCatalog discountCatalog;

    /**
     * Creates an instance of a DiscountCatalog
     */
    public DiscountCatalog() {
        availableDiscount();
    }

    /**
     * Gets the discount percent
     * 
     * @return the discount percent for the customer
     */
    public HashMap<String, Amount> getDiscountPercent() { return this.discountList; }

    @Override
    public void setData() {
        discountCatalog.availableDiscount();   
    }

    @Override
    public String getData() {
        return discountList.toString();
        
    }

    protected void availableDiscount() {
        discountList.put("Discount Bronze tier", new Amount(0.05));
        discountList.put("Discount Silver tier", new Amount(0.10));
        discountList.put("Discount Gold tier", new Amount(0.15));
        discountList.put("Discount Diamond tier",new Amount(0.25));
    }



    

}

