package com.roi.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.roi.suites.RoiCompleteFlow;

public class PositionPricingPage {

	WebDriver driver;
	By Menu = By.linkText("Admin");
	By pricingMenu = By.linkText("Positions");
	By createnew = By.linkText("Create New");
	By newIndustrybtn = By.xpath("/html/body/div/div/section[2]/div/div[2]/form/div[1]/div[1]/div/label/button");
	By newDepartmentbtn = By.id("sdomain_id");
	By newPositionbtn = By.id("pmaster_id");
	By saveIndustrybtn = By.xpath("/html/body/div[1]/div/section[2]/div/div[2]/div/div/div/div/div[3]/button[2]");
	By saveDepartmentbtn = By.xpath("/html/body/div[1]/div/section[2]/div/div[2]/div/div/div/div/div[3]/button[2]");
	By savePositionbtn = By.xpath("/html/body/div[1]/div/section[2]/div/div[2]/div/div/div/div/div[3]/button[2]");
	By industryInputField = By.id("SectorName");
	By departmentInputField = By.id("ServiceDomain");
	By positionInputField = By.id("PositionName");
	By selectCatagory = By.xpath("//*[@id='toggleElement']/select");
	By selectPosition = By.xpath("//*[@id='servicecategory']/select");
	By selectSubPosition = By.xpath("//*[@id='jobpositionId']/select");
	By submitpricing = By.xpath("//input[@value='Create']");
	By MinimumExperience = By.id("MinExp");
	By country = By.id("countryid");
	By MaximumExperience = By.id("MaxExp");

	By USSalary = By.id("USSalary");
	By Website = By.id("Website");
	By InrSalMid = By.id("InrSalMid");
	By PreferredRate = By.id("PreferredHrlyRate");
	By UsdSalMide = By.id("UsdSalMid");
	By InrSalHigh = By.id("InrSalHigh");
	By UsdSalHigh = By.id("UsdSalHigh");
	By P4InrSalMid = By.id("PInrSalMid");
	By P4UsdSalMid = By.id("PUsdSalMid");
	By comments = By.name("comments");

	public static final Logger logger = Logger.getLogger(RoiCompleteFlow.class);

	public PositionPricingPage(WebDriver driver) {

		this.driver = driver;
	}

	public void createNewPositionPricing(String IndustryName, String DepartmentName, String PositionName)
			throws InterruptedException {
		logger.info(":::Going to create pricing for the newly created positions..... ");

		Thread.sleep(3000);
		driver.findElement(Menu).click();
		Thread.sleep(2000);
		driver.findElement(pricingMenu).click();
		Thread.sleep(2000);
		WebDriverWait wait3 = new WebDriverWait(driver, 75);

		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Create New"))).click();

		Thread.sleep(1500);

		driver.findElement(newIndustrybtn).click();
		Thread.sleep(1000);
		driver.findElement(industryInputField).sendKeys(IndustryName);
		driver.findElement(saveIndustrybtn).click();
		Thread.sleep(1500);
		driver.findElement(newDepartmentbtn).click();
		Thread.sleep(1500);

		driver.findElement(departmentInputField).sendKeys(DepartmentName);
		driver.findElement(saveDepartmentbtn).click();
		Thread.sleep(1500);

		driver.findElement(newPositionbtn).click();
		Thread.sleep(1500);
		driver.findElement(positionInputField).sendKeys(PositionName);
		driver.findElement(savePositionbtn).click();
		Thread.sleep(1500);
		/*
		 * Select sel =new Select(driver.findElement(selectCatagory));
		 * sel.selectByVisibleText(PositionCategoryName); Thread.sleep(500);
		 * logger.info(":::Selected category"); Select sel1 =new
		 * Select(driver.findElement(selectPosition));
		 * sel1.selectByVisibleText(PositionName); Thread.sleep(400);
		 * logger.info(":::Selected position"); Select sel2 =new
		 * Select(driver.findElement(selectSubPosition));
		 * sel2.selectByVisibleText(SubPositionName); Thread.sleep(500);
		 * logger.info(":::Selected subposition");
		 */

		driver.findElement(MinimumExperience).sendKeys("2");
		driver.findElement(MaximumExperience).sendKeys("5");
		driver.findElement(USSalary).sendKeys("50000");
		Thread.sleep(600);
		driver.findElement(Website).sendKeys("www.roitestautomation.com");
		driver.findElement(PreferredRate).sendKeys("14");
		driver.findElement(InrSalMid).sendKeys("100000");
		driver.findElement(UsdSalMide).sendKeys("30000");
		driver.findElement(UsdSalHigh).sendKeys("49000");
		Thread.sleep(600);
		driver.findElement(InrSalHigh).sendKeys("90000");
		driver.findElement(P4InrSalMid).sendKeys("10000");
		driver.findElement(P4UsdSalMid).sendKeys("50000");
         
		Select sel = new Select(driver.findElement(country));
		sel.selectByVisibleText("US");
		Thread.sleep(500);
		driver.findElement(comments).sendKeys("We are prepared this pricing for automation...");
		Thread.sleep(2000);
		driver.findElement(submitpricing).click();
		Thread.sleep(90000);
		logger.info(":::Successfully entered all the details and submitted");

	}
}