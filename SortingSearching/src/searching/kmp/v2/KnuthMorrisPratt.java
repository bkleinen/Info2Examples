package searching.kmp.v2;

public class KnuthMorrisPratt {
	/**
	 * "we know exactly at which places a new potential match which could
	 * continue to the current position could begin prior to the current
	 * position." http://en.wikipedia.org/wiki/Knuth–Morris–Pratt_algorithm
	 * 
	 * @param pattern
	 * @return
	 */
	public int[] createFailureFunction(String p) {
		int[] t = new int[p.length()];
		t[0] = -1;
		t[1] = 0;
		int pos = 2;
		int cnd = 0;
		while (pos < t.length) {
			// substring continues
			if (p.charAt(pos - 1) == p.charAt(cnd)) {
				cnd++;
				t[pos] = cnd;
				pos++;
				// it doesn't, but we can fall back
			} else if (cnd > 0)
				cnd = t[cnd];
			else {
				t[pos] = 0;
				pos++;
			}
		}
		return t;
	}

	public int search(String pattern, String stringToSearch) {
		int m = 0; // beginningOfCurrentMatch
		int i = 0; // positionOfCurrentMatchInPattern
		int[] t = createFailureFunction(pattern);
		while (m < stringToSearch.length()) {
			if (pattern.charAt(i) == stringToSearch.charAt(m + i)) {
				if (i == pattern.length() - 1)
					return m;
				else
					i++;
			} else {
				m = m + i - t[i];
				if (t[i] > -1)
					i = t[i];
				else
					i = 0;
			}
		}
		return -1;
	}
}
