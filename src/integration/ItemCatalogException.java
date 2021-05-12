package src.integration;

/**
 * Thrown when the item database can't be reached
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
