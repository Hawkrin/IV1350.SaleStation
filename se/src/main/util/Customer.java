package main.util;

import main.integration.CustomerDTO;

/**
 * Represents a customer
 */
public class Customer {
    private CustomerDTO customerInfo;
    private int customerID;
    
    /**
     * Creates a new instance of a customer
     * 
     * @param itemInformation The information of a customer {@link CustomerDTO}
     * @param customerID the id of a customer
     */
    public Customer(CustomerDTO customerInfo, int customerID) {
        this.customerInfo = customerInfo;
        this.customerID = customerID;
    }

    /**
     * Creates a new instance of a customer
     */
    public Customer() {}

    /**
     * gets the info about the customer
     * 
     * @return the information in the form of {@link CustomerDTO}
     */
    public CustomerDTO getCustomerDTO() { return customerInfo; }

    /**
     * get the ID number of the customer
     * 
     * @return the id number
     */
    public int getCustomerID() { return customerID; }
}
