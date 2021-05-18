package main.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * This class is responsible for logging.
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
    public default String getDateAndTime() {
        DateTimeFormatter format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return timeRightNow.format(format); 
    } 
}


    
    

