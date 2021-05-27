package main.model;

import java.util.HashMap;
import main.integration.Item;

/**
 * Represents the actual sale done in the application
 */
public class Sale {
    private Summary summary;
    private HashMap<Integer, Item> shoppingCart = new HashMap<>();

    /**
     * Creates a new instance of the Sale
     */
    public Sale() {
        this.summary = new Summary();
    }

    /**
     * Get the summary of all products
     * 
     * @return the calculated sum of the products
     */
    public Summary getSummary() { return summary; }

    /**
     * Get the list of items
     * 
     * @return the list of items
     */
    public HashMap<Integer, Item> getShoppingCart() { return shoppingCart; }

    /**
     * Registers items and adds them to the shoppingcart
     * 
     * @param item the item and its information
     * @return the items and price
     */
    public String updateItems(Item item) {
        if(shoppingCartContains(item)) {
            updateItemQuantityAndPrice(item);
        }
        else {
            addNewItem(item);
        }
        return item.getItemDTO().toString();
    }

    private boolean shoppingCartContains(Item item) {
        return shoppingCart.containsKey(item.getItemID());
    }

    private void updateItemQuantityAndPrice(Item item)  {
        Item itemAlreadyExist = shoppingCart.get(item.getItemID());
        itemAlreadyExist.increaseQuantity(item.getItemQuantity());
        shoppingCart.put(itemAlreadyExist.getItemID(), itemAlreadyExist);
        summary.summarizeSale(item);
    } 

    private void addNewItem(Item item)  {
        shoppingCart.put(item.getItemID(), item);
        summary.summarizeSale(item);
    }
    
}
