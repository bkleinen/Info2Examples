package com.bruceeckel.makedirs;

//: c11:MakeDirectories.java
//From 'Thinking in Java, 2nd Ed.' by Bruce Eckel
//www.BruceEckel.com. See copyright notice in CopyRight.txt.
//Demonstrates the use of the File class to
//create directories and manipulate files.
import java.io.File;

public class MakeDirectories {
	private final static String usage = "Usage:MakeDirectories path1 ...\n"
			+ "Creates each path\n" + "Usage:MakeDirectories -d path1 ...\n"
			+ "Deletes each path\n" + "Usage:MakeDirectories -r path1 path2\n"
			+ "Renames from path1 to path2\n";

	private static void usage() {
		System.err.println(usage);
		System.exit(1);
	}

	private static void fileData(File f) {
		System.out.println("Absolute path: " + f.getAbsolutePath()
				+ "\n Can read: " + f.canRead() + "\n Can write: "
				+ f.canWrite() + "\n getName: " + f.getName()
				+ "\n getParent: " + f.getParent() + "\n getPath: "
				+ f.getPath() + "\n length: " + f.length()
				+ "\n lastModified: " + f.lastModified());
		if (f.isFile())
			System.out.println("it's a file");
		else if (f.isDirectory())
			System.out.println("it's a directory");
	}

	public static void main(String[] args) {
		if (args.length < 1)
			usage();
		if (args[0].equals("-r")) {
			if (args.length != 3)
				usage();
			File old = new File(args[1]), rname = new File(args[2]);
			old.renameTo(rname);
			fileData(old);
			fileData(rname);
			return; // Exit main
		}
		int count = 0;
		boolean del = false;
		if (args[0].equals("-d")) {
			count++;
			del = true;
		}
		for (; count < args.length; count++) {
			File f = new File(args[count]);
			if (f.exists()) {
				System.out.println(f + " exists");
				if (del) {
					System.out.println("deleting..." + f);
					f.delete();
				}
			} else { // Doesn't exist
				if (!del) {
					f.mkdirs();
					System.out.println("created " + f);
				}
			}
			fileData(f);
		}
	}
} // /:~