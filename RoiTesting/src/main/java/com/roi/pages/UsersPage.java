package com.roi.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.roi.suites.RoiCompleteFlow;

public class UsersPage {
	
	
	WebDriver driver;
	By Menu = By.linkText("Admin");
	By UsersSubMenu = By.linkText("Users");
	By createnew = By.linkText("Create New");
	By FirstName = By.id("FirstName");
	By LastName = By.id("LastName");
	By email = By.id("Email");
	By password = By.id("Password");
	By cnfpassword = By.id("ConfirmPassword");
	By registerbtn = By.xpath("//button[@type='submit']");
	By role = By.id("role_id");
	By team=By.id("Team");
	By search = By.xpath("//*[@id='user_table_filter']/label/input");
	By firstname = By.xpath("//table[@class='table table-bordered']/tbody/tr[4]/td[2]");
	By Edit=By.xpath("//*[@id=\"user_table\"]/tbody/tr[1]/td[6]/a[1]");
	By submiteditdetails=By.xpath("/html/body/div/div/section[2]/div/div[2]/div/div/form/button");
	By view=By.xpath("//*[@id=\"user_table\"]/tbody/tr[1]/td[6]/a[2]");
	By back=By.xpath("//*[@id='redirect']");
	
	By changePWD=By.xpath("//*[@id=\"user_table\"]/tbody/tr[1]/td[6]/a[4]");
	By PWD=By.id("Password");
	By cnfPWD=By.id("ConfirmPassword");
	By savePWD=By.xpath("/html/body/div/div/section[2]/div/div[2]/div/div/form/button");
	
	public static final Logger logger = Logger.getLogger(RoiCompleteFlow.class);
	public UsersPage(WebDriver driver) {

		this.driver = driver;

	}

	public void createNewUser(String Email, String PassWord,String FirstNameOFUser,String LastNameOfUser) throws InterruptedException {

		driver.findElement(Menu).click();
		Thread.sleep(2000);
		driver.findElement(UsersSubMenu).click();
		Thread.sleep(2000);
		logger.info(":::Clicked on user menu link");
		driver.findElement(createnew).click();
		Thread.sleep(2000);
		logger.info(":::Clicked on create new link to create a new user");
		driver.findElement(FirstName).sendKeys(FirstNameOFUser);
		driver.findElement(LastName).sendKeys(LastNameOfUser);
		driver.findElement(email).sendKeys(Email);
		driver.findElement(password).sendKeys(PassWord);
		driver.findElement(cnfpassword).sendKeys(PassWord);
		logger.info(":::Entered all mandatory details");
		Select role = new Select(driver.findElement(By.id("role_id")));
		role.selectByVisibleText("Admin");
		Select tm = new Select(driver.findElement(By.id("Team")));
		tm.selectByIndex(1);
		driver.findElement(registerbtn).click();
		logger.info(":::Clickked on register button to save the user details...");

		Thread.sleep(3000);
		// Search user with his Email ID
		driver.findElement(search).sendKeys(Email);
		Thread.sleep(2000);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='user_table']/tbody/tr"));

		if (rows.size() == 1) {
			System.out.println("User craeted successfully and his Email ID is:" + Email);
			Thread.sleep(1000);
			logger.debug(":::User craeted successfully and his Email ID is:" + Email);
	
		} else {
			System.out.println("user name not found!!!!!!");
			logger.error(":::User not craeted successfully with the Email ID :" + Email);
			driver.quit();
		}
	
	}
	
	//Edit,change password and view optuins.
	/*public void editOptions(String Email,String PassWord) throws InterruptedException {
		
		driver.findElement(Edit).click();
		Thread.sleep(1000);
        driver.findElement(submiteditdetails).click();
        Thread.sleep(700);
        
        driver.findElement(view).click();
		Thread.sleep(1000);
        driver.findElement(back).click();
        Thread.sleep(700);
        driver.findElement(search).sendKeys(Email);
		Thread.sleep(1000);
		
		driver.findElement(changePWD).click();
		Thread.sleep(700);
		driver.findElement(PWD).sendKeys(PassWord);
		driver.findElement(cnfPWD).sendKeys(PassWord);
		
		driver.findElement(savePWD).click();
		Thread.sleep(2000);
	*/
		
	}

