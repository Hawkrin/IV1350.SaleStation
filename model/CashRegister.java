package model;

import util.Amount;
/**
 * This class represents the cash register
 */
public class CashRegister {
    private Amount balance = new Amount();

    /**
     * Creates a new instance of a cash register
     */
    public void addPayment(Payment payment) {
        balance = balance.plus(payment.getRunningTotal());
    }
    

    
    
}
