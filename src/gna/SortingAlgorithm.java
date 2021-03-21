package gna;

// Do not remove the "implements libpract.SortingAlgorithm".
public abstract class SortingAlgorithm implements libpract.SortingAlgorithm{
	
	protected long comparisons;
	protected long swaps;
	
	protected boolean less(Comparable comparable, Comparable other) {
		return compare(comparable, other) < 0;
	}
	
	protected boolean greater(Comparable comparable, Comparable other) {
		return compare(comparable, other) > 0;
	}
	
	protected boolean equal(Comparable comparable, Comparable other) {
		return comparable.compareTo(other) == 0;
	}
	
	protected int compare(Comparable comparable, Comparable other) {
		comparisons++;
		return comparable.compareTo(other);
	}
	
	public long getComparisons() {
		return comparisons;
	}
	
	public long getSwaps() {
		return swaps;
	}
	
	protected void swap(Comparable[] array, int i, int j) {
		swaps++;
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * Sorts the given array.
	 * 
	 * Note: to know whether "array[i] < array[j]", one writes "array[i].compareTo(array[j]) < 0".
	 * 
	 * @throws IllegalArgumentException
	 * 	array == null
	 * @post
	 * 	After execution of this method, array is sorted. That means:
	 *  - any element of the original array has the same amount of occurrences in the new array,
	 *    e.g. if the original array has twice the element x, the resulting element has twice the element x.
	 *  - any elements of the resulting array has the same amount of occurrences in the original array
	 *  - for any elements x and y in the resulting array, x occurs before y if and only if x is
	 *    less than or equal to y, according to the compareTo method.
	 * @return The number of comparisons (i.e. calls to compareTo) performed by the algorithm.
	 */
	public abstract long sort(Comparable[] array) throws IllegalArgumentException;
}
