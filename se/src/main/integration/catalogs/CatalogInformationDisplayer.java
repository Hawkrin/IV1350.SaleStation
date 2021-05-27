package main.integration.catalogs;

/**
 * A class that displays all the data contained in the stores database.
 */
public class CatalogInformationDisplayer  {
    private CompleteCatalog catalog = new CompleteCatalog();

    /**
     * Prints the data from Completecatalog
     */
    public void printData(){
        System.out.println(catalog.getData());
    }

    /**
     * Sets the data from the completecatalog
     */
    public void setData(){
        catalog.setData();
    }



  
    
}
