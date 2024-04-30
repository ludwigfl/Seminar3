package se.kth.iv1350.module3.integration;

import java.util.List;
import se.kth.iv1350.module3.model.Discount;
import se.kth.iv1350.module3.model.Item;
import se.kth.iv1350.module3.model.DiscountEligibility;

/**
 *
 * @author ludwigflodin, antonHammar
 */
public class DiscountDatabase {
    
    /**
     * 
     * @param itemList
     * @return 
     */
    public Discount getItemDiscount(List<Item> itemList){
        Discount discount = new Discount(20, 0.9);
        return discount;
    }
    
    /**
     * 
     * @param totalPrice
     * @return 
     */
    public Discount getTotalPriceDiscount(double totalPrice){
        Discount discount = new Discount(20, 0.9);
        return discount;
    }
    
    /**
     * 
     * @param customerId
     * @return 
     */
    public Discount getCustomerDiscount(int customerId){
        Discount discount = new Discount(20, 0.9);
        return discount;
    }
    
    /**
     * 
     * @param customerId
     * @return 
     */
    public DiscountEligibility checkEligibility(int customerId){
        DiscountEligibility eligibility = new DiscountEligibility(true, true, true);
        return eligibility;
    }
  
    
    
    
}
