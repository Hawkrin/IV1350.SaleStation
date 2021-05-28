package tests.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import main.view.TotalRevenueFileOutput;


public class TotalRevenueFileOutputTest {
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;
    TotalRevenueFileOutput instance;
    
    @Before
    public void setUp() {
        instance = new TotalRevenueFileOutput();
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
        instance = null;
    }

    public void testTotalRevenueFileOutputConstructor() {
        //instance.TotalRevenueFileOutput();

    }
    
}
