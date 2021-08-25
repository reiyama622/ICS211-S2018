package edu.ics211.h07;

/** Queue211 interface that has methods add, element, poll, peek, size, offer, and remove.
 * @author Rei Yamamoto
 *
 * @param <E> generic type
 */
public interface Queue211<E> {

  /**
   * adds e to the end of the queue. May throw an IllegalStateException if the queue is full.
   * 
   * @param e the item to add
   * @return true or false if the item was added
   */
  boolean add(E e);


  /**
   * Retrieves, but doesn't remove the head of the queue. Throws NoSuchElementException if queue is empty.
   * 
   * @return the element that was retrieved
   */
  E element();


  /**
   * adds e to the end of the queue.
   * 
   * @param e the item to add
   * @return false if the queue is full
   */
  boolean offer(E e);


  /**
   * Retrieves, but doesn't remove the head of the queue.
   * 
   * @return Return null if queue is empty.
   */
  E peek();


  /**
   * Retrieves and removes the head of the queue.
   * 
   * @return Returns null if the queue is empty.
   */
  E poll();


  /**
   * Retrieves and removes the head of the queue. Throws NoSuchElementException if queue is empty.
   * 
   * @return the item that was aremoved
   */
  E remove();


  /**
   * the size of the queue.
   * 
   * @return the size of the queue
   */
  int size();

}
