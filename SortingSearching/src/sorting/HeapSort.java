package sorting;


public class HeapSort<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public void sort(E[] a) {
		// Build-Max-Heap(A)
		Heap<E> h = new Heap<E>(a);
		// for i = A.length downto 2
		for (int i = h.a.length - 1; i >= 1; i--) {
			// exchange A[1] with A[i]
			exchange(h.a, 0, i);
			// A.heap-size = A.heap-size-1
			h.removeLastElementFromHeap();
			// Max-Heapify(A,1)
			h.maxHeapify(0);
		}
	}

	private void exchange(E[] a, int i, int j) {
		E t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
