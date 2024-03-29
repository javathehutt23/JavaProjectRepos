/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author bunta
 */
public class BoxTest {
    
    // Test data
    
    Coordinates testCoordinates1 = new Coordinates(0,0);
    Coordinates testCoordinates2 = new Coordinates(30,40);
    Coordinates testCoordinates3 = new Coordinates(1000, 2000);

    Address testAddress1 = new Address("1 First St", "Aplace", "Citadel City", "A111", testCoordinates1);
    Address testAddress2 = new Address("123 Count St", "Brooklyn", "Welling Town", "B222", testCoordinates2);
    Address testAddress3 = new Address("321 Back St", "Christly", "Holly Oaks", "C333", testCoordinates3);
    Customer testCustomer1 = new Customer("FirstName", testAddress1);
    Depot testDepot1 = new Depot("Depot 1", testAddress2);
    Product testProducta1 = new Product("Alpha", 0, true, true);
    Product testProducta2 = new Product("Alpha", 2, true, true);
    Product testProducta3 = new Product("Alpha", 3, false, true);
    Product testProducta4 = new Product("Alpha", 4, true, false);
    
    Product testProductb1 = new Product("Beta", 0, true, true);
    Product testProductb2 = new Product("Beta", 2, true, true);
    Product testProductb3 = new Product("Beta", 3, false, true);
    Product testProductb4 = new Product("Beta", 4, true, false);
    
   // Manifest testManifest1 = new Manifest();

    Box testBox1 = new Box(testCustomer1, testDepot1);
    Box testBox2 = new Box(testCustomer1, testDepot1);
    Box testBox3 = new Box(testCustomer1, testDepot1);
    Box testBox4 = new Box(testCustomer1, testDepot1);
    

    /**
     *
     */
    @Before
    public void TestaddProduct(){
        testBox1.addProduct(testProducta1);
        testBox1.addProduct(testProducta2);
        testBox1.addProduct(testProducta3);
        testBox1.addProduct(testProductb3);
        System.out.println("added a1, a2, a3 & b3 to Box1");
        testBox2.addProduct(testProductb1, 1);
        System.out.println("add 15 of b1 to Box2");
        testBox3.addProduct(testProducta4, 11);
        System.out.println("added 11 of a4 to Box3");
        testBox4.addProduct(testProductb3, 5);
        System.out.println("added 5 of b3 to Box4");
        assertNotNull(testBox1); 
        assertNotNull(testBox2);
        assertNotNull(testBox3);
        assertNotNull(testBox4);   
        }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }
    
    /**
     * Test of toString method, of class Box.
     */
   /* @Test
    public void testtoString() {
        System.out.println("toString");
    // this isnt going to work beacuse the retuened item from tostring function is complex    

        assertEquals("Alpha", testBox3.toString());
        assertEquals("Beta", testBox4.toString());
        assertNotSame("Alpha", testBox3.toString());
    }
*/
    /**
     * Test of getWeight method, of class Box
     */
    @Test
    public void testgetTotalWeight() {
        System.out.println("getTotalWeight");
        assertEquals( 8, testBox1.getTotalWeight(), 0);
        assertEquals( 0, testBox2.getTotalWeight(), 0);
        assertNotEquals( 2, testBox2.getTotalWeight());
        assertEquals( 44, testBox3.getTotalWeight(), 0);
        assertNotEquals( 43, testBox3.getTotalWeight());
        assertEquals( 15, testBox4.getTotalWeight(), 0);
    }
 
       /**
     * Test of getWeight method, of class Box
     */
    @Test
    public void testcanFitWeight() {
        System.out.println("canFit another product fit depending on weight < 40");
        assertEquals(true, testBox1.canFit(testProductb1));
        assertEquals(true, testBox2.canFit(testProductb2));
        assertEquals(false, testBox3.canFit(testProductb3));
        assertEquals(true, testBox4.canFit(testProductb4));
    }

/*        @Test
    public void testcanFitquantity() {
        System.out.println("canFit another product depending on quantity < 40");
        assertEquals(true, testBox1.canFit(testProductb1, 10));
        assertEquals(true, testBox2.canFit(testProductb2, 19));
        assertEquals(false, testBox3.canFit(testProductb3, 60));
        assertEquals(true, testBox4.canFit(testProductb4, 5));
        assertEquals(false, testBox1.canFit(testProductb3, 60));
    }
*/
    
    @Test
    public void testremainingCapacity() {
        System.out.println("Testing Remaining capacity in Box...");
        assertEquals( 12.0, testBox1.remainingCapacity(), 0);
        assertEquals(20.0, testBox2.remainingCapacity(), 0);
        assertNotEquals(0, testBox2.remainingCapacity());
        assertEquals(-24, testBox3.remainingCapacity(), 0);
        assertNotEquals(0, testBox3.remainingCapacity());
        assertEquals(5, testBox4.remainingCapacity(), 0);        
    }
    @Test
    public void testisFragile(){
    System.out.println("Testing if the contents if fragile in the box...");
        assertEquals(true, testBox1.isFragile());
        assertEquals(true, testBox2.isFragile());
        assertEquals(false, testBox3.isFragile());
        assertEquals(true, testBox4.isFragile());
        assertNotEquals(false, testBox4.isFragile());
        assertNotEquals(false, testBox1.isFragile());
            }
            
    @Test
    public void testisHazardous() {
        System.out.println("Testing if the contents if hazardous in the box...");
        assertEquals(true, testBox1.isHazardous());
        assertEquals(true, testBox2.isHazardous());
        assertEquals(true, testBox3.isHazardous());
        assertEquals(false, testBox4.isHazardous());
        assertNotEquals(true, testBox4.isHazardous());
        assertNotEquals(false, testBox1.isHazardous());

    }
    @Test
    public void testisHeavy() {
        System.out.println("Testing if the contents if the box is heavy...");
        assertEquals(false, testBox1.isHeavy());
        assertEquals(false, testBox2.isHeavy());
        assertEquals(true, testBox3.isHeavy());
        assertEquals(true, testBox4.isHeavy());
        assertNotEquals(false, testBox4.isHeavy());
        assertNotEquals(true, testBox1.isHeavy());

    }

}
