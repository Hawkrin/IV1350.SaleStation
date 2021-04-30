package integration;

import model.Sale;

public class DiscountCatalog {
    private CustomerDTO customer;
    private Sale sale;


    /**
     * 
     * @param customer
     * @param sale
     */
    public DiscountCatalog(CustomerDTO customer, Sale sale) {
        this.customer = customer;
        this.sale = sale;
    }
    
}
