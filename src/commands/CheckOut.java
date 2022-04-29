package commands;

import java.io.IOException;
import java.time.Instant;

import org.json.simple.parser.ParseException;

import Application.Model;
import commons.Utilities;

public class CheckOut extends Command {
	
	double fare;
	String carNo = getArgumentList()[0];

	Model model = new Model("database.json");

	public CheckOut(String[] argumentList, String shortVersion, String longVersion) {

		super(argumentList, shortVersion, longVersion);

	}

	public int hoursCal() {

		int hours;

		try {

			String timeStr;
			timeStr = model.getOwnerEntryTime(carNo);
			Instant instant1 = Instant.parse(timeStr);

			String str = Utilities.intractiveInput(100);
			Instant instant2 = Instant.parse(str);

			hours = Utilities.elapsedTime(instant1, instant2);
			return hours;

		} catch (IOException | ParseException e1) {

			System.out.println("INVALID TIME");
		}
		return 0;
	}

	@Override
	public boolean input() {

		return false;
	}

	@Override
	public boolean process() {
		int hours = hoursCal();

	    fare = getFare(hours);
		
		

		try {

			model.deleteData(carNo);

		} catch (IOException | ParseException e) {

			System.out.println("UNABLE TO DELETE DATA");
		}

		return false;
	}

	@Override
	public boolean output() {
        System.out.println("YOUR FARE IS :" + fare);
		return false;
	}

	public double getFare(int hours) {

		double fare = 0;
		String type = "2-wheeler";
		double rate = 1;

		if (type.equals("2-wheelers")) {

			int temp = hours;
			rate = 0.15;

			if (temp > 12) {

				fare += (temp - 12) * 70;
				temp = temp - 12;

			}

			if (temp > 9) {

				fare += (temp - 9) * 50;
				temp = temp - 9;
			}

			if (temp > 3) {

				fare += (temp - 3) * 35;
				temp = temp - 3;
			}

			if (temp < 3) {

				fare += (temp - 0) * 20;
				temp = temp - 0;
			}

		} else if (type.equals("4-wheeler")) {

			int temp = hours;
			rate = 0.3;

			if (temp > 12) {

				fare += (temp - 12) * 120;
				temp = temp - 12;

			}

			if (temp > 9) {

				fare += (temp - 9) * 100;
				temp = temp - 9;
			}

			if (temp > 3) {

				fare += (temp - 3) * 70;
				temp = temp - 3;
			}

			if (temp < 3) {

				fare += (temp - 0) * 50;
				temp = temp - 0;
			}

		}

		if (hours > 12) {
			fare = fare + (fare * rate);
		}

		return fare;

	}

}
