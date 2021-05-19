package main.integration;

public class CatalogInformationDisplayer {
    private CompleteCatalog catalog = new CompleteCatalog();

    public void printData(){
        for (int i = 0; i < catalog.getData().length; i++) {
            System.out.println("\nData: " + catalog.getData()[i]);
        }
    }

    public void setData(String customerData, String itemData){
        catalog.setData(customerData, itemData);
     }
    
}
