package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph <V>{
	
	private Set<V> vertices =  new HashSet<V>();
	private Map<V, Set<V>> edges = new HashMap<>();
    private Set<V> visited ;
	
	public void addVertex(V v) throws GraphException
	{
		if(vertices.contains(v))
			throw new GraphException("Already exist");
		vertices.add(v);
	}
	
	
	public void addEdge(V v1, V v2) throws GraphException
	{
		if ( (!vertices.contains(v1) || (!vertices.contains(v2))) )
		{
			throw new GraphException("One of the vrtices not exist");
		}
		else 
		{
			if(hasEdge(v1, v2))
				throw new GraphException("One of the vrtices not exist");
			else
			{
				if (edges.get(v1) == null)
				{
					Set<V> ed = new HashSet<>();
					ed.add(v2);
					edges.put(v1, ed);
				}
				else
					edges.get(v1).add(v2);
				
				if (edges.get(v2) == null)
				{
					Set<V> ed = new HashSet<>();
					ed.add(v1);
					edges.put(v2, ed);
				}
				else
					edges.get(v2).add(v1);
			}
		}
	}
	
	public boolean hasEdge(V v1, V v2)
	{
		if(edges.containsKey(v1))
		{
			return edges.get(v1).contains(v2);
		}
		else if(edges.containsKey(v2))
		{
		    return edges.get(v2).contains(v1);
		}
		else
		{
			return false;
		}
	}
	
	public boolean connected(V v1, V v2) throws GraphException
	{
		if(v1.equals(v2))
			return true;
		if(hasEdge(v1, v2))
			return true;
		if(edges.get(v1)==null && edges.get(v2)==null)
			throw new GraphException("empty");
		if(!vertices.contains(v1)||!vertices.contains(v2))
			throw new GraphException("One of the vrtices not exist");
		
		visited=new HashSet<V>();
		return isConnected(v1,v2);
	}
	private boolean isConnected(V v1,V v2)
	{
		if(hasEdge(v1,v2))
			return true;
		if(visited.contains(v1))
			return false;
		visited.add(v1);
		for(V v:edges.get(v1))
		{
			if(v==v2)
				return true;
			if(isConnected(v,v2))
				return true;
		}
		return false;
	}
	
}
