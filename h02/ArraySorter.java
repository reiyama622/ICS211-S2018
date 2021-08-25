
package edu.ics211.h02;

import java.util.Comparator;

/**
 * Array sorter class that sorts arrays using bubble sort, insertion sort and selection sort.
 * 
 * @author Rei Yamamoto used code from quiz 05.
 * @param <E> generic type.
 */
public class ArraySorter<E> implements SortableArray<E> {
  long startTime;
  long sortTime;
  int swaps;
  int comparisons;
  E temp;


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h02.SortableArray#insertionSort(java.lang.Object[], java.util.Comparator)
   */
  @Override
  public void insertionSort(E[] data, Comparator<E> compare) {
    startTime = System.nanoTime();
    swaps = 0;
    comparisons = 0;

    for (int i = 1; i < data.length; i++) {
      E temp = data[i];
      int j = i;
      while (j > 0 && ((compare.compare(data[j - 1], temp)) > 0)) {
        data[j] = data[j - 1];
        swaps++;
        j--;
      }
      data[j] = temp;
      comparisons++;
    }
    sortTime = System.nanoTime() - startTime;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h02.SortableArray#bubbleSort(java.lang.Object[], java.util.Comparator)
   */
  @Override
  public void bubbleSort(E[] data, Comparator<E> compare) {
    startTime = System.nanoTime();
    swaps = 0;
    comparisons = 0;
    for (int i = 0; i < data.length; i++) {
      comparisons++;
      for (int j = 0; j < data.length - 1 - i; j++) {
        if (compare.compare(data[j], data[j + 1]) > 0) {
          comparisons++;
          temp = data[j + 1];
          data[j + 1] = data[j];
          data[j] = temp;
          swaps++;
        }
      }
    }

    sortTime = System.nanoTime() - startTime;

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h02.SortableArray#selectionSort(java.lang.Object[], java.util.Comparator)
   */
  @Override
  public void selectionSort(E[] data, Comparator<E> compare) {
    startTime = System.nanoTime();
    swaps = 0;
    comparisons = 0;
    E temp;
    int posMin;
    for (int i = 0; i < data.length - 1; i++) {
      posMin = i;
      for (int j = i + 1; j < data.length; j++) {
        comparisons++;
        if (compare.compare(data[j], data[posMin]) < 0) {
          posMin = j;
        }
        if (compare.compare(data[posMin], data[i]) < 0) {
          temp = data[i];
          data[i] = data[posMin];
          data[posMin] = temp;
        }
      }
    }
    sortTime = System.nanoTime() - startTime;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h02.SortableArray#getNumberOfSwaps()
   */
  @Override
  public int getNumberOfSwaps() {
    // TODO Auto-generated method stub
    return swaps;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h02.SortableArray#getNumberOfComparisons()
   */
  @Override
  public int getNumberOfComparisons() {
    // TODO Auto-generated method stub
    return comparisons;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h02.SortableArray#getSortTime()
   */
  @Override
  public double getSortTime() {
    // TODO Auto-generated method stub
    return sortTime;
  }

}