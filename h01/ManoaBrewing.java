package edu.ics211.h01;

/**
 * Represents the ManoaBrewing singleton. The best brewery in the islands.
 * 
 * @author Rei Yamamoto
 * lines 9-27 from screenshot on H01 page.
 */
public class ManoaBrewing implements IBrewery {
  private static ManoaBrewing instance;


  /** Hide the default constructor. So no one can create an instance. */
  private ManoaBrewing() {
  }


  /**
   * Returns the singleton instance.
   * 
   * @return the singleton instance.
   */
  public static ManoaBrewing getInstance() {
    if (instance == null) {
      instance = new ManoaBrewing();
    }
    return instance;
  }


  /* (non-Javadoc)
   * @see edu.ics211.h01.IBrewery#brewBeer(java.lang.String, java.lang.String)
   */
  @Override
  public Beer brewBeer(String name, String type) {
    if (type == "Pilsner") {
      return new Pilsner(name);
    } else if (type == "India Pale Ale") {
      return new IndiaPaleAle(name);
    } else if (type == "Bohemian Pilsner") {
      return new BohemianPilsner(name);
    } else {
      throw new IllegalArgumentException("It must be Pilsner, India Pale Ale or Bohemian Pilsner.");
    }
  }


  /* (non-Javadoc)
   * @see edu.ics211.h01.IBrewery#brewPilsner(java.lang.String, java.lang.Integer, java.lang.Double)
   */
  @Override
  public Beer brewPilsner(String name, Integer ibu, Double abv) {
    if ((ibu >= 25 && ibu <= 45) || (abv >= 4.2 && abv <= 6.0)) {
      return new Pilsner(name, ibu, abv);
    } else {
      throw new IllegalArgumentException("It cannot be a Pilsner.");
    }

  }


  /* (non-Javadoc)
   * @see edu.ics211.h01.IBrewery#brewBohemianPilsner(java.lang.String, java.lang.Integer, java.lang.Double)
   */
  @Override
  public Beer brewBohemianPilsner(String name, Integer ibu, Double abv) {
    if ((ibu > 35 && ibu < 45) || (abv > 4.2 && abv < 5.4)) {
      return new BohemianPilsner(name);
    } else {
      throw new IllegalArgumentException("It cannot be a Bohemian Pilsner.");
    }
  }


  /* (non-Javadoc)
   * @see edu.ics211.h01.IBrewery#brewIndiaPaleAle(java.lang.String, java.lang.Integer, java.lang.Double)
   */
  @Override
  public Beer brewIndiaPaleAle(String name, Integer ibu, Double abv) {
    if ((ibu > 40 && ibu < 100) || (abv > 5.0 && abv < 10.0)) {
      return new IndiaPaleAle(name);
    } else {
      throw new IllegalArgumentException("It cannot be a India Pale Ale.");
    }
  }
}
