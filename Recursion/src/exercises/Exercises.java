package exercises;

import java.io.File;
import java.util.Stack;

public class Exercises {

	public String reverse(String str) {
		int l = str.length();
		if (l <= 1)
			return str;
		else
			return str.substring(l - 1) + reverse(str.substring(0, l - 1));
	}

	public static void main(String[] x) {
		Exercises e = new Exercises();
		System.out.println("stressed: " + e.reverse("stressed"));
		System.out.println("anna [" + "anna".substring(1, 3) + "]");
	}

	public boolean isPalindromeUsingReverse(String str) {

		return str.equals(reverse(str));
	}

	public boolean isPalindromeRecursive(String str) {
		int l = str.length();
		if (l <= 1)
			return true;
		if (str.charAt(0) != str.charAt(l - 1))
			return false;
		else
			return isPalindromeRecursive(str.substring(1, l - 1));
	}

	public boolean isPalindromeStack(String str) {
		Stack<Character> stack = new Stack<Character>();
		int length = str.length();
		// put first half of stack
		for (int i=0;i<length/2;i++){
			stack.push(str.charAt(i));
		}
		// compare it with second half
		for(int i=(length+1)/2;i<length;i++){
			if (str.charAt(i) != stack.pop()) return false;
		}
		return true;
		
		
	}

	public boolean isPalindromeLoop(String str) {
		int l = str.length();
		for (int i = 0; i < l / 2; i++) {
			if (!(str.charAt(i) == str.charAt(l - 1 - i)))
				return false;
		}
		return true;
	}

	public static int countFiles(File f) {
		if (f.isFile()) {
			return 1;
		}

		// Count children & recurse into subdirs:
		int count = 0;
		File[] files = f.listFiles();
		for (File fileOrDir : files) {
			count += countFiles(fileOrDir);
		}
		return count;

	}

}
