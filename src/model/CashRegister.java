package src.model;

import src.util.Amount;
/**
 * This class represents the cash register
 */
public class CashRegister {
    private Amount balance = new Amount();

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
