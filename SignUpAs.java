import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class SignUpAs extends JFrame implements ActionListener {
	
	JButton btn1 =new JButton("SignUp As Donor");
	JButton btn2 =new JButton("SignUp As Receiver");
	JButton btn3 =new JButton("Back");
	
	public SignUpAs(){
		setContentPane(new JLabel(new ImageIcon("Red Blood_Cells2.jpg")));
		setVisible(true);
		setSize(600,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		btn1.setBounds(100,100,180,60);
		add(btn1);
		btn2.setBounds(300,100,180,60);
		add(btn2);
		btn3.setBounds(2,240,65,30);
		add(btn3);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
	}
	@Override
		public void actionPerformed(ActionEvent e) {
      //  JOptionPane.showMessageDialog(this, "Clicked", "Warning", MessageType.WARNING.ordinal());
	  	if(e.getActionCommand().equals("SignUp As Donor"))
		{
			DonorSignUp w =new DonorSignUp();
			setVisible(false);
		}
		else if(e.getSource()==btn2)
		{
			ReceiverSignUp E = new ReceiverSignUp();
			setVisible(false);
		}
		else if(e.getSource()==btn3)
		{
			BLogin t = new BLogin();
			setVisible(false);
		}
	  
    }
	
	
}