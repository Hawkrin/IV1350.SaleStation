package tests.integration;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerCatalogTest {
    private int customerExistInSystem = 123456789;
    private int customerNotExistInSystem = 987654321;
    private int customerIDIsZero = 0;

    @Test
    public void testcustomerInRegister(){
        src.integration.CustomerCatalog customerCatalog = new src.integration.CustomerCatalog();
        boolean expectedResult = true;
        boolean result = customerCatalog.customerInRegister(customerExistInSystem);
        assertEquals("The expected customer does not  exist in the catalog.", expectedResult, result);
    }

    @Test
    public void testcustomerNotInRegister(){
        src.integration.CustomerCatalog customerCatalog = new src.integration.CustomerCatalog();
        boolean expectedResult = false;
        boolean result = customerCatalog.customerInRegister(customerNotExistInSystem);
        assertEquals("The expected customer does exist in the catalog.", expectedResult, result);
    }

    @Test
    public void testcustomerIDisZero(){
        src.integration.CustomerCatalog customerCatalog = new src.integration.CustomerCatalog();
        boolean expectedResult = false;
        boolean result = customerCatalog.customerInRegister(customerIDIsZero);
        assertEquals("The expected customer does exist in the catalog.", expectedResult, result);
    }

    
}
