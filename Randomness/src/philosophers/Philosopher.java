package philosophers;

public class Philosopher implements Runnable {
	private static final boolean RANDOMIZE = true;
	private static final boolean ORDER = false;
	
	int number;
	Fork leftFork, rightFork;
	int hunger = 10;

	public Philosopher(int number, Fork leftFork, Fork rightFork) {
		this.number = number;
		this.setForks(leftFork, rightFork);
		// this.setForksInOrder(leftFork, rightFork);
	}

	private void setForks(Fork leftFork, Fork rightFork) {
		this.rightFork = rightFork;
		this.leftFork = leftFork;
	}

	private void setForksInOrder(Fork leftFork, Fork rightFork) {
		if (leftFork.number < rightFork.number) {
			this.rightFork = rightFork;
			this.leftFork = leftFork;
		} else {
			this.rightFork = leftFork;
			this.leftFork = rightFork;
		}
	}

	public void dine() throws InterruptedException {
		// IF hungry
		if (isHungry()) {
			// REPEAT (take left fork if available)
			// UNTIL (holding left fork)
			if (RANDOMIZE) {
				boolean flipForks = (int) ((Math.random() * 2)) == 1;
				if (flipForks) {
					Fork f = leftFork;
					leftFork = rightFork;
					rightFork = f;
				}

			}
			do {
				Thread.sleep(2 * 1000);
				tryToTakeFork(leftFork);
			} while (!holding(leftFork));
			// REPEAT (take right fork if available)
			// UNTIL (holding right fork)
			Thread.sleep(10 * 1000);
			do {
				Thread.sleep(2 * 1000);
				tryToTakeFork(rightFork);
			} while (!holding(rightFork));
			// REPEAT eat
			// UNTIL NOT hungry
			do {
				eat();
			} while (isHungry());
			// (drop right fork)
			drop(rightFork);
			// (drop left fork)
			drop(leftFork);
		}
	}

	private void eat() throws InterruptedException {
		output("is eating...");
		hunger--;
		Thread.sleep(500);
	}

	private void output(String string) {
		System.out.println("Philosopher " + number + " " + string);

	}

	private void drop(Fork fork) {
		fork.drop();
		output(" has dropped fork " + fork.number);

	}

	private boolean holding(Fork fork) {
		return fork.inHandOf == this;
	}

	private void tryToTakeFork(Fork fork) {
		if (fork.take(this))
			output(" has taken fork " + fork.number);
		else
			output(" couldn't take fork " + fork.number);
	}

	private boolean isHungry() {
		return hunger > 0;
	}

	@Override
	public void run() {
		try {
			dine();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] x) {
		int n = 10;
		Fork[] fork = new Fork[n];
		Philosopher[] philosopher = new Philosopher[n];
		for (int i = 0; i < n; i++) {
			fork[i] = new Fork(i);
		}
		for (int i = 0; i < n; i++) {
			philosopher[i] = new Philosopher(i, fork[i], fork[(i + 1) % n]);
		}
		for (int i = 0; i < n; i++) {
			(new Thread(philosopher[i])).start();
		}
	}
}
