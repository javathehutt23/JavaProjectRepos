package packer;

/**
 *
 * @author Harry Furnish
 * @version 1.0
 */
public class Product {

    private String name;
    private int weight;
    private boolean hazardous;
    private boolean fragile;
    /**
     * Product class hold product details 
     * @param name product name
     * @param weight product weight
     * @param hazardous product hazardous indicator
     * @param fragile  product fragile indicator
     */
    public Product(String name, int weight, boolean hazardous, boolean fragile) {
        this.name = name;
        this.weight = weight;
        this.hazardous = hazardous;
        this.fragile = fragile;
    }

    /**
	 * 
     * @return int product weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @return string product name
     */
    public String getName() {
        return name;
    }

    /**
     * @return boolean product is or is not hazardous
     */
    public boolean isHazardous() {
        return hazardous;
    }

    /**
     * @return boolean product is or is not fragile
     */
    public boolean isFragile() {
        return fragile;
    }
    /**
     * 
     * @return string product name
     */
    public String toString() {
        return this.getName();
    }
    /**
     * Equals provides comparison of this product to another product
     * @param o product object 
     * @return boolean object is equal to product
     */
    public boolean equals(Object o) {
        if (!(o instanceof Product)) {
            return false;
        }
        Product p = (Product)o;
        return p.getName().equals(this.getName());
    }
    
}
