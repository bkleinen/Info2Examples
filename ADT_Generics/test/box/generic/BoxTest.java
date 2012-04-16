package box.generic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoxTest {
	Box<Integer> integerBox = new Box<Integer>();
	@Test
	public void testAdd() {
		 integerBox.add(new Integer(10));
	}

	@Test
	public void testGet() {
		 integerBox.add(new Integer(10));
	     // no cast necessary!
	        Integer someInteger = integerBox.get(); 
	        assertEquals(10, someInteger.intValue());
	}
}
