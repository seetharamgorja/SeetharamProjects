package com.csq.pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegisterCTOs {

	public WebDriver wait;
	  @Test
	  public void ctoRegister(WebDriver driver, Properties pr) throws InterruptedException {

		
		driver.findElement(By
				.xpath("//span[@id='__icon0' and @class='hdrMenuIcon sapMBarChild sapUiIcon sapUiIconMirrorInRTL sapUiIconPointer']"))
				.click();

		driver.findElement(By.xpath("//li[@class='sapUiMnuItm' and @id='registerctos']")).click();
		Thread.sleep(2000);
		
	try {
		driver.findElement(By.xpath("//input[@name='file']")).sendKeys("C:\\Users\\seetharamu\\Desktop\\ctos upload.xlsx");
		Thread.sleep(13000);
	  } catch (Exception e) {
		  e.printStackTrace();
		System.out.println("File Does not upload:"+e);
		}
		driver.findElement(By.xpath("//div[@id='ctoGrid']/div[6]/div/div[2]/button")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id='ctoGrid']/div[6]/div/div/button")).click();
		
		
		Thread.sleep(1000);
		driver.findElement(By
				.xpath("//span[@id='__icon0' and @class='hdrMenuIcon sapMBarChild sapUiIcon sapUiIconMirrorInRTL sapUiIconPointer']"))
				.click();

		driver.findElement(By.xpath("//li[@class='sapUiMnuItm' and @id='customersampling']")).click();
		Thread.sleep(5000);
	}

}
