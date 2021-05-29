package tests.view;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import main.view.TotalRevenueFileOutput;


public class TotalRevenueFileOutputTest {
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;
    TotalRevenueFileOutput instance;
    
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

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void totalRevenueFileCreationTest() throws IOException {
        exception.expect(IOException.class);
        InputStream in = createMock(InputStream.class);
        expect(in.read()).andThrow(IOException.class);
        replay(in);
        instance = new TotalRevenueFileOutput();
    }
    
}
