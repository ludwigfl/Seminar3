package se.kth.iv1350.module3.view;

import se.kth.iv1350.module3.controller.Controller;
import se.kth.iv1350.module3.model.Item;
import se.kth.iv1350.module3.model.SaleDTO;
import java.text.DecimalFormat;

/**
 * The view class, represents the user interface
 * @author ludwigflodin, antonHammar
 */
public class View {
     
    final private Controller contr;
    private final DecimalFormat decfor;
    double payment;
    
    /**
     * Constructor that creates the instance of view 
     * @param contr controller variable which handles communication between layers
     */
    public View( Controller contr){
        this.contr = contr;
        decfor = new DecimalFormat("0.00");
        payment = 400;
    }
    
    private void printInfo(SaleDTO saleInfo, double payment){
        
        System.out.println("End sale:\nTotal cost ( incl VAT ): " + decfor.format((saleInfo.getTotal()+ saleInfo.getTotalVAT()))  + " SEK\n");

        for(Item item : saleInfo.itemList.getList()){
        
        System.out.println("Add " + item.getQuantity() + " item(s) with item id " + item.getID() + ":");
        System.out.println("Item ID: " + item.getID());
        System.out.println("Item name: " + item.getName());
        System.out.println("Item cost: " + item.getPrice() + " SEK");
        System.out.println("Vat: " + item.getVatForPrintOut()+ "%");
        System.out.println("Item description: " + item.getDesc());
        
        double vatPrice = item.getVatPrice();
        System.out.println("Total cost ( incl VAT ): " + (decfor.format((item.getItemTotalPrice()+vatPrice))) + " SEK");
        System.out.println("Total VAT: " + decfor.format(vatPrice) + " SEK\n");
        }
        
        System.out.println("Customer pays " + decfor.format(payment) + " SEK");
        System.out.println("Told external inventory system to decrease inventory quantity of items");
        System.out.println("Sent sale info to external accounting system.");
        
    }
    
    /**
     * runs a fake execution of a sale
     */
    public void runFakeExecution(){
        contr.startSale();
        System.out.println("A new sale has been started. \n");
        contr.scanItem(123, 2); //123 temp itemID, 2 temp number of item
        contr.scanItem(321, 5); //123 temp itemID, 2 temp number of item
        contr.requestDiscount(1); //1 temp customerId
        SaleDTO saleInfo = contr.endSale(payment);
        printInfo(saleInfo,payment);
    }
    
    
}
