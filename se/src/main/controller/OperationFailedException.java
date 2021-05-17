package main.controller;

/**
 * Thrown if the controller fails while registering items
 */
public class OperationFailedException extends Exception {
    
    /**
    * Creates an instance of <code>CatalogException</code> with a given message.
    *
    * @param msg Information about the reason why the exception is thrown.
    */
    public OperationFailedException(String msg, Exception cause) {
        super(msg);
    }
}
