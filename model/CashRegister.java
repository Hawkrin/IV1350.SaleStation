package model;

/**
 * This class represents the cash register
 */
public class CashRegister {
    private Amount balance;

    /**
     * Creates a new instance of a cash register
     */
    public CashRegister() {
        this.balance = new Amount();
    }

    /**
     * Get the current balance of the cash register
     *
     * @return the current balance
     */
    public Amount getBalance() { return balance; }

    
}
