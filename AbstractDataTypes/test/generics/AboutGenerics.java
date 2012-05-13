package generics;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class AboutGenerics {


	// Wildcards
	void printCollection(Collection<?> c) {
		for (Object e : c) {
			System.out.println(e);
		}
	}

	// bounded wildcards
	public void drawAll(List<? extends Shape> shapes) {
		for (Shape s : shapes) {
			s.draw(this);
		}
	}

	abstract class Shape {
		public abstract void draw(AboutGenerics c);
	}

	class Circle extends Shape {
		private int x, y, radius;

		public void draw(AboutGenerics c) { // ...
		}
	}

	class Rectangle extends Shape {
		private int x, y, width, height;

		public void draw(AboutGenerics c) {
			// ...
		}
	}

	// generic methods
	static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
		for (T o : a) {
			c.add(o); // correct
		}
	}
	@Test 
	public void aboutGenericMethods(){
		//We can call this method with any kind of collection whose 
		//element type is a super- type of the element type of the array.
		Object[] oa = new Object[100];
		Collection<Object> co = new ArrayList<Object>(); 
		fromArrayToCollection(oa, co);
		// T inferred to be Object 
		String[] sa = new String[100];
		Collection<String> cs = new ArrayList<String>(); 
		fromArrayToCollection(sa, cs);
		// T inferred to be String 
		fromArrayToCollection(sa, co);
		// T inferred to be Object 
		Integer[] ia = new Integer[100];
		Float[] fa = new Float[100];
		Number[] na = new Number[100];
		Collection<Number> cn = new ArrayList<Number>(); 
		fromArrayToCollection(ia, cn);
		// T inferred to be Number 
		fromArrayToCollection(fa, cn);
		// T inferred to be Number 
		fromArrayToCollection(na, cn);
		// T inferred to be Number 
		fromArrayToCollection(na, co);
		// T inferred to be Object 
		
		//fromArrayToCollection(na, cs);
		// compile-time error
	}
}
