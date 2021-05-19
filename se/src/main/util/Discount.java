package main.util;

/**
 * A helping class for discounts
 */
public class Discount {
    private Amount availableDiscount;

    /**
     * Creates an instance of a discount
     * 
     * @param availableDiscount the discount available
     */
    public Discount(Amount availableDiscount) {
        this.availableDiscount = availableDiscount;
        
    }

    /**
     * Gets the value of a discount
     * 
     * @return the value of a discount
     */
    public Amount getDiscount() { return availableDiscount; }
    
    /**
     * Customer info represented as a string
     * 
     * @return the completed string.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nAvailable Discount: " + this.availableDiscount);
        return builder.toString();
    }
}
