package exercise04;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exercise04.JulianDate;
import exercise04.MetricDate;
import exercise04.MyJulianDate;

public class MetricDateTest {

	@Test
	public void julian2metricTestReformDay() {
		MyJulianDate julianDate = new MyJulianDate(MetricDate.REFORMDAY);
		MetricDate metricDate = new MetricDate(julianDate);
		assertEquals("day", julianDate.getDay(), metricDate.getDay());
		assertEquals("month", julianDate.getMonth(), metricDate.getMonth());
		assertEquals("year", julianDate.getDay(), metricDate.getYear());
	}

	@Test
	public void createtest() {
		MetricDate metricDate = new MetricDate(479234);
		assertEquals("day", 35, metricDate.getDay());
		assertEquals("month", 3, metricDate.getMonth());
		assertEquals("year", 480, metricDate.getYear());
		assertEquals("weekday", JulianDate.Day.Friday, metricDate.getWeekday());
	}

	@Test
	public void createtest3() {
		MetricDate metricDate = new MetricDate(10009);
		assertEquals("day", 10, metricDate.getDay());
		assertEquals("month", 1, metricDate.getMonth());
		assertEquals("year", 11, metricDate.getYear());
		assertEquals("weekday", JulianDate.Day.Sunday3, metricDate.getWeekday());
	}

	@Test
	public void createtest1() {
		MetricDate metricDate = new MetricDate(1);
		assertEquals("day", 2, metricDate.getDay());
		assertEquals("month", 1, metricDate.getMonth());
		assertEquals("year", 1, metricDate.getYear());
		assertEquals("weekday", JulianDate.Day.Tuesday, metricDate.getWeekday());
	}

	@Test
	public void testConversion() {
		MyJulianDate julianDate = new MyJulianDate(16, 02, 1986);
		MetricDate metricDate = new MetricDate(julianDate);
		MyJulianDate doubleConverted = metricDate.toJulianDate();
		assertEquals(julianDate, doubleConverted);
		assertEquals("73.10.0719", metricDate.toString());
	}
}
