package edu.ics211.h01;

import java.util.Comparator;

public class IbuComparator implements Comparator<Beer> {

  @Override
  public int compare(Beer o1, Beer o2) {
    return o1.ibu.compareTo(o2.ibu);
  }
}
