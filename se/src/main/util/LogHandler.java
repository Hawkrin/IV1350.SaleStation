package main.util;

import java.time.LocalDateTime;

/**
 * This class is responsible for the log.
 */
public interface LogHandler {
    LocalDateTime timeRightNow = LocalDateTime.now();

    /**
     * Logs a string
     * 
     * @return the string that has been logged
     */
    public void log(Exception exception);

    /**
     * Gets the date and time of today
     * 
     * @return the date and time of today
     */
    public default String getDateAndTime() { return timeRightNow.toString(); }
}


    
    

