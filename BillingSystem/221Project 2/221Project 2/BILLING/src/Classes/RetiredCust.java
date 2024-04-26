package Classes;

public class RetiredCust extends Customer {
	
    private double pension;
    private int discountAmount;
    

    public RetiredCust(String name,String surname,int age,String phoneNumber,int id,double salary, Address address) {
    	super( name, surname, age, phoneNumber, id, address);
		this.pension = salary;
    }

    public double getPension() {
        return pension;
    }

    public void setPension(double pension) {
        this.pension = pension;
    }



    public void calculateDiscount(double pension) {
    	
    	discountAmount = 5;

		if (pension > 9000)
			discountAmount  = 15;
		else if (pension > 7500)
			discountAmount = 25;
		else if (pension > 6000)
			discountAmount = 35;		
    }

	@Override
	public String toString() {
		return super.toString() +"\npension= " + pension + "\ndiscount Amount= " + discountAmount +"%" + "\n";
	}

    
}
