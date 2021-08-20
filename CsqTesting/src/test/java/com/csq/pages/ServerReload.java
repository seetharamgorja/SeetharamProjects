package com.csq.pages;

import org.testng.annotations.Test;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.sikuli.script.FindFailed;

import org.sikuli.script.Pattern;

import org.sikuli.script.Screen;

public class ServerReload {

	public WebDriver wait;
	  @Test
	  public void serverReload() throws InterruptedException, FindFailed {

		Screen screen = new Screen();

		// Create object of Pattern class and specify the images path

		Pattern managerappbtn = new Pattern("C://images//button1.PNG");
		Pattern username = new Pattern("C://images//username.PNG");
		Pattern password = new Pattern("C://images//password.PNG");
		Pattern signin = new Pattern("C://images//signin.PNG");
		Pattern reload1 = new Pattern("C://images//reload.PNG");
		Pattern reload2 = new Pattern("C://images//reload.PNG");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://192.168.235.76:9080");

		screen.wait(managerappbtn, 10);
		screen.click(managerappbtn);

		screen.wait(username, 10);
		screen.type(username, "tadmin");

		// This will type of password field

		screen.type(password, "apt8043@pt");

		// This will click on login button

		screen.click(signin);

		List<WebElement> li = driver.findElements(By.xpath("/html/body/table[5]/tbody/tr[5]/td[6]/form"));
		System.out.println(li.size());

		if (li.size() == 3) {
			driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[5]/td[6]/form[2]")).click();
			Thread.sleep(14000);
            System.out.println("CSQ Server reloaded successfully......................");
            driver.close();
		} else {
			driver.quit();
			
			System.out.println("Server need to start..");
		}

		

	}

}