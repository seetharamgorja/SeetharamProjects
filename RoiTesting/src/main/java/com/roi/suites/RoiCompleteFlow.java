
package com.roi.suites;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.roi.pages.CampaignsPage;
import com.roi.pages.ClientPage;
import com.roi.pages.CompaniesPage;
import com.roi.pages.ContactsPage;
import com.roi.pages.ConvertLeadToPotentials;
import com.roi.pages.IndustryPage;
import com.roi.pages.LeadPage;
import com.roi.pages.LoginPage;
import com.roi.pages.MasterData;
import com.roi.pages.PositionPricingPage;
import com.roi.pages.PositionsPage;
import com.roi.pages.ReportsPage;
import com.roi.pages.RoiCalculationPage;
import com.roi.pages.UsersPage;

public class RoiCompleteFlow {

//Login Credentials........................................
	public String FirstNameOFUser = "seetaramg";
	public String LastNameOfUser = "QAA";
	public String UserFullName = FirstNameOFUser + " " + LastNameOfUser;
	public String UserName = "testingteam@pena4tech.com";
	public String PassWord = "Pena4@123";
	public String Email = "testingbyyseetharamgorj@gmail.com";

//Main Fields..............................................
	public String DepartmentName = "testdepartmentoneg";
	public String IndustryName = "ITIg";
	public String PositionName = "testingpositionltooog";
	public String OpportunityName = "testingopportunityltooog";
	public String Passcode = "1140";

//Master data.............................................
	public String CompanyTypeName = "ctnltoog";
	public String Companyname = "cnltpog";
	public String CredentialsName = "cltoog";
	public String DbSourceName = "testingdatabaseltoog";
	public String FocusName = "fcltoog";
	public String CRMIndustryName = "indltoog";
	public String LocationName = "NYOg";
	public String MarketingName = "markltoog";
	public String CampaignStatusName = "testingcampaignstatusltoog";
	public String businessCategoryName = "testingbcltoog";
	public String LeadSourceName = "ldsltoog";
	public String BudgetCategoryName = "testingbdcategoryltoog";
	public String ManagementLevel = "Emailg";
	public String TeamName = "Salesltoog";
	public String TypeofCampaign = "Emailg";
	public String StageName = "testingstageltoog";
	public String contactFirstName = "testingltoog";
	public String contactLastName = "Oneabltoog";
	public String contactEmail = "testingemailoneabaltooabg@gmail.com";
	public String CampaignName = "P4-fcltoo-NYO-Apr.16.21";
	public String Leadname = "Leadltoog";
	public WebDriver driver;
	WebDriverWait wait;

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Calendar cal = Calendar.getInstance();

	public static final Logger logger = Logger.getLogger(RoiCompleteFlow.class);
	List<Map<String, String>> registration = new ArrayList<Map<String, String>>();
	Properties pr = new Properties();

	@BeforeTest
	public void addData() throws IOException {

		registration.add(ImmutableMap.of("userType", "ADMIN", "UserName", "seetharamnaidu@pena4tech.com"));
		registration.add(ImmutableMap.of("userType", "SalesExicutive", "UserName", Email));

		FileInputStream ip = new FileInputStream(
				"C:/Users/GorjaS/eclipse-workspace/RoiTesting/src/main/resources/roi.properties");
		pr.load(ip);

		String url = pr.getProperty("roi.uat.url");

		String browserName = pr.getProperty("browser");

		if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\GorjaS\\Desktop\\Seetharam testing\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\GorjaS\\Desktop\\Seetharam testing\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.get(url);

		logger.info(":::Launch the browser and access the ROI URL");
	}

	@Test(priority = 1, description = "Login to ROI Application.....")
	public void loginTest() throws IOException, InterruptedException {
		logger.debug(":::Going to login to ROI Application wit valid credentials...............");
		for (Map<String, String> map : registration) {

			if (map.get("userType").equals("ADMIN")) {

				LoginPage ln = new LoginPage(driver);
				ln.login(PassWord, UserName);
				Thread.sleep(3000);
				logger.info(":::Successfully login to ROI application with the user:::::" + UserName);
			}
		}
	}

