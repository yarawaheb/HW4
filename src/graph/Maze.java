package graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Maze implements GraphInterface<Place>{
	
	private Place Start;
	private Place End;
	private int size;
	private Graph<Place> grph;
	private Place[][] maze;
	
	public Maze(int size, int startx, int starty, int endx, int endy)
	{
		this.size = size;
		
		Start = new Place(startx, starty, size);
		
		End   = new Place(endx, endy, size); 
		
		maze = new Place[size][size];
		
		maze[startx][starty] = Start;
		maze[endx][endy] = End; 
		
	}
	
	public boolean addWall(int x, int y)
	{
		if(maze[x][y] != null)
		{
			return false;
		}
		else
		{
			Place newPlace = new Place(x, y, size);
			maze[x][y] = newPlace;
		}
		
		return true;
	}
	
	@Override 
	public String toString() 
	{
		StringBuilder strBldr = new StringBuilder();
		for (int i = 0; i < size ; i++)
		{
			for (int j = 0; j < size; j++)
			{
				if (maze[i][j] == null)
				{
					strBldr.append(".");
				}
				else if (maze[i][j].equals(End))
				{
					strBldr.append("E");
				}
				else if (maze[i][j].equals(Start))
				{
					strBldr.append("S");
				}
				else
				{
					strBldr.append("@");
				}
			}
			strBldr.append("\n");
		}
		
		return strBldr.toString();
	}
	
	public boolean isSolvable() 
	{
		boolean res = false;
		grph= new Graph<>();
		Set<Place> visited=new HashSet<>();
		for (int i = 0;  i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				if( (maze[i][j] == null) || (maze[i][j].equals(Start)) || (maze[i][j].equals(End)) )
				{
					
					Place p=new Place(i, j, size);
					
					try {
						if(!visited.contains(p)) {
							visited.add(p);
							grph.addVertex(p);
						}
			
							if ( j != size -1)
							{
								if( (maze[i][j+1] == null) || (maze[i][j+1].equals(Start)) || (maze[i][j+1].equals(End)) )
								{
									Place p1=new Place(i, j+1, size);
									if(!visited.contains(p1)) 
									{
										visited.add(p1);
									
										grph.addVertex(p1);
									}
										grph.addEdge(p, p1);
									
								}
							}
								

							if ( i != size -1)
							{
								if( (maze[i+1][j] == null) || (maze[i+1][j].equals(Start)) || (maze[i+1][j].equals(End)) )
								{	
									Place p3=new Place(i+1, j, size);
								
									if(!visited.contains(p3))
									{
										visited.add(p3);
									
										grph.addVertex(p3);
									}
										grph.addEdge(p, p3);
								
								    
							    }
							}
								
					} catch (GraphException e) {
						//TODO Auto-generated catch block
						e.printStackTrace();
					}}
				}
			}
		
		try
		{
			res =  grph.connected(Start, End);
		}
		catch(GraphException e)
		{
			
		}
		
		return res;
	}
	
	
	@Override
	public Collection<Place> neighbours(Place p) 
	{
		Set<Place> visited=new HashSet<>();
		Set<Place> st = new HashSet<>();
		int i,
			j;
		
		i = p.getX();
		
		j = p.getY();
		
		if ( j != size -1)
		{
			if( (maze[i][j+1] == null) || (maze[i][j+1].equals(Start)) || (maze[i][j+1].equals(End)) )
			{
				Place p1=new Place(i, j+1, size);
				if(!visited.contains(p1)) {
					st.add(p1);
					visited.add(p1);
				}
			}
		}

		if ( i != size -1)
		{
			if( (maze[i+1][j] == null) || (maze[i+1][j].equals(Start)) || (maze[i+1][j].equals(End)) )
			{
				Place p3=new Place(i+1, j, size);
				if(!visited.contains(p3)) {
					st.add(p3);
					visited.add(p3);
				}
			}
		}

		return st;	
	}
	
}
