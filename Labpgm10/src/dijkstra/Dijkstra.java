package dijkstra;

import java.io.*;

public class Dijkstra
{
	private boolean[] visited;
	private int[] shortestPaths;
	private int[] parent;
	private int[][]distanceMatrix;
	private int n;
	private int count;
	
	public Dijkstra()
	{
		this.count = 0;		
	}
	
	public void initialize()
	{
		shortestPaths = new int[n];
		parent = new int[n];
		distanceMatrix = new int[n][];
		visited = new boolean[n];
		
		for(int i=0;i<n;i++)
			distanceMatrix[i] = new int[n];
		
		for(int i=0;i<n;i++)
		{
			visited[i] = false;
			parent[i] = i;
		}
	}
	
	public void set(int n)
	{
		this.n = n;
	}
	
	public void read()
	{
		System.out.println("Enter the number of nodes");
		
		try{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		this.set(n);
		
		this.initialize();
		
		System.out.println("Enter the distance matrix");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				distanceMatrix[i][j] = Integer.parseInt(reader.readLine());
		}catch(IOException ex){
			System.out.println(ex);
		}
		
	}

	public int findNodeWithShortestPath()
	{
		int min = 999;
		int minNode = 0;
		for(int i=0;i<n;i++)
			if(visited[i]!=true && shortestPaths[i] < min)
			{
				min = shortestPaths[i];
				minNode = i;
			}
			
			return minNode;
	}
	
	public void dijkstra(int source)
	{
		// visit the source node
		visited[source] = true;
		
		// initialize the shortest paths of the adjacent nodes
		// as the path from source 
		// and update the parent of those nodes to be the source
		for(int i=0;i<n;i++)			
		{
			shortestPaths[i] = distanceMatrix[source][i];
			parent[i] = source;
		}
		
		this.count = 0;
		// repeat until all nodes are visited
		while(count<n)
		{
			// Among the nodes that are not visited
			// find the node with shortest path
				int u = findNodeWithShortestPath();
				
			// visit the node
				visited[u] = true;
				count++;
				
			// update the shortestPaths of the remaining nodes that are not visited
			// d[v] = min(d[v], d[u] + distanceMatrix[u][v]);
			for(int v=0;v<n;v++)
			{
				if(visited[v] != true)
				{
					// shortestPaths[v] = min(shortestPaths[v], shortestPaths[u] + distanceMatrix[u][v]);
					
						
					if((shortestPaths[u] + distanceMatrix[u][v]) < shortestPaths[v])
					{
						shortestPaths[v] = shortestPaths[u] + distanceMatrix[u][v];
						parent[v] = u;
					}
				}
			}
		}
		
	}	
	
	public void printShortestPaths(int source)
	{
		System.out.println("============================================================");
		System.out.println("Shortest distance of all the nodes from source node "+source);
		System.out.println("============================================================");
		for(int i=0;i<n;i++)
		{
			System.out.print("Shortest distance of node "+i+" = "+shortestPaths[i]+" ");
			
			System.out.print("Shortest path of node "+i+" : ");
			
			int v = i;
			while(parent[v]!=v && (v != source))
			{
				System.out.print(" "+parent[v]+"-->"+v+" ");
				v = parent[v];
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		Dijkstra d = new Dijkstra();
		
		d.read();

		d.dijkstra(0);
	
		d.printShortestPaths(0);
	}
}