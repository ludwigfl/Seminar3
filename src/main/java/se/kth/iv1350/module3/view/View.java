package se.kth.iv1350.module3.view;

import se.kth.iv1350.module3.controller.Controller;
import se.kth.iv1350.module3.model.Receipt;
import se.kth.iv1350.module3.model.Sale;

/**
 *
 * @author Ludwig
 */
public class View {
     
    private Controller contr;
    
    /**
     * 
     * @param contr 
     */
    public View( Controller contr){
        this.contr = contr;
    }
    
    /**
     * 
     */
    public void runFakeExecution(){
        contr.startSale();
        System.out.println("A new sale has been started. ");
        contr.scanItem(123, 2); //123 temp itemID, 2 temp number of item
        //contr.re
        Receipt receipt = contr.getSale().getReceipt();
        receipt.update(contr.getSale().getItemList(), 420);
        contr.printReceipt(receipt);
    }
    
    
}
