package commands;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import Application.Model;

public class DetailsOfVehicle extends Command {

	Model model = new Model("database.json");
	JSONArray ownerList;

	public DetailsOfVehicle(String shortVersion, String longVersion) {
		super(null, shortVersion, longVersion);

	}

	@Override
	public boolean input() {

		return true;
	}

	@Override
	public boolean process() {

			try {
				ownerList = model.readOwnerListFromDb();
			} catch (IOException e) {
				System.out.println("UNABLE TO GET OWNERLIST");
			}



		return true;
	}

	@Override
	public boolean output() {
		
		
		System.out.println("-------------------------------------------------------------------------");

		System.out.printf("%20s %20s\n", "OWNER NAME", "VEHICLE NUMBER");

		System.out.println("---------------------------------------------------------------------------");
		
		for (int i = 0; i < ownerList.size(); i++) {

			JSONObject ownerJson = (JSONObject) ownerList.get(i);
			JSONObject vehicleJson = (JSONObject) ownerJson.get("vehicle");
			String vehicle = (String)vehicleJson.get("carNo");
			String ownerName = (String) ownerJson.get("name") ;
			
			System.out.printf("%20s %20s\n", ownerName, vehicle);

		}
		
		return true;
	}

}
























