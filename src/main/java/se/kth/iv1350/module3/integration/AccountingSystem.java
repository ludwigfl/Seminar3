package se.kth.iv1350.module3.integration;

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
        System.out.println("Customer pays " + payment + " SEK");
        System.out.println("Sent sale info to external accounting system.");
    }
}
