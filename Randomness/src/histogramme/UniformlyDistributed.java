package histogramme;

import java.util.Random;

public class UniformlyDistributed {
	public static void main(String[] a) {
		System.out.println("Uniformly Distributed: ");
		new UniformlyDistributed().histogram(10, 100000);
		System.out.println("Gaussian Distributed: ");
		new GaussianDistributed().histogram(20, 100000);
	}

	protected Random rnd = new Random();

	public void histogram(int n, int samplesize) {
		int notInRange = 0;
		int[] histogram = new int[n * 2];
		for (int i = 0; i < n; i++)
			histogram[i] = 0;
		for (int i = 0; i < samplesize; i++) {
			int drawn = draw(n);
			if ((0 <= drawn) && (drawn < n))
				histogram[drawn]++;
			else
				notInRange++;
		}
		for (int i = 0; i < n; i++)
			System.out.println(" " + i + " " + histogram[i]);
		System.out.println("not in range " + notInRange);
	}

	protected int draw(int n) {
		return (int) (rnd.nextDouble() * n);
	}

}
