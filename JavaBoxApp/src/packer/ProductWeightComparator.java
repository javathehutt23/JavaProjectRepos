package packer;

import java.util.Comparator;

/**
 *
 * @author Harry Furnish
 * @version 1.0
 * This is used when we need to sort by product weight descending
 */
public class ProductWeightComparator implements Comparator<Product> {
    /**
     * compare provides a simple sort of two products returning a value for greater than or less than weight 
     * @param a product to compare weight
     * @param b product to compare weight
     * @return int comparison of weight of product a to product b
     */
    public int compare(Product a, Product b) {
        if (a.getWeight() < b.getWeight()) {return 1;}
        else if (a.getWeight() > b.getWeight()) {return -1;}
        else return a.getName().compareTo(b.getName());
    }
                
}
