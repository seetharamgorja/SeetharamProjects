package com.csq.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AssessmentCycle {

	public WebDriver wait;
	  @Test
	  public void assessmentCycle(WebDriver driver, Properties pr) throws InterruptedException, SQLException {

		driver.findElement(By
				.xpath("//span[@id='__icon0' and @class='hdrMenuIcon sapMBarChild sapUiIcon sapUiIconMirrorInRTL sapUiIconPointer']"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//li[@class='sapUiMnuItm' and @id='workflow']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@id,'__toolbar')]/button")).click();
		
		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DAY_OF_MONTH, +1);
		String initiation_Start_Time = sdfTime.format(calendar.getTime());
		
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String sampling_Start_Time = sdfTime.format(calendar.getTime());

		
		System.out.println(initiation_Start_Time);

		System.out.println(sampling_Start_Time);

	
		
		driver.findElement(By.xpath("//input[@id='initDt-inner']")).sendKeys(initiation_Start_Time);
		driver.findElement(By.xpath("//input[@id='initDuration-inner']")).sendKeys("2");
		driver.findElement(By.xpath("//input[@id='initDt-inner']")).click();
		driver.findElement(By.xpath("//input[@id='assessmentsDuration-inner']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@id='initDt-inner']")).click();
		driver.findElement(By.xpath("//input[@id='totalReminders-inner']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@id='initDt-inner']")).click();
		driver.findElement(By.xpath("//div[@id='addAcDialog-footer']/button")).click();
		
		
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
				String updatequery = "UPDATE assessment_cycle_info SET status ='A' , initiation_date = '" + sampling_Start_Time + "' , sampling_start= '"
						+sampling_Start_Time + "', sampling_end= '"
						+sampling_Start_Time + "', cycle_start= '"
						+sampling_Start_Time + "', sampling_reminder= '"
						+sampling_Start_Time + "' ORDER BY cycle_id DESC LIMIT 1;";
				// updating the SQL Query and store the results in ResultSet
				st.executeUpdate(updatequery);
System.out.println("Assessment cycle updated from database according to our request........................");
	}

}
