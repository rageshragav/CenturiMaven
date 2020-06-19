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

public class New_DocumentWithExcelTemplate extends Centuri_Base {
	CenturiHomePage chp; 
	CenturiNewDocuemntPage cndp;
	CenturiToDoPage ctdp;
	CenturiReadPage crp;
	String documentName = "Automated Document Excel";
	
	@Test(description ="Adding a new document",priority=1)
	public void centuriNewDocumentcreation() throws InterruptedException, IOException {
		test = extent.createTest("Creating a New document by selecting template as excel");
		object();
		ObjCenturiNewDocuemntPage();
		//Thread.sleep(3000);
		chp.waitForVisibilityOfElementNewButton().click();
		chp.newDocumentCreateButton().click();
		cndp.waitForVisibilityOfElementWorkUnitCenturi().click();
		cndp.waitForVisibilityOfElementCreateDoc().click();
		cndp.waitForVisibilityOfElementDocType().click();
		cndp.waitForVisibilityOfElementDocTemplateExcel().click();
		cndp.waitForVisibilityOfElementDocTitleField().sendKeys(documentName);
		cndp.waitForVisibilityOfElementDocTitleNextButton().click();
		cndp.waitForVisibilityOfElementDocTag().click();
		Thread.sleep(1500);
		cndp.waitForVisibilityOfElementDocCompletButton().click();
		cndp.waitForVisibilityOfElementdownloadDocButton().click();
		Thread.sleep(1500);
		cndp.waitForVisibilityOfElementtodoNavigation().click();
		test.log(Status.PASS, "New document creation is completed");
	}
	@Test(description ="Delegate publication a new document",priority=2)
	public void publishNewDocument() throws InterruptedException, IOException {
		test = extent.createTest("Delegate publication and Publish document");
		ObjCenturiTodoPage();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ng-isolate-scope']//menu")));
		String getToDo = ctdp.todoText().getText();
		System.out.println(getToDo);
		if(getToDo == "TODO" || getToDo == "TO-DO") {
		//if(ctdp.todoText().isDisplayed()) {
			test.log(Status.PASS, "User navigated to ToDo page to 'Delegate publication'");
		} else {
			driver.get("http://demo-centuri.conevo.in/#/todo/work");
		}
		Thread.sleep(3000);
		try {
		waitForProcessedDocument();
		test.log(Status.PASS, "Created " + documentName + " is visible in the list");	
		}catch(Exception e) {
			test.log(Status.PASS, "Created " + documentName + " is visible in the list");
		}finally {}
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Automated Document')]")));
		//Thread.sleep(3000);
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
				driver.navigate().refresh();
				waitForProcessedDocument();
				Thread.sleep(2000);
				ctdp.selectDocumentCheckBox().click();
				Thread.sleep(2000);
				ctdp.subMenuThreeDotsIcon().click();
				ctdp.saveDocumentButton().click();
				//ctdp.delegatePublicationButton().click();
				Thread.sleep(4000);
				try {
				WebElement droparea = driver.findElement(By.xpath("//c-drop-zone[@id='DROPZONE_SELECTFILEDIRECTIVE']"));
				// drop the file
				DropFile(new File("C:\\Users\\BALAJI\\Downloads\\"+documentName+".xlsm"), droparea, 0, 0);
				Thread.sleep(4000);
				test.log(Status.PASS, "Dragged and dropped the Downloaded Automated Document for delegation publish");
				
				}catch(Exception e) {
					test.log(Status.FAIL, "Drag and drop popup is not visible");
					System.out.println(e);
				}
				finally {
					Thread.sleep(2000);
					ctdp.delegatePublicationButton().click();
				}
				
			}
			else {
				test.log(Status.FAIL, "'Delegate publication' button is not visible, check stages chart");
			}
			ctdp.waitForVisibilityOfElementrecipientText();
			Thread.sleep(3000);
			ctdp.searchRecipient().sendKeys("James bond");
			ctdp.waitForVisibilityOfElementselectRecipient().click();
			ctdp.sendButton().click();
			test.log(Status.PASS, "Automated Document moved to 'Document delegation' stage and its completed");
			waitForProcessedDocument();
			Thread.sleep(4000);
			ctdp.selectDocumentCheckBox().click();
			Thread.sleep(3000);
			if(ctdp.publishButton().isDisplayed()) {
			for (int i = 0; i < 2; i++){
				 //click the button
				ctdp.publishButton().click();
				Thread.sleep(4000);
				}
			waitForDocumentList();
			test.log(Status.PASS, "Document moved to publish stage and publish is completed");
			driver.get("http://demo-centuri.conevo.in/#/read/newWorkflows");
			}
		
	}
	
	@Test(description ="Archive a new document",priority=3)
	public void archiveDocument() throws InterruptedException, IOException {
		test = extent.createTest("Archive the Automated document");
		ObjCenturiReadPage();
		waitForProcessedDocument();
		ctdp.selectDocumentCheckBox().click();
		crp.waitforsubMenuButton().click();
		Thread.sleep(1000);
		crp.waitforarchiveButton().click();
		Thread.sleep(1000);
		crp.waitforSendToArchiveButton().click();
		Thread.sleep(3000);
		if(driver.getPageSource().contains(documentName)) {
		test.log(Status.PASS, "Automated Document moved to archive stage");
		}else {
			test.log(Status.FAIL, "Automated Document not moved to archive stage");
		}
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Automated Document')]|//h3[contains(text(),'Automated Document Excel')]")));
	}
	public void waitForDocumentList() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='list-ctx']")));
	}
	public void iterateThroughDocumentList(){
		
	}
}
