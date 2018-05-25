package heapSort;

import java.io.*;

public class HeapSort
{
	private int[] x;
	private int size;
	
	public HeapSort()
	{
		x = new int[5];
		size = 0;
	}
	public void readInput()
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the number of elements");
		try{
			this.size = Integer.parseInt(reader.readLine());
			
			x = new int[size];
			
			System.out.println("Enter the elements");
			for(int i=0;i<size;i++)
				x[i] = Integer.parseInt(reader.readLine());	
		
		}catch(IOException ex){
			System.out.println(ex);
		}
	}
	
	public void sort()
	{
		build_max_heap(size);
				System.out.println("Max Heap = "+this);
				System.out.println("Sorting the array by getting the ith largest element at the root and adjusting the heap");
		for(int i=size-1; i>=0; i--)
		{
			// swap the root and the last element
			int temp = x[i];
			x[i] = x[0];
			x[0] = temp;
			
			// adjust the heap consisting of remaining i elements
			heapify(i, 0);
			
			System.out.println("Array contents ="+this);
		}
		
	}	
	
	public void build_max_heap(int n)
	{
		for(int i=n/2; i>=0; i--)
			heapify(n, i);
	}
	
	public void heapify(int n, int root)
	{	
		int left = 	2 * root;
		int right = 2 * root + 1;
		
		int temp = 0;
		int largest = left;
		
		// no left child, hence no right child because
		// of the property of complete binary tree
		if(left>=n) return;
		
		//only left child exists
		// check whether left child is larger than root
		else if(right>=n) largest = x[largest]>x[root]?left:root;
		
		// both left and right child exists
		else if(x[left]<x[right])
			largest = right;
		
		largest = x[largest]>x[root]?largest:root;
		
		// swap parent element with the largest element		
		if(x[largest] > x[root])
		{			
			temp = x[root];
			x[root] = x[largest];
			x[largest] = temp;
			
			root = largest;
		
			// call heapify recursively until the root does not have any children
			// or root satisfies the max-heap property
			heapify(n, root);
		}
		// max heap property is satisfied
		else
			return;
		
		
	}
	
	public String toString()
	{
		StringBuffer strBuffer = new StringBuffer();
		
		strBuffer.append("[");
		
		for(int i=0;i<size;i++)
			strBuffer.append(x[i]+", ");
		
		if(size!=0)
			strBuffer.delete(strBuffer.length()-2, strBuffer.length());
		
		strBuffer.append("]");
		
		return strBuffer.toString();
	}
	
	public static void main(String[] args)
	{
		HeapSort heapSort = new HeapSort();
		
		heapSort.readInput();
		
		System.out.println("Unsorted array: "+heapSort);
		
		heapSort.sort();
		
		System.out.println();
		System.out.println("Sorted array = "+heapSort);
		
	}
}