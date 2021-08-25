/**
 * 
 */
package edu.ics211.h05;

import java.util.LinkedList;
import java.util.ListIterator;
import edu.ics211.h01.Beer;

/**
 * JosephusBeerFlight class that removes the beer every x amount of steps.
 * 
 * @author Rei Yamamoto
 *
 */
public class JosephusBeerFlight {
  Beer[] array;
  private CircularDoublyLinkedList<Beer> b;


  /**
   * Constructor that takes in a beer array.
   * 
   * @param array the array.
   */
  public JosephusBeerFlight(Beer[] array) {
    this.array = array;
  }


  /**
   * Method that removes beers every x amount of steps.
   * 
   * @param start the beer to start at.
   * @param step the number of steps to move.
   * @param isClockwise the direction to move.
   * @return the order in which the beers were removed
   */
  LinkedList<Beer> tasteBeers(int start, int step, boolean isClockwise) {
    CircularDoublyLinkedList<Beer> list = new CircularDoublyLinkedList<Beer>(array);
    ListIterator<Beer> iterator = (ListIterator<Beer>) list.iterator();
    LinkedList<Beer> linkedList = new LinkedList<Beer>();
    if (isClockwise) {
      for (int at = start - 1; at < array.length; at += step - 1) {
        iterator.next();
        linkedList.add(iterator.next());
        iterator.remove();
      }
    } else {
      for (int at = start - 1; at < array.length; at -= step + 1) {
        iterator.previous();
        linkedList.add(iterator.next());
        iterator.remove();
      }

    }
    return linkedList;
  }
}