// ============================================================================
// file: MergeSort.java
// ============================================================================
// Programmer: David Shin
// Date: 2/7/17
// Class: CS 331 ("Design and Analysis of Algorithms")
// Time: T/R 5:00 - 6:50pm
// Instructor: Mr. Perez
// Project: 1
//
// Description:
//     This class is responsible for sorting a list of random integers using 
//		merge sort.
//
// ============================================================================

package cs331.sorting.dshin1;


import java.util.ArrayList;
import java.util.List;
import cs331.sorting.dshin1.IntList.Node;

public class MergeSort<T> implements Sort<Integer>
{
	//global variable 'temp' is responsible for keeping the values to be sorted in a linked list.
    private IntList temp = new IntList();
    
    
    public MergeSort()
    {
    }//end default constructor
    
    @Override
    public void init(List<Integer> list) 
    {
    	for (int i = 0; i < list.size(); i++) 
        {
            temp.addElement(list.get(i));
        }
    	//temp.print();
    }//end init
    
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
		temp = mergeSort(temp);
		for (int i = 0; i < temp.getSize(); i++)
		{
		    list.add(temp.getIndex(i));
		}	
		//System.out.println("This is from the class MergeSort and printing the sorted list..");
		//temp.print();
		return list;
	}
	    
}//end MergeSort class

