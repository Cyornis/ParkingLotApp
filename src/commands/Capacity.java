package commands;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import Application.Model;

public class Capacity extends Command {

	int noOfVehicles;

	public Capacity(String shortVersion, String longVersion) {
		super(null, shortVersion, longVersion);
	}

	@Override
	public boolean input() {

		return true;
	}

	@Override
	public boolean process() {

		try {
			Model model = new Model("database.json");

			noOfVehicles = model.readOwnerListFromDb().size();

		} catch (Exception e) {
			System.out.println("INVALID OWNER");
		}

		return false;
	}

	@Override
	public boolean output() {

		System.out.println("NUMBER OF VEHICLES: " + noOfVehicles);
		return false;
	}

}
