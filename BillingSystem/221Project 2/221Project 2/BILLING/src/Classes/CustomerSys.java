package Classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerSys {

	private static ArrayList<Customer> custArr = new ArrayList<>();
	
	
		public static String listAllCustomers() {
			String out = "";
			for (Customer custs : custArr) {
				out += custs.toString() + "\n\n";
			}
			return out;
		}
		
	
		public static boolean deleteCustomer(int id) {
			Customer c = searchCustomer(id);
			if (c == null)
				return false;
			else {
				
				custArr.remove(c);
				return true;
			}
		}
		
		
	public static Customer searchCustomer(int idOfCust) {

		Customer cust = null;
		for (Customer c : custArr) {
			if (c.checkId(idOfCust))
				return c;
		}
		return cust;
	}
	
	
	public static boolean addCustomer(String type,String name,String surname,int age,String phoneNumber,int id,double salary, Address adress) {

		
		Customer custObj = null ;
		
		if (searchCustomer(id) == null) {
			if (type.equalsIgnoreCase("normal")) {
				custObj = new NormalCust( name, surname, age, phoneNumber, id, salary, adress);
				((NormalCust) custObj).calculateTax(((NormalCust) custObj).getSalary());
			}
			else if (type.equalsIgnoreCase("retired")) {
				custObj = new RetiredCust(name, surname, age, phoneNumber, id, salary, adress);
				((RetiredCust) custObj).calculateDiscount(((RetiredCust) custObj).getPension());			
			}
					
			custArr.add(custObj);			
			return true;
			
		}else 
			return false;				
	}
	
		
	public static boolean readFromfile(String fileName) {
		try {
			custArr= new ArrayList<Customer>();
			File file= new File("customer_data");
			
			Scanner scanner= new Scanner(file);
			String[] splittedLine;
			Customer cust = null;
			String type, name, surname,phoneNumber, city;
			int id, age, street, building;
			double salary;
			Address address;
			while(scanner.hasNextLine()) {
				//normal%John%Doe%45%555-1234%123%17500.0%10%76%NewYork
				splittedLine = scanner.nextLine().split("%");
				type=splittedLine[0];
				name=splittedLine[1];
				surname=splittedLine[2];
				age=Integer.parseInt(splittedLine[3]);
				phoneNumber=splittedLine[4];
				id=Integer.parseInt(splittedLine[5]);
				salary= Double.parseDouble(splittedLine[6]);
				street=Integer.parseInt(splittedLine[7]);
				building= Integer.parseInt(splittedLine[8]);
				city= splittedLine[9];
				address= new Address(street, building, city);
					
					
				if(type.equalsIgnoreCase("normal")) {
					cust= new NormalCust(name,surname,age,phoneNumber,id,salary,address);
					((NormalCust) cust).calculateTax(salary);
				}
				else if(type.equalsIgnoreCase("retired")) {
					cust= new RetiredCust(name,surname,age,phoneNumber,id,salary,address);
					((RetiredCust) cust).calculateDiscount(salary);	
				}
					
					custArr.add(cust);
				}
				return true;
				
			} catch (Exception exc) {
				System.out.println(exc);
				return false;
			}			
			
	}
	
	//-----------------------------------------------------------------------------------------------------------
	public static boolean writeToFile(String fileName) {
		
		String line;
		RetiredCust retired;
		NormalCust normal;
		
		File file = new File(fileName);
		
		if (!file.exists()) {
			System.out.println("File could not be found.");
			return false;
		}
		
		PrintWriter printWriter = null;
		
		try {
			printWriter = new PrintWriter(file); // will overwrite
			for( Customer cust: custArr ) {
				
				if (cust instanceof RetiredCust) {
					retired= (RetiredCust)cust;
					//surname age phoneNumber id salaryORpension streetNo buildingNo city
					line = "retired%"+ retired.getName()+ "%" + retired.getLastname()+ "%";
					line += retired.getAge()+"%"+ retired.getPhoneNumber()+"%"+retired.getId()+"%";
					line +=	retired.getPension()+"%"+retired.getCusAddress().getStreet()+"%"+retired.getCusAddress().getBuildingNo()
							+ "%" + retired.getCusAddress().getCity();
				}
				else {
					normal=(NormalCust)cust;
					line = "normal%"+ normal.getName()+ "%" + normal.getLastname()+ "%";
					line += normal.getAge()+"%"+ normal.getPhoneNumber()+"%"+normal.getId()+"%";
					line +=	normal.getSalary()+"%"+normal.getCusAddress().getStreet()+"%"+normal.getCusAddress().getBuildingNo()
							+ "%" + normal.getCusAddress().getCity();
				}
				printWriter.println(line);
				
			}
			return true;
		}
		catch (Exception exc) {
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