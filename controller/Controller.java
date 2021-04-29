package controller;

import integration.*;
import model.*;

/**
 * This is the applications only controller, all calls to the model passes through
 * this class
 */
public class Controller {
    private Sale sale;
    private Reciept reciept;
    private CashRegister cashRegister;
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private ItemCatalog itemCatalog;
    private DiscountCatalog discountCatalog;
    private SalesLog salesLog;
    private RecieptPrinter recieptPrinter;

    /**
     * Creates a new instance instance of the catalogs and systems
     * @param catalogHandler gets the classes that handels communication with databases.
     * @param systemHandler gets the classes that handels communication with external systems.
     */
    public Controller(CatalogHandler catalogHandler, SystemHandler systemHandler) {  
        this.itemCatalog = catalogHandler.getItemCatalog();
        this.discountCatalog = catalogHandler.getDiscountCatalog();
        this.inventorySystem = systemHandler.getInventorySystem();
        this.accountingSystem = systemHandler.getAccountingSystem();
    }

    /**
     * Creates a new instance of the salesLog and the reciept printer
     * @param salesLog gets the saleslog
     * @param recieptPrinter gets reciept printer
     */
    public Controller(SalesLog salesLog, RecieptPrinter recieptPrinter) {
        this.salesLog = salesLog.getSalesLog();
        this.recieptPrinter = recieptPrinter.getRecieptPrinter();
    }

    /**
     * A new sale is being created
     */
    public void startNewSale(){
        this.sale = new Sale();
    }

    void checkforDiscount(int customerID) {}
    void pay(double amount) {}
    
}
