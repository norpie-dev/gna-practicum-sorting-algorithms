package gna;

/**
 * Performs sort by using the Insertion Sort algorithm.
 * 
 */
public class InsertionSort extends SortingAlgorithm {

	/**
	 * Sorts the given array using insertion sort.
	 * 
	 * @see super
	 */
	public long sort(Comparable[] array) throws IllegalArgumentException {
		// Valid array prerequisites
		if (array == null) {
			throw new IllegalArgumentException("argument 'array' must not be null.");
		}
		// Pre-requisite variables
		comparisons = 0;
		// Algorithm
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j > 0 && greater(array[j - 1], array[j]); j--) {
				swap(array, j - 1, j);
			}
		}
		return comparisons;
	}
}
