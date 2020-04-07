package Centuri_POC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import objectrepository.CenturiHomePage;
import objectrepository.CenturiNewDocuemntPage;
import objectrepository.CenturiToDoPage;
import riskmodule.Centuri_Base;

public class Add_New_Document extends Centuri_Base {
	CenturiHomePage chp; 
	CenturiNewDocuemntPage cndp;
	CenturiToDoPage ctdp;
	String documentName = "Automated Document";
	public void object() {
		chp = new CenturiHomePage(driver,wait);
	}
	public void ObjCenturiNewDocuemntPage() {
		cndp = new CenturiNewDocuemntPage(driver,wait);
	}
	public void ObjCenturiTodoPage() {
		ctdp = new CenturiToDoPage(driver,wait);
	}
	//@Test(description ="Adding a new document",priority=1)
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
		cndp.waitForVisibilityOfElementDocTitleField().sendKeys(documentName);
		cndp.waitForVisibilityOfElementDocTitleNextButton().click();
		cndp.waitForVisibilityOfElementDocTag().click();
		Thread.sleep(1500);
		cndp.waitForVisibilityOfElementDocCompletButton().click();
		cndp.waitForVisibilityOfElementdownloadDocButton().click();
		cndp.waitForVisibilityOfElementtodoNavigation().click();
	}
	@Test(description ="Adding a new document",priority=2)
	public void publishNewDocument() throws InterruptedException, IOException {
		test = extent.createTest("Publish document");
		ObjCenturiTodoPage();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ng-isolate-scope']//menu")));
		String getToDo = ctdp.todoText().getText();
		System.out.println(getToDo);
		if(getToDo == "TODO") {
		//if(ctdp.todoText().isDisplayed()) {
			test.log(Status.PASS, "User navigated to ToDo page");
		} else {
			driver.get("http://demo-centuri.conevo.in/#/todo/work");
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='list-ctx']")));
		WebElement allDocuments = driver.findElement(By.xpath("//ul[@class='list-ctx']"));
		List<WebElement> documentlist = allDocuments.findElements(By.xpath("//ul[@class='list-ctx']//li//div//c-workflow-list-item//h3"));
		
		 List<String> all_document_text=new ArrayList<>();
			for (int i = 0; i < documentlist.size(); i++){ 
				all_document_text.add(documentlist.get(i).getAttribute("innerText"));
			}
			System.out.println(all_document_text);
			if(all_document_text.contains(documentName)) {
				//ctdp.newDocumentInList().click();
				
			}
			
		
	}
}
