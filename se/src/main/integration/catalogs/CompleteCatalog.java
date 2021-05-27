package main.integration.catalogs;

/**
 * A composite entity class of the classes ItemCatalog, DiscountCatalog and CustomerCatalog
 */
public class CompleteCatalog implements CatalogTemplate {
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
    @Override
    public void setData() {
        itemcatalog.setData();
        customercatalog.setData();
        discountcatalog.setData();  
    }

    /**
     * Gets the data.
     * 
     * @return the current data represented as a string
     */
    @Override
    public String getData() {
        return "\n\nThe current members of the store: \n\n" +
                customercatalog.getData().toString() +
                "\n\nThe current items in stock: \n\n" +
                itemcatalog.getData().toString() +
                "\n\nThe current discount levels available: \n\n" +
                discountcatalog.getData().toString();
       
    }

  
}
