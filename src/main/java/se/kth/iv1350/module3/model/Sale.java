package se.kth.iv1350.module3.model;

import java.time.LocalDate;
import java.time.LocalTime;
import se.kth.iv1350.module3.integration.InventorySystem;


/**
 *The class for the sale that contains the information for the sale
 * @author ludwigflodin, antonHammar
 */
public class Sale {
    public ItemList ItemList = new ItemList();
    private LocalTime saleTime;
    private LocalDate saleDate;
    private Receipt receipt;
    private SaleDTO saleInfo;
    private double runningTotal;
    private double runningTotalVAT;
    final private InventorySystem invSys;
    
    /**
     * Constructor for sale 
     * @param invSys 
     */
    public Sale(InventorySystem invSys) {
      saleTime = LocalTime.now();
      saleDate = LocalDate.now();
      receipt = new Receipt(saleTime, saleDate);
      this.invSys = invSys;
    }
    
     /**
     * Adds item or quantity of specific item type to list
     * @param quantity The amount of a single type of item
     * @param itemId The items identifier
     */
    public void editItemList(int quantity, int itemId){
        Item item = ItemList.getItem(itemId); 
            
        if(item != null){
           item.increaseQuantity(quantity); 
           addToRunningTotal(item);
           addToTotalVat(item.getVatPrice());
        }
        else{
            item = invSys.getFakeItem(itemId, quantity);
            addToRunningTotal(item);
            addToTotalVat(item.getVatPrice());
            ItemList.addItem(item); 
        }
    }
    
    /**
     * creates the saleDTO at the end of the sale
     */
    public void createSaleDTO(){
        this.saleInfo = new SaleDTO(this.ItemList, this.saleTime, this.saleDate, this.runningTotal, this.runningTotalVAT);
    }
    
    /**
     * gets the sale information through DTO 
     * @return saleInfo
     */
    public SaleDTO getSaleInfo(){
        return saleInfo;
    }
    
    /**
     * gets the total VAT 
     * @return running total vat
     */
    public double getTotalVat(){
        return runningTotalVAT;
    }
    
    /**
     * adds to the total vat 
     * @param vat the vat of the item
     */
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
