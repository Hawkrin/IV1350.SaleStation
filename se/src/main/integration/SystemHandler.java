package main.integration;
/**
 * This class initiates all external systems. Created as a singelton
 */
public class SystemHandler {
    private static final SystemHandler INSTANCE = new SystemHandler();
    private InventorySystem inventorySystem = new InventorySystem();
    private AccountingSystem accountingSystem = new AccountingSystem();

    private SystemHandler() {}
    
    /**
     * Gets the instance of a SystemHandler
     * 
     * @return The <code>SystemHandler</code>
     */
    public static SystemHandler getSystemHandler(){ return INSTANCE; }
       
    /**
     * Get the value of the inventorySystem
     * 
     * @return the value of the inventorySystem
     */
    public InventorySystem getInventorySystem() { return inventorySystem; }

    /**
     * Get the value of the accountingSystem
     * 
     * @return the value of the accountingSystem
     */
    public AccountingSystem getAccountingSystem() { return accountingSystem; }
    
}
