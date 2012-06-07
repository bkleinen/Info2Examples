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
		t[0] = 0;
		int pos = 1;
		int cnd = 0;
		while (pos < t.length) {
			// substring continues
			if (p.charAt(pos) == p.charAt(cnd)) {
				cnd++;
				t[pos] = cnd;
				pos++;
				// it doesn't, but we can fall back
			} else if (cnd > 0)
				cnd = t[cnd - 1];
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
		while (m + i < stringToSearch.length()) {
			if (pattern.charAt(i) == stringToSearch.charAt(m + i)) {
				if (i == pattern.length() - 1)
					return m;
				else
					i++;
			} else {
				if (i == 0)
					m++;
				else {
					m = m + i - t[i - 1];
					i = t[i - 1];
				}
			}
		}
		return -1;
	}
}
