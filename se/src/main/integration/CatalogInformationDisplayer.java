package main.integration;

/**
 * A class that displays the entity CompleteCatalog
 */
public class CatalogInformationDisplayer {
    private CompleteCatalog catalog = new CompleteCatalog();

    /**
     * prints the data from Completecatalog
     */
    public void printData(){
        for (int i = 0; i < catalog.getData().length; i++) {
            System.out.println("\nData: " + catalog.getData()[i]);
        }
    }

    /**
     * Sets the data
     * 
     * @param customerData the customer data
     * @param itemData the item data
     */
    public void setData(String customerData, String itemData, String discountData){
        catalog.setData(customerData, itemData, discountData);
     }
    
}
