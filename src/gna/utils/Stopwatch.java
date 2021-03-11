package gna.utils;

public class Stopwatch {
	
	private long startTime = -1;
	private long stopTime = -1;
	
	public void start() {
		startTime = System.currentTimeMillis();
	}
	
	public void stop() {
		stopTime = System.currentTimeMillis();
	}
	
	private void verify() {
		if(startTime == -1) {
			throw new RuntimeException("Timer was never started!");
		}
		if(stopTime == -1) {
			throw new RuntimeException("Timer was never stopped!");
		}
	}
	
	public double getMilliseconds() {
		verify();
		return stopTime - startTime;
	}

	public double getSeconds() {
		verify();
		return getMilliseconds() / 1000;
	}
	
	public String toString() {
		return getSeconds() + "s";
	}

}
