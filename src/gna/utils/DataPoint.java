package gna.utils;

public class DataPoint {
	
	private String algorithm;
	private int comparableCount;
	private double milliseconds;

	public String getAlgorithm() {
		return algorithm;
	}

	public int getComparableCount() {
		return comparableCount;
	}
	
	public double getMilliseconds() {
		return milliseconds;
	}
	
	public DataPoint(String algorithm, int comparableCount, double milliseconds) {
		this.algorithm = algorithm;
		this.comparableCount = comparableCount;
		this.milliseconds = milliseconds;
	}

}
