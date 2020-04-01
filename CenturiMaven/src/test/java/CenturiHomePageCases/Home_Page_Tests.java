package CenturiHomePageCases;

import java.io.IOException;

import org.openqa.selenium.By;
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
	@Test(description ="Verify whether the home page contains functions icon",priority=1,enabled=false)
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
			String getPortal = chp.portalIcon().getAttribute("innerText");
			Assert.assertEquals( getPortal,portalText);
			test.log(Status.PASS, "Under function icons - The PORTAL icon is visible");
			}
		catch(Exception e) {
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
	@Test(description ="Verify whether the home page cases running successfully",priority=2)
	public void centuri_home_page_testcase_002() throws InterruptedException, IOException {
		test = extent.createTest("Homepage-Search #TC-3.3-002");
		object();
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
	//@Test(description ="Verify whether the home page cases running successfully",priority=3)
	public void centuri_home_page_testcase_003() throws InterruptedException, IOException {
		test = extent.createTest("Homepage-Widgets #TC-3.3-003");
		
	}

}


