package box.object;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class BoxTest {
	ArrayList x = new ArrayList();
	Box integerBox = new Box();
	@Test
	public void testAdd() {
		 integerBox.add(new Integer(10));
		 
	}

	@Test
	public void testGet() {
	//	 integerBox.add(new Integer(10));
		 integerBox.add("hallo");
			
	     // no cast necessary!
	   //     Integer someInteger = (Integer)integerBox.get(); 
	        Object o = integerBox.get();
	        Integer someInteger = null;
	        if (o instanceof Integer)
	             someInteger = (Integer)o; 
	 	   
	        assertEquals(10, someInteger.intValue());
	}
}
