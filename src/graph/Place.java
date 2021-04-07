package graph;

public class Place {
	
	private int x; 
	private int y; 
	
	public Place(int x, int y, int bound)
	{
		if ( ( ( x > bound -1) || (x < 0) )|| 
				( ( y > bound -1) || (y < 0) ) )
		{
			throw new IllegalArgumentException();
		}
		
		this.x = x;
		
		this.y = y;
		
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	@Override 
	public int hashCode()
	{
		int hash = 7;
	    hash = 31 * Integer.hashCode(x) + hash;
	    hash = 31 * hash + Integer.hashCode(y);
	    return hash;

	}
	
	@Override
	public boolean equals(Object obj)
	{
		Place other = (Place)obj;
		
		return ((this.x == other.getX()) && (this.y == other.getY()));
	}
	
	@Override
	public String toString()
	{
		return "[" + x +"," + y + "]";
	}

}
