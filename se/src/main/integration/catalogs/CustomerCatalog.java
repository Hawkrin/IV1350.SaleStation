package main.integration.catalogs;

import java.util.HashMap;
import java.util.Map;
import main.integration.CustomerDTO;
import main.integration.InvalidIDException;
import main.util.Customer;

/**
 * Represents a Register for customers
 */
public class CustomerCatalog implements CatalogTemplate {
    private HashMap<Integer, CustomerDTO> customerRegistry = new HashMap<>();
    CustomerCatalog custCatalog;
    
    private final int DATABASE_UNREACHABLE = 1337;

    public CustomerCatalog() {
        membership();
    }

    /**
     * Get the list of customers
     * 
     * @return the list of customers
     */
    public Map<Integer, CustomerDTO> getCustomerRegistry() { return customerRegistry; }

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
     * @throws InvalidIDException if the customer ID isn't in the database
     * @throws CatalogException if the database can't be reached
     */
    public Customer getCustomer(CustomerDTO customer, int customerID) throws InvalidIDException {
        if(customerInRegister(customerID)) {
            return new Customer(customerRegistry.get(customerID), customerID);
        }
        if (customerID == DATABASE_UNREACHABLE){
            throw new CatalogException("Could not reach the database");
        }
        if(!customerInRegister(customerID)) {
            throw new InvalidIDException("The customer with ID: " + customerID + "doesn't exist in the database");
        }
        return null;
        
    }

    @Override
    public void setData() {
        custCatalog.membership();   
    }

    @Override
    public String getData() {
        return customerRegistry.toString();
        
    }

    protected void membership() {
        customerRegistry.put(123456789, new CustomerDTO("Karl Karlsson", 123456789));
        customerRegistry.put(98765321, new CustomerDTO("Mikael Mikaelsson", 98765321));
        customerRegistry.put(11111111, new CustomerDTO("Daniel Danielsson", 11111111));
    }

  


}


