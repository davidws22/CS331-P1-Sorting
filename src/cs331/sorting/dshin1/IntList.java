// ============================================================================
// file: IntList.java
// ============================================================================
// Programmer: David Shin
// Date: 2/7/17
// Class: CS 331 ("Design and Analysis of Algorithms")
// Time: T/R 5:00 - 6:50pm
// Instructor: Mr. Perez
// Project: 1
//
// Description:
//     This class is responsible for providing the tools to create a linked list
//		of integers.
//
// ============================================================================
package cs331.sorting.dshin1;

public class IntList
{
    public class Node
    {
	//variable declarations
	int data;
	Node next;
	Node prev;
	//copy constructor
	public Node( int data, Node next, Node prev)
	{
	    this.data = data;
	    this.next = next;
	}

	//default constructor
	public Node( )
	{
	    data = 0;
	    next = null;
	    prev = null;
	}

	//accessors
	public int getData()
	{
	    return data;
	}

	//mutators
	public void setData(int data)
	{
	    this.data = data;
	}
	

    }//end Node class

    protected Node head;
    protected Node tail;
    protected int size;

    //default constructor
    public IntList()
    {
	head = null;
	tail = null;
	size = 0;
    }

    //accessors
    public boolean isEmpty()
    {
	if(head == null)
	{
	    return true;
	}
	else
	    return false;
    }

    public int getSize()
    {
        return size;   
    }

    public int getIndex(int index)
    {
	Node curr = new Node();
	curr = head;
	for(int i = 0; i < index; i++)
	{	    
            curr = curr.next;
            
        }
        return curr.data;
    }

    //mutators
    public void addElement(int value)
    {
	Node temp = new Node(value, null,null);
	if (head == null)
	{
	    head = temp;
	    tail = head;
	    ++size;
	    
	}
	else
	{
		temp.prev = tail;
	    tail.next = temp;
	    tail = temp;
	   
	    ++size;
	}
    }

    public void setIndex(int index, int value)
    {
	Node curr = new Node ();
	curr = head;
	for(int i = 0; i < index; i++)
	{
	    curr = curr.next;
        }
	curr.data = value;
    }
    
    public void print()
    {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(getIndex(i));
        }
    }
    
}//end IntList class

