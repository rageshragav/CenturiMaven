package Centuri_Admin_Page_Cases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import objectrepository.CenturiAdminPage;
import objectrepository.CenturiHomePage;
import riskmodule.Centuri_Base;

public class Administration_Cases  extends Centuri_Base {
	CenturiAdminPage cap; 
	CenturiHomePage chp;
	String workflowName = "Automated workflow";
		String searchMainText = "Search in Centuri";
		public void objectAdminPage() {
			cap = new CenturiAdminPage(driver,wait);
		}
		public void objectHomePage() {
			chp = new CenturiHomePage(driver,wait);
		}
		
		
		String[] list = {"Dansk","English","Norsk","Deutsch","Svenska"}; 
		@Test(description ="Verify Amininstration->System->General",priority=1)
		public void centuri_Admin_page_testcase_001() throws InterruptedException, IOException {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			test = extent.createTest("Enable/disable language -Features #TC-3.1-001");
			objectAdminPage();
			cap.adminIcon().click();
			//cap.generalOption().click();
			test.log(Status.INFO, "Compicated test case - Yet to create scripts");
			//cap.editButton().click();
			 // js.executeScript("window.scrollBy(0,1000)");
			/*cap.languageDropdown().click();
			String langList = cap.languageList().getText();
			langList.toCharArray();
			System.out.println(langList);
			if(list.equals(langList)) {
				System.out.println("PASS");
			}
			 
			WebElement checkbox = driver.findElement(By.xpath("//c-checkbox[@id='']//label//*[local-name()='svg']//*[name()='g' and contains(@fill,'none')]//*[name()='path' and contains(@class,'checkbox-b')]"));
			// 	WebElement checkbox = driver.findElement(By.xpath("//c-checkbox[@enabled='true']//label//*[local-name()='svg']//svg[@width=\"15\"]"));
			checkbox.click();
			if(checkbox.isSelected()) {
				System.out.println("Checkbox is checked");
				checkbox.click();
				
			}else
			{
				System.out.println("Checkbox is not checked");
			}*/
			
			
}
		public void un_check_ModuleIcons() throws InterruptedException{
			//waiting for all the modules icon visibility with checkbox
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='module-list']")));
			//Clicking on each checkbox of the modules and saving
			for(int j=2; j<=6; j++){
				driver.findElement(By.xpath("//td[" + j + "]//c-checkbox[1]//label[1]//*[local-name()='svg']")).click();
						}
			//Clicking on REPORTS and HELP icon check boxes
			driver.findElement(By.xpath("//td[8]//c-checkbox[1]//label[1]//*[local-name()='svg']")).click();
			driver.findElement(By.xpath("//td[11]//c-checkbox[1]//label[1]//*[local-name()='svg']")).click();
			//Clicking on save and waiting until the success popup disappears
			cap.save().click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//c-status-feedback[@class='item ng-isolate-scope success']//span[@class='ng-scope']")));
			
		}
		//@Test(description ="Verify Amininstration->System->Modules",priority=2)
		public void centuri_Admin_page_testcase_002() throws InterruptedException, IOException {
			test = extent.createTest("Enable/disable modules -Features ##TC-3.1.15.1-001");
			objectHomePage();
			//clicking on modules option
			cap.modulesOption().click();
			//Method to uncheck the checked modules icons
			un_check_ModuleIcons();
			//Navigation to start page to see the changes
			driver.get("http://demo-centuri.conevo.in/#/start/content");
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
			
			//Validating the modules icons visibility
			
			if(chp.portalMenu().size()!=0 &&
			   chp.contractMenu().size()!=0 &&
				chp.caseMenu().size()!=0 &&
				chp.riskMenu().size()!=0 &&
				chp.reportsMenu().size()!=0 &&
				chp.helpMenu().size()!=0) {
				System.out.println("Testcase failed");
				test.log(Status.FAIL, "Some module icon is visible from Unchecked modules - Case not working as expected");
			}else
			{
				test.log(Status.PASS, "Unchecked modules icons are not visible in home page - Case is working");
				System.out.println("Testcase passed");
			}
			//
			driver.get("http://demo-centuri.conevo.in/#/admin/modules");
	        //Method to check the unchceked modules icons 
			un_check_ModuleIcons();
			//Navigation to start page to see the changes
			driver.get("http://demo-centuri.conevo.in/#/start/content");
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fixed-widgets']")));
			
			if(chp.portalMenu().size()!=0 &&
					   chp.contractMenu().size()!=0 &&
						chp.caseMenu().size()!=0 &&
						chp.riskMenu().size()!=0 &&
						chp.reportsMenu().size()!=0 &&
						chp.helpMenu().size()!=0) {
						//System.out.println("Testcase passed");
						test.log(Status.PASS, "Unchecked modules icons are not visible in home page - Case is working");
					}else
					{
						test.log(Status.PASS, "Some module icon is visible from Unchecked modules - Case not working as expected");
						//System.out.println("Testcase failed");
					}
					
			}
		@Test(description ="Verify Amininstration->System->Modules",priority=2)
		public void centuri_Admin_page_testcase_3_1_2_1() throws InterruptedException, IOException {
			test = extent.createTest("Create new workflow - #TC-3.1.2.1-001");
			cap.configuration().click();
			/*cap.newWorkFlow().click();
			cap.toggleDown().click();
			cap.workflowDropDown().findElement(By.xpath("//li[8]//div[2]//div[1][contains(text(),'Document for immediate publication')]")).click();
			cap.workflowTitle().click();
			cap.fillTitle().click();
			cap.fillTitleEditor().sendKeys(workflowName);
			cap.titleOKBtn().click();
			cap.saveWorkFlow().click();
			cap.closeWorkFlowEdit().click();*/
			cap.waitForWorkFlowList();
			if(cap.waitForWorkFlowList().isDisplayed()) {
				List<WebElement> workflowNameList = cap.waitForWorkFlowList().findElements(By.xpath("//ul[@class='list-ctx']//li//div[@class='container']//h3//a"));
				
				List <String> all_flowname_text =new ArrayList<>();
				for (int i = 0; i < workflowNameList.size(); i++){ 
					all_flowname_text.add(workflowNameList.get(i).getAttribute("innerText"));
					}
					System.out.println(all_flowname_text);
					//System.out.println("" +documentName+  "");
					if(all_flowname_text.contains(workflowName)||all_flowname_text.contains("" +workflowName+  "")) {
						test.log(Status.PASS, "Created " + workflowName + " is displayed in the workflow list");	
					}else {
						test.log(Status.FAIL, "Created " + workflowName + " is not displayed in the workflow list");	
					}
			}else {
				test.log(Status.FAIL, "cannot check" + workflowName + " in the workflow list");
			}
			}
		
		}
