package main.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
/**
 * Represents a reciept, which contains all info about the sale.
 */
public class Receipt {
    private Sale sale;
    LocalDateTime timeofSale = LocalDateTime.now();
   
    /**
     * Creates a new instance, representing a reciept
     * 
     * @param sale the information about the {@link Sale}
     */
    public Receipt(Sale sale){
        this.sale = sale;
    }

    /**
     * Gets the date and time of today
     * 
     * @return the date and time of today
     */
    public String getDateAndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return timeofSale.format(formatter); 
    } 

    /**
     * Creates an exampel reciept.
     *
     * @return a receipt displayed as a string.
     */
    public String createReceipt() {
        StringBuilder builder = new StringBuilder();
        appendLine(builder, "********RECIEPT*********\n");
        builder.append("Purchase was made: ");
        appendLine(builder, getDateAndTime().toString());
        builder.append("\nItems Bought: \n\n");
        appendLine(builder, sale.getShoppingCart().toString());
        appendLine(builder, "\n*******RECIEPT END******");
        endSection(builder);
        return builder.toString();
    }  

    private void appendLine(StringBuilder builder, String newLine) {
        builder.append(newLine);
        builder.append("\n");
    }

    private void endSection(StringBuilder builder) {
        builder.append("\n");
    }
    
}
