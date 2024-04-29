package se.kth.iv1350.module3.main;

import se.kth.iv1350.module3.controller.Controller;
import se.kth.iv1350.module3.integration.AccountingSystem;
import se.kth.iv1350.module3.integration.DiscountDatabase;
import se.kth.iv1350.module3.integration.InventorySystem;
import se.kth.iv1350.module3.model.ReceiptPrinter;
import se.kth.iv1350.module3.view.View;

/**
 * The class that is created when program starts
 * @param 
 * @author ludwigflodin, antonHammar
 */
public class Main {
    
/**
 * The main method for program, calls when program starts to initialize
 * @param args 
 */
    public static void main(String[] args){
    AccountingSystem acctSys = new AccountingSystem();
    InventorySystem invSys = new InventorySystem();
    DiscountDatabase disSys = new DiscountDatabase();
    ReceiptPrinter printer = new ReceiptPrinter();
    
    Controller contr = new Controller(invSys, disSys, acctSys, printer);
    View view = new View(contr);
    
    
   view.runFakeExecution();
    
    }
}
