package com.roi.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	public static String URL = "http://uat.p4staffingroi.com/";

	public static String UserName = "testingteam@pena4tech.com";
	public static String FirstName = "testinggg";
	public static String LastName = "user";
	public static String Email = "automation@gmail.com";
	public static String Password = "Support@123";
	public static String Industry = "AUTOMATIONNNN";
	public static String PositionCategory = "ten";
	public static String Position = "eleven";
	public static String SubPosition = "fifteen";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new ChromeDriver();
		// driver.get("http://192.168.116.169:8080/");
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 500);

		WebElement email = driver.findElement(By.id("login"));

		email.sendKeys(UserName);

		// Password Field

		WebElement password = driver.findElement(By.id("Password"));

		password.sendKeys("Pena4@123");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		System.out.println("Login Successfully");
		Thread.sleep(6000);
		
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		 driver.findElement(By.linkText("Admin")).click(); 
		 Thread.sleep(2000);
		  driver.findElement(By.linkText("Users")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//*[@id='user_table_filter']/label/input")).sendKeys("testonee@gmail.com");
		
		driver.findElement(By.xpath("/html/body/div/div/section[2]/div/div[2]/div/table/tbody/tr[1]/td[1]")).click();
		//driver.findElement(By.xpath("//a[contains(@href='/Account/EditUser/')]")).click();
		//wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@alt='Edit']"))).click();
		WebElement m = driver.findElement(By.xpath("//a[@alt='Edit']"));
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
	      jse.executeScript("arguments[0].click();", m);
		
		
		/*
		 * driver.findElement(By.linkText("Admin")).click(); Thread.sleep(2000);
		 * driver.findElement(By.linkText("Campaign Template")).click();
		 * Thread.sleep(4000); driver.findElement(By.linkText("Create New")).click();
		 * Thread.sleep(50000); WebElement iframe=driver.findElement(By.xpath(
		 * "//div[@id='Create_form']/div[2]/div/div/div/div/div/iframe"));
		 * 
		 * driver.switchTo().frame(iframe); driver.findElement(By.xpath(
		 * "//div[@id='Create_form']/div[2]/div/div/div/div/div/iframe/html/body")).
		 * sendKeys("jjfkekek");
		 */
		
		driver.findElement(By.linkText("Campaigns")).click();
		Thread.sleep(6000);
		
		
		
		
		
		driver.findElement(By.linkText("Create New")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id='create_form']/div/div[3]/div[3]/div/div/button")).click();
		driver.findElement(By.xpath("/html/body/div/div/section[2]/div/form/div/div[3]/div[3]/div/div/ul/li[1]/div/input")).sendKeys("Banking");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div/section[2]/div/form/div/div[3]/div[3]/div/div/ul/li[2]/a/label/input")).click();
		
		driver.findElement(By.xpath("//table[@id='Campaigns_table']/tbody//tr[1]/td[2]/a")).click();
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("/html/body/div/div/section[2]/div/div[1]/p/i[1]")).click();
		Thread.sleep(6000);
		Select clientSelection = new Select(driver.findElement(By.id("client_1")));
		clientSelection.selectByIndex(2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='count1']/div[2]/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("/html/body/div/div/section[2]/div/div[3]/div[2]/div[2]/div/div/ul/li[3]/a/label/input"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='count1']/div[3]/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("/html/body/div/div/section[2]/div/div[3]/div[2]/div[3]/div/div/ul/li[4]/a/label/input"))
				.click();
		Thread.sleep(1500);
		driver.findElement(By.id("link_submit")).click();
		 
		Thread.sleep(15000);
		driver.findElement(By.xpath("/html/body/div/div/section[2]/div/div[2]/div[1]/div[8]/div[2]/table/tbody/tr[1]/td[3]/button")).click();
		
		Thread.sleep(15000);
		
		
		Select opSelection = new Select(driver.findElement(By.id("CompanyName_C")));
		opSelection.selectByIndex(3);
		Select posiSelection = new Select(driver.findElement(By.id("CompanyName_C")));
		posiSelection.selectByIndex(3);
		
		driver.findElement(By.xpath("//div[@id='email_table_data']/table/tbody//tr[1]/td[2]")).click();
		
		
		
		
		
		
		///html/body/div/div/section[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/a
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(2000);

		// Create contact driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();

		driver.findElement(By.id("FirstName_C")).sendKeys("contact");
		driver.findElement(By.id("LastName_C")).sendKeys("one");

		driver.findElement(By.xpath("/html/body/div/div/section[2]/div/div[2]/div[4]/div[3]/div/div/button")).click();
		Thread.sleep(1000);
		List<WebElement> bbbcc = driver.findElements(
				By.xpath("/html/body/div/div/section[2]/div/div[2]/div[4]/div[3]/div/div/ul/li[15]/a/label"));

		bbbcc.get(0).click();

		driver.findElement(By.id("Title_C")).sendKeys("Mr.");
		driver.findElement(By.id("Department_C")).sendKeys("QA");
		driver.findElement(By.id("Phone_C")).sendKeys("9876543212");
		driver.findElement(By.id("Email_C")).sendKeys("contactss@gmail.com");
		driver.findElement(By.id("StreetAddress_C")).sendKeys("mvp");
		driver.findElement(By.id("City_C")).sendKeys("vizag");
		driver.findElement(By.id("Zip_C")).sendKeys("555436");
		driver.findElement(By.id("Mobile_C")).sendKeys("9878909876");

		Select cpn = new Select(driver.findElement(By.id("CompanyName_C")));
		cpn.selectByIndex(3);
		Select rpt = new Select(driver.findElement(By.id("ReportTo_C")));
		rpt.selectByIndex(2);
		Select state = new Select(driver.findElement(By.id("State_C")));
		state.selectByIndex(2);
		Select country = new Select(driver.findElement(By.id("Country_C")));
		country.selectByVisibleText("US");
		Select db = new Select(driver.findElement(By.id("ContactSource_C")));
		db.selectByIndex(1);
		Select owner = new Select(driver.findElement(By.id("Pena4Owner_C")));
		owner.selectByIndex(2);
		Select status = new Select(driver.findElement(By.id("Status_C")));
		status.selectByIndex(1);
		Thread.sleep(1000);
		driver.findElement(By.id("Save")).click();

		Thread.sleep(3000);

		/*
		 * driver.findElement(By.linkText("Leads")).click(); Thread.sleep(3000);
		 * driver.findElement(By.xpath(
		 * "/html/body/div/div/section[2]/div/div[2]/div[2]/div[2]/label/input")).
		 * sendKeys("testingleadone");
		 * driver.findElement(By.linkText("testingleadone")).click();
		 * Thread.sleep(1500);
		 * driver.findElement(By.linkText("Revenue Projections")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.linkText("Description, Plan, Next Step & Update")).
		 * click(); Thread.sleep(2000);
		 * driver.findElement(By.linkText("Convert")).click();
		 * 
		 * driver.findElement(By.id("conver_leads")).click(); Thread.sleep(4000);
		 * driver.findElement(By.id("btnNexttab1")).click();
		 * driver.findElement(By.id("btnNexttab2")).click();
		 * driver.findElement(By.id("Description_C")).
		 * sendKeys("This potentails converted from existing lead...");
		 * Thread.sleep(1000); driver.findElement(By.id("btnSavePotential")).click();
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * // Check box /
		 * 
		 * 
		 * WebDriverWait wait1 = new WebDriverWait(driver, 500);
		 * 
		 * By PositionsMenu = By.linkText("Positions"); By PositionsCategoryMenu =
		 * By.linkText("Position Category"); By createnew = By.linkText("Create New");
		 * 
		 * By pcName = By.name("SectorName"); By submitcategory =
		 * By.xpath("/html/body/div/div/section[2]/div/div[2]/div/div/form/div[2]/input"
		 * );
		 * 
		 * By positionsubMenu = By.linkText("Position"); By pcDrop =
		 * By.name("SectorId"); By positionName = By.name("ServiceDomain");
		 * 
		 * 
		 * // Submit // //
		 * button.......................................................................
		 * // ............................... SimpleDateFormat sdfTime = new
		 * SimpleDateFormat("yyyy-MM-dd"); Calendar calendar = Calendar.getInstance();
		 * 
		 * calendar.add(Calendar.DAY_OF_MONTH, +1); String initiation_Start_Time =
		 * sdfTime.format(calendar.getTime());
		 * 
		 * calendar.add(Calendar.DAY_OF_MONTH, -1); String sampling_Start_Time =
		 * sdfTime.format(calendar.getTime());
		 * 
		 * System.out.println(initiation_Start_Time);
		 * 
		 * System.out.println(sampling_Start_Time);
		 * 
		 * WebDriverWait wait2 = new WebDriverWait(driver, 5000);
		 * 
		 * // driver.findElement(By.linkText("Admin")).click(); Thread.sleep(1000);
		 * 
		 * 
		 * driver.findElement(By.linkText("Leads")).click();
		 * 
		 * driver.findElement(By.linkText("Create Lead")).click();
		 * driver.findElement(By.id("Lead_Name")).sendKeys("testlead");
		 * 
		 * Select one = new Select(driver.findElement(By.id("Pena4_Owner")));
		 * one.selectByIndex(2); Select two = new
		 * Select(driver.findElement(By.id("Company_Name"))); two.selectByIndex(5);
		 * Select three = new Select(driver.findElement(By.id("Lead_Source")));
		 * three.selectByIndex(2); Select four = new
		 * Select(driver.findElement(By.id("State"))); four.selectByIndex(2); Select
		 * five = new Select(driver.findElement(By.id("Industry")));
		 * five.selectByIndex(2); Select six = new
		 * Select(driver.findElement(By.id("Contactname"))); six.selectByIndex(1);
		 * Select seven = new Select(driver.findElement(By.id("Campaign")));
		 * seven.selectByIndex(2); Select eight = new
		 * Select(driver.findElement(By.id("Interest_Products_Services")));
		 * eight.selectByIndex(1); Select nine = new
		 * Select(driver.findElement(By.id("New_Business_Category")));
		 * nine.selectByIndex(2); Select ten = new
		 * Select(driver.findElement(By.id("Status"))); ten.selectByIndex(2); Select
		 * eleven = new Select(driver.findElement(By.id("stages")));
		 * eleven.selectByIndex(2);
		 * 
		 * Thread.sleep(2000);
		 * 
		 * try {
		 * driver.findElement(By.xpath("//input[@id='Date_First_Contact']")).sendKeys(
		 * initiation_Start_Time); driver.findElement(By.xpath(
		 * "//table[@class='table-condensed']/tbody/tr[3]/td[3]")).click();
		 * 
		 * //
		 * driver.findElement(By.id("Date_First_Contact")).sendKeys(sampling_Start_Time)
		 * ; } catch (Exception e) { System.out.println(e); }
		 * driver.findElement(By.xpath(
		 * "//*[@id='GeneralInformation']/div[3]/div/div/button")).click();
		 * Thread.sleep(1000); List<WebElement> bbcc = driver.findElements(By.xpath(
		 * "/html/body/div/div/section[2]/div/div[2]/form/div/div/div/div[1]/div[3]/div[1]/div/ul/li[4]/a/label/input"
		 * ));
		 * 
		 * bbcc.get(0).click(); driver.findElement(By.xpath(
		 * "//*[@id='GeneralInformation']/div[2]/div[4]/div/button")).click();
		 * Thread.sleep(1000); List<WebElement> bbccd = driver.findElements(By.xpath(
		 * "/html/body/div/div/section[2]/div/div[2]/form/div/div/div/div[1]/div[2]/div[4]/div/ul/li[2]/a/label/input"
		 * ));
		 * 
		 * bbccd.get(0).click();
		 * driver.findElement(By.id("Year_Identified")).sendKeys("2020");
		 * driver.findElement(By.id("btnNexttab1")).click();
		 * 
		 * 
		 * driver.findElement(By.linkText("Campaigns")).click();
		 * driver.findElement(By.linkText("Create New")).click(); Thread.sleep(3000);
		 * //driver.findElement(By.id("CampaignName")).sendKeys("CampaignName");
		 * driver.findElement(By.id("TargetGenericTitle")).sendKeys("CampaignName");
		 * 
		 * driver.findElement(By.id("ActualPositionTitle")).sendKeys("CampaignName");
		 * try {
		 * 
		 * driver.findElement(By.xpath("//input[@id='DateAssigned']")).sendKeys(
		 * sampling_Start_Time);
		 * 
		 * } catch (Exception e) {
		 * System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr" +
		 * e); }
		 * 
		 * Select se = new Select(driver.findElement(By.id("FocusId")));
		 * se.selectByIndex(4); driver.findElement(By.xpath(
		 * "//*[@id='create_form']/div/div[2]/div/div[1]/div/button")).click();
		 * Thread.sleep(1000); // driver.findElement(By.xpath(
		 * "/html/body/div/div/section[2]/div/form/div/div[1]/div[3]/div/div/ul/li[1]/div/input"
		 * )).sendKeys("HR");
		 * 
		 * List<WebElement> ba = driver.findElements( By.xpath(
		 * "/html/body/div/div/section[2]/div/form/div/div[2]/div[1]/div/div/ul/li/a/label/input"
		 * ));
		 * 
		 * ba.get(1).click();
		 * 
		 * Select s = new Select(driver.findElement(By.id("branchid")));
		 * s.selectByIndex(5); Select see = new
		 * Select(driver.findElement(By.id("GeographicLocationid")));
		 * see.selectByIndex(2); driver.findElement(By.xpath(
		 * "//*[@id='create_form']/div/div[2]/div[2]/div/div/button")).click();
		 * Thread.sleep(1000); List<WebElement> bb = driver.findElements( By.xpath(
		 * "/html/body/div/div/section[2]/div/form/div/div[2]/div[2]/div/div/ul/li/a/label/input"
		 * ));
		 * 
		 * bb.get(3).click(); driver.findElement(By.xpath(
		 * "//*[@id=\"create_form\"]/div/div[4]/div[3]/div/div/button")).click();
		 * Thread.sleep(1000); List<WebElement> bc = driver.findElements( By.xpath(
		 * "/html/body/div/div/section[2]/div/form/div/div[4]/div[3]/div/div/ul/li/a/label/input"
		 * )); bc.get(4).click();
		 * 
		 * driver.findElement(By.id("NumberofContacts")).sendKeys("8");
		 * driver.findElement(By.id("Contacted")).sendKeys("4");
		 * 
		 * 
		 * for(WebElement element : ba) { if(!element.getText().equals("IT")) {
		 * System.out.println("Functions: " + element.getText()); element.click(); } }
		 * 
		 * // driver.findElement(By.xpath(
		 * "/html/body/div/div/section[2]/div/form/div/div[1]/div[3]/div/div/ul/li[13]/a/label/input"
		 * )).click();
		 * 
		 * 
		 * Select se1=new Select(driver.findElement(By.id("ProductsServicesid")));
		 * se1.selectByIndex(3); Select se2=new
		 * Select(driver.findElement(By.id("ContactDatabases"))); se2.selectByIndex(1);
		 * 
		 * 
		 * 
		 * Select se4=new Select(driver.findElement(By.id("AssignedTo")));
		 * se4.selectByIndex(2);
		 * 
		 * 
		 * Select se6 = new
		 * Select(driver.findElement(By.id("LinktoMarketingCampaignid")));
		 * se6.selectByIndex(1); Select se5 = new
		 * Select(driver.findElement(By.id("Pena4Owner")));
		 * se5.selectByVisibleText("TestingQA");
		 * 
		 * Select se7 = new Select(driver.findElement(By.id("CampaignStatus")));
		 * se7.selectByIndex(1);
		 * 
		 * driver.findElement(By.xpath("//*[@id='form_create']")).click();
		 * Thread.sleep(4000);
		 * 
		 * driver.findElement(By.linkText("Secret Passcode")).click();
		 * Thread.sleep(600); driver.findElement(By.xpath(
		 * "/html/body/div/div/section[2]/div/div[2]/div[2]/form/div/div[2]/input")).
		 * click(); driver.findElement(By.id("SetSecretPasscode")).sendKeys("1111");
		 * driver.findElement(By.xpath(
		 * "/html/body/div/div/section[2]/div/div[2]/div/form/div/div[3]/input")).click(
		 * ); Thread.sleep(1000);
		 * 
		 * driver.findElement(By.linkText("Stages")).click(); Thread.sleep(2000);
		 * 
		 * driver.findElement(By.linkText("Create New")).click(); Thread.sleep(500);
		 * driver.findElement(By.id("txtStageName_C")).sendKeys("stage twww");
		 * Thread.sleep(500);
		 * 
		 * driver.findElement(By.id("txtCurrentProb_C")).sendKeys("85");
		 * Thread.sleep(500);
		 * 
		 * driver.findElement(By.id("btnStageSave")).click(); Thread.sleep(2000);
		 * 
		 * driver.findElement(By.linkText("Reference Tables")).click();
		 * Thread.sleep(2000);
		 * 
		 * Select list1 = new Select(driver.findElement(By.id("PageName")));
		 * list1.selectByVisibleText("Company Type"); Thread.sleep(500);
		 * driver.findElement(By.xpath(
		 * "/html/body/div/div/section[2]/div/div[4]/form/div[2]/input")).click();
		 * Thread.sleep(1000); driver.findElement(By.linkText("Create New")).click();
		 * Thread.sleep(500);
		 * driver.findElement(By.id("create_title")).sendKeys("company type fie");
		 * Thread.sleep(500);
		 * 
		 * driver.findElement(By.id("create_buttion")).click(); Thread.sleep(3000);
		 * Select list2 = new Select(driver.findElement(By.id("PageName")));
		 * list2.selectByVisibleText("Credentials"); Thread.sleep(500);
		 * driver.findElement(By.xpath(
		 * "/html/body/div/div/section[2]/div/div[4]/form/div[2]/input")).click();
		 * Thread.sleep(1000); driver.findElement(By.linkText("Create New")).click();
		 * Thread.sleep(500);
		 * driver.findElement(By.id("create_title")).sendKeys("credentilas forrr");
		 * Thread.sleep(500);
		 * 
		 * driver.findElement(By.id("create_buttion")).click(); Thread.sleep(3000);
		 * 
		 * Select list3 = new Select(driver.findElement(By.id("PageName")));
		 * list3.selectByVisibleText("Contact Databases"); Thread.sleep(500);
		 * driver.findElement(By.xpath(
		 * "/html/body/div/div/section[2]/div/div[4]/form/div[2]/input")).click();
		 * Thread.sleep(1000); driver.findElement(By.linkText("Create New")).click();
		 * Thread.sleep(500);
		 * driver.findElement(By.id("create_title")).sendKeys("test databaseone");
		 * Thread.sleep(500);
		 * 
		 * driver.findElement(By.id("create_buttion")).click(); Thread.sleep(2000);
		 * 
		 * driver.findElement(By.linkText("Companies")).click(); Thread.sleep(1500);
		 * driver.findElement(By.linkText("Create Company")).click();
		 * Thread.sleep(1500);
		 * 
		 * driver.findElement(By.id("CompanyName")).sendKeys("test company five");
		 * 
		 * driver.findElement(By.id("AliasName")).sendKeys("alias one");
		 * driver.findElement(By.id("CompanyZip")).sendKeys("54345");
		 * driver.findElement(By.id("CompanyStreet")).sendKeys("mvp");
		 * driver.findElement(By.id("CompanyCity")).sendKeys("vizag");
		 * driver.findElement(By.id("CompanyPhone")).sendKeys("9874385812");
		 * driver.findElement(By.id("CompanyWebsite")).sendKeys("www.google.com");
		 * 
		 * Select cmtype = new Select(driver.findElement(By.id("CompanyType")));
		 * cmtype.selectByVisibleText("companytypefour"); Thread.sleep(500); Select
		 * cmstate = new Select(driver.findElement(By.id("CompanyState")));
		 * cmstate.selectByIndex(3); Thread.sleep(500); Select country1 = new
		 * Select(driver.findElement(By.id("CompanyCountry")));
		 * country1.selectByVisibleText("US"); Thread.sleep(500); Select owner1 = new
		 * Select(driver.findElement(By.id("Pena4Owner")));
		 * owner1.selectByVisibleText("TestingQA"); Thread.sleep(500);
		 * 
		 * Select status1 = new Select(driver.findElement(By.id("Status")));
		 * status1.selectByVisibleText("Active"); Thread.sleep(500);
		 * 
		 * driver.findElement(By.xpath(
		 * "/html/body/div/div/section[2]/div/div[2]/form/div[7]/div/div/input")).click(
		 * ); Thread.sleep(2000);
		 * 
		 * driver.findElement(By.linkText("Positions")).click(); Thread.sleep(1000);
		 * 
		 * WebDriverWait wait3 = new WebDriverWait(driver, 75);
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * linkText("Create New"))).click(); Thread.sleep(2000);
		 * 
		 * driver.findElement(By.xpath(
		 * "/html/body/div/div/section[2]/div/div[2]/form/div[1]/div[1]/div/label/button"
		 * )) .click(); Thread.sleep(1000);
		 * driver.findElement(By.id("SectorName")).sendKeys("Test industry d");
		 * driver.findElement(By.xpath(
		 * "/html/body/div[1]/div/section[2]/div/div[2]/div/div/div/div/div[3]/button[2]"
		 * )) .click(); Thread.sleep(1500);
		 * driver.findElement(By.id("sdomain_id")).click(); Thread.sleep(1500);
		 * 
		 * driver.findElement(By.id("ServiceDomain")).sendKeys("Test department c");
		 * driver.findElement(By.xpath(
		 * "/html/body/div[1]/div/section[2]/div/div[2]/div/div/div/div/div[3]/button[2]"
		 * )) .click(); Thread.sleep(1500);
		 * 
		 * driver.findElement(By.id("pmaster_id")).click(); Thread.sleep(1500);
		 * driver.findElement(By.id("PositionName")).sendKeys("Test position a");
		 * driver.findElement(By.xpath(
		 * "/html/body/div[1]/div/section[2]/div/div[2]/div/div/div/div/div[3]/button[2]"
		 * )) .click(); Thread.sleep(1500);
		 * 
		 * driver.findElement(By.id("alias_show_button")).click(); Thread.sleep(1500);
		 * driver.findElement(By.id("position_name")).sendKeys("Test positionalias a");
		 * driver.findElement(By.id("add")).click(); Thread.sleep(2000);
		 * driver.findElement(By.xpath(
		 * "/html/body/div[1]/div/section[2]/div/div[3]/div/div/div[1]/button")).click()
		 * ;
		 * 
		 * driver.findElement(By.linkText("Roles and Privileges")).click();
		 * Thread.sleep(3000);
		 * 
		 * driver.findElement(By.xpath(
		 * "/html/body/div/div/section[2]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[4]/a"
		 * )) .click(); driver.findElement(By.id("roles_privilege_submit"));
		 * driver.findElement(By.linkText("Opportunities"));
		 * 
		 * List<WebElement> count1 = driver.findElements(By.xpath(
		 * "/html/body/div[1]/div/section[2]/div/div[3]/div/div/div[2]/div/div/div/div[1]/table/thead/tr/th"
		 * )); System.out.println(count1.size()); driver.findElement(By.xpath(
		 * "/html/body/div[1]/div/section[2]/div/div[3]/div/div/div[2]/div/div/div/div[1]/table/thead/tr/th[3]/center[2]/input"
		 * ));
		 * 
		 * driver.findElement(By.xpath(
		 * "/html/body/div[1]/div/section[2]/div/div[3]/div/div/div[2]/div/div/div/div[1]/table/thead/tr/th[2]/center[2]/input"
		 * )); driver.findElement(By.xpath(
		 * "/html/body/div[1]/div/section[2]/div/div[3]/div/div/div[2]/div/div/div/div[1]/table/thead/tr/th[4]/center[2]/input"
		 * ));
		 * 
		 * driver.findElement(By.linkText("Opportunities"));
		 * 
		 * count1.get(2).click(); count1.get(1).click(); count1.get(3).click();
		 * 
		 * count1.get(4).click();
		 * 
		 * driver.findElement(By.linkText("Clients")).click();
		 * 
		 * Thread.sleep(1000); Select pagecount = new
		 * Select(driver.findElement(By.name("user_table_length")));
		 * pagecount.selectByValue("50"); Thread.sleep(3000); List<WebElement> count =
		 * driver.findElements(By.xpath("//table[@id='user_table']/tbody/tr"));
		 * System.out.println(count.size());
		 * driver.findElement(By.id("client_status_id")).click(); Thread.sleep(3000);
		 * Select pagecount1 = new
		 * Select(driver.findElement(By.name("user_table_length")));
		 * pagecount1.selectByValue("50");
		 * 
		 * Thread.sleep(3000);
		 * 
		 * List<WebElement> countt =
		 * driver.findElements(By.xpath("//table[@id='user_table']/tbody/tr"));
		 * System.out.println(countt.size());
		 * 
		 * driver.findElement(By.id("client_status_id")).click(); Thread.sleep(1500);
		 * 
		 * driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li/a/img")).
		 * click();
		 * 
		 * driver.findElement(By.xpath(
		 * "/html/body/div/header/nav/div/ul/li/ul/li/form/input[1]")).click();
		 * 
		 * driver.findElement(By.linkText("ROI Calculator")).click();
		 * Thread.sleep(4000);
		 * 
		 * driver.findElement(By.id("getroi")).click();
		 * 
		 * Thread.sleep(6000);
		 * 
		 * List<WebElement> rows1 =
		 * driver.findElements(By.xpath("//*[@class='roi-blk']/center/label"));
		 * 
		 * System.out.println(rows1.size());
		 * 
		 * Iterator<WebElement> clickElement = rows1.iterator(); while
		 * (clickElement.hasNext()) { clickElement.next().click(); Thread.sleep(1000); }
		 * Thread.sleep(2000);
		 * 
		 * driver.findElement(By.xpath("//*[@id='largeModal']/div/div/div[1]/button")).
		 * click(); Thread.sleep(2000);
		 * 
		 * driver.findElement(By.linkText("Reports")).click(); Thread.sleep(2000);
		 * 
		 * driver.findElement(By.linkText("Client Report")).click(); Thread.sleep(2000);
		 * 
		 * Select cust = new Select(driver.findElement(By.id("Customer")));
		 * cust.selectByVisibleText("AUTOMATIONQE"); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//input[@value='Search']")).click();
		 * Thread.sleep(7000); List<WebElement> rows =
		 * driver.findElements(By.xpath("//*[@id='starting_divs']/table[4]/tbody/tr"));
		 * 
		 * System.out.println(rows.size());
		 * 
		 * if (rows.size() == 1) { System.out.println("Test case passed.........");
		 * 
		 * } else { System.out.println("Failed....."); }
		 * 
		 * driver.findElement(By.linkText("ROI Calculator")).click();
		 * Thread.sleep(4000);
		 * 
		 * driver.findElement(By.id("getroi")).click();
		 * 
		 * Thread.sleep(000);
		 * 
		 * Select abc = new Select(driver.findElement(By.id("CustomerId")));
		 * abc.selectByIndex(3);
		 * 
		 * driver.findElement(By.linkText("Clients")).click();
		 * driver.findElement(By.linkText("Create New")).click();
		 * 
		 * Thread.sleep(600);
		 * 
		 * Select sell = new Select(driver.findElement(By.id("Title")));
		 * sell.selectByIndex(2);
		 * driver.findElement(By.id("FirstName")).sendKeys("abc");
		 * driver.findElement(By.id("LastName")).sendKeys("def");
		 * driver.findElement(By.id("designation")).sendKeys("ghi");
		 * 
		 * Select sell2 = new Select(driver.findElement(By.id("Industry")));
		 * sell2.selectByIndex(2);
		 * 
		 * driver.findElement(By.id("Company")).sendKeys("Cone");
		 * driver.findElement(By.id("Alias")).sendKeys("fsdhaf");
		 * 
		 * Select sell3 = new Select(driver.findElement(By.id("Region")));
		 * sell3.selectByIndex(2);
		 * 
		 * driver.findElement(By.id("EmailAdddress")).sendKeys("abcdefgh@gmail.com");
		 * driver.findElement(By.id("WebAdddress")).sendKeys("www.abcdefghgmail.com");
		 * 
		 * driver.findElement(By.linkText("Positions")).click();
		 * driver.findElement(By.linkText("Position Category")).click();
		 * driver.findElement(By.linkText("Create New")).click(); Thread.sleep(2000);
		 * driver.findElement(By.name("SectorName")).sendKeys("zxcvbn");
		 * driver.findElement(By.xpath("//input[@value='Create']")).click();
		 * Thread.sleep(5000);
		 * 
		 * // driver.findElement(By.xpath("//*[@id='toggleElement']/span[1]")).click();
		 * Select sel = new
		 * Select(driver.findElement(By.xpath("//*[@id='toggleElement']/select")));
		 * sel.selectByIndex(3);
		 * 
		 * Select sel1 = new
		 * Select(driver.findElement(By.xpath("//*[@id='servicecategory']/select")));
		 * sel1.selectByVisibleText("ap"); Select sel2 = new
		 * Select(driver.findElement(By.xpath("//*[@id='jobpositionId']/select")));
		 * sel2.selectByVisibleText("ap");
		 * 
		 * driver.findElement(By.id("MinExp")).sendKeys("23"); //driver.quit();
		 */ }
}
