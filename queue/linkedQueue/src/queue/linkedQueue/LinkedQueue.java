package queue.linkedQueue;

import queue.*;
import java.io.*;

public class LinkedQueue
{

	Node frontNode;
	Node rearNode;
	int size = 0;	
	
	public LinkedQueue()
	{
		size = 0;
		frontNode = null;
		rearNode = null;
	}
	
	public Node getFrontNode()
	{
		return this.frontNode;
	}

	public Node getRearNode()
	{
		return this.rearNode;
	}

	public void setFrontNode(Node node)
	{
		this.frontNode = node;
	}

	public void setRearNode(Node node)
	{
		this.rearNode = node;
	}
	public boolean isEmpty()
	{
		return (frontNode == null && rearNode == null);
	}

	public void enqueue(int data)
	{
		Node newNode = new Node();
		newNode.setData(data);

		if(rearNode != null)
		{
			rearNode.setNode(newNode);			
		}

		rearNode = newNode;

		if(frontNode == null)
			frontNode = rearNode;

		size++;
	}

	public int dequeue() throws QueueEmptyException
	{
		int data;

		if(isEmpty())
			throw new QueueEmptyException();
		else
		{
			data = frontNode.getData();
			frontNode = frontNode.getNode();

			if(frontNode == null)
				rearNode = null;
		}	

		size--;		

		return data;		
	}

	public String toString()
	{
		Node temp = frontNode;

		StringBuffer strBuffer = new StringBuffer();
	
		for(int i =0; i< this.size; i++)
		{
			//System.out.println(temp.getData());
			strBuffer.append(temp.getData()+"->");
			temp = temp.getNode();
		}

		strBuffer.delete(strBuffer.length()-2, strBuffer.length());

		return strBuffer.toString();
	}

	public static void main(String[] args)
	{
		LinkedQueue queue = new LinkedQueue();

		queue.setFrontNode(null);
		queue.setRearNode(null);

		int frontElement = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0, flag = 0, element = 0;	
		

		for(;;)
		{
			System.out.println("Enter the choice");
			System.out.println("enqueue-1");
			System.out.println("dequeue-2");
			System.out.println("display-3");
			System.out.println("Exit-4");

			try{
			choice = Integer.parseInt(reader.readLine());
			}catch(IOException ex){
				System.out.println(ex);
			}

			switch(choice)
			{
				case 1:
					System.out.println("Enter the element to be inserted into the queue");
					try{
					element = Integer.parseInt(reader.readLine());
					}catch(IOException ex){
						System.out.println(ex);
					}
					queue.enqueue(element);
					break;
		
				case 2:
					try{
					frontElement = queue.dequeue();
					System.out.println("Deleted element = "+frontElement);
					}catch(Exception ex){
						System.out.println(ex);
					}
					
					break;

				case 3:
					System.out.println("------------------------------------"+queue);
					//queue.display();
					break;

				default:
					flag = 1;
					break;
			}

			if(flag == 1)
				break;
		}
	}
}
