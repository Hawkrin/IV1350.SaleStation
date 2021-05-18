package main.model;

/**
 * An obsverver interface. Used for classes that wants to be notified when a payment
 * has been done.
 */
public interface PaymentObserver {


    /**
     * Invoked when a payment is made.
     * @param total the total of the made payment.
     */
    void summarizeSale(Item item);
    
}
