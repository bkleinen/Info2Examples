package com.bruceeckel.dirlist;



import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
//From 'Thinking in Java, 2nd Ed.' by Bruce Eckel
//www.BruceEckel.com. See copyright notice in CopyRight.txt.
//Additional comments inserted by D. Weber-Wulff


public class AlphabeticComparator
 // Compares two strings, irrespective of capitalization
 implements Comparator{
   public int compare(Object o1, Object o2) {
     String s1 = (String)o1;
     String s2 = (String)o2;
     return s1.toLowerCase().compareTo(
       s2.toLowerCase());
   }
 } 
