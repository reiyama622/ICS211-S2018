package edu.ics211.h02;

import java.util.Comparator;

/**
 * Sorts arrays using bubble, insertion, and selection. 
 * Gets the number of swaps, comparisons, and the SortTime.
 * 
 * @author Rei Yamamoto
 *
 * @param <E> a generic type.
 */
public interface SortableArray<E> {

  /**
   * Uses insertion sort method to sort the array.
   * 
   * @param data the data of a specific type.
   * @param compare compares the data.
   */
  void insertionSort(E[] data, Comparator<E> compare);


  /**
   * Uses bubble sort method to sort the array.
   * 
   * @param data the data of a specific type.
   * @param compare compares the data.
   */
  void bubbleSort(E[] data, Comparator<E> compare);


  /**
   * Uses selection sort method to sort the array.
   * 
   * @param data the data of a specific type.
   * @param compare compares the data.
   */
  void selectionSort(E[] data, Comparator<E> compare);


  /**
   * Gets the number of swaps.
   * 
   * @return swaps. The number of swaps that it did.
   */
  int getNumberOfSwaps();


  /**
   * Gets the number of comparisons.
   * 
   * @return comparisons. The number of comparisons it did.
   */
  int getNumberOfComparisons();


  /**
   * Gets the sort time.
   * 
   * @return sortTime. The time it took to run.
   */
  double getSortTime();

}
