package src.model;

import src.integration.Item;
import src.util.Amount;

/**
 * Represents the Summary in price of the purchase
 */
public class Summary {

    private Amount totalWithoutTax;
    private Amount totalTax;
    private Amount totalDiscount;
    private Amount summary;

    /**
     *  Creates a new instance, representing the total.
     */
    public Summary(){
        this.summary = new Amount();
        this.totalTax = new Amount();
    }

    /**
     * Get the total cost of the purchase
     * 
     * @return the total cost of the purchase
     */
    public Amount getTotalWithoutTax() { return this.totalWithoutTax; }

    /**
     * Get the total amount of tax of the purchase
     * 
     * @return  the total amount of tax
     */
    public Amount getTotalTax() { return this.totalTax; }

    /**
     * Get the total amount of discount of the purchase
     * 
     * @return the total amount of discount
     */
    public Amount getTotalDiscount() { return this.totalDiscount; }

    /**
     * returns the total price before tax and discount
     * 
     * @return total price of products with taxes
     */
    public Amount getSummary() { return totalWithoutTax.add(totalTax) ; }

    /**
     * Updates the price of the items being bought as well as the total tax.
     * 
     * @param item The item that is being added to the summary of the sale.
     */
    public void SummarizeSale(Item item) {
        if(item == null) { 
            throw new IllegalArgumentException("no Items to summerize"); 
        }
        Amount numberOfItems = item.getItemQuantity();
        Amount itemPrice = item.getItemDTO().getItemPrice();
        Amount itemTaxRate = item.getItemDTO().getTaxRate();

        this.totalTax = this.totalTax.add(numberOfItems.multiply(itemTaxRate));
        this.summary = this.summary.add(numberOfItems.multiply(itemPrice));
    }
    
}
