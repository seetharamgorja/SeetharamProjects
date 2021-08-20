package com.csq.suites;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.csq.pages.AdminApprove;
import com.csq.pages.AssessmentCycle;
import com.csq.pages.AssessmentProcess;
import com.csq.pages.LoginToCsq;
import com.csq.pages.ReUpdateCycle;
import com.csq.pages.RegisterCTOs;
import com.csq.pages.RegistrationProcess;
import com.csq.pages.ServerReload;
import com.csq.pages.CustomerSampling;
import com.google.common.collect.ImmutableMap;

public class HomeCsq {

	// Before going to run this,we need to change the below data and excel sheet
	// (Register ctos & upload customers in xml ) also.

	public String Arpmail = "Airportuser001@gmail.com";
	public String Ctomail = "selfctouser1@gmail.com";
	public String ArpUserName = "ARP_USER1";
	public String CtoUserName = "SELF_CTO1";
	public String AdminUserName = "ADMIN";
	public String password = "P@ssw0rd";
	public String CtoCode = "TESTCTO001";
	public String CtoName = "TESTCTO00A";
	public String Customer1 = "seetharamug@prospectatech.com";
	public String Customer2 = "rajeshg@prospectatech.com";
	public String Customer1mail = "testcustomer1@gmail.com";
	public String Customer2mail = "testcustomer2@gmail.com";

	public String Airport = "//div[contains(@class,'sapMPopoverScroll')]/ul/li[4]";

	public WebDriver driver;
	WebDriverWait wait;
	List<Map<String, String>> registration = new ArrayList<>();
	Properties pr = new Properties();

	@BeforeTest
	public void addData() throws IOException, InterruptedException {
		registration.add(ImmutableMap.of("userType", "Airport", "userName", ArpUserName));
		registration.add(ImmutableMap.of("userType", "CTO", "userName", CtoUserName));
		registration.add(ImmutableMap.of("userType", "ADMIN", "userName", AdminUserName));
		FileInputStream ip = new FileInputStream(
				"D:/Udemy_SeleniumClasses/eBrokerTest/src/test/resources/eBroker.properties");
		pr.load(ip);

		String browserName = pr.getProperty("browser");

		if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Udemy_SeleniumClasses\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();

			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));

			driver = new ChromeDriver(capabilities);
			driver.manage().deleteAllCookies();

			// driver = new ChromeDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Udemy_SeleniumClasses\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://192.168.235.76:9080/csq/login");

	}

	@Test(priority = 1, description = "Registeration process for Airport user and CTO user")
	public void registrationTest() throws IOException, InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.linkText("REGISTRATION")).click();
		Thread.sleep(2000);

		for (Map<String, String> map : registration) {
			RegistrationProcess eb = new RegistrationProcess();
			eb.register(map.get("userType"), driver, Arpmail, Ctomail, Airport, CtoCode, CtoName);
			Thread.sleep(3000);
		}
	}
	@Test(priority = 2, description = "Access provided to newly created users by Admin from requests page")
	public void adminApproveAccess() throws IOException, InterruptedException, SQLException {

		for (Map<String, String> map : registration) {

			if (map.get("userType").equals("ADMIN")) {

				LoginToCsq log = new LoginToCsq();
				log.login("P@ssw0rd", map.get("userName"), driver, pr);
				Thread.sleep(2000);

				AdminApprove adap = new AdminApprove();
				adap.approveRegisteredUsers(ArpUserName, CtoUserName, password, AdminUserName, driver, pr);

			}
		}
	}
/*
	@Test(priority = 3, description = "Creating a new assessment cycle and updated dates from database")
	public void cycleUpdate() throws IOException, InterruptedException, SQLException {

		for (Map<String, String> map : registration) {

			if (map.get("userType").equals("ADMIN")) {

				LoginToCsq log = new LoginToCsq();
				log.login("P@ssw0rd", map.get("userName"), driver, pr);
				Thread.sleep(2000);
				
				AssessmentCycle ac = new AssessmentCycle();
				ac.assessmentCycle(driver, pr);

				Thread.sleep(3000);
				log.logout(driver, pr);
			}
		}
	}

	@Test(priority = 4, description = "registering CTOs by Airport user ")
	public void uploadCtos() throws IOException, InterruptedException {

		for (Map<String, String> map : registration) {

			if (map.get("userType").equals("Airport")) {

				LoginToCsq log = new LoginToCsq();
				log.login("P@ssw0rd", map.get("userName"), driver, pr);
				Thread.sleep(2000);

				RegisterCTOs rctos = new RegisterCTOs();
				rctos.ctoRegister(driver, pr);

				Thread.sleep(3000);
				log.logout(driver, pr);
			}

		}
	}

	@Test(priority = 5, description = "CSQ server reloading process")
	public void serverReload() throws IOException, InterruptedException, FindFailed {

		ServerReload sr = new ServerReload();
		sr.serverReload();
		Thread.sleep(7000);

	}

	@Test(priority = 6, description = "Customer sampling(created new customers and initiate for assessment")
	public void CustomerSampling() throws IOException, InterruptedException, SQLException {
		System.out.println("coming.........");
		for (Map<String, String> map : registration) {

			if (map.get("userType").equals("CTO")) {
				driver.manage().deleteAllCookies();
				Thread.sleep(2000);

				LoginToCsq log = new LoginToCsq();
				log.login("P@ssw0rd", map.get("userName"), driver, pr);
				Thread.sleep(2000);

				CustomerSampling cs = new CustomerSampling();
				cs.customerSamplingProcess(driver, pr, Customer1, Customer2, Customer1mail, Customer2mail);

				Thread.sleep(2000);
				log.logout(driver, pr);

			}
		}
	}

	@Test(priority = 7, description = "CSQ server reloading process")
	public void updateCycleagain() throws IOException, InterruptedException, FindFailed, SQLException {

		Thread.sleep(3000);
		ReUpdateCycle reup = new ReUpdateCycle();
		reup.cycleUpdateForAssessment();

		ServerReload sr = new ServerReload();
		sr.serverReload();
		Thread.sleep(8000);

	}

	@Test(priority = 8, description = "Assessment process going by registered customers")
	public void assessment() throws IOException, InterruptedException, SQLException {

		AssessmentProcess obj = new AssessmentProcess();
		obj.assesment(Customer1mail, password);
		// obj.assesment(Customer1mail, password);
		Thread.sleep(2000);

	}

	@AfterTest
	public void quitBrowser() throws IOException, InterruptedException, FindFailed, SQLException {
		driver.close();
		driver.quit();

	}
*/
}
