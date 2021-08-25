package edu.ics211.h09;

import java.util.Comparator;

/**Comparator that compares two contacts by last name and first name.
 * @author Rei Yamamoto
 *
 */
public class ContactComparator implements Comparator<Contact> {

  /* (non-Javadoc)
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */
  @Override
  public int compare(Contact o1, Contact o2) {
    int comp = o1.getLastName().compareTo(o2.getLastName());
    if(o1.getLastName() == o2.getLastName()) {
      comp = o1.getFirstName().compareTo(o2.getFirstName());
    }
    return comp;
  }
}
