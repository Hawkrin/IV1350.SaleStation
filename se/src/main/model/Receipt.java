package main.model;

import main.util.DateAndTime;
/**
 * Represents a reciept, which contains all info about the sale.
 */
public class Receipt {
    private Sale sale;
    private  DateAndTime saleTime = new DateAndTime();
    
   
    /**
     * Creates a new instance, representing a reciept
     * 
     * @param sale the information about the {@link Sale}
     */
    public Receipt(Sale sale){
        this.sale = sale;
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
        appendLine(builder, saleTime.getDateAndTime().toString());
        builder.append("\nItems Bought: \n\n");
        appendLine(builder, sale.getShoppingCart().toString());
        appendLine(builder, "\n*******RECIEPT END*******");
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
