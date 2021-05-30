package tests.view;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;
import main.view.TotalRevenueFileOutput;


public class TotalRevenueFileOutputTest {
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;
    TotalRevenueFileOutput instance;
    private static final String NAME_OF_LOG_FILE = "TotalRevenueFile.txt";
    private PrintWriter logFile;
    
    @Before
    public void setUp() {
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
    @Test
    public void testTotalRevenueFileConstructor() throws IOException {
        try {
            logFile = new PrintWriter(new FileWriter(NAME_OF_LOG_FILE), false);
        }
        catch(IOException exception){
            System.out.println("Could not create logger.");
            exception.printStackTrace();
        }
        
    }

}
