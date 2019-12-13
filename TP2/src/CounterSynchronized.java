
public class CounterSynchronized {
	private boolean started = false;
	private int c = 0;

	public synchronized void start() {
		c = 42;
		started = true;
	}

	public synchronized void stop() {
		started = false;
	}

	public synchronized void increment() {
		c++;
	}

	public synchronized int value() {
		if (started == true) {
			return c;
		}
		throw new IllegalStateException();
	}

}
