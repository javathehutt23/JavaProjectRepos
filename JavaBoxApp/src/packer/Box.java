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
     * Box holds details of a manifest of products  contained and the customer and depot to be used for dispatch
     * @param customer customer details for box label
     * @param depot depot details for box label
     */
    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }
    /**
     * addProduct adds products into the manifest of items to contained in a box
     * @param product product to be added into box
     */
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }
    
    /**
     * addProduct (quantity) checks if the box has space to contain a product based on the defined capacity
     * @param product product to be added into box
     * @param quantity quantity of product to be added into box
     */
    
    public void addProduct(Product product, int quantity) {
        if (canFit(product,quantity)); {
            contents.addProduct(product, quantity);
        }
    }
   /**
    * getLabel provides a string cotent of the the box and the customer and depot details
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
     * getLabel provides a string cotent of the the box and the customer and depot details
     * @return string label details
     */
    public String toString() {
        return getLabel();
    }
    /**
     * getTotalWeight provide the total calculated weight of all products in the box manifest multiplying weight by quantity
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
     * canFit checks if a nominated product fit into a box of given capacity
     * @param p product to be tested to see if will fit in box
     * @return boolean can or cannot fit in box
     */
    public boolean canFit(Product p) {
        return p.getWeight() < Capacity - this.getTotalWeight();
    }
    /**
     * canFit checks if a nominated product fit into a box of given capacity based on quantity * weight 
     * @param p product to be tested to see if will fit in box
     * @param quantity integer number of product items to be fitted in box
     * @return boolean can or cannot fit all products in box
     */
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) < Capacity - this.getTotalWeight();
    }
    /**
     * remainingcapacity provide the avaiable unused capcity in the box
     * @return double amount of weight capacity remaining in box
     */
    public double remainingCapacity() {
        return Capacity - this.getTotalWeight();
    }
    /**
     * isFragile confirms whether box contains fragile products
     * @return boolean contains or does not contain fragile product 
     */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    /**
     *  isHazardous confirms whether box contains hazardous products
     * @return boolean contains or does not contain hazardous product
     */
    public boolean isHazardous() {
        return contents.hasHazardousItems();
    }
    /**
     * isHeavy confirms if a box is considered heavy based on weight capacity
     * @return boolean box is considered or not consider heavy
     */
    public boolean isHeavy(){
        return this.getTotalWeight() >= 15;
    }

}
