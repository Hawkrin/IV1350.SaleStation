package src.integration;

/**
 * Thrown when a fault occurs in <code>ItemCatalog</code>.
 */
public class ItemCatalogException extends RuntimeException {
    
    /**
     * Creates an instance of <code>ItemCatalogException</code> with a given message.
     * 
     * @param msg Information about the reason why the exception is thrown.
     */
    public ItemCatalogException(String msg) {
        super(msg);
    }
}
