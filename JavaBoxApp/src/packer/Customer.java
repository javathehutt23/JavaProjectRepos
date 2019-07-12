package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Harry Furnish
 * @version 1.0
 */
public class Customer {
    
    private String name;
    private List<Address> addresses;
    /**
     * Customer class provide the customer details used to label and dispatch boxes
     * @param name customer name
     * @param address customer address
     */
    public Customer(String name, Address address) {
        addresses = new ArrayList<>();
        this.name = name;
        this.addresses.add(address);
    }
    /**
     * addAddress to a customer object
     * @param address add customer address
     */
    public void addAddress(Address address) {
        this.addresses.add(address);
    }
    /**
     * getName of customer
     * @return string customer name
     */
    public String getName() {
        return name;
    }
/**
 * getClosestAddressTo gets the closest customer address to a depot for customers with more than one address
 * @param d depot to deliver from
 * @return address the closest address to the depot
 */
    public Address getClosestAddressTo(Depot d) {
        double bestDistance = Double.MAX_VALUE;
        Address bestAddress = null;
        for (Address a : addresses) {
            double distance = a.getCoordinates().companyDistanceTo(d.getCoordinates());
            if (distance < bestDistance) {
                bestAddress = a;
                bestDistance = distance;
            }
        }
        return bestAddress;
    }
    /**
     * toString gets the name of the customer
     * @return string name of customer
     */
    public String toString() {
        return this.getName();
    }
}
