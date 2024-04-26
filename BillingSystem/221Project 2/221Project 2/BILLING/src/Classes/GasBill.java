package Classes;
import java.util.Scanner;

public class GasBill extends OnlineBilling{
	private double usedGas;
	private static final int UNIT_PRICE_GAS = 1;
	

	public GasBill() {
		
	}


	public GasBill(int id, String issuedate, String duedate, double usedGas,int installment) {
		super(id, issuedate, duedate,installment);
		this.usedGas=usedGas;
		
	}


	public double getUsedGas() {
		return usedGas;
	}


	public void setUsedGas(double usedGas) {
		this.usedGas = usedGas;
	}


	public static int getUnitPriceGas() {
		return UNIT_PRICE_GAS;
	}
	

	@Override
	public String toString() {
		return "Gas Bill Info: \n"+super.toString()+ "\nusedGas: " + usedGas + "\n";
	}


	@Override
	public void calculateTotalBill() {
		
		double basefee = 55;
		
		if (usedGas > 1500)
			basefee *= 2.5;
		else if (usedGas > 1000)
			basefee *= 1.75;
		else if (usedGas > 700)
			basefee *= 1.5;
		
		this.totalBill = basefee + fineAmount;
		
	}


	@Override
	public void addTax() {
		double tax;
		tax = 0.04 * totalBill;
		totalBill += tax;
		
	}
	
}
