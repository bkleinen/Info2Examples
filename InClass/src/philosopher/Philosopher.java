package philosopher;

public class Philosopher {

	private int number;

	public Philosopher(int i, Fork rightFork, Fork leftFork) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
		this.number = i;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 6;
		Philosopher[] philosopher = new Philosopher[n];
		Fork[] fork = new Fork[n];
		for (int i = 0; i < fork.length; i++) {
			fork[i] = new Fork(i);
		}
		for (int i = 0; i < philosopher.length; i++) {
			philosopher[i] = new Philosopher(i, fork[i], fork[(i + 1) % n]);
		}

	}

	private Fork leftFork;
	private Fork rightFork;

	public void dine() {
		// IF hungry
		if (isHungry()) {
			// REPEAT (take left fork if available)
			do {
				takeForkIfAvailable(leftFork);
				// UNTIL (holding left fork)
			} while (!holding(leftFork));
			// REPEAT (take right fork if available)
			do {
				takeForkIfAvailable(rightFork);
				// UNTIL (holding right fork)
			} while (!holding(rightFork));
			// REPEAT eat
			do {
				dine();
				// UNTIL NOT hungry
			} while (isHungry());
			// (drop right fork)
			drop(rightFork);
			// (drop left fork)
			drop(leftFork);
		}
	}

	private void drop(Fork fork) {
		fork.isHeld = false;

	}

	private boolean holding(Fork fork) {
		return fork.isHeld;
	}

	private boolean takeForkIfAvailable(Fork fork) {
		if (fork.isHeld)
			return false;
		fork.isHeld = true;
		return true;
	}

	private boolean isHungry() {
		// TODO Auto-generated method stub
		return true;
	}

}
