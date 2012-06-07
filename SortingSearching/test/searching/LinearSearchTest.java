package searching;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LinearSearchTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSearch() {
		LinearSearch<String> sut = new LinearSearch<String>();
		List<String> a = new ArrayList<String>();
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("d");
		a.add("e");
		String x = "d";
		String result = sut.search(a, x);
		assertEquals(x,result);
		assertEquals("d",sut.search(a, "d"));
		assertEquals(null,sut.search(a, "f"));
		
	}

}
