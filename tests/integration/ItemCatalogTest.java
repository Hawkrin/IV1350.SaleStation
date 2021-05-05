package tests.integration;

import src.util.Amount;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;

public class ItemCatalogTest {
    private src.integration.Item testItem;

    @BeforeEach
    void setUp() {
        testItem = new src.integration.Item(new src.integration.ItemDTO("Nails", new Amount(50), new Amount(0.06), 11112), new Amount(5));
    }

    @AfterEach
    void tearDown() {
        testItem = null;
    }
    

}
