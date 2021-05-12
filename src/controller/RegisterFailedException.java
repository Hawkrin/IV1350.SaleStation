package src.controller;

/**
 * Thrown if the controller fails while registering items
 */
public class RegisterFailedException extends Exception {
    
    /**
    * Creates a new instance with a specified message
    *
    * @param
    */
    public RegisterFailedException(String msg) {
        super(msg);
    }
}
