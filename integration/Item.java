package integration;

import util.Amount;
/**
 * Represents an Item
 */
public class Item {
    private ItemDTO itemInformation;
    private Amount itemQuantity;

    /**
     * Creates a new instance of an Item
     * @param itemInformation The information of an item
     * @param Quantity the amount of each item
     */
    public Item(ItemDTO itemInformation, Amount Quantity) {
        this.itemInformation = itemInformation;
        this.itemQuantity = itemQuantity;
    }

    /**
     * Creates a new instance of a single Item
     * @param itemInformation The information of an item
     */
    public Item(ItemDTO itemInformation) {
        this.itemInformation = itemInformation;

    }

    /**
     * get the information about the product
     * @return returns the item information
     */
    public ItemDTO getItemDTO() { return itemInformation; }

    /**
     * get the quantity of a certain item
     * @return the quantity of an item
     */
    public Amount getItemQuantity() { return itemQuantity; }

    /**
     * presents the selected Item as a string
     */
    public String toString() {
        StringBuilder itemPresentation = new StringBuilder();
        itemPresentation.append("itemInfo " + this.ItemDTO);
        itemPresentation.append("item Quantity " + this.itemQuantity);
        return itemPresentation.toString();
    }


    
}
