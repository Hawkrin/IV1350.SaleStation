package main.util;


import main.controller.*;
import main.integration.InvalidIDException;
import main.view.ErrorMessageHandler;

/**
 * This class exists to help executing a sample of the application in the View class.
 */
public class SampleHelpMethods {
    Controller ctrl;
    private ErrorMessageHandler errorMsgHandler =  ErrorMessageHandler.getErrorMessage();
    private LogHandler loghandler = FileErrorLogger.getFileErrorLogger();

    /**
     * Creates a new instance
     * 
     * @param ctrl The controller that is used for all operations
     * @throws IOException if interrupted
     */
    public SampleHelpMethods(Controller ctrl) {
        this.ctrl = ctrl;
    }

    /**
     * Search for the requested item. This method implements the registerItem method
     * from the controller class.
     * 
     * @param quantity how many examples of an item to purchase {@link Amount}
     * @param itemID the item number
     * @return returns the result to the sale method registerItems
     */
    public void registerItem(int itemID, Amount quantity){
        try {
            System.out.println(ctrl.registerItem(itemID, quantity));
        }catch (InvalidIDException exception) {
            handleException("The ID: " + itemID +  " doesn't exist, please try again.", exception);
        }catch (OperationFailedException exception) {
            handleException("Failed to register item, try again.", exception);
        }catch (IllegalStateException exception){
            handleException("A new sale have to be started.", exception);
        }
    }

    private void handleException(String message, Exception exception){
        errorMsgHandler.displayErrorMessage(message);;
        loghandler.logException(exception);
    }
    
}
