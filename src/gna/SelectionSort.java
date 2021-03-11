package gna;

/**
 * Performs sort by using the Selection Sort algorithm.
 * 
 */
public class SelectionSort extends SortingAlgorithm {
	/**
	 * Sorts the given array using selection sort.
	 * 
	 * @see super
	 */
	public long sort(Comparable[] array) throws IllegalArgumentException {
		if (array == null) {
			throw new IllegalArgumentException("argument 'array' must not be null.");
		}	
		// Actual algorithm
		long comparisons = 0;
		for (int i = 0; i < array.length - 1; i++) {
			int minimum = i;
			
			// Find the smallest element of the array
			for(int j = i+1; j < array.length; j++) {
				if(array[j].compareTo(array[minimum]) < 0) {
					comparisons++;
					minimum = j;
				}
			}
			
			// Swap
			Comparable temp = array[i];
			array[i] = array[minimum];
			array[minimum] = temp;
		}
		return comparisons;
	}

	/**
	 * Constructor.
	 */
	public SelectionSort() {
	}
}
