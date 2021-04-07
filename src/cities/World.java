package cities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class World {

   private Map<String, Country> countries=new HashMap<>();
   
   public void addCountry(String name) {
	   countries.put(name, new Country(name));
   }


   public void addCity(String name, String countryName, int population) {
	City c = new City(name, new Country(countryName), population);
	if(countries.get(countryName) ==null){
		throw (new IllegalArgumentException() );
	}
	countries.get(countryName).addCity(c);
   }
   
   public int population() {
	   int sum=0;
	   for (Country c:countries.values())
		   sum+=c.population();
	   return sum;
   }
   
   public List<City> smallCities(int under){
	   List<City> l=new ArrayList<>() ;
	   for (Country c:countries.values())
		   l.addAll(c.smallCities(under));
	   return l;
   }
   
   public String report() {
	   String str="";
	   for (Country c:countries.values()) {
		   str+=c.report();
		   str+="\n";
	   }
	   str+="Total population is "+population()+"\n";

	   return str;
   }

/*public static void main(String[] args) {
	World w = new World();
	w.addCountry("Spain");
	w.addCity("Granada", "Spain", 233764);
	w.addCountry("Brazil");
	w.addCity("Salvador",  "Brazil", 2677000);
	w.addCity("Barcelona", "Spain", 1615000);
	w.addCity("Rio de Janeiro",  "Brazil", 6320000);

	System.out.println(w.report());
	int bound = 2000000;
	System.out.println("Cities with population under " + bound + ":");
	System.out.println(w.smallCities(bound));

}*/
}
