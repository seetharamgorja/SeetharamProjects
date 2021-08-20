package com.csq.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class AssessmentProcess {
	public WebDriver wait;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		AssessmentProcess obj = new AssessmentProcess();

		FileInputStream fis = new FileInputStream("C:\\Users\\seetharamu\\Documents\\CSQ_CREDENTIALS.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Iterate through the rows present in sheet
		Iterator<Row> rIterator = sheet.iterator();
		if (rIterator.hasNext())
			rIterator.next();
		while (rIterator.hasNext()) {
			Row row = rIterator.next();

			Cell cell = row.getCell((short) 0);
			String userName = cell.getStringCellValue();

			Cell pwcell = row.getCell((short) 1);
			String password = pwcell.getStringCellValue();

			obj.assesment(userName, password);
			System.out.println(" ");
		}
		fis.close();

	}

	public void assesment(String userName, String password) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

/*		System.setProperty("webdriver.gecko.driver", "D:\\Udemy_SeleniumClasses\\geckodriver.exe");

	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities = DesiredCapabilities.firefox();
	capabilities.setBrowserName("firefox");
	capabilities.setVersion("your firefox version");
	capabilities.setPlatform(Platform.WINDOWS);
	capabilities.setCapability("marionette", false);
    WebDriver driver = new FirefoxDriver(capabilities);
		
	*/
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get("http://192.168.235.76:9080/csq/login");
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//*[@id='usr']")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='loginSubmit']")).click();
		Thread.sleep(4000);

		driver.findElement(By
				.xpath("//span[@id='__icon0' and @class='hdrMenuIcon sapMBarChild sapUiIcon sapUiIconMirrorInRTL sapUiIconPointer']"))
				.click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//li[@class='sapUiMnuItm' and @id='assessment']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("dlgSubmit")).click();
		Thread.sleep(2000);
		// System.out.println(driver.findElement(By.xpath("//*[@title='Cargo
		// Service Quality (CSQ)']")).isDisplayed());

		try {
			WebElement popup = driver.findElement(By.xpath("//*[@id='__mbox0']"));
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			if (driver.findElement(By.xpath("//*[@id='__mbox0']")).isDisplayed()) {
				driver.findElement(By.xpath("//button[@id='__mbox-btn-1']")).click();
				Thread.sleep(700);
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		}

		System.out.println(driver.findElement(By.id("p1_2")).getText());
		Thread.sleep(2000);

		// clicking on selected check boxes

		// driver.findElement(By.id("p1_1-CbBg")).click();
		// driver.findElement(By.id("p2_6-CbBg")).click();

		AssessmentProcess obj = new AssessmentProcess();
		obj.clickCheckBox(driver);

		// ...................................................Assessement for
		// TECHNOLOGY Category...................
		driver.findElement(By.xpath("//div[@id='__filter1-text']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='__filter1-text']")).getText());
		obj.clickCheckBox(driver);

		// ...................................................Assessement for
		// FACILITIES Category...................
		driver.findElement(By.xpath("//div[@id='__filter2-text']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='__filter2-text']")).getText());
		obj.clickCheckBox(driver);

		// ...................................................Assessement for
		// REGULTORS Category...................
		driver.findElement(By.xpath("//div[@id='__filter3-text']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='__filter3-text']")).getText());
		obj.clickCheckBox(driver);

		// ...................................................Assessement for
		// AIRPORT INFRA Category...............
		driver.findElement(By.xpath("//div[@id='__filter4-text']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='__filter4-text']")).getText());
		obj.clickRadioButton(driver);

		// ...................................................Assessement for
		// OTHERS Category........................
		driver.findElement(By.xpath("//div[@id='__filter5-text']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='__filter5-text']")).getText());
		obj.clickRadioButton(driver);
		// driver.findElement(By.id("c1-inner")).sendKeys("Say hello to
		Thread.sleep(1000);
		try {
			// driver.findElement(By.id("__button0")).click();
			// driver.findElement(By.id("c0-inner")).sendKeys("My Assessment is
			// done and going to submit!!!!!!!!!!!");
			WebDriverWait wait = new WebDriverWait(driver, 25);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='submitArea']/div/div[3]/button")));
			driver.findElement(By.xpath("//div[@id='submitArea']/div/div[3]/button")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//button[starts-with(@id,'__mbox-btn-')]")).click();
			Thread.sleep(2000);

		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		driver.close();
	}

	// Clicking on Check boxes for first 4
	// categories................................................................

	public void clickCheckBox(WebDriver driver) {

		List<WebElement> li = driver.findElements(By.xpath("//body/div[2]/div[3]/div/div[2]/div/span"));
		List<WebElement> li2 = driver.findElements(By.xpath("//body/div[2]/div[3]/div/div[2]/div/div"));
		Random random = new Random();

		List<String> spanIds = new ArrayList<>();
		for (WebElement webElement : li) {
			if (webElement.getAttribute("id").startsWith("p")) {
				spanIds.add(webElement.getAttribute("id"));
			}
		}
		int i = 0;
		for (WebElement webElement : li2) {

			String webId = "//div/div/div[starts-with(@id,'" + spanIds.get(i)
					+ "_') and @class='sapMCb sapMCbHasLabel sapMCbWrapped subParameterChkBox']"; // subParameterChkBox
			List<WebElement> liWe = webElement.findElements(By.xpath(webId));
			if (liWe != null && !liWe.isEmpty() && liWe.size() > 0) {

				int loopIndex = random.nextInt(liWe.size());
				while (loopIndex == 0) {
					loopIndex = random.nextInt(liWe.size());
				}

				for (int j = 0; j < loopIndex; j++) {

					int checkboxIndex = random.nextInt(liWe.size());
					while (checkboxIndex == 0) {
						checkboxIndex = random.nextInt(liWe.size());
					}

					String checkboxId = liWe.get(checkboxIndex).getAttribute("id") + "-CbBg";
					try {
						WebElement ww = liWe.get(checkboxIndex)
								.findElement(By.xpath("//div[@id='" + checkboxId + "']"));
						ww.click();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			i++;
		}
	}

	// Clicking on RAdio buttons for last 2
	// categories.......................................................................

	public void clickRadioButton(WebDriver driver) {

		List<WebElement> li = driver.findElements(By.xpath("//body/div[2]/div[3]/div/div[2]/div/span"));
		//List<WebElement> li2 = driver.findElements(By.xpath("//body/div[2]/div[3]/div/div[2]/div/div"));

		System.out.println("Li>>>>>" + li.size());
		//System.out.println("Li2>>>>>" + li2.size());
		int i = 0;

		Random random = new Random();
		for (WebElement webElement : li) {
			String divId = li.get(i).getAttribute("id").replace('p', 'f');
			System.out.println("divId>>>>>>>>>" + divId);
			String webId = "//div/div/div[starts-with(@id,'" + divId + "') and @class='sapMRbG sapMRbG1Row']/div"; // subParameterChkBox
			List<WebElement> liWe = webElement.findElements(By.xpath(webId));
			//System.out.println("liWe>>>>>>>>" + liWe);
			if (liWe != null && !liWe.isEmpty() && liWe.size() > 0) {

				int radioIndex = random.nextInt(liWe.size() - 1);
				while (radioIndex == 0) {
					radioIndex = random.nextInt(liWe.size() - 1);
				}

				String radioButtonId = liWe.get(radioIndex).getAttribute("id") + "-Button";
				System.out.println("radioButtonId>>>>>" + radioButtonId);
				try {
					WebElement ww = liWe.get(radioIndex)
							.findElement(By.xpath("//div/div[@id='" + radioButtonId + "']"));
					ww.click();
		//click last option from others( have an issue)......................................................................................................			
					if(divId.equalsIgnoreCase("f52")){
						Thread.sleep(2000);
						radioButtonId = liWe.get(0).getAttribute("id") + "-Button";
						liWe.get(0).findElement(By.xpath("//div/div[@id='" + radioButtonId + "']")).click();
						Thread.sleep(2000);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			i++;
		}

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

