package linearList;

import java.lang.IndexOutOfBoundsException;
import java.util.Iterator;
import java.lang.reflect.Array; 
import java.util.Arrays;

/** Array Implementation of LinearList **/
@SuppressWarnings("unchecked")
public class ArrayLinearList<T> implements LinearList<T>{

/** Declares an array of integers and an integer size
 ** to hold the length of the array
 **/
	private T[] element;
	private int size;

	public ArrayLinearList(Class<T> cls)
	{
	
		this.size = 0;
		@SuppressWarnings("unchecked")
		final T[] temp = (T[])Array.newInstance(cls, 5);		
		this.element = temp;
	}

	public ArrayLinearList(Class<T> cls, int capacity)
	{
		this.size = 0;
		@SuppressWarnings("unchecked")
		final T[] temp = (T[])Array.newInstance(cls, capacity);		
		this.element = temp;
	}

	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size == 0;
	}

	public void checkIndex(int index) throws java.lang.IndexOutOfBoundsException
	{
		if(index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException("Invalid index");
		}		
	}

	 /**
     * Returns the element at the specified index
     * 
     * @param index index of the element in the list
     * @return element at the specified index
     * @throws IndexOutOfBoundsException 
     */
	public T get(int index) throws IndexOutOfBoundsException
	{
		checkIndex(index);
		
		return element[index];		
	}

	
	 /**
     * Returns the index of the element
     * 
     * @param element element for which index needs to be found
     * @return the index of the element     
     */
	public int indexOf(T key)
	{
		int i=0;
		// search for the element
		for(i=0; i<size; i++)
		{
			if(element[i] == key) break;
		}

		if(i < size ) 
			return i;
		else
			return -1;
	}
	
	 /**
     * Adds an element at the specified index
     * 
     * @param key element to be added
	 * @param index index of the element to be added          
     */
	public void add(T key, int index)
	{
		int i=0;
		if(index < 0 && index >= element.length)
			throw new IndexOutOfBoundsException("invalid index");
		/*else if(index == capacity)
			// increase the length of the array*/
		else if(size == element.length - 1)
		{
			element = Arrays.copyOf(element, size * 2);
		}			
		
		// shift the elements starting from the index right by one position
		for(i=size; i > index; i--)
		{
			element[i] = element[i-1];
		}

		// insert the element at the index
		element[i] = key;
		size++;
					
	}

	 /**
     * Removes an element with the specified key
     * 
     * @param key key of the element to be removed          
     */
	public void remove(T key)
	{
		int i=0;
		for(i=0; i<size; i++)
		{
			if(element[i] == key) break;
		}
		
		// shift the elements after the key left by one position
		for(int j = i; j<size-1; j++)
		{		
			element[j] = element[j+1];
		}
		
		// decrease the size of the list and delete the last element
		element[--size] = null;
	}
	
	 /**
     * Returns a string representation of the object
     *      
     * @return a string representation of the object.    
     */
	public String toString()
	{	/*
		Iterator it = element.iterator();

		while(it.hasnext())
		{
			System.out.print(" "+it.next()+" ");
		}
		*/
		
		StringBuffer strBuffer = new StringBuffer();

		for(int i =0; i<size; i++)
			strBuffer.append(" " + element[i] + " ");
		
		return new String(strBuffer);
	}
}
