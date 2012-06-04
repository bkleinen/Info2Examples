package histogramme;

import java.util.Random;

public class Gaussian {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		for (int i = 0; i < 10000; i++) {
			int g = (int)(r.nextGaussian()*5+5);
			System.out.println(g);
			if (g < min) min = g;
			if (g > max) max = g;
		}
		System.out.println("min "+min);
		System.out.println("max "+max);

	}

}
