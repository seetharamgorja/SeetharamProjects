package com.csq.pages;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CustomerSampling {
	public WebDriver wait;
	  @Test
	  public void customerSamplingProcess(WebDriver driver, Properties pr,String Customer1,String Customer2,String Customer1mail,String Customer2mail) throws InterruptedException, SQLException {

		driver.findElement(By
				.xpath("//span[@id='__icon0' and @class='hdrMenuIcon sapMBarChild sapUiIcon sapUiIconMirrorInRTL sapUiIconPointer']"))
				.click();

		driver.findElement(By.xpath("//li[@class='sapUiMnuItm' and @id='customersampling']")).click();
		Thread.sleep(2500);

		driver.findElement(By.xpath("//button[@title='ADD NEW CUSTOMER']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='__box0-inner']")).sendKeys("Forwarder");
		driver.findElement(By.xpath("//input[@id='__input0-inner']")).sendKeys(Customer1);
		driver.findElement(By.xpath("//input[@id='__input1-inner']")).sendKeys(Customer1mail);
		driver.findElement(By.xpath("//input[@id='__input2-inner']")).click();
		driver.findElement(By.xpath("//button[@title='SAVE']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='ADD NEW CUSTOMER']")).click();
		driver.findElement(By.xpath("//input[@id='__box1-inner']")).sendKeys("Forwarder");
		driver.findElement(By.xpath("//input[@id='__input3-inner']")).sendKeys(Customer2);
		driver.findElement(By.xpath("//input[@id='__input4-inner']")).sendKeys(Customer2mail);
		driver.findElement(By.xpath("//input[@id='__input5-inner']")).click();
		driver.findElement(By.xpath("//button[@title='SAVE']")).click();
		Thread.sleep(2000);
		
		
		//Upload customers from excel .........................................................
		
		driver.findElement(By.xpath("//button[@title='UPLOAD FILE']")).click();
		Thread.sleep(1500);
		try {
			driver.findElement(By.xpath("//input[@name='file']"))
					.sendKeys("C:\\Users\\seetharamu\\Desktop\\customers upload.xlsx");
			Thread.sleep(15000);
			System.out.println("Customers uploaded from excel successfully......................");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File Does not upload:" + e);
		}
		

		List<WebElement> li4 = driver.findElements(By.xpath("//div[contains(@id,'-tableCtrlCnt')]/table/tbody/tr/td"));

		List<WebElement> li5 = driver.findElements(By.xpath("//div[contains(@id,'-tableCtrlCnt')]/table/tbody/tr[2]/td"));
		//List<WebElement> li3 = driver.findElements(By.xpath("//div[contains(@id,'-tableCtrlCnt')]/table/tbody/tr[3]/td"));
		System.out.println(li4.get(2).getAttribute("id"));
		
		driver.findElement(By.id(li4.get(2).getAttribute("id"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(li5.get(2).getAttribute("id"))).click();
		Thread.sleep(1000);
		//driver.findElement(By.id(li3.get(2).getAttribute("id"))).click();
		Actions act2 = new Actions(driver);
		act2.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@title='SUBMIT']")).click();
		Thread.sleep(2000);
		
		
	//Customers password updated from DB directly ......................................................	

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
				String updatepassword = "UPDATE testdb.usrdtl SET usrpasswd ='"+"Ezhl+GW0dUflej5CO55Y9Q=="+"' ORDER BY usrid DESC LIMIT 3;";
				// updating the SQL Query and store the results in ResultSet
				st.executeUpdate(updatepassword);
System.out.println("Assessment cycle updated from database according to our request........................");



SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");
Calendar calendar = Calendar.getInstance();

calendar.add(Calendar.DAY_OF_MONTH, +1);
String initiation_Start_Time = sdfTime.format(calendar.getTime());

calendar.add(Calendar.DAY_OF_MONTH, -1);
String cycle_Start_Time = sdfTime.format(calendar.getTime());


System.out.println(initiation_Start_Time);

System.out.println(cycle_Start_Time);


String updateassessmentdatesquery = "UPDATE assessment_cycle_info SET cycle_start = '" + cycle_Start_Time + "' , cycle_end= '"
		+cycle_Start_Time + "', reminder_dates= '"
		+cycle_Start_Time + "' ORDER BY cycle_id DESC LIMIT 1;";
// updating the SQL Query and store the results in ResultSet
st.executeUpdate(updateassessmentdatesquery);


	}
}