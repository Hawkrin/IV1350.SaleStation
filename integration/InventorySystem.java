package integration;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains all the calls to the data store with the products which can be purchased
 */
public class InventorySystem {

    private List<ItemDTO> availableItems = new ArrayList();
    InventorySystem() {
        addItems();
    }

    /**
     * Search for an item via an itemNumber
     */
    /*public ItemDTO searchedItem(int itemID) {
        for (ItemDTO item : availableItems) {
            if(ItemDTO()==
        }
    }*/

    //Items in stock -> "Name", price, taxRate, ID
    private void addItems() {
        availableItems.add(new ItemDTO("Hammer", 300, 0.25, 11111));
        availableItems.add(new ItemDTO("Nails", 50, 0.06, 11112));
        availableItems.add(new ItemDTO("Saw", 200, 0.25, 11113));
        availableItems.add(new ItemDTO("Screwdriver", 100, 0.12, 11114));
        availableItems.add(new ItemDTO("Drill", 500, 0.12, 11115));
        availableItems.add(new ItemDTO("Screws", 60, 0.06, 11116));
    }


    
}
