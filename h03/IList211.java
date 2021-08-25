package edu.ics211.h03;

import java.util.Comparator;

/**
 * gets the item at index, sets an item at a given index, returns the index of, size, adds at the end, adds at the
 * index, and removes the item at an index.
 * 
 * @author Rei Yamamoto
 *
 * @param <E> generic type.
 */
public interface IList211<E> {
  /**
   * gets the item at the given index.
   * 
   * @param index the index of the item you would like to get.
   * @return the object you got.
   */
  E get(int index);


  /**
   * sets the element at the index.
   * 
   * @param index the index you would like to set.
   * @param element the element that you would like to set.
   * @return the object you replaced.
   */
  E set(int index, E element);


  /**
   * gets the index position of an object.
   * 
   * @param obj the object you want to find the index of.
   * @return the index of the object.
   */
  int indexOf(Object obj);


  /**
   * gets the size of the list.
   * 
   * @return the size of the list.
   */
  int size();


  /**
   * adds an element to the end of the list.
   * 
   * @param e the element to be added.
   * @return true or false if the element was added or not.
   */
  boolean add(E e);


  /**
   * adds the element at a certain index.
   * 
   * @param index the place you want to add the object.
   * @param element the element you want to add.
   */
  void add(int index, E element);


  /**
   * removes an object at a certain index.
   * 
   * @param index the place that you want to remove.
   * @return the object removed.
   */
  E remove(int index);

}
