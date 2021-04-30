package controller;

import integration.*;
import model.*;
import util.Amount;

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
     * @param recieptPrinter gets reciept printer
     */
    public Controller(CatalogHandler catalogHandler, SystemHandler systemHandler, RecieptPrinter recieptPrinter) {  
        this.itemCatalog = catalogHandler.getItemCatalog();
        this.discountCatalog = catalogHandler.getDiscountCatalog();
        this.inventorySystem = systemHandler.getInventorySystem();
        this.accountingSystem = systemHandler.getAccountingSystem();
        this.recieptPrinter = recieptPrinter;
    }

    /**
     * Creates a new instance of the salesLog and the reciept printer
     * @param salesLog gets the saleslog
     * @param cashRegister gets the current balance in the cashRegister
     */
    public Controller(SalesLog salesLog, CashRegister cashRegister) {
        this.salesLog = salesLog.getSalesLog();
        this.cashRegister = new CashRegister();
    }

    /**
     * A new sale is being created
     */
    public void startNewSale(){
        this.sale = new Sale();
    }


    public String SearchForItem(ItemDTO itemInformation, Amount quantity, int itemID) {
        if(itemCatalog.itemInStock(itemID)){
            Item newItem = itemCatalog.getItem(itemInformation, quantity, itemID);
            return sale.newSale(newItem) + ", quantity: " + quantity.toString() + 
                ", running total: " + totalSum();
        }

    }

    void checkforDiscount(int customerID) {}
    void pay(double amount) {}
    
}
