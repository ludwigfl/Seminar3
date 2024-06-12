package se.kth.iv1350.module3.view;

import java.text.DecimalFormat;
import se.kth.iv1350.module3.controller.Controller;
import se.kth.iv1350.module3.model.Item;
import se.kth.iv1350.module3.model.ItemDTO;
import se.kth.iv1350.module3.model.SaleDTO;


/**
 * The view class, represents the user interface
 * @author ludwigflodin, antonHammar
 */
public class View {
     
    final private Controller contr;
    double payment;
    
    /**
     * Constructor that creates the instance of view 
     * @param contr controller variable which handles communication between layers
     */
    public View( Controller contr){
        this.contr = contr;
        payment = 400;
    }
    
     /**
      * formats the item info to a string
      * @return the string with the item info
      */
     private String toStringItem(ItemDTO itemDTO){
         final DecimalFormat decfor = new DecimalFormat("0.00");
         
         double vatPrice = itemDTO.getPrice()*itemDTO.getVAT()*itemDTO.getQuantity();
         
         return "Add " + itemDTO.getQuantity() + " item(s) with item id " + itemDTO.getID() + ":"
         +"\nItem ID: " + itemDTO.getID()  
         +"\nItem name: " + itemDTO.getName() 
         +"\nItem cost: " + itemDTO.getPrice() + " SEK"
         +"\nVat: " + itemDTO.getVAT()*100+ "%"
         +"\nItem description: " + itemDTO.getDesc()
         +"\nTotal cost ( incl VAT ): " + decfor.format((itemDTO.getPrice()*itemDTO.getQuantity()) + vatPrice) + " SEK" 
         +"\nTotal VAT: " + decfor.format(vatPrice) + " SEK\n";
     }
     
     /**
     * formats the end sale info to a string
     * @return the string for printout of the end sale info
     */
    public String toStringSale(SaleDTO saleInfo){
        DecimalFormat decfor = new DecimalFormat("0.00");
        return 
        "End sale:"
        +"\nTotal cost ( incl VAT ): " + decfor.format(saleInfo.getTotal() + saleInfo.getTotalVAT())  + " SEK"
        +"\nCustomer pays " + decfor.format(saleInfo.getPayment()) + " SEK"
        +"\nTold external inventory system to decrease inventory quantity of items"
        +"\nSent sale info to external accounting system.";
    }
    
    /**
     * runs a fake execution of a sale
     */
    public void runFakeExecution(){
        ItemDTO itemDTO;
        contr.startSale();
        System.out.println("A new sale has been started. \n");
        itemDTO = contr.scanItem(123, 2); //123 temp itemID, 2 temp number of item
        System.out.println(toStringItem(itemDTO)); //Leif approved of this method :)
        itemDTO = contr.scanItem(321, 5); //123 temp itemID, 2 temp number of item
        System.out.println(toStringItem(itemDTO)); //Leif approved of this method :)
        contr.requestDiscount(1); //1 temp customerId
        SaleDTO saleInfo = contr.endSale(payment);
        System.out.println(toStringSale(saleInfo)); //Leif approved of this method :)
    }    
}
