package stack.linearStack;

import java.lang.Exception;
import stack.*;
import java.io.*;

public class LinearStack
{
	private String[] stack;
	private int top;

	public LinearStack()
	{
		top = -1;
		stack = new String[5];
	}

	public void push(String item)
	{
		if(top == stack.length - 1)
			resize();
		
			stack[++top] = item;
	}

	public String pop() throws StackUnderFlowException
	{
		if(top == -1)
		{			
			throw new StackUnderFlowException();			
		}
		else
			return stack[top--];
		
	}

	public String peek() throws NoSuchElementException
	{
		if(top == -1)
		{		
			throw new NoSuchElementException();
		}
		else
			return stack[top];
	}

	public boolean isEmpty()
	{
		return top==-1;
	}

	public void display()
	{
		
		System.out.println("top="+top);
		for(int i=top; i>=0; i--)
			System.out.print(stack[i]+" ");

		System.out.println();
	}

	public String toString()
	{
		//String result = "";
		StringBuffer strBuffer = new StringBuffer();
		System.out.println("top="+top);
		strBuffer.append("[");
		for(int i=top;i>=0;i--)
//		result += result + stack[i] + " ";
		strBuffer.append(stack[i]+",");
		
		if(!isEmpty())
		strBuffer.deleteCharAt(strBuffer.length()-1);

		strBuffer.append("]");
		return strBuffer.toString();


		
//		return result;
	}
	
	public void resize()
	{
		System.out.println("Increasing size of stack");
		
		String[] newStringArray = new String[stack.length << 1];
		
		//System.arrayCopy(stack, 0, newStringArray, 0, stack.length);
		for(int i=0;i<stack.length;i++)
			newStringArray[i] = stack[i];			
			
		stack = newStringArray;
		
		System.out.println("Stack size = "+stack.length);
	}
	
	public static void main(String[] args) 
	{
		LinearStack s = new LinearStack();		

		int choice = 0;
		String input=null;
		int flag = 0;
		int item = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		for(;;)
		{
			
			System.out.println("\nEnter the choice");			
			System.out.println(" 1-push \n 2-pop  \n 3-peek \n 4-display \n 5-Exit \n");

			try{
			input = reader.readLine().split(" ")[0];
			choice = Integer.parseInt(input);

			System.out.println("Entered choice = "+choice+"\n");
			}catch(IOException ex){
				System.out.println(ex);
			}

			
				switch(choice)
				{
					case 1: 
						try{
						System.out.println("Enter the item to be pushed");			
						input = reader.readLine();
						
						}catch(IOException ex){
							System.out.println(ex);
						}
						s.push(input);
						s.display();
						break;


					case 2: try{
						String element = s.pop();
						
						System.out.println("Popped element = "+element);
						s.display();
						}catch(Exception ex){
							System.out.println(ex);
						}
						
						break;

					case 3: try{
							System.out.println("Peek element = "+s.peek());
						}catch(Exception ex){
							System.out.println(ex);
						}
						break;

					case 4: //s.display();
						System.out.println("stack elements = "+s);
						break;

					default:flag = 1;
				}

			if(flag ==1) break;
		}
	}
}
