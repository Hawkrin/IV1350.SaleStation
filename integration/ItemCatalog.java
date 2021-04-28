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
     * Search for an item via an itemNumber
     */
    /*public ItemDTO searchedItem(int itemID) {
        for (ItemDTO item : availableItems) {
            if(ItemDTO()==
        }
    }*/

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
