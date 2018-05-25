package selection;

import java.io.*;
public class SelectIthSmallest
{
	private int[] array;
	private int size;
	
	public SelectIthSmallest()
	{		
		array = new int[]{10, 90, 20, 80, 70};	
		this.size = array.length;
	}
	
	public SelectIthSmallest(int size)
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
	
	public int partition(int[] array, int low, int high)
	{
		int i = low;
		int j = high;
		int pivot = array[low];
		
		while(i<j)
		{
			System.out.println("********");
			System.out.println("i="+i+"j="+j);
			while(array[i] <= pivot && i<high){i++;System.out.println("i="+i+"j="+j);}
			System.out.println("========");
			while(array[j] > pivot && j>low) {j--;System.out.println("i="+i+"j="+j);}
			System.out.println("i="+i+"j="+j);
			if(i<j)
			{
				// swap array[i] and array[j]
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;			
			}
		}
		
		// swap the pivot element and array[partition]
			int temp = array[low];
			array[low] = array[j];
			array[j] = temp;
			
			return j;
	}
	
	public int ithSmallest(int[] array, int low, int high, int i)
	{
		if(low > high)
			return -1;
		
		int partition = partition(array, low, high);
		
		// ith smallest element found
		if(partition == i)
			return array[partition];
		
		else if(i<partition)
			return ithSmallest(array, low, partition - 1, i);
		
		else if(i>partition)
			return ithSmallest(array, partition + 1, high, i);		
		
		return -1;
	}
	
	
	public static void main(String[] args)
	{
		SelectIthSmallest  k = new SelectIthSmallest();
		
		int i = 0;	
		
		for(int element: k.getArray())
			System.out.print(element+" ");
		
		System.out.println("\nEnter the value of i to find the ith smallest element");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			i = Integer.parseInt(reader.readLine());
		}catch(IOException ex){
		}
		
		System.out.println("The "+i+" th smallest element = "+k.ithSmallest(k.getArray(), 0, k.getArray().length - 1, i-1));		
		
	}
	
}