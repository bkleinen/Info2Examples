package lcg;

import java.util.Random;

public class LinearCongruentialGenerator {
	long a = 0;
	long m = 0;
	long state = 0;
	boolean simple = true;

	public LinearCongruentialGenerator(long a, long m, long state) {
		this.a = a;
		this.m = m;
		this.state = state;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinearCongruentialGenerator g = new LinearCongruentialGenerator(7, 11,
				4);
		g.cycles(4);
		/*
		LinearCongruentialGenerator g2 = new LinearCongruentialGenerator(7,
				(long) (Math.pow(2, 31) - 1), 4);
		g2.cycles(1);
		*/
		/*
		 g = new LinearCongruentialGenerator(2, 11,
				4);
		g.cycles(4);
		*/
		System.out.println("Random starts here");
		for (int i = 0; i < 4; i++) {
			Random r = new Random(4);
			for (int j = 0; j < 10; j++) {
				System.out.print(""+(int)(r.nextDouble()*10)+", ");
				
			}
			System.out.println();
			
		}
	}

	private void cycles(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m - 1; j++) {
				System.out.print(next() + ", ");
				if (j % 20 == 0)
					System.out.println();
			}
			System.out.println();
		}

	}

	public long next() {
		if (simple)
			return state = (a * state) % m;
		long q = m / a;
		long r = m % a;
		long tmp = a * (state % q) - r * (state % q);
		if (tmp >= 0)
			state = tmp;
		else
			state = tmp + m;
		return state;
	}

}
