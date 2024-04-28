package se.kth.iv1350.module3.model;

    /**
    *Class for handling the discount eligibility of customer
    * @author ludwigflodin, antonHammar
    */
    public class DiscountEligibility {
    private boolean itemEligibility;
    private boolean totalPriceEligibility;
    private boolean idEligibility;
    
    /**
     * Constructor that creates the object that stores the discount eligibility of customer
     * @param itemEligibility the individual item discount 
     * @param totalPriceEligibility the total price of sale discount
     * @param idEligibility the specific id discount 
     */
    public DiscountEligibility(boolean itemEligibility, boolean totalPriceEligibility, boolean idEligibility){
        this.idEligibility = idEligibility;
        this.itemEligibility = idEligibility;
        this.totalPriceEligibility = totalPriceEligibility;
    }
    
    /**
     * Returns the item discount eligibility of a customer
     * @return 
     */
    public boolean getItemEligiblity(){
        return itemEligibility;
    }
    /**
     * Returns the total price discount eligibility of a customer
     * @return 
     */
    public boolean getTotalPriceEligiblity(){
        return totalPriceEligibility;
    }
    
    /**
     * Returns the customer id discount eligibility of a customer
     * @return 
     */
    public boolean getidEligiblity(){
        return idEligibility;
    }
}
