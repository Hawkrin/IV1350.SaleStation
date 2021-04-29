package integration;

public class SalesLog {
    private SalesLog salesLog;
    private Sale sale;

    /**
     * Creates an instance of a sales log
     * 
     * @param sale the sale information
     */
    public SalesLog(Sale sale) {
        this.sale = sale;
    }

    /**
     * Gets the salesLog 
     * 
     * @return return the value of the salesLog
     */
    public getSalesLog() { return salesLog; }
    
}
