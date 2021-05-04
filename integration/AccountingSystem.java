package integration;

import model.Sale;
import java.time.*;
import java.util.HashMap;
/**
 * Represents an external accounting system
 */
public class AccountingSystem {
    private LocalDateTime timeOfSale;
    private HashMap<LocalDateTime, Sale> accLog = new HashMap();
    
    /**
     * A new instance of an accounting system
     */
    public AccountingSystem() {}

    /**
     * Adds the sale and the saleTime to the accounting logs.
     * 
     * @param sale the recently finishied {@link Sale}
     */
    public void updateAccounting(Sale sale) {
        timeOfSale = LocalDateTime.now();
        accLog.put(timeOfSale, sale);   
    }  
}
