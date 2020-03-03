package riskmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import objectrepository.CenturiAdminPage;
import objectrepository.CenturiLoginPage;

public class Centuri_Base {
	public static  WebDriver driver;
	WebDriverWait wait ;
	

public void userlogin() throws InterruptedException {
	
	  
	 CenturiLoginPage clp = new CenturiLoginPage(driver, wait);
	 	
	 //clp.user().sendKeys("james");
	 
	 //NOT USING THREAD AND WAITING FOR THE VISIBILITY OF ELEMENT
	 clp.waitForVisibilityOfElementuser().sendKeys("james");
	 //NOT USING THREAD AND WAITING FOR THE VISIBILITY OF ELEMENT
	 clp.waitForVisibilityOfElementsignin().click();
	 
	// clp.signinbutton().click();
	}

	@BeforeTest
	public void Launch_Browser() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver","D:\\chromedriver_80.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver_80.exe");
		
		 
		driver = new ChromeDriver();
		 driver.get("http://demo-centuri.conevo.in/");
		 driver.manage().window().maximize();
		
		 wait = new WebDriverWait(driver, 160);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		 userlogin();
		/* wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		  
		 CenturiLoginPage clp = new CenturiLoginPage(driver);
		 	
		 clp.user().sendKeys("james");
		 Thread.sleep(1000);
		 clp.signinbutton().click();*/
		
		 
		 
	}
/*@Test(description ="Verify whether user can able to login into the application",priority=1)
@Description("Verify whether user can able to login into the application")
@Epic("Sprint 84")
@Feature("UserLogin")
@Story("1234")
@Step("Verify User Login")
@Severity(SeverityLevel.NORMAL)
public void User_login() throws InterruptedException {
	 userlogin();
}*/

}
