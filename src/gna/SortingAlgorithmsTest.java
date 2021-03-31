package gna;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests that test whether the implementations of the sorting algorithms do
 * sort.
 */
public class SortingAlgorithmsTest {

	private HashSet<SortingAlgorithm> algorithms;

	public boolean lessEqual(Comparable i, Comparable j) {
		return i.compareTo(j) <= 0;
	}

	public void isSorted(Comparable[] comparables) {
		for (int i = 1; i < comparables.length; i++) {
			assertTrue(lessEqual(comparables[i - 1], comparables[i]));
		}
	}

	@Before
	public void before() {
		algorithms = new HashSet<>();
		algorithms.add(new InsertionSort());
		algorithms.add(new QuickSort());
		algorithms.add(new SelectionSort());
	}

	@Test
	public void positiveNumbers() {
		for (SortingAlgorithm algorithm : algorithms) {
			Comparable[] comparables = { 1, 3, 2, 5, 4 };
			algorithm.sort(comparables);
			isSorted(comparables);
		}
	}

	@Test
	public void positiveEqualNumbers() {
		for (SortingAlgorithm algorithm : algorithms) {
			Comparable[] comparables = { 1, 1, 1, 1, 1 };
			algorithm.sort(comparables);
			isSorted(comparables);
		}
	}

	@Test
	public void zeroes() {
		for (SortingAlgorithm algorithm : algorithms) {
			Comparable[] comparables = { 0, 0, 0, 0, 0 };
			algorithm.sort(comparables);
			isSorted(comparables);
		}
	}

	@Test
	public void negativeNumbers() {
		for (SortingAlgorithm algorithm : algorithms) {
			Comparable[] comparables = { -5, -3, -10, -1, -2 };
			algorithm.sort(comparables);
			isSorted(comparables);
		}
	}

	@Test
	public void negativeEqualNumbers() {
		for (SortingAlgorithm algorithm : algorithms) {
			Comparable[] comparables = { -5, -5, -5, -5, -5 };
			algorithm.sort(comparables);
			isSorted(comparables);
		}
	}
}
