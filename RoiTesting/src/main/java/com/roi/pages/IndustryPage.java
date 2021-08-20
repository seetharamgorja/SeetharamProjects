package com.roi.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndustryPage {
	
	WebDriver driver;
	By Menu = By.linkText("Menu");
	By IndustrySubMenu = By.linkText("Products/Services");
	By createnew = By.linkText("Create New");
	By IndName = By.name("IndustryName");
	By submitindustry = By.xpath("//input[@value='Create']");
	By SearchIndustry=By.xpath("//*[@id='user_table_filter']/label/input");
	
	public IndustryPage(WebDriver driver) {
		
		this.driver=driver;
}
	
	public void createNewIndustry(String IndustryName) throws InterruptedException {
		Thread.sleep(2000);
		//driver.findElement(Menu);
		driver.findElement(IndustrySubMenu).click();
		Thread.sleep(1000);
		driver.findElement(createnew).click();
		Thread.sleep(2000);
		driver.findElement(IndName).sendKeys(IndustryName);
		Thread.sleep(1000);
		driver.findElement(submitindustry).click();
		Thread.sleep(3500);
		
	

	}
		
	}
