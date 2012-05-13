package errorhandling;

/**
 * †berschrift: Beschreibung: adapted from
 * http://people.f4.htw-berlin.de/~weberwu/info2/Handouts/Underflow.java
 * Copyright: Copyright (c) 2002 Organisation:
 * 
 * @author DWW, BK
 * @version 1.0
 */

public class Underflow extends Exception {

	private static final long serialVersionUID = 1427062030639479078L;
	protected String where;

	public Underflow(String s) {
		where = s;
	}

	public String whoCausedException() {
		return where;
	}
}