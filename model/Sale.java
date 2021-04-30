package model;

import java.util.ArrayList;
import java.util.List;
import util.Amount; 
import java.time.*;
import integration.Item;
import integration.ItemCatalog;
/**
 * Represents the actual sale done in the application
 */
public class Sale {
    private Summary summary;
    private LocalTime saleTime;
    private List shoppingCart = new ArrayList();

    /**
     * Creates a new instance of the Sale
     */
    public Sale() {
        this.summary = new Summary();
        setTimeOfSale();
    }

    /**
     * Get the summary of all products
     * @return the calculated sum of the products
     */
    public Summary getSummary() {
        return summary;
    }

    private void setTimeOfSale() {
        saleTime = LocalTime.now();
    }


    
}
