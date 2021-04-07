package cities;

public class City implements Comparable<City>{
	private String name;
	private Country country;
	private int population;
	public City(String name, Country country, int population) {
		this.name = name;
		this.country = country;
		this.population = population;
	}
	public String getName() {
		return name;
	}
	public Country getCountry() {
		return country;
	}
	public int getPopulation() {
		return population;
	}

	@Override
	public String toString() {
		return getName()+" (of "+getCountry()+")";
	}
	@Override
	public int compareTo(City o) {
		return this.getName().compareTo(o.getName());
	}
	@Override
	public boolean equals(Object o) {
		   return this.getName()==((City) o).getName();
		}
	

}
