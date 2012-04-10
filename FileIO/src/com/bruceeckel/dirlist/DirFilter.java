package com.bruceeckel.dirlist;

import java.io.File;
import java.io.FilenameFilter;

class DirFilter implements FilenameFilter {
	   String afn;
	   DirFilter(String afn) {
		   this.afn = afn; 
		   }
	   public boolean accept(File dir, String name) {
	     // Strip path information:
	     String f = new File(name).getName();
			// return true if afn can be found in the name anywhere
	     return f.indexOf(afn) != -1;
	   }
	 }

