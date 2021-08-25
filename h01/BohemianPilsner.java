/**
 * 
 */
package edu.ics211.h01;

/**
 * Bohemian pilsner class that extends the pilsner class and randomly sets the abv and ibu and throws and illegal
 * argument exception if they are out of range.
 * 
 * @author Rei Yamamoto
 *
 */
public class BohemianPilsner extends Pilsner {

  /**
   * throws an illegal argument exception if the abu and ibv are out of range.
   * 
   * @param name the name
   * @param ibu the ibu
   * @param abv the abv
   */
  public BohemianPilsner(String name, Integer ibu, double abv) {
    super(name, ibu, abv);
    if (((this.ibu < 35) || (this.ibu > 45))) {
      throw new IllegalArgumentException("Not a valid ibu");
    }
    if (((this.abv < 4.2) || (this.abv > 5.4))) {
      throw new IllegalArgumentException("Not a valid abv");
    }
  }


  /**
   * randomly sets the ibu and abv of the beer.
   * 
   * @param name the name
   */
  public BohemianPilsner(String name) {
    super(name, (int) (Math.random() * 10 + 35),
        (double) (Math.random() * 1.2 + 4.2));

  }

}
