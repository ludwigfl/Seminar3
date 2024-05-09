package se.kth.iv1350.module3.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author ludwigflodin, antonHammar
 */
public class SaleDTO {
    
    public ItemList itemList = new ItemList();
    private LocalTime saleTime;
    private LocalDate saleDate;
    private Receipt receipt;
    private double total;
    private double totalVAT;
    
    public SaleDTO(ItemList itemList, LocalTime saleTime, LocalDate saleDate, double total, double totalVAT) {
       
        for(Item item : itemList.getList()){
            this.itemList.addItem(item);
        }
       
        this.saleTime = saleTime;
        this.saleDate = saleDate;
        this.total = total;
        this.totalVAT = totalVAT;  
    }  
    
    /**
     * getter for itemlist
     * @return itemlist
     */
    public ItemList getitemList(){
        return itemList;
    }
    
    /**
     * getter for running total
     * @return running total
     */
    public double getTotal(){
        return total;
    }
    
    /**
     * getter for the RT's vat
     * @return RT's vat
     */
    public double getTotalVAT(){
        return totalVAT;
    }
}
