package main.model;

import main.integration.Item;
import main.util.Amount;

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
        this.totalWithoutTax = new Amount();
        this.totalDiscount = new Amount();
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
    public Amount getSummary() { return summary.add(totalTax) ; }

    /**
     * Updates the total and the totalTax by adding it with another total.
     *
     * @param summary The total that will be added to this total.
     */
    public void updateTotal(Summary summary){
        this.summary = this.summary.add(summary.getSummary());
        this.totalTax = this.totalTax.add(summary.getTotalTax());
    }

    /**
     * Updates the price of the items being bought as well as the total tax.
     * 
     * @param item The item that is being added to the summary of the sale.
     */
    public void summarizeSale(Item item) {
        Amount numberOfItems = item.getItemQuantity();
        Amount itemPrice = item.getItemDTO().getItemPrice();
        Amount itemTaxRate = item.getItemDTO().getTaxRate();

        this.totalTax = this.totalTax.add(numberOfItems.multiply(itemTaxRate));
        this.summary = this.summary.add(numberOfItems.multiply(itemPrice));
    } 
}
