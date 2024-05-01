package se.kth.iv1350.module3.integration;

import java.text.DecimalFormat;

/**
 *
 * @author ludwigflodin, antonHammar
 */
public class AccountingSystem {
    private static final DecimalFormat decfor = new DecimalFormat("0.00");
    
    /**
     * does nothing
     * @param payment 
     */
    public void sendInformation(double payment){
        //best method
        System.out.println("Customer pays " + decfor.format(payment) + " SEK");
        System.out.println("Sent sale info to external accounting system.");
    }
}
