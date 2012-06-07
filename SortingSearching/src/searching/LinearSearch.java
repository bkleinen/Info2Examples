package searching;

import java.util.List;

public class LinearSearch<E> {
	public E search(List<E> a, E x) {
		for (E s : a) {
			if (s.equals(x))
				return s;
		}
		return null;
	}

}
