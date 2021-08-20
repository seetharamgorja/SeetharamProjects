package com.csq.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Test;

public class DeleteData {
  @Test
  public void deleteRecentData() throws SQLException, InterruptedException {
	  
		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DAY_OF_MONTH, +0);
		String initiation_Start_Time = sdfTime.format(calendar.getTime());
		

		
		Thread.sleep(4000);
		String dbURL = "jdbc:mysql://192.168.235.23:3306/testdb?useSSL=false";
		String username = "csqdev";
		String password = "Csqdev@123";
		// Load MySQL JDBC Driver
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Creating connection to the database
				Connection connection = DriverManager.getConnection(dbURL, username, password);
				// Creating statement object
				java.sql.Statement st = connection.createStatement();
				//String deleteQuery = "DELETE FROM usrlogin ORDER BY sessionid DESC LIMIT 2 ;";
			//	String deleteQuery="DELETE FROM usracc ORDER BY createdon  LIMIT 1 ;";
				//String deleteQuery="DELETE FROM custsampling ORDER BY createdon  LIMIT 1 ;";
				String deleteQuery="DELETE FROM usrdtl  WHERE accstype='ARP' OR ACCSTYPE='CTO';";
				// updating the SQL Query and store the results in ResultSet
				st.executeUpdate(deleteQuery);

	  
	  
  }
}
