package se.kth.iv1350.module3.integration;

import java.util.List;
import se.kth.iv1350.module3.model.Item;
import se.kth.iv1350.module3.model.ItemDTO;

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
     * @param quantity
     * @return 
     */
    public ItemDTO getFakeItem(int ID, int quantity){
        ItemDTO itemDTO = new ItemDTO(0, 0, "", 0, "", 0);
        if (ID == 123){
           itemDTO = new ItemDTO(ID, 0.06, "Big oatmeal for the family", 59.99, "BigWheel Oatmeal", quantity);
        }
        else if (ID == 321){
           itemDTO = new ItemDTO(ID, 0.03, "YouGoGo Blueberry for the family", 39.99, "YouGoGo Blueberry", quantity);
        }
        
       return itemDTO;
    }
    
    /**
     * does nothing
     * @param itemList 
     */
    public void sendInformation(List<Item> itemList){
        //best method
    }
}
