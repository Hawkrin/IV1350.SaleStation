package tests.view;

import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import main.util.DateAndTime;
import main.view.ErrorMessageHandler;



public class ErrorMessageHandlerTest {
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;
    ErrorMessageHandler instance;
    String string;
    DateAndTime errorTime;

    @Before
    public void setUp() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        instance = new ErrorMessageHandler();
        string = new String();
        errorTime = new DateAndTime();
    }

    @After
    public void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
        instance = null;
    }

    @Test
    public void testDisplayErrorMessage(){
        instance.displayErrorMessage(string);
        String printout = outContent.toString();
        String expRes = "******WARNING******\n" +
                        errorTime.getDateAndTime() + "\n" +
                        "ERROR OCCURED " + "\n" +
                        string + "\n" +
                        "*******************";
        assertTrue("A wrong print out is made", printout.contains(expRes));
    }  

}
