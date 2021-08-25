/**
 * 
 */
package edu.ics211.h01;

/**
 * extends the beer class and randomly sets the abv and ibu and throws and illegal argument exeption if they are out of
 * range.
 * 
 * @author Rei Yamamoto
 *
 */
public class Pilsner extends Beer {

  /**
   * sets the name, and throws an Illegal argument exception if the ibu and abv are out of range.
   * 
   * @param name the name
   * @param ibu the ibu
   * @param abv the abv
   */
  public Pilsner(String name, Integer ibu, double abv) {
    super(name, "Pilsner", ibu, abv);
    if (((this.ibu < 25) || (this.ibu > 45))) {
      throw new IllegalArgumentException("Not a valid ibu");
    }
    if (((this.abv < 4.2) || (this.abv > 6.0))) {
      throw new IllegalArgumentException("Not a valid abv");
    }
  }


  /**
   * randomly sets the ibu and abv.
   * 
   * @param name the name
   */
  public Pilsner(String name) {
    super(name, "Pilsner", (int) (Math.random() * 20 + 25),
        (double) (Math.random() * 1.8 + 4.2));
  }

}
