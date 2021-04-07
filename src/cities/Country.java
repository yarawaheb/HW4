package cities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Country implements Comparable<Country>{
	private Set<City> cities;
	private String name;
	private List<City> l;
	private List<City> sortl;
	public Country(String name) {
		this.name=name;
		l=new ArrayList<>();
		
		cities=new HashSet<>() {
		};
	}
	

	public void addCity(City city) {
		boolean flag=false;
		if(!city.getCountry().name.equals(this.name))
			throw new IllegalArgumentException();
		//if(!cities.contains(city))///TO ASK!!
		for(City c:cities)
			if(c.getName()==city.getName())
				flag=true;
		if(!flag)
		    cities.add(city);
		
	}
	
	public int population() {
		int populationNumber=0;
		for(City c:cities)
			populationNumber+=c.getPopulation();
		return populationNumber;
	}
	@Override
	public String toString() {
		return name;
	}

	
	public List<City> smallCities(int under){
		for(City c:cities) {
			if(c.getPopulation()<under)
				l.add(c);
		}
		
		Collections.sort(l);
		return l;
	}
	
	public String report() {
		sortl=new ArrayList<>();
		sortl.addAll(cities);
		Collections.sort(sortl);
		String s="";
		s+=name+"("+population()+") : ";
		for(City c:sortl)
			s+=c.getName()+"("+c.getPopulation()+"), ";
		s=s.substring(0, s.length()-2);
		return s;
	}

	@Override
	public int compareTo(Country o) {
		return this.name.compareTo(o.name);
	}
	@Override
	public boolean equals(Object o) {
	   return this.name==((Country) o).name;
	}

}
