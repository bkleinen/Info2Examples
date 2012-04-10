package com.bruceeckel.dirlist;

import java.util.Comparator;

public class AlphabeticComparatorTypeSafe
// Compares two strings, irrespective of capitalization
implements Comparator<String>{
  public int compare(String s1, String s2) {
    return s1.toLowerCase().compareTo(
      s2.toLowerCase());
  }
}