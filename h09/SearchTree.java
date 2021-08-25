package edu.ics211.h09;

/**
 * SearchTree interface.
 * @author Rei Yamamoto
 * Interface from ICS211 website
 *
 * @param <E> generic type
 */
public interface SearchTree<E> {
  /**
   * Inserts item into where it belongs in the tree.
   * 
   * @param item the thing to add
   * @return true if item is inserted, false if item is already in tree.
   */
  boolean add(E item);


  /**
   * Checks if the item is in the tree or not.
   * 
   * @param item the thing to check for
   * @return true if item is in the tree, false otherwise.
   */
  boolean contains(E item);


  /**
   * Finds the target item.
   * 
   * @param target the item to find
   * @return a reference to the target if found, null if target isn't in the tree.
   */
  E find(E target);


  /**
   * Removes target from the tree.
   * 
   * @param target the thing to delete
   * @return a reference to the target if found, null if target isn't in the tree.
   */
  E delete(E target);


  /**
   * Removes target from the tree.
   * 
   * @param target the thing to remove
   * @return true if target was in the tree, false otherwise.
   */
  boolean remove(E target);
}
