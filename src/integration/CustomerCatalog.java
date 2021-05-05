package src.integration;

import java.util.ArrayList;
import java.util.List;
import src.util.Customer;

/**
 * Represents a Register for customers
 */
public class CustomerCatalog {
    private List<CustomerDTO> customerRegistry = new ArrayList();

    /**
     * Checks if the customerID is in the database
     * 
     * @param customerID the ID of a certain customer
     * @return If customer exists <code>true</code> else <code>false</code>
     */
    public boolean customerInRegister(int customerID) {
        return customerRegistry.contains(customerID);
    }

    /**
     * if the customers ID is in the database, the information about the customer
     * is retrieved
     * 
     * @param customer information about the customer
     * @param customerID the ID number of the customer
     * @return all the info about the customer if in the database, otherwise an exception
     */
    public Customer getCustomer(CustomerDTO customer, int customerID) {
        if(customerInRegister(customerID)) {
            return new Customer(customerRegistry.get(customerID), customerID);
        }
        else throw new IllegalArgumentException("No customer found");
    }
}


