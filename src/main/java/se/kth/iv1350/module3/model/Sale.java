package se.kth.iv1350.module3.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import se.kth.iv1350.module3.controller.Controller;

/**
 *The class for the sale that contains the information for the sale
 * @author ludwigflodin, antonHammar
 */
public class Sale {
    public ItemList ItemList = new ItemList();
    private LocalTime saleTime;
    private LocalDate saleDate;
    private Receipt receipt;
    private double runningTotal;
    
    /**
     * Constructor creates instance of a sale 
     */
    public Sale() {
      saleTime = LocalTime.now();
      receipt = new Receipt(saleTime, saleDate);
    }
    
    /**
     * Gets the list of items currently added to the list
     * @return the list of items
     */
    public List<Item> getItemList(){
        return ItemList.getList();
    }
    
    /**
     * Adds the price of an item to the running total of the sale
     * @param price the price of the item
     */
    public void addToRunningTotal(double price){
        runningTotal += price;
    }
    
    /**
     * Gets the current total price
     * @return the current total price
     */
    public double calculateRunningTotal(){
        return runningTotal;
    }
    
    /**
     * Gets the receipt of the sale 
     * @return the receipt 
     */
    public Receipt getReceipt(){
        return receipt;
    }
}
