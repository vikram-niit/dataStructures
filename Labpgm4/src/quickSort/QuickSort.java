package quickSort;

import java.io.*;

public class QuickSort
{
	private int[] x;
	private int size;
	
	public QuickSort()
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
		quickSort(0, size-1);
	}	
	
	public void quickSort(int low, int high)
	{		
		if(low<high)
		{
			int partition = partition(low, high);
			
			System.out.println("Partitioned array = "+this+" partition="+partition);	
			System.out.println();
			
			quickSort(low, partition-1);
			quickSort(partition+1, high);	
		}
		
	}
	
	public int partition(int low, int high)
	{
		int pivot = low;
		
		int i=low, j=high;
		int temp = 0;
		
		while(i<j)
		{
			
			while(i<size && x[i] <= x[pivot])
				i++;
			
			while(j>=0 && x[j] > x[pivot])
				j--;		
			
			// swap x[i] and x[j]
			if(i<size && j>=0 && i<j)
			{
				temp = x[i];
				x[i] = x[j];
				x[j] = temp;			
			}
			System.out.println("Array = "+this+" i="+i+" j="+j+" pivot element = "+x[pivot]);
		}
				
		// swap x[pivot] with a[j]
		if(j>=0)
		{
			temp = x[pivot];
			x[pivot] = x[j];
			x[j] = temp;
		}
		
		System.out.println("Array = "+this);
		
		return j;
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
		QuickSort quickSort = new QuickSort();
		
		quickSort.readInput();
		
		System.out.println("Unsorted array: "+quickSort);
		
		quickSort.sort();
		
		System.out.println();
		System.out.println("Sorted array = "+quickSort);
		
	}
}