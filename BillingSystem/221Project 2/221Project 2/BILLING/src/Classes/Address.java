package Classes;
import java.util.Scanner;

public class Address {
	private int street;
	private int buildingNo;
	private String city;
	
	public Address() {
		
	}
	
	public Address(int street, int buildingNo, String city) {
		this.street = street;
		this.buildingNo = buildingNo;
		this.city = city;
		
	}

	public int getStreet() {
		return street;
	}

	public void setStreet(int street) {
		this.street = street;
	}

	public int getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public void getInput() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter your Street No: ");
		street = scanner.nextInt();
		System.out.println("Please enter your Building No: ");
		buildingNo = scanner.nextInt();
		System.out.println("Please enter your City: ");
		city = scanner.next();
	}
	
	public String toString() {
		return "\nAddress Info\n"
				+ "Street No: " + street
				+ "  Building No: " + buildingNo
				+ "  City: " + city; 
	}
}

