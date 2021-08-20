package com.roi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ClientPage {
	
	
	WebDriver driver;
	By client = By.linkText("Clients");
	By Menu = By.linkText("Admin");
	By createnew = By.linkText("Create New");

	By title = By.id("Title");
	By FirstName=By.id("FirstName");
	By LastName=By.id("LastName");
	By desgination=By.id("designation");
	By industry=By.id("Industry");
	By allclients=By.id("client_status_id");
	By company=By.id("Company");
	By alias=By.id("Alias");
	By region=By.id("Region");
	By emailaddress=By.id("EmailAdddress");
	By webaddress=By.id("WebAdddress");
	By MobilePhone=By.id("MobilePhone");
	By submitclient = By.xpath("//input[@value='Create']");
	
	public ClientPage(WebDriver driver) {

		this.driver = driver;
}
	public void createNewClient(String ComanyName,String IndustryName) throws InterruptedException {
		Thread.sleep(4000);	
		driver.findElement(Menu).click();
		driver.findElement(client).click();
		
		Thread.sleep(3000);
		driver.findElement(allclients).click();
		Thread.sleep(3000);
		Select pagecount=new Select(driver.findElement(By.name("user_table_length")));
		pagecount.selectByValue("50");
		
		Thread.sleep(4000);
		driver.findElement(allclients).click();
		Thread.sleep(3000);
		driver.findElement(createnew).click();
		Thread.sleep(2000);
		
		Select clienttitle=new Select(driver.findElement(title));
		clienttitle.selectByIndex(2);
		Thread.sleep(300);
		driver.findElement(FirstName).sendKeys("Testone");
		driver.findElement(LastName).sendKeys("user");
		driver.findElement(desgination).sendKeys("Testing");
		Thread.sleep(300);
		driver.findElement(company).sendKeys(ComanyName);
		
		driver.findElement(alias).sendKeys("QAAUTOMATION");
		Select state=new Select(driver.findElement(region));
		state.selectByIndex(2);
		Select indus=new Select(driver.findElement(industry));
		indus.selectByVisibleText("IT");
		driver.findElement(emailaddress).sendKeys("testqa@gmail.com");
		driver.findElement(webaddress).sendKeys("www.automation.com");
		driver.findElement(MobilePhone).sendKeys("9577645876");
		Thread.sleep(800);
		driver.findElement(submitclient).click();
		Thread.sleep(2000);
}
}