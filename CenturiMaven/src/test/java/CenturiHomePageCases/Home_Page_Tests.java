package CenturiHomePageCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import objectrepository.CenturiHomePage;
import riskmodule.Centuri_Base;

public class Home_Page_Tests extends Centuri_Base {
	
	 CenturiHomePage chp; 
	public CenturiHomePage chp1; 
	String startText = "Start";
	String portalText = "Portal";
	String readText = "Read";
	String contractText = "Contracts";
	String casesText = "Cases";
	String pdcaText = "PDCA";
	String searchText = "Search";
	String todoText = "Todo";
	String reportsText = "Reports";
	String adminText = "Administrator";
	String helpText = "Help";
	
	
	String searchMainText = "Search in Centuri";
	public void object() {
		chp = new CenturiHomePage(driver,wait);
	}
	@Test(description ="Verify whether the home page contains functions icon",priority=1)
	public void centuri_home_page_testcase_001() throws InterruptedException, IOException {
		//test.log(Status.PASS, "Centuri login successfully done");
		test = extent.createTest("Homepage-Features #TC-3.3-001");
		test.log(Status.PASS, "User login is successfull");
		object();
		//chp = new CenturiHomePage(driver,wait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
		 Thread.sleep(2000);
		//if(chp.featureIconsContainer()!=null) {
		test.log(Status.PASS, "The functions icons are visible");
		
		//Code To Check whether the START function icon is visible
		try 
		{
		String getStart = chp.startIcon().getAttribute("innerText");
		Assert.assertEquals( getStart,startText);
		test.log(Status.PASS, "Under function icons - The START icon is visible");
		}
		catch (Exception e)
		{
		test.log(Status.FAIL, "Under function icons - The START icon is not visible");
		}
		finally {}
		
		//}
		//else {
			//test.log(Status.FAIL, "The functions icons are not visible");
		//}
		
		//Code To Check whether the PORTAL function icon is visible
		try {
			//test.createNode("Checking the PORTAL icon on home page");
			String getPortal = chp.portalIcon().getAttribute("innerText");
			Assert.assertEquals( getPortal,portalText);
			//Assert.assertTrue(true);
			test.log(Status.PASS, "Under function icons - The PORTAL icon is visible");
			}
		catch(Exception e) {
			//Assert.assertTrue(false);
			test.log(Status.FAIL, "Under function icons - The PORTAL icon is not visible");
		}finally{}
		
		//Code To Check whether the READ function icon is visible
		try {
			String getRead = chp.readIcon().getAttribute("innerText");
			Assert.assertEquals( getRead,readText);
			test.log(Status.PASS, "Under function icons - The READ icon is visible");
			}
		catch(Exception e) {
			test.log(Status.FAIL, "Under function icons - The READ icon is not visible");
		}finally{}
		
		//Code To Check whether the CONTRACTS function icon is visible
		try {
			String getContract = chp.contractsIcon().getAttribute("innerText");
			Assert.assertEquals( getContract,contractText);
			test.log(Status.PASS, "Under function icons - The CONTRACT icon is visible");
			}
		catch(Exception e) {
			test.log(Status.FAIL, "Under function icons - The CONTRACT icon is not visible");
		}finally{}
		
		//Code To Check whether the CASES function icon is visible
		try {
			String getCases = chp.casesIcon().getAttribute("innerText");
			Assert.assertEquals( getCases,casesText);
			test.log(Status.PASS, "Under function icons - The CASE icon is visible");
			}
		catch(Exception e) {
			test.log(Status.FAIL, "Under function icons - The CASE icon is not visible");
		}finally{}
		
		//Code To Check whether the PDCA function icon is visible
		try {
			String getRisk = chp.pdcaIcon().getAttribute("innerText");
			Assert.assertEquals( getRisk,pdcaText);
			test.log(Status.PASS, "Under function icons - The PDCA icon is visible");
			}
		catch(Exception e) {
			test.log(Status.FAIL, "Under function icons - The PDCA icon is not visible");
		}finally{}
		
		//Code To Check whether the SEARCH function icon is visible
		try {
			String getSearch = chp.searchIcon().getAttribute("innerText");
			Assert.assertEquals( getSearch,searchText);
			test.log(Status.PASS, "Under function icons - The SEARCH icon is visible");
			}
		catch(Exception e) {
			test.log(Status.FAIL, "Under function icons - The SEARCH icon is not visible");
		}finally{}
		
		//Code To Check whether the ToDo function icon is visible
		try {
			String getTodo = chp.todoIcon().getAttribute("innerText");
			Assert.assertEquals( getTodo,todoText);
			test.log(Status.PASS, "Under function icons - The TODO icon is visible");
			}
		catch(Exception e) {
			test.log(Status.FAIL, "Under function icons - The TODO icon is not visible");
		}finally{}
		
		//Code To Check whether the REPORT function icon is visible
		try {
			String getReport = chp.reportsIcon().getAttribute("innerText");
			Assert.assertEquals( getReport,reportsText);
			test.log(Status.PASS, "Under function icons - The REPORTS icon is visible");
			}
		catch(Exception e) {
			test.log(Status.FAIL, "Under function icons - The REPORTS icon is not visible");
		}finally{}
		
		//Code To Check whether the ADMIN function icon is visible
		try {
			String getAdministration = chp.adminIcon().getAttribute("innerText");
			Assert.assertEquals( getAdministration,adminText);
			test.log(Status.PASS, "Under function icons - The ADMINISTRATION icon is visible");
			}
		catch(Exception e) {
			test.log(Status.FAIL, "Under function icons - The ADMINISTRATION icon is not visible");
		}finally{}
		
		//Code To Check whether the HELP function icon is visible
		try {
			String getHelp = chp.helpIcon().getAttribute("innerText");
			Assert.assertEquals( getHelp,helpText);
			test.log(Status.PASS, "Under function icons - The HELP icon is visible");
			}
		catch(Exception e) {
			test.log(Status.FAIL, "Under function icons - The HELP icon is not visible");
		}finally{}
	
	}
	@Test(description ="Verify whether the home page contains search field",priority=2)
	public void centuri_home_page_testcase_002() throws InterruptedException, IOException {
		test = extent.createTest("Homepage-Search #TC-3.3-002");
		object();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
		//chp1 = new CenturiHomePage(driver,wait);
		try {
		Thread.sleep(3000);
		String getMainPageSearch = chp.searchMainText().getAttribute("innerText");
		Assert.assertEquals( getMainPageSearch,searchMainText);
		test.log(Status.PASS, "Search text above search field is visible");
		}
		catch (Exception e)
		{
		test.log(Status.FAIL, "Search text above search field is not visible");
		}
		finally {}
	}
	
