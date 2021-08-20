package com.csq.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Test;

public class ReUpdateCycle {
  @Test
  public void cycleUpdateForAssessment() throws SQLException, InterruptedException {
	  
	  SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DAY_OF_MONTH, 0);
		String initiation_Start_Time = sdfTime.format(calendar.getTime());
		
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String sampling_Start_Time = sdfTime.format(calendar.getTime());

		
		System.out.println(initiation_Start_Time);//Current date

		System.out.println(sampling_Start_Time);//day before date

		
		
		//Connect to database and change the dates directly form DB	
		
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
						String updatequery = "UPDATE assessment_cycle_info SET initiation_date = '" + sampling_Start_Time + "' , sampling_start= '"
								+sampling_Start_Time + "', sampling_end= '"
								+sampling_Start_Time + "', cycle_start= '"
								+initiation_Start_Time + "', cycle_end= '"
								+initiation_Start_Time + "' ORDER BY cycle_id DESC LIMIT 1;";
						// updating the SQL Query and store the results in ResultSet
						st.executeUpdate(updatequery);
		System.out.println("Assessment cycle updated from database according to our request........................");
			}
	  
 

}