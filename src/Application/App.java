package Application;

import java.io.IOException;

import commands.CheckIn;

public class App {
	
	

	public static void main(String[] args) throws IOException {
		
		CheckIn c = new CheckIn("ch","checkin");
	    c.execute();
		
		
		
      }
}


