package se.kth.iv1350.module3.model;

/**
 *
 * @author ludwigflodin
 */
public class Item {
    private double price;
    private String desc;
    private int ID;  
    private double VAT;
    private int quantity;
    
    /**
     * 
     * @param itemId 
     */
    public Item(int itemId){
        ID = itemId;
        quantity = 1;
    }
    
    public double getPrice(){
        return price;
    }
    public double getVAT(){
        return VAT;
    }
    
    /**
     * 
     * @return 
     */
     public int getID(){
        return ID;
    }
     /**
      * 
      * @param amount 
      */
     public void increaseQuantity(int amount){
         quantity = quantity + amount;
     }
}
