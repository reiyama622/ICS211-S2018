
package edu.ics211.h10;

import java.util.Comparator;

/**
 * Compares two potions
 *
 * @author Rei Yamamoto assisted by Jonathan Oba
 *
 */
public class PotionComparator implements Comparator<Potion> {

  /* (non-Javadoc)
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */
  @Override
  public int compare(Potion o1, Potion o2) {
    if (o1.getName().compareTo(o2.getName()) == 0) {
      return 0;
    } else if (o1.getName().compareTo(o2.getName()) < 0) {
      return -1;
    } else {
      return 1;
    }
  }
}
