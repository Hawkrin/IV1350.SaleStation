package main.integration;

import java.util.HashMap;
import main.model.Sale;
import main.util.DateAndTime;
/**
 * Represents an external accounting system. Created as a singelton
 */
public class AccountingSystem {
    private  DateAndTime saleTime = new DateAndTime();
    private HashMap<DateAndTime, Sale> accountingLog = new HashMap<>();
    
    /**
     * A new instance of an accounting system
     */
   AccountingSystem() {}

    /**
     * Adds the sale and the saleTime to the accounting logs.
     * 
     * @param sale the recently finishied {@link Sale}
     */
    public void updateAccounting(Sale sale) {
        saleTime.getDateAndTime();
        accountingLog.put(saleTime, sale);   
    }
    
}
