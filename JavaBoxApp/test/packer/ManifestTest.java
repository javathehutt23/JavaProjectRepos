/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

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
public class ManifestTest {
    Manifest testManifest1 = new Manifest();
    Manifest testManifest2 = new Manifest();
    Manifest testManifest3 = new Manifest();
    
    Product testProducta1 = new Product("Alpha1", 0, true, true);
    Product testProducta2 = new Product("Alpha2", 2, true, true);
    Product testProducta3 = new Product("Alpha3", 3, false, false);
    Product testProducta4 = new Product("Alpha4", 4, true, false);
    Product testProductb1 = new Product("Beta1", 0, true, true);
    Product testProductb2 = new Product("Beta2", 2, true, true);
    Product testProductb3 = new Product("Beta3", 3, false, true);
    Product testProductb4 = new Product("Beta4", 4, true, false);
        
    @BeforeClass
    public static void setUpClass() {
    System.out.println("running manifestTest...");
    }

    /**
     * Test of addProduct method, of class Manifest.
     */
    @Before
    public void testAddProduct_Product() {
        testManifest1.addProduct(testProducta2);
        testManifest1.addProduct(testProducta4);
        testManifest1.addProduct(testProductb3);
        testManifest2.addProduct(testProducta3, 5);
        testManifest3.addProduct(testProducta1);
        assertNotNull(testManifest1);
        assertNotNull(testManifest2);
    }


    /**
     * Test of removeProduct method, of class Manifest.
     */
    @Test
    public void testRemoveProduct() {
        testManifest3.removeProduct(testProducta1);
        assertEquals(false, testManifest3.containsProduct(testProducta1));
    }

    /**
     * Test of getTotalWeight method, of class Manifest.
     */
    @Test
    public void testGetTotalWeight() {
        System.out.println("getTotalWeight");
        assertEquals( 9, testManifest1.getTotalWeight(), 0);
        assertEquals( 15, testManifest2.getTotalWeight(), 0);
        assertNotEquals( 14, testManifest2.getTotalWeight());
        assertEquals( 0, testManifest3.getTotalWeight(), 0);
        assertNotEquals( 1, testManifest3.getTotalWeight());
    }

    /**
     * Test of getHeaviestUnder method, of class Manifest.
     */
    @Test
    public void testGetHeaviestUnder() {
        System.out.println("getHeaviestUnder");
        double weight = 10;
        assertEquals( testProducta4, testManifest1.getHeaviestUnder(weight));
        assertNotEquals(testProducta2, testManifest1.getHeaviestUnder(weight));
        assertEquals( testProducta3, testManifest2.getHeaviestUnder(weight));
        assertEquals( testProducta1, testManifest3.getHeaviestUnder(weight));
    }

    /**
     * Test of isEmpty method, of class Manifest.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        assertEquals(false, testManifest3.isEmpty());
        testManifest3.removeProduct(testProducta1);
        assertEquals(true, testManifest3.isEmpty());
    }

    /**
     * Test of containsProduct method, of class Manifest.
     */
    @Test
    public void testContainsProduct() {
        assertEquals(true, testManifest3.containsProduct(testProducta1));
        assertEquals(false, testManifest3.containsProduct(testProducta2));
        assertEquals(true, testManifest1.containsProduct(testProducta2));
        assertEquals(true, testManifest1.containsProduct(testProductb3));
        assertEquals(true, testManifest2.containsProduct(testProducta3));
    }

    /**
     * Test of toString method, of class Manifest.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String a = testManifest1.toString();
        assertEquals(a, testManifest1.toString());
    }

    /**
     * Test of hasFragileItems method, of class Manifest.
     */
    @Test
    public void testHasFragileItems() {
        System.out.println("hasFragileItems");
        assertEquals(true, testManifest1.hasFragileItems());
        assertEquals(false, testManifest2.hasFragileItems());
        assertEquals(true, testManifest3.hasFragileItems());
        assertNotEquals(false, testManifest1.hasFragileItems());
    }

    @Test
    public void testHasHazardousItem(){
        System.out.println("hasHazardousItems");
        assertEquals(true, testManifest1.hasHazardousItems());
        assertEquals(false, testManifest2.hasHazardousItems());
        assertEquals(true, testManifest3.hasHazardousItems());
        assertNotEquals(false, testManifest1.hasHazardousItems());
    }
   
    
}
