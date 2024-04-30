package se.kth.iv1350.module3.controller;

import static java.lang.Math.round;
import se.kth.iv1350.module3.integration.AccountingSystem;
import se.kth.iv1350.module3.model.Sale;
import se.kth.iv1350.module3.model.Item;
import se.kth.iv1350.module3.integration.InventorySystem;
import se.kth.iv1350.module3.model.Receipt;
import se.kth.iv1350.module3.integration.DiscountDatabase;
import se.kth.iv1350.module3.model.Discount;
import se.kth.iv1350.module3.model.DiscountEligibility;
import se.kth.iv1350.module3.model.ReceiptPrinter;


/**
 * Class of controller to handle layer communication
 * @author ludwigflodin, antonHammar
 */
public class Controller {
    private Sale sale;
    final private InventorySystem invSys;
    final private DiscountDatabase disSys;
    final private AccountingSystem acctSys;
    final private ReceiptPrinter printer;
    
    /**
     * Constructor of controller to create instance of controller
     * @param invSys the inventory system
     * @param disSys the discount system
     * @param acctSys the accounting system
     */
    public Controller(InventorySystem invSys, DiscountDatabase disSys, AccountingSystem acctSys){
       this.invSys = invSys;
       this.disSys = disSys;
       this.acctSys = acctSys;
       this.printer = new ReceiptPrinter();
   }
    
   /**
    * Handle the 3 different discounts ( ͡° ͜ʖ ͡°)
    * @param customerId identifier of the customer
    */
    public void handleDiscount(int customerId){
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
     * Request the discount from view
     * @param customerId identifier of the customer
     */
    public void requestDiscount(int customerId){
        handleDiscount(customerId);
    }
    
    /**
     * Creates sale object
     */
   public void startSale(){
       sale = new Sale();
   }
   
   /**
    * Gets the sale object
    * @return the sale
    */
   public Sale getSale(){
       return sale;
   }

   /**
    * Responsible for scanning item checks for item
    * @param itemId The items identifier
    * @param quantity The amount of a single type of item
    * @return 
    */
    public void scanItem(int itemId, int quantity){
       
        boolean itemExists = invSys.itemExists(itemId);
        
        if(itemExists){ 
            editItemList(quantity, itemId);
        }
         
    }
    
    /**
     * Adds item or quantity of specific item type to list
     * @param quantity The amount of a single type of item
     * @param itemId The items identifier
     */
    private void editItemList(int quantity, int itemId){
        Item item = sale.ItemList.getItem(itemId); 
            
        if(item != null){
           item.increaseQuantity(quantity); 
           sale.addToRunningTotal(item);
           sale.addToTotalVat(item.getVatPrice());
        }
        else{
            item = invSys.getFakeItem(itemId, quantity);
            sale.addToRunningTotal(item);
            sale.addToTotalVat(item.getVatPrice());
            sale.ItemList.addItem(item); 
        }
    }
    
    
    /**
     * Handles all things necessary for end of sale 
     * @param payment the amount of money customer pays for sale
     */
    public void endSale(double payment){
        
        System.out.println("End sale:\nTotal cost ( incl VAT ): " + round((sale.getTotalVat() + sale.getRunningTotal())*100.0)/100.0  + " SEK\n");
        
        sendSaleInformation();
        handleReceipt(payment);
        
    }
    
    /**
     * Handles all the things necessary for receipt 
     * @param payment the amount of money customer pays for sale
     */
    private void handleReceipt(double payment){
        Receipt receipt = getSale().getReceipt();
        receipt.update(getSale().getItemList(), payment, sale.getTotalVat());
        printer.printReceipt(receipt);
    }
    
    /**
     * Sends information of sale to external inventory and accounting system
     */
    private void sendSaleInformation(){
        invSys.sendInformation(sale.getItemList());
        acctSys.sendInformation(sale.getRunningTotal() + sale.getTotalVat());
    }
}
