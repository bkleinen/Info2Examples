package exercise04;

public interface JulianDate {
	public enum Day {
		Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday, Sunday1, Sunday2, Sunday3
	}
	JulianDate tomorrow();
	JulianDate yesterday();
	long daysBetween(JulianDate other);
	Day weekday();
	void setDate(int day,int month,int year, int hour,int minute);
	void setJD(long jd);
	String getDate();
	long getJD();
}
