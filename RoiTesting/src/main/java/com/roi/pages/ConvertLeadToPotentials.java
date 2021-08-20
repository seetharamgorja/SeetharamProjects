package com.roi.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.roi.suites.RoiCompleteFlow;

public class ConvertLeadToPotentials {
	WebDriver driver;
	By Menu = By.linkText("Admin");
	By leads = By.linkText("Leads");
	By search = By.cssSelector(".input-field");
	By RP=By.linkText("Revenue Projections");
	By description=By.linkText("Description, Plan, Next Step & Update");
	By convert=By.linkText("Convert");
	By yes=By.id("conver_leads");
	By next1=By.id("btnNexttab1");
	By next2=By.id("btnNexttab2");
	By comment=By.id("Description_C");
	By Save=By.id("btnSavePotential");
	


	public static final Logger logger = Logger.getLogger(RoiCompleteFlow.class);

	public ConvertLeadToPotentials(WebDriver driver) {

		this.driver = driver;

	}

	public void leadConvertToPotential(String Leadname) throws InterruptedException {
		Thread.sleep(3000);
		
		driver.findElement(leads).click();
		Thread.sleep(5000);
		driver.findElement(search).sendKeys(Leadname);
		driver.findElement(By.linkText(Leadname)).click();
		Thread.sleep(1500);
		driver.findElement(RP).click();
		Thread.sleep(2000);
		driver.findElement(description).click();
		Thread.sleep(2000);
		driver.findElement(convert).click();
		
		driver.findElement(yes).click();
		Thread.sleep(4000);
		driver.findElement(next1).click();
		driver.findElement(next2).click();
		driver.findElement(comment).sendKeys("This potentails converted from existing lead...");
		Thread.sleep(1000);
		driver.findElement(Save).click();
	}
}
