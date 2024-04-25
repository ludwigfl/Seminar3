package se.kth.iv1350.module3.main;

import se.kth.iv1350.module3.controller.Controller;
import se.kth.iv1350.module3.integration.AccountingSystem;
import se.kth.iv1350.module3.integration.InventorySystem;
import se.kth.iv1350.module3.view.View;

/**
 * @param 
 * @author Ludwig
 */
public class Main {
    
/**
 * @param 
 * 
 */
    public static void main(String[] args){
    AccountingSystem acctSys = new AccountingSystem();
    InventorySystem invSys = new InventorySystem();
    
    Controller contr = new Controller(invSys);
    View view = new View(contr);
    
    
   view.runFakeExecution();
    
    }
}
