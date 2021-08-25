package edu.ics211.h04;

import java.util.Comparator;

/**
 * compares the objects.
 * 
 * @author Rei Yamamoto
 *
 */
public class IntComparator implements Comparator<Integer> {

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */
  @Override
  public int compare(Integer o1, Integer o2) {
    return o1.compareTo(o2);
  }
}
