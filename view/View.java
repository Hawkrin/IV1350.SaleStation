package view;

import controller.Controller;

/**
 * represents the user interface
 */
public class View {

    private Controller ctrl;

    /**
     * Creates a new instance
     * 
     * @param ctrl The controller that is used for all operations
     */
    public View(Controller ctrl) {
        this.ctrl = ctrl;
    }
    
}
