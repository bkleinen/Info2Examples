package random;

public class Random {
	public static void main(String[] a){
		java.util.Random r = new java.util.Random(123L);
		for (int i=0;i<10;i++)
		System.out.println((int)(r.nextDouble()*10));
	}
}
