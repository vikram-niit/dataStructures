package hashTable;

public class HashTableOperations
{
	public static HashTable createHashTable(int size)
	{
		HashTable hashTable = new HashTable(size);

		return hashTable;
	}
	
	public static void insert(HashTable hashTable, int data)
	{
		if(search(hashTable, data))
		{
			System.out.println("Data already in hashTable");
			return;
		}
		
		int index = Hash(hashTable, data);
		
		HashTableNode hashTableNode = hashTable.getHashTable()[index];
		
		if(hashTableNode == null)
		{
			hashTable.getHashTable()[index] = new HashTableNode();
			hashTableNode = hashTable.getHashTable()[index];			
		}
		
		hashTableNode.setBlockCount(hashTableNode.getBlockCount() + 1);
		
		HashNode temp = hashTableNode.getStartNode();
		
		HashNode newNode = new HashNode(data);
		
		
		// if blockCount > LOAD_FACTOR increase table size and rehash
		
		if(temp == null)
		{			
			temp = newNode;
			hashTableNode.setStartNode(temp);
		}
		else
		{
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}		
		
		
	}
	
	public static boolean search(HashTable hashTable, int data)
	{
		int index = Hash(hashTable, data);		
		
		HashTableNode hashTableNode = hashTable.getHashTable()[index];
		
		if(hashTableNode == null) 
			return false;
		
		HashNode temp = hashTableNode.getStartNode();
		
		while(temp != null)
		{
			if(temp.getData() == data)
				return true;
			temp = temp.getNext();
		}
		
		return false;
	}
	
	public static void delete(HashTable hashTable, int data)
	{
		if(!search(hashTable, data))
		{
			System.out.println("No such element exists");
			return;
		}
		
		int index = Hash(hashTable, data);
		
		HashTableNode hashTableNode = hashTable.getHashTable()[index];
		hashTableNode.setBlockCount(hashTableNode.getBlockCount() - 1);
		
		HashNode temp = hashTableNode.getStartNode();
		HashNode prev = temp;
		
		while(temp != null)
		{
			if(temp.getData() == data)
			{
				prev.setNext(temp.getNext());
				temp = null;
				
				return;
			}
			
			prev = temp;
			temp = temp.getNext();
		}
	}
	
	public static int Hash(HashTable hashTable, int data)	{
		
		return (data)%(hashTable.getTsize());
	}
	
	public static void main(String[] args)
	{
		HashTable hashTable = createHashTable(5);
		
		System.out.println(hashTable);
		insert(hashTable, 1);
		insert(hashTable, 11);
		insert(hashTable, 21);
		insert(hashTable, 12);
		insert(hashTable, 22);
		
		System.out.println(hashTable);
		
		if(search(hashTable, 12))
			System.out.println("Key 12 found\n");
		else
			System.out.println("Key 12 not found\n");
		
		System.out.println(hashTable);
		
		
		delete(hashTable, 22);
		System.out.println("Key 22 deleted");
		
		System.out.println(hashTable);
	}
	
}
