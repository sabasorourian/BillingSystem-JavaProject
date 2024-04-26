package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.CustomerSys;
import Classes.OnlineBilling;
import Classes.OnlineBillingSys;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class BillingFrame extends JFrame {

	private JPanel contentPane;
	private JTextField id_tf;
	private JTextField issue_tf;
	private JTextField due_tf;
	private JTextField amount_tf;
	private JTextField search_tf;
	private JTextField delete_tf;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JTextArea display_ta;

	/**
	 * Create the frame.
	 */
	public BillingFrame(CustomerFrame custFrame) {
		setTitle("Billing Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		JComboBox Inst_CB = new JComboBox();
		Inst_CB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(25, 23, 155, 203);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("Choose Bill");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(20, 11, 113, 61);
		panel.add(lblNewLabel);
		
		
		
		JRadioButton gas_btn = new JRadioButton("Gas");
		buttonGroup.add(gas_btn);
		gas_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gas_btn.setBounds(20, 99, 103, 21);
		panel.add(gas_btn);
		gas_btn.setSelected(true);
		JRadioButton water_btn = new JRadioButton("Water");
		buttonGroup.add(water_btn);
		water_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		water_btn.setBounds(20, 133, 103, 21);
		panel.add(water_btn);
		
		JRadioButton electricity_btn = new JRadioButton("Electricity");
		buttonGroup.add(electricity_btn);
		electricity_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		electricity_btn.setBounds(20, 167, 103, 21);
		panel.add(electricity_btn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(215, 23, 439, 203);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Add Bill Info");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(47, 0, 130, 56);
		panel_1.add(lblNewLabel_1);
		
		id_tf = new JTextField();
		id_tf.setBounds(10, 99, 76, 19);
		panel_1.add(id_tf);
		id_tf.setColumns(10);
		
		issue_tf = new JTextField();
		issue_tf.setColumns(10);
		issue_tf.setBounds(111, 99, 76, 19);
		panel_1.add(issue_tf);
		
		due_tf = new JTextField();
		due_tf.setColumns(10);
		due_tf.setBounds(222, 99, 76, 19);
		panel_1.add(due_tf);
		
		amount_tf = new JTextField();
		amount_tf.setColumns(10);
		amount_tf.setBounds(350, 99, 76, 19);
		panel_1.add(amount_tf);
		
		JLabel id_lbl = new JLabel("Id");
		id_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		id_lbl.setBounds(26, 76, 49, 14);
		panel_1.add(id_lbl);
		
		JLabel issueDate_lbl = new JLabel("Issue Date");
		issueDate_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		issueDate_lbl.setBounds(105, 74, 82, 19);
		panel_1.add(issueDate_lbl);
		
		JLabel dueDate_lbl = new JLabel("Due Date");
		dueDate_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dueDate_lbl.setBounds(236, 74, 62, 22);
		panel_1.add(dueDate_lbl);
		
		JLabel amount_lbl = new JLabel("Used Amount");
		amount_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		amount_lbl.setBounds(340, 75, 89, 20);
		panel_1.add(amount_lbl);
		JCheckBox addToFile_checkbox = new JCheckBox("Add To File");
		
		JButton add_btn = new JButton("ADD");
		add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean added;
				String type = null;
				
				if(amount_tf.getText().isEmpty()||id_tf.getText().isEmpty()||issue_tf.getText().isEmpty()
						||due_tf.getText().isEmpty()) {
					display_ta.setText("All fields are required for Bill Info");
				}
				else {
					
					double amount = Double.parseDouble(amount_tf.getText().toString());
					int id = Integer.parseInt(id_tf.getText().toString());
					
					if(water_btn.isSelected()) {
						type = "water";
					}
					if(gas_btn.isSelected()) {
						type = "gas";
					}
					if(electricity_btn.isSelected()) {
						type = "electricity";
					}
					
					int installment = Integer.parseInt(Inst_CB.getSelectedItem().toString());
					added = OnlineBillingSys.addBills(type,id,issue_tf.getText(),due_tf.getText(),amount,installment);
					if(added) {
						display_ta.setText("Bill Info has been added");
						if(addToFile_checkbox.isSelected()) {
							if(OnlineBillingSys.writeToFile("bill_data"))
								display_ta.setText("Bill Info has been added to file");
							else
								display_ta.setText("Bill Info could not be added to file");
						}
					}
					else
						display_ta.setText("Bill Info cannot be added. already exists");
					clear();
				}
				
			}
		});
		add_btn.setBounds(47, 157, 89, 23);
		panel_1.add(add_btn);
		
		JButton readfile_btn = new JButton("Read From File");
		readfile_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(OnlineBillingSys.readFromFile("bill_data"))
					display_ta.setText("file read successful");
				else
					display_ta.setText("some error occured. file not read");
			}
		});
		readfile_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		readfile_btn.setBounds(250, 15, 130, 35);
		panel_1.add(readfile_btn);
		
		addToFile_checkbox.setBounds(182, 157, 186, 23);
		panel_1.add(addToFile_checkbox);
		
		addToFile_checkbox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				
			}
		});
		addToFile_checkbox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(692, 23, 193, 203);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Search Bill");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 11, 101, 15);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Delete Bill");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(10, 123, 101, 15);
		panel_2.add(lblNewLabel_2_1);
		
		search_tf = new JTextField();
		search_tf.setBounds(64, 37, 96, 19);
		panel_2.add(search_tf);
		search_tf.setColumns(10);
		
		delete_tf = new JTextField();
		delete_tf.setColumns(10);
		delete_tf.setBounds(64, 149, 96, 19);
		panel_2.add(delete_tf);
		
		JLabel id_lbl_1 = new JLabel("Id:");
		id_lbl_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		id_lbl_1.setBounds(10, 37, 35, 17);
		panel_2.add(id_lbl_1);
		
		JLabel id_lbl_2 = new JLabel("Id:");
		id_lbl_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		id_lbl_2.setBounds(19, 150, 35, 14);
		panel_2.add(id_lbl_2);
		
		JButton search_btn = new JButton("search");
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OnlineBilling object1;
				if(search_tf.getText().isEmpty()) {
					display_ta.setText("First add id to search info");
				}
				else {
					int id = Integer.parseInt(search_tf.getText());
					object1=OnlineBillingSys.searchBills(id);
					if(object1 == null)
						display_ta.setText("Bill Info NOT found!");
					else
						display_ta.setText(object1.toString());
					clear();
				}
				
			}
		});
		search_btn.setBounds(50, 73, 89, 23);
		panel_2.add(search_btn);
		
		JButton delete_btn = new JButton("delete");
		delete_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean deleted;
				if(delete_tf.getText().isEmpty()) {
					display_ta.setText("First add id to delete info");
				}
				else {
					int id = Integer.parseInt(delete_tf.getText());
					deleted = OnlineBillingSys.deleteBill(id);
					if(!deleted)
						display_ta.setText("Bill Info NOT deleted! Does not exist");
					else
						display_ta.setText("Bill Info deleted");
					clear();
				}		
			}
		});
		delete_btn.setBounds(50, 179, 89, 23);
		panel_2.add(delete_btn);

		
		JButton display_btn = new JButton("DISPLAY");
		display_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String out;
				out = OnlineBillingSys.listAllBills();
				if(out == "")
					display_ta.setText("No data available. Add data or read from file");
				else 
					display_ta.setText(out);
			}
		});
		display_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		display_btn.setBounds(171, 436, 118, 27);
		contentPane.add(display_btn);
		
		JPanel installment_panel = new JPanel();
		installment_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		installment_panel.setBounds(560, 257, 275, 153);
		contentPane.add(installment_panel);
		installment_panel.setLayout(null);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Installment(s)");
		lblNewLabel_2_1_1.setBounds(65, 5, 145, 25);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		installment_panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_4_1_1_1_1 = new JLabel("Select Installment Months");
		lblNewLabel_1_4_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1.setBounds(10, 61, 190, 25);
		installment_panel.add(lblNewLabel_1_4_1_1_1_1);
		
		
		Inst_CB.setModel(new DefaultComboBoxModel(new String[] {"0","3", "6"}));
		Inst_CB.setToolTipText("");
		Inst_CB.setBounds(210, 63, 55, 25);
		installment_panel.add(Inst_CB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 248, 412, 177);
		contentPane.add(scrollPane);
		
		display_ta = new JTextArea();
		scrollPane.setViewportView(display_ta);
		
		JButton close_btn = new JButton("CLOSE");
		close_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		close_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		close_btn.setBounds(485, 431, 98, 27);
		contentPane.add(close_btn);
		
		
	}
	
	public void clear() {
		id_tf.setText("");
		issue_tf.setText("");
		due_tf.setText("");
		amount_tf.setText("");
		search_tf.setText("");
		delete_tf.setText("");
	}
}
