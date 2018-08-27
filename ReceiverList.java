import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import java.awt.event.*;
class ReceiverList extends JFrame implements ActionListener{
	JButton btn1 = new JButton("Back");
	JButton btn2 = new JButton("Delete");
	JTable table;
public ReceiverList(){
		
		Statement st = null;
		ResultSet rs = null;
		String s;

//connect  app to mysql database
	try{
		
		st = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();
		s = "SELECT * FROM `receiver_list` ";
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

			table = new JTable(data,column);
			
			JScrollPane jsp = new JScrollPane(table);
			this.getContentPane().add(jsp);
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

 
		}catch(Exception e){
		   JOptionPane.showMessageDialog(null, "ERROR");
		   e.printStackTrace();
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
		
		setSize(500,520);
		setTitle("Receiver List");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		add(btn1);
		add(btn2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
      
  }
  
  	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()== btn1){
			AdminLogin A = new AdminLogin();
			setVisible(false);
			
		}
		if(ae.getSource()== btn2){
			
			if(table.getSelectedRowCount()==1){ 
				int selectedRow = table.getSelectedRow();
				int selectedColumn = table.getSelectedColumn();                    
				String selectedValue = table.getValueAt(selectedRow, selectedColumn).toString();
				System.out.println(selectedValue);
				System.out.println(selectedColumn);
				//JOptionPane.showMessageDialog(null, selectedRow);
				if(selectedColumn!=0){
					JOptionPane.showMessageDialog(this,"Please Select Name Column Row For Approve Request");
				}
				else{
					try {
							Class.forName("com.mysql.jdbc.Driver");
							Statement stmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();
							
							String query = "UPDATE `receiver_list` SET `Needed Blood Group`=' ' WHERE Name='" +selectedValue+ "'";
							//System.out.println(name);
							if(stmt.executeUpdate(query)==1){
								JOptionPane.showMessageDialog(this, "Approve Request Successfully!");
								
							}else{
								JOptionPane.showMessageDialog(this, "Request Sent Failed");
							}
						}catch(Exception ex){
								
							JOptionPane.showMessageDialog(this, "Error");	  
						}
					}
			}
			
			//setVisible(false);
			
		}

	}
}