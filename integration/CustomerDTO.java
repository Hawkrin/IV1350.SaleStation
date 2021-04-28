package integration;

public class CustomerDTO {
    private String customerName;
    private int customerID;

    /**
     * Creates a new instance representing a certain customer
     * @param name the name of the customer
     * @param id the id of the customer
     */
    public CustomerDTO(String customerName, int customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    /**
     * Creates a new instance representing a certain customer
     * @param id the id of the customer
     */
    public CustomerDTO(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Get the ID of the customer
     * @return the ID of the customer
     */
    public int getCustomerID() { return this.customerID; }

    /**
     * Get the Name of the customer
     * @return the name of the customer
     */
    public String getCustomerName() {return this.customerName; }
    
}
