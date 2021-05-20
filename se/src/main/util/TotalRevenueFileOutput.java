package main.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import main.model.PaymentObserver;
import main.model.Summary;

/**
 * Prints Log Revenue messages as a text file
 */
public class TotalRevenueFileOutput implements PaymentObserver {
    private Summary RevenueFileOutput = new Summary();
    private static final String NAME_OF_LOG_FILE = "TotalRevenue.txt";
    private PrintWriter logFile;

    /**
     * Creates an instance of the FileLogger
     * @throws IOException
     */
    public TotalRevenueFileOutput() {
        try {
            logFile = new PrintWriter(new FileWriter(NAME_OF_LOG_FILE), true);
        } 
        catch (IOException exception) {
            System.out.println("Error while creating the log.");
            exception.printStackTrace();
        }
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
}

