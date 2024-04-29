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
     * Updates the information in the receipt
     * @param itemList the list of items during the sale
     * @param payment the payment from the customer
     */
    public void update(List<Item> itemList, double payment){
        this.itemList = itemList;
        this.payment = payment; 
        calculateTotalVAT();
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
    private void calculateTotalVAT(){
        for(Item item : itemList){
            totalVAT += item.getVAT()*item.getPrice(); 
        }
    }
    
    /**
     * calculates the total price based on advanced algorithm with price of items and old total price
     */
    private void calculateTotalPrice(){
        for(Item item : itemList){
            totalPrice += item.getPrice(); 
        }
    }
    
    public List<Item> getItemList(){
        return itemList;
    }
    
}
