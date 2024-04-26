package se.kth.iv1350.module3.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import se.kth.iv1350.module3.controller.Controller;

/**
 *
 * @author Ludwig
 */
public class Sale {
    public ItemList ItemList = new ItemList();
    private LocalTime saleTime;
    private LocalDate saleDate;
    private Receipt receipt;
    private double runningTotal;
    
    /**
     * 
     * @return 
     */
    public List<Item> getItemList(){
        return ItemList.getList();
    }
    
    /**
     * 
     * @param price 
     */
    public void addToRunningTotal(double price){
        runningTotal += price;
    }
    
    /**
     * 
     * @return 
     */
    public double getRunningTotal(){
        return runningTotal;
    }
    /**
     * 
     */
    public Sale() {
      saleTime = LocalTime.now();
      receipt = new Receipt(saleTime, saleDate);
    }
    /**
     * 
     * @return 
     */
    public Receipt getReceipt(){
        return receipt;
    }
    
    
    
}
