package se.kth.iv1350.module3.model;

/**
 *
 * @author ludwigflodin
 */
public class Discount {
   
    
    private double sumToBeReduced;
    private double percentageToBeReduced;
    
     public Discount(double kr, double percentage){
         this.sumToBeReduced = kr;
         this.percentageToBeReduced = percentage;
         
     }
    
    /**
     * 
     * @return 
     */
    public double getsumToBeReduced(){
        return sumToBeReduced;
    }
    
    /**
     * 
     * @return 
     */
    public double getpercentageToBeReduced(){
        return sumToBeReduced;
    }
    
    
    
}
