package model;

/**
 * Represents a reciept, which contains all info about the sale.
 */
public class Reciept {
    private Sale sale;
    private Payment payment;

    /**
     * Creates a new instance, representing a reciept
     * 
     * @param sale the information about the {@link Sale}
     */
    public Reciept(Sale sale, Payment payment){
        this.sale = sale;
        this.payment = payment;
    }
    
}
