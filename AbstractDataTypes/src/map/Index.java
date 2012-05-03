package map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Index {
	Map<String, Set<Integer>> index = new TreeMap<String, Set<Integer>>();

	// Add a page reference to the index.
	void addReference(String term, int pageNum) {
		// The set of page references that we
		// have so far for the term.
		Set<Integer> references;
		references = index.get(term);

		if (references == null) {
			// This is the first reference
			Set<Integer> firstRef = new HashSet<Integer>();
			firstRef.add(new Integer(pageNum));
			index.put(term, firstRef);
		} else {
			references.add(new Integer(pageNum));
		}
	}

	void printIndex() {
		Set<Entry<String, Set<Integer>>> entries = index.entrySet();
		
		for (Entry<String, Set<Integer>> entry : entries) {
			String term = entry.getKey();
			Set<Integer> pages = entry.getValue();
			System.out.print(term + " ");
			printIntegers(pages);
			System.out.println();
		}
	}

	private void printIntegers(Set<Integer> pages) {

		String delim = "";
		for (Integer page : pages) {
			System.out.print(delim);
			System.out.print(page);
			delim = ", ";
		}
	}

	public static void main(String[] args) {
		Index index = new Index();
		index.addReference("hallo", 1);
		index.addReference("hallo", 2);
		index.addReference("bla", 5);
		index.printIndex();
	}
}