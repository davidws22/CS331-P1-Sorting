// ============================================================================
// file: InsertionSort.java
// ============================================================================
// Programmer: David Shin
// Date: 2/7/17
// Class: CS 331 ("Design and Analysis of Algorithms")
// Time: T/R 5:00 - 6:50pm
// Instructor: Mr. Perez
// Project: 1
//
// Description:
//     This class is responsible for sorting a list of random Integers using 
// 		insertion sort.
//
// ============================================================================

package cs331.sorting.dshin1;


import java.util.ArrayList;
import java.util.List;
import cs331.sorting.dshin1.*;
import cs331.sorting.dshin1.IntList.Node;

public class InsertionSort<T> implements Sort<Integer> {
    //global temporary Linked List object 'temp' responsible for storing data to be sorted.
	private IntList temp = new IntList();
    
	public InsertionSort() 
	{	
	}//end default constructor.
    
    //implementation of init...
    @Override
	public void init(List<Integer> list) 
    {
    	for( int i = 0; i < list.size(); i++)
    	{
    		temp.addElement(list.get(i));		
    	}
		//temp.print();
	}//end init
    



	public IntList insertionSort(IntList t)
	{
		//variable declarations
		int size = t.getSize();
		//ArrayList<Integer> list = new ArrayList<>();
		int x,j,i;
		
		Node curr;
		curr = t.head;
	
		for(i = 1; i < size; i++)
		{
			
			x = t.getIndex(i);
			//x = curr.next.data;
			j = i -1;
			while(j>= 0 && t.getIndex(j) > x )//t.data > x
			//while(((j >= 0) && (curr.data > x)) && (curr.next != null))
			{	
				//t.data = 
				t.setIndex(j+1, t.getIndex(j));
				//curr.data = curr.prev.data;
				
				j--;
			}
			t.setIndex(j+1, x);                        
			//curr.next.data = x;
			//curr = curr.next;
		}    
		return t;
	}//end insertionSort
		
	@Override
	public List<Integer> getSortedList() 
	{
		//variable declarations
		ArrayList<Integer> list = new ArrayList<>();
		temp = insertionSort(temp);
			
		for (int i = 0; i < temp.getSize(); i++)
		{
		    list.add(temp.getIndex(i));
		}	
		//System.out.println("This is from the class insertionSort and printing the sorted list..");
		//temp.print();
		return list;
			
	}//end getSortedList
}//end class InsertionSort
