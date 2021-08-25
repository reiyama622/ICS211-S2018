package edu.ics211.h03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import labwork.Calculator;

/**
 * tests the SortableList class.
 * 
 * @author Rei Yamamoto
 *
 */
public class SortableListTest {
  private SortableList<Integer> list;
  private IntComparator compare;


  /**
   * tests the insertion sort method.
   */
  @Test
  public void testInsertionSort() {
    list = new SortableList<Integer>();
    compare = new IntComparator();
    list.add(3);
    list.add(6);
    list.add(1);
    list.add(7);
    list.add(2);
    list.insertionSort(compare);
    assertTrue("not sorted", list.get(3) == 6);
  }


  /**
   * tests the bubble sort method.
   */
  @Test
  public void testBubbleSort() {
    list = new SortableList<Integer>();
    compare = new IntComparator();
    list.add(3);
    list.add(6);
    list.add(1);
    list.add(7);
    list.add(2);
    list.bubbleSort(compare);
    assertTrue("not sorted", list.get(3) == 6);
  }


  /**
   * tests the selection sort method.
   */
  @Test
  public void testSelectionSort() {
    list = new SortableList<Integer>();
    compare = new IntComparator();
    list.add(1);
    list.add(2);
    list.add(4);
    list.add(3);
    list.add(5);
    list.selectionSort(compare);
    assertTrue("did not sort", list.get(2) == 3);
  }


  /**
   * tests the get number of swaps method.
   */
  @Test
  public void testGetNumberOfSwaps() {

  }


  /**
   * tests the get number of comparisons method.
   */
  @Test
  public void testGetNumberOfComparisons() {

  }


  /**
   * tests the get sort time method.
   */
  @Test
  public void testGetSortTime() {

  }


  /**
   * tests the get method.
   */
  @Test
  public void testGet() {
    list = new SortableList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.get(0);
    assertTrue("wrong get", list.get(0) == 1);
  }


  /**
   * tests the set method.
   */
  @Test
  public void testSet() {
    list = new SortableList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.set(3, 8);
    assertTrue("wrong set", list.get(3) == 8);
  }


  /**
   * tests the index of method.
   */
  @Test
  public void testIndexOf() {
    list = new SortableList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    assertTrue("wrong index of", list.indexOf(5) == 4);

  }


  /**
   * tests the size method.
   */
  @Test
  public void testSize() {
    list = new SortableList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    assertTrue("Not correct size", list.size() == 5);

  }


  /**
   * tests the add method.
   */
  @Test
  public void testAdd() {
    list = new SortableList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    assertTrue("add did not work", list.get(0) == 1);
    assertTrue("add did not work", list.get(1) == 2);
    assertTrue("add did not work", list.get(2) == 3);
    assertTrue("add did not work", list.get(3) == 4);
    assertTrue("add did not work", list.get(4) == 5);
  }


  /**
   * tests the add at method.
   */
  @Test
  public void testAddAt() {
    list = new SortableList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(1, 7);
    assertTrue("add did not work", list.get(1) == 7);
  }


  /**
   * tests the remove method.
   */
  @Test
  public void testRemove() {
    list = new SortableList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.remove(2);
    assertTrue("remove did not work", list.get(2) == 4);

  }
}
