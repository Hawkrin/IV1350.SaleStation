package main.startup;

import main.controller.Controller;
import main.integration.CatalogHandler;
import main.integration.ReceiptPrinter;
import main.integration.SalesLog;
import main.integration.SystemHandler;
import main.view.View;

/**
 * Contains the <code>main</code> method. Performs all startup of the application.
 */
public class Main {

    /**
     * Starts the application
     * 
     * @param args no command line parameters are taken
     */
    public static void main(String[] args) {
        SystemHandler systemHandler = new SystemHandler();
        CatalogHandler catalogHandler = new CatalogHandler();
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        SalesLog salesLog = new SalesLog();
        Controller ctrl = new Controller(catalogHandler, systemHandler, receiptPrinter, salesLog);
        View view = new View(ctrl);

        
        

    }
    
}
