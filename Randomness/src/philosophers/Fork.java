package philosophers;

public class Fork {
	public Fork(int n){
		this.number = n;
	}
	int number;
	Philosopher inHandOf;

	public synchronized boolean take(Philosopher p) {
		if (inHandOf != null)
			return false;
		inHandOf = p;
		return true;
	}

	public synchronized void drop() {
		inHandOf = null;
	}
}
