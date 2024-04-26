package se.kth.iv1350.module3.model;

/**
 *
 * @author ludwigflodin
 */
public class DiscountEligibility {
    private boolean itemEligibility;
    private boolean totalPriceEligibility;
    private boolean idEligibility;
    
    public DiscountEligibility(boolean itemEligibility, boolean totalPriceEligibility, boolean idEligibility){
        this.idEligibility = idEligibility;
        this.itemEligibility = idEligibility;
        this.totalPriceEligibility = totalPriceEligibility;
    }
    
    public boolean getItemEligiblity(){
        return itemEligibility;
    }
    
    public boolean getTotalPriceEligiblity(){
        return totalPriceEligibility;
    }
    public boolean getidEligiblity(){
        return idEligibility;
    }
}
