package main.integration;

/**
 * Thrown when a database can't be reached
 */
public class CatalogException extends RuntimeException {
    
    /**
     * Creates an instance of <code>CatalogException</code> with a given message.
     * 
     * @param msg Information about the reason why the exception is thrown.
     */
    public CatalogException(String msg) {
        super(msg);
    }
}
