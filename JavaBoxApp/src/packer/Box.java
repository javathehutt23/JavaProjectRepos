package packer;

/**
 *
 * @author I.M.Bad
 */
public class Box {
    
    
    private Manifest contents;
    private Customer customer;
    private Depot depot;
    private double Capacity = 20;

    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }
    
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }
    
    
    
    public void addProduct(Product product, int quantity) {
        if (canFit(product,quantity)); {
            contents.addProduct(product, quantity);
        }
    }
   
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
    
    public String toString() {
        return getLabel();
    }
    
    public double getTotalWeight() {
        return contents.getTotalWeight();
    }
    
/*    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }
    */
    public boolean canFit(Product p) {
        return p.getWeight() < Capacity - this.getTotalWeight();
    }
    
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) < Capacity - this.getTotalWeight();
    }
    
    public double remainingCapacity() {
        return Capacity - this.getTotalWeight();
    }
    
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    
    public boolean isHazardous() {
        return contents.hasHazardousItems();
    }
    public boolean isHeavy(){
        return this.getTotalWeight() >= 15;
    }

}
