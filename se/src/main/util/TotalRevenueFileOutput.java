package main.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import main.model.PaymentObserver;
import main.model.Summary;

/**
 * Prints Log Revenue messages as a text file
 */
public class TotalRevenueFileOutput implements PaymentObserver, LogHandler {
    private Summary RevenueFileOutput;
    private LogHandler logger;
    private static final String NAME_OF_LOG_FILE = "TotalRevenue.txt";
    private PrintWriter logFile;

    /**
     * Creates an instance of the FileLogger
     * @throws IOException
     */
    public TotalRevenueFileOutput() throws IOException {
        RevenueFileOutput = new Summary();
        FileWriter fileWriter = new FileWriter(NAME_OF_LOG_FILE);
        logFile = new PrintWriter(fileWriter, true);
    }

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
        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("***************FILE LOGGER****************\n\n");
        logBuilder.append("Total Revenue After Sale: " + RevenueFileOutput.getSummary().toString());
        logBuilder.append("\n");  
        logBuilder.append("*************FILE LOGGER ENDS************\n");
        logFile.println(logBuilder);  
    }

    @Override
    public void logException(Exception exception) {
        // TODO Auto-generated method stub   
    }

    @Override
    public void log(String string) {
        // TODO Auto-generated method stub
        
    }

}
