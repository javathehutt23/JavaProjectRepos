/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author harry
 */
public class PackerTest {
    
    Address depotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
        Depot depot = new Depot("Main Depot", depotAddress);

        Address customerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
        Address customerAddress2 = new Address("88 Camp Mine St", "Ridgeway", "Lowe Valley", "I998", new Coordinates(100, 34));
        Customer customer = new Customer("Andy Bravo", customerAddress1);
        
        Manifest manifest = new Manifest();
    
    @Before    
        public void setup(){
        customer.addAddress(customerAddress2);
        manifest.addProduct(new Product("Hammer", 3, false, false), 1);
        manifest.addProduct(new Product("Nails", 1, false, false), 12);
        manifest.addProduct(new Product("Ladder", 15, false, false), 2);
        manifest.addProduct(new Product("Saw", 5, false, false), 1);
        manifest.addProduct(new Product("Light Bulbs", 1, false, true), 20);
        manifest.addProduct(new Product("Weedkiller", 2, true, false), 1);
        
        }

    /**
     * Test of packProducts method, of class Packer.
     */
    @Test
    public void testPackProducts() {
        System.out.println("\nMANIFEST (to be packed):");
        System.out.println(manifest);

        System.out.println("\nPACKING:");
        List<Box> done = Packer.packProducts(customer, depot, manifest);
        for (Box b : done) {
            System.out.println(b);
    }
    }
    
}
