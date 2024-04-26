package Classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineBillingSys {

	private static ArrayList<OnlineBilling> billArr = new ArrayList<>();
	

//------------------------------------------------------------------------------------------	
	public static boolean addBills(String type,int id,String issuedate,String duedate,double usedAmount,int installment){
		
		OnlineBilling billObj = null;
		
		if (searchBills(id) == null) {
			if(type.equalsIgnoreCase("water")) 
				billObj = new WaterBill( id,  issuedate,  duedate,  usedAmount,installment);	
			else if(type.equalsIgnoreCase("gas"))
				billObj = new GasBill( id,  issuedate,  duedate,  usedAmount,installment);
			else if(type.equalsIgnoreCase("electricity"))
				billObj = new ElectricityBill( id, issuedate, duedate, usedAmount,installment);
			
			billObj.calculateTotalBill();
			billObj.addTax();
			billArr.add(billObj);	
			return true;
		}
		else {
			return false;
		}			
					
	}
//-------------------------------------------------------------------------------------------	
	
	public static OnlineBilling searchBills(int idOfBills) {
		
		OnlineBilling ob = null;
		for (OnlineBilling bills:billArr) {
			
			if(bills.checkId(idOfBills))
				return bills;
		}
		return ob;
	}

	//---------------------------------------------------------------------------------------------------
	
	public static boolean deleteBill(int id) {
		OnlineBilling bill = searchBills(id);
		if(bill == null)
			return false;
		else {
			billArr.remove(bill);
			return true;
		}
		
	}
	
//--------------------------------------------------------------------------------------------------------------
	public static String listAllBills() {
		String out = "";
		for (OnlineBilling bills:billArr) {
			 
			out += bills.toString() + "\n";
		}
		return out;
	}
//------------------------------------------------------------------------------------------------------------	
	
	public static boolean readFromFile(String fileName) {
		
		try {
			billArr = new ArrayList<OnlineBilling>();
			
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			String[] splittedLine;
			OnlineBilling billObj = null;
			
			String type;
			int id;
			String issuedate;
			String duedate;
			double usedAmount;
			int installment;
			
			while (scanner.hasNextLine()) {
				splittedLine = scanner.nextLine().split("%");
				
				type = splittedLine[0];
				id = Integer.parseInt(splittedLine[1]) ;
				issuedate = splittedLine[2];
				duedate = splittedLine[3];
				usedAmount = Double.parseDouble(splittedLine[4]);
				installment = Integer.parseInt(splittedLine[5]);
				if(type.equalsIgnoreCase("water")) 
					billObj = new WaterBill( id,  issuedate,  duedate,  usedAmount,installment);	
				else if(type.equalsIgnoreCase("gas"))
					billObj = new GasBill( id,  issuedate,  duedate,  usedAmount,installment);
				else if(type.equalsIgnoreCase("electricity"))
					billObj = new ElectricityBill( id, issuedate, duedate, usedAmount,installment);
				billObj.afterDueDateFine();
				billObj.calculateTotalBill();
				billObj.addTax();
				billArr.add(billObj);	
	
			}
			return true;
		}
		catch (Exception exc) {
			System.out.println(exc);
			return false;
		}	
	}
//---------------------------------------------------------------------------------------------------
public static boolean writeToFile(String fileName) {
		
		String line = "\n";
		OnlineBilling lastBill = null;
		WaterBill water;
		GasBill gas;
		ElectricityBill electricity;
		
		File file;
		FileWriter fileWriter;
		PrintWriter printWriter = null;
		
		try {
			file = new File(fileName);
			
			fileWriter = new FileWriter(file, true); // will append
			printWriter = new PrintWriter(fileWriter);
			
			
			if (billArr.size() > 0) { 
				lastBill = billArr.get(billArr.size() - 1); 
			
				if (lastBill instanceof WaterBill) {
					water = (WaterBill)lastBill;
					line += "water%" + water.getId() + "%" + water.getIssueDate() + "%" + water.getDueDate();
					line +=  "%" + water.getUsedWater()+ "%" +water.getInstallmentType();
				} 
				else if (lastBill instanceof GasBill) {
					gas = (GasBill)lastBill;
					line += "water%" + gas.getId() + "%" + gas.getIssueDate() + "%" + gas.getDueDate();
					line +=  "%" + gas.getUsedGas()+ "%" + gas.getInstallmentType();
				}
				else if(lastBill instanceof ElectricityBill) {
					electricity = (ElectricityBill)lastBill;
					line += "water%" + electricity.getId() + "%" + electricity.getIssueDate() + "%" + electricity.getDueDate();
					line +=  "%" + electricity.getUsedElectricity()+ "%" +electricity.getInstallmentType();
				}
				
				printWriter.print(line);
			}
			
			return true;
		}
		catch (FileNotFoundException exc) {
			System.out.println(exc);
		}
		catch (IOException exc) {
			System.out.println(exc);
		}
		finally {
			if (printWriter != null) { // for preventing null reference exception
				printWriter.close();
			}
		}		
		return false;		
	}
	
}
