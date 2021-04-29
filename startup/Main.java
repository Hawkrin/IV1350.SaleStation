package startup;

import controller.Controller;
import integration.SystemHandler;
import view.View;

/**
 * Contains the <code>main</code> method. Performs all startup of the application.
 */
public class Main {
    /**
     * Starts the application
     * @param args no command line parameters are taken
     */
    public static void main(String[] args) {
        SystemHandler systemhandler = new SystemHandler();
        Controller ctrl = new Controller(systemhandler);
        

    }
    
}
