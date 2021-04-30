package model;

import util.Amount;
import integration.Item;

public class Summary {
    private Amount runningTotal;
    private Amount totalTax;
    private Amount totalDiscount;
    private Amount summary;

    /**
     * Get the total cost of the purchase
     * 
     * @return the total cost of the purchase
     */
    public Amount getRunningTotal() { return this.runningTotal; }

    /**
     * Get the total amount of tax of the purchase
     * 
     * @return  the total amount of tax
     */
    public Amount getTotalTax() { return this.totalTax; }

    /**
     * Get the total amount of discount of the purchase
     * @return the total amount of discount
     */
    public Amount getTotalDiscount() { return this.totalDiscount; }

    /**
     * returns the total price before tax and discount
     * 
     * @return total price of products
     */
    public Amount summary() { return this.summary; }


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

