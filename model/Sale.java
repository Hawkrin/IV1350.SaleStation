package model;

import java.util.HashMap;
import util.Amount; 
import java.time.*;
import integration.Item;
import integration.ItemCatalog;
/**
 * Represents the actual sale done in the application
 */
public class Sale {
    private Summary sum;
    private LocalTime saleTime;
    private HashMap<String, Item> shoppingCart = new HashMap<>();

    /**
     * Creates a new instance of the Sale
     */
    public Sale() {
        this.sum = new Summary();
        setTimeOfSale();
    }

    /**
     * Get the summary of all products
     * @return the calculated sum of the products
     */
    public Summary getSummary() {
        return sum;
    }

    private void setTimeOfSale() {
        saleTime = LocalTime.now();
    }

    
}
