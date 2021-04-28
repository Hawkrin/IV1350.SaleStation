package integration;

/**
 * Represents an Item
 */
public class Item {
    private ItemDTO itemInformation;
    private int itemQuantity;

    /**
     * Creates a new instance of an Item
     * @param itemInformation The information of an item
     * @param Quantity the amount of each item
     */
    public Item(ItemDTO itemInformation, int Quantity) {
        this.itemInformation = itemInformation;
        this.itemQuantity = itemQuantity;
    }
    

    
}
