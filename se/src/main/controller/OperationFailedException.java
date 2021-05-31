package main.controller;

/**
 * Thrown when an operation fails, with the reason unknown.
 */
public class OperationFailedException extends Exception {
    
    /**
    * Creates an instance of <code>CatalogException</code> with a given message.
    *
    * @param msg Information about the reason why the exception is thrown.
    */
    public OperationFailedException(String msg, Exception exception) {
        super(msg);
    }
}
