package main.integration.catalogs;

/**
 * This class handles all catalogs which are being created
 */
public class CatalogHandler {
    private static final CatalogHandler INSTANCE = new CatalogHandler();
    private DiscountCatalog discountCatalog = new DiscountCatalog();
    private ItemCatalog itemCatalog = new ItemCatalog();
    private CustomerCatalog customerCatalog = new CustomerCatalog();

    private CatalogHandler() {}

    /**
     * Get the instance of a CatalogHandler
     * 
     * @return the <code>CatalogHandler</code>
     */
    public static CatalogHandler getCatalogHandler(){ return INSTANCE; }

    /**
     * Gets the value of discountCatalog
     * 
     * @return the value of the discountcatalog
     */
    public DiscountCatalog getDiscountCatalog() { return discountCatalog; }

    /**
     * Gets the value of itemCatalog
     * 
     * @return the value of the the itemCatalog
     */
    public ItemCatalog getItemCatalog() { return itemCatalog; }

    /**
     * Gets the value of customerCatalog
     * 
     * @return the value of customerCatalog
     */
    public CustomerCatalog getCustomerCatalog() { return customerCatalog; }

   
}
