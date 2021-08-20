package com.csq.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AdminApprove {
	@Test
	public void approveRegisteredUsers(String ArpUserName,String CtoUserName,String passWord, String userName, WebDriver driver, Properties pro) throws InterruptedException {
	 
		driver.findElement(By
				.xpath("//span[@id='__icon0' and @class='hdrMenuIcon sapMBarChild sapUiIcon sapUiIconMirrorInRTL sapUiIconPointer']"))
				.click();

		driver.findElement(By.xpath("//li[@class='sapUiMnuItm' and @id='requests']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("__table0-rows-row0")).getText());
		driver.findElement(By.id("__table0-rows-row0")).click();
		driver.findElement(By.xpath("//button[@title='ACCEPT']")).click();
		Thread.sleep(2000);
	
	//	driver.findElement(By.xpath("//div[contains(@id,'--Form--Grid')]/div/div/div/div/div[2]/div/div")).sendKeys("test");
		driver.findElement(By.id("__input0-inner")).clear();
		driver.findElement(By.id("__input0-inner")).sendKeys(CtoUserName);
		driver.findElement(By.id("__input1-inner")).clear();
		driver.findElement(By.id("__input1-inner")).sendKeys(passWord);
		driver.findElement(By.id("__input2-inner")).sendKeys(passWord);
		driver.findElement(By.className("sapMSwtCont")).click();
		driver.findElement(By.xpath("//input[@id='sysip--inner']")).sendKeys("20");
		try {
			
		
		driver.findElement(By.xpath("//div[contains(@id,'-footer')]/button")).click();
		Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Market share does not equal to 100%:"+e);
		}
		driver.findElement(By.id("__table0-rows-row0")).click();
		driver.findElement(By.xpath("//button[@title='ACCEPT']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("__input13-inner")).sendKeys(ArpUserName);
		driver.findElement(By.id("__input14-inner")).sendKeys(passWord);
		driver.findElement(By.id("__input15-inner")).sendKeys(passWord);
		driver.findElement(By.xpath("//div[contains(@id,'-footer')]/button")).click();
		Thread.sleep(3000);
  }
}
