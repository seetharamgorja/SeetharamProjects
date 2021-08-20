package com.audittool.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class TestFlow {

	public static String UatURL = "http://dev.audittool.com/";

	public static String ProductionURL = "http://pena4.audittool.com";

	public static String UserName = "seetharamunaidu.gorja5@pena4tech.com";
	public static String UserTypeName = "utysixx";
	public static String ClientName = "seetharam";
	public static String HSName = "hssixx";
	public static String auditorEmail = "seetharam.auditors@pena4tech.com";
	public static String QAEmail = "seetharam.qas@gmail.com";
	public static String AuditName = "Adtnine";
	public static String PatientType = "INP";
	public static String FirstName = "fnsixx";
	public static String LastName = "lnsixx";
	public static String AuditorPh = "5980893324";
	public static String QAPh = "9808605345";
	public static String CompleteAuditorName = FirstName + " " + LastName + " " + "-" + " " + "Auditor";
	public static String CompleteQAName = FirstName + " " + LastName + " " + "-" + " " + "QA";

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		/*
		 * System.setProperty(
		 * "webdriver.gecko.driver","E:\\Seetharam testing\\geckodriver.exe" );
		 * 
		 * // Initialize Gecko Driver using Desired Capabilities Class
		 * DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		 * capabilities.setCapability("marionette",true); WebDriver driver= new
		 * FirefoxDriver(capabilities);
		 */

		// WebDriver driver = new ChromeDriver();
		// driver.get("http://192.168.116.169:8080/");seetharam gsr - Auditor
		driver.get(UatURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// WebDriverWait wait = new WebDriverWait(driver, 500);
		System.out.println(CompleteAuditorName);

		WebElement email = driver.findElement(By.id("userid"));

		email.sendKeys(UserName);

		// Password Field

		WebElement password = driver.findElement(By.id("userpwd"));

		password.sendKeys("Test@123");

		Thread.sleep(2000);
		driver.findElement(By.id("btnLogin")).click();

		System.out.println("Login Successfully");
		Thread.sleep(6000);

		String title1 = driver.getTitle();
		System.out.println(title1);

		driver.findElement(By.linkText("Admin")).click();

		driver.findElement(By.linkText("User Types")).click();
		// driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("CREATE NEW USER TYPE +")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("utname")).sendKeys(UserTypeName);

		Select sts = new Select(driver.findElement(By.id("status")));
		sts.selectByVisibleText("Active");
		driver.findElement(By.id("btnutCreate")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div/div[1]/div[2]/div/label/input"))
				.sendKeys(UserTypeName);
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("Health Systems")).click(); //
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("CREATE NEW HEALTH SYSTEM +")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("hsname")).sendKeys(HSName);

		Select sts3 = new Select(driver.findElement(By.id("status")));
		sts3.selectByVisibleText("Active");
		driver.findElement(By.id("btnhsCreate")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div/div[1]/div[2]/div/label/input"))
				.sendKeys(HSName);
		Thread.sleep(1500);

		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("Clients")).click();

		driver.findElement(By.linkText("CREATE NEW CLIENT +")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("clientname")).sendKeys(ClientName);
		Thread.sleep(1500);
		Select hsn = new Select(driver.findElement(By.name("hsname")));
		hsn.selectByVisibleText(HSName);
		Select sts2 = new Select(driver.findElement(By.id("status")));
		sts2.selectByVisibleText("Active");
		driver.findElement(By.id("btnclCreate")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div/div[1]/div[2]/div/label/input"))
				.sendKeys(ClientName);
		Thread.sleep(1500);

		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User")).click();
		// driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("CREATE NEW USER +")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("fname")).sendKeys(FirstName);
		driver.findElement(By.id("lname")).sendKeys(LastName);
		driver.findElement(By.id("email")).sendKeys(auditorEmail);
		driver.findElement(By.id("phno")).sendKeys(AuditorPh);
		driver.findElement(By.id("pwd")).sendKeys("Test@123");
		driver.findElement(By.id("cpwd")).sendKeys("Test@123");
		Thread.sleep(500);

		Select role = new Select(driver.findElement(By.id("role")));
		role.selectByVisibleText("Auditor");

		Select status = new Select(driver.findElement(By.id("status")));
		status.selectByVisibleText("Active");
		Select utype = new Select(driver.findElement(By.id("usertype")));
		utype.selectByVisibleText(UserTypeName);
		Select country = new Select(driver.findElement(By.id("countryid")));
		country.selectByVisibleText("United States of America");
		Select state = new Select(driver.findElement(By.id("region")));
		state.selectByIndex(3);
		driver.findElement(By.id("btnCreate")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div/div/div[1]/div[2]/div/label/input"))
				.sendKeys(auditorEmail);

		driver.findElement(By.linkText("CREATE NEW USER +")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("fname")).sendKeys(FirstName);
		driver.findElement(By.id("lname")).sendKeys(LastName);
		driver.findElement(By.id("email")).sendKeys(QAEmail);
		driver.findElement(By.id("phno")).sendKeys(QAPh);
		driver.findElement(By.id("pwd")).sendKeys("Test@123");
		driver.findElement(By.id("cpwd")).sendKeys("Test@123");
		Thread.sleep(500);

		Select role1 = new Select(driver.findElement(By.id("role")));
		role1.selectByVisibleText("QA");

		Select status1 = new Select(driver.findElement(By.id("status")));
		status1.selectByVisibleText("Active");
		Select utype1 = new Select(driver.findElement(By.id("usertype")));
		utype1.selectByVisibleText(UserTypeName);
		Select country1 = new Select(driver.findElement(By.id("countryid")));
		country1.selectByVisibleText("United States of America");
		Select state1 = new Select(driver.findElement(By.id("region")));
		state1.selectByIndex(3);
		driver.findElement(By.id("btnCreate")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div/div/div[1]/div[2]/div/label/input"))
				.sendKeys(QAEmail);

		driver.findElement(By.linkText("Audit")).click();
		driver.findElement(By.linkText("CREATE AUDIT")).click();
		Thread.sleep(1000);
		Select clSelection = new Select(driver.findElement(By.id("ddlclient")));
		clSelection.selectByVisibleText(ClientName);
		driver.findElement(By.id("auditname")).sendKeys(AuditName);
		Thread.sleep(1000);
		Select ptType = new Select(driver.findElement(By.id("ddlpatienttype")));
		ptType.selectByVisibleText("INP");

		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DAY_OF_MONTH, +1);
		String initiation_Start_Time = sdfTime.format(calendar.getTime());

		calendar.add(Calendar.DAY_OF_MONTH, +3);
		String sampling_Start_Time = sdfTime.format(calendar.getTime());
		System.out.println(sampling_Start_Time);
		// driver.findElement(By.id("enddate")).click();
		// WebElement ele=driver.findElement(By.id("enddate"));
		// ele.min="06/21/2021";

		// Date selection..........................................................
		WebElement element = driver.findElement(By.id("enddate"));
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly')", element);
		WebElement newElement = driver.findElement(By.id("enddate"));
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','2021-08-27')", newElement);

		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[1]/input")).click();

		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div/input")).click();

		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div/input")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div/input")).click();

		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[3]/div[1]/div/input")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[3]/div[2]/div/input")).click();

		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]/input[2]"))
				.sendKeys("Tested by Seetharam");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div[2]/input[2]"))
				.sendKeys("testingone");

		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div[3]/input[2]"))
				.sendKeys("testingtwo");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div[4]/input[2]"))
				.sendKeys("testingthree");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div[5]/input[2]"))
				.sendKeys("testingfour");
		driver.findElement(By.id("baserate")).sendKeys("159");
		Thread.sleep(1000);
		Select fileType = new Select(driver.findElement(By.id("ddldatafiletype")));
		fileType.selectByIndex(1);

		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div[3]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click();
		Thread.sleep(4000);
		// driver.findElement(By.name("file")).click();//*[@id="divupload"]/form
		Actions action = new Actions(driver);
		WebElement el = driver.findElement(By.id("file"));

		action.moveToElement(el).click().perform();
		Thread.sleep(1000);
		Runtime.getRuntime().exec("C:\\Users\\GorjaS\\Desktop\\FileUpload.exe");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='divupload']/form/div/input[6]")).click();
		Thread.sleep(15000);

		driver.findElement(By.linkText("Audit")).click();
		driver.findElement(By.linkText("EXISTING AUDIT")).click();
		Thread.sleep(9000);
		Select cl = new Select(driver.findElement(By.id("ddlclient")));
		cl.selectByVisibleText(ClientName);
		Select pt = new Select(driver.findElement(By.id("ddlpatienttype")));
		pt.selectByVisibleText(PatientType);
		Select an = new Select(driver.findElement(By.id("ddlauditname")));
		an.selectByVisibleText(AuditName);
		driver.findElement(By.id("btngetdata")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath(
				"/html/body/div[2]/div/div/div[3]/div/div/div/div/div[2]/div/div/div[2]/table/tbody/tr[1]/td[1]/input"))
				.click();
		driver.findElement(By.id("btn_assign")).click();
		Thread.sleep(3000);
		Select assignTo = new Select(driver.findElement(By.id("ddl_users")));
		assignTo.selectByVisibleText(CompleteAuditorName);
		driver.findElement(By.id("btn_audit_assign")).click();
		driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div/div/div/div/div/div/div[4]/button[1]")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click();

		driver.findElement(By.xpath("/html/body/div[2]/header/nav/div[3]/ul/li/a/span/img")).click();
		driver.findElement(By.xpath("//*[@id='div_logout']")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/center/a[2]")).click();

		Thread.sleep(4000);

		WebElement email2 = driver.findElement(By.id("userid"));

		email2.sendKeys(auditorEmail);

		// Password Field

		WebElement password2 = driver.findElement(By.id("userpwd"));

		password2.sendKeys("Test@123");

		Thread.sleep(2000);
		driver.findElement(By.id("btnLogin")).click();

		System.out.println("Login Successfully");
		Thread.sleep(6000);

		driver.findElement(By.linkText("Audit")).click();
		driver.findElement(By.linkText("EXISTING AUDIT")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='tblauditdata']/tbody/tr/td[11]/a")).click();
		Thread.sleep(5000);

		Select alt0 = new Select(driver.findElement(By.id("ddlDispo")));
		alt0.selectByIndex(1);

		Select alt1 = new Select(driver.findElement(By.id("ddlAttend")));
		alt1.selectByIndex(1);
		Select alt2 = new Select(driver.findElement(By.id("ddlGrouper")));
		alt2.selectByIndex(1);
		Select alt3 = new Select(driver.findElement(By.id("ddlDRG")));
		alt3.selectByIndex(1);
		Select alt4 = new Select(driver.findElement(By.id("ddlDocument1")));
		alt4.selectByIndex(1);
		Select alt5 = new Select(driver.findElement(By.id("ddlDocument2")));
		alt5.selectByIndex(2);
		Select alt6 = new Select(driver.findElement(By.id("ddlDocument3")));
		alt6.selectByIndex(3);
		Select alt7 = new Select(driver.findElement(By.id("ddlDocument4")));
		alt7.selectByIndex(4);
		Select alt8 = new Select(driver.findElement(By.id("ddlDocument5")));
		alt8.selectByIndex(5);

		Thread.sleep(1500);
		Select auditStatus = new Select(driver.findElement(By.id("ddlauditstatus")));
		auditStatus.selectByVisibleText("QA required");
		driver.findElement(By.id("tanotes")).sendKeys("This Audit created for automation purpose by Seetharam...");
		Thread.sleep(5000);
		driver.findElement(By.id("btnSaveAudit")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/header/nav/div[3]/ul/li/a/span/img")).click();
		driver.findElement(By.xpath("//*[@id='div_logout']")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/center/a[2]")).click();

		Thread.sleep(4000);

		WebElement email3 = driver.findElement(By.id("userid"));

		email3.sendKeys(UserName);

// Password Field

		WebElement password3 = driver.findElement(By.id("userpwd"));

		password3.sendKeys("Test@123");

		Thread.sleep(2000);
		driver.findElement(By.id("btnLogin")).click();

		System.out.println("Login Successfully");
		Thread.sleep(6000);
		driver.findElement(By.linkText("Audit")).click();
		driver.findElement(By.linkText("EXISTING AUDIT")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//table[@id='tblauditdata']/tbody/tr[1]/td[1]/input")).click();
		driver.findElement(By.id("btn_assign")).click();
		Thread.sleep(3000);
		Select assignTo2 = new Select(driver.findElement(By.id("ddl_users")));
		assignTo2.selectByVisibleText(CompleteQAName);
		driver.findElement(By.id("btn_audit_assign")).click();
		driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div/div/div/div/div/div/div[4]/button[1]")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click();

		Thread.sleep(8000);
		driver.findElement(By.xpath("/html/body/div[2]/header/nav/div[3]/ul/li/a/span/img")).click();
		driver.findElement(By.xpath("//*[@id='div_logout']")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/center/a[2]")).click();

		Thread.sleep(4000);

		WebElement email4 = driver.findElement(By.id("userid"));

		email4.sendKeys(QAEmail);

// Password Field

		WebElement password4 = driver.findElement(By.id("userpwd"));

		password4.sendKeys("Test@123");

		Thread.sleep(2000);
		driver.findElement(By.id("btnLogin")).click();

		System.out.println("QA Login Successfully");
		Thread.sleep(6000);
		driver.findElement(By.linkText("Audit")).click();
		driver.findElement(By.linkText("EXISTING AUDIT")).click();
		Thread.sleep(9000);

		Select cl1 = new Select(driver.findElement(By.id("ddlclient")));
		cl1.selectByVisibleText(ClientName);
		Select pt1 = new Select(driver.findElement(By.id("ddlpatienttype")));
		pt1.selectByVisibleText(PatientType);
		Select an1 = new Select(driver.findElement(By.id("ddlauditname")));
		an1.selectByVisibleText(AuditName);
		driver.findElement(By.id("btngetdata")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='tblauditdata']/tbody/tr[1]/td[11]/a")).click();

		Thread.sleep(5000);
		Select auditStatus1 = new Select(driver.findElement(By.id("ddlauditstatus")));
		auditStatus1.selectByVisibleText("Completed");
		driver.findElement(By.id("tanotes")).sendKeys("This Audit Reviewed by QA...");
		Thread.sleep(5000);
		driver.findElement(By.id("btnSaveAudit")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("/html/body/div[2]/header/nav/div[3]/ul/li/a/span/img")).click();
		driver.findElement(By.xpath("//*[@id='div_logout']")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/center/a[2]")).click();

	}
}
