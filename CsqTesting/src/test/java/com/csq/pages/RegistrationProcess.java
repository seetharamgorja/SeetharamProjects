package com.csq.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class RegistrationProcess {
	 @Test
	  public void register(String userType, WebDriver driver,String Arpmail,String Ctomail,String Airport,String CtoCode,String CtoName)
				throws InterruptedException {
		//  Logger log = Logger.getLogger("devpinoyLogger");
			driver.findElement(By.xpath("//div[@id='accessGrid']/div[3]/div/div/div")).click();

			// driver.findElement(By.xpath(userType)).click();
			if (userType.equalsIgnoreCase("Airport")) {
				driver.findElement(By.xpath("//div[contains(@class,'sapMPopoverScroll')]/ul/li")).click();
				
				driver.findElement(By.xpath("//div[@id='accessGrid']/div[5]/div/div/div")).click();
				driver.findElement(By.xpath(Airport)).click();
				driver.findElement(By.xpath("//div[@id='accessGrid']/div[11]/div/div/div/div[2]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@id='officeGrid']/div[11]/div/div/input")).sendKeys("530012");
				driver.findElement(By.xpath("//div[@id='officeGrid']/div[15]/div/div/input")).sendKeys("9809801234");
				driver.findElement(By.xpath("//div[@id='officeGrid']/div[17]/div/div/input")).sendKeys(Arpmail);
			
				String captcha=driver.findElement(By.id("captchaCode")).getText();
				System.out.println(captcha.replaceAll(" ", ""));
				driver.findElement(By.xpath("//input[@id='ttCaptch-inner']")).sendKeys(captcha.replaceAll(" ", ""));
				driver.findElement(By.xpath("//div[@id='buttons-area']/button[2]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//div[contains(@id,'-footer')]/button")).click();
				Thread.sleep(1000);
				driver.findElement(By.linkText("REGISTRATION")).click();
				Thread.sleep(1000);
			}
			if (userType.equalsIgnoreCase("CTO")) {
				
				driver.findElement(By.xpath("//div[contains(@class,'sapMPopoverScroll')]/ul/li[2]")).click();
				
		
				driver.findElement(By.xpath("//div[@id='accessGrid']/div[5]/div/div/div")).click();
				driver.findElement(By.xpath(Airport)).click();
				driver.findElement(By.xpath("//div[@id='accessGrid']/div[13]/div/div/input")).sendKeys(CtoCode);
				driver.findElement(By.xpath("//div[@id='accessGrid']/div[15]/div/div/input")).sendKeys(CtoName);
				driver.findElement(By.xpath("//div[@id='accessGrid']/div[17]/div/div/input")).sendKeys("20");
				//driver.findElement(By.xpath("//div[@id='accessGrid']/div[11]/div/div/div/div[2]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@id='officeGrid']/div[11]/div/div/input")).sendKeys("5301112");
				driver.findElement(By.xpath("//div[@id='officeGrid']/div[15]/div/div/input")).sendKeys("9809811234");
				driver.findElement(By.xpath("//div[@id='officeGrid']/div[17]/div/div/input")).sendKeys(Ctomail);
				
				
				String captcha2=driver.findElement(By.id("captchaCode")).getText();
				System.out.println(captcha2.replaceAll(" ", ""));
				driver.findElement(By.xpath("//input[@id='ttCaptch-inner']")).sendKeys(captcha2.replaceAll(" ", ""));
				driver.findElement(By.xpath("//div[@id='buttons-area']/button[2]")).click();
				Thread.sleep(2000);
				
	
				
				driver.findElement(By.xpath("//div[contains(@id,'-footer')]/button")).click();
				Thread.sleep(1000);
				driver.findElement(By.linkText("REGISTRATION")).click();
				Thread.sleep(1000);
			}

			Thread.sleep(1000);
  }
}
