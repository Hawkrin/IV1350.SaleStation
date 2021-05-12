package src.integration;

import java.util.HashMap;
import src.util.Customer;

/**
 * Represents a Register for customers
 */
public class CustomerCatalog {
    private HashMap<Integer, CustomerDTO> customerRegistry = new HashMap();

    public CustomerCatalog() {
        membership();
    }

    /**
     * Checks if the customerID is in the database
     * 
     * @param customerID the ID of a certain customer
     * @return If customer exists <code>true</code> else <code>false</code>
     */
    public boolean customerInRegister(int customerID) {
        return customerRegistry.containsKey(customerID);
    }

    /**
     * if the customers ID is in the database, the information about the customer
     * is retrieved
     * 
     * @param customer information about the customer
     * @param customerID the ID number of the customer
     * @return all the info about the customer if in the database, otherwise an exception
     * @throws InvalidIDException
     */
    public Customer getCustomer(CustomerDTO customer, int customerID) throws InvalidIDException {
        if(customerInRegister(customerID)) {
            return new Customer(customerRegistry.get(customerID), customerID);
        }
        if(customerInRegister(customerID) == false) {
            throw new InvalidIDException("The customer with ID: " + customerID + "doesn't exist in the database");
        }
        throw new CustomerCatalogException("Could not reach the database");
    }

    private void membership() {
        customerRegistry.put(123456789, new CustomerDTO("Karl Karlsson", 123456789));
    }


}


