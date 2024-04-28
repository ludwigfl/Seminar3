package se.kth.iv1350.module3.model;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author ludwigflodin, antonHammar
 */
public class SaleTest {
     Sale instanceToTest;
    
    public SaleTest() {
    }
    
    @BeforeEach
    public void setUp() {
        instanceToTest = new Sale();
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;
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
    
    /*
    @Test
    public void testAddToRunningTotal() {
        double price = 0.0;
        Sale instance = new Sale();
        instance.addToRunningTotal(price);
    }
    */
    
    @Test
    public void testCalculateRunningTotal() {
        double expResult = 0;
        for(Item item : instanceToTest.getItemList()){
            expResult += item.getPrice(); 
        double result = instanceToTest.calculateRunningTotal();
        assertEquals(expResult, result, "Different running total values, oh no!");
        }
    }

    /*
        @Test
        public void testGetReceipt() {
        Sale instance = new Sale();
        Receipt expResult = null;
        Receipt result = instance.getReceipt();
        assertEquals(expResult, result);
    }
    */
    
}
