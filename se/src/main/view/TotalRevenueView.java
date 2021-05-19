package main.view;

import main.model.PaymentObserver;
import main.model.Summary;
import main.util.LogHandler;

/**
 * Displays the total revenue after a payment is done
 */
public class TotalRevenueView implements PaymentObserver, LogHandler {
    private Summary totalRevenue;

    /**
     * Creates a new instance of TotalRevenue
     */
    public TotalRevenueView(){
        totalRevenue = new Summary();
    }

    @Override
    public void logException(Exception exception) {
        // TODO Auto-generated method stub   
    }

    @Override
    public void log(String string) {
        // TODO Auto-generated method stub   
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
        System.out.println("A sale was made at: " + getDateAndTime() + "\n");
        System.out.println("Total Revenue After Sale: " + totalRevenue.getSummary().toString());
        System.out.println("\n");
        System.out.println("*************CONSOLE LOGGER ENDS************\n");
    }

    
}
