/**
 * 
 */
package edu.ics211.h07;

import java.util.ArrayList;
import java.util.List;

/**
 * Program that Simulates checkout lanes.
 * 
 * @author Rei Yamamoto helped by Branden Ogata
 *
 */
public class CheckoutLanes {
  public int numExpress;
  public int numRegular;
  public CircularArrayQueue<Shopper>[] amountExpress;
  public CircularArrayQueue<Shopper>[] amountRegular;


  /**
   * Constructor that creates lanes.
   * 
   * @param numExpress the number of express lanes.
   * @param numRegular the number of regular lanes.
   */
  public CheckoutLanes(int numExpress, int numRegular) {
    this.numExpress = numExpress;
    amountExpress = new CircularArrayQueue[numExpress];
    amountRegular = new CircularArrayQueue[numRegular];
    for (int i = 0; i < numExpress; i++) {
      amountExpress[i] = new CircularArrayQueue<Shopper>();
    }
    for (int j = 0; j < numRegular; j++) {
      amountRegular[j] = new CircularArrayQueue<Shopper>();
    }
    if (numExpress > amountExpress.length || numRegular > amountRegular.length || numRegular < 1) {
      throw new IllegalArgumentException();
    }
  }


  /**
   * Puts the shopper into a lane.
   * 
   * @param laneNumber the lane number that the shopper will be in.
   * @param shopper The shopper.
   */
  public void enterLane(int laneNumber, Shopper shopper) {
    if ((laneNumber < 0) || (laneNumber > (amountExpress.length + amountRegular.length))) {
      throw new IllegalArgumentException();
    }
    if (amountExpress.length == 0) {
      amountRegular[laneNumber].add(shopper);
    } else if (laneNumber >= amountExpress.length) {
      int lane = laneNumber - amountExpress.length;
      amountRegular[lane].add(shopper);
    } else {
      amountExpress[laneNumber].add(shopper);
    }
  }


  /**
   * Simulates a shopper checking out. Emptys each lane one by one.
   * 
   * @return the list of shoppers who checked out
   */
  public List<Shopper> simulateCheckout() {
    List<Shopper> list = new ArrayList<>();
    for (int i = 0; i < amountExpress.length; i++) {
      while (amountExpress[i].size() > 0) {
        if (amountExpress[i].peek() != null) {
          if (amountExpress[i].peek().getNumberOfItems() > 10) {
            System.out.println("Express lane shopper with " + amountExpress[i].peek().getNumberOfItems() + " items moved to lane " + amountExpress.length);
            amountRegular[0].add(amountExpress[i].remove());

          }
          System.out.println("Express lane " + i + " shopper with " + amountExpress[i].peek().getNumberOfItems() + " items");
          Shopper removed = amountExpress[i].remove();
          list.add(removed);
        }
      }
    }
    for (int x = 0; x < amountRegular.length; x++) {
      while (amountRegular[x].size() > 0) {
        System.out.println("Regular lane " + (x + amountExpress.length) + " shopper had " + amountRegular[x].peek().getNumberOfItems() + " items");
        Shopper removed = amountRegular[x].remove();
        list.add(removed);
      }
    }
    return list;
  }
}