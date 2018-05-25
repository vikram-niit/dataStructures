package linearList;

public class Node<T>{

	private Node next;
	private T data;

	public T getData()
	{
		return data;
	}
	
	public void setData(T data)
	{
		this.data = data;
	}

	public Node getNext()
	{	
		return next;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}

}
