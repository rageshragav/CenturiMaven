package Centuri_Home_General_PageCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import objectrepository.CenturiHomePage;
import riskmodule.Centuri_Base;

public class General_Cases extends Centuri_Base {
	
	 CenturiHomePage chp; 
	public CenturiHomePage chp1; 
	String shortcutDialog = Keys.chord(Keys.ALT,Keys.ENTER);
	String documentPageNavigation = Keys.chord(Keys.ALT,Keys.SHIFT,"d");
	String formPageNavigation = Keys.chord(Keys.ALT,Keys.SHIFT,"f");
	String casePageNavigation = Keys.chord(Keys.ALT,Keys.SHIFT,"c");
	String contractPageNavigation = Keys.chord(Keys.ALT,Keys.SHIFT,"a");
	String taskPageNavigation = Keys.chord(Keys.ALT,Keys.SHIFT,"t");
	String startPageNavigationKeys = Keys.chord(Keys.ALT,"1");
	String portalPageNavigationKeys = Keys.chord(Keys.ALT,"2");
	String readPageNavigationKeys = Keys.chord(Keys.ALT,"3");
	String contractPageNavigationKeys = Keys.chord(Keys.ALT,"4");
	String casesPageNavigationKeys = Keys.chord(Keys.ALT,"5");
	String pdcaPageNavigationKeys = Keys.chord(Keys.ALT,"p");
	String searchPageNavigationKeys = Keys.chord(Keys.ALT,"6");
	String todoPageNavigationKeys = Keys.chord(Keys.ALT,"7");
	String reportsPageNavigationKeys = Keys.chord(Keys.ALT,"8");
	String adminPageNavigationKeys = Keys.chord(Keys.ALT,"9");
	String helpPageNavigationKeys = Keys.chord(Keys.ALT,"0");
	String settingsPageNavigationKeys = Keys.chord(Keys.ALT,".");
	String startPageLink = "http://demo-centuri.conevo.in/#/start/content";
	String documentPageLink = "http://demo-centuri.conevo.in/#/start/new/workunit/docflow//";
	String formPageLink = "http://demo-centuri.conevo.in/#/start/new/workunit/formflow//";
	String casePageLink = "http://demo-centuri.conevo.in/#/start/new/workunit/caseflow//";
	String contractPageLink = "http://demo-centuri.conevo.in/#/start/new/workunit/contractflow//";
	String taskPageLink = "http://demo-centuri.conevo.in/#/start/task/new";
	String portalPageLink = "http://demo-centuri.conevo.in/#/portal/content";
	String readPageLink = "http://demo-centuri.conevo.in/#/read/newWorkflows";
	String contractMainPageLink = "http://demo-centuri.conevo.in/#/contract/myContracts";
	String caseMainPageLink = "http://demo-centuri.conevo.in/#/case/myCases";
	String riskMainPageLink = "http://demo-centuri.conevo.in/#/risk/allRisks";
	String SearchMainPageLink = "http://demo-centuri.conevo.in/#/search/criteria";
	String todoMainPageLink = "http://demo-centuri.conevo.in/#/todo/work";
	String reportsPageLink = "http://demo-centuri.conevo.in/#/reports";
	String adminPageLink = "http://demo-centuri.conevo.in/#/admin";
	String helpPageLink = "http://demo-centuri.conevo.in/#/help/documents";
	String settingsPageLink = "http://demo-centuri.conevo.in/#/settings/user";
	String searchMainText = "Search in Centuri";
	public void object() {
		chp = new CenturiHomePage(driver,wait);
	}
	//@Test(description ="Verify whether the user can navigate to respective pages on clicking the shortcut options",priority=1)
	public void centuri_general_testcase_001() throws InterruptedException, IOException {
		//test.log(Status.PASS, "Centuri login successfully done");
		test = extent.createTest("Navigation Shortcut popup – navigations through option click #TC-3.2-001");
		test.log(Status.PASS, "User login is successfull");
		object();
		//chp = new CenturiHomePage(driver,wait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
		 Thread.sleep(2000);
		
		//Code To Check whether the user navigates to Document creation page with shortcut keys function
		try 
		{
		chp.centuriMainPage().sendKeys(shortcutDialog);
		chp.documentNavigation().click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
		WaitForTwoSeconds();
		String getLink = driver.getCurrentUrl();
		Assert.assertEquals( getLink,documentPageLink);
		driver.navigate().back();
		test.log(Status.PASS, "User successfully navigated to NEW DOCUMENT CREATION page with shortcut keys function");
		}
		catch (Exception e)
		{
			test.log(Status.PASS, "User not successfully navigated to new document creation page with shortcut keys function");
		}
		finally {}
		
		//Code To Check whether the user navigates to FORM CREATION page with shortcut keys function
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				chp.centuriMainPage().sendKeys(shortcutDialog);
				chp.formNavigation().click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				String getLink = driver.getCurrentUrl();
				Assert.assertEquals( getLink,formPageLink);
				driver.navigate().back();
				test.log(Status.PASS, "User successfully navigated to new FORM CREATION page with shortcut keys function");
				}
				catch (Exception e)
				{
					test.log(Status.PASS, "User not successfully navigated to new FORM CREATION page with shortcut keys function");
				}
				finally {}
		//Code To Check whether the user navigates to CASE CREATION page with shortcut keys function
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				chp.centuriMainPage().sendKeys(shortcutDialog);
				chp.caseNavigation().click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				String getLink = driver.getCurrentUrl();
				Assert.assertEquals( getLink,casePageLink);
				driver.navigate().back();
				test.log(Status.PASS, "User successfully navigated to new CASE CREATION page with shortcut keys function");
				}
				catch (Exception e)
				{
					test.log(Status.PASS, "User not successfully navigated to new CASE CREATION page with shortcut keys function");
				}
				finally {}
		//Code To Check whether the user navigates to CONTRACT CREATION page with shortcut keys function
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				chp.centuriMainPage().sendKeys(shortcutDialog);
				chp.contractNavigation().click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				String getLink = driver.getCurrentUrl();
				Assert.assertEquals( getLink,contractPageLink);
				driver.navigate().back();
				test.log(Status.PASS, "User successfully navigated to new CONTRACT CREATION page with shortcut keys function");
				}
				catch (Exception e)
				{
					test.log(Status.PASS, "User not successfully navigated to new CONTRACT CREATION page with shortcut keys function");
				}
				finally {}
		//Code To Check whether the user navigates to TASK CREATION page with shortcut keys function
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				chp.centuriMainPage().sendKeys(shortcutDialog);
				chp.taskNavigation().click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				String getLink = driver.getCurrentUrl();
				Assert.assertEquals( getLink,taskPageLink);
				driver.navigate().back();
				test.log(Status.PASS, "User successfully navigated to TASK CREATION page with shortcut keys function");
				}
				catch (Exception e)
				{
					test.log(Status.PASS, "User not successfully navigated to TASK CREATION page with shortcut keys function");
				}
				finally {}
		//Code To Check whether the user navigates to PORTAL page with shortcut keys function
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				chp.centuriMainPage().sendKeys(shortcutDialog);
				chp.portalNavigation().click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				String getLink = driver.getCurrentUrl();
				Assert.assertEquals( getLink,portalPageLink);
				driver.navigate().back();
				test.log(Status.PASS, "User successfully navigated to PORTAL page with shortcut keys function");
				}
				catch (Exception e)
				{
					test.log(Status.PASS, "User not successfully navigated to PORTAL page with shortcut keys function");
				}
				finally {}
		//Code To Check whether the user navigates to READ page with shortcut keys function
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				chp.centuriMainPage().sendKeys(shortcutDialog);
				chp.readNavigation().click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				String getLink = driver.getCurrentUrl();
				Assert.assertEquals( getLink,readPageLink);
				driver.navigate().back();
				test.log(Status.PASS, "User successfully navigated to READ page with shortcut keys function");
				}
				catch (Exception e)
				{
					test.log(Status.PASS, "User not successfully navigated to READ page with shortcut keys function");
				}
				finally {}
		//Code To Check whether the user navigates to CONTRACTS page with shortcut keys function
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				chp.centuriMainPage().sendKeys(shortcutDialog);
				chp.contractsListNavigation().click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				String getLink = driver.getCurrentUrl();
				Assert.assertEquals( getLink,contractMainPageLink);
				driver.navigate().back();
				test.log(Status.PASS, "User successfully navigated to CONTRACTS page with shortcut keys function");
				}
				catch (Exception e)
				{
					test.log(Status.PASS, "User not successfully navigated to CONTRACTS page with shortcut keys function");
				}
				finally {}
		//Code To Check whether the user navigates to CASES page with shortcut keys function
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				chp.centuriMainPage().sendKeys(shortcutDialog);
				chp.casesListNavigation().click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				String getLink = driver.getCurrentUrl();
				Assert.assertEquals( getLink,caseMainPageLink);
				driver.navigate().back();
				test.log(Status.PASS, "User successfully navigated to CASES page with shortcut keys function");
				}
				catch (Exception e)
				{
					test.log(Status.PASS, "User not successfully navigated to CASES page with shortcut keys function");
				}
				finally {}
		//Code To Check whether the user navigates to PDCA page with shortcut keys function
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				chp.centuriMainPage().sendKeys(shortcutDialog);
				chp.riskListNavigation().click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				String getLink = driver.getCurrentUrl();
				Assert.assertEquals( getLink,riskMainPageLink);
				driver.navigate().back();
				test.log(Status.PASS, "User successfully navigated to PDCA page with shortcut keys function");
				}
				catch (Exception e)
				{
					test.log(Status.PASS, "User not successfully navigated to PDCA page with shortcut keys function");
				}
				finally {}
		//Code To Check whether the user navigates to SEARCH page with shortcut keys function
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				chp.centuriMainPage().sendKeys(shortcutDialog);
				chp.searchMainPageNavigation().click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				String getLink = driver.getCurrentUrl();
				Assert.assertEquals( getLink,SearchMainPageLink);
				driver.navigate().back();
				test.log(Status.PASS, "User successfully navigated to SEARCH page with shortcut keys function");
				}
				catch (Exception e)
				{
					test.log(Status.PASS, "User not successfully navigated to SEARCH page with shortcut keys function");
				}
				finally {}
		//Code To Check whether the user navigates to TODO page with shortcut keys function
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				chp.centuriMainPage().sendKeys(shortcutDialog);
				chp.todoMainPageNavigation().click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				String getLink = driver.getCurrentUrl();
				Assert.assertEquals( getLink,todoMainPageLink);
				driver.navigate().back();
				test.log(Status.PASS, "User successfully navigated to TODO page with shortcut keys function");
				}
				catch (Exception e)
				{
					test.log(Status.PASS, "User not successfully navigated to TODO page with shortcut keys function");
				}
				finally {}
		//Code To Check whether the user navigates to REPORTS page with shortcut keys function
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				chp.centuriMainPage().sendKeys(shortcutDialog);
				chp.reportsMainPageNavigation().click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				String getLink = driver.getCurrentUrl();
				Assert.assertEquals( getLink,reportsPageLink);
				driver.navigate().back();
				test.log(Status.PASS, "User successfully navigated to REPORTS page with shortcut keys function");
				}
				catch (Exception e)
				{
					test.log(Status.PASS, "User not successfully navigated to REPORTS page with shortcut keys function");
				}
				finally {}
		//Code To Check whether the user navigates to ADMINSTRATION page with shortcut keys function
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				chp.centuriMainPage().sendKeys(shortcutDialog);
				chp.administrationMainPageNavigation().click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				String getLink = driver.getCurrentUrl();
				Assert.assertEquals( getLink,adminPageLink);
				driver.navigate().back();
				test.log(Status.PASS, "User successfully navigated to ADMINSTRATION page with shortcut keys function");
				}
				catch (Exception e)
				{
					test.log(Status.PASS, "User not successfully navigated to ADMINSTRATION page with shortcut keys function");
				}
				finally {}
		//Code To Check whether the user navigates to HELP page with shortcut keys function
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				chp.centuriMainPage().sendKeys(shortcutDialog);
				chp.helpMainPageNavigation().click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				String getLink = driver.getCurrentUrl();
				Assert.assertEquals( getLink,helpPageLink);
				driver.navigate().back();
				test.log(Status.PASS, "User successfully navigated to HELP page with shortcut keys function");
				}
				catch (Exception e)
				{
					test.log(Status.PASS, "User not successfully navigated to HELP page with shortcut keys function");
				}
				finally {}
		//Code To Check whether the user navigates to SETTINGS page with shortcut keys function
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				chp.centuriMainPage().sendKeys(shortcutDialog);
				chp.settingsMainPageNavigation().click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
				WaitForTwoSeconds();
				String getLink = driver.getCurrentUrl();
				Assert.assertEquals( getLink,settingsPageLink);
				driver.navigate().back();
				driver.findElement(By.xpath("//button[@class='popup-msg-button btn-primary']//*[contains(text(),'OK')]")).click();
				test.log(Status.PASS, "User successfully navigated to SETTINGS page with shortcut keys function");
				}
				catch (Exception e)
				{
					test.log(Status.PASS, "User not successfully navigated to SETTINGS page with shortcut keys function");
				}
				finally {}
			
	}
	@Test(description ="Verify whether the user can navigate to respective pages with keyboard shorcut keys",priority=1)
	public void centuri_General_page_testcase_002() throws InterruptedException, IOException {
		test = extent.createTest("Navigation Shortcut popup – navigations through shortcut keys #TC-3.2-002");
		object();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
	//Code To Check whether the user navigated to New document page with keyboard shortcut keys
	/*	try {
		chp.centuriMainPage().sendKeys(documentPageNavigation);
		WaitForTwoSeconds();
		String getLink = driver.getCurrentUrl();
		Assert.assertEquals( getLink,documentPageLink);
		test.log(Status.PASS, "User successfully navigated to NEW DOCUMENT CREATION page with keyboard shortcut keys");
		}
		catch (Exception e)
		{
		test.log(Status.FAIL, "User not successfully navigated to NEW DOCUMENT CREATION page with keyboard shortcut keys");
		}
		finally {}
	//Code To Check whether the user navigated to New Form page with keyboard shortcut keys
		try {
			chp.centuriMainPage().sendKeys(formPageNavigation);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,formPageLink);
			test.log(Status.PASS, "User successfully navigated to NEW FORM CREATION page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to NEW FORM CREATION page with keyboard shortcut keys");
			}
			finally {}
	//Code To Check whether the user navigated to New Case page with keyboard shortcut keys
		try {
			chp.centuriMainPage().sendKeys(casePageNavigation);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,casePageLink);
			test.log(Status.PASS, "User successfully navigated to NEW CASE CREATION page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to NEW CASE CREATION page with keyboard shortcut keys");
			}
			finally {}
	//Code To Check whether the user navigated to New Case page with keyboard shortcut keys
			try {
			chp.centuriMainPage().sendKeys(casePageNavigation);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,casePageLink);
			test.log(Status.PASS, "User successfully navigated to NEW CASE CREATION page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to NEW CASE CREATION page with keyboard shortcut keys");
			}
			finally {}
	//Code To Check whether the user navigated to New CONTRACT page with keyboard shortcut keys
			try {
			chp.centuriMainPage().sendKeys(contractPageNavigation);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,contractPageLink);
			test.log(Status.PASS, "User successfully navigated to NEW CONTRACT CREATION page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to NEW CONTRACT CREATION page with keyboard shortcut keys");
			}
			finally {}
	//Code To Check whether the user navigated to New TASK page with keyboard shortcut keys
			try {
			chp.centuriMainPage().sendKeys(taskPageNavigation);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,taskPageLink);
			test.log(Status.PASS, "User successfully navigated to NEW TASK CREATION page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to NEW TASK CREATION page with keyboard shortcut keys");
			}
			finally {}
	//Code To Check whether the user navigated to portal page with keyboard shortcut keys
			try {
			chp.centuriMainPage().sendKeys(portalPageNavigationKeys);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,portalPageLink);
			test.log(Status.PASS, "User successfully navigated to PORTAL page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to PORTAL page with keyboard shortcut keys");
			}
			finally {}
	//Code To Check whether the user navigated to READ page with keyboard shortcut keys
			try {
			chp.centuriMainPage().sendKeys(readPageNavigationKeys);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,readPageLink);
			test.log(Status.PASS, "User successfully navigated to READ page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to READ page with keyboard shortcut keys");
			}
			finally {}
	//Code To Check whether the user navigated to CONTRACT page with keyboard shortcut keys
			try {
			chp.centuriMainPage().sendKeys(contractPageNavigationKeys);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,contractMainPageLink);
			test.log(Status.PASS, "User successfully navigated to CONTRACT page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to CONTRACT page with keyboard shortcut keys");
			}
			finally {}
	//Code To Check whether the user navigated to CASES page with keyboard shortcut keys
			try {
			chp.centuriMainPage().sendKeys(casesPageNavigationKeys);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,caseMainPageLink);
			test.log(Status.PASS, "User successfully navigated to CASES page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to CASES page with keyboard shortcut keys");
			}
			finally {}*/
	//Code To Check whether the user navigated to PDCA page with keyboard shortcut keys
			try {
			chp.centuriMainPage().sendKeys(pdcaPageNavigationKeys);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,riskMainPageLink);
			test.log(Status.PASS, "User successfully navigated to PDCA page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to PDCA page with keyboard shortcut keys");
			}
			finally {}
	//Code To Check whether the user navigated to SEARCH page with keyboard shortcut keys
			try {
			chp.centuriMainPage().sendKeys(searchPageNavigationKeys);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,SearchMainPageLink);
			test.log(Status.PASS, "User successfully navigated to SEARCH page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to SEARCH page with keyboard shortcut keys");
			}
			finally {}
	//Code To Check whether the user navigated to TODO page with keyboard shortcut keys
			try {
			chp.centuriMainPage().sendKeys(todoPageNavigationKeys);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,todoMainPageLink);
			test.log(Status.PASS, "User successfully navigated to TODO page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to TODO page with keyboard shortcut keys");
			}
			finally {}
	//Code To Check whether the user navigated to REPORTS page with keyboard shortcut keys
			try {
			chp.centuriMainPage().sendKeys(reportsPageNavigationKeys);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,reportsPageLink);
			test.log(Status.PASS, "User successfully navigated to REPORTS page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to REPORTS page with keyboard shortcut keys");
			}
			finally {}
	//Code To Check whether the user navigated to ADMIN page with keyboard shortcut keys
			try {
			chp.centuriMainPage().sendKeys(adminPageNavigationKeys);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,adminPageLink);
			test.log(Status.PASS, "User successfully navigated to ADMIN page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to ADMIN page with keyboard shortcut keys");
			}
			finally {}
	//Code To Check whether the user navigated to HELP page with keyboard shortcut keys
			try {
			chp.centuriMainPage().sendKeys(helpPageNavigationKeys);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,helpPageLink);
			test.log(Status.PASS, "User successfully navigated to HELP page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to HELP page with keyboard shortcut keys");
			}
			finally {}
	//Code To Check whether the user navigated to SETTINGS page with keyboard shortcut keys
			try {
			chp.centuriMainPage().sendKeys(settingsPageNavigationKeys);
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,settingsPageLink);
			test.log(Status.PASS, "User successfully navigated to SETTINGS page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to SETTINGS page with keyboard shortcut keys");
			}
			finally {}
	//Code To Check whether the user navigated to START page with keyboard shortcut keys
			try {
			chp.centuriMainPage().sendKeys(startPageNavigationKeys);
			driver.findElement(By.xpath("//button[@class='popup-msg-button btn-primary']//*[contains(text(),'OK')]")).click();
			WaitForTwoSeconds();
			String getLink = driver.getCurrentUrl();
			Assert.assertEquals( getLink,startPageLink);
			test.log(Status.PASS, "User successfully navigated to START page with keyboard shortcut keys");
			}
			catch (Exception e)
			{
				test.log(Status.PASS, "User not successfully navigated to START page with keyboard shortcut keys");
			}
			finally {}
	}
	

//	@Test(description ="Verify whether the home page contains mandatory widgets",priority=3)
	public void centuri_home_page_testcase_003() throws InterruptedException, IOException {
		test = extent.createTest("Homepage-Widgets #TC-3.3-003");
		object();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
		//Code To Check whether the My work widget is visible
	}
//	@Test(description ="Verify whether the home page (START)Popup contains all the MiniIcons",priority=4)
	public void centuri_home_page_testcase_004() throws InterruptedException, IOException {
		test = extent.createTest("Homepage-MiniIcons #TC-3.3-004");
		object();
		
		
	}
}



