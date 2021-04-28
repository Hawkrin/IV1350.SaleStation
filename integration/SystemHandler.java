package integration;
/**
 * This class initiates all external systems
 */
public class SystemHandler {
    private InventorySystem inventorySystem = new InventorySystem();
    private AccountingSystem accountingSystem = new AccountingSystem();

    /**
     * Get the value of the inventorySystem
     * @return the value of the inventorySystem
     */
    public InventorySystem getInventorySystem() {
        return inventorySystem;
    }

    /**
     * Get the value of the accountingSystem
     * @return the value of the accountingSystem
     */
    public AccountingSystem getAccountingSystem() {
        return accountingSystem;
    }
    
    
}
