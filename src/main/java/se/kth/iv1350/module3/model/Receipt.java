package se.kth.iv1350.module3.model;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;


/**
 * The class for the receipt that contains information of the sale
 * @author ludwigflodin, antonHammar
 */
public class Receipt {
    private List<Item> itemList;
    private double totalPrice;
    private double totalVAT;
    private double payment;
    private double change;
    private LocalTime time;
    private LocalDate date;
    
    /**
     * Constructor for the receipt
     * @param saleTime the time of the sale in local time 
     * @param saleDate the date of the sale in local date
     */
    public Receipt(LocalTime saleTime, LocalDate saleDate){
        this.time = saleTime;
        this.date = saleDate;
    } 
    
    /**
     * gets the local time of the sale
     * @return time
     */
    public LocalTime getTime(){
        return time;
    }
    
    /**
     * gets the local date of the sale
     * @return date
     */
    public LocalDate getDate(){
        return date;
    }
    
    /**
     * Updates the information in the receipt
     * @param itemList the list of items during the sale
     * @param payment the payment from the customer
     * @param totalVAT the vat for the whole sale
     */
    public void update(List<Item> itemList, double payment, double totalVAT){
        this.itemList = itemList;
        this.payment = payment; 
        this.totalVAT = totalVAT;
        calculateTotalPrice();
        calculateChange();
    }
    
     /**
     * Calculates the change based on advanced algorithm with payment and total price
     */
    private void calculateChange(){
        change = payment - totalPrice;
    }
    
    /**
     * calculates the total VAT based on advanced algorithm with price and vat of items
     */
    /*private void calculateTotalVAT(){
        for(Item item : itemList){
            totalVAT += item.getVAT()*item.getPrice(); 
        }
    }*/
    
    /**
     * calculates the total price based on advanced algorithm with price of items and old total price
     */
    private void calculateTotalPrice(){
        for(Item item : itemList){
            totalPrice += item.getPrice(); 
        }
    }
    
    public double getTotalVatPrice(){
        return totalPrice+totalVAT;
    }
    
    public List<Item> getItemList(){
        return itemList;
    }
    
}
