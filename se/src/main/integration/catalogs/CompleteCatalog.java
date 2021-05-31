package main.integration.catalogs;

/**
 * A complete catalog of all the data contained in the store.
 */
public class CompleteCatalog implements CatalogTemplate {
    CustomerCatalog customercatalog = new CustomerCatalog();
    ItemCatalog itemcatalog = new ItemCatalog();
    DiscountCatalog discountcatalog = new DiscountCatalog();

    @Override
    public void setData() {
        itemcatalog.setData();
        customercatalog.setData();
        discountcatalog.setData();  
    }

    @Override
    public String getData() {
        return "\n\nThe current members of the store: \n\n" +
                customercatalog.getData() +
                "\n\nThe current items in stock: \n\n" +
                itemcatalog.getData() +
                "\n\nThe current discount levels available: \n\n" +
                discountcatalog.getData();  
    }

  
}
