package util;

/**
 * The object amount is used to represent different values, such as prices, quantities etc.
 */
public class Amount {
    private final double amount;
    

    /**
     * Creates an instance, representing an amount
     * @param amount the amount represented by the instance
     */
    public Amount(double amount) {
        this.amount = amount;
    }
    
    /**
     * get the value of the amount
     * @return The value of the amount
     */
    public double getAmount() { return amount; }


    
}
