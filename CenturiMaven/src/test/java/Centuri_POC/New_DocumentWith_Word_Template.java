package Centuri_POC;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import objectrepository.CenturiHomePage;
import objectrepository.CenturiNewDocuemntPage;
import objectrepository.CenturiReadPage;
import objectrepository.CenturiToDoPage;
import riskmodule.Centuri_Base;

public class New_DocumentWith_Word_Template extends Centuri_Base{
	CenturiHomePage chp; 
	CenturiNewDocuemntPage cndp;
	CenturiToDoPage ctdp;
	CenturiReadPage crp;
	String documentName = "Automated Document Word";
	String documentdescription = "This is the test description filled when running the test automation";
	List <String> all_document_text;
	

@Test(description ="Adding a new document",priority=1)
public void centuriNewDocumentcreation() throws InterruptedException, IOException {
	test = extent.createTest("Creating a New document");
	object();
	ObjCenturiNewDocuemntPage();
	chp.waitForVisibilityOfElementNewButton().click();
	chp.newDocumentCreateButton().click();
	cndp.waitForVisibilityOfElementCreateDoc().click();
	//cndp.waitForVisibilityOfElementWorkUnitCenturi().click();
	cndp.waitForVisibilityOfElementDocType().click();
	cndp.waitForVisibilityOfElementDocTemplateWord().click();
	cndp.waitForVisibilityOfElementDocTitleField().sendKeys(documentName);
	cndp.waitForVisibilityOfElementdocDescriptionField().sendKeys(documentdescription);
	cndp.waitForVisibilityOfElementDocTitleNextButton().click();
	cndp.waitForVisibilityOfElementDocTag().click();
	cndp.waitForVisibilityOfElementDocCompletButton().click(); 
	cndp.waitForVisibilityOfElementdownloadDocButton().click();
	cndp.waitForVisibilityOfElementtodoNavigation().click();
	test.log(Status.PASS, "New document creation is completed");
}
@Test(description ="Adding a new document",priority=2)
public void publishNewDocument() throws InterruptedException, IOException {
	test = extent.createTest("Document Delegate Publishing and publishing");
	ObjCenturiTodoPage();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ng-isolate-scope']//menu")));
	String getToDo = ctdp.todoText().getText();
	//System.out.println(getToDo);
	if(getToDo == "TODO" || getToDo == "TO-DO") {
		test.log(Status.PASS, "User navigated to ToDo page to 'Delegate publication'");
	} else {
		driver.get("http://demo-centuri.conevo.in/#/todo/work");
	}
	
	//Iterating through the list of available documents Checking the document visibility in the TODO page
	cndp.waitForVisibilityOfProcessedDocument();
	cndp.waitForVisibilityOfdisplayCountText();
	WebElement allDocuments = driver.findElement(By.xpath("//ul[@class='list-ctx']"));
	List<WebElement> documentNameList = allDocuments.findElements(By.xpath("//ul[@class='list-ctx']//li//div[@class='container']//li[@class='title']"));
	
	all_document_text=new ArrayList<>();
	for (int i = 0; i < documentNameList.size(); i++){ 
		all_document_text.add(documentNameList.get(i).getAttribute("innerText"));
		}
		//System.out.println(all_document_text);
		//System.out.println("" +documentName+  "");
		if(all_document_text.contains(documentName)||all_document_text.contains("" +documentName+  "")) {
			test.log(Status.PASS, "Created " + documentName + " is displayed in the ToDo list");	
		}else {
			test.log(Status.FAIL, "Created " + documentName + " is not displayed in the ToDo list");	
		}
		
		ctdp.waitForVisibilityOfElementDelegatePublicationButton();
		if(ctdp.waitForVisibilityOfElementDelegatePublicationButton().isDisplayed() || ctdp.publishButton().isDisplayed()) {
			cndp.waitForVisibilityOfElementdocumentListInTodo();
			driver.get("http://demo-centuri.conevo.in/#/todo/work");
			driver.navigate().refresh();
			
			//waiting for the document and selecting the checkbox of the document for saving, drag and drop the downloaded file
			cndp.waitForVisibilityOfProcessedDocument();
			ctdp.selectDocumentCheckBox().click();
			ctdp.subMenuThreeDotsIcon().click();
			ctdp.saveDocumentButton().click();
			try {
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//c-drop-zone[@id='DROPZONE_SELECTFILEDIRECTIVE']"))));
			WebElement droparea = driver.findElement(By.xpath("//c-drop-zone[@id='DROPZONE_SELECTFILEDIRECTIVE']"));
			// drop the file
			DropFile(new File("C:\\Users\\BALAJI\\Downloads\\"+documentName+".docx"), droparea, 0, 0);
			test.log(Status.PASS, "Dragged and dropped the Downloaded Automated Document for delegation publish");
			
			}catch(Exception e) {
				test.log(Status.FAIL, "Drag and drop popup is not visible");
				System.out.println(e);
			}
			finally {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'Please wait while the document is saved.')]")));
				//Clicking on the delegate publication button after the file saved successfully
				ctdp.waitForVisibilityOfElementDelegatePublicationButton().click();
			}
			ctdp.waitForVisibilityOfElementrecipientText();
			ctdp.waitForVisibilityOfElementsearchRecipient();
			ctdp.searchRecipient().sendKeys("James bond");
			ctdp.waitForVisibilityOfElementselectRecipient().click();
			ctdp.sendButton().click();
			test.log(Status.PASS, "Automated Document moved to 'Document delegation' stage and its completed");
			cndp.waitForVisibilityOfProcessedDocument();
			ctdp.selectDocumentCheckBox().click();
			ctdp.waitForVisibilityOfElementpublishButton();
			if(ctdp.waitForVisibilityOfElementpublishButton().isDisplayed()) {
			for (int i = 0; i < 2; i++){
				 //click the button
				ctdp.waitForVisibilityOfElementpublishButton().click();
				Thread.sleep(4000);
				}
			crp.waitForDocumentList();
			test.log(Status.PASS, "Document moved to publish stage and publish is completed");
			driver.get("http://demo-centuri.conevo.in/#/read/newWorkflows");
			}
		}
		else {
			test.log(Status.FAIL, "'Delegate publication' button is not visible, check stages chart");
		}
		
	
}

