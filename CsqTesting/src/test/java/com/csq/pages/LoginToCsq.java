package com.csq.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginToCsq {
	public WebDriverWait wait;

	@Test
	public void login(String passWord, String userName, WebDriver driver, Properties pro) throws InterruptedException {
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		driver.get("http://192.168.235.76:9080/csq/login?v=2.1.13");
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys("P@ssw0rd");
		driver.findElement(By.id("loginSubmit")).click();

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("CSQ Login"));

	}

	public void logout(WebDriver driver, Properties pro) throws InterruptedException {
		
	driver.findElement(By.xpath("//div[contains(@id,'__layout')]/div[2]")).click();
	Thread.sleep(3000);	

	

	}
}
