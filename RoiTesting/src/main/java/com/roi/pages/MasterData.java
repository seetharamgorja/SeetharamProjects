package com.roi.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.roi.suites.RoiCompleteFlow;

public class MasterData {
	
	
	WebDriver driver;
	By Admin = By.linkText("Admin");
	By Menu = By.linkText("Menu");
	By createnew = By.linkText("Create New");

	By SecretPasscode = By.linkText("Secret Passcode");
	By SetPasscode=By.id("SetSecretPasscode");
	By ChangePasscode=By.xpath("/html/body/div/div/section[2]/div/div[2]/div[2]/form/div/div[2]/input");
	By SavePasscode=By.xpath("/html/body/div/div/section[2]/div/div[2]/div/form/div/div[3]/input");
	
	
	By RefrenceTable=By.linkText("Reference Tables");
	By pageName=By.id("PageName");
	By goToPage=By.xpath("/html/body/div/div/section[2]/div/div[4]/form/div[2]/input");
	By CreateTitle=By.id("create_title");
	By CreateBtn=By.id("create_buttion");
	
	
	By stages=By.linkText("Stages");
	By stageName=By.id("txtStageName_C");
	By stageProb=By.id("txtCurrentProb_C");
	By status=By.id("Status_C");
	By SaveStage = By.id("btnStageSave");
	

	public static final Logger logger = Logger.getLogger(RoiCompleteFlow.class);
	
