package edu.ics211.h09;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * BinarySearchTree class that implements the SearchTree interface.
 * 
 * @author Rei Yamamoto Interface from ICS 211 website.
 * 
 * ALGORITHM ANALYSIS The big O would be O(logn + n) because to search through the tree it is logn because you always
 * split the tree in half and either go left or right. Then the n is to print out all the values in order.
 * 
 * @param <E> generic type
 */
public class BinarySearchTree<E> implements SearchTree<E> {
  private TreeNode<E> root;
  private Comparator<E> comp;
  protected boolean addReturn;
  protected E deletedReturn;
  private int size;


  /**
   * Creates a new BinarySearchTree.
   * 
   * @param c the comparator to use for determining order.
   */
  public BinarySearchTree(Comparator<E> c) {
    comp = c;
  }


  /**
   * Returns a list of values in order.
   * 
   * @return the items in order as a List.
   */
  public List<E> inOrder() {
    List<E> list = new ArrayList<E>();
    inOrder(root, list);
    return list;

  }


  /**
   * Recursively makes a list of treeNodes in order.
   * 
   * @param root the root
   * @param list the list of TreeNodes
   */
  private void inOrder(TreeNode<E> root, List<E> list) {
    if (root != null) {
      inOrder(root.left, list);
      list.add((E) root.data);
      inOrder(root.right, list);
    }
  }

  /**
   * Provate inner class that creates a tree node.
   * 
   * @author Rei Yamamoto
   * @param <E> generic type
   */
  public class TreeNode<E> {
    private E data;
    private TreeNode<E> left;
    private TreeNode<E> right;


    /**
     * Constructor for the inner class.
     * 
     * @param item the item in the node
     * @param left the left of the node
     * @param right the right of the node
     */
    public TreeNode(E item) {
      this.data = item;
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h09.SearchTree#add(java.lang.Object)
   */
  @Override
  public boolean add(E item) {
    root = add(item, root);
    size++;
    return addReturn;
  }


  /**
   * adds an item to the tree. Add method from Dr.Moore's screen cast Binary Trees & Binary Search Trees
   * 
   * @param item the item to add
   * @param root the root of the tree
   * @return true or false if the item was added or not
   */
  public TreeNode<E> add(E item, TreeNode<E> root) {
    if (root == null) {
      addReturn = true;
      return new TreeNode<E>(item);
    }
    int result = comp.compare(item, root.data);
    if (result == 0) {
      addReturn = false;
      return root;
    } else if (result > 0) {
      root.right = add(item, root.right);
      size++;
      return root;
    } else {
      root.left = add(item, root.left);
      size++;
      return root;
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h09.SearchTree#contains(java.lang.Object)
   */
  @Override
  public boolean contains(E item) {
    return contains(item, root);
  }


  /**
   * checks to see if the item is in the tree.
   * 
   * @param item the item to check for
   * @param root the root of the tree
   * @return true or false if the item is in the tree
   */
  public boolean contains(E item, TreeNode<E> root) {
    if (root == null) {
      return false;
    }
    int result = comp.compare(item, root.data);
    if (result == 0) {
      return true;
    } else if (result > 0) {
      return contains(item, root.right);
    } else {
      return contains(item, root.left);
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h09.SearchTree#find(java.lang.Object)
   */
  @Override
  public E find(E target) {
    return find(root, target);
  }


  /**
   * Finds the taget . Code from ICS 211 Binary Trees & Binary Search Trees screencast.
   * 
   * @param localRoot the root
   * @param target the item to find
   * @return the found item
   */
  public E find(TreeNode<E> localRoot, E target) {
    if (localRoot == null) {
      return null;
    }
    int result = comp.compare(target, localRoot.data);
    if (result == 0) {
      return localRoot.data;
    } else if (result < 0) {
      return find(localRoot.left, target);
    } else {
      return find(localRoot.right, target);
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h09.SearchTree#delete(java.lang.Object)
   */
  @Override
  public E delete(E target) {
    root = delete(root, target);
    size--;
    return deletedReturn;
  }


  /**
   * Deletes the target from the tree. Delete method from Dr.Moore's screen cast Binary Trees & Binary Search Trees
   * 
   * @param localRoot the root
   * @param target the thing you want to delete.
   * @return a TreeNode<E> the new root
   */
  private TreeNode<E> delete(TreeNode<E> localRoot, E target) {
    if (localRoot == null) {
      deletedReturn = null;
      return localRoot;
    }
    int result = comp.compare(target, localRoot.data);
    if (result < 0) {
      localRoot.left = delete(localRoot.left, target);
      size--;
      return localRoot;
    } else if (result > 0) {
      localRoot.right = delete(localRoot.right, target);
      size--;
      return localRoot;
    } else {
      return replaceNode(localRoot);
    }
  }


  /**
   * Replaces the local root with the correct data. Code from Dr.Moore's screen cast Binary Trees & Binary Search Trees.
   * 
   * @param localRoot the root
   * @return the new root
   */
  private TreeNode<E> replaceNode(TreeNode<E> localRoot) {
    deletedReturn = localRoot.data;
    if (localRoot.left == null) {
      return localRoot.right;
    } else if (localRoot.right == null) {
      return localRoot.left;
    } else {
      if (localRoot.left.right == null) {
        localRoot.data = localRoot.left.data;
        localRoot.left = localRoot.left.left;
        return localRoot;
      } else {
        localRoot.data = findLargestChild(localRoot.left);
        return localRoot;
      }
    }
  }


  /**
   * Finds the largest value in the left subtree.
   * 
   * @param parent the root of the current sub tree
   * @return the data in order predecessor
   */
  private E findLargestChild(TreeNode<E> parent) {
    if (parent.right.right == null) {
      E returnValue = parent.right.data;
      parent.right = parent.right.left;
      return returnValue;
    } else {
      return findLargestChild(parent.right);
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h09.SearchTree#remove(java.lang.Object)
   */
  @Override
  public boolean remove(E target) {
    if (contains(target)) {
      delete(target);
      size--;
      return true;
    } else {
      return false;
    }
  }
}
