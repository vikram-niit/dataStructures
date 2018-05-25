package stack.linkedStack;

import java.io.*;
import stack.*;
import java.lang.*;

public class LinkedStack
{
	private Node top;
	private int size;	

		
	public LinkedStack()
	{
		top = null;
		size = 0;
	}

	public int getSize()
	{
		return size;
	}
	public void push(String data)
	{
		Node newNode = new Node();
		newNode.setData(data);
		
		if(size == 0)
		{
			top = newNode;
		}
		else
		{
			newNode.setNode(top);
			top = newNode;
		}
			
		size++;
	}

	public String pop() throws StackUnderFlowException
	{
		int item = 0;
		String element = "";
		if(size == 0)
			throw new stack.StackUnderFlowException();
		else
		{
			element = top.getData();
			top = top.getNode();
			size--;		
		}		
		
		return element;
	}

	public String peep() throws NoSuchElementException
	{
		if(size == 0)
			throw new NoSuchElementException();
		else
		{
			return this.top.getData();
		}
	}
		
	public String toString()
	{
		Node temp = top;
		
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("[");
		while(temp != null)
		{
			strBuffer.append(temp.getData()+"->");
			temp = temp.getNode();
		}

		if(top!=null)
		strBuffer.delete(strBuffer.length()-2, strBuffer.length());
	
		strBuffer.append("]");
		
		return strBuffer.toString();
	}


	public static void main(String[] args)
	{
		LinkedStack stack = new LinkedStack();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		
		int choice = 0, flag = 0, item = 0;
		String element = "";
		for(;;)
		{
			System.out.println("Enter the choice");
			System.out.println("1.push");
			System.out.println("2.pop");
			System.out.println("3.peek");
			System.out.println("4.Display");
			System.out.println("5.Exit");
		
			try{
			choice = Integer.parseInt(reader.readLine());
			}catch(IOException ex){
				System.out.println(ex);
			}
			
			switch(choice)
			{
				case 1: System.out.println("Enter the element to be pushed");
					try{
					element = reader.readLine().split(" ")[0];
					}catch(IOException ex){
						System.out.println(ex);
					}
					stack.push(element);
					System.out.println("Linked Stack: "+stack);				
					break;
				case 2: try{
					System.out.println("Popped element = "+ stack.pop() + "\nsize = "+stack.getSize());
					System.out.println("Linked Stack: "+stack);				
					}catch(StackUnderFlowException ex){
						System.out.println(ex);
					}
					break;
				case 3: try{
					System.out.println("Peek element = "+stack.peep());
					System.out.println("Linked Stack: "+stack);				
					}catch(Exception ex){
						System.out.println(ex);
					}
					break;
				case 4:	System.out.println("-----------------------------------------------------");
					System.out.println("Linked Stack: "+stack);				
					System.out.println("-----------------------------------------------------");
					break;
				default: flag = 1;
					 break;			
			}


			//System.out.println("Enter 1 to continue, 0 to exit ");
			//try{
			//flag = Integer.parseInt(reader.readLine());
			//}catch(IOException ex){
			//	System.out.println(ex);
			//}

			if(flag == 1)
				break;		
			
		}
	}
}
