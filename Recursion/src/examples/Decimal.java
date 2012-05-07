package examples;

public class Decimal {
	public String decimal(int n) {
		if (n < 10)
			return String.valueOf(n);
		else
			return decimal(n / 10) + String.valueOf(n % 10);
	}

	public void printDecimal(int n) {
		if (n < 10)
			System.out.print(n);
		else
			printDecimal(n / 10);
	}
}
