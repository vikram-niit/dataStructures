package priorityQueue;

import java.io.*;
import java.lang.Math;

public class PriorityQueue
{
	private int[] priorityQueue;
	private int size;
	
	public PriorityQueue()
	{
		size = 0;
		priorityQueue = new int[5];		
	}
	
	public void enqueue(int item)
	{
		if(full())
			resize();
		
		// insert item into heap using top down approach 
		
		int child = size;
		int parent = (child - 1)/2;
		
		// if the current element to be inserted is greater than 
		// that of its parent move the parent to the child position
		// repeat the same at all levels till the root
		while((child>0) && item > priorityQueue[parent])
		{
			priorityQueue[child] = priorityQueue[parent];
			child = parent;
			parent = (parent - 1)/2;		
		}
		
		// insert the item at the appropriate position
		// so that the heap property is satisfied
		priorityQueue[child] = item;		
		
		size++;
		
	}
	
	public int dequeue() throws QueueEmptyException
	{
		if(empty())
			throw new QueueEmptyException();
		
		// delete the root and move the last element to root
		// adjust the heap to satisfy the max-heap property
		int element = priorityQueue[0];
		priorityQueue[0] = priorityQueue[size-1];
		System.out.println("Last element = "+priorityQueue[size-1]);
		size--;
		
		int parent = 0;
		int child = (parent * 2) + 1;		
		
		int largestChild = child;
		
		while(child < size)
		{			
			// adjust the heap
			// check if right child exists
			if((child + 1) < size)
				// check if it is greater than the left child and update the largestChild
				if(priorityQueue[child+1] > priorityQueue[child])
					largestChild = child + 1;				
				
				System.out.println("parent = "+parent+"child = "+child+"largestChild = "+largestChild);
			// swap the largest child and the parent if largestChild > parent
			if(priorityQueue[largestChild] > priorityQueue[parent])
			{
				int temp = priorityQueue[parent];
				priorityQueue[parent] = priorityQueue[largestChild];
				priorityQueue[largestChild] = temp;
			}
			else
				// max-heap property is satisfied, hence stop adjusting the heap, break out of the loop
				break;
			
			// repeat the same for the subtree with largestChild as parent node
			parent = largestChild;
			child = 2*parent + 1;
			largestChild = child;
		
		}		
		
		return element;
	}
	
	public boolean empty()
	{
		return size == 0;
	}
	
	public boolean full()
	{
		return size == priorityQueue.length;
	}
	
	public void resize()
	{
		int[] newArray = new int[priorityQueue.length << 1];
		
		for(int i=0;i<priorityQueue.length;i++)
			newArray[i] = priorityQueue[i];
		
		priorityQueue = newArray;
	}
	
	public String toString()
	{
		StringBuffer strBuffer = new StringBuffer();
		
		strBuffer.append("[");
		
		for(int i=0;i<size;i++)
		{
			strBuffer.append(priorityQueue[i]+", ");
		}
		
		if(size!=0)
			strBuffer.delete(strBuffer.length()-2, strBuffer.length());
		
		strBuffer.append("]");
		
		return strBuffer.toString();
	}
	
	public static void main(String[] args)
	{
		PriorityQueue priorityQueue = new PriorityQueue();
		
		int choice = 0;
		int element = 0;
		int flag = 0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for(;;)
		{
			System.out.println("Enter the choice");
			System.out.println("1.Enqueue");
			System.out.println("2.Dequeue");
			System.out.println("3.Display");
			System.out.println("4.Exit");
			
			try{
				choice = Integer.parseInt(reader.readLine());
			}catch(IOException ex){
				System.out.println(ex);
			}
			
			switch(choice)
			{
				case 1: System.out.println("Enter the element to be inserted");
						try{
							element = Integer.parseInt(reader.readLine());
						}catch(IOException ex){
							System.out.println(ex);
						}
						priorityQueue.enqueue(element);
						System.out.println("priorityQueue = "+priorityQueue);
						break;
						
				case 2: try{
						element = priorityQueue.dequeue();
						System.out.println("Deleted element = "+element);
						}catch(QueueEmptyException ex){
							System.out.println(ex);
						}
						System.out.println("priorityQueue = "+priorityQueue);
						
						break;
						
				case 3: System.out.println("priorityQueue = "+priorityQueue);
						break;
						
				default: flag = 1;
						 break;				
			}
			if(flag == 1)break;
		}		
		
	}
	
}