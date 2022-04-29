package Application;

import java.time.LocalDateTime;

public class Owner  {
	
	private String name;
	private long mobileNo;
	private double bankBalance;
    public LocalDateTime time;
	
	
    public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	private Vehicle vehicle = new Vehicle(); //reference of Vehicle is created
	
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public double getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(double bankBalance) {
		this.bankBalance = bankBalance;
	}

	public double getFare() {
		return 0.0;
	}
	
	

	public void displayDetails() {
		
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("DETAILS OF OWNER");
		System.out.println("------------------------------------------------------------------------------------------------------");
		
        System.out.println("name: "+this.name);
        System.out.println("mobile number: "+this.mobileNo);
        System.out.println("bank balance: "+this.bankBalance);
        
        
        
	}

	public boolean canPay() {
		return false;

	}
}































