import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import java.awt.event.*;
class DonorListByAddress extends JFrame implements ActionListener{
	JButton btn1 = new JButton("Back");
	String address;
public DonorListByAddress(String addrs){
		
		Statement st = null;
		ResultSet rs = null;
		String s;
		address=addrs;
		
//connect  app to mysql database
	try{
		
		st = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();
		s = "SELECT `Name`,`Address`,`Email`,`Contact No.`,`Gender`,`Donate Blood Group`,`Last Donate Date`FROM `donor_list` WHERE `Address`='"+address+"'";
		rs = st.executeQuery(s);
		ResultSetMetaData rsmt = rs.getMetaData();
		int c = rsmt.getColumnCount();
		Vector column = new Vector(c);
		for(int i = 1; i <= c; i++){

		   column.add(rsmt.getColumnName(i));
		}
		Vector data = new Vector();
		Vector row = new Vector();
		while(rs.next()){

		   row = new Vector(c);
		   for(int i = 1; i <= c; i++){
			   row.add(rs.getString(i));
		   }
		   data.add(row);

		}

			JTable table = new JTable(data,column);
			JScrollPane jsp = new JScrollPane(table);
			
			this.getContentPane().add(jsp);

		}catch(Exception e){
		   JOptionPane.showMessageDialog(null, "ERROR");
	}finally{
	   try{
	   st.close();
	   rs.close();
	   DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").close();
	   }catch(Exception e){
		   JOptionPane.showMessageDialog(null, "ERROR CLOSE");
		}
	}
	
		setVisible(true);
		setSize(600,220);
		setTitle("Donor List");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.getContentPane().add(btn1,BorderLayout.SOUTH);
		btn1.addActionListener(this);
      
  }
  
  	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==btn1){
			BLogin E = new BLogin();
			setVisible(false);
		}
			
		
		
	}	
}