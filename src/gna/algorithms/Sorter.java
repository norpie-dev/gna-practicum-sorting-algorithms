package gna.algorithms;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import gna.SortingAlgorithm;
import gna.timing.Stopwatch;

public class Sorter {

	private SortingAlgorithm sorter;
	private Class<? extends SortingAlgorithm> algorithm;

	public Sorter(Class<? extends SortingAlgorithm> algorithm) {
		try {
			this.algorithm = algorithm;
			this.sorter = algorithm.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, Object> sort(Comparable[] array) throws IllegalArgumentException {
		Stopwatch stopwatch = new Stopwatch();
		// Timing
		stopwatch.start();
		sorter.sort(array);
		stopwatch.stop();
		// Get data
		HashMap<String, Object> data = new HashMap<>();
		data.put("milliseconds", stopwatch.getMilliseconds());
		data.put("comparables", array.length);
		data.put("comparisons", sorter.getComparisons());
		data.put("swaps", sorter.getSwaps());
		return data;
	}
	
	public Class<? extends SortingAlgorithm> getAlgorithm() {
		return algorithm;
	}
	
}
