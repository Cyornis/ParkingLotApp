package commands;

import java.io.IOException;
import java.time.Instant;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import Application.Model;
import Application.Owner;
import commons.Utilities;

public class CheckIn extends Command {

	Owner owner = new Owner();
	Model model = new Model("database.json");
	
	public CheckIn(String shortVersion, String longVersion) {
		super(null ,shortVersion, longVersion);
		owner.setTime(Instant.now());//logEntryTime EntryTime
		
	}
	
	

	@Override
	public boolean input()  {
		
		int noOfVehicles;
		
		try {
			noOfVehicles = model.readOwnerListFromDb().size();
			if(noOfVehicles == 40)
			{
				System.exit(1);
			}
				
			
		} catch (IOException e1) {
			
			System.out.println("unable to get number of vehicles");
			
		}
		
	
			
		Scanner cin = new Scanner(System.in);
		String str;
		
		System.out.println("----------------------------------------------------------------------------------------");
		
		System.out.println("enter the owner details");
	    System.out.println("----------------------------------------------------------------------------------------");
	    
	    System.out.println("name: ");
	    String name=Utilities.intractiveInput(100);
	    owner.setName(name);
	    
	    System.out.println("mobile: ");	    
	    long mobile;
	    
	    while(true)
	    {	
	    	try {
	    		
	    		str = Utilities.intractiveInput(10);
	    		mobile = Long.parseLong(str);	
	    		break;
	    	
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("numeric input required");

	    	}
	    }
	    
	    
	    
	    owner.setMobileNo(mobile);
	    
	    System.out.println("bankBalance: ");
	    double bankBalance;   
	    while(true)
	    {	
	    	try {
	    		
	    		str = Utilities.intractiveInput(10);
	    		bankBalance = Double.parseDouble(str);
	    		break;
	    	
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("numeric input required");

	    	}
	    }
	    
	    
	    owner.setBankBalance(bankBalance);
	    
	    System.out.println("----------------------------------------------------------------------------------------");
	    
	    System.out.println("enter the vehicle details");
	    System.out.println("----------------------------------------------------------------------------------------");
	   
	    System.out.println("type (2-wheeler / 4-wheeler): ");
	    String type;
	    while(true)
	    {
	    	type=Utilities.intractiveInput(100);
	    	if(type.equals("2-wheeler") || type.equals("2-wheeler") )
	    	{
	    		break;
	    	}
	    	else
	    	{
	    		System.out.println("Enter either '2-wheeler or '4-wheeler '");
	    	}
	    }
	    
	    owner.getVehicle().setType(type);
	    
	    System.out.println("carNo: ");
	    String carNo;
	    
	    while(true) {
	    	
	    	
	    	carNo=Utilities.intractiveInput(100);
	    	
	    		int test;
				try {
						test = model.searchData(carNo);
						if(test != -1)
				    	{
				    		System.out.println("the given car already exists");
				    		System.out.println("Kindly, enter again");
				    	}
				    	else
				    	{
				    		owner.getVehicle().setCarNo(carNo);
				    		break;
				    	}
					
				} 
					catch (IOException | ParseException e) {
					
					e.printStackTrace();
				}
	    	
	    	
	    }
	    
	    System.out.println("model: ");
	    String model=Utilities.intractiveInput(100);
	    owner.getVehicle().setModel(model);
	    
	    System.out.println("manufacturer: ");
	    String manufacturer=Utilities.intractiveInput(100);
	    owner.getVehicle().setManufacturer(manufacturer);
	    
	    
	    return true;
	}

	@Override
	public boolean process() {
		
		
		
		try {
			model.addData(owner);
			
		} catch (IOException | ParseException e) {
			
			
			System.out.println("FAILED TO ADD DATA");
			return false;
		} 
	    return true;
	}

	@Override
	public boolean output() {
		
		owner.displayDetails();
		owner.getVehicle().displayDetails();
		
		return false;
	}

}

