	public MasterData(WebDriver driver) {

		this.driver = driver;
}
	public void createMasterData(String CRMIndustryName,String BudgetCategoryName,String businessCategoryName,String LeadSourceName,String CampaignStatusName,String MarketingName,String LocationName,String FocusName,String Passcode,String CompanyTypeName,String CredentialsName,String DbSourceName,String StageName,String ManagementLevel,String TeamName,String TypeofCampaign) throws InterruptedException {
		Thread.sleep(4000);	
		
		/*
		 * driver.findElement(Admin).click();
		 * 
		 * //Thread.sleep(2000); driver.findElement(SecretPasscode).click();
		 * Thread.sleep(1000);
		 * 
		 * logger.info("::Going to change secreate code::");
		 * 
		 * driver.findElement(ChangePasscode).click(); Thread.sleep(1000);
		 * driver.findElement(SetPasscode).sendKeys(Passcode); Thread.sleep(1500);
		 * driver.findElement(SavePasscode).click(); Thread.sleep(2000);
		 * logger.info("::Successfully changed passcode::");
		 */
	
		driver.findElement(RefrenceTable).click();
		logger.info("::Moving to refrence table to create master data for CRM application::");
		Select list1 = new Select(driver.findElement(pageName));
		list1.selectByVisibleText("Company Type");
		Thread.sleep(2000);
		driver.findElement(goToPage).click();
		Thread.sleep(1000);
		driver.findElement(createnew).click();
		Thread.sleep(3000);
		driver.findElement(CreateTitle).sendKeys(CompanyTypeName);
		Thread.sleep(500);
		driver.findElement(CreateBtn).click();
		Thread.sleep(5000);
		logger.info("::Creating a new companytype name successfully::");
		Select list2 = new Select(driver.findElement(pageName));
		list2.selectByVisibleText("Credentials");
		Thread.sleep(500);
		driver.findElement(goToPage).click();
		Thread.sleep(1000);
		driver.findElement(createnew).click();
		Thread.sleep(1000);
		driver.findElement(CreateTitle).sendKeys(CredentialsName);
		Thread.sleep(500);
		driver.findElement(CreateBtn).click();
		Thread.sleep(3000);
		logger.info("::Creating a new credentials successfully::");
		Select list3 = new Select(driver.findElement(pageName));
		list3.selectByVisibleText("Contact Databases");
		Thread.sleep(500);
		driver.findElement(goToPage).click();
		Thread.sleep(1000);
		driver.findElement(createnew).click();
		Thread.sleep(1000);
		driver.findElement(CreateTitle).sendKeys(DbSourceName);
		Thread.sleep(500);
		driver.findElement(CreateBtn).click();
		Thread.sleep(3000);
		
		Select list4 = new Select(driver.findElement(pageName));
		list4.selectByVisibleText("Focus");
		Thread.sleep(500);
		driver.findElement(goToPage).click();
		Thread.sleep(1000);
		driver.findElement(createnew).click();
		Thread.sleep(1000);
		driver.findElement(CreateTitle).sendKeys(FocusName);
		Thread.sleep(500);
		driver.findElement(CreateBtn).click();
		Thread.sleep(3000);
		
		Select list5 = new Select(driver.findElement(pageName));
		list5.selectByVisibleText("Geographic Location");
		Thread.sleep(500);
		driver.findElement(goToPage).click();
		Thread.sleep(1000);
		driver.findElement(createnew).click();
		Thread.sleep(1000);
		driver.findElement(CreateTitle).sendKeys(LocationName);
		Thread.sleep(500);
		driver.findElement(CreateBtn).click();
		Thread.sleep(3000);
		
		
		Select list6 = new Select(driver.findElement(pageName));
		list6.selectByVisibleText("Marketing Campaign");
		Thread.sleep(500);
		driver.findElement(goToPage).click();
		Thread.sleep(1000);
		driver.findElement(createnew).click();
		Thread.sleep(1000);
		driver.findElement(CreateTitle).sendKeys(MarketingName);
		Thread.sleep(500);
		driver.findElement(CreateBtn).click();
		Thread.sleep(3000);
		
		Select list7 = new Select(driver.findElement(pageName));
		list7.selectByVisibleText("Campaign Status");
		Thread.sleep(500);
		driver.findElement(goToPage).click();
		Thread.sleep(1000);
		driver.findElement(createnew).click();
		Thread.sleep(1000);
		driver.findElement(CreateTitle).sendKeys(CampaignStatusName);
		Thread.sleep(500);
		driver.findElement(CreateBtn).click();
		Thread.sleep(3000);
		
		Select list8 = new Select(driver.findElement(pageName));
		list8.selectByVisibleText("New Business Category");
		Thread.sleep(500);
		driver.findElement(goToPage).click();
		Thread.sleep(1000);
		driver.findElement(createnew).click();
		Thread.sleep(1000);
		driver.findElement(CreateTitle).sendKeys(businessCategoryName);
		Thread.sleep(500);
		driver.findElement(CreateBtn).click();
		Thread.sleep(3000);
		
		Select list9= new Select(driver.findElement(pageName));
		list9.selectByVisibleText("Contact/Lead Source");
		Thread.sleep(500);
		driver.findElement(goToPage).click();
		Thread.sleep(1000);
		driver.findElement(createnew).click();
		Thread.sleep(1000);
		driver.findElement(CreateTitle).sendKeys(LeadSourceName);
		Thread.sleep(500);
		driver.findElement(CreateBtn).click();
		Thread.sleep(3000);
		
		Select list10= new Select(driver.findElement(pageName));
		list10.selectByVisibleText("Budget Category");
		Thread.sleep(500);
		driver.findElement(goToPage).click();
		Thread.sleep(1000);
		driver.findElement(createnew).click();
		Thread.sleep(1000);
		driver.findElement(CreateTitle).sendKeys(BudgetCategoryName);
		Thread.sleep(500);
		driver.findElement(CreateBtn).click();
		Thread.sleep(3000);
		
		Select list11= new Select(driver.findElement(pageName));
		list11.selectByVisibleText("Industry");
		Thread.sleep(500);
		driver.findElement(goToPage).click();
		Thread.sleep(1000);
		driver.findElement(createnew).click();
		Thread.sleep(1000);
		driver.findElement(CreateTitle).sendKeys(CRMIndustryName);
		Thread.sleep(500);
		driver.findElement(CreateBtn).click();
		Thread.sleep(3000);
		
		
		
		
		
		Select list12= new Select(driver.findElement(pageName));
		list12.selectByVisibleText("Management Level");
		Thread.sleep(500);
		driver.findElement(goToPage).click();
		Thread.sleep(1000);
		driver.findElement(createnew).click();
		Thread.sleep(1000);
		driver.findElement(CreateTitle).sendKeys(ManagementLevel);
		Thread.sleep(500);
		driver.findElement(CreateBtn).click();
		Thread.sleep(3000);
		
		Select list13= new Select(driver.findElement(pageName));
		list13.selectByVisibleText("Type of Campaign");
		Thread.sleep(500);
		driver.findElement(goToPage).click();
		Thread.sleep(1000);
		driver.findElement(createnew).click();
		Thread.sleep(1000);
		driver.findElement(CreateTitle).sendKeys(TypeofCampaign);
		Thread.sleep(500);
		driver.findElement(CreateBtn).click();
		Thread.sleep(3000);
		
		Select list14= new Select(driver.findElement(pageName));
		list14.selectByVisibleText("Team");
		Thread.sleep(500);
		driver.findElement(goToPage).click();
		Thread.sleep(1000);
		driver.findElement(createnew).click();
		Thread.sleep(1000);
		driver.findElement(CreateTitle).sendKeys(TeamName);
		Thread.sleep(500);
		driver.findElement(CreateBtn).click();
		Thread.sleep(3000);
		logger.info("::Successfully all master data created successfully::");
		driver.findElement(stages).click();
		Thread.sleep(2000);

		driver.findElement(createnew).click();
		Thread.sleep(500);
		driver.findElement(stageName).sendKeys(StageName);
		Thread.sleep(500);

		driver.findElement(stageProb).sendKeys("85");
		Thread.sleep(500);
		
		Select statusofstage=new Select(driver.findElement(status));
		statusofstage.selectByVisibleText("Open");

		driver.findElement(SaveStage).click();
		Thread.sleep(4000);
}
}
