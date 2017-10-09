package cs331.sorting.dshin1;

import java.io.FileNotFoundException;
import java.io.PrintStream;


public class main {
	
	static final int MAX_POW = 12;
	static final int START_POW = 4;
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		//PrintStream ps = new PrintStream("runtimes1.csv");
		long startTime = 0;
		long endTime = 0;
		long elapsedTime;

		SortTest trial1 = new SortTest(); //insertion
		SortTest trial2 = new SortTest(); //merge
		SortTest trial3 = new SortTest(); //mergeinsertion
		SortTest trial4 = new SortTest(); //quickSort Random pivot
		SortTest trial5 = new SortTest(); //quickSort using first pivot
		
		//for(int i = START_POW; i <= MAX_POW; i++)
		//{
			//int n  = 16;//(int) Math.pow(2, i);
			int n = (int)Math.pow(2, 12);
			
			System.out.println("Number of elements: " + n);
			//ps.print(n);
			startTime = System.nanoTime();
			trial1.testInsertionSort();
			endTime = System.nanoTime();
			elapsedTime = endTime - startTime;
			//ps.print("," + elapsedTime);
			
			System.out.println("Insertion Sort Time: " + elapsedTime);
			
			startTime = System.nanoTime();
			trial2.testMergeSort();
			endTime = System.nanoTime();
			elapsedTime = endTime - startTime;
			//ps.print("," + elapsedTime);
			System.out.println("Merge Sort Time: " + elapsedTime);
			
			
			startTime = System.nanoTime();
			trial3.testMergeInsertionSort();
			endTime = System.nanoTime();
			elapsedTime = endTime - startTime;
			System.out.println("MergeInsertion Sort Time: " + elapsedTime);
			//ps.println("," + elapsedTime);
			
			startTime = System.nanoTime();
			trial4.testQuickSortRandom();
			endTime = System.nanoTime();
			elapsedTime = endTime - startTime;
			System.out.println("QuickSortRandom Time: " + elapsedTime);
			
			startTime = System.nanoTime();
			trial5.testQuickSort();
			endTime = System.nanoTime();
			elapsedTime = endTime - startTime;
			System.out.println("QuickSort Time: " + elapsedTime);
			
		//}
		//ps.close();
	}
		


}


