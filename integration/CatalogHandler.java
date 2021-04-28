package integration;
/**
 * This class handels all catalogs which are being created
 */
public class CatalogHandler {
    private DiscountCatalog discountCatalog = new DiscountCatalog();
    private ItemCatalog itemCatalog = new ItemCatalog();

    /**
     * Gets the value of discountCatalog
     * @return the value of the discountcatalog
     */
    public DiscountCatalog getDiscountCatalog() {
        return discountCatalog;
    }

    /**
     * Gets the value of itemCatalog
     * @return the value of the the itemCatalog
     */
    public ItemCatalog getItemCatalog() {
        return itemCatalog;
    }

   
}
