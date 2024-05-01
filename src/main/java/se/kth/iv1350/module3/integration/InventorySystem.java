package se.kth.iv1350.module3.integration;

import static java.lang.Math.round;
import java.text.DecimalFormat;
import java.util.List;
import se.kth.iv1350.module3.model.Item;

/**
 *
 * @author ludwigflodin, antonHammar
 */
public class InventorySystem {
    private static final DecimalFormat decfor = new DecimalFormat("0.00"); 
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
    public Item getFakeItem(int ID, int quantity){
        Item item = new Item(0, 0, "", 0, "", 0);
        if (ID == 123){
           item = new Item(ID, 0.06, "Big oatmeal for the family", 59.99, "BigWheel Oatmeal", quantity);
        }
        else if (ID == 321){
           item = new Item(ID, 0.03, "YouGoGo Blueberry for the family", 39.99, "YouGoGo Blueberry", quantity);
        }
        
       printItemInfo(item);
       return item;
    }
    
    /**
     * does nothing
     * @param itemList 
     */
    public void sendInformation(List<Item> itemList){
        //best method
        System.out.println("Told external inventory system to decrease inventory quantity of items");
    }
    
    private void printItemInfo(Item item){
        System.out.println("Add " + item.getQuantity() + " item(s) with item id " + item.getID() + ":");
        System.out.println("Item ID: " + item.getID());
        System.out.println("Item name: " + item.getName());
        System.out.println("Item cost: " + item.getPrice() + " SEK");
        System.out.println("Vat: " + item.getVAT() + "%");
        System.out.println("Item description: " + item.getDesc());
        
        double vatPrice = item.getVatPrice();
        System.out.println("Total cost ( incl VAT ): " + (decfor.format((item.getItemTotalPrice()+vatPrice))) + " SEK");
        System.out.println("Total VAT: " + decfor.format(vatPrice) + " SEK\n");
        
        
    }
}
