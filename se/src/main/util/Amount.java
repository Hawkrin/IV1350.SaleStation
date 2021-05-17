package main.util;

/**
 * The object amount is used to represent different amounts, such as prices, quantities etc.
 */
public class Amount {
    private final double amount;
    

    /**
     * Creates an instance, representing an amount
     * 
     * @param amount the amount represented by the instance
     */
    public Amount(double amount) {
        this.amount = amount;
    }

     /**
     * Creates a new instance, representing the amount 0.
     */
    public Amount() {
        this(0);
    }
    
    /**
     * get the value of the amount
     * 
     * @return The value of the amount
     */
    public double getAmount() { return amount; }

    /**
    * Will subtract an <code>Amount</code> with another speciefied <code>Amount</code>
    *
    * @param other The specified <code>Amount</code>
    
    * @return The difference between the two <code>Amount</code>
    */
    public Amount subtract(Amount other){
        return new Amount(this.amount - other.amount);
    }
    
    /**
    * Will add an <code>Amount</code> with another speciefied <code>Amount</code>
    *
    * @param other The specified <code>Amount</code>
    * @return The sum of the two <code>Amount</code>
    */
    public Amount add(Amount other){
        return new Amount(this.amount + other.amount);
    }

    /**
    * Will multiply an <code>Amount</code> with another speciefied <code>Amount</code>
    *
    * @param other The specified <code>Amount</code> 
    * @return The product of the two <code>Amount</code> 
    */
    public Amount multiply(Amount other){ 
        return new Amount(this.amount * other.amount);
    }

    /**
     * Make a code>Amount</code> into a <code>String</code>.
     * 
     * @return <code>Amount</code> represented as a <code>String</code>
     */
    @Override
    public String toString() {
        return Double.toString(amount);
    }
}









