package gna;

import java.util.HashMap;

import gna.algorithms.Sorter;
import gna.datalogging.DataLogger;
import gna.datalogging.DataPoint;
import gna.utils.ComparableFactory;

public class Main {

	public static void main(String[] args) {
		Comparable[] comparables = ComparableFactory.getRandomInts(32764, 0, Integer.MAX_VALUE);
		Sorter sorter = new Sorter(QuickSort.class);
		HashMap<String, Object> data = sorter.sort(comparables);
		System.out.println(data.get("milliseconds"));
//		doublingExperiment();
	}

	// Experiments
	protected static void doublingExperiment() {
		System.out.println("Doubling experiment - Started");
		long prev = 1;
		HashMap<String, Object> example = new HashMap<String, Object>();
		example.put("milliseconds", null);
		example.put("comparables", null);
		example.put("comparisons", null);
		example.put("swaps", null);
		example.put("ratio", null);
		DataLogger datalogger = new DataLogger(new DataPoint(example));
		for (int i = 11; i < 26; i++) {
			System.out.println(i);
			int n = (int) Math.pow(2, i);
			Comparable[] comparables = ComparableFactory.getRandomInts(n, 0, Integer.MAX_VALUE);
			// Get algo and timer
			Sorter sorter = new Sorter(InsertionSort.class);
			HashMap<String, Object> data = sorter.sort(comparables);
			long time = (long) data.get("milliseconds");
			data.put("ratio", time/prev);
			prev = time;
			datalogger.add(new DataPoint(data));
		}
		datalogger.write();
		System.out.println("Doubling experiment - Stopped");
	}

	// Data gathering
	private static Main instance;

	public static Main getInstance() {
		return instance;
	}

}