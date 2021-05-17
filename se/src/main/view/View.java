package main.view;

import main.controller.Controller;
import main.util.*;
import main.integration.*;
import main.model.*;

/**
 * represents the user interface
 */
public class View {
    private Controller ctrl;
    private ErrorMessageHandler errorMsgHandler =  ErrorMessageHandler.getErrorMessage();
    private ConsoleLogger logger = ConsoleLogger.getConsoleLogger();

    /**
     * Creates a new instance
     * 
     * @param ctrl The controller that is used for all operations
     */
    public View(Controller ctrl) {
        this.ctrl = ctrl;
    }

    /**
     * Makes a sample run of the application
     */
    public void sampleRun(){
        System.out.println("New Sale: ");
        ctrl.startNewSale();
        System.out.println("\nCashier enter items.");
        registerItem("Hammer", new Amount(2));

    }
    
}
