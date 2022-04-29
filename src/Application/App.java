package Application;

import java.io.IOException;

import commands.CheckIn;
import commands.DetailsOfVehicle;

public class App {
	
	

	public static void main(String[] args) throws IOException {
		
		CheckIn c = new CheckIn("ch","checkin");
	    c.execute();
	    
	    DetailsOfVehicle d = new DetailsOfVehicle("dov","details");
	    d.execute();
	    
	    
	    
		
		
		
      }
}


