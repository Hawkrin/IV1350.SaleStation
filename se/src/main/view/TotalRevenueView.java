package main.view;

import main.model.PaymentObserver;
import main.model.Summary;

/**
 * Displays the total revenue after a payment is done
 */
public class TotalRevenueView implements PaymentObserver {
    private Summary totalRevenue;

    /**
     * Creates a new instance of TotalRevenue
     */
    public TotalRevenueView(){
        totalRevenue = new Summary();
    }

    /**
     * Updates the total revenue when a payment is done
     * 
     * @param summary the summary of the revenue
     */
    @Override
    public void updateTotal(Summary summary) {
        totalRevenue.updateTotal(summary);
        printTotalRevenue();    
    }

    private void printTotalRevenue(){
        System.out.println("***************CONSOLE LOGGER****************\n\n");
        System.out.println("Total Revenue After Sale: " + totalRevenue.getSummary().toString());
        System.out.println("\n");
        System.out.println("*************CONSOLE LOGGER ENDS************\n");
    }
    
}
