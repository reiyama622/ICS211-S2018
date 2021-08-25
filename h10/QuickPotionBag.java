package edu.ics211.h10;

import java.util.Hashtable;

/**
 * @author Rei Yamamoto
 *
 */
public class QuickPotionBag implements PotionBag {
  private static QuickPotionBag qBag = new QuickPotionBag();
  Hashtable<Potion, Potion> quick;
  long time;
  int size;


  /**
   * Constructor that creates a QuickPotionBag.
   */
  private QuickPotionBag() {
    quick = new Hashtable<Potion, Potion>(100, (float) 0.5);
    size = 0;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#store(edu.ics211.h10.Potion)
   */
  @Override
  public void store(Potion p) {
    quick.put(p, p);
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
    size--;
    return quick.remove(p);
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
   * Gets an instance of QuickPotionBag
   * 
   * @return qbag The instance of the bag
   */
  public static QuickPotionBag getInstance() {
    if (qBag == null) {
      qBag = new QuickPotionBag();
    }
    return qBag;
  }

}