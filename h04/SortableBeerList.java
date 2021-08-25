package edu.ics211.h04;

import edu.ics211.h01.Beer;
import edu.ics211.h04.IList211;
import java.util.Comparator;

/**
 * implements the IList211 for the type Beer.
 * 
 * @author Rei
 *
 */
public class SortableBeerList implements IList211<Beer> {
  private SortableList<Beer> beerList;
  private int size;
  private Comparator<Beer> compare;


  /**
   * constructor to initialze the beerList and compare.
   * 
   * @param compare compares the items
   */
  public SortableBeerList(Comparator<Beer> compare) {
    this.compare = compare;
    beerList = new SortableList<Beer>();
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#get(int)
   */
  @Override
  public Beer get(int index) {
    return beerList.get(index);
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#set(int, java.lang.Object)
   */
  @Override
  public Beer set(int index, Beer element) {
    Beer temp = beerList.get(index);
    beerList.set(index, element);
    beerList.insertionSort(compare);
    return temp;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#indexOf(java.lang.Object)
   */
  @Override
  public int indexOf(Object obj) {
    return beerList.indexOf(obj);
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
  public boolean add(Beer e) {
    beerList.add(e);
    size++;
    beerList.insertionSort(compare);
    return true;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#add(int, java.lang.Object)
   */
  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#add(int, java.lang.Object)
   */
  @Override
  public void add(int index, Beer element) {
    beerList.add(index, element);
    size++;
    beerList.insertionSort(compare);
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#remove(int)
   */
  @Override
  public Beer remove(int index) {
    Beer temp = beerList.get(index);
    beerList.remove(index);
    size--;
    return temp;
  }

}
