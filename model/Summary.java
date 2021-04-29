package model;

import util.Amount;

public class Summary {
    private Amount runningTotal;
    private Amount totalTax;
    private Amount totalDiscount;
    private Amount summary;

    /**
     * Get the total cost of the purchase
     * @return the total cost of the purchase
     */
    public Amount getRunningTotal() { return this.runningTotal; }

    /**
     * Get the total amount of tax of the purchase
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
     * @return total price of products
     */
    public Amount sum() { return this.summary; }
}

