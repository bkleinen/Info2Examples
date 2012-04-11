package subsequence;

import info2.subsequence.MCSS;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MCSSTest {
	static MCSS mcss = new MCSS();

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { {  mcss.new ResultSet(3,0,1),new Integer[] { 1, 2 } },
				{  mcss.new ResultSet(20,1,3),new Integer[] { -2, 11, -4, 13, -5, 2 }
				},
				{  mcss.new ResultSet(7,2,5),new Integer[] { 1, -3, 4, -2, -1, 6 }
				 }};
		return Arrays.asList(data);
	}

	int[] a;
	MCSS.ResultSet expectedResultSet;

	public MCSSTest(MCSS.ResultSet resultSet, Integer[] a) {
		expectedResultSet = resultSet;
		this.a = new int[a.length];
		// java sucks. sometimes.
		for (int i = 0; i < a.length; i++)
			this.a[i] = a[i];
	}

	@Test
	public void bruteForce() {
		assertEquals(expectedResultSet, mcss.bruteForce(a));
	}

	
	@Test
	public void quadratic() {
		assertEquals(expectedResultSet, mcss.quadratic(a));
	}
	@Test
	public void linear() {
		assertEquals(expectedResultSet, mcss.linear(a));
	}
}
