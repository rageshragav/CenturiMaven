package CenturiHomePageCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import objectrepository.CenturiHomePage;
import riskmodule.Centuri_Base;

public class Home_Page_Tests extends Centuri_Base {
	
	public CenturiHomePage chp; 
	@Test(description ="Verify whether the home page contains functions icon",priority=1)
	public void centuri_home_page_testcase_001() throws InterruptedException, IOException {
		test = extent.createTest("Homepage-Features #TC-3.3-001");
		chp = new CenturiHomePage(driver,wait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
		 
		//Thread.sleep(3000);
		//boolean functionICons = chp.featureIconsContainer().isDisplayed();
		if(chp.featureIconsContainer()!=null) {
		test.log(Status.PASS, "The functions icons are visible");
			
		}else {
			
		}
	}
	@Test(description ="Verify whether the home page cases running successfully",priority=2)
	public void centuri_home_page_testcase_002() throws InterruptedException, IOException {
		test = extent.createTest("Homepage-Search #TC-3.3-002");
		
	}

}


