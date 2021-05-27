package main.model;

/**
 * An abstract class which contains a template method.
 */
public abstract class ObserverTemplateClass implements PaymentObserver {
    private Summary totalRevenue = new Summary();

    /**
     * This method is implemented from the PaymentObserver interface
     */
    @Override
    public void updateTotal(Summary  summary) {
        calculateTotalIncome(summary);
        showTotalIncome ();
    }

    private void showTotalIncome () {
        try {
            doShowTotalIncome ();
        } 
        catch (Exception exception) {
            handleErrors(exception);
        }
    }

    /**
     * The  total  amount  paid  since  the  program  started.
     * 
     * @param summary the summary of a recent purchase
     */
    public void calculateTotalIncome(Summary summary) {
        totalRevenue.updateTotal(summary);
    }
  
    /**
     * Get the calculated income
     * 
     * @return the calculated income
     */
    public Summary getCalculatedIncome(){ return totalRevenue; }

    /**
     * Shows total income after a sale
     * 
     * @throws Exception if a sale hasn't been made
     */
    protected  abstract  void  doShowTotalIncome () throws Exception;

    /**
     * Displays an error if a sale cant be done
     * 
     * @param exception if an error occured which stopped the sale
     */
    protected  abstract  void  handleErrors(Exception exception);
}
