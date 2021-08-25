/**
 * 
 */
package edu.ics211.h05;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import edu.ics211.h03.IList211;

/** CircularDoublyLinkedList class that implements Ilist211 and Iterable.
 * @author Rei
 *
 * @param <E> Generic type
 */
public class CircularDoublyLinkedList<E> implements IList211<E>, Iterable<E> {
  private E[] data;
  private int size;
  private DLinkedNode head;
  private DLinkedNode tail;


  /**
   * adds onto the list.
   * 
   * @param items and E array.
   */
  public CircularDoublyLinkedList(E[] items) {
    for (int i = 0; i < items.length; i++) {
      add(items[i]);
    }
  }


  /**
   * public constructor.
   */
  public CircularDoublyLinkedList() {
    // TODO Auto-generated constructor stub
  }

  /**
   * private inner class that implements ListIterator.
   * 
   * @author Rei Yamamoto
   *
   */
  private class LinkedListIterator implements ListIterator<E> {
    private DLinkedNode next;
    private DLinkedNode prev;
    private int nextIndex;
    private int prevIndex;
    DLinkedNode lastReturned;


    /**
     * Constructor that initializes nextIndex, prevIndex, next, and prev.
     */
    public LinkedListIterator() {
      nextIndex = 0;
      prevIndex = size;
      this.next = head;
      this.prev = tail;
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.util.ListIterator#hasNext()
     */
    @Override
    public boolean hasNext() {
      if (next != null) {
        return true;
      } else {
        return false;
      }
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.util.ListIterator#next()
     */
    @Override
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      E first = next.item;
      next = next.next;
      nextIndex++;
      return first;
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.util.ListIterator#hasPrevious()
     */
    @Override
    public boolean hasPrevious() {
      if (prev != null) {
        return true;
      } else {
        return false;
      }
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.util.ListIterator#previous()
     */
    @Override
    public E previous() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      E first = prev.item;
      prev = prev.prev;
      prevIndex++;
      return first;
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.util.ListIterator#nextIndex()
     */
    @Override
    public int nextIndex() {
      // TODO Auto-generated method stub
      return nextIndex;
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.util.ListIterator#previousIndex()
     */
    @Override
    public int previousIndex() {
      // TODO Auto-generated method stub
      return prevIndex;
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.util.ListIterator#remove()
     */
    @Override
    public void remove() {
      // TODO Auto-generated method stub

    }


    /*
     * (non-Javadoc)
     * 
     * @see java.util.ListIterator#set(java.lang.Object)
     */
    @Override
    public void set(E e) {
      throw new UnsupportedOperationException();
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.util.ListIterator#add(java.lang.Object)
     */
    @Override
    public void add(E e) {
      throw new UnsupportedOperationException();
    }
  }

  /**
   * Private inner class.
   * 
   * @author Rei Yamamoto
   *
   */
  private class DLinkedNode {
    E item;
    DLinkedNode next;
    DLinkedNode prev;


    /**
     * constructor that initiaizes item, next, and prev.
     * 
     * @param item the item looking at
     * @param next the next item
     * @param prev the previous item
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
   * @see edu.ics211.h03.IList211#get(int)
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
   * @see edu.ics211.h03.IList211#set(int, java.lang.Object)
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
   * @see edu.ics211.h03.IList211#indexOf(java.lang.Object)
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
   * @see edu.ics211.h03.IList211#size()
   */
  @Override
  public int size() {
    return size;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#add(java.lang.Object)
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
   * @see edu.ics211.h03.IList211#add(int, java.lang.Object)
   */
  @Override
  public void add(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) {
      head = new DLinkedNode(element, head, head.prev);
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
   * @see edu.ics211.h03.IList211#remove(int)
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


  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Iterable#iterator()
   */
  @Override
  public Iterator<E> iterator() {
    LinkedListIterator list = new LinkedListIterator();
    return list;
  }

}
