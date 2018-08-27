import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
class AdminLogin extends JFrame implements ActionListener{
	
	
	JButton btn1 =new JButton("View Donor List");
	JButton btn2 =new JButton("View Receiver List");
	JButton btn3 =new JButton("Back");
	
	public AdminLogin(){
		setContentPane(new JLabel(new ImageIcon("Red Blood_Cells6.jpg")));
		setTitle("Admin Panel");
		setVisible(true);
		setSize(600,300);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		btn1.setBounds(100,100,180,60);
		add(btn1);
		btn1.setForeground(Color.red);
		btn2.setBounds(300,100,180,60);
		add(btn2);
		btn2.setForeground(Color.red);
		btn3.setBounds(2,240,65,30);
		add(btn3);
		btn3.setForeground(Color.red);
		

		btn3.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
	}
	@Override
		public void actionPerformed(ActionEvent e) {
      //  JOptionPane.showMessageDialog(this, "Clicked", "Warning", MessageType.WARNING.ordinal());
	  	if(e.getActionCommand().equals("View Donor List"))
		{
			DonorList L =new DonorList();
			setVisible(false);
		}
		else if(e.getSource()==btn2)
		{
			ReceiverList k=new ReceiverList();
			setVisible(false);
		}
		else if(e.getSource()==btn3)
		{
			BLogin t = new BLogin();
			setVisible(false);
		}
	  
    }
	
	
}