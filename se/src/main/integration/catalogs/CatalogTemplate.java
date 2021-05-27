package main.integration.catalogs;

/**
 * A composite entity interface of the classes ItemCatalog, DiscountCatalog and CustomerCatalog and CompleteCatalog
 */
public interface CatalogTemplate {

    /**
     * Sets the data
     * 
     * @param data the data that is set
    
     */
    void setData();

    /**
     * Gets the data
     * 
     * @return the data
     */
    String getData();


    
}