	/*
	 * @Test(priority = 2, description =
	 * "Create a new user in ROI/CRM application ..") public void createuser()
	 * throws IOException, InterruptedException {
	 * logger.debug(":::Creating a new sales executive in ROI application.......");
	 * for (Map<String, String> map : registration) {
	 * 
	 * if (map.get("userType").equals("ADMIN")) {
	 * 
	 * UsersPage up = new UsersPage(driver); up.createNewUser(Email, PassWord,
	 * FirstNameOFUser, LastNameOfUser); // // up.editOptions(Email,
	 * 
	 * // PassWord);
	 * 
	 * Thread.sleep(2000); logger.
	 * info(":::Successfully created a new sales executive with the username::::" +
	 * Email);
	 * 
	 * }
	 * 
	 * } }
	 */

//Below code commented due to these functionalities removed from ROI application...........................................................
	/*
	 * @Test(priority = 3, description =
	 * "Create a new Product/service in ROI application ..") public void
	 * createindustry() throws IOException, InterruptedException {
	 * logger.debug(":::Creating a new Industry in ROI application......."); for
	 * (Map<String, String> map : registration) {
	 * 
	 * if (map.get("userType").equals("ADMIN")) {
	 * 
	 * IndustryPage ip = new IndustryPage(driver);
	 * ip.createNewIndustry(IndustryName); Thread.sleep(3000);
	 * logger.info(":::Successfully created a new industry with the name of::::" +
	 * IndustryName); } } }
	 * 
	 * @Test(priority = 4, description =
	 * "Create a new category/position/subposition in ROI application ..") public
	 * void createNewPostitions() throws IOException, InterruptedException { logger.
	 * info(":::Creating a new category/position/subposition in ROI application......."
	 * ); for (Map<String, String> map : registration) {
	 * 
	 * if (map.get("userType").equals("ADMIN")) {
	 * 
	 * PositionsPage pp = new PositionsPage(driver);
	 * pp.createNewpositionsinroi(PositionCategoryName, PositionName,
	 * SubPositionName); Thread.sleep(3000);
	 * 
	 * logger.info(
	 * ":::Successfully created a new position Category with the name of::::" +
	 * PositionCategoryName);
	 * logger.info(":::Successfully created a new position with the name of::::" +
	 * PositionName);
	 * logger.info(":::Successfully created a new sub position with the name of::::"
	 * + SubPositionName); } } }
	 */
//The above code is commented due to functionalities removed..........................................................................

	/*
	 * @Test(priority = 3, description =
	 * "Creating master data of CRM from reference table ..") public void
	 * createMasterDataFromAdmin() throws IOException, InterruptedException {
	 * logger.info(":::Creating a new Position pricing in ROI application .."); for
	 * (Map<String, String> map : registration) {
	 * 
	 * if (map.get("userType").equals("ADMIN")) {
	 * 
	 * MasterData md = new MasterData(driver); md.createMasterData(CRMIndustryName,
	 * BudgetCategoryName, businessCategoryName, LeadSourceName, CampaignStatusName,
	 * MarketingName, LocationName, FocusName, Passcode, CompanyTypeName,
	 * CredentialsName, DbSourceName, StageName, TypeofCampaign, TeamName,
	 * ManagementLevel); Thread.sleep(3000);
	 * logger.info(":::Successfully created master data of CRM Application......");
	 * } } }
	 * 
	 * @Test(priority = 4, description =
	 * "Creating a new company from CRM application..") public void
	 * CreatingNewCompany() throws IOException, InterruptedException {
	 * logger.info(":::Creating a new Position pricing in ROI application .."); for
	 * (Map<String, String> map : registration) {
	 * 
	 * if (map.get("userType").equals("ADMIN")) {
	 * 
	 * CompaniesPage cppage = new CompaniesPage(driver);
	 * cppage.createNewCompany(Companyname, CompanyTypeName, CRMIndustryName,
	 * UserFullName); Thread.sleep(3000);
	 * logger.info(":::Successfully created a new company in CRM Application"); } }
	 * }
	 * 
	 * @Test(priority = 5, description =
	 * "Create a new Position pricing in ROI application ..") public void
	 * createPositionPricing() throws IOException, InterruptedException {
	 * logger.info(":::Creating a new Position pricing in ROI application .."); for
	 * (Map<String, String> map : registration) {
	 * 
	 * if (map.get("userType").equals("ADMIN")) {
	 * 
	 * PositionPricingPage ppc = new PositionPricingPage(driver);
	 * ppc.createNewPositionPricing(IndustryName, DepartmentName, PositionName);
	 * Thread.sleep(3000); logger.
	 * info(":::Successfully created position pricing for newly created positions");
	 * } } }
	 */

	@Test(priority = 5, description = "Creating a new contact in CRM application ..")
	public void creatingNewContact() throws IOException, InterruptedException {
		logger.info(":::Creating a new contact in CRM application ..");
		for (Map<String, String> map : registration) {

			if (map.get("userType").equals("ADMIN")) {

				ContactsPage cont = new ContactsPage(driver);
				cont.createNewContact(contactFirstName, contactLastName, CRMIndustryName, ManagementLevel, Companyname,
						LeadSourceName, UserFullName, contactEmail, CredentialsName);
				Thread.sleep(1500);
				logger.info(":::Successfully created a new contact");
			}
		}

	}

