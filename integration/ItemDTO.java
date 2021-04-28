package integration;

public class ItemDTO {

    private final int price;
    private final String itemName;
    private final double taxRate;
    private final int itemID;

    /**
     * Creates a new instance representing a certain item
     * 
     * @param price The price of the product
     * @param itemName Name of the product
     * @param taxRate the taxrate of the product
     */
    public ItemDTO(String itemName, int price, double taxRate, int itemID) {
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
    public int getPrice() { return price; }

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
    public double getTaxRate() { return taxRate; }

    /**
     * Get the itemID of a product
     * 
     * @return the itemID of a product
     */
    public double getItemID() { return itemID; }

    /**
     * Item info represented as a string
     * 
     * @return the completed string.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ItemName: " + itemName);
        builder.append("\nPrice of item: " + price);
        builder.append("\nTaxrate of item: " + taxRate);
        builder.append("\nItemID: " + itemID);
        return builder.toString();
    }



    
    
}
