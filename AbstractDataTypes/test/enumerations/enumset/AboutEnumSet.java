package enumerations.enumset;

import static org.junit.Assert.assertEquals;

import java.awt.Font;
import java.util.EnumSet;

import org.junit.Test;

import enumerations.Season;
public class AboutEnumSet {

	@Test
	public void test() {
		EnumSet<Season> seasonSet = EnumSet.noneOf(Season.class);
		EnumSet<Season> seasonSet2 = EnumSet.allOf(Season.class);
		seasonSet.add(Season.WINTER);
		assertEquals("[WINTER]",seasonSet.toString());
		assertEquals("[WINTER, SPRING, SUMMER, FALL]",seasonSet2.toString());
		
	}
	enum Day { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY }

	@Test 
	public void testDays(){
		String result = "";
		for (Day d : EnumSet.range(Day.MONDAY,Day.FRIDAY))
			result += d;
		assertEquals("MONDAYTUESDAYWEDNESDAYTHURSDAYFRIDAY",result);
		
	}
	
	

}
