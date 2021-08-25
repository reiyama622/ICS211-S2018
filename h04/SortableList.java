package edu.ics211.h04;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Implements the IList211 and ISortableList211.
 * 
 * @author Rei Yamamoto
 *
 * @param <E> generic type
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {
  private int size;
  private int swaps;
  private int comps;
  private long startTime;
  private long sortTime;
  private DLinkedNode head;

  /**
   * private inner DLinkedNode class.
   * 
   * @author Rei Yamamoto
   *
   */
  private class DLinkedNode {
    E item;
    DLinkedNode next;
    DLinkedNode prev;


    /**
     * Initializes item, next, and prev.
     * 
     * @param item the item
     * @param next the next thing
     * @param prev the previous thing
     */
    public DLinkedNode(E item, DLinkedNode next, DLinkedNode prev) {
      this.item = item;
      this.next = next;
      this.prev = prev;
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.ISortableList#insertionSort(java.util.Comparator)
   */
  @Override
  public void insertionSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    for (int i = 1; i < size; i++) {
      E temp = get(i);
      int j = i;
      while (j > 0 && compare.compare(get(j - 1), temp) > 0) {
        E temp2 = get(j - 1);
        set(j - 1, get(j));
        set(j, temp2);
        j--;
        swaps++;
      }
      set(j, temp);
    }
    sortTime = System.nanoTime() - startTime;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.ISortableList#bubbleSort(java.util.Comparator)
   */
  @Override
  public void bubbleSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    for (int i = 0; i < size - 1; i++) {
      comps++;
      for (int j = 0; j < size - 1 - i; j++) {
        if (compare.compare(get(j), get(j + 1)) > 0) {
          comps++;
          E temp = get(j + 1);
          set(j + 1, get(j));
          set(j, temp);
          swaps++;
        }
      }
    }

    sortTime = System.nanoTime() - startTime;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.ISortableList#selectionSort(java.util.Comparator)
   */
  @Override
  public void selectionSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    int posMin;
    for (int i = 0; i < size - 1; i++) {
      posMin = (int) get(i);
      for (int j = i + 1; j < size; j++) {
        comps++;
        if (compare.compare(get(j), get(posMin)) < 0) {
          posMin = j;
        }

        if (compare.compare(get(posMin), get(i)) < 0) {
          E temp = get(i);
          set(i, get(posMin));
          set(posMin, temp);
        }

      }
    }
    sortTime = System.nanoTime() - startTime;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.ISortableList#getNumberOfSwaps()
   */
  @Override
  public int getNumberOfSwaps() {
    // TODO Auto-generated method stub
    return 0;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.ISortableList#getNumberOfComparisons()
   */
  @Override
  public int getNumberOfComparisons() {
    // TODO Auto-generated method stub
    return 0;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.ISortableList#getSortTime()
   */
  @Override
  public double getSortTime() {
    // TODO Auto-generated method stub
    return 0;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.IList211#get(int)
   */
  @Override
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Illegal index");
    }
    DLinkedNode temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp.item;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.IList211#set(int, java.lang.Object)
   */
  @Override
  public E set(int index, E element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Illegal index");
    }
    DLinkedNode temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    E retVal = temp.item;
    temp.item = element;
    return retVal;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.IList211#indexOf(java.lang.Object)
   */
  @Override
  public int indexOf(Object obj) {
    DLinkedNode temp = head;
    for (int i = 0; i < size; i++) {
      if (temp.item.equals(obj)) {
        return i;
      }
      temp = temp.next;
    }
    return -1;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.IList211#size()
   */
  @Override
  public int size() {
    return size;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.IList211#add(java.lang.Object)
   */
  @Override
  public boolean add(E e) {
    if (head == null) {
      head = new DLinkedNode(e, null, null);
    } else {
      DLinkedNode temp = head;
      for (int i = 0; i < size - 1; i++) {
        temp = temp.next;
      }
      temp.next = new DLinkedNode(e, null, null);
    }
    size++;
    return true;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.IList211#add(int, java.lang.Object)
   */
  @Override
  public void add(int index, E element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Illegal index");
    }
    if (index == 0) {
      head = new DLinkedNode(element, null, null);
      size++;
    } else {
      DLinkedNode temp = head;
      for (int i = 0; i < index - 1; i++) {
        temp = temp.next;
      }
      temp.next = new DLinkedNode(element, temp.next, temp.prev);
      size++;
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.IList211#remove(int)
   */
  @Override
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Illegal index");
    }
    if (index == 0) {
      E old = head.item;
      head = head.next;
      size--;
      return old;
    } else {
      DLinkedNode temp = head;
      for (int i = 0; i < index - 1; i++) {
        temp = temp.next;
      }
      E removed = temp.next.item;
      temp.next = temp.next.next;
      size--;
      return removed;
    }
  }

}