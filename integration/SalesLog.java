package integration;

import model.Sale;

/**
 * represents a sales log database
 */
public class SalesLog {
    private SalesLog salesLog;
    private Sale sale;

    /**
     * Gets the salesLog 
     * 
     * @return return the value of the salesLog
     */
    public SalesLog getSalesLog() { return salesLog; }

    /**
     * updates the sales log
     * 
     * @param sale the recently finishied {@link Sale}
     */
    public void updateSalesLog(Sale sale){}
    
}
