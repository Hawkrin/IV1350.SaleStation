package main.util;

import main.model.PaymentObserver;
import main.model.Summary;

/**
 * Displays the total revenue via a logfile when a payment is done.
 */
public class TotalRevenueFileOutput implements PaymentObserver {
    private Summary RevenueFileOutput;
    private LogHandler logger;

    /**
     * Creates a new instance and writes log messages to the specified logger
     * 
     * @param logger The logger used for log messages
     */
    public TotalRevenueFileOutput(LogHandler logger) {
        this.logger = logger;
    }

    /**
     * Changes type of logger to use
     * 
     * @param logger The logger used for log messages
     */
    public void setLogger(LogHandler logger) {
        this.logger = logger;
    }

    /**
     * Creates a new instance of TotalRevenueFileOutPut
     */
    public TotalRevenueFileOutput(){
        RevenueFileOutput = new Summary();
    }

    /**
     * Updates the total revenue when a payment is done
     * 
     * @param summary the summary of the revenue
     */
    @Override
    public void updateTotal(Summary summary){
        RevenueFileOutput.updateTotal(summary);
        createTotalRevenueFile();
    }

    private void createTotalRevenueFile(){
        logger.log(RevenueFileOutput.getSummary());    
    }
    
}
