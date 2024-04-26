package Classes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public abstract class OnlineBilling implements BillingInterface {
	protected int id;
	protected String issueDate;
	protected String dueDate;
	protected double fineAmount;
	protected double totalBill = 0.0;
	protected int customerId;
	protected int installmentType;
	
	public OnlineBilling() {
		
	}

	public OnlineBilling(int id, String issuedate, String duedate,int installment) {
		this.id = id;
		this.issueDate = issuedate;
		this.dueDate = duedate;
		this.installmentType = installment;
	}
	
	
	public int getId() {
		return id;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	
	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
	public boolean checkId(int id) {
		
		if( id == this.id )
			return true;
		return false;
	}
	
	

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	

	public int getInstallmentType() {
		return installmentType;
	}

	@Override
	public String toString() {
		return "\nBillid= " + id + "\nissueDate= " + issueDate + "\ndueDate= " + dueDate
				 + "\ntotalBill= " + totalBill + "\ninstallment months= " + installmentType
				 + "\nFineAmount= " + fineAmount;
	}

	public abstract void calculateTotalBill();
	
	public double afterDueDateFine() {
		
		fineAmount = 0;
		int day, dueday, month,dueM,dueY,year;
		String [] splittedDue = dueDate.split("-");
		dueday = Integer.parseInt( splittedDue[2]);
		dueM =Integer.parseInt( splittedDue[1]);
		dueY = Integer.parseInt( splittedDue[0]);
		
		LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayString = today.format(formatter);

        String [] splittedToday = todayString.split("-");
		day = Integer.parseInt( splittedToday[2]);
		month =Integer.parseInt( splittedToday[1]);
		year = Integer.parseInt( splittedToday[0]);
		
		if(year == dueY) {
			if(month == dueM) {
				if(day > dueday)
					fineAmount = 50;
			}
			if(month > dueM) {
				fineAmount = 75;
			}
				
		}	
		else if(year > dueY)
			fineAmount = 100;	
		     
        return fineAmount;
	}
	
}
