package se.kth.iv1350.module3.model;

/**
 *Class for specific item, a type of product in the store 
 * @author ludwigflodin, antonHammar
 */
public class Item {
    private String name;
    private double price;
    private String desc;
    private int ID;  
    private double VAT;
    private int quantity;
    
    /**
     * Constructor for specific item, a type of product in the store
     * @param itemId
     * @param VAT
     * @param desc
     * @param price
     * @param name 
     */
    public Item(int itemId, double VAT, String desc, double price, String name){
        ID = itemId;
        this.name = name;
        this.price = price;
        this.VAT = VAT;
        this.desc = desc;
        quantity = 1;
    }
    
    /**
     * Gets the price of the item
     * @return the price of item
     */
    public double getPrice(){
        return price;
    }
    
    /**
     * Gets the vat of the item
     * @return the vat of the item
     */
    public double getVAT(){
        return VAT;
    }
    
    /**
     * gets the id of the item
     * @return the id of the item
     */
     public int getID(){
        return ID;
    }
     /**
      * increases the quantity of the specific type of item
      * @param amount the amount of the type of item
      */
     public void increaseQuantity(int amount){
         quantity = quantity + amount;
     }
}
