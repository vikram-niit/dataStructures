package binarySearchTree;

public class BSTNode
{
	BSTNode left;
	BSTNode right;
	int data;
	
	public BSTNode()
	{
		left = null;
		right = null;
		data = 0;
	}
	
	public BSTNode(int key)
	{
		left = null;
		right = null;
		data = key;
	}
	
	public int getData()
	{
		return this.data;
	}
	
	public void setData(int data)
	{
		this.data = data;
	}
	
	public BSTNode getLeft()
	{
		return this.left;
	}
	
	public void setLeft(BSTNode left)
	{
		this.left = left;
	}
	
	public BSTNode getRight()
	{
		return this.right;
	}
	
	public void setRight(BSTNode right)
	{
		this.right = right;
	}
	
	public String toString()
	{
		StringBuffer strBuffer = new StringBuffer();
		
		strBuffer.append(this.getData());
		
		return strBuffer.toString();
	}
}