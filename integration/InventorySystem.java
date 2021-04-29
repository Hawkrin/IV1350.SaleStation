package integration;

import java.util.ArrayList;
import java.util.List;
import util.Amount;

/**
 * This class represents the current stock in the inventory
 */
public class InventorySystem {
    private List<ItemDTO> inventoryStock = new ArrayList();

    InventorySystem() {
        itemsInStock();
    }
    
    //
    private void itemsInStock() {
        inventoryStock.add(new ItemDTO("Hammer", new Amount(300), new Amount(0.25), 11111, new Amount(20)));
        inventoryStock.add(new ItemDTO("Nails", new Amount(50), new Amount(0.06), 11112, new Amount(500)));
        inventoryStock.add(new ItemDTO("Screwdriver", new Amount(100), new Amount(0.25), 11114, new Amount(10)));
        inventoryStock.add(new ItemDTO("Drill", new Amount(500), new Amount(0.12), 11115, new Amount(5)));
        inventoryStock.add(new ItemDTO("Screws", new Amount(60), new Amount(0.06), 11116, new Amount(6)));
    }
    
}


