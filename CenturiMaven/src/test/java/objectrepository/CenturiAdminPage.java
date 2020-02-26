package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CenturiAdminPage {
	WebDriver driver;

	public CenturiAdminPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	
	//Menu popup buttons
	By startlink = By.xpath("//*[contains(text(),'START')]");
	//By adminstration = By.xpath("//*[contains(text(),'Administrera')]"); 
	By adminstration = By.xpath("//*[text()='Administrera']|//*[text()='Administrator']"); 
	
	
	//Menu panel buttons
	By modules = By.xpath("//*[text()='Moduler']|//*[text()='Modules']"); 
	//By modules = By.xpath("//*[contains(text(),'Moduler')]");
	By register = By.xpath("//*[contains(text(),'Register')][1]");

	
	public WebElement modules() {
		return driver.findElement(modules);
	}
	
	public WebElement register() {
		return driver.findElement(register);
	}
	
	
	//Register menu
	By riskregister = By.xpath("//*[contains(text(),'Risk Register')]");
	
	public WebElement riskregister() {
		return driver.findElement(riskregister);
	}
	
	By pdcacheckbox = By.xpath("//body//td[6]");
	By pdcaicon = By.xpath("//*[@class='module-icon menu-item risk-theme']");
	By save = By.xpath("//*[text()='Spara']|//*[text()='Save']");
	By logout = By.xpath("//*[text()='Logga ut']|//*[text()='Sign out']"); 
	//By logout = By.xpath("//*[text()='Logga ut']");
	public WebElement startlink() {
		return driver.findElement(startlink);
	}
	
	public WebElement adminstration() {
		return driver.findElement(adminstration);
	}
	
	public WebElement pdcacheckbox() {
		return driver.findElement(pdcacheckbox);
	}
	public WebElement pdcaicon() {
		return driver.findElement(pdcaicon);
	}
	public WebElement save() {
		return driver.findElement(save);
	}
	public WebElement logout() {
		return driver.findElement(logout);
	}
	
}
