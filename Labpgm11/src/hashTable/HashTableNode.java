package hashTable;

public class HashTableNode
{
	private HashNode startNode;
	private int blockCount;
	
	public HashTableNode()
	{
		this.startNode = null;
		this.blockCount = 0;
	}
	
	public HashNode getStartNode()
	{
		return this.startNode;
	}
	
	public void setStartNode(HashNode startNode)
	{
		this.startNode = startNode;
	}
	
	public int getBlockCount()
	{
		return this.blockCount;
	}
	
	public void setBlockCount(int blockCount)
	{
		this.blockCount = blockCount;
	}
}