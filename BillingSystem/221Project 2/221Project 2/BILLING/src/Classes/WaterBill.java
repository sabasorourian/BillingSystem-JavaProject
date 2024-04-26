package Classes;
import java.util.Scanner;

public class WaterBill extends OnlineBilling{

	@Override
	public String toString() {
		return "\nWaterBill info\n" + super.toString() + "\nusedWater= " + usedWater + "\n";
	}

	private double usedWater;
	private final static int UNIT_PRICE_WATER=3;
	
	public WaterBill() {
	
	}
	public WaterBill(int id, String issuedate, String duedate, double usedWater,int installment) {
		super(id, issuedate, duedate,installment);
		this.usedWater = usedWater;
		
	}
	public double getUsedWater() {
		return usedWater;
	}
	public void setUsedWater(double usedWater) {
		this.usedWater = usedWater;
	}
	public static int getUnitPriceWater() {
		return UNIT_PRICE_WATER;
	}

	@Override
	public void calculateTotalBill() {
		double basefee = 55;
		
		if (usedWater > 750)
			basefee *= 2.5;
		else if (usedWater > 620)
			basefee *= 1.75;
		else if (usedWater > 590)
			basefee *= 1.5;
		
		this.totalBill = basefee + fineAmount;
		
	}
	
	@Override
	public void addTax() {
		double tax;
		tax = 0.05 * totalBill;
		totalBill += tax;
		
	}
	
}
