package se.kth.iv1350.module3.model;

/**
 *
 * @author ludwigflodin
 */
public class Item {
    private String name;
    private double price;
    private String desc;
    private int ID;  
    private double VAT;
    private int quantity;
    
    /**
     * 
     * @param itemId 
     */
    public Item(int itemId, double VAT, String desc, double price, String name){
        ID = itemId;
        this.name = name;
        this.price = price;
        this.VAT = VAT;
        this.desc = desc;
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
