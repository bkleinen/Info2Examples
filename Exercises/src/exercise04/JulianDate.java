package exercise04;

public interface JulianDate {
	public enum Day {
		Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday, Sunday1, Sunday2, Sunday3
	}

	public enum Month {
		January, February, March, April, May, June, July, August, September, October, November, December
	};

	public static int[] DaysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,
			30, 31 };
	public static double DAYSINYEAR = 365.25;

	public int daysBeetween(JulianDate other);

	public int daysFromZero();

	public JulianDate daysFromThis();

	public JulianDate tomorrow();

	public JulianDate yesterday();

	public Day getWeekday();

	public int getDay();

	public int getMonth();

	public int getYear();



}
