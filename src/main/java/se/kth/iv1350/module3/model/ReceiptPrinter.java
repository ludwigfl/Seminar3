package se.kth.iv1350.module3.model;

import static java.lang.Math.abs;
import static java.lang.Math.round;
import java.time.LocalTime;

/**
 *Class for printing the receipt of the sale
 * @author ludwigflodin, antonHammar
 */
public class ReceiptPrinter {
    
    /**
     * Prints the receipt
     * @param receipt the receipt with all the sale information
     */
    public void printReceipt(Receipt receipt){
        LocalTime time = receipt.getTime();
        time = time.plusMinutes(1).minusNanos(1).withSecond(0).withNano(0);
        double total = 0;
        double totvat = 0;
        double change = 0;
        
        System.out.println("------------------------------------ Begin receipt ------------------------------------");
        System.out.println("Time of Sale: " + receipt.getDate().toString() + " " + time.toString());
        
        for(Item item : receipt.getItemList()){
           System.out.println(item.getName() + "        " + item.getQuantity() + " x " + item.getPrice() + "   " + round(item.getItemTotalPrice()*100.0)/100.0 + " SEK");
           totvat += item.getVatPrice();
           total += item.getItemTotalPrice();
        }
         change = abs(total - receipt.getPayment());
         System.out.println("Total: " + round(total*100.0)/100.0 + " SEK");
         System.out.println("VAT: " + round(totvat*100.0)/100.0 + " SEK");
         System.out.println("Cash: " + receipt.getPayment() + " SEK");
         System.out.println("Change: " + round(receipt.getChange()*100.0)/100.0 + " SEK");
         System.out.println("------------------------------------ End receipt ------------------------------------");
         System.out.println("Change to give to customer: " + round(receipt.getChange()*100.0)/100.0 + " SEK");
         
    }
}
