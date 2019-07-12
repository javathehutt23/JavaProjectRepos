package packer;

/**
 *
 * @author Harry Furnish
 */
public class Depot {
    private String name;
    private Address address;
    /**
     * Depot clas holds details of the depot from which the package and box will be dispatched
     * @param name name of depot
     * @param address address of depot
     */
    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    /**
     * getName provides the depot name
     * @return string depot name
     */
    public String getName() {
        return name.toString();
    }
    /**
     * getCordinates provides the geographic coordinates of the depot
     * @return coordinates of depot 
     */
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    /**
     * toString provides the deport name 
     * @return string name of depot
     */
    public String toString() {
        return this.getName();
    }
    
}
