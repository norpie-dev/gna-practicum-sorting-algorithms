package gna.utils;

public class ComparableFactory {

	public static Comparable[] getRandomInts(int size, int min, int max) {
		Comparable[] comparables = new Comparable[size];
		for (int i = 0; i < size; i++) {
			comparables[i] = RandomUtil.getRandomNumber(min, max);
		}
		return comparables;
	}
	
	public static Comparable[] getRandomN(int size, int min, int max) {
		Comparable[] comparables = new Comparable[size];
		for (int i = 0; i < size; i++) {
			comparables[i] = RandomUtil.getRandomNumber(min, max);
		}
		return comparables;

}
