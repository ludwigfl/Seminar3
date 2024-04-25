package se.kth.iv1350.module3.integration;
import se.kth.iv1350.module3.model.Item;

/**
 *
 * @author ludwigflodin
 */
public class InventorySystem {
    
    /**
     * 
     * @param itemId
     * @return 
     */
    public boolean itemExists(int itemId){
        return true;
    }
    
    /**
     * 
     * @param ID
     * @return 
     */
    public Item getFakeItem(int ID){
       Item item = new Item(ID);
       
       return item;
    }
    
}
