package main.integration.catalogs;

import java.util.HashMap;

import main.integration.CustomerDTO;
import main.integration.InvalidIDException;
import main.util.Customer;

/**
 * Represents a Register for customers
 */
public class CustomerCatalog implements CatalogTemplate {
    private HashMap<Integer, CustomerDTO> customerRegistry = new HashMap<>();
    private HashMap <Integer, String> customerGDPRAgreement = new HashMap<>();
    CustomerCatalog customerCatalog;
    String approve;
    String decline;

    public CustomerCatalog() {
        membership();
    }

    /**
     * Get the list of customers
     * 
     * @return the list of customers
     */
    public HashMap<Integer, CustomerDTO> getCustomerRegistry() { return customerRegistry; }

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
     * Checks if the customer have agreed to GDPR. If not, the customer data can't be retrieved
     * 
     * @param customerID the ID of a certain customer
     * @return If customer has agreed <code>true</code> else <code>false</code>
     */
    public boolean customerGDPRError(int customerID){
        return customerGDPRAgreement.containsKey(customerID);    
    }

    /**
     * if the customers ID is in the database, the information about the customer
     * is retrieved
     * 
     * @param customer information about the customer
     * @param customerID the ID number of the customer
     * @return all the info about the customer if in the database, otherwise an exception
     * @throws InvalidIDException if the customer ID isn't in the database
     * @throws CatalogException if the database can't be reached
     */
    public Customer getCustomer(CustomerDTO customer, int customerID) throws InvalidIDException {
        if(customerInRegister(customerID)) {
            return new Customer(customerRegistry.get(customerID), customerID);
        }
        if(customerInRegister(customerID) == false) {
            throw new InvalidIDException("The customer with ID: " + customerID + "doesn't exist in the database");
        }
        if(customerInRegister(customerID) && customerGDPRError(customerID) == false) {
            throw new CatalogException("Could not reach the database");
        }
        return null;
    }

    @Override
    public void setData() {
        customerCatalog.membership();   
    }

    @Override
    public String getData() {
        return customerRegistry.toString();
        
    }

    protected void membership() {
        customerRegistry.put(123456789, new CustomerDTO("Karl Karlsson", 123456789));
        customerRegistry.put(98765321, new CustomerDTO("Mikael Mikaelsson", 98765321));
        customerRegistry.put(11111111, new CustomerDTO("Daniel Danielsson", 11111111));

        customerGDPRAgreement.put(123456789, approve);
        customerGDPRAgreement.put(11111111, approve);
    }

  


}


