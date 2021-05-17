package tests.integration;

import main.integration.CustomerDTO;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
public class CustomerDTOTest {

    
    @Test
    void testToString() {
        String customerName = "Karl Karlsson";
        int customerID = 123456789;
        CustomerDTO customerDTO = new CustomerDTO(customerName, customerID);
        String expResult = "Customer Name: " + customerName + "\nCustomer ID: " + customerID;
        String result = customerDTO.toString();
        assertEquals("CustomerDTO string doesnt match the other String", expResult, result);
    }

    @Test
    void testToStringWithEmptyString() {
        String customerName = "";
        int customerID = 123456789;
        CustomerDTO customerDTO = new CustomerDTO(customerName, customerID);
        String expResult = "Customer Name: " + customerName + "\nCustomer ID: " + customerID;
        String result = customerDTO.toString();
        assertEquals("CustomerDTO string doesnt match the other String", expResult, result);
    }

    @Test
    void testToStringWithNullParameters() {
        String customerName = null;
        int customerID = 0;
        CustomerDTO customerDTO = new CustomerDTO(customerName, customerID);
        String expResult = "Customer Name: " + customerName + "\nCustomer ID: " + customerID;
        String result = customerDTO.toString();
        assertEquals("CustomerDTO string doesnt match the other String", expResult, result);
    }
    
}
