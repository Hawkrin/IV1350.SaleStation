package main.controller;

import java.util.ArrayList;
import java.util.List;
import main.integration.*;
import main.model.*;
import main.util.Amount;

/**
 * This is the applications only controller, all calls to the model passes through
 * this class
 */
public class Controller {
    private Sale sale;
    private CashRegister cashRegister;
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private ItemCatalog itemCatalog;
    private DiscountCatalog discountCatalog;
    private SalesLog salesLog;
    private ReceiptPrinter receiptPrinter;
    private List<PaymentObserver> paymentObservers = new ArrayList<>();

    /**
     * Creates a new instance instance of the catalogs and systems
     * 
     * @param catalogHandler gets the classes that handels communication with databases.
     * @param systemHandler gets the classes that handels communication with external systems.
     * @param recieptPrinter gets reciept printer
     * @param salesLog gets the saleslog
     * @param cashRegister gets the current balance in the cashRegister
     */
    public Controller(CatalogHandler catalogHandler, SystemHandler systemHandler, ReceiptPrinter receiptPrinter, SalesLog salesLog) {  
        this.itemCatalog = catalogHandler.getItemCatalog();
        this.discountCatalog = catalogHandler.getDiscountCatalog();
        this.inventorySystem = systemHandler.getInventorySystem();
        this.accountingSystem = systemHandler.getAccountingSystem();
        this.salesLog = salesLog;
        this.receiptPrinter = receiptPrinter;
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
     * @param quantity how many examples of an item to purchase {@link Amount}
     * @param itemID the item number
     * @return returns the result to the sale method registerItems
     * @throws InvalidIDException if the itemID doesn't exist in the database
     * @throws OperationFailedException catches the InvalidIDException
     * @throws IllegalStateException if the method is called on before the sale is inititated.
     */
    public String registerItem(int itemID, Amount quantity) throws InvalidIDException, OperationFailedException {
        if (sale == null){
            throw new IllegalStateException("Call to registerItem was made before initiating a new sale.");
        }
        try {
            Item newItem = itemCatalog.getItem(itemID, quantity);
            return sale.updateItems(newItem) + "\nItem Quantity: " + quantity.toString() + "\nPrice Summary: " + displaySummary();
        }
        catch(CatalogException CataExc) {
            throw new OperationFailedException("Could not find the requested Item.", CataExc);
        }    
    }

    /**
     * Displays the total price to pay
     * 
     * @return the summary displayed as a string
     * @throws IllegalStateException If this method is called before <code>startNewSale</code>
     */
    public String displaySummary() throws IllegalStateException {
        if (sale == null){
            throw new IllegalStateException("displaySummary was called before a new sale was initiated.");
        }
        return sale.getSummary().getSummary().toString();
    }

    /**
     * A payment of an {@link Amount} is made, all external systems are updated, a reciept
     * is being printed
     * 
     * @param amount the amount given by the customer
     * @return the change to give back to the customer displayed as a string
     * @throws IllegalStateException If this method is called before <code>startNewSale</code>
     */
    public String salePayment(Amount paidAmount) throws IllegalStateException {
        if (sale == null){
            throw new IllegalStateException("salePayment was called before a new sale was initiated.");
        }
        Payment payment = new Payment(paidAmount, sale.getSummary());
        Receipt receipt = new Receipt(sale);
        accountingSystem.updateAccounting(sale);
        inventorySystem.updateInventory(sale);
        receiptPrinter.printReceipt(receipt);
        cashRegister.addPayment(payment);
        salesLog.updateSalesLog(sale);
        payment.addPaymentObservers(paymentObservers);

        return "Change to return: " + payment.getChange().toString();
    }

    /**
     * The specified observer will be notified when a payment is made.
     * 
     * @param observers The observers to notify.
     */
    public void addPaymentObserver(PaymentObserver obs) {
        paymentObservers.add(obs);
    }   
}
