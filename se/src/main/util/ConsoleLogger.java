package main.util;

/**
 * Prints Log messages to the console
 */
public class ConsoleLogger implements LogHandler {
    private static final ConsoleLogger CONSOLE_LOGGER = new ConsoleLogger();

    /**
     * Creates an instance of the FileLogger
     */
    private ConsoleLogger() {}

    /**
     * Gets the console logger
     * 
     * @return the console logger
     */
    public static ConsoleLogger getConsoleLogger() { return CONSOLE_LOGGER; }

    /**
     * Prints and logs the specified string to the console
     * 
     * @param message the string that will be output
     */
    @Override
    public void logException(Exception exception) {
        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("An Error Occured");
        logBuilder.append("\n @ " + getDateAndTime());
        logBuilder.append("\n and an Exception was thrown: ");
        logBuilder.append(exception.getMessage());
        System.out.println(logBuilder.toString());
        exception.printStackTrace(System.out);  
    }

    @Override
    public void log(String string) {}
        
}
    


