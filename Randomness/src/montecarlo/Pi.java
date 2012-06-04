package montecarlo;

public class Pi {
//	static final long MAX = Long.MAX_VALUE;
	static final long MAX = 9000000;

	public static void main(String[] a) {
		long countIn = 0, countOut = 0;
		double x, y;
		long size = 100000;
		for (long i = 0; i <= MAX; i++) {
			x =  (Math.random() * size)+1;
			y =  (Math.random() * size)+1;
			double distance = Math.sqrt(x * x + y * y);
			if (distance < size)
				countIn++;
			else
				countOut++;
			if ((i % 100000) == 0) 
				System.out.println("i: s" +i+" pi: "+ (double) countIn / i * 4);
			/*
			 * 				BigDecimal bd = new BigDecimal(countIn);
				bd = bd.divide(new BigDecimal(i));
				bd = bd.multiply(new BigDecimal(4));
				System.out.println("i: s" + i + " pi: " + bd.toString());

			 */
			
		}
		double pi = (double)countIn / MAX * 4;
		System.out.println("Math.PI " + Math.PI);
		System.out.println("CountIn " + countIn);
		System.out.println("countOut " + countOut);
		System.out.println("...: " + pi);

	}
}
