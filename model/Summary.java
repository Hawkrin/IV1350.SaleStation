package model;

public class Summary {
    private double runningTotal;
    private double totalTax;
    private double totalDiscount;
    private double summary;

    /**
     * Get the total cost of the purchase
     * @return the total cost of the purchase
     */
    public double getRunningTotal() { return this.runningTotal; }

    /**
     * Get the total amount of tax of the purchase
     * @return  the total amount of tax
     */
    public double totalTax() { return this.totalTax; }

    /**
     * Get the total amount of discount of the purchase
     * @return the total amount of discount
     */
    public double totalDiscount() { return this.totalDiscount; }

    /**
     * returns the total price before tax and discount
     * @return total price of products
     */
    public double sum() { return this.summary; }
}

