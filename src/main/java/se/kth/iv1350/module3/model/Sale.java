package se.kth.iv1350.module3.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


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
    private double runningTotalVAT;
    
    /**
     * Constructor creates instance of a sale 
     */
    public Sale() {
      saleTime = LocalTime.now();
      saleDate = LocalDate.now();
      receipt = new Receipt(saleTime, saleDate);
    }
    
    /**
     * Gets the list of items currently added to the list
     * @return the list of items
     */
    public List<Item> getItemList(){
        return ItemList.getList();
    }
    
    public double getTotalVat(){
        return runningTotalVAT;
    }
    
    public void addToTotalVat(double vat){
        runningTotalVAT += vat;
    }
    
    /**
     * Adds the price of an item to the running total of the sale
     * @param item the item which price is added to running total
     */
    public void addToRunningTotal(Item item){
        runningTotal += item.getPrice() * item.getQuantity();
    }
    
    /**
     * Gets the current total price
     * @return the current total price
     */
    public double getRunningTotal(){
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
