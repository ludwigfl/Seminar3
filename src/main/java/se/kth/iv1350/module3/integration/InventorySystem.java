package se.kth.iv1350.module3.integration;
import java.util.List;
import java.util.ArrayList;
import se.kth.iv1350.module3.model.Item;

/**
 *
 * @author ludwigflodin, antonHammar
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
       Item item = new Item(ID, 0.06, "Big oatmeal for the family", 59.99, "BigWheel Oatmeal");
       
       return item;
    }
    
    /**
     * does nothing
     * @param itemList 
     */
    public void sendInformation(List<Item> itemList){
        //best method
    }
}
