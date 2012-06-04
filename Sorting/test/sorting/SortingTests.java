package sorting;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import sorting.InsertionSort;
import sorting.Quicksort;
import sorting.SelectionSort;
import sorting.Sorter;

@RunWith(Parameterized.class)
public class SortingTests {
	static abstract class Factory {
		abstract Sorter<Integer> createSorter();
	}

	public Factory factory;
	public String algorithm;
	public Sorter<Integer> sorter;

	public SortingTests(String algorithm, Factory factory) {
		this.algorithm = algorithm;
		this.factory = factory;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { "Insertion Sort", new Factory() {
			Sorter<Integer> createSorter() {
				return new InsertionSort<Integer>();
			}
		} }, { "Selection Sort", new Factory() {
			Sorter<Integer> createSorter() {
				return new SelectionSort<Integer>();
			}
		} }, { "Quick Sort", new Factory() {
			Sorter<Integer> createSorter() {
				return new Quicksort<Integer>();
			}
		} }, { "HeapSort", new Factory() {
			Sorter<Integer> createSorter() {
				return new HeapSort<Integer>();
			}
		} } };
		return Arrays.asList(data);
	}

	@Before
	public void setUp() throws Exception {
		sorter = factory.createSorter();
	}

	@Test
	public void testSort5() {
		Integer[] testArray = generateTestArray(5, 100);
		testSortingOn(testArray);

	}

	@Test
	public void testSort100() {
		Integer[] testArray = generateTestArray(100, 1000);
		testSortingOn(testArray);
	}

	private void testSortingOn(Integer[] testArray) {
		sorter.sort(testArray);
		for (int i = 0; i < testArray.length - 1; i++) {
			assertTrue(algorithm + " ta[" + i + "]=" + testArray[i] + " <= ta["
					+ (i + 1) + "]=" + testArray[i + 1] + " ",
					testArray[i] <= testArray[i + 1]);
		}

	}

	private Integer[] generateTestArray(int n, int max) {
		Integer[] theArray = new Integer[n];
		for (int i = 0; i < theArray.length; i++) {
			theArray[i] = (int) (Math.random() * max);
		}
		return theArray;
	}

}
