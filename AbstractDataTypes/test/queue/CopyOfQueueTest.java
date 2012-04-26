package queue;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import errorhandling.Underflow;

@RunWith(Parameterized.class)
public class CopyOfQueueTest {
	static abstract class Factory {
		abstract Queue<String> create();
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { new LinkedQueue<String>() },
				{ new ArrayQueue<String>() } };
		return Arrays.asList(data);
	}

	Queue<String> queueUnderTest;
	Factory factory;

	public CopyOfQueueTest(Queue<String> queue) {
		this.queueUnderTest = queue;
	}

	@Before
	public void instantiateQueue() {
		//queueUnderTest = factory.create();
	}


	
	/**
	 * isEmpty(new Queue()) = true
	 */
	@Test
	public void newQueueIsEmpty() {
		assertTrue(queueUnderTest.isEmpty());
		queueUnderTest.enqueue("a");
	}
	/**
	 * dequeue(new Queue()) = error
	 * 
	 * @throws Underflow
	 */
	@Test(expected = Underflow.class)
	public void dequeueOnEmptyQueue() throws Underflow {
		queueUnderTest.dequeue();
		queueUnderTest.enqueue("a");
	}

}