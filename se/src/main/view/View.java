package main.view;

import java.io.IOException;
import main.controller.*;
import main.util.*;
import main.integration.*;
import main.model.*;

/**
 * represents the user interface
 */
public class View {
    private Controller ctrl;
    private ErrorMessageHandler errorMsgHandler =  ErrorMessageHandler.getErrorMessage();
    private LogHandler loghandler = FileLogger.getFileLogger();

    /**
     * Creates a new instance
     * 
     * @param ctrl The controller that is used for all operations
     */
    public View(Controller ctrl) throws IOException {
        this.ctrl = ctrl;
        ctrl.addPaymentObserver(new TotalRevenueView());
        ctrl.addPaymentObserver(new TotalRevenueFileOutput());
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
        registerItem(22222, new Amount(2));
        registerItem(11112, new Amount(3));
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

    private void registerItem(int itemID, Amount amount){
        String out;
        try {
            out = ctrl.registerItem(itemID, amount);
            System.out.println(out);
        }catch (InvalidIDException exception) {
            handleException("The ID: " + itemID +  " doesn't exist, please try again.", exception);
        }catch (OperationFailedException exception) {
            handleException("Failed to register item, try again.", exception);
        }catch (IllegalStateException exception){
            handleException("Have to start new sale.", exception);
        }
    }

    private void handleException(String message, Exception exception){
        errorMsgHandler.displayErrorMessage(message);;
        loghandler.logException(exception);
    }
    
}
