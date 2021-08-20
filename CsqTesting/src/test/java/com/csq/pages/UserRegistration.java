package com.csq.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UserRegistration {
  @Test
  public void registerUser() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get("http://192.168.235.76:9080/csq/login?v=2.0.21");
		Thread.sleep(1000);
		driver.manage().deleteAllCookies();
		
		
	/*	
		driver.findElement(By.linkText("REGISTRATION")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='accessGrid']/div[3]/div/div/div")).click();
		driver.findElement(By.xpath("//div[contains(@class,'sapMPopoverScroll')]/ul/li")).click();
		driver.findElement(By.xpath("//div[@id='accessGrid']/div[5]/div/div/div")).click();
		driver.findElement(By.xpath("//div[contains(@class,'sapMPopoverScroll')]/ul/li[17]")).click();
		driver.findElement(By.xpath("//div[@id='accessGrid']/div[11]/div/div/div/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='officeGrid']/div[11]/div/div/input")).sendKeys("530012");
		driver.findElement(By.xpath("//div[@id='officeGrid']/div[15]/div/div/input")).sendKeys("9809801234");
		driver.findElement(By.xpath("//div[@id='officeGrid']/div[17]/div/div/input")).sendKeys("airpot2.gorja@gmail.com");
		
		
		String captcha=driver.findElement(By.id("captchaCode")).getText();
		System.out.println(captcha.replaceAll(" ", ""));
		driver.findElement(By.xpath("//input[@id='ttCaptch-inner']")).sendKeys(captcha.replaceAll(" ", ""));
		driver.findElement(By.xpath("//div[@id='buttons-area']/button[2]")).click();
		Thread.sleep(13000);
		
		
		
		
		
		
		driver.findElement(By.xpath("//div[contains(@id,'-footer')]/button")).click();
		Thread.sleep(2000);*/
		
		
		driver.findElement(By.linkText("REGISTRATION")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='accessGrid']/div[3]/div/div/div")).click();
		driver.findElement(By.xpath("//div[contains(@class,'sapMPopoverScroll')]/ul/li[2]")).click();
		driver.findElement(By.xpath("//div[@id='accessGrid']/div[5]/div/div/div")).click();
		driver.findElement(By.xpath("//div[contains(@class,'sapMPopoverScroll')]/ul/li[27]")).click();
		driver.findElement(By.xpath("//div[@id='accessGrid']/div[13]/div/div/input")).sendKeys("CT1");
		driver.findElement(By.xpath("//div[@id='accessGrid']/div[15]/div/div/input")).sendKeys("cto1");
		driver.findElement(By.xpath("//div[@id='accessGrid']/div[17]/div/div/input")).sendKeys("25");
		//driver.findElement(By.xpath("//div[@id='accessGrid']/div[11]/div/div/div/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='officeGrid']/div[11]/div/div/input")).sendKeys("5301112");
		driver.findElement(By.xpath("//div[@id='officeGrid']/div[15]/div/div/input")).sendKeys("9809811234");
		driver.findElement(By.xpath("//div[@id='officeGrid']/div[17]/div/div/input")).sendKeys("cto33@gmail.com");
		
		
		String captcha2=driver.findElement(By.id("captchaCode")).getText();
		System.out.println(captcha2.replaceAll(" ", ""));
		driver.findElement(By.xpath("//input[@id='ttCaptch-inner']")).sendKeys(captcha2.replaceAll(" ", ""));
		driver.findElement(By.xpath("//div[@id='buttons-area']/button[2]")).click();
		Thread.sleep(2000);
		
	Thread.sleep(10000);
		
		driver.findElement(By.xpath("//div[contains(@id,'-footer')]/button")).click();
		Thread.sleep(2000);
		
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//*[@id='usr']")).sendKeys("ADMIN");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys("P@ssw0rd");
		driver.findElement(By.xpath("//input[@id='loginSubmit']")).click();
		Thread.sleep(1000);
		driver.findElement(By
				.xpath("//span[@id='__icon0' and @class='hdrMenuIcon sapMBarChild sapUiIcon sapUiIconMirrorInRTL sapUiIconPointer']"))
				.click();

		driver.findElement(By.xpath("//li[@class='sapUiMnuItm' and @id='requests']")).click();
		Thread.sleep(2000);
		

		
		
  }
}
