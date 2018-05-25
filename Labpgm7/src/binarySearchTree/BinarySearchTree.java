package binarySearchTree;

import java.io.*;

public class BinarySearchTree
{
	private BSTNode root;	
	
	private StringBuffer strBuffer;
	private int position;
	private int level;
	
	public BinarySearchTree()
	{
		root = null;	
		strBuffer = new StringBuffer();
		position = -1;
		level = 0;
	}
	
	public BSTNode getRoot()
	{
		return this.root;
	}
	
	public void setRoot(BSTNode root)
	{
		this.root = root;
	}
	
	public int getLevel()
	{
		return this.level;
	}
	
	public void setLevel(int level)
	{
		this.level = level;
	}
	
	public BSTNode insert(BSTNode root, int key)
	{	
		if(root != null)
		{	if(key < root.getData())
					root.setLeft(insert(root.getLeft(), key));
			else if(key > root.getData())
					root.setRight(insert(root.getRight(), key));
		}
		else
			root = new BSTNode(key);
		
		return root;
		
	}
	
	public BSTNode delete(BSTNode root, int key) throws NoSuchElementException
	{
		if(root == null)
		{
			System.out.println("key does not exist");
			throw new NoSuchElementException();
		}
		
		if(key < root.getData())
			root.setLeft(delete(root.getLeft(), key));
		else if(key > root.getData())
			root.setRight(delete(root.getRight(), key));
		else
		//key found
		{	
			// both left subtree and right subtree exists
			if(root.getLeft() != null && root.getRight() !=null)
			{
				// find the largest node in the left subtree(inorder predecessor)
				BSTNode inorderPredecessor = findMax(root.getLeft());
				// set root's value to that of that of the inorder predecessor
				root.setData(inorderPredecessor.getData());
				
				System.out.println("findMax(root.getLeft()="+inorderPredecessor.getData());
				
				// delete the inorder predecessor
				root.setLeft(delete(root.getLeft(), inorderPredecessor.getData()));
			}
			
			// only one child or both children null
			// if left child is null return right subtree
			else if(root.getLeft() == null)		
				root = root.getRight();
			
			// else if right child is null return left subtree
			else if(root.getRight() == null)			
				root = root.getLeft();
			
			
		}
		
		return root;
	}
	
	public int search(BSTNode root, int key)
	{	
		if(root != null)
		{
			if(key < root.getData())
			{
				level++;
				position = 2 * position + 1;
				return search(root.getLeft(), key);
			}
			else if(key > root.getData())
			{
				level++;
				position = 2 * position + 2;
				return search(root.getRight(), key);
			}
			else
			//key found
				return level;
		}
		else
		// key not found
		{
			position = -1;
			return position;
		}
	}
	
	public BSTNode findMax(BSTNode root)
	{
		if(root.getRight() != null)
			root = findMax(root.getRight());
	
		return root;		
	}
	public void display(BSTNode root, int level)
	{
		// Perform reverse inorder traversal
		if(root != null)
		{
			display(root.getRight(), level + 1);
			// Print the root node at level l at 'l' positions away from the screen
			for(int i=0;i<level;i++)
				strBuffer.append("   ");
			//System.out.print("   ");
			
			strBuffer.append(root.getData());
			//System.out.println(root.getData());
			strBuffer.append("\n");
			//System.out.println();
			
			display(root.getLeft(), level + 1);			
		}
	}
	
	public String toString()
	{
		System.out.println("=====================================");
		System.out.println("Binary Search Tree printed sideways");
		System.out.println("=====================================");
		
		strBuffer = new StringBuffer();
		
		display(this.root, 0);
		
		return strBuffer.toString();
		
	}
	
	public static void main(String[] args)
	{
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		
		int choice = 0;
		int element = 0;
		int flag = 0;
		int key = 0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	
		
		for(;;)
		{
			System.out.println("Enter the choice");
			System.out.println("1.Insert");
			System.out.println("2.Delete");
			System.out.println("3.Search");
			System.out.println("4.Display");
			System.out.println("5.Exit");
			
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
							int position = binarySearchTree.search(binarySearchTree.getRoot(), element);
		
							if(position != -1)							
								System.out.println("Key already exists");															
							else
							binarySearchTree.setRoot(binarySearchTree.insert(binarySearchTree.getRoot(), element));
						
							System.out.println(binarySearchTree);
							break;
					case 2: System.out.println("Enter the element to be deleted");
							try{
								element = Integer.parseInt(reader.readLine());
							}catch(IOException ex){
								System.out.println(ex);
							}	

							try{
								binarySearchTree.setRoot(binarySearchTree.delete(binarySearchTree.getRoot(), element));
							}catch(NoSuchElementException ex){
								System.out.println(ex);
							}	
							
							System.out.println(binarySearchTree);
							break;
					case 3: System.out.println("Enter the key to be searched");
							try{
								key = Integer.parseInt(reader.readLine());
							}catch(IOException ex){
								System.out.println(ex);
							}
							binarySearchTree.setLevel(0);
							position = binarySearchTree.search(binarySearchTree.getRoot(), key);
							
							if(position != -1)
								System.out.println("Key found at level "+position);
							else
								System.out.println("Key not found");
							System.out.println(binarySearchTree);
							break;
					case 4: System.out.println(binarySearchTree);
							break;
					default: flag = 1;
							 break;
				}
				if(flag == 1)break;
		}	
	}	
}
