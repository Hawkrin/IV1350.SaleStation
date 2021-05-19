package main.integration;

public class CompleteCatalog {
    CustomerCatalog customercatalog = new CustomerCatalog();
    ItemCatalog itemcatalog = new ItemCatalog();

    public void setData(String customerData, String itemData) {
        itemcatalog.addItems();
        customercatalog.membership();
    }

    public String[] getData() {
        return new String[] {
        customercatalog.getCustomerRegistry().toString(), 
        itemcatalog.getAvailabelItems().toString()
        };
    }
    
}
