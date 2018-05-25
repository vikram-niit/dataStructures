package linearList;

public class LinkedList<T> implements LinearList<T>{

	private Node<T> list;
	private int size;

	public LinkedList()
	{
		size = 0;
	}
		
	public int size()
	{
		return size;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	 /**
     * Checks whether the index is within valid range
     * 
     * @param index value of the index to be checked     
     * @throws IndexOutOfBoundsException 
     */
	public void checkIndex(int index) throws IndexOutOfBoundsException
	{
		if(index<0 && index>=size)
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
	 @SuppressWarnings("unchecked")
	public T get(int index) throws IndexOutOfBoundsException
	{
		checkIndex(index);
		Node<T> temp = list;

		for(int i=0;i<index;i++)
		{
			temp = temp.getNext();
		}
		
		return temp.getData();
	}

	 /**
     * Reads a record from the file
     * 
     * @param element element for which index needs to be found
     * @return index index of the element 
    
     */
	public int indexOf(T element)
	{
		Node temp = list;
		int i=0;
		while(temp!=null)
		{
			if(temp.getData() == element)break;
			
			temp = temp.getNext();
			i++;
		}

		if(temp!=null)
			return i;
		else
			return -1;
	}
	
	 /**
     * Adds an element at the specified index
     * 
     * @param element element to be added to the list
	 * @param index position at which element needs to be added
     */
	public void add(T element, int index)
	{
		Node temp = list;
		
		Node<T> newNode = new Node<T>();
		newNode.setData(element);

		if(temp == null)
		{
			list = newNode;
			newNode.setNext(null);
			size++;	

			return;
		}		
	
		for(int i=0;(i<index-1) || (i<size-1);i++)
		{
			temp = temp.getNext();
		}		
		
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);
		
		size++;

	}
	
	 /**
     * Removes the element from the list
     * 
     * @param element element to be removed
     */
	public void remove(T element)
	{
		Node current = list;
		Node previous = list;
		while((current!=null) && (current.getData() != element))
		{	
			previous = current;
			current = current.getNext();
		}
	
		// update previous node's next to current node's next and delete current node
		if(current!=null)
		{
			previous.setNext(current.getNext());
			current = null;
		}
		
		size--;
	}

	 /**
     * Returns a string representation of the linkedList
     *     
     * @return a string representation of the linkedList     
     */
	public String toString()
	{
		String result = "";
		Node current = list;
		while(current != null)
		{
			result += current.getData() + " ";
			current = current.getNext();
		}

		return result;		
	}
		
}
