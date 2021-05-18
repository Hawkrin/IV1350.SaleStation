package main.model;

import java.util.List;
import java.util.ArrayList;
import main.util.Amount;
/**
 * Represents the payment done when a product is purchased
 */
public class Payment {
    private Amount paidAmount;
    private Summary summary;
    private List<PaymentObserver> paymentObservers = new ArrayList();

    /**
     * Creates an instance, an amount has been used as payment
     * 
     * @param paidAmount the {@link Amount} of cash used to pay
     */
    public Payment(Amount paidAmount, Summary summary){
        this.paidAmount = paidAmount;
        this.summary = summary;
    }

    /**
     * Get the price of the purchase
     * 
     * @return the {@link Amount} of the purchase 
     */
    public Summary getFinalSum(){ return summary; }

    /**
     * Calculates the change to return
     * Also notifies the observers when a payment has been done.
     * 
     * @return the change to return as a {@link Amount}
     */
    public Amount getChange() {
        notifyObservers();
        return paidAmount.subtract(summary.getSummary());
    }

    /**
     * The specified observer will be notified when a payment is made.
     * 
     * @param observers The observers to notify.
     */
    public void addPaymentObserver(PaymentObserver obs) {
        paymentObservers.add(obs);
    }

    /**
     * All the specified observers will be notified when this rental has been paid.
     * 
     * @param observers The observers to notify. 
     */
    public void addPaymentObservers(List<PaymentObserver> observers) {
        paymentObservers.addAll(observers);
    }

    private void notifyObservers(){
        for (PaymentObserver obs : paymentObservers) {
            obs.updateTotal(summary);
        }
    }
    
}

   
