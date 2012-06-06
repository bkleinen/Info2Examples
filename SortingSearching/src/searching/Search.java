package searching;

public class Search<E extends Comparable<E>> {
	public int binarySearch(E[] a, E key) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid].compareTo(key) == 0)
				return mid;
			if (a[mid].compareTo(key) < 0)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	public int binarySearchRec(E[] a, E key, int low, int high) {
		if (low == high && a[low].compareTo(key) != 0)
			return -1;
		int mid = (low + high) / 2;
		if (a[mid].compareTo(key) == 0)
			return mid;

		if (a[mid].compareTo(key) < 0)
			return binarySearchRec(a, key, mid + 1, high);
		else
			return binarySearchRec(a, key, low, mid - 1);
	}

	public Object binarySearchRec(E[] a, E key) {
		return binarySearchRec(a, key, 0, a.length - 1);
	}

}
