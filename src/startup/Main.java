package src.startup;

import src.controller.Controller;
import src.integration.CatalogHandler;
import src.integration.RecieptPrinter;
import src.integration.SalesLog;
import src.integration.SystemHandler;
import src.view.View;

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
        RecieptPrinter recieptPrinter = new RecieptPrinter();
        SalesLog salesLog = new SalesLog();
        Controller ctrl = new Controller(catalogHandler, systemHandler, recieptPrinter, salesLog);
        View view = new View(ctrl);

        
        

    }
    
}
