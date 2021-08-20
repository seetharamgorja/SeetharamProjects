
package com.roi.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.roi.suites.RoiCompleteFlow;

public class LoginPage {

	WebDriver driver;
	By Username = By.name("Email");
	By Pwd = By.name("Password");
	By RemberMe = By.id("RememberMe");
	By LoginBtn = By.xpath("//*[@id='formContent']/form/div[3]/button");
	By profilepic = By.xpath("/html/body/div/header/nav/div/ul/li/a/img");
	By logout = By.xpath("/html/body/div/header/nav/div/ul/li/ul/li/form/input[1]");

	public static final Logger logger = Logger.getLogger(RoiCompleteFlow.class);

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	public void login(String PassWord, String UserName) throws InterruptedException {

		driver.findElement(Username).sendKeys(UserName);
		logger.info(":::Entered UserName");
		driver.findElement(Pwd).sendKeys(PassWord);
		logger.info(":::Entered Password");
		driver.findElement(RemberMe).click();
		Thread.sleep(1500);
		logger.info(":::Clicked on rember me");
		driver.findElement(LoginBtn).click();
		Thread.sleep(3000);
		logger.info(":::Clicked on login button");
		String Actual = driver.getTitle();
		String Expected = "ROI Calculator";

		if (Actual.equals(Expected)) {
			logger.debug(":::Successfully logged in to ROI Application with Admin");

		} else {
			logger.error(":::Login failed.........");
			driver.close();
		}

	}

	public void logout() throws InterruptedException {
		driver.findElement(profilepic).click();

		driver.findElement(logout).click();
		Thread.sleep(3000);
		logger.info(":::Logout from the application as a admin user..");
	}
}
