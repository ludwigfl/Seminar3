package se.kth.iv1350.module3.controller;

import se.kth.iv1350.module3.model.Sale;
import se.kth.iv1350.module3.model.Item;
import se.kth.iv1350.module3.integration.InventorySystem;
import se.kth.iv1350.module3.model.Receipt;


/**
 *
 * @author Ludwig
 */
public class Controller {
    private Sale sale;
    final private InventorySystem invSys;
    
    /**
     * 
     * @param invSys 
     */
    public Controller(InventorySystem invSys){
       this.invSys = invSys;
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
        }
        else{
            sale.ItemList.addItem(invSys.getFakeItem(itemId)); 
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
