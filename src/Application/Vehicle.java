package Application;

public class Vehicle {

	private String type;
	private String model;
	private String carNo;
	private String manufacturer;

	public double getFare() {
      return 0.0;
	}

	// can be shifted to abstract class
	public void displayDetails() {
		
		System.out.println("--------------------------------------------------------------------");
		
		System.out.println("VEHICLE DETAILS");
		
		System.out.println("--------------------------------------------------------------------");
		
        System.out.println("type: "+this.type);
        System.out.println("model: "+this.model);
        System.out.println("carNo: "+this.carNo);
        System.out.println("manufacturer: "+this.manufacturer);
        
        
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

}
