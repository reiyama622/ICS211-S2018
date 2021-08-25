package edu.ics211.h07;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Implements Queue211 for a generic type.
 * 
 * @author Rei Yamamoto
 *
 * @param <E> generic type
 */
public class CircularArrayQueue<E> implements Queue211<E> {
  private int front;
  private int rear;
  private int size;
  private E[] data;


  /**
   * Constructor that initializes the variables.
   */
  public CircularArrayQueue() {
    this.data = (E[]) new Object[10];
    this.front = 0;
    this.rear = data.length - 1;
    size = 0;
  }


  /**
   * Makes the array bigger if it is full.
   */
  private void reallocate() {
    E[] newData = (E[]) new Object[2 * data.length];
    int j = front;
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
      j = (j + 1) % data.length;
    }
    front = 0;
    rear = size - 1;
    data = newData;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#add(java.lang.Object)
   */
  @Override
  public boolean add(E e) {
    if (size == data.length) {
      reallocate();
    }
    rear = (rear + 1) % data.length;
    data[rear] = e;
    size++;
    return true;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#element()
   */
  @Override
  public E element() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[front];
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#offer(java.lang.Object)
   */
  @Override
  public boolean offer(E e) {
    try {
      return add(e);
    } catch (IllegalStateException illegalState) {
      return false;
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#peek()
   */
  @Override
  public E peek() {
    try {
      return element();
    } catch (NoSuchElementException noSuch) {
      return null;
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#poll()
   */
  @Override
  public E poll() {
    try {
      return remove();
    } catch (NoSuchElementException noSuch) {
      return null;
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#remove()
   */
  @Override
  public E remove() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    E old = data[front];
    front = (front + 1) % data.length;
    size--;
    return old;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#size()
   */
  @Override
  public int size() {
    return size;
  }
}
