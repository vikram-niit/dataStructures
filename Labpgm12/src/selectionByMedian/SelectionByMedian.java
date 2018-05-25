package selectionByMedian;

import java.io.*;
public class SelectionByMedian
{
	private int[] array;
	private int size;
	
	public SelectionByMedian()
	{		
		array = new int[]{10, 90, 20, 80, 70, 160, 150, 140, 130, 110, 100, 170, 180, 190};	
		this.size = array.length;
	}
	
	public SelectionByMedian(int size)
	{
		this.size = size;
		array = new int[size];		
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public void setSize(int size)
	{
		this.size = size;
	}
	
	public int[] getArray()
	{
		return this.array;
	}
	
	public void setArray(int[] array)
	{
		this.array = array;
	}
	
	public int partition(int[] array, int low, int high, int pivot)
	{
		int i = low;
		int j = high;		
		
		int pivotPosition = 0;
		
		System.out.println("pivot="+pivot);
		
		while(i<j)
		{
			System.out.println("\n********");
			System.out.println("i="+i+"j="+j);
			while(i<=high && (array[i] <= pivot) )
			{
				if(array[i] == pivot)pivotPosition = i;
				i++;System.out.println("i="+i+"j="+j+"pivotPosition="+pivotPosition);
				
			}
			System.out.println("========");
			while(array[j] > pivot && j>low) {
				
				
				j--;System.out.println("i="+i+"j="+j);
				
			}
			System.out.println("i="+i+"j="+j);
			if(i<j)
			{
				// swap array[i] and array[j]
				System.out.println("swapping "+array[i]+"and "+array[j]);
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;			
			}
		}
		
		// swap the pivot element and array[partition]
			System.out.println("swapping "+array[pivotPosition]+" and "+array[j]);
			int temp = array[pivotPosition];
			array[pivotPosition] = array[j];
			array[j] = temp;
			
			return j;
	}
	
	public int selection(int[] array, int[] mediansArray, int m)
	{
		
		int n = mediansArray.length;
		
		int numberOfSets = n/5;
		
		if(n%5 != 0)
			numberOfSets++;
		
		int[] medians = new int[numberOfSets];
		
		// divide the array into subsets of 5 and sort each one of them
		int i = 0;
		if((n/5) > 0)
		{
		
		System.out.println("\nInside if (n/5)>0 n="+n);
		for(int element: mediansArray)
			System.out.print(element+" ");
		
			int count = n;
			i=0;
			int k = 0;
			int l = 0;
			int[] tempArray = new int[5];
			System.out.println("\n count = "+count);
			while(count >= 5)
			{
				
				System.out.println("\nInside while");
				
				l = 0;
				for(int j=i;j<(i+5);j++)
				{					
					tempArray[l++] = mediansArray[j];
					
				//	System.out.println("\nselection: Inside outer for loop i="+i+"j="+j);
				//	for(int p=(i+1);p<((i+5) - j);p++)
				//	{
				//		System.out.println("\nnselection: Inside inner for loop ");
				//		if(mediansArray[p] > mediansArray[p+1])
				//		{
				//			
				//			System.out.println("\nSwapping elements "+mediansArray[p]+" and" +mediansArray[p+1]);
				//	
				//			int temp = mediansArray[p];
				//			mediansArray[p] = mediansArray[p+1];
				//			mediansArray[p+1] = temp;
				//		}
				//	}
				}
				
				// Find the median of each of the n/5 groups and store them in another array
				
				tempArray = sort(tempArray);
				
					System.out.println("\nsorted array");
				for(int element: tempArray)
			System.out.print(element+" ");
					
				medians[k++] = tempArray[2];
				
				// medians[k++] = mediansArray[(2*i + 5)/2];
				
				
		
			
				i = i+5;
				count = count - 5;
				
				
			}
			
			// find median for remaining last fewer than 5 elements
			if(count<5 && count!=0)
			{
				// sort the remaining elements
				l=0;
				tempArray = new int[count];
				while(count>0)
				{
					tempArray[l++] = mediansArray[i++];
					count--;
				}
				
				System.out.println("\n temp array");
				for(int element: tempArray)
			System.out.print(element+" ");
				
				tempArray = sort(tempArray);
				
				System.out.println("\nsorted array, i="+i);
				for(int element: tempArray)
			System.out.print(element+" ");
				//medians[k++] = mediansArray[i + ((count)/2)];
				
				int medianPosition = (tempArray.length / 2);
				medians[k++] = tempArray[medianPosition];
				System.out.println("\n count = "+count);
			}	
			
			System.out.println("\nInside if after evaluation of medians: array = ");
				for(int element: array)
			System.out.print(element+" ");
				
				System.out.println("\nInside if after evaluation of medians: mediansArray = ");
				for(int element: mediansArray)
			System.out.print(element+" ");
				
				System.out.println("\nInside if after evaluation of medians: medians = ");
				for(int element: medians)
			System.out.print(element+" ");
		
				
			// call selection recursively to find the median of medians
			return selection(array, medians, m);
		}
		
		else
		{
			System.out.println("\nInside else (n/5)>0 n="+n);
			for(int element: mediansArray)
			System.out.print(element+" ");			
			
			
			int medianPosition = mediansArray.length/2;
			int median = mediansArray[medianPosition];		
		
			//int low = array[0];
			//int high = array[array.length - 1];
			
			int low = 0;
			int high = array.length - 1;
			
			int partition = partition(array, low, high, median);
			
			// ith smallest element found
			if(partition == m)
				return array[partition];
			
			else if(m<partition)
			{
				System.out.println("\nInside if(m<partition) m= "+m+" partition="+partition);
				
				System.out.println("\n if(m<partition) array = ");
				for(int element: array)
			System.out.print(element+" ");
				int length = partition;
				
				if(length <= 0) return -1;
				
				int[] subArray = new int[length];
				
				// Form a subproblem
				for(int q=0;q<partition;q++)
					subArray[q] = array[q];
				
				
				int[] copy2 = new int[subArray.length];
		
				for(int j = 0;j<subArray.length; j++)
				copy2[j] = subArray[j];
			
				System.out.println("\nsubArray: ");
				for(int element: subArray)
				System.out.print(element+" ");
				
				return selection(subArray, copy2, m);
			}
			
			else if(m>partition)
			{  
				System.out.println("\nInside if(m>partition) m= "+m+" partition="+partition);
				int length = (array.length) - (partition + 1);
				
				if(length <= 0 ) return -1;
				
				int[] subArray = new int[length];
				
				// Form a subproblem
				int k=0;
				for(int q=partition+1;q<array.length;q++)
					subArray[k++] = array[q];
				
				int[] copy2 = new int[subArray.length];
		
				for(int j = 0;j<subArray.length; j++)
				copy2[j] = subArray[j];
			
			
				System.out.println("\nsubArray: ");
				for(int element: subArray)
				System.out.print(element+" ");
		
				return selection(subArray, copy2, m-(partition+1));		
			}
			
		}
		
		return -1;
	}
	
	public int[] sort(int[] array)
	{
		for(int i=1;i<array.length;i++)
		{
			for(int j=0; j<array.length - i;j++)
			{
				if(array[j] > array[j+1])
				{
						int temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
				}				
			}
		}
		
		return array;
	}
	
	public static void main(String[] args)
	{
		SelectionByMedian  k = new SelectionByMedian();
		
		int i = 0;	
		
		for(int element: k.getArray())
			System.out.print(element+" ");
		
		System.out.println("\nEnter the value of i to find the ith smallest element");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			i = Integer.parseInt(reader.readLine());
		}catch(IOException ex){
		}
		
		int[] copy = new int[k.getArray().length];
		
		for(int j = 0;j<k.getArray().length; j++)
			copy[j] = k.getArray()[j];
		
		int[] copy2 = new int[k.getArray().length];
		
		for(int j = 0;j<k.getArray().length; j++)
			copy2[j] = k.getArray()[j];
		
		
		
		System.out.println("The "+i+" th smallest element = "+k.selection(copy, copy2, i-1));		
		
	}
	
}