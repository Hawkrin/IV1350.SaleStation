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
     * 
     * @return the calculated sum of the products
     */
    public Summary getSummary() { return summary; }


    /**
     * Registers items and adds them to the shoppingcart
     * 
     * @param item the item and its information
     * @return the items and price
     */
    public String registerItems(Item item) {
        addItemToShoppingCart(item);
    }


    private boolean shoppingCartContains() {
        return shoppingCart.contains(item.getItemID());
    }

    private void setTimeOfSale() {
        saleTime = LocalTime.now();
    }
    
    private void addItemToShoppingCart(Item item) {
        shoppingcart.add(item.getItemID(), item);
    }
    
    private void increaseQuantityOfItem(Item item){
        if(shoppingCartContains(item)) {
            addItemToShoppingCart(item);
        }
    }

    private void requestedQuantityOfItem(Item item, Amount quantity) {

    }
    
}
