
public class Timer {
	long current, total;
	
	public Timer() {
		current = 0;
		total = 0;
	}
	
	public void start() {
		current = System.nanoTime();
	}
	
	public void stop() {
		total = System.nanoTime() - current;
		current = 0;
	}
	
	public void reset() {
		total = 0;
		current = 0;
	}
	
	public long getNano() {
		return total;
	}
	
	public long getMilli() {
		return (long) (total*0.000001);
	}
	
	public long getSec() {
		return (long) (total*0.000001*.001);
	}
	
	public long getMin() {
		return (long) (total*0.000001*.001)/60;
	}
}
