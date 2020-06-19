package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CenturiAdminPage {
	WebDriver driver;
	private WebDriverWait webDriverWait;

	public CenturiAdminPage(WebDriver driver,WebDriverWait webDriverWait) {
		this.driver = driver;	
		this.webDriverWait = webDriverWait;
	}
	
	By adminIcon = By.xpath("//div[@class='ng-scope ng-isolate-scope']//*[contains(text(),'Administrator')]");
	public WebElement adminIcon() {
		  return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(adminIcon));
		  }
	
	
	//Admin main page side menu options
	By generalOption = By.xpath("//li[1]//li[1]//span[1]//a[1][contains(text(),'General')]");
	public WebElement generalOption() {
		  return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(generalOption));
		  }
	By editButton = By.xpath("//section//*[contains(text(),'Edit')]");
	public WebElement editButton() {
		  return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(editButton));
		  }
	By modulesOption = By.xpath("//li[1]//ul[1]//li[2]//span[1]//span[1]//a[1][contains(text(),'Modules')]");
	public WebElement modulesOption() {
		  return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(modulesOption));
		  }
	
	By languageDropdown = By.xpath("//i[@class='menu-angle fa fa-angle-down']");
	public WebElement languageDropdown() {
		  return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(languageDropdown));
		  }
	By languageList = By.xpath("//div[@class='select-menu-container ng-scope']");
	public WebElement languageList() {
		  return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(languageList));
		  }
	//Menu popup buttons
	By startlink = By.xpath("//*[contains(text(),'START')]");
	//By adminstration = By.xpath("//*[contains(text(),'Administrera')]"); 
	By adminstration = By.xpath("//*[text()='Administrera']|//*[text()='Administrator']"); 
	
	
	//Menu panel buttons
	By modules = By.xpath("//*[text()='Moduler']|//*[text()='Modules']"); 
	//By modules = By.xpath("//*[contains(text(),'Moduler')]");
	By register = By.xpath("//*[contains(text(),'Register')][1]");
	By configuration = By.xpath("//*[contains(text(),'Configuration')][1]");
	By newWorkFlow = By.xpath("//span[@class='ng-binding'][contains(text(),'New workflow')]");
	
	public WebElement modules() {
		return driver.findElement(modules);
	}
	
	public WebElement register() {
		return driver.findElement(register);
	}
	public WebElement configuration() {
		 return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(configuration));
	}
	public WebElement newWorkFlow() {
		 return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(newWorkFlow));
	}
	
	//NEW WORKFLOW PAGE
	By toggleDown = By.xpath("//i[@class='menu-angle fa fa-angle-down']");
	By workflowDropDown = By.xpath("//ul[@class='items ng-scope']");
	By workflowTitle = By.xpath("//i[@class='fa fa-edit']");
	By fillTitle = By.xpath("//li[3]//span[2]");
	By fillTitleEditor = By.xpath("//input[@id='langEditorInput']");
	By titleOKBtn = By.xpath("//button[@class='popup-msg-button btn-primary']//*[contains(text(),'OK')]");
	By saveWorkFlow = By.xpath("//li[@class='ng-scope']//span[@class='ng-binding'][contains(text(),'Save')]");
	By closeWorkFlowEdit = By.xpath("//span[@class='ng-binding'][contains(text(),'Close')]");
	By workflowList = By.xpath("//ul[@class='list-ctx']");
	public WebElement toggleDown() {
		 return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(toggleDown));
	}
	public WebElement workflowDropDown() {
		 return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(workflowDropDown));
	}
	public WebElement workflowTitle() {
		 return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(workflowTitle));
	}
	public WebElement fillTitle() {
		 return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(fillTitle));
	}
	public WebElement fillTitleEditor() {
		 return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(fillTitleEditor));
	}
	public WebElement titleOKBtn() {
		 return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(titleOKBtn));
	}
	public WebElement saveWorkFlow() {
		 return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(saveWorkFlow));
	}
	public WebElement closeWorkFlowEdit() {
		 return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(closeWorkFlowEdit));
	}
	public WebElement waitForWorkFlowList() {
		 return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(workflowList));
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
