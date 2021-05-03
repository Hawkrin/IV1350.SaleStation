package model;

/**
 * Represents a reciepts, which contains all info about the sale.
 */
public class Reciept {
    private Sale sale;

    /**
     * Creates a new instance, representing a reciept
     * 
     * @param sale the information about the sale
     */
    public Reciept(Sale sale){
        this.sale = sale;
    }
    
}
