
package edu.ics211.h10;

import java.util.Comparator;

/**
 * Creates a medium potion bag. Some code from HW09.
 * 
 * @author Rei Yamamoto helped by Jonathan Oba
 *
 */
public class MediumPotionBag implements PotionBag {
  private static MediumPotionBag mBag = new MediumPotionBag();
  private Comparator<Potion> comp;
  private TreeNode root;
  protected boolean addReturn;
  protected Potion deleteReturn;
  private int size;
  private double time;

  /**
   * Private inner class that creates a TreeNode.
   * 
   * @author Rei Yamamoto
   *
   * @param <Potion> a potion
   */
  private class TreeNode<Potion> {
    Potion data;
    TreeNode<Potion> left;
    TreeNode<Potion> right;


    /**
     * Constructor for the treeNode inner class.
     * 
     * @param data the data to put into the node
     */
    public TreeNode(Potion data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }


    /**
     * Initilizes the left right and data variables.
     * 
     * @param data the data in the node
     * @param left the left TreeNode
     * @param right the right TreeNode
     */
    public TreeNode(Potion data, TreeNode<Potion> left, TreeNode<Potion> right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }


  /**
   * constructor for the medium potion bag class initializes the comparator.
   */
  private MediumPotionBag() {
    this.comp = new PotionComparator();
  }


  /**
   * Gets an instance of the Medium potion bag.
   * 
   * @return mBag the instance of the bag
   */
  public static MediumPotionBag getInstance() {
    if (mBag == null) {
      mBag = new MediumPotionBag();
    }
    return mBag;
  }


  /**
   * adds the item.
   * 
   * @param item the thing to add
   * @return true or false is the item was added
   */
  public boolean add(Potion item) {
    if (item == null) {
      throw new NullPointerException();
    }
    root = add(root, item);
    size++;
    return addReturn;
  }


  /**
   * helper method to add an item into the tree.
   * 
   * @param localRoot the root of the tree
   * @param item the item to add
   * @return true or false if the item was added or not
   */
  private TreeNode<Potion> add(TreeNode<Potion> localRoot, Potion item) {
    if (localRoot == null) {
      addReturn = true;
      return new TreeNode<Potion>(item);
    }
    int result = comp.compare(item, localRoot.data);
    if (result == 0) {
      addReturn = false;
      return localRoot;
    } else if (result > 0) {
      localRoot.right = add(localRoot.right, item);
      return localRoot;
    } else {
      localRoot.left = add(localRoot.left, item);
      return localRoot;
    }

  }


  /**
   * deletes the thing from the tree.
   * 
   * @param target the thing you want to delete
   * @return the thing deleted
   */
  public Potion delete(Potion target) {
    if (target == null) {
      return null;
    }
    root = delete(root, target);
    size--;
    return deleteReturn;
  }


  /**
   * Deletes the target from the tree.
   * 
   * @param localRoot the root of the tree
   * @param target the thing to delete
   * @return the new root
   */
  private TreeNode<Potion> delete(TreeNode<Potion> localRoot, Potion target) {
    if (localRoot == null) {
      deleteReturn = null;
      return localRoot;
    }
    int result = comp.compare(target, localRoot.data);
    if (result < 0) {
      localRoot.left = delete(localRoot.left, target);
      return localRoot;
    } else if (result > 0) {
      localRoot.right = delete(localRoot.right, target);
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
  private TreeNode<Potion> replaceNode(TreeNode<Potion> localRoot) {
    deleteReturn = localRoot.data;
    if (localRoot.left == null) {
      return localRoot.right;
    } else if (localRoot.right == null) {
      return localRoot.left;
    } else if (localRoot.left.right == null) {
      localRoot.data = localRoot.left.data;
      localRoot.left = localRoot.left.left;
      return localRoot;
    } else {
      localRoot.data = findLargestChild(localRoot.left);
      return localRoot;
    }
  }


  /**
   * Finds the largest value in the left subtree.
   * 
   * @param parent the root of the current sub tree
   * @return the data in order predecessor
   */
  private Potion findLargestChild(TreeNode<Potion> parent) {
    if (parent.right.right == null) {
      Potion value = parent.right.data;
      parent.right = parent.right.left;
      return value;
    } else {
      return findLargestChild(parent.right);
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#store(edu.ics211.h10.Potion)
   */
  @Override
  public void store(Potion p) {
    mBag.add(p);
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#timedStore(edu.ics211.h10.Potion)
   */
  @Override
  public long timedStore(Potion p) {
    long start = System.nanoTime();
    store(p);
    long end = System.nanoTime();
    long result = end - start;
    return result;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#retrieve(edu.ics211.h10.Potion)
   */
  @Override
  public Potion retrieve(Potion p) {
    return mBag.delete(p);

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#timedRetrieve(edu.ics211.h10.Potion)
   */
  @Override
  public long timedRetrieve(Potion p) {
    long start = System.nanoTime();
    retrieve(p);
    long end = System.nanoTime();
    long result = end - start;
    return result;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#size()
   */
  @Override
  public int size() {
    return size;
  }

}
