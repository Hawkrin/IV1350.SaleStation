package src.integration;

/**
 * Thrown when a fault occurs in <code>ItemCatalog</code>.
 */
public class CustomerCatalogException extends RuntimeException {
    
    /**
     * Creates an instance of <code>CustomerCatalogException</code> with a given message.
     * 
     * @param msg Information about the reason why the exception is thrown.
     */
    public CustomerCatalogException(String msg) {
        super(msg);
    }
}