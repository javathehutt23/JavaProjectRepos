package packer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Harry Furnish
 * @version 1.0
 */
public class Manifest {
    
    // This tracks the quantity if each product in the manifest
    private Map<Product, Integer> quantities;
    // This keeps a list of all products ordered by weight
    private Set<Product> byWeight;

    public Manifest() {
        quantities = new HashMap<>();
        byWeight = new TreeSet<>(new ProductWeightComparator());
    }
    /**
     * 
     * @param p product to be add to manifest
     */
    public void addProduct(Product p) {
        addProduct(p,1);
    }
    /**
     * 
     * @param p product to be added to manifest
     * @param quantity number of products to be added to manifest
     */
    public void addProduct(Product p, int quantity) {
        if (quantities.containsKey(p)) {
            quantities.put(p,quantities.get(p)+quantity);
        }
        else {
            quantities.put(p,quantity);
            if(!byWeight.add(p)) {
                System.out.println("Couldn't add to Set");
            }
        }
    }
    /**
     * 
     * @param p product to be removed from manifest
     */
    public void removeProduct(Product p) {
        if (quantities.containsKey(p) && quantities.get(p) > 0) {
            quantities.put(p,quantities.get(p)-1);
        }
        if (quantities.get(p) == null) {
            quantities.remove(p);
        }
        if (quantities.containsKey(p) && quantities.get(p) == 0) {
            byWeight.remove(p);
        }
    }
    /**
     * 
     * @return double total weight of products in manifest
     */
    public double getTotalWeight() {
        double weight = 0;
        double totalWeight = 0;
        for (Product p : quantities.keySet()) {
            weight = quantities.get(p) * p.getWeight();
            totalWeight += weight;
        }
        return totalWeight;
    }
    /**
     * 
     * @param weight double weight of product 
     * @return product weighing less than weight input
     */
    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() <= weight) {
                return p;
            }
        }
        return null;
    }
    /**
     * 
     * @return boolean is or is not empty
     */
    public boolean isEmpty() {
        return byWeight.isEmpty();
    }
    /**
     * 
     * @param p product to be searched for in manifest
     * @return boolean product is or is not in manifest
     */
    public boolean containsProduct(Product p) {
        return quantities.containsKey(p) && quantities.get(p) > 0;
    }
    /**
     * 
     * @return string manifest contents
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product p : quantities.keySet()) {
            result.append(p.getName());
            result.append(" x ");
            result.append(quantities.get(p));
            result.append("\n");
        }
        return result.substring(0, result.length()-1);
    }
    /**
     * 
     * @return boolean manifest contains or does not contain fragile products
     */
    public boolean hasFragileItems() {
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                return true;
            }
        }
        return false;
    }
    /**
     * 
     * @return boolean manifest contains or does not contain fragile products
     */
    public boolean hasHazardousItems() {
        for (Product p : quantities.keySet()) {
            if (p.isHazardous()) {
                return true;
            }
        }
        return false;
    }
/*
    double getWeight() {
        double a = 0;
        for (Product p : quantities.keySet()){
            a = p.getWeight();
            return a;
    }
        return a;
    }*/
}
    

