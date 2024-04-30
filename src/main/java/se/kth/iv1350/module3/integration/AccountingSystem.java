package se.kth.iv1350.module3.integration;

import static java.lang.Math.round;

/**
 *
 * @author ludwigflodin, antonHammar
 */
public class AccountingSystem {
    
    /**
     * does nothing
     * @param payment 
     */
    public void sendInformation(double payment){
        //best method
        System.out.println("Customer pays " + round(payment*100.0)/100.0 + " SEK");
        System.out.println("Sent sale info to external accounting system.");
    }
}
