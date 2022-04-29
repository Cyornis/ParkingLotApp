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
	
	public CheckIn(String shortVersion, String longVersion) {
		super(null ,shortVersion, longVersion);
		owner.setTime(Instant.now());//logEntryTime EntryTime
		
	}
	
	

	@Override
	public boolean input() {
		Scanner cin = new Scanner(System.in);
		String str;
		
		System.out.println("----------------------------------------------------------------------------------------");
		
		System.out.println("enter the owner details");
	    System.out.println("----------------------------------------------------------------------------------------");
	    
	    System.out.println("name: ");
	    String name=Utilities.intractiveInput(100);
	    owner.setName(name);
	    
	    System.out.println("mobile: ");
	    str = Utilities.intractiveInput(10);
	    long mobile = Long.parseLong(str);	    
	    owner.setMobileNo(mobile);
	    
	    System.out.println("bankBalance: ");
	    str=Utilities.intractiveInput(100);
	    double bankBalance = Double.parseDouble(str);
	    owner.setBankBalance(bankBalance);
	    
	    System.out.println("----------------------------------------------------------------------------------------");
	    
	    System.out.println("enter the vehicle details");
	    System.out.println("----------------------------------------------------------------------------------------");
	   
	    System.out.println("type: ");
	    String type=Utilities.intractiveInput(100);
	    owner.getVehicle().setType(type);
	    
	    System.out.println("carNo: ");
	    String carNo=Utilities.intractiveInput(100);
	    owner.getVehicle().setCarNo(carNo);
	    
	    System.out.println("model: ");
	    String model=Utilities.intractiveInput(100);
	    owner.getVehicle().setModel(model);
	    
	    System.out.println("manufacturer: ");
	    String manufacturer=Utilities.intractiveInput(100);
	    owner.getVehicle().setManufacturer(manufacturer);
	    
	    
	    return false;
	}

	@Override
	public boolean process() {
		
		Model model = new Model("database.json");
		
		try {
			model.addData(owner);
			
		} catch (IOException | ParseException e) {
			
			System.out.println("FAILED TO ADD DATA");
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

























