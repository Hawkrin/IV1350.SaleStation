package main.integration;

import java.util.HashMap;
import main.util.Amount;

/**
 * Contains all the calls to the data store with the products which can be purchased
 */
public class ItemCatalog {
    private HashMap<Integer, ItemDTO> availableItems  = new HashMap<>();

    public ItemCatalog() {
        addItems();
    }
    
    /**
     * Get the list of the available items
     * 
     * @return the list of available items
     */
    public HashMap<Integer, ItemDTO> getAvailabelItems() { return  availableItems; }

    /**
     * Checks if the searched itemID is currently in the database
     * 
     * @param itemID the number of the item.
     * @return If item exists <code>true</code> else <code>false</code>
     */
    public boolean itemInStock(int itemID) {
        return availableItems.containsKey(itemID);
    }

    /**
     * if the item is in stock, the information about the item is being retrieved
     *
     * @param itemInformation price, VAT and the Name of the Item {@link ItemDTO}
     * @param itemQuantity how many of a certain Item {@link Amount}
     * @param itemID the Item ID
     * @return all the info about the item if in stock, otherwise return null
     * @throws InvalidIDException if the searched item isn't in stock
     * @throws CatalogException if the database can't be reached
     *                              
     */
    public Item getItem(int itemID, Amount itemQuantity) throws InvalidIDException {
        if(itemInStock(itemID)) {
            return new Item(availableItems.get(itemID), itemQuantity, itemID);
        }
        if(itemInStock(itemID) == false) {
            throw new InvalidIDException("No item with the ID: " + itemID + "exists in stock");
        }
        throw new CatalogException("Could not reach the database");
    }

    public void addItems() {
        availableItems.put(11111, new ItemDTO("Hammer", new Amount(300), new Amount(0.25), 11111));
        availableItems.put(11112, new ItemDTO("Nails", new Amount(50), new Amount(0.06), 11112));
        availableItems.put(11113, new ItemDTO("Saw", new Amount(200), new Amount(0.25), 11113));
        availableItems.put(11114, new ItemDTO("Screwdriver", new Amount(100), new Amount(0.25), 11114));
        availableItems.put(11115, new ItemDTO("Drill", new Amount(500), new Amount(0.12), 11115));
        availableItems.put(11116, new ItemDTO("Screws", new Amount(60), new Amount(0.06), 11116));
    }




    
}
