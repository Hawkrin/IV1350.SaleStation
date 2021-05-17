package main.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * This class is responsible for the log.
 */
public class LogHandler {
    LocalDateTime timeRightNow = LocalDateTime.now();
    private static final String NAME_OF_LOG_FILE = "SaleStation-log.txt";
    private static final LogHandler LOG_INSTANCE = new LogHandler();
    private PrintWriter logFile;
    
    /**
     * Creates the instance of the file logger
     * 
     * @return the logged instance
     */
    public static LogHandler getLog() { return LOG_INSTANCE; }

    /**
     * Writes a log entry describing a thrown exception.
     * 
     * @param exception The exception that shall be logged.
     */
    public void logException(Exception exception) {
        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("An Error Occured");
        logBuilder.append("\n @ " + timeRightNow);
        logBuilder.append("\n and an Exception was thrown: ");
        logBuilder.append(exception.getMessage());
        logFile.println(logBuilder);
        exception.printStackTrace(logFile);
    }

    private LogHandler() {
        try {
            logFile = new PrintWriter(new FileWriter(NAME_OF_LOG_FILE), true);
        } catch (IOException ex) {
            System.out.println("Error while creating the logger.");
            ex.printStackTrace();
        }
    }
    
}
