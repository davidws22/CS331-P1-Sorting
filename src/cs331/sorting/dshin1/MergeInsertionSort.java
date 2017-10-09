// ============================================================================
// file: MergeInsertionSort.java
// ============================================================================
// Programmer: David Shin
// Date: 2/7/17
// Class: CS 331 ("Design and Analysis of Algorithms")
// Time: T/R 5:00 - 6:50pm
// Instructor: Mr. Perez
// Project: 1
//
// Description:
//     This class is responsible for sorting the first 55 unsorted elements using 
//		insertion sort and then sorting the rest of the elements using merge sort.
//
// ============================================================================
package cs331.sorting.dshin1;

import java.util.ArrayList;
import java.util.List;
import cs331.sorting.dshin1.IntList.Node;


public class MergeInsertionSort<T> implements Sort<Integer> 
{
	//global variable 'temp' is responsible for keeping the values to be sorted in a linked list.
    private IntList temp = new IntList(); //holds all data elements
    
    boolean target = false; //turned to true if there are more than 28 elements to be sorted.
    
    
    
    //Initialization of linked list given a list.
	@Override
	public void init(List<Integer> list) 
	{
		for( int i = 0; i < list.size(); i++)
    	{
    		temp.addElement(list.get(i));
    	}
	}

	public void mergeInsertion()
	{
		//start with insertion.
		//after running three trials, the average intersection between merge and insertion is 28 elements.
		temp = insertionSort(temp);
		if (target)
		{
			temp = mergeSort(temp);
		}
	}
	
	public IntList insertionSort(IntList t)
	{
		//variable declarations
		int size = t.getSize();
		int x,j,i;
		
		for(i = 1; i < size; i++)
		{
			
			x = t.getIndex(i);
			j = i -1;
			while(j>= 0 && t.getIndex(j) > x )
			{
				t.setIndex(j+1, t.getIndex(j));
				j--;
			}
			
			t.setIndex(j+1, x);
			
			if(i > 28)
			{
				target = true;
				return t;
			}
		}    
		return t;
	}//end insertionSort
	
    public IntList mergeSort(IntList t){
        int size = t.getSize();
        if(size < 2)
        {
            return t;
        }
        
        int mid = size / 2;
        
        IntList left = new IntList();
        IntList right = new IntList();
        
        for(int i = 0; i < mid; i++)
        {
            left.addElement(t.getIndex(i));   
        }
        for (int i = mid; i < size; i++) 
        {
            right.addElement(t.getIndex(i));
        }
        mergeSort(left);
        mergeSort(right);
        Merge(left,right,t);
        return t;
    }
    
    public void Merge(IntList left, IntList right, IntList linked){
        
        int leftSize = left.getSize();
        int rightSize = right.getSize();
        int i = 0, j = 0, k = 0;
        
        while(i < leftSize && j < rightSize)
        {
            if(left.getIndex(i) <= right.getIndex(j))
            {
                linked.setIndex(k, left.getIndex(i));
                i++;
                k++;
            }
            else
            {
                linked.setIndex(k, right.getIndex(j));
                k++;
                j++;
            }
        }
        
        while(i < leftSize)
        {
            linked.setIndex(k++, left.getIndex(i++));
        }
        
        while( j < rightSize)
        {
            linked.setIndex(k++, right.getIndex(j++));
        }
    }//end Merge    
    
	
	@Override
	public List<Integer> getSortedList() 
	{
		//variable declaration
		ArrayList<Integer> list = new ArrayList<>();
		mergeInsertion();
	
		for (int i = 0; i < temp.getSize(); i++)
		{
		    list.add(temp.getIndex(i));
		}	
		
		//System.out.println("This is from the class MergeInsertionSort and printing the sorted list..");
		//temp.print();
		return list;
	}
	
	
	
}
