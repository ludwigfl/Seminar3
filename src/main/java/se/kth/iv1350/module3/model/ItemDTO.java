package se.kth.iv1350.module3.model;

/**
 *
 * @author ludwigflodin, antonhammar
 */
public class ItemDTO {
    
    private String name;
    private double price;
    private String desc;
    private int ID;  
    private double VAT;
    private int quantity;
    
    /**
     * Constructor for specific item, a type of product in the store
     * @param itemId the item's identifier
     * @param VAT the item's vat 
     * @param desc the item's description
     * @param price the item's price 
     * @param name the item's name
     * @param quantity the amount of the item
     */
    public ItemDTO(int itemId, double VAT, String desc, double price, String name, int quantity){
        this.ID = itemId;
        this.name = name;
        this.price = price;
        this.VAT = VAT;
        this.desc = desc;
        this.quantity = quantity;
    }
    
    /**
     * gets the name of the item
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Gets the price of the item
     * @return the price of item
     */
    public double getPrice(){
        return price;
    }
    
    /**
     * gets the items description
     * @return desc
     */
    public String getDesc(){
        return desc;
    }
    
    /**
     * Gets the vat of the item
     * @return the vat of the item
     */
    public double getVAT(){
        return VAT;
    }
   
    
    /**
     * Gets the quantity of an item in list 
     * @return the amount of items
     */
    public int getQuantity(){
        return quantity;
    }
    
    /**
     * gets the id of the item
     * @return the id of the item
     */
     public int getID(){
        return ID;
    }

}

