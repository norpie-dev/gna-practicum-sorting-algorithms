package gna;

/**
 * Performs sort by using the Quick Sort algorithm.
 *
 */
public class QuickSort extends SortingAlgorithm {

	/**
	 * Sorts the given array using quick sort.
	 * 
	 * @see super
	 */
	public long sort(Comparable[] array) throws IllegalArgumentException {
		// Pre-requisite checking
		if (array == null) {
			throw new IllegalArgumentException("argument 'array' must not be null.");
		}
		// Pre-requisite variables
		comparisons = 0;
		swaps = 0;
		// Algorithm
		sort(array, 0, array.length - 1);
		return comparisons;
	}

	private void sort(Comparable[] array, int low, int high) {
		if (low >= high)
			return;
		int partition = partition(array, low, high);
		sort(array, low, partition - 1);
		sort(array, partition + 1, high);
	}

	private int partition(Comparable[] array, int low, int high) {
		Comparable pivot = array[low];

		int lowIndex = low;
		int highIndex = high + 1;

		while (true) {
			while (less(array[++lowIndex], pivot)) {
				if (lowIndex == high)
					break;
			}
			while (less(pivot, array[--highIndex])) {
				if (highIndex == low)
					break;
			}
			if(lowIndex >= highIndex) break;
			swap(array, lowIndex, highIndex);
		}
		swap(array, low, highIndex);
		return highIndex;
	}
}
