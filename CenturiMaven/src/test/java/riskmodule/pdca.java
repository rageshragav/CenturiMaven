package riskmodule;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

/*import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;*/
import objectrepository.CenturiAdminPage;
import objectrepository.CenturiLoginPage;

public class pdca extends Centuri_Base {
	@Test(description ="Verify whether user can able to Enable/Disable view of the PDCA icon in home page")
	/*@Description("Verify whether user can able to Enable/Disable view of the PDCA icon in home pagen")
	@Epic("Sprint 84")
	@Feature("PDCA Icon Visibility")
	@Story("1234")
	@Step("PDCA Icon Visibility")
	@Severity(SeverityLevel.NORMAL)*/
	
	//(dependsOnMethods = { "login" })
	public void pdca_availability() throws InterruptedException, IOException {
		 test = extent.createTest("PDCA icon availability");
		 CenturiAdminPage cap = new CenturiAdminPage(driver,wait);
		 CenturiLoginPage clp = new CenturiLoginPage(driver, wait);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'START')]")));
		 Thread.sleep(3000);
		 executor.executeScript("arguments[0].click();",cap.adminstration());
		 Thread.sleep(3000);
		 cap.modules().click();	
		 Thread.sleep(2000);
		 if(cap.pdcaicon().isDisplayed()) {
			 cap.pdcacheckbox().click();
			 cap.save().click();
		 }else {
			 System.out.println("icon not visible");
		 }
		 Thread.sleep(2000);
		 executor.executeScript("arguments[0].click();",cap.adminstration());
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Logga ut']|//*[text()='Sign out']")));
		 cap.logout().click();
		 Thread.sleep(1000);
		 clp.waitForVisibilityOfElementsignin().click();
		//WebElement signin = driver.findElement(By.xpath("//*[contains(text(),'Logga in')][1]"));
		//signin.click();
		//Thread.sleep(1000);
		//For comparing the actual and expected images
		/*File image = new File("/Users/conevo/eclipse-workspace/Centuri/images/expected.png");
		BufferedImage bfi = ImageIO.read(image);
		boolean status = Shutterbug.shootPage(driver).withName("actual").equals(bfi,0.1);
		Assert.assertTrue(status);*/
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'START')]")));
		
		WebElement icons= driver.findElement(By.xpath("//*//ul[@class='module-navigator']"));
		List<WebElement> iconslist =icons.findElements(By.tagName("li"));
		for (WebElement li : iconslist) {
		if (li.getText().equals("PDCA")) {
		    System.out.println("PDCA icon not removed");
		   }else {
			   System.out.println("PDCA icon removed");
		   }
		}
		 executor.executeScript("arguments[0].click();",cap.adminstration());
		 Thread.sleep(3000);
		 cap.modules().click();
		 Thread.sleep(2000);
		 if(cap.pdcaicon().isDisplayed()) {
			 cap.pdcacheckbox().click();
			 cap.save().click();
		 }else {
			 System.out.println("icon not visible");
		 }
		boolean status = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='PDCA']")));
		Assert.assertTrue(status);
			
		
	}
	 
	
}
