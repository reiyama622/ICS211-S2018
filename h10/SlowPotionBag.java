package edu.ics211.h10;

import java.util.ArrayList;

/**
 * Creates a slow potion bag
 * 
 * @author Rei Yamamoto
 *
 */
public class SlowPotionBag implements PotionBag {
  private static SlowPotionBag sBag = new SlowPotionBag();
  ArrayList<Potion> slow;
  private int size;
  private Potion[] data;


  /**
   * Constructor that creates a potion bag of 100
   */
  public SlowPotionBag() {
    slow = new ArrayList<Potion>(100);
    size = 0;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#store(edu.ics211.h10.Potion)
   */
  @Override
  public void store(Potion p) {
    slow.add(0, p);
    size++;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#timedStore(edu.ics211.h10.Potion)
   */
  @Override
  public long timedStore(Potion p) {
    long start = System.nanoTime();
    store(p);
    long end = System.nanoTime();
    long result = end - start;
    return result;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#retrieve(edu.ics211.h10.Potion)
   */
  @Override
  public Potion retrieve(Potion p) {
    slow.remove(p);
    size--;
    return p;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#timedRetrieve(edu.ics211.h10.Potion)
   */
  @Override
  public long timedRetrieve(Potion p) {
    long start = System.nanoTime();
    retrieve(p);
    long end = System.nanoTime();
    long result = end - start;
    return result;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#size()
   */
  @Override
  public int size() {
    return size;
  }


  /**
   * Gets an instance of the slow potion bag
   * 
   * @return sBag the instance of the bag
   */
  public static SlowPotionBag getInstance() {
    if (sBag == null) {
      sBag = new SlowPotionBag();
    }
    return sBag;
  }

}
