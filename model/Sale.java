package model;
/**
 * Represents the actual sale done in the application
 */
public class Sale {
    private Summary sum;

    /**
     * Creates a new instance of the Sale
     */
    public Sale() {
        this.sum = new Summary();
    }

    /**
     * Get the summary of all products
     * @return the calculated sum of the products
     */
    public Summary getSummary() {
        return sum;
    }
    
}
