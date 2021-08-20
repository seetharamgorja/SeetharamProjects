package com.roi.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.roi.suites.RoiCompleteFlow;

public class LeadPage {

	WebDriver driver;
	By Menu = By.linkText("Admin");
	By Lead = By.linkText("Leads");
	By createlead = By.linkText("Create Lead");

	By leadName = By.id("Lead_Name");
	By ownerName = By.id("Pena4_Owner");
	By cpname = By.id("Company_Name");
	By leadSource = By.id("Lead_Source");
	By state = By.id("State");
	By industry = By.id("Industry");
	By cntName = By.id("Contactname");
	By campaign = By.id("Campaign");
	By ips = By.id("Interest_Products_Services");
	By nbc = By.id("New_Business_Category");
	By status = By.id("Status");
	By stage = By.id("stages");
	By bdgcat = By.id("Budget_Category");
	By gut = By.id("Gut_Prob");
	By nextTab2=By.id("btnNexttab2");
	By createLead=By.id("btnSaveLeads");
	By datePicker = By.xpath("//input[@id='Date_First_Contact']");
	By dateofappointment=By.xpath("//input[@id='Date_Of_Appointment']");
	By dateSelection = By.xpath("//table[@class='table-condensed']/tbody/tr[3]/td[3]");
	By assignedTobox = By.xpath("//*[@id='GeneralInformation']/div[3]/div/div/button");
	By assignedToValue = By.xpath(
			"/html/body/div/div/section[2]/div/div[2]/form/div/div/div/div[1]/div[3]/div[1]/div/ul/li[4]/a/label/input");
	By psbox = By.xpath("//*[@id='GeneralInformation']/div[2]/div[4]/div/button");
	By psValue = By.xpath(
			"/html/body/div/div/section[2]/div/div[2]/form/div/div/div/div[1]/div[2]/div[4]/div/ul/li[2]/a/label/input");
	By yearIdentified = By.id("Year_Identified");
	By tabNext = By.id("btnNexttab1");
	By annualrevenue=By.id("Weekly_Revenue");
	By inddroplistbtn = By.xpath("/html/body/div/div/section[2]/div/div[2]/form/div/div/div/div[1]/div[2]/div[3]/div/button");
	By indsearch = By.xpath("/html/body/div/div/section[2]/div/div[2]/form/div/div/div/div[1]/div[2]/div[3]/div/ul/li[1]/div/input");
	By indselectAll = By.xpath("/html/body/div/div/section[2]/div/div[2]/form/div/div/div/div[1]/div[2]/div[3]/div/ul/li[2]/a/label/input");

	public static final Logger logger = Logger.getLogger(RoiCompleteFlow.class);

	public LeadPage(WebDriver driver) {

		this.driver = driver;

	}

	public void createNewLead(String CampaignName,String Companyname,String businessCategoryName,String LeadSourceName,String CRMIndustryName,String Leadname, String CompanyTypeName, String FirstNameOFUser,String BudgetCategoryName)
			throws InterruptedException {
		Thread.sleep(2000);
String cmp=driver.findElement(By.xpath("/html/body/div/div/section[2]/div/div[2]/div/table/tbody/tr[1]/td[2]")).getText();
		
		System.out.println(cmp);
		Thread.sleep(3000);
		driver.findElement(Lead).click();
		Thread.sleep(6500);
		driver.findElement(createlead).click();
		Thread.sleep(1500);
		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DAY_OF_MONTH, +1);
		String initiation_Start_Time = sdfTime.format(calendar.getTime());
		Thread.sleep(1000);
		driver.findElement(leadName).sendKeys(Leadname);
		Select p4ownername = new Select(driver.findElement(ownerName));
		p4ownername.selectByIndex(2);
		Thread.sleep(500);
		Select cpName = new Select(driver.findElement(cpname));
		cpName.selectByVisibleText(Companyname);
		Thread.sleep(500);
		Select ls = new Select(driver.findElement(leadSource));
		ls.selectByVisibleText(LeadSourceName);
		Thread.sleep(500);
		Select st = new Select(driver.findElement(state));
		st.selectByIndex(2);
		/*
		 * Select ind = new Select(driver.findElement(industry));
		 * ind.selectByVisibleText(CRMIndustryName);
		 */
		driver.findElement(inddroplistbtn).click();
		driver.findElement(indsearch).sendKeys(CRMIndustryName);
		Thread.sleep(2000);
		driver.findElement(indselectAll).click();
		
		Select cnt = new Select(driver.findElement(cntName));
		cnt.selectByIndex(1);
		Select camp = new Select(driver.findElement(campaign));
		camp.selectByVisibleText(cmp);
		Thread.sleep(500);
		Select Ips = new Select(driver.findElement(ips));
		Ips.selectByIndex(1);
		Select Nbc = new Select(driver.findElement(nbc));
		Nbc.selectByVisibleText(businessCategoryName);
		Select sta = new Select(driver.findElement(status));
		sta.selectByVisibleText("Open");
		Thread.sleep(2000);
		Select StageSelection = new Select(driver.findElement(stage));
		StageSelection.selectByIndex(1);
		driver.findElement(dateofappointment).sendKeys(initiation_Start_Time);

		driver.findElement(datePicker).sendKeys(initiation_Start_Time);
		driver.findElement(dateSelection).click();
		driver.findElement(assignedTobox).click();
		Thread.sleep(1000);
		List<WebElement> asto = driver.findElements(assignedToValue);

		asto.get(0).click();

		driver.findElement(psbox).click();
		Thread.sleep(1000);
		List<WebElement> ps = driver.findElements(psValue);

		ps.get(0).click();

		Thread.sleep(2000);
		driver.findElement(tabNext).click();
		Thread.sleep(1500);
		Select Bdgcat=new Select(driver.findElement(bdgcat));
		Bdgcat.selectByVisibleText(BudgetCategoryName);
		Thread.sleep(500);
		//driver.findElement(annualrevenue).clear();
		
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(annualrevenue);
		actions.doubleClick(elementLocator).perform();
		
		driver.findElement(annualrevenue).sendKeys("10000");
		Thread.sleep(5000);
		Select Gut=new Select(driver.findElement(gut));
		Gut.selectByIndex(6);
		driver.findElement(nextTab2).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Summary_of_Discussion")).sendKeys("This lead created by Seetharam to test automation scripts..");
		driver.findElement(createLead).click();

	}
}