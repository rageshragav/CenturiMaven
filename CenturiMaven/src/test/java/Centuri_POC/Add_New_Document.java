package Centuri_POC;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import objectrepository.CenturiHomePage;
import objectrepository.CenturiNewDocuemntPage;
import riskmodule.Centuri_Base;

public class Add_New_Document extends Centuri_Base {
	CenturiHomePage chp; 
	CenturiNewDocuemntPage cndp;
	public void object() {
		chp = new CenturiHomePage(driver,wait);
	}
	public void ObjCenturiNewDocuemntPage() {
		cndp = new CenturiNewDocuemntPage(driver,wait);
	}
	@Test(description ="Adding a new document",priority=1)
	public void centuriNewDocumentcreation() throws InterruptedException, IOException {
		test = extent.createTest("New document creation");
		object();
		ObjCenturiNewDocuemntPage();
		//Thread.sleep(3000);
		chp.waitForVisibilityOfElementNewButton().click();
		chp.newDocumentCreateButton().click();
		cndp.waitForVisibilityOfElementWorkUnitCenturi().click();
		cndp.waitForVisibilityOfElementCreateDoc().click();
		cndp.waitForVisibilityOfElementDocType().click();
		cndp.waitForVisibilityOfElementDocTemplate().click();
		cndp.waitForVisibilityOfElementDocTitleField().sendKeys("Automated Document");
		cndp.waitForVisibilityOfElementDocTitleNextButton().click();
		cndp.waitForVisibilityOfElementDocTag().click();
		Thread.sleep(1500);
		cndp.waitForVisibilityOfElementDocCompletButton().click();
		cndp.waitForVisibilityOfElementdownloadDocButton().click();
		cndp.waitForVisibilityOfElementtodoNavigation().click();
		driver.get("http://demo-centuri.conevo.in/#/read/notRead");
	}
}
