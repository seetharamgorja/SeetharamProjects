package com.csq.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UploadCustomers {
	@Test
	public void uplodtecutomersforsampling() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get("http://192.168.235.76:9080/csq/login");
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//*[@id='usr']")).sendKeys("AISATS_BLR");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys("P@ssw0rd");
		driver.findElement(By.xpath("//input[@id='loginSubmit']")).click();
		Thread.sleep(4000);

		
		driver.findElement(By
				.xpath("//span[@id='__icon0' and @class='hdrMenuIcon sapMBarChild sapUiIcon sapUiIconMirrorInRTL sapUiIconPointer']"))
				.click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//li[@class='sapUiMnuItm' and @id='customersampling']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@title='UPLOAD FILE']")).click();
		Thread.sleep(1500);
		try {
			driver.findElement(By.xpath("//input[@name='file']"))
					.sendKeys("C:\\Users\\seetharamu\\Desktop\\customers upload.xlsx");
			Thread.sleep(15000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File Does not upload:" + e);
		}
		driver.findElement(By.xpath("//button[@title='ADD NEW CUSTOMER']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='__box0-inner']")).sendKeys("Forwarder");
		driver.findElement(By.xpath("//input[@id='__input0-inner']")).sendKeys("CCCustomer1");
		driver.findElement(By.xpath("//input[@id='__input1-inner']")).sendKeys("wddmai2@gmail.com");
		driver.findElement(By.xpath("//input[@id='__input2-inner']")).click();
		driver.findElement(By.xpath("//button[@title='SAVE']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='ADD NEW CUSTOMER']")).click();
		driver.findElement(By.xpath("//input[@id='__box1-inner']")).sendKeys("Forwarder");
		driver.findElement(By.xpath("//input[@id='__input3-inner']")).sendKeys("fwdd1");
		driver.findElement(By.xpath("//input[@id='__input4-inner']")).sendKeys("fwddmail@gmail.com");
		driver.findElement(By.xpath("//input[@id='__input5-inner']")).click();
		driver.findElement(By.xpath("//button[@title='SAVE']")).click();
		Thread.sleep(2000);

		List<WebElement> li4 = driver.findElements(By.xpath("//div[contains(@id,'-tableCtrlCnt')]/table/tbody/tr/td"));

		List<WebElement> li5 = driver.findElements(By.xpath("//div[contains(@id,'-tableCtrlCnt')]/table/tbody/tr[2]/td"));
		//List<WebElement> li3 = driver.findElements(By.xpath("//div[contains(@id,'-tableCtrlCnt')]/table/tbody/tr[3]/td"));
		System.out.println(li4.get(2).getAttribute("id"));
		
		driver.findElement(By.id(li4.get(2).getAttribute("id"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(li5.get(2).getAttribute("id"))).click();
		Thread.sleep(1000);
		//driver.findElement(By.id(li3.get(2).getAttribute("id"))).click();
		Actions act2 = new Actions(driver);
		act2.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@title='SUBMIT']")).click();
		Thread.sleep(2000);
		
		
	}}


		
	
