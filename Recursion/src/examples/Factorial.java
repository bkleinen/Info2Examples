package examples;

import java.math.BigInteger;

public class Factorial {
	public long factorial(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public BigInteger factorialBigInteger(int n) {
		if (n <= 1) {
			return BigInteger.ONE;
		} else {
			return BigInteger.valueOf(n).multiply(factorialBigInteger(n - 1));
		}
	}

	public void printFactorials(int upTo) {

		System.out.println("Long.MAX_VALUE: " + Long.MAX_VALUE);
		System.out.println("      " + Long.MAX_VALUE);
		for (int i = 1; i <= upTo; i++) {
			System.out.println("" + i + "! = " + factorialBigInteger(i));
		}
	}

	public static void main(String[] arguments) {
		(new Factorial()).printFactorials(200);
	}
}
