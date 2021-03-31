package gna.utils;

import gna.SortingAlgorithm;
import gna.datalogging.DataLogger;
import gna.datalogging.DataPoint;

public class Stopwatch {
	
	private long startTimeNano = -1;
	private long stopTimeNano = -1;
	
	private long startTimeMillis = -1;
	private long stopTimeMillis = -1;

	public void start() {
		startTimeNano = System.nanoTime();
		startTimeMillis = System.currentTimeMillis();
	}
	
	public void stop() {
		stopTimeNano = System.nanoTime();
		stopTimeMillis = System.currentTimeMillis();
	}
	
	public long getMilliseconds() {
		return stopTimeMillis - startTimeMillis;
	}

	public long getNanoSeconds() {
		return stopTimeNano - startTimeNano;
	}

	public long getSeconds() {
		return getMilliseconds() / 1000;
	}
	
	public static long time(Class<? extends SortingAlgorithm> clazz, int size) {
		Sorter sorter = new Sorter(clazz);
		DataPoint datapoint = sorter.sort(ComparableFactory.getN(size));
		new DataLogger().add(datapoint);
		return (long) datapoint.get("milliseconds");
	}

}
