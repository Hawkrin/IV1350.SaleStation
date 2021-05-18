package main.view;

import main.model.PaymentObserver;
import main.model.Summary;

/**
 * Displays the total revenue after a payment is done
 */
public class TotalRevenueView implements PaymentObserver  {
    private Summary totalRevenue;

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
        System.out.println("**********Total Revenue After Sale**********");
        System.out.println("Revenue: " + totalRevenue.getSummary().toString());
        System.out.println("********************************************\n");
    }
    
}
