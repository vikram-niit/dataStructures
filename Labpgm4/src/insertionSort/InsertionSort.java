package insertionSort;

import java.io.*;

public class InsertionSort
{
	private int[] x;
	private int size;
	
	public InsertionSort()
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
		for(int i=1;i<size;i++)
		{
			// consider the ith element
			int item = x[i];
			
			System.out.println("Pass "+i+": "+this);
			
			// insert at appropriate position in partially sorted array
			int j=i-1;
			while(j>=0 && item<x[j])
			{				
				x[j+1] = x[j];
				
				j--;			

				System.out.println("Pass "+i+": "+this);
			}
			
			x[j+1] = item;
			
			System.out.println("Pass "+i+": "+this);
			System.out.println();
		}
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
		InsertionSort insertionSort = new InsertionSort();
		
		insertionSort.readInput();
		
		insertionSort.sort();
		
		System.out.println("Sorted array = "+insertionSort);
		
	}
}