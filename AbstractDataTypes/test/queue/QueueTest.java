package queue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import errorhandling.Underflow;

@RunWith(Parameterized.class)
public class QueueTest {
	static abstract class Factory {
		abstract Queue<String> create();
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { new Factory() {
			Queue<String> create() {
				return new LinkedQueue<String>();
			}
		} }, { new Factory() {
			Queue<String> create() {
				return new ArrayQueue<String>();
			}
		} } };
		return Arrays.asList(data);
	}

	Queue<String> queueUnderTest;
	Factory factory;

	public QueueTest(Factory factory) {
		this.factory = factory;
	}

	@Before
	public void instantiateQueue() {
		queueUnderTest = factory.create();
	}

	/**
	 * isEmpty(new Queue()) = true
	 */
	@Test
	public void newQueueIsEmpty() {
		assertTrue(queueUnderTest.isEmpty());
	}

	/**
	 * dequeue(new Queue()) = error
	 * @throws Underflow
	 */
	@Test(expected = Underflow.class)
	public void dequeueOnEmptyQueue() throws Underflow {
		queueUnderTest.dequeue();
	}
	/**
	 * isEmpty(enqueue(q,x)) = false
	 */
	@Test
	public void isEmptyFalse(){
		queueUnderTest.enqueue("a");
		assertFalse(queueUnderTest.isEmpty());	
	}
	/**
	 * peek(new Queue()) = error
	 */
	@Test(expected = Underflow.class)
	public void peekOnEmptyQueue() throws Underflow {
		queueUnderTest.peek();
	}
	/**
	 * isEmpty(q)
	 * dequeue(enqueue(q,x)) = q
	 * @throws Underflow 
	 */
	@Test
	public void dequeueEnqueueEmptyQueue() throws Underflow{
		queueUnderTest.enqueue("a");
		queueUnderTest.dequeue();
		assertTrue(queueUnderTest.isEmpty());
	}
	/**
	 * !isEmpty(q)
	 * dequeue(enqueue(q,x)) = enqueue(dequeue(q),x) 
	 * @throws Underflow 
	 */
	@Test
	public void dequeueEnqueueNonEmptyQueue() throws Underflow{
		// given two nonempty queues
		Queue<String> queue1 = queueUnderTest;
		Queue<String> queue2 = factory.create();
		queue1.enqueue("s");
		queue2.enqueue("s");
		// when dequeue(enqueue(q,x))
		queue1.enqueue("x");
		queue1.dequeue();
		// when enqueue(dequeue(q),x) 
		queue2.dequeue();
		queue2.enqueue("x");
		// then both queues are the same
		assertEquals("x",queue1.dequeue());
		assertEquals("x",queue2.dequeue());
		assertTrue(queue1.isEmpty());
		assertTrue(queue2.isEmpty());
	 }
		
	
	
	
	/**
	 * dequeue(enqueue(q,x)) = 
   if isEmpty(q) then q     else enqueue(dequeue(q),x)
	 */
}