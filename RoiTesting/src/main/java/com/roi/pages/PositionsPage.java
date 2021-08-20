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

public class PositionsPage {

	WebDriver driver;
	By Menu = By.linkText("Admin");
	By PositionsMenu = By.linkText("Positions");
	By PositionsCategoryMenu = By.linkText("Position Category");
	By createnew = By.linkText("Create New");

	By pcName = By.name("SectorName");
	By submitcategory = By.xpath("//input[@value='Create']");

	By positionsubMenu = By.linkText("Position");
	By pcDrop = By.name("SectorId");
	By positionName = By.name("ServiceDomain");

	By subpositionsubMenu = By.linkText("Sub Position");
//	By pcDrop2 = By.name("SectorId");
	By subpositionName = By.name("PositionName");
	By search = By.xpath("//*[@id='user_table_filter']/label/input");
	
	public static final Logger logger = Logger.getLogger(RoiCompleteFlow.class);
	
	public PositionsPage(WebDriver driver) {

		this.driver = driver;

	}

	public void createNewpositionsinroi(String PositionCategoryName, String PositionName,String SubPositionName) throws InterruptedException {
		Thread.sleep(7000);
	driver.findElement(Menu).click();
		driver.findElement(PositionsMenu).click();
		logger.debug(":::Clicked on positions menu link");
		/*
		 * driver.findElement(PositionsCategoryMenu).click();
		 * logger.debug(":::Clicked on positions Category menu link");
		 * driver.findElement(createnew).click(); Thread.sleep(600);
		 * logger.debug(":::Clicked on create link to creae a new category ..");
		 * driver.findElement(pcName).sendKeys(PositionCategoryName); Thread.sleep(600);
		 * WebDriverWait wait = new WebDriverWait(driver, 40);
		 * driver.findElement(submitcategory).click();; Thread.sleep(4500);
		 * logger.debug(":::Submit category detail");
		 * driver.findElement(search).sendKeys(PositionCategoryName);
		 * Thread.sleep(2000); logger.debug(":::Search for created category");
		 */
		/*
		 * List<WebElement> rows =
		 * driver.findElements(By.xpath("//table[@id='user_table']/tbody/tr"));
		 * 
		 * if (rows.size() == 1) {
		 * System.out.println("Position category created successfylly:" +
		 * PositionCategoryName);
		 * logger.info(":::Position category created successfylly:" +
		 * PositionCategoryName); } else {
		 * System.out.println("Position not created!!!!!!"); driver.quit();
		 * logger.error(":::category not created"); }
		 */
		 System.out.println("Position category created successfylly:" + PositionCategoryName);
		Thread.sleep(3000);
		driver.findElement(positionsubMenu).click();
		Thread.sleep(2000);
		logger.debug(":::Selected positions submenu link");
		
		//wait.until(ExpectedConditions.elementToBeClickable(createnew));
		try {
			driver.findElement(createnew).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	
		Thread.sleep(600);
		Select selectcategory = new Select(driver.findElement(pcDrop));
		selectcategory.selectByVisibleText(PositionCategoryName);
		Thread.sleep(400);
		driver.findElement(positionName).sendKeys(PositionName);
		Thread.sleep(500);
		driver.findElement(submitcategory).click();;
		Thread.sleep(2500);
		logger.debug(":::Created a new position");
		Thread.sleep(1000);
		driver.findElement(subpositionsubMenu).click();
		//wait.until(ExpectedConditions.elementToBeClickable(createnew));
		try {
			driver.findElement(createnew).click();
		} catch (Exception e) {
			System.out.println(e);
		}

		Thread.sleep(600);
		Select selectcategory1 = new Select(driver.findElement(pcName));
		selectcategory1.selectByVisibleText(PositionCategoryName);
		Thread.sleep(600);
		Select selectposi = new Select(driver.findElement(positionName));
		selectposi.selectByVisibleText(PositionName);
		Thread.sleep(600);
		driver.findElement(subpositionName).sendKeys(SubPositionName);
		try {
			driver.findElement(submitcategory).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		logger.debug(":::Created  a new sub position");
		Thread.sleep(1500);
	}
}
