package loops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exercise03.Fragments;
import static org.junit.Assert.*;

public class FragmentsTest {
	Fragments fragments = new Fragments();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFragment1() {
		for (int n=0;n<100;n++)
			assertEquals(""+n,fragments.f1(n),fragments.fragment1(n));
	}

	@Test
	public void testFragment2() {
		for (int n=0;n<100;n++)
			assertEquals(""+n,fragments.f2(n),fragments.fragment2(n));
	}

	@Test
	public void testFragment3() {
		for (int n=0;n<100;n++)
			assertEquals(""+n,fragments.f3(n),fragments.fragment3(n));
	}

	@Test
	public void testFragment4() {
		for (int n=0;n<100;n++)
			assertEquals(""+n,fragments.f4(n),fragments.fragment4(n));
	}

	@Test
	public void testFragment5() {
		for (int n=0;n<100;n++)
			assertEquals(""+n,fragments.f5(n),fragments.fragment5(n));
	}

	@Test
	public void testFragment6() {
		for (int n=1;n<100;n++)
			assertEquals(""+n,fragments.f6(n),fragments.fragment6(n));

	}

	@Test
	public void testFragment7() {
		for (int n=100;n<200;n++){
			assertTrue(""+n,fragments.f7(n)>fragments.fragment7(n));
			//System.out.println("f7 "+n+" "+fragments.f7(n)+" "+(double)fragments.fragment7(n));
		}

	}

}
