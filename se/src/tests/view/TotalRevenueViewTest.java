package tests.view;

import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import main.model.ObserverTemplateClass;
import main.model.Receipt;
import main.model.Sale;
import main.util.DateAndTime;
import main.view.TotalRevenueView;

public class TotalRevenueViewTest {
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;
    TotalRevenueView instance;
    Sale sale; 
    DateAndTime logTime;
    Receipt receipt;
    ObserverTemplateClass otc;
    
    @Before
    public void setUp() {
        sale = new Sale();
        logTime = new DateAndTime();
        receipt = new Receipt(sale);
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        instance = new TotalRevenueView();
    }

    @After
    public void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
        instance = null;
    }

    @Test
    public void testdoShowTotalIncome(){
        instance.doShowTotalIncome();
        String printout = outContent.toString();
        String expRes = "***************CONSOLE LOGGER****************" + "\n\n" +
        "A sale was made at: " + logTime.getDateAndTime() + "\n\n" +
        "Total Revenue After Sale: " +  "751.3599999999999" +
        "\n\n" +
        "*************CONSOLE LOGGER ENDS************\n";;          
        assertTrue("A wrong print out is made", printout.contains(expRes));
    }

    @Test
    public void testhandleErrors() {
        Exception exception = new Exception();
        instance.handleErrors(exception);
        String printout = outContent.toString();
        String expRes = "***************CONSOLE LOGGER****************\n\n" +
        "An error occured @ " + logTime.getDateAndTime() + "\n\n" +
        "The following happend: \n" + exception.getMessage() + "\n\n" +
        "*************CONSOLE LOGGER ENDS************\n";
        assertTrue("A wrong print out is made", printout.contains(expRes));

    }


}
