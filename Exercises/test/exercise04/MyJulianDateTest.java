package exercise04;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exercise04.MyJulianDate;

public class MyJulianDateTest {

	@Test
	public void testDaysFromZero() {
		MyJulianDate sut = new MyJulianDate(1, 1, 1);
		assertEquals("this is the first day", 0, sut.daysFromZero());
		sut = new MyJulianDate(2, 1, 1);
		assertEquals("this is the second day", 1, sut.daysFromZero());
		sut = new MyJulianDate(4, 1, 1);
		assertEquals("this is the forth day", 3, sut.daysFromZero());
		sut = new MyJulianDate(1, 2, 1);
		assertEquals("January", 31, sut.daysFromZero());
		sut = new MyJulianDate(1, 3, 1);
		assertEquals("February", 31 + 28, sut.daysFromZero());
	}
	@Test
	public void testDaysFromZeroNow() {
		MyJulianDate sut = new MyJulianDate(23, 4, 2012);
		assertEquals("this is now", 734630, sut.daysFromZero());
		assertEquals("day should be the same",23,sut.getDay());
		assertEquals("month should be the same",4,sut.getMonth());
		assertEquals("year should be the same",2012,sut.getYear());
		
		
	}

	@Test
	public void testDaysFromZeroYear() {
		MyJulianDate sut = new MyJulianDate(1, 1, 2);
		assertEquals("this is the first year", 365, sut.daysFromZero());
		sut = new MyJulianDate(1, 1, 3);
		assertEquals("this is the second year", 2 * 365, sut.daysFromZero());
		sut = new MyJulianDate(1, 1, 5);
		assertEquals("this is the fifth year including one leap year",
				4 * 365 + 1, sut.daysFromZero());

	}

	@Test
	public void testFieldsAndConstructor() {
		MyJulianDate sut = new MyJulianDate(1, 2, 3);
		assertEquals("day should be 1", 1, sut.getDay());
		assertEquals("month should be 2", 2, sut.getMonth());
		assertEquals("year should be 3", 3, sut.getYear());
	}

	@Test
	public void testDaysBeetweenToday() {
		MyJulianDate sut1 = new MyJulianDate(1, 1, 2012);
		MyJulianDate sut2 = new MyJulianDate(22, 04, 2012);
		assertEquals("days inbetween excel", 112, sut2.daysBeetween(sut1));
	}

	@Test
	public void testDaysBeetweenLeapDay() {
		MyJulianDate sut1 = new MyJulianDate(1, 1, 2012);
		assertEquals("days inbetween excel", 58,
				new MyJulianDate(28, 02, 2012).daysBeetween(sut1));
		assertEquals("days inbetween excel", 59,
				new MyJulianDate(29, 02, 2012).daysBeetween(sut1));
		assertEquals("days inbetween excel", 60,
				new MyJulianDate(01, 03, 2012).daysBeetween(sut1));
	}

	@Test
	public void testDaysBeetweenWithinOneMonth() {
		MyJulianDate sut1 = new MyJulianDate(1, 2, 3);
		MyJulianDate sut2 = new MyJulianDate(24, 2, 3);
		assertEquals("days within one month", 23, sut2.daysBeetween(sut1));
	}

	@Test
	public void testDaysBeetweenFebruary() {
		MyJulianDate sut1 = new MyJulianDate(1, 2, 3);
		MyJulianDate sut2 = new MyJulianDate(1, 3, 3);
		assertEquals("days within one month", 28, sut2.daysBeetween(sut1));
	}

	@Test
	public void testDaysBeetweenMarch() {
		MyJulianDate sut1 = new MyJulianDate(1, 3, 3);
		MyJulianDate sut2 = new MyJulianDate(1, 4, 3);
		assertEquals("days within one month", 31, sut2.daysBeetween(sut1));
	}

	@Test
	public void testDaysBeetweenSeptember() {
		MyJulianDate sut1 = new MyJulianDate(1, 9, 3);
		MyJulianDate sut2 = new MyJulianDate(11, 10, 3);
		assertEquals("days within one month", 40, sut2.daysBeetween(sut1));
	}

	@Test
	public void testToString() {
		MyJulianDate sut1 = new MyJulianDate(14, 07, 2012);
		assertEquals("14.07.2012", sut1.toString());

	}
	@Test
	public void testToString2() {
		MyJulianDate sut1 = new MyJulianDate(01, 02, 10);
		assertEquals("01.02.0010", sut1.toString());

	}
	@Test
	public void testCreateFromDaysFromZero1(){
		MyJulianDate sut1 = new MyJulianDate(01, 02, 10);
		int dfz = sut1.daysFromZero();
		assertEquals(sut1,new MyJulianDate(dfz));
	}

	@Test
	public void testCreateFromDaysFromZero2(){
		MyJulianDate sut1 = new MyJulianDate(22, 04, 2012);
		int dfz = sut1.daysFromZero();
		assertEquals(sut1,new MyJulianDate(dfz));
	}
	
	@Test
	public void testTomorrow() {
		MyJulianDate sut1 = new MyJulianDate(22, 04, 2012);
		assertEquals("tomorrow", new MyJulianDate(23, 04, 2012),
				sut1.tomorrow());
	}

	@Test
	public void testYesterday() {
		MyJulianDate sut1 = new MyJulianDate(22, 04, 2012);
		assertEquals("yesterday", new MyJulianDate(21, 04, 2012),
				sut1.yesterday());
	}

	@Test
	public void testMyBirthday() {
		MyJulianDate today = new MyJulianDate(23, 04, 2012);
		MyJulianDate birthday = new MyJulianDate(16, 02, 1986);
		assertEquals("",15658,today.daysBeetween(birthday));
	}

}
