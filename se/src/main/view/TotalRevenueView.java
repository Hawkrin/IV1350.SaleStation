package main.view;

import main.model.ObserverTemplateClass;
import main.util.DateAndTime;

/**
 * Displays the total revenue after a payment is done
 */
public class TotalRevenueView extends ObserverTemplateClass {
    private  DateAndTime saleTime = new DateAndTime();
    
    /**
     * Creates a new instance of TotalRevenue
     */
    public TotalRevenueView() throws UnsupportedOperationException {}

    /**
     * Shows total income after a sale in the console
     * 
     * @throws Exception if a sale hasn't been made
     */
    @Override
    public void doShowTotalIncome() {
        print("***************CONSOLE LOGGER****************" + "\n\n" +
        "A sale was made at: " + saleTime.getDateAndTime() + "\n\n" +
        "Total Revenue After Sale: " +  getCalculatedIncome().getSummary().toString() +
        "\n\n" +
        "*************CONSOLE LOGGER ENDS************\n");
    }

    /**
     * Displays an error in the console if a sale cant be done
     * 
     * @param exception if an error occured which stopped the sale
     */
    @Override
    public void handleErrors(Exception exception) {
        print("***************CONSOLE LOGGER****************\n\n" +
        "An error occured @ " + saleTime.getDateAndTime() + "\n\n" +
        "The following happend: \n" + exception.getMessage() + "\n\n" +
        "*************CONSOLE LOGGER ENDS************\n"); 
    }

    private void print(String output) {
        System.err.println(output);
    }
 
}
