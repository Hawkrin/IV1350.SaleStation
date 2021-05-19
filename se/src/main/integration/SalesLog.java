package main.integration;

import main.model.Sale;

/**
 * represents a sales log database. Created as a singelton
 */
public class SalesLog {
    private static final SalesLog INSTANCE = new SalesLog();

    private SalesLog(){}
    
    /**
     * Gets the salesLog 
     * 
     * @return return the value of the salesLog
     */
    public static SalesLog getSalesLog() { return INSTANCE; }

    /**
     * updates the sales log
     * 
     * @param sale the recently finishied {@link Sale}
     */
    public void updateSalesLog(Sale sale){}
    
}
