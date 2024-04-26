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
       Item item = new Item(ID, 0.06, "hej svej", 59.99, "BigWheel Oatmeal");
       
       return item;
    }
    
}
