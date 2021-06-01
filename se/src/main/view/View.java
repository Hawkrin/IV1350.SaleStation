package main.view;

import main.controller.*;
import main.util.*;

/**
 * represents the user interface
 */
public class View {
    private SampleHelpMethods sample;
    private Controller ctrl;
    private ErrorMessageHandler errorMsgHandler =  ErrorMessageHandler.getErrorMessage();
    private TotalRevenueView revenueView = new TotalRevenueView();
    private TotalRevenueFileOutput revenueViewFile = new TotalRevenueFileOutput();

    /**
     * Creates a new instance
     * 
     * @param ctrl The controller that is used for all operations
     */
    public View(Controller ctrl, SampleHelpMethods sample) {
        this.sample = sample;
        this.ctrl = ctrl;
        this.ctrl.addPaymentObserver(new TotalRevenueView());
        this.ctrl.addPaymentObserver(new TotalRevenueFileOutput());
    }

    /**
     * Makes a sample run of the application
     * 
     */
    public void sampleRun() {
        print("New Sale Started:");
        ctrl.startNewSale();
        print("\nCashier enter items:\n");
        sample.registerItem(11111, new Amount(2));
        print("\n");
        sample.registerItem(11112, new Amount(3));
        print("\nCashier displays the total with taxes:");
        print(ctrl.displaySummary());
        print("\nCashier enters the amount paid by the customer.\n");
        print("\nA Receipt is Printed: \n");
        print(ctrl.salePayment(new Amount(1500)));
    }

    /**
     * Makes a sample run of the application
     */
    public void sampleRunWithExceptions() {
        print("New Sale Started:");
        ctrl.startNewSale();
        print("\nCashier enter items:\n");
        sample.registerItem(11111, new Amount(2));
        sample.registerItem(11112, new Amount(3));
        try{
            print("\nCashier displays the total price with taxes:" + "\n" + ctrl.displaySummary());
            print("\nCashier enters the amount paid by the customer.\n");
        }
        catch(IllegalStateException exception) {
            handleException("A new sale have to be started", exception);
        }
        try{
            print("\nA Receipt is Printed: \n");
            print(ctrl.salePayment(new Amount(1500)));
        }
        catch(IllegalStateException exception) {
            handleException("A new sale have to be started", exception);
        }
    }

    private void handleException(String message, Exception exception){
        errorMsgHandler.displayErrorMessage(message);;
        revenueViewFile.handleErrors(exception);
        revenueView.handleErrors(exception);
    }

    private void print(String output) {
        System.out.println(output);
    }
    
}
