package main.view;

import java.io.IOException;
import main.controller.*;
import main.util.*;
import main.integration.*;

/**
 * represents the user interface
 */
public class View {
    private SampleHelpMethods sample;
    private Controller ctrl;
    private ErrorMessageHandler errorMsgHandler =  ErrorMessageHandler.getErrorMessage();
    private LogHandler fileLoghandler = FileErrorLogger.getFileErrorLogger();
    private LogHandler consolLoghandler = ConsoleLogger.getConsoleLogger();

    /**
     * Creates a new instance
     * 
     * @param ctrl The controller that is used for all operations
     */
    public View(Controller ctrl, SampleHelpMethods sample) throws IOException {
        this.sample = sample;
        this.ctrl = ctrl;
        this.ctrl.addPaymentObserver(new TotalRevenueView());
        this.ctrl.addPaymentObserver(new TotalRevenueFileOutput());
    }

    /**
     * Makes a sample run of the application
     * 
     */
    public void sampleRun() throws InvalidIDException, OperationFailedException{
        System.out.println("New Sale Started:");
        ctrl.startNewSale();
        System.out.println("\nCashier enter items:\n");
        System.out.println(ctrl.registerItem(11111, new Amount(2)));
        System.out.println("\n");
        System.out.println(ctrl.registerItem(11112, new Amount(3)));
        System.out.println("\nCashier displays the total with taxes:");
        System.out.println(ctrl.displaySummary());
        System.out.println("\nCashier enters the amount paid by the customer.\n");
        System.out.println("\nA Receipt is Printed: \n");
        System.out.println(ctrl.salePayment(new Amount(1500)));
    }

    /**
     * Makes a sample run of the application
     */
    public void sampleRunWithExceptions() throws InvalidIDException, OperationFailedException {
        System.out.println("New Sale Started:");
        ctrl.startNewSale();
        System.out.println("\nCashier enter items:\n");
        sample.registerItem(11111, new Amount(2));
        sample.registerItem(11112, new Amount(3));
        try{
            System.out.println("\nCashier displays the total price with taxes:");
            System.out.println((ctrl.displaySummary()));
            System.out.println("\nCashier enters the amount paid by the customer.\n");
        }
        catch(IllegalStateException exception) {
            handleException("A new sale have to be started", exception);
        }
        try{
            System.out.println("\nA Receipt is Printed: \n");
            System.out.println(ctrl.salePayment(new Amount(1500)));
        }
        catch(IllegalStateException exception) {
            handleException("A new sale have to be started", exception);
        }
    }

    private void handleException(String message, Exception exception){
        errorMsgHandler.displayErrorMessage(message);;
        fileLoghandler.logException(exception);
        consolLoghandler.logException(exception);
    }
    
}
