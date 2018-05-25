package polynomialAddAndSubtract;

public class Node
{
	private Node left;
	private Node right;
	private int data;

	public Node()
	{
		this.data = -1;
		this.left = null;
		this.right = null;
	}
	
	public Node(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public int getData()
	{
		return this.data;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	public Node getLeft()
	{
		return this.left;
	}

	public void setLeft(Node left)
	{
		this.left = left;
	}
	
	public Node getRight()
	{
		return this.right;
	}
	
	public void setRight(Node right)
	{
		this.right = right;
	}
}
