package edu.ics211.h01;

import java.util.Comparator;

public class AbvComparator implements Comparator<Beer> {

  @Override
  public int compare(Beer o1, Beer o2) {
    if (o1.abv > o2.abv)
      return 1;
    if (o1.abv < o2.abv)
      return -1;
    else
      return 0;
  }
}
