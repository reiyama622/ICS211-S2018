package lab12;

import java.util.Iterator;

/**
 * Tests the sortableList class.
 * 
 * @author Rei Yamamoto
 *
 */
public class Test {

  /**
   * Test to see if the add method works.
   */
  @org.junit.Test
  public void test() {
    SortableList<Integer> list = new SortableList<Integer>();
    Iterator<Integer> iter = list.iterator();
    list.add(1);
    list.add(2);
    list.add(3);
    for (Integer value : list) {
      System.out.println(value);
    }
  }
}
