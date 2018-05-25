package mergeSort;

import java.io.*;

public class MergeSort
{
	private int[] x;
	private int size;
	
	public MergeSort()
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
		int low = 0;
		int high = x.length - 1;		
				
		mergeSort(low, high);	
	}
	
	/*
	*  perform the following operations
	*  recursively
	*
	*  1. Divide the array into 2 parts 
	*  2. sort the left part of the array
	*  3. sort the right part of the array
	*  4. merge the 2 arrays
	*/
	public void mergeSort(int low, int high)
	{
		int mid = (low + high) / 2;
		
		// partial array contains only one element 
		// array is already sorted, hence return if low == high
		if(low >= high) return;
		
		mergeSort(low, mid);
		mergeSort(mid+1, high);		
				
		merge(low, mid, high);	

		System.out.println("Merged partially sorted arrays : "+this);
	}
	
	public void merge(int low, int mid, int high)
	{
		int i = low;
		int j = mid+1;
		int k = 0;
		int[] temp = new int[x.length];
		
		while(i<=mid && j<=high)
		{
			if(x[i]<=x[j])
			{
				temp[k++] = x[i];
				i++;
			}
			
			if(x[i]>x[j]) 
			{
				temp[k++] = x[j];				
				j++;
			}			
		}
		
		// copy remaining elements 
		while(i<=mid)
			temp[k++] = x[i++];
		
		while(j<=high)
			temp[k++] = x[j++];
		
		// copy elements from temp array to x at positions from low to high
		for(i=low, k=0; i<=high; i++)
			x[i] = temp[k++];			
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
		MergeSort mergeSort = new MergeSort();
		
		mergeSort.readInput();
		
		System.out.println("Unsorted array: "+mergeSort);
		
		mergeSort.sort();
		
		System.out.println();
		System.out.println("Sorted array = "+mergeSort);
		
	}
}