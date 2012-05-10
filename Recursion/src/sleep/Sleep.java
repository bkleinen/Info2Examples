package sleep;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Sleep {
	public static void sleep(String who, String identation, Iterator<String> all) {
		if (!all.hasNext()) {
			System.out.println(identation + "...who fell asleep.");
		} else {
			String nextOne = all.next();
			if (who == null)
				System.out.print("A child couldn't sleep, so her ");
			else
				System.out.print(identation + "who couldn't sleep, so the "
						+ who + "'s ");
			System.out.println("father told a story about a little " + nextOne);

			sleep(nextOne, identation + "  ", all);

			if (who == null)
				System.out.println(identation
						+ "... and the little child fell asleep;");

			else
				System.out.println(identation + "... and the little " + who
						+ " fell asleep.");
		}
	}

	public static void main(String[] x) {
		List<String> all = Arrays.asList(new String[] { "frog", "bear",
				"weasel", "dog", "mouse" });
		// Iterator<String> i = all.iterator();
		sleep(null, "", all.iterator());
	}
}
