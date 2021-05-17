package main.integration;

import main.util.Amount;

/**
 * Represents the data of an item
 */
public class ItemDTO {

    private final Amount price;
    private final String itemName;
    private final Amount taxRate;
    private final int itemID;

    /**
     * Creates a new instance representing a certain item
     * 
     * @param price The price of the product {@link Amount}
     * @param itemName Name of the product
     * @param taxRate the taxrate of the product {@link Amount}
     * @param itemID is the ID number of the product
     */
    public ItemDTO(String itemName, Amount price, Amount taxRate, int itemID) {
        this.price = price;
        this.itemName = itemName;
        this.taxRate = taxRate;
        this.itemID = itemID;
    }

    /**
     * Get the price of the product
     * 
     * @return the price of the product
     */
    public Amount getItemPrice() { return price; }

    /**
     * Get the name of the product
     * 
     * @return the name of the product
     */
    public String getItemName() { return itemName; }

    /**
     * Get the taxrate of the product
     * 
     * @return the taxrate of the product
     */
    public Amount getTaxRate() { return taxRate; }

    /**
     * Get the itemID of a product
     * 
     * @return the itemID of a product
     */
    public int getItemID() { return itemID; }

    /**
     * Item info represented as a string
     * 
     * @return the completed string.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Item Name: " + itemName);
        builder.append("\nItem Price: " + price);
        builder.append("\ntaxRate: " + taxRate);
        builder.append("\nItem ID: " + itemID);
        return builder.toString();
    }


    
    
}
