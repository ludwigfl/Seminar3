package se.kth.iv1350.module3.view;

import se.kth.iv1350.module3.controller.Controller;
import se.kth.iv1350.module3.model.Receipt;
import se.kth.iv1350.module3.model.Sale;

/**
 * The view class, represents the user interface
 * @author ludwigflodin, antonHammar
 */
public class View {
     
    private Controller contr;
    
    /**
     * Constructor that creates the instance of view 
     * @param contr controller variable which handles communication between layers
     */
    public View( Controller contr){
        this.contr = contr;
    }
    
    /**
     * runs a fake execution of a sale
     */
    public void runFakeExecution(){
        contr.startSale();
        System.out.println("A new sale has been started. ");
        contr.scanItem(123, 2); //123 temp itemID, 2 temp number of item
        contr.requestDiscount(1); //1 temp customerId
        contr.endSale(420); //420 temp payment
    }
    
    
}
