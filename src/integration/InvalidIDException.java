package src.integration;

/**
 * Thrown when an itemID is unknown
 */
public class InvalidIDException extends Exception {

    /**
     * Creates an instance of <code>InvalidItemException</code> with a given message.
     * 
     * @param msg msg Information about the reason why the exception is thrown.
     */
    public InvalidIDException(String msg) {
        super(msg);
    }
    
}
