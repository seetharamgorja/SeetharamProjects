package com.roi.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.roi.suites.RoiCompleteFlow;

public class CampaignsPage {
	WebDriver driver;
	By Menu = By.linkText("Admin");
	By Campaigns = By.linkText("Campaigns");
	By createcamp = By.linkText("Create New");

	By campname = By.id("CampaignName");
	By branch=By.id("branchid");
	By targetname = By.id("TargetGenericTitle");
	By actpos = By.id("ActualPositionTitle");
	By assigndate = By.xpath("//input[@id='DateAssigned']");
	By focus = By.id("FocusId");
	By gplocation = By.id("GeographicLocationid");
	By psbtn = By.xpath("//*[@id='create_form']/div/div[4]/div[2]/div/div/button");
	By cdbtn = By.xpath("//*[@id='create_form']/div/div[4]/div[3]/div/div/button");
	By atbtn = By.xpath("//*[@id='create_form']/div/div[7]/div[1]/div/div/button");
	By selectps = By.xpath("/html/body/div/div/section[2]/div/form/div/div[4]/div[2]/div/div/ul/li/a/label/input");
	By selectcd = By.xpath("/html/body/div/div/section[2]/div/form/div/div[4]/div[3]/div/div/ul/li/a/label/input");
	By selectat = By.xpath("/html/body/div/div/section[2]/div/form/div/div[7]/div[1]/div/div/ul/li/a/label/input");
	By noofcts = By.id("NumberofContacts");
	By noofctscd = By.id("Contacted");
	By marketingid = By.id("LinktoMarketingCampaignid");
	By powner = By.id("Pena4Owner");
	By cmpstatus = By.id("CampaignStatus");
	By submitcamp = By.xpath("//*[@id='form_create']");
	By typeOfCampaign=By.id("type_of_campaign");
	By team=By.id("teamid");
	By industry=By.id("industryid");
	By inddroplistbtn = By.xpath("//*[@id='create_form']/div/div[3]/div[3]/div/div/button");
	By indsearch = By.xpath("/html/body/div/div/section[2]/div/form/div/div[3]/div[3]/div/div/ul/li[1]/div/input");
	By indselectAll = By.xpath("/html/body/div/div/section[2]/div/form/div/div[3]/div[3]/div/div/ul/li[2]/a/label/input");
	By saveCampaign=By.xpath("//*[@id='form_create']");
	
	

	public static final Logger logger = Logger.getLogger(RoiCompleteFlow.class);

	public CampaignsPage(WebDriver driver) {

		this.driver = driver;

	}

	public void createNewCampaign(String CampaignName, String CRMIndustryName,String FocusName, String LocationName, String MarketingName,
			String CampaignStatusName,String Companyname,String UserFullName) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(Campaigns).click();
		Thread.sleep(4500);
		driver.findElement(createcamp).click();

		Thread.sleep(8000);

		//driver.findElement(campname).sendKeys(CampaignName);
		Select TOC=new Select(driver.findElement(typeOfCampaign));
		TOC.selectByIndex(1);
		Select TID=new Select(driver.findElement(team));
		TID.selectByIndex(1);
		/*
		 * Select IID=new Select(driver.findElement(industry));
		 * IID.selectByVisibleText(CRMIndustryName);
		 */
		
		driver.findElement(inddroplistbtn).click();
		Thread.sleep(1500);
		driver.findElement(indsearch).sendKeys(CRMIndustryName);
		Thread.sleep(1500);
		driver.findElement(indselectAll).click();
		
		
		Select br=new Select(driver.findElement(branch));
		br.selectByIndex(2);
		driver.findElement(targetname).sendKeys("testtarget");

		driver.findElement(actpos).sendKeys("testactualposition");

		SimpleDateFormat sdfTime = new SimpleDateFormat("MM-dd-yyyy");
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DAY_OF_MONTH, +1);
		String initiation_Start_Time = sdfTime.format(calendar.getTime());

		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String sampling_Start_Time = sdfTime.format(calendar.getTime());
System.out.println(sampling_Start_Time);
		driver.findElement(assigndate).sendKeys(sampling_Start_Time);

		Select fcid = new Select(driver.findElement(focus));
		fcid.selectByVisibleText(FocusName);
		driver.findElement(psbtn).click();
		Thread.sleep(1000);

		List<WebElement> ps = driver.findElements(selectps);

		ps.get(1).click();

		Select gp = new Select(driver.findElement(gplocation));
		gp.selectByVisibleText(LocationName);

		driver.findElement(cdbtn).click();
		Thread.sleep(1000);
		List<WebElement> cdb = driver.findElements(selectcd);

		cdb.get(1).click();
		driver.findElement(atbtn).click();
		Thread.sleep(1000);
		List<WebElement> bc = driver.findElements(selectat);

		bc.get(4).click();

		/*
		 * driver.findElement(noofcts).sendKeys("8");
		 * driver.findElement(noofctscd).sendKeys("4");
		 */

		Select se6 = new Select(driver.findElement(marketingid));
		se6.selectByVisibleText(MarketingName);
		Select se5 = new Select(driver.findElement(powner));
		se5.selectByVisibleText(UserFullName);
		
		

		Select se7 = new Select(driver.findElement(cmpstatus));
		se7.selectByIndex(2);
		
		driver.findElement(saveCampaign).click();

	}
}