package se.kth.iv1350.module3.model;

import static java.lang.Math.round;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.module3.controller.Controller;
import se.kth.iv1350.module3.integration.AccountingSystem;
import se.kth.iv1350.module3.integration.DiscountDatabase;
import se.kth.iv1350.module3.integration.InventorySystem;



/**
 *
 * @author ludwigflodin, antonHammar
 */
public class SaleTest {
     private ItemDTO item1;
     
     private Item itemToTest;
     private Controller controllerToTest;
     private InventorySystem invSys;
     private DiscountDatabase disSys;
     private AccountingSystem acctSys;
     private Sale sale;
    
    
    public SaleTest() {
    }
    
    @BeforeEach
    public void setUp() {
        invSys = new InventorySystem();
        disSys = new DiscountDatabase();
        acctSys = new AccountingSystem();
        controllerToTest = new Controller(invSys, disSys, acctSys);
        controllerToTest.startSale();
        sale = new Sale();
        item1 = new ItemDTO(123, 0.06, "Big oatmeal for the family", 59.99, "BigWheel Oatmeal", 50); 
        itemToTest = new Item(item1);
        

    }
    
    @AfterEach
    public void tearDown() {
        controllerToTest = null;
        itemToTest = null;
        invSys = null;
        disSys = null;
        acctSys = null;
        item1 = null;
    }
    
    /*
    @Test
    public void testGetItemList() {
        Sale instance = new Sale();
        List<Item> expResult = null;
        List<Item> result = instance.getItemList();
        assertEquals(expResult, result);
    }
    */
    
    
    @Test
    public void testAddToRunningTotal() {
        double expResult =2999.5;
        sale.addToRunningTotal(itemToTest);
         
        double result = sale.getRunningTotal();
        assertEquals(expResult, result, "Different running total values in addToRunningTotal, oh no!");

    }
   
    
   
    @Test
    public void testAddToTotalVAT() {
        double expResult = 179.97;
        sale.addToTotalVat(item1.getPrice()*item1.getVAT()*item1.getQuantity());
         
        double result = sale.getTotalVat();
                
        assertEquals(expResult, result, "Different total VATs, oh no!");
        
    }

    
}
