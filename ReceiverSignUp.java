import java.awt.TrayIcon.MessageType;
import java.awt.Color;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
class ReceiverSignUp extends JFrame implements ActionListener{
	
    Statement stmt = null;
    ResultSet rs = null;

	Font myFont = new Font("Times New Roman", Font.BOLD,30);
	
	JLabel labT=new JLabel("Receiver Registration Form");
	JLabel lab1=new JLabel("Name:");
	JLabel lab2=new JLabel("Password:");
	
	JPasswordField passwordField1 = new JPasswordField();
	JPasswordField passwordField2 = new JPasswordField();

	JLabel lab4=new JLabel("Gender:");

	JLabel lab7=new JLabel("Address:");
	JLabel lab8=new JLabel("Contact No:");
	JLabel lab9=new JLabel("Email:");

	JTextField txtF1 =new JTextField();

	JTextField txtF4 =new JTextField();

	JTextField txtF7 =new JTextField();
	JTextField txtF8 =new JTextField();
	JTextField txtF9 =new JTextField();
	
	JButton btn1 =new JButton("Cancel");
	JButton btn2 =new JButton("Submit");
	String data[] = {"Male", "Female"};

	JComboBox combo =new JComboBox(data);

	public ReceiverSignUp(){

		setContentPane(new JLabel(new ImageIcon("Red Blood_Cells4.jpg")));
		setVisible(true);
		setSize(600,600);
		setLayout(null);
		//combo.setSelectedIndex(1);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		combo.setBounds(200,240,80,20);
		add(combo);
		
		setTitle("Receiver Registration Form");
		//labT.setBackground(Color.yellow);
		//setBackground(Color.green);
		//setForeground(Color.blue);
		labT.setFont(myFont);
		
		labT.setBounds(120,50,350,40);
		add(labT);
		labT.setForeground(Color.white);
		lab1.setBounds(140,130,80,10);
		add(lab1);
		lab1.setForeground(Color.white);
		lab2.setBounds(115,165,80,10);
		add(lab2);
		lab2.setForeground(Color.white);
		lab4.setBounds(150,245,110,10);
		add(lab4);
		lab4.setForeground(Color.white);
		lab7.setBounds(130,200,80,10);
		add(lab7);
		lab7.setForeground(Color.white);
		lab8.setBounds(120,310,80,10);
		add(lab8);
		lab8.setForeground(Color.white);
		lab9.setBounds(150,350,80,10);
		add(lab9);
		lab9.setForeground(Color.white);
		txtF1.setBounds(200,120,170,30);
		add(txtF1);              
		passwordField1.setBounds(200,155,170,30);
		add(passwordField1);              
		
		txtF7.setBounds(200,190,170,30);
		add(txtF7); 
		txtF8.setBounds(200,300,170,30);
		add(txtF8);             
		txtF9.setBounds(200,340,170,30);
		add(txtF9);	
		
		btn1.setBounds(140,440,75,30);
		add(btn1);
		btn1.setForeground(Color.red);
		btn2.setBounds(300,440,75,30);
		add(btn2);
		btn2.setForeground(Color.red);
		btn2.addActionListener(this);
		btn1.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==btn2){
			
			try {

				Class.forName("com.mysql.jdbc.Driver");
				
				stmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();
				String cname = txtF1.getText();
				String pass = passwordField1.getText();
				
				String address = txtF7.getText();
				String email = txtF9.getText();
				String contact = txtF8.getText();
				String gender=combo.getSelectedItem().toString();

				String query = "INSERT INTO `receiver_list`(`Name`,`Password`,`Address`,`Email`,`Contact No`,`Gender`) VALUES ('"+cname+"', '"+pass+"','"+address+"','"+email+"','"+contact+"','"+gender+"')";
				//JOptionPane.showMessageDialog(this, "try block");
				//System.out.println(query);
				if(stmt.executeUpdate(query)==1){
					JOptionPane.showMessageDialog(this, "Successfully Inserted ");

				}
				
				else{
					JOptionPane.showMessageDialog(this, "Failed To Insert");
				}
			}
				catch (Exception ex){
					
					JOptionPane.showMessageDialog(this, "Error");
					  ex.printStackTrace();
				}
			
			
		}

		if (ae.getSource()==btn1){
			
			SignUpAs S = new SignUpAs();
			setVisible(false);
		}

	}
	
	
}