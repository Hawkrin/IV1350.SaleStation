package main.view;

import java.time.LocalDateTime;

/**
 * This class shows the error messages to the user
 */
public class ErrorMessageHandler {
    LocalDateTime timeRightNow = LocalDateTime.now();
    
 /**
     * Displays the specified error message.
     * 
     * @param msg The error message to display.
     */
    void displayErrorMessage(String msg) {
        StringBuilder occuredError = new StringBuilder();
        occuredError.append(timeRightNow);
        occuredError.append(", ERROR: ");
        occuredError.append(msg);
        System.out.println(occuredError);
    }
}