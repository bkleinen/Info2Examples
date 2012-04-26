package exercise04;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JulianDateConversion {
	int day, month, year, hour, minute;
	double jd;
	JulianDate julianDate;

	public JulianDateConversion(int day, int month, int year, int hour,
			int minute, double jd) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.jd = jd;
	}

	/**
	 * <pre>
	 * Kalenderdatum	Julianisches Datum
	 * 1. Januar 1, 0000 UT (julianisch)	1.721.423,5000
	 * 27. Januar 333, 1200 UT (julianisch)	1.842.713,0000
	 * 4. Oktober 1582, 2400 UT (julianisch)	2.299.160,5000
	 * 15. Oktober 1582, 0000 UT (gregorianisch)	2.299.160,5000
	 * 1. Januar 1900, 0000 UT (gregorianisch)	2.415.020,5000
	 * 1. Januar 1990, 1200 UT (gregorianisch)	2.447.893,0000
	 * 1. Januar 1990, 1800 UT (gregorianisch)	2.447.893,2500
	 * 1. Januar 2000, 1200 UT (gregorianisch)	2.451.545,0000
	 * (Standardäquinoktium)
	 * 14. Januar 2006, 1630 UT (gregorianisch) 	2.453.750,1875
	 * 25. März 2010, 1630 UT (gregorianisch) 	2.455.281,1875
	 * 17. April 2012, 14:39:04 UT (gregorianisch) 	2.456.035,11046
	 * </pre>
	 */
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 1, 1, 1, 00, 00, 1721423.5000 },
				{ 27, 1, 333, 12, 0, 1842713.0000 },
				{ 4, 10, 1582, 24, 00, 2299160.5000 },
				{ 15, 10, 1582, 0, 0, 2299160.5000 },
				{ 1, 1, 1900, 0, 0, 2415020.5000 },
				{ 1, 1, 1990, 12, 0, 2447893.0000 },
				{ 1, 1, 1990, 18, 0, 2447893.2500 },
				{ 1, 1, 2000, 12, 00, 2451545.0000 },
				{ 25, 3, 2010, 16, 30, 2453750.1875 },
				{ 17, 4, 2012, 14, 39, 2456035.11046 } });
	}

	@Before
	public void setUp() {
		julianDate = new SimpleJulianDate();
	}

	@Test
	public void testGregorianToJD() {
		julianDate.setDate(day, month, year, hour, minute);
		assertEquals(toString(), jd, julianDate.getJD(),0.00001);
	}

	public String toString() {
		return String.format("%02d.%02d.%04d %02d:%02d / ", day, month, year,
				hour, minute) + jd;
	}
}
