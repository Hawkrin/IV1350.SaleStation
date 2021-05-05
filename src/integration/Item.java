package src.integration;

import src.util.Amount;
/**
 * Represents an Item
 */
public class Item {
    private ItemDTO itemInformation;
    private Amount itemQuantity;
    private int itemID;

    /**
     * Creates a new instance of an Item
     * 
     * @param itemInformation The information of an item {@link ItemDTO}
     * @param Quantity the amount of each item {@link Amount}
     * @param itemID ID number of the item
     */
    public Item(ItemDTO itemInformation, Amount itemQuantity, int itemID) {
        this.itemInformation = itemInformation;
        this.itemQuantity = itemQuantity;
        this.itemID = itemID;
    }

    /**
     * Creates a new instance of an Item
     * 
     * @param itemInformation The information of an item {@link ItemDTO}
     * @param Quantity the amount of each item {@link Amount}
     */
    public Item(ItemDTO itemInformation, Amount itemQuantity) {
        this.itemInformation = itemInformation;
        this.itemQuantity = itemQuantity;
    }

    /**
     * Creates a new instance of a single Item
     * 
     * @param itemInformation The information of an item {@link ItemDTO}
     */
    public Item(ItemDTO itemInformation) {
        this.itemInformation = itemInformation;
    }

    /**
     * get the ID of the product
     * 
     * @return returns the ID of the product
     */
    public int getItemID() { return itemID; }

    /**
     * get the information about the product
     * 
     * @return returns the item information
     */
    public ItemDTO getItemDTO() { return itemInformation; }

    /**
     * get the quantity of a certain item
     * 
     * @return the quantity of an item
     */
    public Amount getItemQuantity() { return itemQuantity; }

    /**
     * presents the selected Item as a string
     * 
     * @return the iteminfo displayed as a string.
     */
    @Override
    public String toString() {
        StringBuilder itemPresentation = new StringBuilder();
        itemPresentation.append(this.itemInformation);
        itemPresentation.append("item Quantity: " + this.itemQuantity);
        return itemPresentation.toString();
    }

    /**
     * Will increase the quantity of an item
     *
     * @param newQuantity The {@link Amount} that will be added to the quantity.
     */
    public void increaseQuantity(Amount newQuantity){
        this.itemQuantity = this.itemQuantity.add(newQuantity);
    }

    /**
     * Will decrease the quantity of an item
     *
     * @param newQuantity The {@link Amount} that will be subtracted to the quantity.
     */
    public void decreaseQuantity(Amount newQuantity){
        this.itemQuantity = this.itemQuantity.subtract(newQuantity);
    }


    
}
