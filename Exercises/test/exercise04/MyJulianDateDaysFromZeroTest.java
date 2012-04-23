package exercise04;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exercise04.MyJulianDate;

@RunWith(Parameterized.class)
public class MyJulianDateDaysFromZeroTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 1, 1, 1 }, { 31, 1, 1 },
				{ 31, 1, 2012 }, { 31, 12, 2012 }, { 1, 6, 100 }, { 1, 7, 1 },
				{ 28, 2, 2011 }, {1, 3, 2012 }, { 29, 2, 2012 } });
	}

	MyJulianDate sut;

	public MyJulianDateDaysFromZeroTest(int day, int month, int year) {
		sut = new MyJulianDate(day, month, year);
	}

	@Test
	public void testDaysFromZero() {
		MyJulianDate clone = new MyJulianDate(sut.daysFromZero());
		assertEquals(sut, clone);
	}

}
