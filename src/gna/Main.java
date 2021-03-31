package gna;

import gna.datalogging.DataLogger;
import gna.datalogging.DataPoint;
import gna.utils.ComparableFactory;
import gna.utils.Sorter;

public class Main {

	public static void main(String[] args) {
		new Main();
	}

	// Instanciation
	private static Main instance;

	private static final Class<? extends SortingAlgorithm>[] ALL_ALGORITHMS = new Class[] { QuickSort.class,
			InsertionSort.class, SelectionSort.class };

	public static Main getInstance() {
		return instance;
	}

	public Main() {
		oneToOneHundred();
		doublingRatioExperiment(QuickSort.class, 320, 10);
		worstCase();
		bestCase();
	}

	// Experiments

	/*
	 * Doubling ratio experiment
	 */
	public void doublingRatioExperiment(Class<? extends SortingAlgorithm> algorithm, int start, int iterations) {
		System.out.println("Doing: " + algorithm.getSimpleName());
		DataLogger datalogger = new DataLogger(algorithm.getSimpleName());
		Sorter sorter = new Sorter(algorithm);
		int n = start;
		for (int i = 0; i < iterations; i++) {
			n = dual(n);
			for (int j = 0; j < 20; j++) {
				Comparable[] comparables = ComparableFactory.getN(n);
				DataPoint datapoint = sorter.sort(comparables);
				datalogger.add(datapoint);
				System.out.println("Datapoint " + j + " acquired");
			}
			System.out.println("Iteration done: " + i);
		}
		datalogger.write();
		System.out.println("Done: " + algorithm.getSimpleName());
	}

	private int dual(int i) {
		return i * 2;
	}

	/*
	 * Run all 3 algorithms 50 times for every array of size n, where n is a number
	 * from 1 to 100.
	 */
	public void oneToOneHundred() {
		for (Class<? extends SortingAlgorithm> algorithm : ALL_ALGORITHMS) {
			DataLogger datalogger = new DataLogger(algorithm.getSimpleName());
			System.out.println("Starting with algorithm: " + algorithm.getSimpleName());
			Sorter sorter = new Sorter(algorithm);
			for (int i = 0; i < 50; i++) {
				for (int n = 1; n < 101; n++) {
					Comparable[] comparables = ComparableFactory.getN(n);
					DataPoint datapoint = sorter.sort(comparables);
					datalogger.add(datapoint);
				}
				System.out.println("Done " + i + "/" + 50 + " for " + algorithm.getSimpleName());
			}
			datalogger.write();
			System.out.println("Done with algorithm: " + algorithm.getSimpleName());
		}
	}

	/*
	 * Simulates the worst case scenario of the algorithm
	 */
	public void worstCase() {
		for (Class<? extends SortingAlgorithm> algorithm : ALL_ALGORITHMS) {
			DataLogger datalogger = new DataLogger(algorithm.getSimpleName());
			System.out.println("Starting with algorithm: " + algorithm.getSimpleName());
			Sorter sorter = new Sorter(algorithm);
			for (int i = 0; i < 50; i++) {
				for (int n = 1; n < 101; n++) {
					Comparable[] comparables = ComparableFactory.getNReversed(n);
					DataPoint datapoint = sorter.sort(comparables);
					datalogger.add(datapoint);
				}
				System.out.println("Done " + i + "/" + 50 + " for " + algorithm.getSimpleName());
			}
			datalogger.write();
			System.out.println("Done with algorithm: " + algorithm.getSimpleName());
		}
	}

	/*
	 * Simulates the best case scenario of the algorithm
	 */
	public void bestCase() {
		for (Class<? extends SortingAlgorithm> algorithm : ALL_ALGORITHMS) {
			DataLogger datalogger = new DataLogger(algorithm.getSimpleName());
			System.out.println("Starting with algorithm: " + algorithm.getSimpleName());
			Sorter sorter = new Sorter(algorithm);
			for (int i = 0; i < 50; i++) {
				for (int n = 1; n < 101; n++) {
					Comparable[] comparables = ComparableFactory.getNSorted(n);
					DataPoint datapoint = sorter.sort(comparables);
					datalogger.add(datapoint);
				}
				System.out.println("Done " + i + "/" + 50 + " for " + algorithm.getSimpleName());
			}
			datalogger.write();
			System.out.println("Done with algorithm: " + algorithm.getSimpleName());
		}
	}
}