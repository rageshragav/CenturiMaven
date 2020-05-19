package riskmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import objectrepository.CenturiAdminPage;

public class Seed_RiskRegister extends Centuri_Base{
@Test
	public void seed_register() throws InterruptedException {
		 CenturiAdminPage cap = new CenturiAdminPage(driver,wait);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'START')]")));
			 Thread.sleep(3000);
			 executor.executeScript("arguments[0].click();",cap.adminstration());
			 Thread.sleep(2000);
			 cap.register().click();
			 //Thread.sleep(3000);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Risk Register')]")));
			 cap.riskregister().click();
			 Thread.sleep(2000);
			// Shutterbug.shootPage(driver,ScrollStrategy.WHOLE_PAGE).save("C:\\centuri\\screenshot");
			 
	}
}	
