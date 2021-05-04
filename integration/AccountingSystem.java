package integration;

import model.Sale;
import java.time.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * Represents an external accounting system
 */
public class AccountingSystem {
    private LocalDateTime timeOfSale;
    private HashMap<LocalDateTime, Sale> accLog = new HashMap();
    
    /**
     * A new instance of an accounting system
     */
    AccountingSystem() {}


    /**
     * Adds the sale and the saleTime to the accounting logs.
     * 
     * @param sale the recently finishied {@link Sale}
     */
    public void accountingLog(Sale sale) {
        timeOfSale = LocalDateTime.now();
        accLog.put(timeOfSale, sale);   
    }  
}
