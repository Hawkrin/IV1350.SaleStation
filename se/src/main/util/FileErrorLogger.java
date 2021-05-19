package main.util;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Prints Log Error messages as a text file
 */
public class FileErrorLogger implements LogHandler {
    private static final FileErrorLogger FILE_LOGGER = new FileErrorLogger();
    private static final String NAME_OF_LOG_FILE = "SaleException-log.txt";
    private PrintWriter logFile;
    
    /**
     * Creates an instance of the FileLogger
     */
    public FileErrorLogger() {
        try {
            logFile = new PrintWriter(new FileWriter(NAME_OF_LOG_FILE), true);
        } 
        catch (IOException exception) {
            System.out.println("Error while creating the log.");
            exception.printStackTrace();
        }
    }

    /**
     * Gets the file logger
     * 
     * @return the file logger
     */
    public static FileErrorLogger getFileErrorLogger() { return FILE_LOGGER; }

    /**
     * Logs the specified exception to a txt file.
     * 
     * @param exception the exception that will be logged
     */
    @Override
    public void logException(Exception exception) {
        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("An Error Occured");
        logBuilder.append("\n @ " + getDateAndTime());
        logBuilder.append("\n and an Exception was thrown: ");
        logBuilder.append(exception.getMessage());
        logFile.println(logBuilder.toString());
        exception.printStackTrace(logFile);  
    }

    /**
     * Prints and logs the specified string to a txt file.
     * 
     * @param amount the amount that will be logged
     */
    @Override
    public void log(String string) {
        logFile.println(string);
    }
    
}
