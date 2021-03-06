package Application;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Model {
	private String db;

	public Model(String db) {
		super();
		this.db = db;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	@SuppressWarnings("unchecked")
	
	//this adds the detail of owner 
	
	public void addData(Owner owner) throws IOException, ParseException {
		JSONObject ownerJson = new JSONObject();
		ownerJson.put("name", owner.getName());
		ownerJson.put("mobileNo", owner.getMobileNo());// check,long
		ownerJson.put("bankBalance", owner.getBankBalance());// double

		ownerJson.put("time", owner.getTime().toString());

		JSONObject vehicleJson = new JSONObject();
		vehicleJson.put("type", owner.getVehicle().getType());
		vehicleJson.put("model", owner.getVehicle().getModel());
		vehicleJson.put("carNo", owner.getVehicle().getCarNo());
		vehicleJson.put("manufacturer", owner.getVehicle().getManufacturer());

		ownerJson.put("vehicle", vehicleJson); // here we are substituting vehicle info in owner object

		JSONArray ownerList = readOwnerListFromDb();

		ownerList.add(ownerJson);

		writeOwnerListToDb(ownerList);

	}

	//this deletes the data from database 
	
	public void deleteData(String carNo) throws IOException, ParseException {

		JSONArray ownerList = readOwnerListFromDb();

		int i = searchData(carNo);
		ownerList.remove(i);// if car does not match
		writeOwnerListToDb(ownerList);

	}
	//this searches the data taken from the databases 
	public int searchData(String carNo) throws IOException, ParseException {

		JSONArray ownerList = readOwnerListFromDb();

		for (int i = 0; i < ownerList.size(); i++) {

			JSONObject ownerJson = (JSONObject) ownerList.get(i);
			JSONObject vehicleJson = (JSONObject) ownerJson.get("vehicle");

			if (vehicleJson.get("carNo").equals(carNo)) {
				return i;
			}

		}
		return -1;

	}
	
	//this retrieves the owner list from the database 

	public JSONArray readOwnerListFromDb() throws IOException  {
		JSONParser jsonParser = new JSONParser();
		JSONArray ownerList;
		FileReader file = new FileReader(db);

			
			try {
				ownerList = (JSONArray) jsonParser.parse(file);
			} catch (IOException | ParseException e) {
				
				ownerList = new JSONArray();
			}
			
	
		
	
		
		return ownerList;
	}
	//this writes the owner list to the database 
	public void writeOwnerListToDb(JSONArray ownerList) {
		
		try (FileWriter file1 = new FileWriter(db)) {

			file1.write(ownerList.toJSONString());
			file1.flush();

		} catch (IOException e) {
			System.out.println("error found while reading the file");
		}

	}
	
	//this tries to get the owner entry time 
	public String getOwnerEntryTime(String carNo) throws IOException, ParseException {

		int index = searchData(carNo);
		
		if(index == -1)
		{
			return null;
		}

		JSONArray ownerList = readOwnerListFromDb();
		JSONObject ownerJson = (JSONObject) ownerList.get(index);
		String time = (String) ownerJson.get("time");
		
		
		return time;

	}

}
