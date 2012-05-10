package language;

public class BuggyAutomaton {
	State currentState = new State1();
	boolean trace = false;

	public BuggyAutomaton(boolean trace) {
		this.trace = trace;
	}

	public boolean read(String input) {
		for (int i = 0; i < input.length(); i++) {
			currentState = currentState.transition(input.charAt(i));
			if (currentState == null)
				return false;
		}
		return currentState.isFinalState();
	}

	abstract class State {
		State() {
			if (trace) {
				System.out.println(this.getClass().getName());
			}
		}

		abstract State transition(char c);

		abstract boolean isFinalState();
	}

	class State1 extends State {
		State transition(char c) {
			switch (c) {
			case 'a':
				return new State2();
			default:
				return null;
			}
		}
		boolean isFinalState() {
			return true;
		};
	}

	class State2 extends State {
		State transition(char c) {
			switch (c) {
			case 'b':
				return new State1();
			case 't':
				return new State3();
			default:
				return null;
			}
		}

		boolean isFinalState() {
			return true;
		};
	}

	class State3 extends State {
		State transition(char c) {
			switch (c) {
			case 'h':
				return new State1();
			default:
				return null;
			}
		}
		boolean isFinalState() {
			return true;
		};

	}
}
