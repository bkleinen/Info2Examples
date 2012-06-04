package pi;

public class Pi {

	private static final int MAX = 9000000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long r = 1000;
		double x, y;
		int counter =0;
		
		for (int i = 0; i < MAX; i++) {
			x = (Math.random() * r);
			y = (Math.random() * r);
			double d = Math.sqrt(x*x+y*y);
			if (d<r)
				counter++;
			if((i%100000) == 0)
				System.out.println("i: "+i+"pi: " +(double)counter/i*4);
		}
		System.out.println("pi: " +(double)counter/MAX*4);
		System.out.println("pi: " +Math.PI);
		System.out.println("pi: " +(Math.PI-(double)counter/MAX*4));
		
	}

}
