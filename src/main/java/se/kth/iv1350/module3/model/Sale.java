package se.kth.iv1350.module3.model;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 *The class for the sale that contains the information for the sale
 * @author ludwigflodin, antonHammar
 */
public class Sale {
    public ItemList itemList = new ItemList();
    private LocalTime saleTime;
    private LocalDate saleDate;
    private Receipt receipt;
    private SaleDTO saleInfo;
    private double runningTotal;
    private double runningTotalVAT;
    
    
    /**
     * Constructor for sale 
     */
    public Sale() {
      saleTime = LocalTime.now();
      saleDate = LocalDate.now();
      receipt = new Receipt(saleTime, saleDate);
    }
    
    public Item createListItem(ItemDTO itemDTO){
        Item item = new Item(itemDTO);
        return item;
    }
    
     /**
     * Adds item or quantity of specific item type to list
     * @param itemDTO The item that is looked for 
     */
    public void editItemList(ItemDTO itemDTO){ 
         Item item = createListItem(itemDTO); 
        if(item.getQuantity() > 0){
            if(itemList.checkforId(item)){
               itemList.increaseQuantityOfItem(item);
               addToRunningTotal(item);
               addToTotalVat(item.getVatPrice());
            }
            else{

                addToRunningTotal(item);
                addToTotalVat(item.getVatPrice());
                itemList.addItem(item); 
            }
        }
    }
    
    /**
     * creates the saleDTO at the end of the sale
     * @param payment the customers payment
     */
    public void createSaleDTO(double payment){
        this.saleInfo = new SaleDTO(itemList, saleTime, saleDate, runningTotal, runningTotalVAT, payment);
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
    public ReceiptDTO getReceiptDTO(){
        return new ReceiptDTO(receipt);
    }
    
    public void updateReceipt(double payment){
        receipt.update(saleInfo.getitemList().getList(), payment, runningTotalVAT);
    }
    
    /**
     * getter for the total price with vat applied
     * @return runningTotal RunningTotalVAT
     */
    public double getTotalWithVat(){
        return runningTotal + runningTotalVAT;
    }
}
