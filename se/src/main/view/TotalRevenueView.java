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
    public TotalRevenueView(){}

    /**
     * Shows total income after a sale in the console
     * 
     * @throws Exception if a sale hasn't been made
     */
    @Override
    protected void doShowTotalIncome() {
        print("***************CONSOLE LOGGER****************\n\n");
        print("A sale was made at: " + saleTime.getDateAndTime() + "\n");
        print("Total Revenue After Sale: " +  getCalculatedIncome().getSummary().toString());
        print("\n");
        print("*************CONSOLE LOGGER ENDS************\n");
    }

    /**
     * Displays an error in the console if a sale cant be done
     * 
     * @param exception if an error occured which stopped the sale
     */
    @Override
    protected void handleErrors(Exception exception) {
        print("***************CONSOLE LOGGER****************\n\n");;
        print("An error occured @ " + saleTime.getDateAndTime() + "\n");
        print("The following happend: \n");
        print(exception.getMessage());
        print("*************CONSOLE LOGGER ENDS************\n"); 
    }

    private void print(String output) {
        System.out.println(output);
    }
 
}
