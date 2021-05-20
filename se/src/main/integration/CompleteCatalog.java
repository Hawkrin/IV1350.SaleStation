package main.integration;

/**
 * A composite entity class of the classes ItemCatalog, DiscountCatalog and CustomerCatalog
 */
public class CompleteCatalog {
    CustomerCatalog customercatalog = new CustomerCatalog();
    ItemCatalog itemcatalog = new ItemCatalog();
    DiscountCatalog discountcatalog = new DiscountCatalog();

    /**
     * Sets the data
     * 
     * @param customerData the data in the addItems Hashmap
     * @param itemData the data in the membership Hashmap
     * @param customerData the data of available discounts
     */
    public void setData(String customerData, String itemData, String discountData) {
        itemcatalog.addItems();
        customercatalog.membership();
        discountcatalog.availableDiscount();    
    }

    /**
     * Gets the data.
     * 
     * @return the current data represented as a string
     */
    public String[] getData() {
        return new String[] {
        customercatalog.getCustomerRegistry().toString(), 
        itemcatalog.getAvailabelItems().toString(),
        discountcatalog.getDiscountPercent().toString()
        };
    }
    
}
