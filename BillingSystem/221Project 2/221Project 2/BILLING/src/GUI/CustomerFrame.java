package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Address;
import Classes.Customer;
import Classes.CustomerSys;
import Classes.OnlineBillingSys;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.ProcessHandle.Info;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class CustomerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField name_tf;
	private JTextField surname_tf;
	private JTextField id_tf;
	private JTextField age_tf;
	private JTextField phoneNumber_tf;
	private JTextField street_tf;
	private JTextField id_delete;
	private JTextField id_search;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField salary_tf;
	private JTextField pension_tf;
	private JTextField building_tf;
	private JTextField city_tf;

	private BillingFrame billframe = new BillingFrame(this);

	/**
	 * Create the frame.
	 */
	public CustomerFrame() {
		setTitle("Customer Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Customer");
		lblNewLabel.setBounds(55, 42, 142, 25);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(24, 95, 60, 13);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Surname");
		lblNewLabel_1_1.setBounds(24, 118, 77, 13);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("ID");
		lblNewLabel_1_2.setBounds(24, 141, 52, 13);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Age");
		lblNewLabel_1_3.setBounds(24, 164, 37, 19);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_3);
		
		JLabel street_lbl = new JLabel("Street");
		street_lbl.setBounds(24, 210, 101, 13);
		street_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(street_lbl);
		
		JLabel lblNewLabel_1_5 = new JLabel(":");
		lblNewLabel_1_5.setBounds(127, 95, 14, 13);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_5_1 = new JLabel(":");
		lblNewLabel_1_5_1.setBounds(127, 120, 14, 13);
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel(":");
		lblNewLabel_1_5_2.setBounds(127, 143, 14, 13);
		lblNewLabel_1_5_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_5_2);
		
		JLabel lblNewLabel_1_5_3 = new JLabel(":");
		lblNewLabel_1_5_3.setBounds(127, 166, 14, 13);
		lblNewLabel_1_5_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_5_3);
		
		JLabel lblNewLabel_1_5_4 = new JLabel(":");
		lblNewLabel_1_5_4.setBounds(127, 189, 14, 13);
		lblNewLabel_1_5_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_5_4);
		
		JLabel lblNewLabel_1_5_5 = new JLabel(":");
		lblNewLabel_1_5_5.setBounds(127, 212, 14, 13);
		lblNewLabel_1_5_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_5_5);
		
		name_tf = new JTextField();
		name_tf.setBounds(137, 94, 96, 19);
		contentPane.add(name_tf);
		name_tf.setColumns(10);
		
		surname_tf = new JTextField();
		surname_tf.setBounds(137, 117, 96, 19);
		surname_tf.setColumns(10);
		contentPane.add(surname_tf);
		
		id_tf = new JTextField();
		id_tf.setBounds(137, 140, 96, 19);
		id_tf.setColumns(10);
		contentPane.add(id_tf);
		
		phoneNumber_tf = new JTextField();
		phoneNumber_tf.setBounds(137, 186, 96, 19);
		phoneNumber_tf.setColumns(10);
		contentPane.add(phoneNumber_tf);
		
		street_tf = new JTextField();
		street_tf.setBounds(137, 209, 96, 19);
		street_tf.setColumns(10);
		contentPane.add(street_tf);
		
		JLabel lblNewLabel_2 = new JLabel("Information");
		lblNewLabel_2.setBounds(24, 325, 131, 19);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 28, 237, 293);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton addB = new JButton("Add");
		addB.setBounds(65, 261, 85, 21);
		panel.add(addB);
		
		addB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_4_1_2 = new JLabel("Building No");
		lblNewLabel_1_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_1_2.setBounds(10, 203, 101, 13);
		panel.add(lblNewLabel_1_4_1_2);
		
		JLabel lblNewLabel_1_5_5_1 = new JLabel(":");
		lblNewLabel_1_5_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5_5_1.setBounds(109, 203, 14, 13);
		panel.add(lblNewLabel_1_5_5_1);
		
		JLabel lblNewLabel_4 = new JLabel("City");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(20, 227, 49, 21);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_5_5_1_1 = new JLabel(":");
		lblNewLabel_1_5_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5_5_1_1.setBounds(97, 227, 14, 13);
		panel.add(lblNewLabel_1_5_5_1_1);
		
		city_tf = new JTextField();
		city_tf.setColumns(10);
		city_tf.setBounds(131, 229, 96, 19);
		panel.add(city_tf);
		
		age_tf = new JTextField();
		age_tf.setBounds(131, 135, 96, 19);
		panel.add(age_tf);
		age_tf.setColumns(10);
		
		JLabel lblNewLabel_1_4 = new JLabel("Phone Number");
		lblNewLabel_1_4.setBounds(10, 161, 101, 13);
		panel.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		building_tf = new JTextField();
		building_tf.setBounds(131, 201, 96, 19);
		panel.add(building_tf);
		building_tf.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(521, 415, 200, 134);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("ID");
		lblNewLabel_1_2_1.setBounds(10, 41, 17, 19);
		panel_2.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblDeleteCustomer = new JLabel("Delete Customer");
		lblDeleteCustomer.setBounds(27, 5, 168, 25);
		panel_2.add(lblDeleteCustomer);
		lblDeleteCustomer.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_5_2_1 = new JLabel(":");
		lblNewLabel_1_5_2_1.setBounds(37, 44, 14, 13);
		panel_2.add(lblNewLabel_1_5_2_1);
		lblNewLabel_1_5_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		id_delete = new JTextField();
		id_delete.setBounds(72, 42, 96, 19);
		panel_2.add(id_delete);
		id_delete.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 345, 436, 193);
		contentPane.add(scrollPane);
		
		JTextArea display_tf = new JTextArea();
		scrollPane.setViewportView(display_tf);
		
		
		JButton deleteB = new JButton("Delete");
		deleteB.setBounds(55, 87, 85, 21);
		panel_2.add(deleteB);
		deleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				if(id_delete.getText().isEmpty()) {
					 display_tf.setText("First give ID to delete");
				}
				else {
					int id = Integer.parseInt(id_delete.getText());
					if(CustomerSys.deleteCustomer(id)){
						display_tf.setText("Customer has been deleted");
					}else {
						display_tf.setText("customer does not exist. cannot be deleted");
					}
					clear();
				}	
			}
		});
		deleteB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(521, 277, 200, 127);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblSearchCustomer = new JLabel("Search Customer");
		lblSearchCustomer.setBounds(14, 5, 171, 25);
		panel_3.add(lblSearchCustomer);
		lblSearchCustomer.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("ID");
		lblNewLabel_1_2_1_1.setBounds(24, 47, 52, 13);
		panel_3.add(lblNewLabel_1_2_1_1);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		id_search = new JTextField();
		id_search.setBounds(94, 41, 96, 19);
		panel_3.add(id_search);
		id_search.setColumns(10);
		
		JLabel lblNewLabel_1_5_6_2 = new JLabel(":");
		lblNewLabel_1_5_6_2.setBounds(57, 46, 14, 13);
		panel_3.add(lblNewLabel_1_5_6_2);
		lblNewLabel_1_5_6_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton searchB = new JButton("Search");
		searchB.setBounds(61, 84, 85, 21);
		panel_3.add(searchB);
		searchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer object2;
				
				if(id_search.getText().isEmpty()) {
					 display_tf.setText("First give ID to search");
				}
				else {
					int id=Integer.parseInt(id_search.getText());
					object2 = CustomerSys.searchCustomer(id);
					if(object2==null){
						display_tf.setText("Customer NOT Found");
					}else {
						display_tf.setText(object2.toString());
					}
					clear();
				}
			}
		});
		searchB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(483, 42, 275, 193);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel salary_panel = new JPanel();
		salary_panel.setBounds(23, 109, 100, 74);
		panel_4.add(salary_panel);
		salary_panel.setLayout(null);
		
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Salary");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1.setBounds(10, 11, 60, 19);
		salary_panel.add(lblNewLabel_1_4_1_1);
		
		salary_tf = new JTextField();
		salary_tf.setColumns(10);
		salary_tf.setBounds(0, 39, 96, 19);
		salary_panel.add(salary_tf);
		
		JPanel pension_panel = new JPanel();
		pension_panel.setBounds(146, 109, 119, 74);
		panel_4.add(pension_panel);
		pension_panel.setLayout(null);
		pension_panel.setVisible(false);
		JLabel lblNewLabel_3 = new JLabel("Pension");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 11, 59, 13);
		pension_panel.add(lblNewLabel_3);
		
		pension_tf = new JTextField();
		pension_tf.setBounds(10, 35, 80, 19);
		pension_panel.add(pension_tf);
		pension_tf.setColumns(10);
		
		JRadioButton normalCust_RB = new JRadioButton("Normal");
		normalCust_RB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pension_panel.setVisible(false);
				salary_panel.setVisible(true);
			}
		});
		normalCust_RB.setBounds(23, 70, 77, 21);
		panel_4.add(normalCust_RB);
		buttonGroup.add(normalCust_RB);
		normalCust_RB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		normalCust_RB.setSelected(true);
		
		JRadioButton retiredCust_RB = new JRadioButton("Retired");
		retiredCust_RB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pension_panel.setVisible(true);
				salary_panel.setVisible(false);
			}
		});
		retiredCust_RB.setBounds(146, 70, 77, 21);
		panel_4.add(retiredCust_RB);
		buttonGroup.add(retiredCust_RB);
		retiredCust_RB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblCustomerType = new JLabel("Customer Type");
		lblCustomerType.setBounds(56, 21, 153, 25);
		panel_4.add(lblCustomerType);
		lblCustomerType.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton readfile_btn = new JButton("Read From File");
		readfile_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (CustomerSys.readFromfile("customer_data")) {
						display_tf.setText("File read successful.");
					} else {
						display_tf.setText("An exception occurred during file read!");
					}
			}
		});
		readfile_btn.setBounds(280, 92, 142, 39);
		readfile_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(readfile_btn);
		
		JButton addBillInfo_btn = new JButton("Add Bill Info");
		addBillInfo_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				billframe.setVisible(true);
			}
		});
		addBillInfo_btn.setBounds(280, 233, 142, 39);
		addBillInfo_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(addBillInfo_btn);
		
		JButton writeToFile_btn = new JButton("Write To File");
		writeToFile_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CustomerSys.writeToFile("customer_data")) {
					display_tf.setText("File write successful.");
				} else {
					display_tf.setText("An exception occurred during file write!");
				}
			}
		});
		writeToFile_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		writeToFile_btn.setBounds(280, 176, 142, 39);
		contentPane.add(writeToFile_btn);
		
		
		JButton displayB = new JButton("Display");
		displayB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String out;
				out = CustomerSys.listAllCustomers();
				if(out == "")
					display_tf.setText("No data available. Add data or read from file");
				else 
					display_tf.setText(out);
			}
		});
		displayB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		displayB.setBounds(183, 547, 101, 25);
		contentPane.add(displayB);
		
		addB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Address adresObj = null;
				String type = null;
				String name, surname, phoneNumber;
				int id, age;
				double salaryORpension = 0;
				
				
				if(normalCust_RB.isSelected()) {
					 type = "normal";
					 if(salary_tf.getText().isEmpty()||street_tf.getText().isEmpty()||building_tf.getText().isEmpty()
							 ||city_tf.getText().isEmpty()||name_tf.getText().isEmpty()||surname_tf.getText().isEmpty()
							 ||age_tf.getText().isEmpty()||phoneNumber_tf.getText().isEmpty()||id_tf.getText().isEmpty()) {
						 display_tf.setText("All fields are required for the Customer Info");
					 }
					 else {
						 salaryORpension = Double.parseDouble(salary_tf.getText().toString()); 
						 int street = Integer.parseInt(street_tf.getText().toString());
						 int building = Integer.parseInt(building_tf.getText().toString());
						 String city = city_tf.getText().toString();
						 adresObj = new Address(street,building,city);
							
						 name = name_tf.getText();
						 surname = surname_tf.getText();
						 phoneNumber = phoneNumber_tf.getText();
						 id = Integer.parseInt(id_tf.getText());
						 age = Integer.parseInt(age_tf.getText());
						 boolean added = CustomerSys.addCustomer(type, name, surname, age, phoneNumber, 
									id, salaryORpension, adresObj);
						 if (added)
							 display_tf.setText("Customer Info has been added");
						 else
							 display_tf.setText("Customer Info NOT added. already exists");	
						 clear();
					 }
				}
				else if(retiredCust_RB.isSelected()) {
					 type = "retired";
					 if(pension_tf.getText().isEmpty()||street_tf.getText().isEmpty()||building_tf.getText().isEmpty()
							 ||city_tf.getText().isEmpty()||name_tf.getText().isEmpty()||surname_tf.getText().isEmpty()
							 ||age_tf.getText().isEmpty()||phoneNumber_tf.getText().isEmpty()||id_tf.getText().isEmpty()) {
						 display_tf.setText("All fields are required for the Customer Info");
					 }
					 else {
						 salaryORpension = Double.parseDouble(pension_tf.getText().toString()); 
						 int street = Integer.parseInt(street_tf.getText().toString());
						 int building = Integer.parseInt(building_tf.getText().toString());
						 String city = city_tf.getText().toString();
						 adresObj = new Address(street,building,city);
							
						 name = name_tf.getText();
						 surname = surname_tf.getText();
						 phoneNumber = phoneNumber_tf.getText();
						 id = Integer.parseInt(id_tf.getText().toString());
						 age = Integer.parseInt(age_tf.getText().toString());
						 boolean added = CustomerSys.addCustomer(type, name, surname, age, phoneNumber, 
									id, salaryORpension, adresObj);
						 if (added)
							 display_tf.setText("Customer Info has been added");
						 else
							 display_tf.setText("Customer Info NOT added. already exists");		
						 clear();
					 }
				}
				
			}
		});
		
	}
	
	public void clear() {
		name_tf.setText("");
		surname_tf.setText("");
		phoneNumber_tf.setText("");
		id_tf.setText("");
		age_tf.setText("");
		salary_tf.setText("");
		pension_tf.setText("");
		street_tf.setText("");
		building_tf.setText("");
		city_tf.setText("");
		id_search.setText("");
		id_delete.setText("");
		
	}
}