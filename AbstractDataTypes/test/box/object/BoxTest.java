package box.object;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoxTest {
	Box integerBox = new Box();

	@Test
	public void testAdd() {
		integerBox.add(new Integer(10));

	}

	@Test
	public void testGet() {
		integerBox.add(new Integer(10));

		Integer someInteger = (Integer) integerBox.get();
		assertEquals(10, someInteger.intValue());
	}
}
