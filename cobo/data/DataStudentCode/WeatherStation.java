/*
 Represents information about a NWS weather station
*/
import core.data.*;
import java.util.Scanner;

public class WeatherStation {
   private String name;
   private String id;
   private String state;
   private double lat;
   private double lng;
   
   WeatherStation(String name, String id, String state, double lat, double lng) {
      this.name = name;
      this.id = id;
      this.lat = lat;
      this.lng = lng;
      this.state = state;   
   }
   
   /* Produce the id of this station */
   public String getId() { 
      return id;
   }

   /* Get the Latitude */
   public double getLat() {
      return lat;
   }
   
   /* Produce the name of this station */
   public String getName() { 
      return name;
   }
   
   /* Determine if this weather station is located in the given state */
   public boolean isLocatedInState(String st) {
      return this.state.equals(st);
   }

   public static void main( String[] args ){
   
      DataSource ds = DataSource.connect("https://weather.gov/xml/current_obs/index.xml").load();
      WeatherStation[] allstns = ds.fetchArray("WeatherStation", "station/station_name",
		                               "station/station_id", "station/state",
					       "station/latitude", "station/longitude");
      System.out.println( "Total stations: " + allstns.length );
      
      Scanner sc = new Scanner( System.in );
      String code = sc.next();
      
      int counter = 0;
      for( WeatherStation st: allstns ){
      	
	 if( st.isLocatedInState(code ) ){
	 	counter++;
	 }
      }
      System.out.println(counter); 
   
   }


}
