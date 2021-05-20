package main.startup;

import java.io.IOException;
import main.controller.Controller;
import main.controller.OperationFailedException;
import main.integration.CatalogHandler;
import main.integration.CatalogInformationDisplayer;
import main.integration.InvalidIDException;
import main.integration.ReceiptPrinter;
import main.integration.SalesLog;
import main.integration.SystemHandler;
import main.util.FileErrorLogger;
import main.util.SampleHelpMethods;
import main.util.TotalRevenueFileOutput;
import main.view.TotalRevenueView;
import main.view.View;

/**
 * Contains the <code>main</code> method. Performs all startup of the application.
 */
public class Main {

    /**
     * Starts the application
     * 
     * @param args no command line parameters are taken
     * @throws OperationFailedException
     * @throws InvalidIDException
     * @throws IOException
     */
    public static void main(String[] args) {
        SystemHandler systemHandler = SystemHandler.getSystemHandler();
        CatalogHandler catalogHandler = CatalogHandler.getCatalogHandler();
        ReceiptPrinter receiptPrinter = ReceiptPrinter.getReceiptPrinter();
        SalesLog salesLog = SalesLog.getSalesLog();
        Controller ctrl = new Controller(catalogHandler, systemHandler, receiptPrinter, salesLog);
        SampleHelpMethods sample = new SampleHelpMethods(ctrl);
        View view = new View(ctrl, sample);
        CatalogInformationDisplayer catalogInformationDisplayer = new CatalogInformationDisplayer();
        //view.sampleRun();
        view.sampleRunWithExceptions();
        catalogInformationDisplayer.printData();
    
        

        
        

    }
    
}
