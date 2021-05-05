package controller;

import integration.*;
import model.*;
import util.Amount;
import model.Summary;

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
     * 
     * @param catalogHandler gets the classes that handels communication with databases.
     * @param systemHandler gets the classes that handels communication with external systems.
     * @param recieptPrinter gets reciept printer
     * @param salesLog gets the saleslog
     * @param cashRegister gets the current balance in the cashRegister
     */
    public Controller(CatalogHandler catalogHandler, SystemHandler systemHandler, RecieptPrinter recieptPrinter, SalesLog salesLog) {  
        this.itemCatalog = catalogHandler.getItemCatalog();
        this.discountCatalog = catalogHandler.getDiscountCatalog();
        this.inventorySystem = systemHandler.getInventorySystem();
        this.accountingSystem = systemHandler.getAccountingSystem();
        this.salesLog = salesLog;
        this.recieptPrinter = recieptPrinter;
        this.cashRegister = new CashRegister();
    }

    /**
     * A new sale is being created
     */
    public void startNewSale(){
        this.sale = new Sale();
    }

    /**
     * Search for the requested item
     * 
     * @param itemInformation the iteminformation represented as a DTO {@link ItemDTO}
     * @param quantity how many examples of an item to purchase {@link Amount}
     * @param itemID the item number
     * @return returns the result to the sale methbod registerItems
     */
    public String searchForItem(ItemDTO itemInformation, Amount quantity, int itemID) {
        if(itemCatalog.itemInStock(itemID)){
            Item newItem = itemCatalog.getItem(itemInformation, quantity, itemID);
            return sale.updateItems(newItem) + ", quantity: " + quantity.toString() + 
                ", Price Summary: " + displaySummary();
        }
        return "Price Summary: " + displaySummary();
    }

    /**
     * Displays the total price to pay
     * 
     * @return the summary displayed as a string
     */
    public String displaySummary() {
        return "the total price after taxes are: " + 
        sale.getSummary().getSummary().toString();
    }

    /**
     * A payment of an {@link Amount} is made, all external systems are updated, a reciept
     * is being printed
     * 
     * @param amount the amount given by the customer
     * @return the change to give back to the customer displayed as a string
     */
    public String salePayment(Amount paidAmount) {
        Payment payment = new Payment(paidAmount, sale.getSummary());
        Reciept reciept = new Reciept(sale);
        accountingSystem.updateAccounting(sale);
        inventorySystem.updateInventory(sale);
        recieptPrinter.printReciept(reciept);
        cashRegister.addPayment(payment);
        salesLog.updateSalesLog(sale);

        return "Change: " + payment.getChange().toString();
    }
    
}
