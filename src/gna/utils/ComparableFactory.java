package gna.utils;

public class ComparableFactory {

	public static Comparable[] getRandomInts(int size, int min, int max) {
		Comparable[] comparables = new Comparable[size];
		for (int i = 0; i < size; i++) {
			comparables[i] = RandomUtil.getRandomNumber(min, max);
		}
		return comparables;
	}

	public static Comparable[] getN(int size) {
		return getRandomInts(size, 0, size);
	}

	public static Comparable[] getNSorted(int size) {
		Comparable[] comparables = new Comparable[size];
		for (int i = 0; i < size; i++) {
			comparables[i] = i;
		}
		return comparables;
	}

	public static Comparable[] getNReversed(int size) {
		Comparable[] comparables = getNSorted(size);
		for (int i = 0; i < comparables.length / 2; i++) {
			Comparable temp = comparables[i];
			comparables[i] = comparables[comparables.length - i - 1];
			comparables[comparables.length - i - 1] = temp;
		}
		return comparables;
	}

}
