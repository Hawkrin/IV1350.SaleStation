package main.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import main.model.PaymentObserver;
import main.model.Summary;
import main.util.LogHandler;

/**
 * Displays the total revenue after a payment is done
 */
public class TotalRevenueView implements PaymentObserver {
    LocalDateTime timeRightNow = LocalDateTime.now();
    private Summary totalRevenue = new Summary();

    /**
     * Creates a new instance of TotalRevenue
     */
    public TotalRevenueView(){}

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

    /**
     * Gets the date and time of today
     * 
     * @return the date and time of today
     */
    public String getDateAndTime() {
        DateTimeFormatter format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return timeRightNow.format(format); 
    }
    
}
