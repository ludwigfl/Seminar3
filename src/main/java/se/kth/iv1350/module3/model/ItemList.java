package se.kth.iv1350.module3.model;
import java.util.ArrayList;
import java.util.List;
/**
 *The class for the list of items in the sale 
 * @author ludwigflodin, antonHammar
 */
public class ItemList {
   final private List<Item> listOfItems = new ArrayList<>(); 
    
   /**
    * Gets the item from the list based on item id 
    * @param itemId the identifier of a specific type of item
    * @return the wanted item it found or null if item isn't found
    */
    public Item getItem(int itemId){
        for(Item item : listOfItems){
            if(itemId == item.getID()){
              return item;
            }
        }
        return null;
    }
    
    /**
     * Adds the specific item to the list 
     * @param item the specific type of item
     */
    public void addItem(Item item){
        listOfItems.add(item);
    }
    
    /**
     * Gets the list of items 
     * @return the list of items
     */
    public List<Item> getList(){
        return listOfItems;
    }
}
