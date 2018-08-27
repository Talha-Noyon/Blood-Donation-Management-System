import java.sql.*;
import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Objects;
class DonorSignUp extends JFrame implements ActionListener{
	
	Font myFont = new Font("Times New Roman", Font.BOLD,30);
	
	JLabel labT=new JLabel("Donor Registration Form");
	JLabel lab1=new JLabel("User Name:");
	
	JPasswordField passwordField1 = new JPasswordField();
	JPasswordField passwordField2 = new JPasswordField();
	
	JLabel lab2=new JLabel("Password:");
	JLabel lab3=new JLabel("Confirm Password:");
	JLabel lab4=new JLabel("Gender:");
	JLabel lab5=new JLabel("Age:");
	JLabel lab6=new JLabel("Blood Group:");
	JLabel lab7=new JLabel("Address:");
	JLabel lab8=new JLabel("Contact No:");
	JLabel lab9=new JLabel("Email:");
	JLabel lab10=new JLabel("Last Donate:");
	
	JTextField txtF1 =new JTextField();
	JTextField txtF2 =new JTextField();
	JTextField txtF3 =new JTextField();
	JTextField txtF4 =new JTextField();
	JTextField txtF5 =new JTextField();
	JTextField txtF7 =new JTextField();
	JTextField txtF8 =new JTextField();
	JTextField txtF9 =new JTextField();
	JTextField txtF10 =new JTextField();
	
	JButton btn1 =new JButton("Cancel");
	JButton btn2 =new JButton("Submit");
	
	//String data[] = {"Male", "Female"};
	//String data2[] = {"AB+", "A+","B+","A-","B-","O+","O-","AB-"};
	JComboBox combo =new JComboBox();
	JComboBox combo2 =new JComboBox();

	
	public DonorSignUp(){
		setContentPane(new JLabel(new ImageIcon("Red Blood_Cells3.jpg")));
		setVisible(true);
		setSize(600,700);
		setLayout(null);
		//combo.setSelectedIndex(1);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		combo.setBounds(200,275,80,20);
		
		combo.addItem("Male");
		combo.addItem("Female");
		add(combo);
		combo.setEditable(true);
		
		
		combo2.setBounds(200,380,80,20);
		combo2.addItem("AB+");
		combo2.addItem("A+");
		combo2.addItem("B+");
		combo2.addItem("A-");
		combo2.addItem("B-");
		combo2.addItem("O+");
		combo2.addItem("O-");
		combo2.addItem("AB-");
		add(combo2);
		combo2.setEditable(true);
		setTitle("Donor Registration Form");
		//labT.setBackground(Color.yellow);
		//setBackground(Color.green);
		
		
		labT.setFont(myFont);
		
		labT.setBounds(125,80,330,40);
		add(labT);
		labT.setForeground(Color.white);
		lab1.setBounds(120,140,80,10);
		add(lab1);
		lab1.setForeground(Color.white);
		lab2.setBounds(120,190,80,10);
		add(lab2);
		lab2.setForeground(Color.white);
		lab3.setBounds(90,240,110,10);
		add(lab3);
		lab3.setForeground(Color.white);
		lab4.setBounds(130,280,80,10);
		add(lab4);
		lab4.setForeground(Color.white);
		lab5.setBounds(150,300,80,20);
		add(lab5);
		lab5.setForeground(Color.white);
		lab6.setBounds(120,380,80,20);
		add(lab6);
		lab6.setForeground(Color.white);
		lab7.setBounds(130,340,80,20);
		add(lab7);
		lab7.setForeground(Color.white);
		lab8.setBounds(120,420,80,10);
		add(lab8);
		lab8.setForeground(Color.white);
		lab9.setBounds(150,460,80,10);
		add(lab9);
		lab9.setForeground(Color.white);
		lab10.setBounds(120,500,80,10);
		add(lab10);
		lab10.setForeground(Color.white);
		txtF1.setBounds(200,130,170,30);
		add(txtF1);            
            
		passwordField1.setBounds(200,180,170,30);
		add(passwordField1);             
		passwordField2.setBounds(200,230,170,30);
		add(passwordField2);
		txtF5.setBounds(200,300,170,30);
		add(txtF5);  
		
		txtF7.setBounds(200,340,170,30);
		add(txtF7); 
		txtF8.setBounds(200,410,170,30);
		add(txtF8);             
		txtF9.setBounds(200,450,170,30);
		add(txtF9);
		
		txtF10.setBounds(200,490,170,30);
		
		txtF10.setText("YYYY-MM-DD");
		add(txtF10);
		

		btn1.setBounds(160,540,75,30);
		add(btn1);
		btn1.setForeground(Color.red);
		btn2.setBounds(290,540,75,30);
		add(btn2);
		btn2.setForeground(Color.red);
		btn2.addActionListener(this);
		btn1.addActionListener(this);
		combo.addActionListener(this);
		combo2.addActionListener(this);

		
		
	}
	
		public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==btn2){
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Statement stmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();
				
				String cname = txtF1.getText();
				String pass = passwordField1.getText();
				String confpass = passwordField2.getText();
				String address = txtF7.getText();
				String email = txtF9.getText();
				String contact = txtF8.getText();
				String gender=combo.getSelectedItem().toString();
				String bloodGrp=combo2.getSelectedItem().toString();
				String lstDonDate = txtF10.getText();
				
				String query = "INSERT INTO `donor_list`(`Name`,`Password`,`Confirm Password`,`Address`,`Email`,`Contact No.`,`Gender`,`Donate Blood Group`,`Last Donate Date`) VALUES ('"+cname+"', '"+pass+"','"+confpass+"','"+address+"','"+email+"','"+contact+"','"+gender+"','"+bloodGrp+"','"+lstDonDate+"')";
				//JOptionPane.showMessageDialog(this, "try block");
				//System.out.println(query);
				if(stmt.executeUpdate(query)==1){
					JOptionPane.showMessageDialog(this, "Successfully Inserted ");

				}
				
				else{
					JOptionPane.showMessageDialog(this, "Failed To Insert");
				}
			}catch (Exception ex){
					
					JOptionPane.showMessageDialog(this, "Error");
					  
				}
			
			
		}
		if (ae.getSource()==btn1){
			
			SignUpAs S = new SignUpAs();
			setVisible(false);
		}
	}
	
	
}