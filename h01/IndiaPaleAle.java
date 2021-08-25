/**
 * 
 */
package edu.ics211.h01;

/**
 * India Pale Ale class that extends beer and randomly sets the abv and ibu and throws and illegal argument exception if
 * they are out of range.
 * 
 * @author Rei Yamamoto
 *
 */
public class IndiaPaleAle extends Beer {

  /**
   * throws an illegal argument exception if the abu and ibv are out of range.
   * 
   * @param name the name
   * @param ibu the ibu
   * @param abv the abv
   */
  public IndiaPaleAle(String name, Integer ibu, double abv) {
    super(name, "IndiaPaleAle", ibu, abv);
    if (((this.ibu < 40) || (this.ibu > 100))) {
      throw new IllegalArgumentException("Not a valid ibu");
    }
    if (((this.abv < 5.0) || (this.abv > 10.0))) {
      throw new IllegalArgumentException("Not a valid abvs");
    }
  }


  /**
   * randomly sets the ibu and abv of the beer.
   * 
   * @param name the name
   */
  public IndiaPaleAle(String name) {
    super(name, "India Pale Ale", (int) (Math.random() * 60 + 40),
        (double) (Math.random() * 5.0 + 5.0));
  }

}
