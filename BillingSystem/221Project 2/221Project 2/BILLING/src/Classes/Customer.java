package Classes;

public  abstract class Customer {

	private String name;
	private String lastname;
	private int id;
	private Address cusAddress;
	private int age;
	private String phoneNumber;
	
	
	public Customer(){
		cusAddress = new Address();
	}
	
	public Customer(String name,String surname,int age,String phoneNumber,int id, Address address) {
		this.name = name;
		this.lastname = surname;
		this.id = id;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.cusAddress = address;
	} 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getCusAddress() {
		return cusAddress;
	}

	public void setCusAddress(Address cusAddress) {
		this.cusAddress = cusAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString(){
		return "\nName: " +  name + " Lastname: " + lastname
				+"\nId: " + id
				+ "\nAge: " + age
				+ "\nPhone Number: " + phoneNumber
				+ cusAddress.toString() + "\n";
	}

	public boolean checkId(int idOfCust) {
		
		if( idOfCust == this.id )
			return true;
		
		return false;
	}
	
}