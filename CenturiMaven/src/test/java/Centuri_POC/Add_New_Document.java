package Centuri_POC;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import objectrepository.CenturiHomePage;
import objectrepository.CenturiNewDocuemntPage;
import objectrepository.CenturiReadPage;
import objectrepository.CenturiToDoPage;
import riskmodule.Centuri_Base;

public class Add_New_Document extends Centuri_Base {
	CenturiHomePage chp; 
	CenturiNewDocuemntPage cndp;
	CenturiToDoPage ctdp;
	CenturiReadPage crp;
	String documentName = "Automated Document";
	
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
		cndp.waitForVisibilityOfElementDocTitleField().sendKeys(documentName);
		cndp.waitForVisibilityOfElementDocTitleNextButton().click();
		cndp.waitForVisibilityOfElementDocTag().click();
		Thread.sleep(1500);
		cndp.waitForVisibilityOfElementDocCompletButton().click();
		cndp.waitForVisibilityOfElementdownloadDocButton().click();
		Thread.sleep(3000);
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
		if(getToDo == "TODO" || getToDo == "TO-DO") {
		//if(ctdp.todoText().isDisplayed()) {
			test.log(Status.PASS, "User navigated to ToDo page");
		} else {
			driver.get("http://demo-centuri.conevo.in/#/todo/work");
		}
		Thread.sleep(5000);
		waitForProcessedDocument();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Automated Document')]")));
		Thread.sleep(3000);
		WebElement allDocuments = driver.findElement(By.xpath("//ul[@class='list-ctx']"));
		List<WebElement> documentNameList = allDocuments.findElements(By.xpath("//ul[@class='list-ctx']//li//div//c-workflow-list-item//h3//a//span"));
		 List<String> all_document_text=new ArrayList<>();
		for (int i = 0; i < documentNameList.size(); i++){ 
			Thread.sleep(500);
			all_document_text.add(documentNameList.get(i).getAttribute("innerText"));
			}
			System.out.println(all_document_text);
			System.out.println("" +documentName+  "");
			if(all_document_text.contains(documentName)||all_document_text.contains("" +documentName+  "") ||
					all_document_text.contains(" Automated Document  ")) {
				test.log(Status.PASS, "Created " + documentName + " is displayed in the ToDo list");	
			}else {
				test.log(Status.FAIL, "Created " + documentName + " is not displayed in the ToDo list");	
			}
			
			if(ctdp.delegatePublicationButton().isDisplayed()) {
				ctdp.delegatePublicationButton().click();
				Thread.sleep(4000);
				WebElement droparea = driver.findElement(By.xpath("//c-drop-zone[@id='DROPZONE_SELECTFILEDIRECTIVE']"));

				// drop the file
				DropFile(new File("C:\\Users\\BALAJI\\Downloads\\"+documentName+".xlsm"), droparea, 0, 0);
				Thread.sleep(3000);
				ctdp.searchRecipient().sendKeys("James bond");
				ctdp.waitForVisibilityOfElementselectRecipient().click();
				ctdp.sendButton().click();
				waitForProcessedDocument();
				Thread.sleep(2000);
				ctdp.selectDocumentCheckBox().click();
				for (int i = 0; i < 2; i++){
					 //click the button
					ctdp.publishButton().click();
					Thread.sleep(4000);
					}
				waitForDocumentList();
				driver.get("http://demo-centuri.conevo.in/#/read/newWorkflows");
			}
			
		
	}
	
	@Test(description ="Adding a new document",priority=3)
	public void archiveDocument() throws InterruptedException, IOException {
		ObjCenturiReadPage();
		waitForProcessedDocument();
		ctdp.selectDocumentCheckBox().click();
		crp.subMenuButton().click();
		Thread.sleep(1000);
		crp.archiveButton().click();
	}
	public void object() {
		chp = new CenturiHomePage(driver,wait);
	}
	public void ObjCenturiNewDocuemntPage() {
		cndp = new CenturiNewDocuemntPage(driver,wait);
	}
	public void ObjCenturiTodoPage() {
		ctdp = new CenturiToDoPage(driver,wait);
	}
	public void ObjCenturiReadPage() {
		crp = new CenturiReadPage(driver,wait);
	}
	public void waitForProcessedDocument() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Automated Document')]")));
	}
	public void waitForDocumentList() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='list-ctx']")));
	}
	public void iterateThroughDocumentList(){
		
	}
}
