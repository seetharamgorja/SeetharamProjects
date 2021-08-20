                   package com.roi.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.roi.suites.RoiCompleteFlow;

public class ReportsPage {
	WebDriver driver;
	By report = By.linkText("Reports");

	By clientreport = By.linkText("Client Report");
	
	By clientdroplist=By.id("Customer");
	By submitclient = By.xpath("//input[@value='Search']");
	By noofrecords=By.xpath("//*[@id='starting_divs']/table[4]/tbody/tr");
	public static final Logger logger = Logger.getLogger(RoiCompleteFlow.class);
	
	public ReportsPage(WebDriver driver) {

		this.driver = driver;
}
	public void searchforClientReports(String ComanyName,String IndustryName) throws InterruptedException {
		Thread.sleep(2000);	
		
		logger.info(":::Clicking on reports link");
	driver.findElement(report).click();
	driver.findElement(clientreport).click();
	Thread.sleep(1500);
	logger.info(":::Redirect to client reports page...");
	
	Select cltdp =new Select(driver.findElement(clientdroplist));
	cltdp.selectByVisibleText(ComanyName);
	logger.info(":::Select Company to see the attached opportunities list with it..");
	
	driver.findElement(submitclient).click();
	Thread.sleep(4000);
	logger.debug(":::Search the Clint...............");
	
	List<WebElement> rows=	driver.findElements(noofrecords);
	
	//System.out.println(rows.size());
	

	if (rows.size()==1) {
		System.out.println("Test case passed.........");
		logger.debug(":::Successfully verified the client reports as per records");
		
	} else {
		System.out.println("Failed.....");
		logger.error(":::Client reports verification is failed....");
		driver.quit();
	}
	
	
}
}