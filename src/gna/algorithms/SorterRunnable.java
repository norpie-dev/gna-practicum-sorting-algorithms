package gna.algorithms;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import gna.SortingAlgorithm;
import gna.datalogging.DataLogger;
import gna.datalogging.DataPoint;
import gna.timing.Stopwatch;

public class SorterRunnable extends Sorter implements Runnable {

	public SorterRunnable(Class<? extends SortingAlgorithm> algorithm) {
		super(algorithm);
	}

	private Class<? extends SortingAlgorithm> sorter;
	private Comparable[] comparables;
	private String filename;
	private SortingAlgorithm algorithm;

	@Override
	public void run() {
		try {
			algorithm = sorter.getConstructor().newInstance();
			HashMap<String, Object> data = new HashMap<>();
			Stopwatch stopwatch = new Stopwatch();
			stopwatch.start();
			data.put("comparisons", algorithm.sort(comparables));
			stopwatch.stop();
			data.put("swaps", algorithm.getSwaps());
			data.put("milliseconds", stopwatch.getMilliseconds());
			DataPoint datapoint = new DataPoint(data);
			DataLogger logger = new DataLogger(filename, datapoint);
			logger.add(datapoint);
			logger.write();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

}
