/**
 * 
 */

package edu.ics211.h03;

import java.util.Arrays;
import java.util.Comparator;
import edu.ics211.h04.IList211;

/**
 * Implements the IList211 and ISortableList211.
 * 
 * @author Rei Yamamoto
 * @param <E> generic type
 * 
 *
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {
  private E[] data;
  private int size;
  long startTime;
  long sortTime;
  int swaps;
  int comparisons;
  E temp;


  /**
   * creates and array of length 10 and size 0.
   */
  public SortableList() {
    this.data = (E[]) new Object[10];
    this.size = 0;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.ISortableList#insertionSort(java.util.Comparator)
   */
  @Override
  public void insertionSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    for (int i = 1; i < size; i++) {
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
   * @see edu.ics211.h03.ISortableList#bubbleSort(java.util.Comparator)
   */
  @Override
  public void bubbleSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    for (int i = 0; i < size - 1; i++) {
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
   * @see edu.ics211.h03.ISortableList#selectionSort(java.util.Comparator)
   */
  @Override
  public void selectionSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    E temp;
    int posMin;
    for (int i = 0; i < size - 1; i++) {
      posMin = i;
      for (int j = i + 1; j < size; j++) {
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
   * @see edu.ics211.h03.ISortableList#getNumberOfSwaps()
   */
  @Override
  public int getNumberOfSwaps() {
    return swaps;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.ISortableList#getNumberOfComparisons()
   */
  @Override
  public int getNumberOfComparisons() {
    return comparisons;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.ISortableList#getSortTime()
   */
  @Override
  public double getSortTime() {
    return sortTime;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#get(int)
   */
  @Override
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Illegal index, " + index);
    }
    return data[index];
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#set(int, java.lang.Object)
   */
  @Override
  public E set(int index, E element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Illegal index, " + index);
    }
    E temp = data[index];
    data[index] = element;
    return temp;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#indexOf(java.lang.Object)
   */
  @Override
  public int indexOf(Object obj) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(obj)) {
        return i;
      }
    }
    return -1;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#size()
   */
  @Override
  public int size() {
    // TODO Auto-generated method stub
    return size;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#add(java.lang.Object)
   */
  @Override
  public boolean add(E e) {
    if (size == data.length) {
      data = Arrays.copyOf(data, data.length * 2);
    }
    data[size] = e;
    size++;
    return true;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#add(int, java.lang.Object)
   */
  @Override
  public void add(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Illegal index" + index);
    }
    if (size == data.length) {
      data = Arrays.copyOf(data, data.length * 2);
    }
    for (int i = size; i > index; i--) {
      data[i] = data[i - 1];
    }
    data[index] = element;
    size++;

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#remove(int)
   */
  @Override
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Illegal index" + index);
    }
    E temp = data[index];
    for (int i = index + 1; i < size; i++) {
      data[i - 1] = data[i];
    }
    size--;
    return temp;
  }

}
