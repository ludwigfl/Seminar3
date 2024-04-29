package se.kth.iv1350.module3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ludwigflodin
 */
public class ItemTest {
    private Item instance;
    
    public ItemTest() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new Item(123, 0.06, "Big oatmeal for the family", 59.99, "BigWheel Oatmeal", 500000);
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /* @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Item instance = null;
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }
    */

    
    /* @Test
    public void testGetVAT() {
        System.out.println("getVAT");
        Item instance = null;
        double expResult = 0.0;
        double result = instance.getVAT();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }
    */

    /* @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Item instance = null;
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    */
    
    /* @Test
    public void testGetID() {
        System.out.println("getID");
        Item instance = null;
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    */
    
    @Test
    public void testIncreaseQuantity() {
        
        int expResult = 500002;
        int result;
        instance.increaseQuantity(2);
        result = instance.getQuantity();
        assertEquals(expResult, result, "Different increase in quantity values, skill issue");
    }
    
}
