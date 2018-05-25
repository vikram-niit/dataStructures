package hashTable;

public class HashNode
{
	private int data;
	private HashNode next;
	
	public HashNode()
	{
		this.data = 0;
		this.next = null;
	}
	
	public HashNode(int data)
	{
		this.data = data;
		this.next = null;
	}
	
	public int getData()
	{
		return this.data;
	}
	
	public void setData(int data)
	{
		this.data = data;
	}
	
	public HashNode getNext()
	{
		return this.next;
	}
	
	public void setNext(HashNode next)
	{
		this.next = next;
	}
	
}