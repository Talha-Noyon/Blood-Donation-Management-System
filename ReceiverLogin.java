import java.sql.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

class ReceiverLogin extends JFrame implements ActionListener{
	
	Font myFont = new Font("Times New Roman", Font.BOLD,30);
	
	JLabel labT=new JLabel("Receiver Profile Information");
	JLabel lab1=new JLabel("Email:");
	
	JPasswordField passwordField1 = new JPasswordField();
	JPasswordField passwordField2 = new JPasswordField();
	
	JLabel lab2=new JLabel("Password:");
	JLabel lab3=new JLabel("Needed Blood Group:");

	JLabel lab7=new JLabel("Address:");
	JLabel lab8=new JLabel("Contact No:");
	JLabel lab9=new JLabel("If Want To Donate Blood:");
	JLabel lab10=new JLabel("Search By Location:");

	JTextField txtF1 =new JTextField();
	JTextField txtF2 =new JTextField();
	JTextField txtF3 =new JTextField();

	JTextField txtF7 =new JTextField();
	JTextField txtF8 =new JTextField();

	JButton btn1 =new JButton("Logout");
	JButton btn2 =new JButton("Update");
	JButton btn3 =new JButton("Request For Blood");
	JButton btn4 =new JButton("Search Donor");
	JButton btn5 =new JButton("If Donate Click Here");
	JButton btn6 =new JButton("Delete");
	String data2[] = {" ","AB+", "A+","B+","A-","B-","O+","O-","AB-"};
	String data3[] = {" ","AB+", "A+","B+","A-","B-","O+","O-","AB-"};
	static String data4[];
	JComboBox combo2 =new JComboBox(data2);
	JComboBox combo3 =new JComboBox(data3);
	JComboBox combo4 =new JComboBox();
	String name, rowName;
	int row ;
	Statement stmt=null;
	ResultSet rs=null;
	public ReceiverLogin(String nam){
		setContentPane(new JLabel(new ImageIcon("Red Blood_Cells5.jpg")));
		name=nam;

        try {
            Class.forName("com.mysql.jdbc.Driver");
			
			combo4.addItem(null);
			stmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();                        
            String query5 = "SELECT `Address` FROM `donor_list`";           
            rs = stmt.executeQuery(query5);
			
            while(rs.next()){
                //Preparing set combobox value
				for(int i = 1; i <= 1; i++){

					rowName=rs.getString(i);
					System.out.println(rowName);
					combo4.addItem(rowName);
					
				}

            }

            stmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();
            String query1 = "SELECT  `Email`,`Password` ,`Address`,`Contact No`,`Gender` FROM `receiver_list` WHERE Name='" + name + "'";
            rs = stmt.executeQuery(query1);
			rs.next();
            System.out.println(rs.getString(1));
			setVisible(true);
			setSize(600,500);
			setLayout(null);
			//combo.setSelectedIndex(1);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			setTitle("Edit Profile");
			setForeground(Color.blue);
			labT.setFont(myFont);
			
			labT.setBounds(110,50,370,40);
			add(labT);
			labT.setForeground(Color.white);
			lab1.setBounds(140,130,80,10);
			add(lab1);
			lab1.setForeground(Color.white);
			lab2.setBounds(120,180,80,10);
			add(lab2);
			lab2.setForeground(Color.white);
			lab3.setBounds(70,220,120,15);
			add(lab3);
			lab3.setForeground(Color.white);
			combo2.setBounds(200,220,90,20);
			add(combo2);

			lab7.setBounds(130,250,80,20);
			add(lab7);
			lab7.setForeground(Color.white);
			lab8.setBounds(120,290,80,10);
			add(lab8);
			lab8.setForeground(Color.white);
			lab9.setBounds(60,330,170,10);
			add(lab9);
			lab9.setForeground(Color.white);
			combo3.setBounds(200,325,90,20);
			add(combo3);
			lab10.setBounds(80,350,165,15);
			add(lab10);
			lab10.setForeground(Color.white);
			combo4.setBounds(200,350,90,20);
			add(combo4);

			txtF1.setBounds(200,120,170,30);
			add(txtF1);        
			txtF1.setText(rs.getString(1));
				
			passwordField1.setBounds(200,170,170,30);
			add(passwordField1); 
			passwordField1.setText(rs.getString(2));

			txtF7.setBounds(200,245,170,30);
			add(txtF7); 
			txtF7.setText(rs.getString(3));
			txtF8.setBounds(200,280,170,30);
			add(txtF8);             
			txtF8.setText(rs.getString(4));
			btn1.setBounds(50,380,75,30);
			add(btn1);
			btn1.setForeground(Color.red);
			btn2.setBounds(140,380,75,30);
			add(btn2);
			btn2.setForeground(Color.red);
			btn3.setBounds(370,380,140,30);
			add(btn3);
			btn3.setForeground(Color.red);
			btn4.setBounds(230,380,120,30);
			add(btn4);
			btn4.setForeground(Color.red);
			btn5.setBounds(200,420,165,30);
			add(btn5);
			btn5.setForeground(Color.red);
			btn6.setBounds(110,420,75,30);
			add(btn6);
			btn6.setForeground(Color.red);
			btn6.addActionListener(this);
			btn5.addActionListener(this);
			btn4.addActionListener(this);
			btn3.addActionListener(this);
			btn2.addActionListener(this);
			btn1.addActionListener(this);
			
		}	
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "ERROR");
			e.printStackTrace();
		}
		
	}
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getSource()==btn6){
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Statement stmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();
				
				String query = "DELETE FROM `receiver_list` WHERE Name='" +name+ "'";
				//System.out.println(name); 
				if(stmt.executeUpdate(query)==1){
					JOptionPane.showMessageDialog(this, "Delete Account Successfully!");
					
				}else{
					JOptionPane.showMessageDialog(this, "Delete  Failed");
				}
			}catch(Exception ex){
					
				JOptionPane.showMessageDialog(this, "Error");	  
			}
			BLogin t = new BLogin();	
			setVisible(false);
		}
		
		if (ae.getSource()==btn5){
			
			if(combo3.getSelectedItem().toString()==" "){
				JOptionPane.showMessageDialog(this, "Please Select Blood Group For Donate Blood");
				
			}
			else{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Statement stmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();
					String query1 = "SELECT  `Gender` FROM `receiver_list` WHERE Name='" + name + "'";
					ResultSet rs = stmt.executeQuery(query1);
					rs.next();
					
					String cname = name;
					String pass = passwordField1.getText();
					String address = txtF7.getText();
					String email = txtF1.getText();
					String contact = txtF8.getText();
					String gender=rs.getString(1);
					String dnetBloodGrp=combo3.getSelectedItem().toString();
					
					
					System.out.println(cname);
					System.out.println(pass);
					System.out.println(address);
					System.out.println(email);
					System.out.println(contact);
					System.out.println(gender);
					System.out.println(dnetBloodGrp);
					
					String query = "INSERT INTO `donor_list`(`Name`,`Password`,`Address`,`Email`,`Contact No.`,`Gender`,`Donate Blood Group`) VALUES ('"+cname+"', '"+pass+"','"+address+"','"+email+"','"+contact+"','"+gender+"','"+dnetBloodGrp+"')";
					//JOptionPane.showMessageDialog(this, "try block");
					//System.out.println(query);
					if(stmt.executeUpdate(query)==1){
						JOptionPane.showMessageDialog(this, "Successfully Inserted To Donor List ");

					}
					
					else{
						JOptionPane.showMessageDialog(this, "Failed To Insert");
					}
				}catch (Exception ex){
						
						JOptionPane.showMessageDialog(this, "Error");
						  ex.printStackTrace();
					}
			}
			
		}
		if(ae.getSource()==btn4){
			
			if(combo4.getSelectedItem()!=null){
				DonorListByAddress dba = new DonorListByAddress(combo4.getSelectedItem().toString());
				setVisible(false);
			}
			
			else{
			DonorList2 list=new DonorList2();
			setVisible(false);
			}
		}

		if(ae.getSource()==btn3){
			if(combo2.getSelectedItem()==" "){
				JOptionPane.showMessageDialog(this, "Please Select Blood Group For Request Blood");
			}
			else{
				try {
						Class.forName("com.mysql.jdbc.Driver");
						Statement stmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();
						String email=txtF1.getText();
						String pass=passwordField1.getText();
						
						String address=txtF7.getText();
						String contactNo=txtF8.getText();
						String needBloodGrp=combo2.getSelectedItem().toString();
						String query = "UPDATE `receiver_list` SET `Email`='"+email+"',`Password`='"+pass+"',`Address`='"+address+"',`Contact No`='"+contactNo+"',`Needed Blood Group`='"+needBloodGrp+"' WHERE Name='" +name+ "'";
						//System.out.println(name);
						if(stmt.executeUpdate(query)==1){
							JOptionPane.showMessageDialog(this, "Sent Request Successfully!");
							
						}else{
							JOptionPane.showMessageDialog(this, "Request Sent Failed");
						}
				}catch(Exception ex){
						
					JOptionPane.showMessageDialog(this, "Error");	  
				}
			}
		}
		
		if(ae.getSource()==btn2){
			try {
					Class.forName("com.mysql.jdbc.Driver");
					Statement stmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();
					String email=txtF1.getText();
					String pass=passwordField1.getText();
					
					String address=txtF7.getText();
					String contactNo=txtF8.getText();
					
					String query = "UPDATE `receiver_list` SET `Email`='"+email+"',`Password`='"+pass+"',`Address`='"+address+"',`Contact No`='"+contactNo+"' WHERE Name='" +name+ "'";
					//System.out.println(name);
					if(stmt.executeUpdate(query)==1){
						JOptionPane.showMessageDialog(this, "Update Successfully!");
						
					}else{
						JOptionPane.showMessageDialog(this, "Update Failed");
					}
			}catch(Exception ex){
					
				JOptionPane.showMessageDialog(this, "Error");	  
			}
		}
		if(ae.getSource()==btn1){
			
			BLogin t = new BLogin();
			setVisible(false);
		}
	}
		
}