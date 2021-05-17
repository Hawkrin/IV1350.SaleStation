package main.model;

import main.util.Amount;
/**
 * This class represents the cash register
 */
public class CashRegister {
    private Amount balance = new Amount();

    /**
     * Gets the current balance in the cash register
     * 
     * @return the balanace
     */
    public Amount getCurrentBalance() { return balance; }

    /**
     * Creates a new instance of a cash register
     * 
     * @param payment represents the payment {@link Payment}
     * 
     */
    public void addPayment(Payment payment) {
        balance = balance.add(payment.getFinalSum().getSummary());
    }
    

    
    
}
