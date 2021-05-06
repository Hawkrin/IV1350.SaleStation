package src.model;

import java.time.LocalDateTime;
/**
 * Represents a reciept, which contains all info about the sale.
 */
public class Receipt {
    private Sale sale;
   
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
        appendLine(builder, "Store Purchase");
        endSection(builder);

        LocalDateTime purchaseMadeAtTime = LocalDateTime.now();
        builder.append("Purchase Made: ");
        appendLine(builder, purchaseMadeAtTime.toString());
        endSection(builder);

        builder.append("Items Bought: ");
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
