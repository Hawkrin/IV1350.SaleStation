package main.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import main.model.ObserverTemplateClass;
import main.util.DateAndTime;

/**
 * Prints Log Revenue messages as a text file
 */
public class TotalRevenueFileOutput extends ObserverTemplateClass  {
    private static final String NAME_OF_LOG_FILE = "TotalRevenueFile.txt";
    private PrintWriter logFile;
    private  DateAndTime saleTime = new DateAndTime();

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
     * Shows total income after a sale in the form of a txt file.
     * 
     * @throws Exception if a sale hasn't been made
     */
    @Override
    protected void doShowTotalIncome() {
        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("***************FILE LOGGER****************\n\n");
        logBuilder.append("A new sale was made @ " + saleTime.getDateAndTime() + "\n");
        logBuilder.append("Total Revenue After Sale: " + getCalculatedIncome().getSummary().toString());
        logBuilder.append("\n");  
        logBuilder.append("*************FILE LOGGER ENDS************\n");
        logFile.println(logBuilder);
    }

    /**
     * Displays an error if a sale cant be done as a txt file.
     * 
     * @param exception if an error occured which stopped the sale
     */
    @Override
    protected void handleErrors(Exception exception) {
        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("***************FILE LOGGER****************\n\n");
        logBuilder.append("An error occured @ " + saleTime.getDateAndTime() + "\n");
        logBuilder.append("The following happend: \n");
        logBuilder.append(exception.getMessage() + "\n");  
        logBuilder.append("*************FILE LOGGER ENDS************\n"); 
        logFile.println(logBuilder);    
    }

    public Object TotalRevenueFileOutput() {
        return null;
    }
}

