package com.roi.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.roi.suites.RoiCompleteFlow;

public class ContactsPage {

	WebDriver driver;
	By Menu = By.linkText("Admin");
	By Contacts = By.linkText("Contacts");
	By createcont = By.linkText("Create Contact");
	By Companies = By.linkText("Companies");
	By ctfirstname = By.id("FirstName_C");
	By ctlastname = By.id("LastName_C");
	// By
	// assignedtobtn=By.xpath("/html/body/div/div/section[2]/div/div[2]/div[4]/div[3]/div/div/button");
	// By
	// assignedvalue=By.xpath("/html/body/div/div/section[2]/div/div[2]/div[4]/div[3]/div/div/ul/li[15]/a/label/input");
	By ctitle = By.id("Title_C");
	By cdepartment = By.id("Department_C");
	By cpone = By.id("Phone_C");
	By cemail = By.id("Email_C");
	By cstreet = By.id("StreetAddress_C");
	By ccity = By.id("City_C");
	By czip = By.id("Zip_C");
	By cmobile = By.id("Mobile_C");
	By ccompname = By.id("CompanyName_C");
	By reporttoname = By.id("ReportTo_C");
	By statename = By.id("State_C");
	By ccountryname = By.id("Country_C");
	By ccontactname = By.id("ContactSource_C");
	By cownername = By.id("Pena4Owner_C");
	By cstatusname = By.id("Status_C");
	By managementname = By.id("Management_Level_C");
	By Indname = By.id("Industry_C");
	By saveC = By.id("Save");
	By inddroplistbtn = By.xpath("/html/body/div/div/section[2]/div/div[2]/div[4]/div[3]/div/div/div/button");
	By indsearch = By.xpath("/html/body/div/div/section[2]/div/div[2]/div[4]/div[3]/div/div/div/ul/li[1]/div/input");
	By indselectAll = By.xpath("/html/body/div/div/section[2]/div/div[2]/div[4]/div[3]/div/div/div/ul/li[2]/a/label/input");

	public static final Logger logger = Logger.getLogger(RoiCompleteFlow.class);

	public ContactsPage(WebDriver driver) {

		this.driver = driver;

	}

	public void createNewContact(String contactFirstName, String contactLastName, String CRMIndustryName,
			String ManagementLevel, String Companyname,String LeadSourceName,String UserFullName, String contactEmail,

			String CredentilasName) throws InterruptedException {
		Thread.sleep(1000);
//driver.findElement(Companies).click();
		driver.findElement(Contacts).click();
		Thread.sleep(7000);
		logger.info("::Clicking on contacts menu item:::");
		driver.findElement(createcont).click();
		logger.info("::Clicking on new contact button::");
		Thread.sleep(5000);
		logger.info("::Now going to enter all required data to create a new contact::");
		driver.findElement(ctfirstname).sendKeys(contactFirstName);
		Thread.sleep(1500);
		driver.findElement(ctlastname).sendKeys(contactLastName);
		
		
		Thread.sleep(2500);
		driver.findElement(inddroplistbtn).click();
		Thread.sleep(1500);
		driver.findElement(indsearch).sendKeys(CRMIndustryName);
		Thread.sleep(1500);
		driver.findElement(indselectAll).click();
		Thread.sleep(1500);
		Select ml = new Select(driver.findElement(managementname));
		ml.selectByVisibleText(ManagementLevel);
		
		driver.findElement(ctitle).sendKeys("Mr.");
		driver.findElement(cdepartment).sendKeys("QA");
		driver.findElement(cpone).sendKeys("9876543212");
		driver.findElement(cemail).sendKeys(contactEmail);
		driver.findElement(cstreet).sendKeys("mvp");
		driver.findElement(ccity).sendKeys("vizag");
		driver.findElement(czip).sendKeys("555436");
		driver.findElement(cmobile).sendKeys("9878909876");

		/*
		 * Select ind2 = new Select(driver.findElement(Indname));
		 * ind2.selectByVisibleText(CRMIndustryName);
		 */

	
		
		
		
		
		Select cpn = new Select(driver.findElement(ccompname));
		cpn.selectByVisibleText(Companyname);
		/*
		 * Select rpt = new Select(driver.findElement(reporttoname));
		 * rpt.selectByVisibleText(UserFullName);
		 */
		Thread.sleep(1500);
		Select state = new Select(driver.findElement(statename));
		state.selectByIndex(2);
		Select country = new Select(driver.findElement(ccountryname));
		country.selectByVisibleText("US");
		Select db = new Select(driver.findElement(ccontactname));
		db.selectByVisibleText(LeadSourceName);
		Select owner = new Select(driver.findElement(cownername));
		owner.selectByVisibleText(UserFullName);
		/*
		 * Select status = new Select(driver.findElement(cstatusname));
		 * status.selectByIndex(1);
		 */
		Thread.sleep(1000);
		driver.findElement(saveC).click();
		logger.info("::Successfully created and saved a new contact::");
		Thread.sleep(4000);

	}
}
