package riskmodule;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import objectrepository.CenturiHomePage;
import objectrepository.CenturiPdcaPage;

public class Risk_Cases extends Centuri_Base{
	
 String EditRiskTitle = "Automated Edited Risk";
String RiskTitle = "Automated Risk";
 String RiskDescription = "Automated Risk";
 public CenturiHomePage chp;
 public CenturiPdcaPage PDCA_Page;
	
	/*public void setup() {
		 chp = new CenturiHomePage(driver, wait);
		 PDCA_Page = new CenturiPdcaPage(driver,wait);
	}*/
	
	@Test(description ="Verify whether user can able to add new risk")
			//,dependsOnMethods = { "User_login" })
	@Description("Verify whether user can able to add new risk")
	@Epic("Sprint 84")
	@Feature("Adding a new Risk")
	@Story("1234")
	@Step("Adding a new Risk")
	@Severity(SeverityLevel.NORMAL)
	//(dependsOnMethods = { "login" })
	public void Adding_New_Risk() throws InterruptedException, IOException {
		 
		 chp = new CenturiHomePage(driver, wait);
		 PDCA_Page = new CenturiPdcaPage(driver,wait);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'START')]")));
		Thread.sleep(2000);	
		//Assert.assertEquals(true, chp.pdcaicon().isDisplayed());
		 JavascriptExecutor js = (JavascriptExecutor) driver; 
		 js.executeScript("arguments[0].click();", chp.pdcaicon());
		// chp.waitForVisibilityOfElementpdcaicon().click();
		 PDCA_Page.waitForVisibilityOfElementaddriskbutton().click();
		 PDCA_Page.waitForVisibilityOfElementrisktitle();
		 PDCA_Page.riskTitleField().sendKeys(RiskTitle);
		 PDCA_Page.descriptionField().sendKeys(RiskDescription);
		 PDCA_Page.ProbabilityField().sendKeys("4");
		 PDCA_Page.ConsequenceField().sendKeys("3");
		 Thread.sleep(1000);
		 PDCA_Page.AttachRegisterField().sendKeys("test");
		 PDCA_Page.SelectRegister().click();
		 PDCA_Page.SaveRiskButton().click();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Spara slutförd')]")));
		//*[@id="popupContainer"]/div/c-alert/div[1]/p
		Thread.sleep(2000);
		 if(driver.getPageSource().contains("Saved successfully")) {
			 Thread.sleep(2000);
			 js.executeScript("arguments[0].click();", PDCA_Page.CloseRiskButton());
		 }else if (driver.findElement(By.className("popup-msg-content")).isDisplayed()) {
			 driver.findElement(By.id("ok")).click();
			 PDCA_Page.CloseRiskButton().click();
			 }
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("list-ctx")));
		 WebElement industries = driver.findElement(By.className("list-ctx"));
		 List<WebElement> links = industries.findElements(By.tagName("li"));
		 for (int i = 1; i < links.size(); i++)
		 {
		    String savedRisk = links.get(i).getText();
		    if(savedRisk.contains(RiskTitle)) {
		    	System.out.println("Riskadded");
		    	Assert.assertTrue(true);
		    	break ;
		    }
		    else {
		    	Assert.assertFalse(true);
		    	System.out.println("Risk not added");
		    }
		 }
		 try {
		wait.until(ExpectedConditions.visibilityOf(PDCA_Page.NewaddedRisk())); 
		 Assert.assertTrue(PDCA_Page.NewaddedRisk().isDisplayed());
		 PDCA_Page.NewaddedRisk().click();
		 }catch(AssertionError e) {
			 Reporter.log("New risk not listed");
			 throw e;
		 }
}
	@Test(description ="Verify whether user can able to add new risk",priority=2)
	//,dependsOnMethods = { "User_login" })
	@Description("Verify whether user can able to add new risk")
	@Epic("Sprint 84")
	@Feature("Adding a new Risk")
	@Story("1234")
	@Step("Adding a new Risk")
	@Severity(SeverityLevel.NORMAL)
//(dependsOnMethods = { "login" })
public void Edit_Risk() throws InterruptedException, IOException {
		 PDCA_Page.waitForVisibilityOfElementrisktitle();
		 Assert.assertEquals(true,PDCA_Page.waitForVisibilityOfElementrisktitle().isDisplayed());
		 PDCA_Page.riskTitleField().clear();
		 PDCA_Page.riskTitleField().sendKeys(EditRiskTitle);
		 PDCA_Page.descriptionField().sendKeys("Edited description");
		 PDCA_Page.ProbabilityField().sendKeys(Keys.BACK_SPACE + "5");
		 PDCA_Page.ConsequenceField().sendKeys(Keys.BACK_SPACE + "5");
	}
}