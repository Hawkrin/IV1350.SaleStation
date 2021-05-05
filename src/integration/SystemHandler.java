package integration;
/**
 * This class initiates all external systems
 */
public class SystemHandler {
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;

    /**
     * Creates a system handler
     */
    public SystemHandler() {
        this.accountingSystem = new AccountingSystem();
        this.inventorySystem = new InventorySystem();
    }
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
