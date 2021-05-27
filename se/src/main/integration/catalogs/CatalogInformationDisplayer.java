package main.integration.catalogs;

/**
 * A class that displays the entity CompleteCatalog
 */
public class CatalogInformationDisplayer  {
    private CompleteCatalog catalog = new CompleteCatalog();

    /**
     * prints the data from Completecatalog
     */
    public void printData(){
        System.out.println(catalog.getData());
    }

    public void setData(){
        catalog.setData();
    }



  
    
}
