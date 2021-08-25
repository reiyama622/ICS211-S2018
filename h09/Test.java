package edu.ics211.h09;

import static org.junit.Assert.*;
import java.util.List;

/**
 * Tests the BinarySearchTree class.
 * @author Rei Yamamoto
 *
 */
public class Test {
  private BinarySearchTree<Contact> tree;


  /**
   * Tests the BinarySearchTree class.
   */
  @org.junit.Test
  public void test() {
    this.tree = new BinarySearchTree<Contact>(new ContactComparator());
    Contact a = new Contact("A", "Wong", "8081234567");
    Contact b = new Contact("B", "Ace", "8081234567");
    Contact c = new Contact("C", "Wong", "8081234567");
    Contact bb = new Contact("B", "Kam", "8081234567");
    Contact d = new Contact("D", "Chang", "8081234567");
    Contact e = new Contact("E", "Vee", "1234567");
    assertTrue("does not work", tree.add(a) == true);
    assertTrue("does not work", tree.add(b) == true);
    assertTrue("does not work", tree.add(c) == true);
    assertTrue("does not work", tree.add(bb) == true);
    assertTrue("does not work", tree.add(d) == true);
    assertTrue("does not work", tree.add(e) == true);
    List<Contact> contacts = tree.inOrder();
    assertNotNull(contacts);
    assertEquals(contacts.size(), 6);
    assertTrue(contacts.get(0).equals(b));
    assertTrue(contacts.get(2).equals(bb));
    assertTrue(contacts.get(5).equals(c));
    assertEquals(a, tree.find(a));
    assertTrue(tree.contains(a));
    assertEquals(e, tree.delete(e));
    assertEquals(null, tree.delete(e));
    assertTrue(tree.remove(d));
    assertFalse(tree.remove(d));
  }

}
