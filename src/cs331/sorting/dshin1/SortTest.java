package cs331.sorting.dshin1;
//modified import below
import cs331.sorting.dshin1.Sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.*;

public class SortTest 
{
	long start;
	long end;
	long elapsed; 
	
	
	private static final int SIZE = (int)Math.pow(2, 10);

	@Test
	public void testInsertionSort()
	{
		List<Integer> unsorted = genUnsortedList(SIZE);
		
		Sort<Integer> insertionSort = new InsertionSort<>();
		start = System.nanoTime();
		sortTest(unsorted, insertionSort);
		end = System.nanoTime();
		elapsed = end - start;
		System.out.println("Insertion sort runtime: " + elapsed);
	}
	
	@Test
	public void testMergeSort()
	{
		List<Integer> unsorted = genUnsortedList(SIZE);
		
		Sort<Integer> mergeSort= new MergeSort<>();
		
		sortTest(unsorted, mergeSort);
	}
	
	@Test
	public void testMergeInsertionSort()
	{
		List<Integer> unsorted = genUnsortedList(SIZE);
		
		Sort<Integer> mergeInsertionSort= new MergeInsertionSort<>();
		
		sortTest(unsorted, mergeInsertionSort);
	}
	
	@Test public void testQuickSortRandom()
	{
			List<Integer> unsorted = genUnsortedList(SIZE);
			Sort<Integer> quick = new QuickSortRandom();
			sortTest(unsorted, quick);
	}
	
	@Test public void testQuickSort()
	{
			List<Integer> unsorted = genUnsortedList(SIZE);
			Sort<Integer> quick = new QuickSort();
			sortTest(unsorted, quick);
	}
	public <T extends S, S extends Comparable<T>> void sortTest(List<T> unsorted, Sort<T> s) 
	{
		s.init(unsorted);

		List<T> sorted = s.getSortedList();

		// Does the sorted list contain every element in the unsorted list?
		assertTrue(sorted.containsAll(unsorted));
		// Is the list actually sorted?
		assertTrue(SortTest.isListSorted(sorted));
	}

	private static <T extends S, S extends Comparable<T>> boolean isListSorted(List<T> list) {
		Iterator<T> i = list.iterator();
		T prev = i.next();

		while (i.hasNext()) {
			T next = i.next();
			if (next.compareTo(prev) < 0)
			{
				System.out.println("Found offending values: " + next + " and " + prev);
				return false;
			}
			prev = next;
		}
		return true;
	}

	public static List<Integer> genUnsortedList(int n) {
		List<Integer> unsorted = new ArrayList<>(n);

		Random gen = new Random(System.currentTimeMillis());

		for (int i = 0; i < n; i++)
			unsorted.add(gen.nextInt());

		return unsorted;
	}
}