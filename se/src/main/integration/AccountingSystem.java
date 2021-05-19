package main.integration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import main.model.Sale;
/**
 * Represents an external accounting system. Created as a singelton
 */
public class AccountingSystem {
    private LocalDateTime timeOfSale;
    private HashMap<LocalDateTime, Sale> accountingLog = new HashMap();
    
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
        getDateAndTime();
        accountingLog.put(timeOfSale, sale);   
    }
    
    public String getDateAndTime() {
        DateTimeFormatter format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return timeOfSale.format(format); 
    } 
}
