package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Harry Furnish
 * @version 1.0 
 */
public class Packer {
    /**
     * Packer provides automated packing of products into boxes, providing a manifest of products.
     * @param c customer details
     * @param d depot details
     * @param m manifest of products to be packed
     * @return list of packed boxes
     */
    public static List<Box> packProducts(Customer c, Depot d, Manifest m) {
        List<Box> packedBoxes = new ArrayList<>();
        Box b = null;
        while (!m.isEmpty()) { // repeat until all items are packed
            if (b == null) {
                b = new Box(c,d);
            }
                Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());
                
                
                if (prodToAdd == null) {
                    b = null;
                    b = new Box(c,d);
                    packedBoxes.add(b);
                }
                else {
                    //System.out.println(prodToAdd + " prodod to add");
                    if (!b.canFit(prodToAdd)){
                    packedBoxes.add(b);
                    //System.out.println("new box");
                    b = null;
                    b = new Box(c,d);
                }
                    b.addProduct(prodToAdd);
                     //System.out.println(b.canFit(prodToAdd));
                     //System.out.println(prodToAdd + " prodod to add");
                    //System.out.println("not empty " + m.isEmpty());
                    m.removeProduct(prodToAdd);
                    //System.out.println("empty " + m.isEmpty());
                    //System.out.println("box " + b);
                }  
                
            }
          // if (b != null)
            if (b != null) {
                packedBoxes.add(b);
                
                //System.out.println("box loaded xxxxxxxxxxxxxxxxxxxx");
            //packedBoxes.add(b);
            }
        //System.out.println("boxes " + packedBoxes);
        return packedBoxes;
    }   
}
