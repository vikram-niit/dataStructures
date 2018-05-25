package linearQueue;

import java.io.*;
public class LinearQueue
{
	
		private int[] queue = new int[5];
		private int size, capacity;
		private int front,rear;
		
		public LinearQueue()
		{
			front = 0;
			rear = -1;
			capacity = 5;
			size = 0;
		}
		
		public void enqueue(int element)
		{
			if(isFull())
			{
				System.out.println("Queue full. Increasing size...");
				resize();
				System.out.println("Queue size increased, new capacity = "+capacity);
				System.out.println(this);			
			}
			
			rear = (rear + 1) % capacity;
			queue[rear] = element;				
			
			size++;
		}
		
		public int dequeue() throws QueueEmptyException
		{
			if(isEmpty())
				throw new QueueEmptyException();
			
			int element = queue[front];
			queue[front] = -1;
			front = (front + 1) % capacity;		
			
			size--;
			
			return element;
		}
		
		public void display()
		{
			int current = front;
			for(int i=0;i<size; i++)
			{				
				System.out.println(queue[current]);
				current = (current + 1)%capacity;
			}
			
			for(int i=0;i<queue.length;i++)
			{
				System.out.println();
				System.out.println("front = "+front);
				System.out.println(queue[i]);
				System.out.println("rear = "+rear);
			}
		}
		public void resize()
		{
			int[] newQueue = new int[queue.length << 1];
			
			int current = front;
			
			for(int i=0;i<size; i++)
			{				
				newQueue[i] = queue[current];
				current = (current + 1)%capacity;
			}
			
			capacity = queue.length << 1;
			queue = newQueue;
			front = 0;
			rear = size-1;			
		}
		
		public boolean isEmpty()
		{
			return (size == 0);
		}
		
		public boolean isFull()
		{
			return (size == capacity);
		}
		
		public String toString()
		{
			StringBuffer strBuffer = new StringBuffer();
			int current = front;
			strBuffer.append("front="+front+" rear="+rear);
			strBuffer.append(" queue contents = ");
			strBuffer.append("[");
			for(int i=0;i<size;i++)
			{				
				strBuffer.append(queue[current]+", ");
				current = (current + 1)%capacity;
			}
			
			
			strBuffer.append("]");
			if(size !=0 )
			strBuffer.delete(strBuffer.length()-3, strBuffer.length()-1);
			
			return strBuffer.toString();
		}
		public static void main(String[] args)
		{
			LinearQueue queue = new LinearQueue();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int choice = 0, flag = 0, element = -1;
			System.out.println(queue);
			
			
			System.out.println(queue);
		
			for(;;)
			{
				System.out.println();
				System.out.println("1. Enqueue");
				System.out.println("2. Dequeue");
				System.out.println("3. Display");
				System.out.println("4. Exit");
				
				System.out.println("Enter the choice");
				try{
					choice = Integer.parseInt(reader.readLine());
				}catch(IOException ex){
					System.out.println(ex);
				}
				System.out.println();
				
				switch(choice)
				{
					case 1: System.out.println("Enter the element to be inserted");
							try{
								element = Integer.parseInt(reader.readLine());
							}catch(IOException ex){
								System.out.println(ex);
							}
							queue.enqueue(element);
							System.out.println("After enqueuing "+queue);
							break;
							
					case 2: try{
							element = queue.dequeue();
							System.out.println("Deleted element = "+element);
							}catch(QueueEmptyException ex){
								System.out.println(ex);
							}
							System.out.println(queue);
							break;
							
					case 3: System.out.println(queue);
							break;
							
					default: flag = 1;
							 break;
				}
				
				if(flag == 1) break;
			}
		}
}