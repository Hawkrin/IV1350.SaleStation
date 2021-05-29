package tests.integration;

import org.junit.jupiter.api.Test;

import main.integration.CustomerDTO;
import main.integration.InvalidIDException;
import main.integration.catalogs.CatalogException;
import main.integration.catalogs.CustomerCatalog;

import static org.junit.Assert.*;

public class CustomerCatalogTest {
    private int customerExistInSystem = 123456789;
    private int customerNotExistInSystem = 987654321;
    private int customerIDIsZero = 0;
    CustomerDTO validCustomer;
    CustomerDTO invalidCustomer;


    @Test
    public void testcustomerInRegister(){
        CustomerCatalog customerCatalogB = new CustomerCatalog();
        invalidCustomer = new CustomerDTO("hejsan svejsan", 123123123);
        validCustomer = new CustomerDTO("Karl Karlsson", 123456789);
        customerCatalogB = new CustomerCatalog();
        boolean expResult = true;
        boolean result = customerCatalogB.customerInRegister(customerExistInSystem);
        assertEquals("The expected customer does not  exist in the catalog.", expResult, result);
    }

    @Test
    public void testcustomerNotInRegister(){
        CustomerCatalog customerCatalog = new CustomerCatalog();
        boolean expResult = false;
        boolean result = customerCatalog.customerInRegister(customerNotExistInSystem);
        assertEquals("The expected customer does exist in the catalog.", expResult, result);
    }

    @Test
    public void testcustomerIDisZero(){
        CustomerCatalog customerCatalog = new CustomerCatalog();
        boolean expResult = false;
        boolean result = customerCatalog.customerInRegister(customerIDIsZero);
        assertEquals("The expected customer does exist in the catalog.", expResult, result);
    }

    @Test
    public void testGetCustomerInvalidIDException() {
        CustomerCatalog customerCatalogA = new CustomerCatalog();
        int customerID = 111111111;
        assertThrows(InvalidIDException.class, () ->  customerCatalogA.getCustomer(invalidCustomer, customerID));   
    }

    @Test
    public void testGetCustomerCatalogException() {
        CustomerCatalog customerCatalogA = new CustomerCatalog();
        int customerID = 123456789;
        assertThrows(CatalogException.class, () ->  customerCatalogA.getCustomer(validCustomer, customerID));   
    }
    
}
