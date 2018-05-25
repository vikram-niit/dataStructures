package multipleQueues;

import java.io.*;

public class MultipleQueues
{
	private int[] multipleQueuesArray;
	private int front1;
	private int rear1;
	private int front2;
	private int rear2;
	
	public MultipleQueues()
	{
		multipleQueuesArray = new int[10];
		front1 = 0;
		rear1 = -1;
		front2 = multipleQueuesArray.length-1;
		rear2 = multipleQueuesArray.length;
	}
	
	public void enqueue1(int element)
	{
		if(queueFull())
			resize();
		
		multipleQueuesArray[++rear1] = element;		
	}
	
	public int dequeue1() throws QueueEmptyException
	{
		if(queue1Empty())
			throw new QueueEmptyException();
		
		else
			return multipleQueuesArray[front1++];
	}
	
	public void enqueue2(int element)
	{
		if(queueFull())
			resize();
		
		multipleQueuesArray[--rear2] = element;
	}
	
	public int dequeue2() throws QueueEmptyException
	{
		if(queue2Empty())
			throw new QueueEmptyException();
		else
			return multipleQueuesArray[front2--];		
	}
	
	public boolean queueFull()
	{
		return ((rear1 + 1) == rear2);
	}
	
	public boolean queue1Empty()
	{
		return front1 > rear1;
	}
	
	public boolean queue2Empty()
	{
		return front2 < rear2;
	}
	
	public String toString()
	{
		StringBuffer strBuffer = new StringBuffer();
		
		strBuffer.append("[");
		for(int i=front1; i<=rear1; i++)
			strBuffer.append(multipleQueuesArray[i]+" ");
		
		if(!queue1Empty())
			strBuffer.delete(strBuffer.length()-1, strBuffer.length());
		
		strBuffer.append("********");
		
		for(int i=rear2; i<=front2; i++)
			strBuffer.append(multipleQueuesArray[i]+" ");
		
		if(!queue2Empty())
			strBuffer.delete(strBuffer.length()-1, strBuffer.length());
		
		
		strBuffer.append("]");
		
		return strBuffer.toString();
	}
	
	public void resize()
	{
		int[] newArray = new int[multipleQueuesArray.length << 2];		
		
		int i=0, j=0;
		for(i=front1, j=0; i<=rear1; i++, j++)
			newArray[j] = multipleQueuesArray[i];
		
		front1 = 0;
		rear1 = j-1;
		
		for(i=front2, j=newArray.length-1; i>=rear2; i--, j--)
			newArray[j] = multipleQueuesArray[i];	
		
		front2 = newArray.length-1;
		rear2 = j+1;
		
		multipleQueuesArray = newArray;
	}
	
	public static void main(String[] args)
	{
		MultipleQueues q = new MultipleQueues();
		
		int choice = 0;
		int element = 0;
		int flag = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			for(;;)
			{
				System.out.println("1.Enqueue(Queue1)");
				System.out.println("2.Dequeue(Queue1)");
				System.out.println("3.Enqueue(Queue2)");
				System.out.println("4.Dequeue(Queue2)");
				System.out.println("5.Display");
				System.out.println("6.Exit");
				System.out.println("Enter the choice");
				
				try{
					choice = Integer.parseInt(reader.readLine());
				}catch(IOException ex){}
				
				switch(choice)
				{
					case 1: System.out.println("Enter the element to be enqueued");
							try{
								element = Integer.parseInt(reader.readLine());
							}catch(IOException ex){}
							q.enqueue1(element);			
							System.out.println(q);
							break;
					case 2: try{
								System.out.println("Dequeued element = "+q.dequeue1());
							}catch(QueueEmptyException ex){}
							System.out.println(q);
							break;
					case 3: System.out.println("Enter the element to be enqueued");
							try{
								element = Integer.parseInt(reader.readLine());
							}catch(IOException ex){}
							q.enqueue2(element);
							System.out.println(q);
							break;
					case 4: try{
								System.out.println("Dequeued element = "+q.dequeue2());
							}catch(QueueEmptyException ex){}
							System.out.println(q);
							break;
					case 5: System.out.println("========================================");
							System.out.println("Multiple Queues");
							System.out.println("========================================");
							System.out.println(q);
							break;
					default: flag = 1;
							 break;
				}
				if(flag == 1)break;
			}			
	}
}