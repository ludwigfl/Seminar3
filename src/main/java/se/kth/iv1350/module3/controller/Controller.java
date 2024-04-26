package se.kth.iv1350.module3.controller;

import se.kth.iv1350.module3.model.Sale;
import se.kth.iv1350.module3.model.Item;
import se.kth.iv1350.module3.integration.InventorySystem;
import se.kth.iv1350.module3.model.Receipt;
import se.kth.iv1350.module3.integration.DiscountDatabase;
import se.kth.iv1350.module3.model.Discount;
import se.kth.iv1350.module3.model.DiscountEligibility;


/**
 *
 * @author Ludwig
 */
public class Controller {
    private Sale sale;
    final private InventorySystem invSys;
    final private DiscountDatabase disSys;
    
    /**
     * 
     * @param invSys 
     */
    public Controller(InventorySystem invSys, DiscountDatabase disSys){
       this.invSys = invSys;
       this.disSys = disSys;
   }
    
   /**
    * Would be really nice if we had a database!!1! ( ͡° ͜ʖ ͡°)
    * @param customerId 
    */
    public void discountHandler(int customerId){
        DiscountEligibility eligible = disSys.checkEligibility(customerId);
        if(eligible.getItemEligiblity()){
           Discount itemDiscount = disSys.getItemDiscount(sale.getItemList());
        }
        if(eligible.getTotalPriceEligiblity()){
            Discount totalPriceDiscount = disSys.getTotalPriceDiscount(sale.getRunningTotal());
        }
        if(eligible.getidEligiblity()){
            Discount idPriceDiscount = disSys.getCustomerDiscount(customerId);
        }
        
    }
    
    /**
     * 
     */
   public void startSale(){
       sale = new Sale();
   }
   
   public Sale getSale(){
       return sale;
   }

   /**
    * 
    * @param itemId
    * @param quantity
    * @return 
    */
    public String scanItem(int itemId, int quantity){
        String returnMessage = "";
        boolean itemExists = invSys.itemExists(itemId);
        
        if(itemExists){ 
            editItemList(quantity, itemId);
        }
        else{
            returnMessage = "Item does not exist";
        }
        return returnMessage;   
    }
    
    /**
     * 
     * @param quantity
     * @param itemId 
     */
    private void editItemList(int quantity, int itemId){
        Item item = sale.ItemList.getItem(itemId); 
            
        if(item != null){
           item.increaseQuantity(quantity); 
           sale.addToRunningTotal(item.getPrice());
        }
        else{
            item = invSys.getFakeItem(itemId);
            sale.addToRunningTotal(item.getPrice());
            sale.ItemList.addItem(item); 
        }
    }
    
    /**
     * 
     * @param receipt 
     */
    public void printReceipt(Receipt receipt){
        System.out.println(receipt);
    }
}
