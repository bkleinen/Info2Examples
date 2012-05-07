package permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {


	public String without(String theString, int index) {
		return theString.substring(0, index) + theString.substring(index + 1);
	}

	public List<String> compute(String originalString) {
		List<String> result = new ArrayList<String>();
		compute("", originalString, result);
		return result;
	}

	public void compute(String prefix, String rest, List<String> result) {
		if (rest.length() == 1) {
			result.add(prefix+rest);
		}
		for (int i = 0; i < rest.length(); i++) {
			compute(prefix + rest.charAt(i), without(rest, i), result);
		}
	}


}
