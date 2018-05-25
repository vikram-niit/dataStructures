package circularList;

import java.io.*;

public class CircularList
{
		private Node head;
		
		public CircularList()
		{
			head = null;
		}
		
		public void insertAtBeginning(Node newNode)
		{
			Node currentNode = head;
			
			if(head == null)
			{
				newNode.setNode(newNode);
				head = newNode;
				
				return;
			}
			
			// traverse to the end of the list
			while(currentNode.getNode() != head)
				currentNode = currentNode.getNode();
			 
			// set new node's next pointer to point to head
			// set last node's next pointer to point to the new node
			// make the new node the head node
			newNode.setNode(head);
			currentNode.setNode(newNode);
			
			head = newNode;				
		}
		
		public void insertAtEnd(Node newNode)
		{
			Node currentNode = head;
			
			if(head == null)
			{
				newNode.setNode(newNode);
				head = newNode;
				
				return;
			}
			
			// traverse to the end of the list
			while(currentNode.getNode() != head)
				currentNode = currentNode.getNode();
			
			// set new node's next pointer to point to head
			// set last node's next pointer to point to new node
			newNode.setNode(head);
			currentNode.setNode(newNode);
		}
		
		public void deleteLastNode()
		{
			Node currentNode = head;
			Node previousNode = head;
			
			if(head == null)
			{
				System.out.println("List is empty");
				return;
			}

			// head points to itself(only one node exists)
			// delete the head by setting it to null
			else if(head.getNode() == head)
			{
				head = null;
				return;
			}
			// traverse to the end of the list with previous node pointing
			// to the second last node
			while(currentNode.getNode() != head)
			{
				previousNode = currentNode;
				currentNode = currentNode.getNode();
			}
			
			// set the second last node's next pointer to point to the head node
			previousNode.setNode(currentNode.getNode());			
			
			currentNode = null;			
		}
		
		public void deleteFirstNode()
		{
			Node currentNode = head;
			
			
			if(head == null)
			{
				System.out.println("List is empty");
				return;
			}
			
			// head points to itself(only one node exists)
			// delete the head by setting it to null
			else if(head.getNode() == head)
			{
				head = null;
				return;
			}
			
			// traverse to the last node in the list
			while(currentNode.getNode() != head)
				currentNode = currentNode.getNode();
			
			// make the second node the head of the list and set last 
			// node's next pointer to point to the new head node
			head = currentNode.getNode().getNode();
			currentNode.setNode(head);
			
		}
		
		public String toString()
		{
			Node currentNode = head;
			StringBuffer strBuffer = new StringBuffer();
			
			strBuffer.append("[");
			
			if(currentNode != null)			
			{
				while(currentNode.getNode() != head)
				{
					strBuffer.append(currentNode.getData()+"->");
					currentNode = currentNode.getNode();
				}
				
				strBuffer.append(currentNode.getData());
			}
			
			
			strBuffer.append("]");
			
			return strBuffer.toString();
		}
		
		public static void main(String[] args)
		{
			CircularList list = new CircularList();
			
			int choice = 0;
			int element = -1;
			int flag = 0;
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			for(;;)
			{
				System.out.println("1.Insert at the beginning of the list");
				System.out.println("2.Insert at the end of the list");
				System.out.println("3.Delete at the begnning of the list");
				System.out.println("4.Delete at the end of the list");
				System.out.println("5.Display");
				System.out.println("6.Exit");
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
								System.out.println("Enter the element");
								element = Integer.parseInt(reader.readLine());
								Node newNode = new Node();
								newNode.setData(element);
								list.insertAtBeginning(newNode);								
							}catch(IOException ex){
								System.out.println(ex);
							}
							System.out.println(list);
							break;
							
					case 2: System.out.println("Enter the element to be inserted");
							try{
								System.out.println("Enter the element");
								element = Integer.parseInt(reader.readLine());
								Node newNode = new Node();
								newNode.setData(element);
								list.insertAtEnd(newNode);								
							}catch(IOException ex){
								System.out.println(ex);
							}
							System.out.println(list);
							break;
							
					case 3: list.deleteFirstNode();
							System.out.println(list);
							break;
							
					case 4: list.deleteLastNode();
							System.out.println(list);
							break;
							
					case 5: System.out.println(list);
					        break;
							
					default: flag = 1;
							 break;
				}
				
				if(flag == 1) break;
			}
		}
}