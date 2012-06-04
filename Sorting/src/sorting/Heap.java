package sorting;

import java.util.Arrays;
import static sorting.SortHelpers.swap;

public class Heap<E extends Comparable<E>> {
	E[] a;
	int heapSize;

	public Heap(E[] a) {
		heapSize = a.length;
		this.a = Arrays.copyOf(a, heapSize);
	}

	public int left(int i) {
		return 2 * i + 1;
	}

	public int right(int i) {
		return 2 * i + 2;
	}

	public int parent(int i) {
		return (i - 1) / 2;
	}

	public void maxHeapify() {
		for (int i = parent(heapSize); i >= 0; i--)
			maxHeapify(i);
	}

	public void maxHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int largest = -1;
		if (l <= heapSize && a[l].compareTo(a[i]) > 0)
			largest = l;
		else
			largest = i;
		if (l <= heapSize && a[r].compareTo(a[largest]) > 0)
			largest = r;
		if (largest != i)
			swap(a, i, largest);
		maxHeapify(largest);
	}

	public E get(int i) {
		return a[i];
	}

	public int heapSize() {
		return heapSize;
	}

	public void removeLastElementFromHeap() {
		heapSize--;

	}

	@Override
	public String toString() {
		return "GenericHeap Size " + heapSize + " "
				+ Arrays.toString(Arrays.copyOf(a, heapSize)) + " Rest: "
				+ Arrays.toString(Arrays.copyOfRange(a, heapSize, a.length));
	}

	public boolean isMaxHeap() {
		for (int i = 0; i < heapSize / 2; i++) {
			int l = left(i);
			int r = right(i);
			if ((l < heapSize && a[i].compareTo(a[left(i)]) < 0)
					|| (r < heapSize && a[i].compareTo(a[right(i)]) < 0))
				return false;
		}
		return true;
	}
}
