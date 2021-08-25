/**
 * 
 */

package edu.ics211.h01;

/**
 * gets the name, type, ibu and abv and then sets the name.
 * 
 * @author Rei Yamamoto
 *
 */
public class Beer implements Comparable<Beer> {
  /**
   * the name of the beer.
   * 
   */
  private String name;
  /**
   * the type of the beer.
   * 
   */
  private String type;
  /**
   * the ibu of the beer.
   * 
   */
  protected Integer ibu;
  /**
   * the abv of the beer.
   * 
   */
  protected double abv;


  /**
   * the beer constructor that sets the name, type, ibu and abv.
   * 
   * @param name the name of the beer
   * @param type the type of the beer
   * @param ibu the ibu of the beer
   * @param abv the abv of the beer
   */
  public Beer(String name, String type, Integer ibu, double abv) {
    super();
    this.name = name;
    this.type = type;
    this.ibu = ibu;
    this.abv = abv;
  }


  /**
   * beer constructor that sets the name and the type.
   * 
   * @param name the name of the beer
   * @param type the type of the beer
   */
  public Beer(String name, String type) {
    super();
    this.name = name;
    this.type = type;
  }


  /**
   * get's the name of the beer.
   * 
   * @return name the name of the beer
   */
  public String getName() {
    return name;
  }


  /**
   * sets the name of the beer.
   * 
   * @param name the name to be set
   */
  public void setName(String name) {
    this.name = name;
  }


  /**
   * gets the type of the beer.
   * 
   * @return type the type of the beer
   */
  public String getType() {
    return type;
  }


  /**
   * gets the ibu.
   * 
   * @return ibu the ibu of the beer
   */
  public Integer getIbu() {
    return ibu;
  }


  /**
   * gets the abv of the beer.
   * 
   * @return abv the beer's abv
   */
  public double getAbv() {
    return abv;
  }


  @Override
  public int compareTo(Beer o) {
    return name.compareTo(o.name);
  }
}
