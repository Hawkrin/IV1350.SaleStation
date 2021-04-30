package util;

/**
 * The object amount is used to represent different amounts, such as prices, quantities etc.
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

    /**
    * Will subtract two <code>Amount</code>
    *
    * @param other The specified <code>Amount</code>
    * @return The difference between the two <code>Amount</code>
    */
    public Amount subtract(Amount other){
        return new Amount(this.amount - other.amount);
    }
    
    /**
    * Will add two <code>Amount</code>
    *
    * @param other The specified <code>Amount</code>
    * @return The sum of the two <code>Amount</code>
    */
    public Amount add(Amount other){
        return new Amount(this.amount + other.amount);
    }

    /**
    * Will multiply two <code>Amount</code>
    *
    * @param other The specified <code>Amount</code>
    * @return The product of the two <code>Amount</code> 
    */
    public Amount multiply(Amount other){ 
        return new Amount(this.amount * other.amount);
    }

}





