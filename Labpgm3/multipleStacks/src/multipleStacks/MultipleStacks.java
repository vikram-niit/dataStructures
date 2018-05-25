package multipleStacks;

import java.io.*;
public class MultipleStacks
{
	private int[] multipleStacksArray;
	private int stack1top;
	private int stack2top;
	
	public MultipleStacks()
	{
		multipleStacksArray = new int[10];
		stack1top = -1;	
		stack2top = multipleStacksArray.length;
	}
	
	public int pop1() throws StackUnderFlowException
	{
		if(isStack1Empty())
			throw new StackUnderFlowException();
		
		else
		{
			return multipleStacksArray[stack1top--];
		}		
	}
	
	public void push1(int element)
	{
		if(isFull())
			// increase size of the array
		resize();
		
		
			multipleStacksArray[++stack1top] = element;
		
	}
	
	public int pop2() throws StackUnderFlowException
	{
		if(isStack2Empty())
			throw new StackUnderFlowException();
		
		else
		{
			return multipleStacksArray[stack2top++];
		}		
	}
	
	public void push2(int element)
	{
		if(isFull())
		// increase size of the array
		resize();
		
			multipleStacksArray[--stack2top] = element;
		
	}
	
	public boolean isStack1Empty()
	{
		return (stack1top == -1);
	}
	
	public boolean isStack2Empty()
	{
		return (stack2top == multipleStacksArray.length);
	}
	
	public boolean isFull()
	{
		return ((stack1top+1) == stack2top);
	}
	
	public void resize()
	{
		int[] newArray = new int[multipleStacksArray.length << 1];
		
		for(int i=0; i<=stack1top; i++)
			newArray[i] = multipleStacksArray[i];
		
		for(int j=multipleStacksArray.length-1; j>=stack2top; j--)
			newArray[j + newArray.length - multipleStacksArray.length] = multipleStacksArray[j];
		
		// update new stack2top
		stack2top = stack2top + newArray.length - multipleStacksArray.length;
		
		multipleStacksArray = newArray;
		
	}
	
	public String toString()
	{
		StringBuffer strBuffer = new StringBuffer();
		
		strBuffer.append("[");
		for(int i=0 ;i<=stack1top; i++)
			strBuffer.append(multipleStacksArray[i]+", ");
		
		if(!isStack1Empty())
			strBuffer.delete(strBuffer.length()-2, strBuffer.length());
		
		//strBuffer.append(" **Stack1top= "+stack1top+"** ");		
		//strBuffer.append(" **Stack2top= "+stack2top+"** ");
		strBuffer.append("  **********  ");
		
		for(int i=stack2top; i<multipleStacksArray.length; i++)
			strBuffer.append(multipleStacksArray[i]+", ");
		
		if(!isStack2Empty())
			strBuffer.delete(strBuffer.length()-2, strBuffer.length());
		
		strBuffer.append("]");
		
		return strBuffer.toString();
		
	}
	
	public static void main(String[] args)
	{
		MultipleStacks mStacks = new MultipleStacks();
		
		int choice = 0;
		int element = -1;
		int flag = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for(;;)
		{
			
				System.out.println();
				System.out.println("Enter the choice");
				System.out.println("1.Push(Stack1)");
				System.out.println("2.Pop(Stack1)");
				System.out.println("3.Push(Stack2)");
				System.out.println("4.Pop(Stack2)");
				System.out.println("5.Display Multiple stacks");
				System.out.println("6.Exit");
				
				try{
					choice = Integer.parseInt(reader.readLine());
				}catch(IOException ex){
					System.out.println(ex);
				}
			
			switch(choice)
			{
				case 1: System.out.println("Enter the element to be pushed");
						try{
							element = Integer.parseInt(reader.readLine());
						}catch(IOException ex){
							System.out.println(ex);
						}
						mStacks.push1(element);
						System.out.println(mStacks);
						break;
						
				case 2: try{
							element = mStacks.pop1();
							System.out.println("Popped element = "+element);
						}catch(StackUnderFlowException ex){
							System.out.println(ex);
						}		
						System.out.println(mStacks);
						break;
						
				case 3: System.out.println("Enter the element to be pushed");
						try{
							element = Integer.parseInt(reader.readLine());
						}catch(IOException ex){
							System.out.println(ex);
						}
						mStacks.push2(element);
						System.out.println(mStacks);
						break;
						
				case 4: try{
							element = mStacks.pop2();
							System.out.println("Popped element = "+element);
						}catch(StackUnderFlowException ex){
							System.out.println(ex);
						}	
						System.out.println(mStacks);
						break;
						
				case 5: System.out.println("=============================================");
						System.out.println("Multiple Stacks using arrays");
						System.out.println("=============================================");
						System.out.println(mStacks);
						break;
						
				default:flag = 1;
						break;
				
			}
			if(flag == 1)break;
		}
		
	}
	
}