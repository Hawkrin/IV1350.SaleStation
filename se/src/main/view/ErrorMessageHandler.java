package main.view;

import java.time.LocalDateTime;

/**
 * This class shows the error messages to the user
 */
public class ErrorMessageHandler {
    LocalDateTime timeRightNow = LocalDateTime.now();
    private static final ErrorMessageHandler ERROR_MESSAGE = new ErrorMessageHandler();

    /**
     * Creates an instance of the ErrorMessageHandler
     */
    public ErrorMessageHandler() {}

    /**
     * Gets the errorMessage
     * 
     * @return the error message
     */
    public static ErrorMessageHandler getErrorMessage(){ return ERROR_MESSAGE; }

    /**
     * Gets the date and time of today
     * 
     * @return the date and time of today
     */
    public String getDateAndTime() {
        DateTimeFormatter format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return timeRightNow.format(format); 
    } 
    
    /**
     * Displays the specified error message.
     * 
     * @param msg The error message to display.
     */
    void displayErrorMessage(String msg) {
        StringBuilder occuredError = new StringBuilder();
        occuredError.append(getDateAndTime());
        occuredError.append("\n");
        occuredError.append(" ERROR: ");
        occuredError.append("\n");
        occuredError.append(msg);
        occuredError.append("\n");
        System.out.println(occuredError);
    }
}