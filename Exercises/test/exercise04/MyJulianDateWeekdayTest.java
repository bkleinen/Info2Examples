package exercise04;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exercise04.JulianDate;
import exercise04.MyJulianDate;

@RunWith(Parameterized.class)
public class MyJulianDateWeekdayTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 22, 4, 2012, JulianDate.Day.Sunday },
				{ 1, 1, 2012, JulianDate.Day.Sunday },
				{ 16, 02, 1986, JulianDate.Day.Tuesday },
				{ 7, 12, 2011, JulianDate.Day.Wednesday },
				{ 27, 6, 2009, JulianDate.Day.Saturday },
				{ 2, 2, 2009, JulianDate.Day.Monday } });
	}

	MyJulianDate sut;
	JulianDate.Day expectedWeekday;

	public MyJulianDateWeekdayTest(int day, int month, int year,
			JulianDate.Day weekday) {
		sut = new MyJulianDate(day, month, year);
		expectedWeekday = weekday;
	}

	@Test
	public void testWeekday() {
		assertEquals(expectedWeekday, sut.getWeekday());
	}

}