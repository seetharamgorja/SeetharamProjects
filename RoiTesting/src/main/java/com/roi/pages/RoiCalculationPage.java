package com.roi.pages;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.roi.suites.RoiCompleteFlow;

public class RoiCalculationPage {
	WebDriver driver;
	By client = By.linkText("ROI Calculator");

	By CustomerSelection = By.id("CustomerId");
	By newOpportunity = By.xpath("//input[@value='New']");
	By opportunityName=By.id("opportunities_id");
	By submitOpportunity = By.id("save");
	By PositionCategory = By.id("CategoryId");
	By positiondrop=By.id("ServiceDomain");
	By subpositionid=By.id("PositionId");
	By savegetroi=By.id("save_roi");
	By getroi=By.id("getroi");
	By resource=By.id("NoOfResources");
	By labels=By.xpath("//*[@class='roi-blk']/center/label");
	By CloseResultWindow=By.xpath("//*[@id='largeModal']/div/div/div[1]/button");
	public static final Logger logger = Logger.getLogger(RoiCompleteFlow.class);
	
	public RoiCalculationPage(WebDriver driver) {

		this.driver = driver;
}
	public void roiCalculation(String Companyname,String OpportunityName,String PositionName,String DepartmentName,String IndustryName ) throws InterruptedException {
		Thread.sleep(2000);	
		driver.findElement(client).click();
		Thread.sleep(6000);
		logger.info(":::Clicked on ROI Calculator link...");
		driver.findElement(getroi).click();
		Thread.sleep(2000);	
		logger.info(":::verifing the get roi window ");
		driver.findElement(CloseResultWindow).click();
		Thread.sleep(2000);
		logger.info(":::Closed the Get Roi Window");
		
	Select customer=new Select(driver.findElement(CustomerSelection));
	customer.selectByVisibleText(Companyname);
	Thread.sleep(1000);
	logger.info(":::Select Client for calculation");
	driver.findElement(newOpportunity).click();
	Thread.sleep(500);
	driver.findElement(opportunityName).sendKeys(OpportunityName);
	driver.findElement(submitOpportunity).click();
	Thread.sleep(500);
	logger.info(":::Created a new opportunity..");
	Select category1=new Select(driver.findElement(PositionCategory));
	category1.selectByVisibleText(IndustryName);
	Thread.sleep(300);
	Select pos1=new Select(driver.findElement(positiondrop));
	pos1.selectByVisibleText(DepartmentName);
	Thread.sleep(500);
	Select subpos1=new Select(driver.findElement(subpositionid));
	subpos1.selectByVisibleText(PositionName);
	Thread.sleep(2000);
	driver.findElement(resource).clear();
	driver.findElement(resource).sendKeys("10");
	Thread.sleep(2000);
	logger.info(":::Fill all the mandatroy details for ROI Calcuation");
	driver.findElement(savegetroi).click();
	logger.info(":::Clicked on Save and Get ROI button");
	Thread.sleep(6000);
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(labels)));
	
	logger.info(":::Verify the result window");
	
	
	
List<WebElement> radiobuttons=	driver.findElements(labels);
	
	System.out.println(radiobuttons.size());
	
    Iterator<WebElement> clickElement = radiobuttons.iterator();
    while (clickElement.hasNext()) {
        clickElement.next().click();
        Thread.sleep(1000);
        logger.info(":::Verify Hourly,Houlry+,Hourly++ results..");
    }
    Thread.sleep(2000);
}}