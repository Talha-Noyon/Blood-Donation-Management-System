import java.awt.*;
import javax.swing.*;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import java.util.Objects;
import java.awt.event.*;
class Info extends JFrame{
	 
	static boolean donorDb(String name, String password) {

        try {
			Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();
            String query = "SELECT Name FROM `donor_list` WHERE Name='" + name + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()) return false;
            else rs = stmt.executeQuery("SELECT Password FROM `donor_list` WHERE Name='" + name + "'");
            rs.next();
            System.out.println(rs.getString(1));
            return Objects.equals(rs.getString(1), password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        } 
        return false;
    } 
	static boolean receiverDb(String name, String password) {

        try {
			Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","").createStatement();
            String query = "SELECT Name FROM `receiver_list` WHERE Name='" + name + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()) return false;
            else rs = stmt.executeQuery("SELECT Password FROM `receiver_list` WHERE Name='" + name + "'");
            rs.next();
            System.out.println(rs.getString(1));
            return Objects.equals(rs.getString(1), password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        } 
        return false;
    }
  
}