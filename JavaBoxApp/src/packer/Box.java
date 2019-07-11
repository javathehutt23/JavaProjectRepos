package packer;

/**
 *
 * @author Harry Furnish
 * @version 1.0
 */
public class Box {
    
    
    private Manifest contents;
    private Customer customer;
    private Depot depot;
    private double Capacity = 21;
    /**
     * 
     * @param customer customer details for box label
     * @param depot depot details for box label
     */
    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }
    /**
     * 
     * @param product product to be added into box
     */
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }
    
    /**
     * 
     * @param product product to be added into box
     * @param quantity quantity of product to be added into box
     */
    
    public void addProduct(Product product, int quantity) {
        if (canFit(product,quantity)); {
            contents.addProduct(product, quantity);
        }
    }
   /**
    * 
    * @return string containing customer/depot details and box contents warning label details
    */
    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        label.append("\n");
        if (this.isFragile()) {
            label.append("FRAGILE\n");
        }
        if (this.isHazardous()){
            label.append("HAZARDOUS\n");
        }
        if (this.isHeavy()){
            label.append("HEAVY\n");
        }
        
        return label.toString();
    }
    /**
     * 
     * @return string label details
     */
    public String toString() {
        return getLabel();
    }
    /**
     * 
     * @return double total weight of box contents
     */
    public double getTotalWeight() {
        return contents.getTotalWeight();
    }
    
/*    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }
    */
    /**
     * 
     * @param p product to be tested to see if will fit in box
     * @return boolean can or cannot fit in box
     */
    public boolean canFit(Product p) {
        return p.getWeight() < Capacity - this.getTotalWeight();
    }
    /**
     * 
     * @param p product to be tested to see if will fit in box
     * @param quantity integer number of product items to be fitted in box
     * @return boolean can or cannot fit all products in box
     */
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) < Capacity - this.getTotalWeight();
    }
    /**
     * 
     * @return double amount of weight capacity remaining in box
     */
    public double remainingCapacity() {
        return Capacity - this.getTotalWeight();
    }
    /**
     * 
     * @return boolean contains or does not contain fragile product 
     */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    /**
     * 
     * @return boolean contains or does not contain hazardous product
     */
    public boolean isHazardous() {
        return contents.hasHazardousItems();
    }
    /**
     * 
     * @return boolean box is considered or not consider heavy
     */
    public boolean isHeavy(){
        return this.getTotalWeight() >= 15;
    }

}
