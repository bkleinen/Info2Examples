package examples;

public class Fibonacci {

	public long fib(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	public long fibCount(int n, Counter c) {
		c.count();
		if (n <= 1) {
			return n;
		} else {
			return fibCount(n - 1,c) + fibCount(n - 2,c);
		}
	}

	class Counter {
		private long counter = 0;

		public void count() {
			counter++;
		}

		public long getCounter() {
			return counter;
		}
	}

}
