package Classes;
import java.util.Scanner;

public class ElectricityBill extends OnlineBilling{
	
	private double usedElectricity;
	
	private static final int UNIT_PRICE_ELECTRICITY = 2;

	public ElectricityBill() {
		
	}

	public ElectricityBill(int id, String issuedate, String duedate, double usedElectricity,int installment){
		super(id, issuedate, duedate,installment);
		this.usedElectricity=usedElectricity;
	}

	public double getUsedElectricity() {
		return usedElectricity;
	}

	public void setUsedElectricity(double usedElectricity) {
		this.usedElectricity = usedElectricity;
	}

	public static int getUnitPriceElectricity() {
		return UNIT_PRICE_ELECTRICITY;
	}
	

	@Override
	public String toString() {
		return "Electricity Bill Info\n" + super.toString()+ "\nusedElectricity: " + usedElectricity + "\n";
	}

	@Override
	public void calculateTotalBill() {
		
		
		double basefee = 150;
		
		if (usedElectricity > 1500)
			basefee += 175;
		else if (usedElectricity > 1000)
			basefee += 150;
		else if (usedElectricity > 700)
			basefee += 90;
		
		this.totalBill = basefee + fineAmount;
		
	}

	@Override
	public void addTax() {
		
		double tax;
		tax = 0.06 * totalBill;
		totalBill += tax;
		
	}
		
}
