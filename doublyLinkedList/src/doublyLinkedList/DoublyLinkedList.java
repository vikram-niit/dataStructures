package doublyLinkedList;

import java.io.*;
public class DoublyLinkedList
{
	private Node head;
	
	public Node getHead()
	{
		return this.head;
	}
	
	public void insertAtTheBeginning(Node newNode)
	{
		if(head == null)
		{
			head = newNode;			
			
			return;
		}		
		else
		{
			// set new node's right pointer to point to head
			// and current head's left pointer to point to newNode
			newNode.setRight(head);
			newNode.setLeft(null);
			head.setLeft(newNode);
			
			// make the new node the head node
			head = newNode;
			
		}
	}
	
	public void insertAtTheEnd(Node newNode)
	{
		if(head == null)
		{
			head = newNode;
			
			return;
		}
		else
		{
			Node currentNode = head;
			// traverse to the last node in the list
			while(currentNode.getRight() != null)
			{
				currentNode = currentNode.getRight();
			}
			
			// set the right pointer of the current last node to point to the new node
			// set the left pointer of the new node to point to the current last node
			currentNode.setRight(newNode);
			newNode.setLeft(currentNode);
		}		
	}
	
	public void insertAtTheMiddle(Node newNode, int position)
	{
		// insert at the beginning
		if(position == 0)
		{
			insertAtTheBeginning(newNode);
			
			return;
		}		
			
		else 
		{
			int currentPosition = 0;
			Node currentNode = head;
			// traverse to the node at the specified position
			while(currentPosition != position && currentNode != null)
			{
				currentNode = currentNode.getRight();	
				currentPosition++;
			}			
			
			if(currentPosition == position && currentNode != null)
			{
				newNode.setLeft(currentNode.getLeft());
				newNode.setRight(currentNode);
				currentNode.setLeft(newNode);			
				newNode.getLeft().setRight(newNode);
			}
			// insert at the end
			else if(currentPosition == position && currentNode == null)
			{			
				insertAtTheEnd(newNode);
			}
			else
			{
				System.out.println("Invalid position");
			}
		}
		
	}
	
	public void deleteFirst()
	{
		if(head == null)
			return;
		
		else
		{
			head = head.getRight();			
			
			return;
		}
	}
	
	public void deleteLast()
	{
		if(head == null)
			return;
		
		//only one node exists
		else if(head.getRight() == null)
		{
			head = null;
			
			return;
		}
		
		else
		{
			Node currentNode = head;
			
			// traverse to the last node
			while(currentNode.getRight() != null)
			{
				currentNode = currentNode.getRight();
			}
			
			// get the second last node and update its right pointer to null
			Node previousNode = currentNode.getLeft();
			previousNode.setRight(null);
			currentNode.setLeft(null);
			currentNode = null;
		}
	}
	
	/*
	** reuses methods deleteFirst and deleteLast for deleting first and last nodes
	** checks whether position is 0. If it is 0 calls deleteFirst(), else traverses the
	** list and determines whether node to be deleted is last or not. If it is the last node
	** to be deleted calls the method deleteLast(), else deletes the middle node and links
	** the previousNode and the nextNode	
	*/
	public void deleteMiddle(int position)
	{
		if(position == 0)
			deleteFirst();
		
		else if(head != null)
		{
			Node currentNode = head;
			int currentPosition = 0;
			
			while(currentPosition != position && currentNode.getRight() != null)
			{
				currentNode = currentNode.getRight();
				currentPosition++;
			}
			
			// if node to be deleted is the last node call deleteLast()
			if(currentPosition == position && currentNode.getRight() == null)
				deleteLast();
			else if(currentPosition == position && currentNode.getRight() != null)
			{
				Node previousNode = currentNode.getLeft();
				Node nextNode = currentNode.getRight();
				
				previousNode.setRight(nextNode);
				nextNode.setLeft(previousNode);
				
				currentNode = null;
			}			
			else 
				System.out.println("Invalid position");
		}
		else
				System.out.println("Invalid position");
	}
	
	public String toString()
	{
		StringBuffer strBuffer = new StringBuffer();
		
		Node currentNode = head;
		
		if(head == null)
			System.out.println("List is empty");
		
		strBuffer.append("[");
		while(currentNode != null)
		{
			strBuffer.append(currentNode.getData()+"<=>");
			currentNode = currentNode.getRight();
		}
		
		// if list is not empty
		if(head!=null)
			strBuffer.delete(strBuffer.length()-3, strBuffer.length());
		
		strBuffer.append("]");
		return strBuffer.toString();
	}
	
	
	public static void main(String[] args)
	{
		
		DoublyLinkedList list = new DoublyLinkedList();
		
		int choice = 0;
		int element = -1;
		int flag = 0;
		int position = 0;
		Node newNode = null;	
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
		for(;;)
		{
			System.out.println("1.Insert at the beginning of the list");
			System.out.println("2.Insert at the end of the list");
			System.out.println("3.Insert at the middle of the list");
			System.out.println("4.Delete First node");
			System.out.println("5.Delete Last node");
			System.out.println("6.Delete node at middle");
			System.out.println("7.Display");
			System.out.println("Enter the choice");
			
			try{
				choice = Integer.parseInt(reader.readLine());
			}catch(IOException ex){
				System.out.println(ex);
			}
		
			switch(choice)
			{
				case 1: System.out.println("Enter the element to be inserted");
						try{
							element = Integer.parseInt(reader.readLine());
						}catch(IOException ex){
							System.out.println(ex);
						}
							newNode = new Node();
							newNode.setData(element);
						
							list.insertAtTheBeginning(newNode);
							System.out.println(list);
							break;
				
				case 2: System.out.println("Enter the element to be inserted");
						try{
							element = Integer.parseInt(reader.readLine());
						}catch(IOException ex){
							System.out.println(ex);
						}
							newNode = new Node();
							newNode.setData(element);
						
							list.insertAtTheEnd(newNode);
							System.out.println(list);
							break;
				case 3: System.out.println("Enter the element to be inserted");
						try{
							element = Integer.parseInt(reader.readLine());
						}catch(IOException ex){
							System.out.println(ex);
						}
						
						newNode = new Node();
						newNode.setData(element);
						
						System.out.println("Enter the position to be inserted");
						try{
							position = Integer.parseInt(reader.readLine());
						}catch(IOException ex){
							System.out.println(ex);
						}
							
						
							list.insertAtTheMiddle(newNode, position);
							System.out.println(list);
							break;
							
				case 4: list.deleteFirst();
						System.out.println(list);
						break;
						
				case 5: list.deleteLast();
						System.out.println(list);
						break;
						
				case 6: System.out.println("Enter the position of the node to be deleted");
						try{
							position = Integer.parseInt(reader.readLine());
						}catch(IOException ex){
							System.out.println(ex);
						}
						list.deleteMiddle(position);
						System.out.println(list);
						break;
						
				case 7: System.out.println(list);
						break;
						
				default: flag = 1;
						 break;
			}
			if(flag == 1)break;
		}
		
	}
}