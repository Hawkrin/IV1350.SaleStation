package controller;

import integration.*;
import model.*;

public class Controller {

    private Sale sale;
    private Reciept reciept;
    private CashRegister cashRegister;
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private ItemIdentifier itemIdentifier;
    private DiscountCatalog discountCatalog;
    private SalesLog salesLog;
    private RecieptPrinter recieptPrinter;

    /**
     * Creates a new instance
     * 
     */
    public Controller(CatalogHandler catalogHandler) {
         
    }

    /**
     * A new sale is being created
     */
    public void startNewSale(){
        this.sale = new Sale();
    }

    
    void searchForItem(int itemID, int itemQuantity) {}
    void checkforDiscount(int customerID) {}
    void pay(double amount) {}
    void controller() {}  //parametrar saknas
    
}
