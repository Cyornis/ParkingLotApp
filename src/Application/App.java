package Application;

import java.io.IOException;

import commands.Command;

public class App {
	
	

	public static void main(String[] args) throws IOException {
		
//		CheckIn c = new CheckIn("ch","checkin");
//	    c.execute();
//	    
//	    DetailsOfVehicle d = new DetailsOfVehicle("dov","details");
//	    d.execute();
		
		Command c = Parser.CheckCommand(args);
		
		if(c != null)
		{
			c.execute();
			
		}
		else
		{
			System.out.println("Invalid Command");
		}
		
		
		
	    
	    
	    
		
		
		
      }
	
}