@Test(description ="Archive a new document",priority=3)
public void archiveDocument() throws InterruptedException, IOException {
	test = extent.createTest("Archive the Automated document");
	ObjCenturiReadPage();
	cndp.waitForVisibilityOfProcessedDocument();
	ctdp.selectDocumentCheckBox().click();
	crp.waitforsubMenuButton().click();
	crp.waitforarchiveButton().click();
	crp.waitforarchiveText();
	crp.waitforSendToArchiveButton().click();
	crp.waitForDocumentList();
	if(driver.getPageSource().contains(documentName)) {
		test.log(Status.FAIL, "Automated document didnt moved to archieved stage");
	}else {
		test.log(Status.PASS, "Automated document successfully moved to archieved stage");
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

}

/*
 * //Iterating through the list of available documents Checking the document visibility in the TODO page
			cndp.waitForVisibilityOfProcessedDocument();
			cndp.waitForVisibilityOfdisplayCountText();
			WebElement allDocumentsList = driver.findElement(By.xpath("//ul[@class='list-ctx']"));
List<WebElement> documentStages = allDocumentsList.findElements(By.xpath("//div[@class='content-wrapper list-item loaded ng-scope list-item-hover list-item-selected']"));

List <String>all_document_stages=new ArrayList<>();
for (int i = 0; i < documentStages.size(); i++){ 
	//Thread.sleep(500);
	all_document_stages.add(documentStages.get(i).getAttribute("innerText"));
	}
	System.out.println(all_document_stages);
	System.out.println("" +documentName+  "");
	if(all_document_text.contains(documentName)||all_document_text.contains("" +documentName+  "")) {
		test.log(Status.PASS, "Created " + documentName + " is displayed in the ToDo list");	
	}else {
		test.log(Status.FAIL, "Created " + documentName + " is not displayed in the ToDo list");	
	}*/
