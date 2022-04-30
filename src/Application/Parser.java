package Application;

import commands.Capacity;
import commands.CheckIn;
import commands.CheckOut;
import commands.Command;
import commands.DetailsOfVehicle;

public class Parser {

	public static Command CheckCommand(String[] input)
	{
		
		if(input[0].equals("checkin") || input[0].equals("ci")) {
			
			CheckIn c = new CheckIn("ch","checkin");
			
			return c;	
			
		}
		else if(input[0].equals("checkout") || input[0].equals("co"))
		{
			String[] temp = new String[2];
			try {
				
				temp[0] = input[1];
				CheckOut c = new CheckOut(temp ,"co","checkout");
				return c;
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Kindly enter the Vehicle Number");
				return null;
			}
		
			
			
		}
		else if(input[0].equals("capacity") || input[0].equals("cp"))
		{
			Capacity c = new Capacity("cp","capacity");
			return c;
		}
		
		else if(input[0].equals("details") || input[0].equals("dov"))
		{

			DetailsOfVehicle c = new DetailsOfVehicle("dov","details");
			return c;
		}
		else
		{
			return null;
		}
		
		
		
	}
	
	
	
	
	
	
}
