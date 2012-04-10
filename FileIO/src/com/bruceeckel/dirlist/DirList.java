package com.bruceeckel.dirlist;

//Displays directory listing.
import java.io.File;
import java.util.Arrays;

public class DirList {
 public static void main(String[] args) {
	  
	    // Since an IOException can be thrown, we will ignore it.
   try {
		  // We will just list the files in the current directory
     File path = new File(".");
		  
     String[] list;

     // Find the file names in question
     if(args.length == 0)
       //  If you call list( ) with no arguments,
       //  you’ll get the full list that the File object contains.
       list = path.list();
			
     else
       // However, if you want a restricted list, for example,
       // all of the files with an extension of .java, then you
       // use a “directory filter,” which is a class that tells
       // how to select the File objects for display.
       list = path.list(new DirFilter(args[0]));

     // Sort the files, ignoring capitalization
		  // Unix does this for you automatically, Windows does not
     Arrays.sort(list, new AlphabeticComparator());

     // Output them to the console
     for(int i = 0; i < list.length; i++)
       System.out.println(list[i]);
			
   } catch(Exception e) {e.printStackTrace(); }
 }
}
