package info2.subsequence;

/**
 * Maximum Contiguous Subsequence Sum 
 */
public class MCSS {
	/*
	 * Continuous Subsequence Sum: Brute Force
	 */
	public ResultSet bruteForce(int[] a) {
		int maxSum = 0;
		int start = -1, end = -1;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				int thisSum = 0;
				for (int k = i; k <= j; k++) {
					thisSum += a[k];
				}
				if (thisSum > maxSum) {
					maxSum = thisSum;
					start = i;
					end = j;
				}
			}
		}
		return new ResultSet(maxSum, start, end);
	}

	/*
	 * Continuous Subsequence Sum: Quadratic
	 */
	public ResultSet quadratic(int[] a) {

		int maxSum = 0;
		int start = -1, end = -1;
		for (int i = 0; i < a.length; i++) {
			int thisSum = 0;
			for (int j = i; j < a.length; j++) {
				thisSum += a[j];
				if (thisSum > maxSum) {
					maxSum = thisSum;
					start = i;
					end = j;
				}
			}
		}
		return new ResultSet(maxSum, start, end);
	}

	/*
	 * Continuous Subsequence Sum: Linear
	 */
	public ResultSet linear(int[] a) {

		int maxSum = 0, thisSum = 0;
		int start = -1, end = -1;

		for (int i = 0, j = 0; j < a.length; j++) {
			thisSum += a[j];
			if (thisSum > maxSum) {
				// remember it
				maxSum = thisSum;
				start = i;
				end = j;
			} else if (thisSum < 0) {
				i = j + 1;
				thisSum = 0;
			}
		}
		return new ResultSet(maxSum, start, end);
	}

	public class ResultSet {
		public ResultSet(int maxSum, int start, int end) {
			this.maxSum = maxSum;
			this.start = start;
			this.end = end;
		}

		public int maxSum = 0;
		public int start = 0;
		public int end = 0;

		@Override
		public boolean equals(Object other) {
			if (other instanceof ResultSet)
				return equals((ResultSet) other);
			return false;
		}

		public boolean equals(ResultSet other) {
			return (this.maxSum == other.maxSum) && (this.start == other.start)
					&& (this.end == other.end);
		}

		public String toString() {
			return "" + maxSum + " [" + start + "," + end + "]";
		}
	}
}
