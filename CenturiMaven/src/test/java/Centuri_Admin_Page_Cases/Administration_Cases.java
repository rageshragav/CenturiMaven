package Centuri_Admin_Page_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import objectrepository.CenturiAdminPage;
import riskmodule.Centuri_Base;

public class Administration_Cases  extends Centuri_Base {
	CenturiAdminPage cap; 
		
		String searchMainText = "Search in Centuri";
		public void object() {
			cap = new CenturiAdminPage(driver,wait);
		}
		
		
		String[] list = {"Dansk","English","Norsk","Deutsch","Svenska"}; 
		@Test(description ="Verify Amininstration->System->General",priority=1)
		public void centuri_Admin_page_testcase_001() throws InterruptedException, IOException {

			test = extent.createTest("Enable/disable language -Features #TC-3.1-001");
			test.log(Status.PASS, "User login is successfull");
			object();
			cap.adminIcon().click();
			cap.generalOption().click();
			cap.editButton().click();
			WaitForTwoSeconds();
			cap.languageDropdown().click();
			String langList = cap.languageList().getText();
			langList.toCharArray();
			System.out.println(langList);
			if(list.equals(langList)) {
				System.out.println("PASS");
			}
}
		}
