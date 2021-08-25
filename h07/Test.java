package edu.ics211.h07;

import static org.junit.Assert.*;
import java.util.List;

/**
 * tests the Checkout Lanes class.
 * 
 *  Sufficient testing because the methods test if there is only one lane which is the
 * regular lane since you need to have atleast one regular and the and an express lane and a regular lane. The
 * CheckoutLanes class adds a person to the desired lane then moves them if they have more than 10 items. The
 * simulateCheckoutMethod emptys each lane one buy one then returns a list of the shoppers who checked out. This test
 * works because it adds to the lanes, checks out the shoppers and returns the size. It tests all the methods that were
 * in the CheckoutLane class.
 * 
 * @author Rei Yamamoto
 *
 */
public class Test {

  /**
   * Test sthe CheckoutLanes class
   */
  @org.junit.Test
  public void oneOne() {
    System.out.println("\nOne Express Lane One Regular Lane");
    CheckoutLanes store1 = new CheckoutLanes(1, 1);
    store1.enterLane(0, new Shopper(1));
    store1.enterLane(0, new Shopper(7));
    store1.enterLane(0, new Shopper(11));
    store1.enterLane(0, new Shopper(10));
    store1.enterLane(1, new Shopper(12));
    store1.enterLane(1, new Shopper(13));
    List<Shopper> shoppers = store1.simulateCheckout();
    assertEquals("Wrong number of shoppers", 6, shoppers.size());
    assertTrue(shoppers.get(0).getNumberOfItems() == 1);
    assertTrue(shoppers.get(1).getNumberOfItems() == 7);
    assertTrue(shoppers.get(2).getNumberOfItems() == 10);
    assertTrue(shoppers.get(3).getNumberOfItems() == 12);
    assertTrue(shoppers.get(4).getNumberOfItems() == 13);
    assertTrue(shoppers.get(5).getNumberOfItems() == 11);
  }


  /**
   * 
   */
  @org.junit.Test
  public void noneOne() {
    System.out.println("\n Zero Express Lanes One Regular Lane");
    CheckoutLanes store2 = new CheckoutLanes(0, 1);
    store2.enterLane(0, new Shopper(8));
    store2.enterLane(0, new Shopper(3));
    store2.enterLane(0, new Shopper(71));
    store2.enterLane(0, new Shopper(10));
    List<Shopper> shoppers = store2.simulateCheckout();
    assertEquals("Wrong number of shoppers", 4, shoppers.size());
    assertTrue(shoppers.get(0).getNumberOfItems() == 8);
    assertTrue(shoppers.get(1).getNumberOfItems() == 3);
    assertTrue(shoppers.get(2).getNumberOfItems() == 71);
    assertTrue(shoppers.get(3).getNumberOfItems() == 10);
  }
}