	String myWorkText = "My work";
	String otherWaitText = "Others waiting for me";
	String deadLineText = "My deadlines";
	String recentReadText = "Recently read";
	String incomingWorkText = "Incoming work";
	String frequentReadText = "Frequently read";
	String newDocText = "New Documents";
	String myFavDoc = "My favorite documents";
	String notReadText = "Not read";
	String toAckText ="To acknowledge";
	@Test(description ="Verify whether the home page contains mandatory widgets",priority=3)
	public void centuri_home_page_testcase_003() throws InterruptedException, IOException {
		test = extent.createTest("Homepage-Widgets #TC-3.3-003");
		object();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
		//chp1 = new CenturiHomePage(driver,wait);
		try {
		Thread.sleep(3000);
		String getMyWorkText = chp.myWorkText().getText();
		Assert.assertEquals( getMyWorkText,myWorkText);
		test.log(Status.PASS, "'My Work' widget is visible");
		}
		catch (Exception e)
		{
		test.log(Status.FAIL, "'My Work' widget is not visible");
		}
		finally {}
		try {
		String getOthersWaitingText = chp.othersWaitingText().getText();
		Assert.assertEquals( getOthersWaitingText,otherWaitText);
		test.log(Status.PASS, "'Other waiting for work' widget is visible");
		}
		catch (Exception e)
		{
		test.log(Status.FAIL, "'Other waiting for work' widget is not visible");
		}
		finally {}
		try {
		String getDeadLineText = chp.myDeadlinesText().getText();
		Assert.assertEquals( getDeadLineText,deadLineText);
		test.log(Status.PASS, "'My deadlines' widget is visible");
		}
		catch (Exception e)
		{
		test.log(Status.FAIL, "'My deadlines' widget is not visible");
		}
		finally {}
		try {
		String getRecentReadText = chp.recentlyReadText().getText();
		Assert.assertEquals( getRecentReadText,recentReadText);
		test.log(Status.PASS, "'Recently read' widget is visible");
		}
		catch (Exception e)
		{
		test.log(Status.FAIL, "'Recently read' widget is not visible");
		}
		finally {}
		try {
		String getincomingText = chp.incomingWorkText().getText();
		Assert.assertEquals( getincomingText,incomingWorkText);
		test.log(Status.PASS, "'Incoming work' widget is visible");
		}
		catch (Exception e)
		{
		test.log(Status.FAIL, "'Incoming work' widget is not visible");
		}
		finally {}	
		try {
		String getfreqReadText = chp.freqReadText().getText();
		Assert.assertEquals( getfreqReadText,frequentReadText);
		test.log(Status.PASS, "'Frequently read' widget is visible");
		}
		catch (Exception e)
		{
		test.log(Status.FAIL, "'Frequently read' widget is not visible");
		}
		finally {}	
		try {
		String getNewDocText = chp.newDocText().getText();
		Assert.assertEquals( getNewDocText,newDocText);
		test.log(Status.PASS, "'New Documents' widget is visible");
		}
		catch (Exception e)
		{
		test.log(Status.FAIL, "'New Documents' widget is not visible");
		}
		finally {}
		try {
		String getFavDocText = chp.myFavDocText().getText();
		Assert.assertEquals( getFavDocText,myFavDoc);
		test.log(Status.PASS, "'My favorite documents' widget is visible");
		}
		catch (Exception e)
		{
		test.log(Status.FAIL, "'My favorite documents' widget is not visible");
		}
		finally {}
		try {
		String getnotReadText = chp.notReadText().getText();
		Assert.assertEquals( getnotReadText,notReadText);
		test.log(Status.PASS, "'Not read' widget is visible");
		}
		catch (Exception e)
		{
		test.log(Status.FAIL, "'Not read' widget is not visible");
		}
		finally {}
		try {
		String getAckText = chp.toAckText().getText();
		Assert.assertEquals( getAckText,toAckText);
		test.log(Status.PASS, "'To acknowledge' widget is visible");
		}
		catch (Exception e)
		{
		test.log(Status.FAIL, "'To acknowledge' widget is not visible");
		}
		finally {}
	}
	String miniStartIcon = "START";
	@Test(description ="Verify whether the home page (START)Popup contains all the MiniIcons",priority=4)
	public void centuri_home_page_testcase_004() throws InterruptedException, IOException {
		test = extent.createTest("Homepage-MiniIcons #TC-3.3-004");
		object();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'START')]")).click();
		Thread.sleep(1500);
		try {
			String getSetText = chp.settingsText().getText();
			test.createNode("Checking SETTINGS Button");
			Assert.assertEquals( getSetText,"SETTINGS");
			Assert.assertTrue(true);
			//test.log(Status.PASS, "Settings option is visible");
			}
			catch (Exception e)
			{
				Assert.assertFalse(false);
			//test.log(Status.FAIL, "Settings option is not visible");
			}
			finally {}
		 
		try {
			String getSignoutText = chp.signoutText().getText();
			Assert.assertEquals( getSignoutText,"SIGN OUT");
			test.log(Status.PASS, "Signout button is visible");
			}
			catch (Exception e)
			{
			test.log(Status.FAIL, "Signout button is not visible");
			}
			finally {}
		try {
			String getRefreshText = chp.refreshText().getText();
			Assert.assertEquals( getRefreshText,"REFRESH");
			test.log(Status.PASS, "Refresh button is visible");
			}
			catch (Exception e)
			{
			test.log(Status.FAIL, "Refresh button is not visible");
			}
			finally {}
		WebElement menuOptions = driver.findElement(By.xpath("//div[@class='main-menu ng-isolate-scope']//ul"));
		List<WebElement> links = menuOptions.findElements(By.xpath("//div[@class='main-menu ng-isolate-scope']//li"));
		 List<String> all_elements_text=new ArrayList<>();
		for (int i = 0; i < links.size(); i++){ 
			all_elements_text.add(links.get(i).getAttribute("innerText"));
		}
		System.out.println(all_elements_text);
		if( all_elements_text.contains("START") &&
			all_elements_text.contains("PORTAL") &&
			all_elements_text.contains("READ") &&
			all_elements_text.contains("CONTRACTS") &&
			all_elements_text.contains("CASES") &&
			all_elements_text.contains("PDCA") &&
			all_elements_text.contains("SEARCH") &&
			all_elements_text.contains("TODO") &&
			all_elements_text.contains("REPORTS") &&
			all_elements_text.contains("ADMINISTRATOR") &&
			all_elements_text.contains("HELP")) {
			test.log(Status.PASS, "All Mini Functions are visible");
		} else {
			test.log(Status.FAIL, "All Mini Functions are not visible");
		}
		
		
		
		
		
		
		//*[contains(text(),'Settings')]
		/*List<WebElement> links = driver.findElements(By.xpath("//div[@class='main-menu ng-isolate-scope']"));
		Iterator<WebElement> iter = links.iterator();
		while(iter.hasNext()) {
		    WebElement we = iter.next();
		    String req = we.getText();
		    System.out.println(req);
		    if (req.equals("Start")) {
		        System.out.println("PASS");
		    // do something in else perhaps
		    }
		}*/
	}
}



