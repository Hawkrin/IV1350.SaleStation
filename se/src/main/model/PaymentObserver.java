package main.model;

/**
 * An obsverver interface. Used for classes that wants to be notified when a payment
 * has been done.
 */
public interface PaymentObserver {

    /**
     * Can be called upon when a payment has been made
     * 
     * @param summary the payment summary
     */
    void updateTotal(Summary summary);
    
}
