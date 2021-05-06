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

    
}
