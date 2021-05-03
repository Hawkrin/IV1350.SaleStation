package integration;

import java.util.ArrayList;
import java.util.List;
import util.Amount;

/**
 * Contains all the calls to the data store with the products which can be purchased
 */
public class ItemCatalog {
    private List<ItemDTO> availableItems = new ArrayList();

    ItemCatalog() {
        addItems();
    }

    /**
     * Checks if the searched itemID is currently in the database
     * 
     * @param itemID the number of the item.
     * @return If item exists <code>true</code> else <code>false</code>
     */
    public boolean itemInStock(int itemID) {
        return availableItems.contains(itemID);
    }

    /**
     * if the item is in stock, the information about the item is being retrieved
     *
     * @param itemInformation price, VAT and the Name of the Item
     * @param itemQuantity how many of a certain Item
     * @param itemID the Item ID
     * @return all the info about the item if in stock, otherwise return null
     */
    public Item getItem(ItemDTO itemInformation, Amount itemQuantity, int itemID) {
        if(itemInStock(itemID)) {
            return new Item(availableItems.get(itemID), itemQuantity, itemID);
        }
        else throw new IllegalArgumentException("No such item in stock");
    }

    //Items in stock -> "Name", price, taxRate, ID
    private void addItems() {
        availableItems.add(new ItemDTO("Hammer",new Amount(300), new Amount(0.25), 11111));
        availableItems.add(new ItemDTO("Nails", new Amount(50), new Amount(0.06), 11112));
        availableItems.add(new ItemDTO("Saw", new Amount(200), new Amount(0.25), 11113));
        availableItems.add(new ItemDTO("Screwdriver", new Amount(100), new Amount(0.25), 11114));
        availableItems.add(new ItemDTO("Drill", new Amount(500), new Amount(0.12), 11115));
        availableItems.add(new ItemDTO("Screws", new Amount(60), new Amount(0.06), 11116));
    }




    
}
