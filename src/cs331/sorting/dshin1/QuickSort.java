package cs331.sorting.dshin1;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;


public class QuickSort<T> implements Sort<Integer>
{
	 
	    public static ArrayList<Integer> array = new ArrayList<>();
	    
	    
	    QuickSort()
	    {
	    }//end default constructor
	    
	    public static void quickSort(ArrayList<Integer> array, int low, int high)
	    {
	    	//variable declarations
	    	Random rnd = new Random();
	    	int i = low;
	    	int j = high;
	    	int temp;
	    	//random pivot selection
	    	int pivot = array.get(i);
	        

	    	//partitioning method
	    	while (i <= j)
	    	{
	    		while (array.get(i) < pivot)
	    			i++;
	    		while (array.get(j) > pivot)
	    			j--;
	    		if (i <= j)
	    		{
	    			//swap
	    			temp = array.get(i);
	    			array.set(i,array.get(j));
	    			array.set(j, temp);

	    			i++;
	    			j--;
	    		}
	    	}

	    //sort lower half
	    if (low < j)
	    quickSort(array, low, j);
	    //sort upper half 
	    if (i < high)
	    quickSort(array, i, high);
	    }
	    
	 
	public void print(ArrayList<Integer> list) 
	{
		for (int i = 0; i < list.size(); i++)
	      System.out.print(list.get(i) + " ");
	}

	@Override
	public void init(List<Integer> list) 
	{
		for(int i = 0; i< list.size(); i++)
		{
			array.add(list.get(i));
		}
		quickSort(array, 0, array.size()-1);
	}

	@Override
	public List<Integer> getSortedList()
	{
		return array;
	}
}
