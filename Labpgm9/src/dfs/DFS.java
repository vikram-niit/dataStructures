package dfs;

import java.io.*;
import dfs.linearQueue.*;

public class DFS{
	
	private boolean[] visited;
	private int n;
	private int[][] adjacencyList;
	private StringBuffer strBuffer;
	private String filename;
	
	public DFS(int n)
	{
		this.n = n;
		adjacencyList = new int[n][];
		strBuffer = new StringBuffer();
		visited = new boolean[n];
		
		for(int i=0;i<n;i++)
			adjacencyList[i] = null;
		
		for(int i=0;i<n;i++)
			visited[i] = false;
		
	}
	
	public void initialize()
	{
		for(int i=0;i<n;i++)
			visited[i] = false;
	}
	
	public StringBuffer getStringBuffer()
	{
		return this.strBuffer;
	}
	
	public int[][] getAdjacencyList()
	{
		return this.adjacencyList;
	}
	
	public void dfs(int node)
	{
		// mark the node as visited and add to the list of visited nodes
		visited[node] =true;		
		strBuffer.append(node+"  ");	
		
		// if the node has children call dfs recursively
		// for each of its child nodes
		if(adjacencyList[node] != null)
		{
			for(int i:adjacencyList[node])
			{
				if(visited[i] != true)
				dfs(i);
			}			
		}		
	}
	
	public void bfs(int node)
	{		
		LinearQueue queue = new LinearQueue();
		
		this.strBuffer = new StringBuffer();
		
		// enqueue the first node
		queue.enqueue(node);
	
		// while queue is not empty
		while(!queue.isEmpty())
		{
			try{
			// dequeue the front node from the queue	
			node = queue.dequeue();
			
			}catch(QueueEmptyException ex){
				System.out.println(ex);
			}
			
			if(!visited[node])
			{
				// mark the node as visited
				visited[node] = true;
				// add to the list of nodes traversed
				strBuffer.append(node+"  ");
				
				// if the node has children
				if(adjacencyList[node] != null)
				{
					// enqueue the adjacent nodes into the queue
					for(int x:adjacencyList[node])
						queue.enqueue(x);
				}
			}
			
		}
		
		
	}
	public void readAdjacencyListFromFile(String filename)
	{
		try{
		FileInputStream fin = new FileInputStream(filename);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
		
		for(int i=0;i<n;i++)
		{
		String str = reader.readLine();
		// parse the string
			System.out.println("String="+str);
			
			if(str!=null)
			str = str.trim();
			
			if(str != null && !str.equals("") && !str.contains("\n"))
			{	
				// retrieve the node
				int node = Integer.parseInt(str.split(":")[0]);
				// retrieve the nodes adjacent to the node
				String[] nodes = str.split(":")[1].split(",");
				
				int[] x = new int[nodes.length];
				
				for(int j=0;j<nodes.length;j++)
					x[j] = Integer.parseInt(nodes[j]);
				
				adjacencyList[node] = x;
			}
		}
		}catch(FileNotFoundException ex){
			System.out.println(ex);
		}catch(IOException ex){
			System.out.println(ex);
		}
	}
	
	public static void main(String[] args)
	{
		
		String filename = "E:/nitk/semester1/dataStructures/Labpgms/Labpgm9/src/adjacencyList.txt";
		
		DFS dfs = new DFS(10);		
		
		
		// Read the adjacency list from file 
		dfs.readAdjacencyListFromFile(filename);
		
		// call dfs from the root node		
		dfs.dfs(0);
		
		System.out.println("==================================================");
		System.out.println("DFS traversal : "+dfs.getStringBuffer().toString());
		System.out.println("==================================================");
		
		dfs.initialize();
		dfs.bfs(0);
		
		System.out.println("==================================================");
		System.out.println("BFS traversal : "+dfs.getStringBuffer().toString());
		System.out.println("==================================================");
	}
	
}