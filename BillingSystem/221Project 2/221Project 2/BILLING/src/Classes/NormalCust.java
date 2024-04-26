package Classes;

public class NormalCust extends Customer{
	
	private double salary;
	private int tax = 5;
	

	public NormalCust(String name,String surname,int age,String phoneNumber,int id,double salary, Address address) {
		super( name, surname, age, phoneNumber, id, address);
		this.salary = salary;
	}

	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salaryAmount) {
		this.salary = salaryAmount;
	}
	
		
	public void calculateTax(double salary) {
		
		
		if (salary > 20000)
			tax  = 15;
		else if (salary > 15000)
			tax = 12;
		else if (salary > 10000)
			tax = 9;
		
	}

	@Override
	public String toString() {
		return super.toString() + "salary= " + salary + "\ntax=" + tax + "%"+ "\n";
	}
	
	
}

