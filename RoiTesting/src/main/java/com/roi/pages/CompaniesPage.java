package com.roi.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.roi.suites.RoiCompleteFlow;

public class CompaniesPage {

	WebDriver driver;
	By Menu = By.linkText("Admin");
	By Companies = By.linkText("Companies");
	By createcomp = By.linkText("Create Company");

	By cpname = By.id("CompanyName");
	By AliasName = By.id("AliasName");
	By cpzip = By.id("CompanyZip");
	By cpstreet = By.id("CompanyStreet");
	By cpcity = By.id("CompanyCity");
	By cpph = By.id("CompanyPhone");
	By cpweb = By.id("CompanyWebsite");
	By cpType = By.id("CompanyType");
	By cpState = By.id("CompanyState");
	By cpCountry = By.id("CompanyCountry");
	By cpOwner = By.id("Pena4Owner");
	By empsize=By.id("employeesrange");
	By reverange=By.id("revenuerange");
	By cpStatus = By.id("Status");
	By saveCp = By.xpath("//*[@id='Create_btn_id']");
	By inddroplistbtn = By.xpath("/html/body/div/div/section[2]/div/div[2]/form/div[2]/div[1]/div/div/button");
	By indsearch = By.xpath("/html/body/div/div/section[2]/div/div[2]/form/div[2]/div[1]/div/div/ul/li[1]/div/input");
	By indselectAll = By.xpath("/html/body/div/div/section[2]/div/div[2]/form/div[2]/div[1]/div/div/ul/li[2]/a/label/input");
	By cpTypebtn=By.xpath("/html/body/div/div/section[2]/div/div[2]/form/div[1]/div[3]/div/div/button");
	By cptypesearch=By.xpath("/html/body/div/div/section[2]/div/div[2]/form/div[1]/div[3]/div/div/ul/li[1]/div/input");
	By cptypeselectall=By.xpath("/html/body/div/div/section[2]/div/div[2]/form/div[1]/div[3]/div/div/ul/li[2]/a/label/input");

	public static final Logger logger = Logger.getLogger(RoiCompleteFlow.class);

	public CompaniesPage(WebDriver driver) {
		
		this.driver = driver;

	}

	public void createNewCompany(String Companyname, String CompanyTypeName,String CRMIndustryName, String UserFullName) throws InterruptedException {
Thread.sleep(3000);
		driver.findElement(Companies).click();
		Thread.sleep(1500);
		driver.findElement(createcomp).click();
		Thread.sleep(1500);

		driver.findElement(cpname).sendKeys(Companyname);

		driver.findElement(AliasName).sendKeys("alias one");
		
		
		driver.findElement(cpTypebtn).click();
		Thread.sleep(1500);
		driver.findElement(cptypesearch).sendKeys(CompanyTypeName);
		Thread.sleep(1300);
		driver.findElement(cptypeselectall).click();
		Thread.sleep(1000);
		
		driver.findElement(inddroplistbtn).click();
		Thread.sleep(1500);
		driver.findElement(indsearch).sendKeys(CRMIndustryName);
		Thread.sleep(1500);
		driver.findElement(indselectAll).click();
		
		driver.findElement(cpzip).sendKeys("54345");
		driver.findElement(cpstreet).sendKeys("mvp");
		driver.findElement(cpcity).sendKeys("vizag");
		driver.findElement(cpph).sendKeys("9874385812");
		driver.findElement(cpweb).sendKeys("www.google.com");

		
		
		
		Select cmstate = new Select(driver.findElement(cpState));
		cmstate.selectByIndex(3);
		Thread.sleep(500);
		Select country1 = new Select(driver.findElement(cpCountry));
		country1.selectByVisibleText("US");
		Thread.sleep(500);
		Select owner1 = new Select(driver.findElement(cpOwner));
		owner1.selectByVisibleText(UserFullName);
		Thread.sleep(500);
		
		Select es = new Select(driver.findElement(empsize));
		es.selectByIndex(5);
		
		Select rr = new Select(driver.findElement(reverange));
		rr.selectByIndex(5);

		Select status1 = new Select(driver.findElement(cpStatus));
		status1.selectByVisibleText("Active");
		Thread.sleep(500);

		driver.findElement(saveCp).click();
		Thread.sleep(3000);
	}
}
