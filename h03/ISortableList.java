package edu.ics211.h03;

import java.util.Comparator;

/** interface for the 
 * @author Rei Yamamoto
 *
 * @param <E> generic type.
 */
public interface ISortableList<E> {
  /** sorts the items using insertion sort.
   * @param compare to determine the order.
   */
  void insertionSort(Comparator<E> compare);


  /** sorts theitems using bubble sort.
   * @param compare to getermine the order.
   */
  void bubbleSort(Comparator<E> compare);


  /**sorts the items using selection sort.
   * @param compare to determine the order.
   */
  void selectionSort(Comparator<E> compare);


  /** gets the number of swaps it took.
   * @return the number of swaps.
   */
  int getNumberOfSwaps();


  /** gets the number of comparisons.
   * @return the number of comparisons.
   */
  int getNumberOfComparisons();


  /** gets the sort time.
   * @return how long it took to sort.
   */
  double getSortTime();
}
