import java.sql.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

class DonorLogin extends JFrame implements ActionListener{
	
	Font myFont = new Font("Times New Roman", Font.BOLD,30);
	
	JLabel labT=new JLabel("Donor Profile Information");
	JLabel lab1=new JLabel("Email:");
	
	JPasswordField passwordField1 = new JPasswordField();
	JPasswordField passwordField2 = new JPasswordField();
	
	JLabel lab2=new JLabel("Password:");
	JLabel lab3=new JLabel("Last Donate Date:");
	
	JLabel lab7=new JLabel("Address:");
	JLabel lab8=new JLabel("Contact No:");

	JTextField txtF1 =new JTextField();
	JTextField txtF2 =new JTextField();
	JTextField txtF3 =new JTextField();

	JTextField txtF7 =new JTextField();
	JTextField txtF8 =new JTextField();

	JButton btn1 =new JButton("Logout");
	JButton btn2 =new JButton("Update");
	JButton btn3 =new JButton("View Request");
	JButton btn4 =new JButton("Delete");
	String data[] = {"Male", "Female"};
	String data2[] = {"AB+", "A+","B+","A-","B-","O+","O-","AB-"};
	JComboBox combo =new JComboBox(data);
	JComboBox combo2 =new JComboBox(data2);
	
	String name;
	public DonorLogin(String nam){
		setContentPane(new JLabel(new ImageIcon("Red Blood_Cells5.jpg")));
		name=nam;
		try{
			
            Statement stmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();
            String query1 = "SELECT  `Email`,`Password`, `Last Donate Date` ,`Address`,`Contact No.` FROM `donor_list` WHERE Name='" + name + "'";
            ResultSet rs = stmt.executeQuery(query1);
			rs.next();
            System.out.println(rs.getString(1));
			setVisible(true);
			setSize(600,500);
			setLayout(null);
			setResizable(false);
			//combo.setSelectedIndex(1);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			setTitle("Edit Profile");
			setForeground(Color.blue);
			labT.setFont(myFont);
			
			labT.setBounds(125,80,340,40);
			add(labT);
			labT.setForeground(Color.white);
			lab1.setBounds(140,140,80,10);
			add(lab1);
			lab1.setForeground(Color.white);
			lab2.setBounds(120,190,80,10);
			add(lab2);
			lab2.setForeground(Color.white);
			lab3.setBounds(90,240,110,10);
			add(lab3);
			lab3.setForeground(Color.white);
			lab7.setBounds(130,280,80,20);
			add(lab7);
			lab7.setForeground(Color.white);
			lab8.setBounds(120,330,80,10);
			add(lab8);
			lab8.setForeground(Color.white);
			txtF1.setBounds(200,130,170,30);
			add(txtF1);        
			txtF1.setText(rs.getString(1));
				
			passwordField1.setBounds(200,180,170,30);
			add(passwordField1); 
			passwordField1.setText(rs.getString(2));
			txtF3.setBounds(200,230,170,30);
			add(txtF3);
			txtF3.setText(rs.getString(3));
			txtF7.setBounds(200,280,170,30);
			add(txtF7); 
			txtF7.setText(rs.getString(4));
			txtF8.setBounds(200,320,170,30);
			add(txtF8);             
			txtF8.setText(rs.getString(5));
			btn1.setBounds(80,370,75,30);
			add(btn1);
			btn1.setForeground(Color.red);
			btn2.setBounds(170,370,75,30);
			add(btn2);
			btn2.setForeground(Color.red);
			btn3.setBounds(260,370,120,30);
			add(btn3);
			btn3.setForeground(Color.red);
			btn4.setBounds(395,370,75,30);
			add(btn4);
			btn4.setForeground(Color.red);
			btn4.addActionListener(this);
			btn3.addActionListener(this);
			btn2.addActionListener(this);
			btn1.addActionListener(this);
		}	
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		
	}
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getSource()==btn4){
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Statement stmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();
				
				String query = "DELETE FROM `donor_list` WHERE Name='" +name+ "'";
				//System.out.println(name); 
				if(stmt.executeUpdate(query)==1){
					JOptionPane.showMessageDialog(this, "Delete Account Successfully!");
					
				}else{
					JOptionPane.showMessageDialog(this, "Delete  Failed");
				}
			}catch(Exception ex){
					
				JOptionPane.showMessageDialog(this, "Error");
				ex.printStackTrace();
			}
			BLogin t = new BLogin();
			setVisible(false);
		}
		
		
		if(ae.getSource()==btn3){
			RequestList rq =new RequestList();
			setVisible(false);
		}
		if(ae.getSource()==btn2){
			try {
					Class.forName("com.mysql.jdbc.Driver");
					Statement stmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();
					String email=txtF1.getText();
					String pass=passwordField1.getText();
					String lstDdate=txtF3.getText();
					String address=txtF7.getText();
					String contactNo=txtF8.getText();
					System.out.println(lstDdate);
					String query = "UPDATE `donor_list` SET `Email`='"+email+"',`Password`='"+pass+"',`Last Donate Date`='"+lstDdate+"',`Address`='"+address+"',`Contact No.`='"+contactNo+"' WHERE Name='" +name+ "'";
					
					if(stmt.executeUpdate(query)==1){
						JOptionPane.showMessageDialog(this, "Update Successfully!");
						
					}else{
						JOptionPane.showMessageDialog(this, "Update Failed");
					}
			}catch(Exception ex){
					
				JOptionPane.showMessageDialog(this, "Error");	  
			}
		}
		else if(ae.getSource()==btn1){
			
			BLogin t = new BLogin();
			setVisible(false);
		}
	}
		
}