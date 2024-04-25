package se.kth.iv1350.module3.model;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;


/**
 *
 * @author Ludwig
 */
public class Receipt {
    private List<Item> itemList;
    private double totalPrice;
    private double totalVAT;
    private double payment;
    private double change;
    private LocalTime time;
    private LocalDate date;
    
    public Receipt(LocalTime saleTime, LocalDate saleDate){
        this.time = saleTime;
        this.date = saleDate;
    }
   
  /**
   * 
   * @return 
   */
    public double getTotalPrice(){
        return totalPrice;
    }
    
    /**
     * 
     * @param currentTotal 
     */
    public void setTotal(double currentTotal){
        this.totalPrice += currentTotal;
    }
    
    /**
     * 
     * @return 
     */
    public double getTotalVAT(){
        return totalVAT;
    }
    
    /**
     * unclear how this works, fix later!!!
     * @param totalVAT 
     */
    public void setTotalVAT(double totalVAT){ 
        this.totalVAT = totalVAT; 
    }
    
    /**
     * 
     * @param itemList
     * @param payment 
     */
    public void update(List<Item> itemList, double payment){
        this.itemList = itemList;
        this.payment = payment; 
        calculateTotalVAT();
        calculateTotalPrice();
        calculateChange();
    }
    
      /**
       * 
       */
    private void calculateChange(){
        change = payment - totalPrice;
    }
    
    /**
     * 
     */
    private void calculateTotalVAT(){
        for(Item item : itemList){
            totalVAT += item.getVAT()*item.getPrice(); 
        }
    }
    
    /**
     * 
     */
    private void calculateTotalPrice(){
        for(Item item : itemList){
            totalPrice += item.getPrice()+totalPrice; 
        }
    } 
}
