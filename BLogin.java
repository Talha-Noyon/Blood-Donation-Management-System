import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

class BLogin extends JFrame implements ActionListener{
	
	
	JButton btn1 = new JButton("SignUp");
	JButton btn2 = new JButton("Login");

	JPanel pane = new JPanel();
	
	Font myFont = new Font("Times New Roman", Font.BOLD,38);
	
	JTextField t =new JTextField(null);
	JPasswordField passwordField1 = new JPasswordField(null);

	JLabel lForm=new JLabel("Login Form");
	JLabel lab1=new JLabel("User Name:");
	JLabel lab2=new JLabel("Password:");
	
	Statement st = null;
	ResultSet rs = null;
	String s,name,pass;
	public BLogin(){
		
		setContentPane(new JLabel(new ImageIcon("Blood_Cells_2k.jpg")));
		//setContentPane(img1=new JLabel(new ImageIcon("lockkeyicon.png")));
		setSize(600,400);
		setVisible(true);
		String un="Admin";
		String pass="Admin";

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Login Form ");
		setResizable(false);
		//setBackground(Color.magenta);
		//.setBackground(new Color(138,7,7));
		//setForeground(Color.decode("#ffffff"));
		lForm.setForeground(Color.white);
		lab1.setForeground(Color.white);
		lab2.setForeground(Color.white);
		btn1.setForeground(Color.red);
		btn2.setForeground(Color.red);
		setLocationRelativeTo(null);
		lForm.setFont(myFont);
		
		lForm.setBounds(155,80,210,45);
		add(lForm);
		lab1.setBounds(100,140,80,10);
		add(lab1);
		lab2.setBounds(100,200,80,10);
		add(lab2);

		
		t.setBounds(180,135,170,30);
		add(t);
		passwordField1.setBounds(180,195,170,30);
		add(passwordField1);

		btn1.setBounds(140,250,80,40);
		add(btn1);
		btn2.setBounds(250,250,80,40);
		add(btn2);
	
		btn2.addActionListener(this);
		btn1.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==btn2){
			System.out.println(passwordField1.getText());
			if(  Info.donorDb(t.getText() , passwordField1.getText())  ){
				
				DonorLogin H =new DonorLogin(t.getText());
				setVisible(false);

			}
			else if(  Info.receiverDb(t.getText() , passwordField1.getText())  ){
				
				ReceiverLogin H =new ReceiverLogin(t.getText());
				setVisible(false);

			}

			else if((t.getText().equals("Admin"))&& (passwordField1.getText().equals("Admin"))){
				
				AdminLogin A = new AdminLogin();
				setVisible(false);
			}
			else if((t.getText().equals(""))&& (passwordField1.getText().equals(""))){
				
					JOptionPane.showMessageDialog(this, "Please Insert Username or Password");
				
				}
			else {

				System.out.println(passwordField1.getText());
                JOptionPane.showMessageDialog(this, "Username or Password incorrect");
			}
			
		}
		
		
		if (ae.getSource()==btn1){
			
			SignUpAs S = new SignUpAs();
			setVisible(false);
		}
	}
	
}