package graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ConnectionChecker <V>{
	
	private GraphInterface<V> g;
	private Set<V> visited =  new HashSet<V>();
	public ConnectionChecker(GraphInterface<V> g) 
	{
		this.g = g;
	}

	public boolean check(V v1, V v2) 
	{
		if(v1.equals(v2)) {
			visited.clear();
			  return true;
		}
		visited.add(v1);
		Collection<V> st =  new HashSet<V>();
		st = g.neighbours(v1);
		
		for(V v : st)
		{
		   if ((!visited.contains(v)) && (v != null))
		   {
			    visited.add(v);
			    return check(v, v2);
		   }
		}
		visited.clear();
		return false;
	}
	
	/*public static void main(String[] args) 
	{
		Maze m = new Maze(4, 0, 0, 3, 3);
		m.addWall(1, 1);
		m.addWall(3, 1);
		m.addWall(0, 1);
		m.addWall(2, 3);
		m.addWall(2, 3);
		m.addWall(1, 3);
		System.out.println(m.toString());
		ConnectionChecker<Place> cc = new ConnectionChecker<>(m);
		System.out.println(cc.check(new Place(0,0,4), new Place(3,3,4)));

	}*/
}
