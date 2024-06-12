package se.kth.iv1350.module3.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author ludwigflodin antonHammar
 */
/**
 * The class for the receipt that contains information of the sale
 * @author ludwigflodin, antonHammar
 */
public class ReceiptDTO {
    private List<Item> itemList;
    private double totalPrice;
    private double totalVAT;
    private double payment;
    private double change;
    private LocalTime time;
    private LocalDate date;
    
    /**
     * Constructor for the receipt
     * @param receipt the receipt of the sale
     */
    public ReceiptDTO(Receipt receipt){
        itemList = receipt.getItemList();
        totalPrice = receipt.getTotalPrice();
        totalVAT = receipt.getTotalVat();
        payment = receipt.getPayment();
        change = receipt.getChange();
        time = receipt.getTime();
        date = receipt.getDate();
    } 
    
    /**
     * gets the local time of the sale
     * @return time
     */
    public LocalTime getTime(){
        return time;
    }
    
    /**
     * gets the payment from receipt
     * @return payment
     */
    public double getPayment(){
        return payment;
    }
    
    /**
     * gets the local date of the sale
     * @return date
     */
    public LocalDate getDate(){
        return date;
    }
    
    
    /**
     * gets the change from receipt
     * @return change
     */
    public double getChange(){
        return change;
    }
    
    /**
     * gets the total price of including total vat
     * @return total price + total vat
     */
    /*public double getTotalVatPrice(){
        return totalPrice+totalVAT;
    }*/
    
    /**
     * gets the total vat from receipt
     * @return totalVAT
     */
    public double getTotalVat(){
        return totalVAT;
    }
    
    /**
     * returns the total price of the sale
     * @return price
     */
    public double getTotalPrice(){
        return totalPrice;
    }
    
    /**
     * gets the list of items 
     * @return itemList
     */
    public List<Item> getItemList(){
        return itemList;
    }
    
}