	@Test(priority = 6, description = "Creating a new campaign in CRM application ..")
	public void creatingNewCampaignTest() throws IOException, InterruptedException {
		logger.info(":::Creating a new Campaign in CRM application ..");
		for (Map<String, String> map : registration) {

			if (map.get("userType").equals("ADMIN")) {

				CampaignsPage camp = new CampaignsPage(driver);
				camp.createNewCampaign(CampaignName, CRMIndustryName, FocusName, LocationName, MarketingName,
						CampaignStatusName, Companyname, UserFullName);
				Thread.sleep(1500);
				logger.info(":::Successfully created a new campaign:::");
			}
		}

	}

	@Test(priority = 7, description = "Creating a new Lead in CRM application ..")
	public void creatingNewLeadTest() throws IOException, InterruptedException {
		logger.info(":::Creating a new Campaign in CRM application ..");
		for (Map<String, String> map : registration) {

			if (map.get("userType").equals("ADMIN")) {

				LeadPage lead = new LeadPage(driver);
				lead.createNewLead(CampaignName, Companyname, businessCategoryName, LeadSourceName, CRMIndustryName,
						Leadname, CompanyTypeName, FirstNameOFUser, BudgetCategoryName);

				Thread.sleep(1500);
				logger.info(":::Successfully created a new campaign:::");
			}
		}

	}

	@Test(priority = 8, description = "Converting lead as potential in CRM application ..")
	public void convertingLeadToPotentialTest() throws IOException, InterruptedException {
		logger.info(":::Creating a new potential in CRM application with existing lead ..");
		for (Map<String, String> map : registration) {

			if (map.get("userType").equals("ADMIN")) {

				ConvertLeadToPotentials clp = new ConvertLeadToPotentials(driver);
				clp.leadConvertToPotential(Leadname);

				Thread.sleep(1500);
				logger.info(":::Successfully converted lead to potential:::");
			}
		}

	}

	@Test(priority = 10, description = "Creating a new client in ROI application ..")
	public void createclient() throws IOException, InterruptedException {
		logger.info(":::Creating a new client in ROI application ..");
		for (Map<String, String> map : registration) {

			if (map.get("userType").equals("ADMIN")) {

				ClientPage cp = new ClientPage(driver);
				cp.createNewClient(Companyname, IndustryName);
				Thread.sleep(1500);
				logger.info(":::Successfully created a new client with the name of::::" + Companyname);
			}
		}

	}

	@Test(priority = 11, description = "ROI Calculation process and verify the results in ROI application ..")
	public void roiCalculationprocess() throws IOException, InterruptedException {
		logger.debug(":::Moving to calculation part......");
		for (Map<String, String> map : registration) {

			if (map.get("userType").equals("ADMIN")) {

				RoiCalculationPage roic = new RoiCalculationPage(driver);
				roic.roiCalculation(Companyname, OpportunityName, PositionName, DepartmentName, IndustryName);
				Thread.sleep(2500);
				logger.info(":::Successfully done the get and save roi results::::");
			}
		}

	}

	@Test(priority = 12, description = "Verifying the client reports..")
	public void verifyReports() throws IOException, InterruptedException {
		logger.debug(":::Moving to reports page");
		for (Map<String, String> map : registration) {

			if (map.get("userType").equals("ADMIN")) {

				ReportsPage rp = new ReportsPage(driver);
				rp.searchforClientReports(Companyname, IndustryName);
				Thread.sleep(2500);
				logger.info(":::Successfully verified the client reports");
			}
		}

	}

	@Test(priority = 13, description = "Login with sales executive........")
	public void verifyLoginWithSalesExicutive() throws IOException, InterruptedException {
		logger.debug(":::verify Login With Sales Exicutive");
		for (Map<String, String> map : registration) {

			if (map.get("userType").equals("SalesExicutive")) {

				LoginPage lp = new LoginPage(driver);
				lp.logout();
				Thread.sleep(1500);
				lp.login(PassWord, Email);
				Thread.sleep(5500);

				List<WebElement> noofmenuitems = driver
						.findElements(By.xpath("/html/body/div/aside/div/section/ul/li"));

				if (noofmenuitems.size() == 4) {
					logger.info(":::Sales Executive user successfully logged in to ROI App..");
				} else {
					logger.error(":::sales executive view changed......");
				}

				logger.info(":::Verified sales executive view..");
			}
		}

	}

	@Test(priority = 14, description = "Quit from browser....")
	public void quitBrowser() {
		driver.quit();
		logger.info(
				":::All the scripts executed as expected and successfully finished the workflow of ROI application....");
	}

}
