package hashTable;

public class HashTable
{
	private int tSize;
	private HashTableNode[] hashTable;
	private int count;
	private static final Integer LOAD_FACTOR = 20;
	
	
	public HashTable(int tSize)
	{
		this.tSize = tSize;
		hashTable = new HashTableNode[tSize];		
	}
	
	public int getTsize()
	{
		return this.tSize;
	}
	
	public void setTsize(int tSize)
	{
		this.tSize = tSize;
		HashTableNode[] hashTable = new HashTableNode[tSize];
	}
	
	public HashTableNode[] getHashTable()
	{
		return this.hashTable;
	}
	
	public void set(HashTableNode[] hashTable)
	{
		this.hashTable = hashTable;
	}
	
	public int getCount()
	{
		return this.count;
	}
	
	public void setCount(int count)
	{
		this.count = count;
	}
	
	public String toString()
	{
		StringBuffer strBuffer = new StringBuffer();
		
		strBuffer.append("\n");
		strBuffer.append("============================================================\n");
		strBuffer.append("HashTable (size = "+this.getTsize()+")\n");
		strBuffer.append("============================================================\n");		
		
		
		for(int i=0;i<this.tSize; i++)
		{
			strBuffer.append("[["+i+"] ==> ");
			if(hashTable[i] == null) 
			{	
				strBuffer.delete(strBuffer.length()-5, strBuffer.length());
				strBuffer.append("]\n");
				continue;
			}
			
			HashNode hashNode = hashTable[i].getStartNode();
			
			while(hashNode != null)
			{
				strBuffer.append(hashNode.getData()+" -> ");
				hashNode = hashNode.getNext();
			}
			
			if((hashTable[i].getBlockCount())!=0)
				strBuffer.delete(strBuffer.length()-3, strBuffer.length());
			
			strBuffer.append("]\n");
		}
		
		return strBuffer.toString();
	}
}