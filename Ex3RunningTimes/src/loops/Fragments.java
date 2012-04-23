package loops;

public class Fragments {

	public int fragment1(int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum++;
		}
		return sum;
	}

	public int f1(int n) {
		return n;
	}

	public int fragment2(int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				sum++;
		return sum;
	}

	public int f2(int n) {
		return 0;
	}

	public int fragment3(int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++)
				sum++;
		return sum;
	}

	public int f3(int n) {
		return 0;
	}

	public int fragment4(int n) {
		int sum = 0;

		for (int i = 0; i < n; i++)
			sum++;
		for (int j = 0; j < n; j++)
			sum++;
		return sum;
	}
	public int f4(int n) {
		return 0;
	}

	public int fragment5(int n) {
		int sum = 0;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n * n; j++)
				sum++;
		return sum;
	}
	public int f5(int n) {
		return 0;
	}


	public int fragment6(int n) {
		int sum = 0;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < i; j++)
				sum++;
		return sum;
	}
	public int f6(int n) {
		return 0;
	}

	public int fragment7(int n) {
		int sum = 0;

		for (int i = 1; i < n; i++)
			for (int j = 0; j < n * n; j++)
				if (j % i == 0)
					for (int k = 0; k < j; k++)
						sum++;
		return sum;
	}
	public int f7(int n) {
		return 0;
	}


}
