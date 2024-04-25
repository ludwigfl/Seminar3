package se.kth.iv1350.module3.model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ludwigflodin
 */
public class ItemList {
   final private List<Item> listOfItems = new ArrayList<>();
 
        
   /*  public boolean itemInList(int itemId){
    *    return getItem(itemId) != null;
    *  }
    */  
    
   /**
    * 
    * @param itemId
    * @return 
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
     * 
     * @param item 
     */
    public void addItem(Item item){
        listOfItems.add(item);
    }
    
    public List<Item> getList(){
        return listOfItems;
    }
  
}
