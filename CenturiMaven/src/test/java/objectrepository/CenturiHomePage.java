package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CenturiHomePage {
	WebDriver driver;
	private WebDriverWait webDriverWait;

	//private FluentWait webDriverWait;
	public CenturiHomePage(WebDriver driver,WebDriverWait webDriverWait) {
		this.driver = driver;	
		this.webDriverWait = webDriverWait;
	}
	
//-----------------------------------------------------------------------------------------------------------------
	
	//Elements for creating NEW Document, Cases, Contracts, Form, Task
	By newWorkFlow = By.xpath("//*[@class='fa fa-small fa-plus circled']");
	By newDocumentCreateButton = By.xpath("//li[contains(text(),'Document')]");
	
	public WebElement newWorkFlow() {
		return driver.findElement(newWorkFlow);
	}
	public WebElement newDocumentCreateButton() {
		return driver.findElement(newDocumentCreateButton);
	}
	public WebElement waitForVisibilityOfElementNewButton() {
		  return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(newWorkFlow));
		  }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Elements used in test case 001
	By pdcaicon = By.xpath("//*[text()='PDCA']");
	By featureIconsContainer = By.xpath("//*[@class='fixed-widgets']");
	By startIcon = By.xpath("//li[@class='start-theme menu-item ng-scope']|//*[@class='ng-scope ng-isolate-scope']//li[@class='start-theme menu-item ng-scope']//div[@class='navigation-text']");
	By portalIcon = By.xpath("//li[@class='portal-theme menu-item ng-scope']//div[@class='navigation-text']");
	By readIcon = By.xpath("//li[@class='read-theme menu-item ng-scope']//div[@class='navigation-text']");
	By contractsIcon = By.xpath("//li[@class='contract-theme menu-item ng-scope']//div[@class='navigation-text']");
	By casesIcon = By.xpath("//li[@class='case-theme menu-item ng-scope']//div[@class='navigation-text']");
	By pdcaIcon = By.xpath("//li[@class='risk-theme menu-item ng-scope']//div[@class='navigation-text']");
	By searchIcon = By.xpath("//li[@class='search-theme menu-item ng-scope']//div[@class='navigation-text']");
	By todoIcon = By.xpath("//li[@class='todo-theme menu-item ng-scope']//div[@class='navigation-text']");
	By reportsIcon = By.xpath("//li[@class='reports-theme menu-item ng-scope']//div[@class='navigation-text']");
	By adminIcon = By.xpath("//li[@class='administrator-theme menu-item ng-scope']//div[@class='navigation-text']");
	By helpIcon = By.xpath("//li[@class='help-theme menu-item ng-scope']//div[@class='navigation-text']");
	
	
	public WebElement waitForVisibilityOfElementpdcaicon() {
		  return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(pdcaicon));
	}
	
	
	public WebElement pdcaicon() {
		return driver.findElement(pdcaicon);
	}
	public WebElement featureIconsContainer() {
		return driver.findElement(featureIconsContainer);
	}
	public WebElement startIcon() {
		return driver.findElement(startIcon);
	}
	public WebElement portalIcon() {
		return driver.findElement(portalIcon);
	}
	public WebElement readIcon() {
		return driver.findElement(readIcon);
	}
	public WebElement contractsIcon() {
		return driver.findElement(contractsIcon);
	}
	public WebElement casesIcon() {
		return driver.findElement(casesIcon);
	}
	public WebElement pdcaIcon() {
		return driver.findElement(pdcaIcon);
	}
	public WebElement searchIcon() {
		return driver.findElement(searchIcon);
	}
	public WebElement todoIcon() {
		return driver.findElement(todoIcon);
	}
	public WebElement reportsIcon() {
		return driver.findElement(reportsIcon);
	}
	public WebElement adminIcon() {
		return driver.findElement(adminIcon);
	}
	public WebElement helpIcon() {
		return driver.findElement(helpIcon);
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Elements used in test case 002
		By searchMainText = By.xpath("//*[@class='start-page']//div[@class='search-widget']//h2[@class='ng-binding']");
		By searchplaceHolderText =By.xpath("//div[@class='start-page']//div[@class='search-table']");
		public WebElement searchMainText() {
			return driver.findElement(searchMainText);
		}
		public WebElement searchplaceHolderText() {
			return driver.findElement(searchplaceHolderText);
		}
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
		//Elements used in test case 003
		By myWorkText = By.xpath("//a[contains(text(),'My work')]");
		By othersWaitingText = By.xpath("//a[contains(text(),'Others waiting for me')]");
		By myDeadlinesText = By.xpath("//a[contains(text(),'My deadlines')]");
		By recentlyReadText = By.xpath("//a[contains(text(),'Recently read')]");
		By incomingWorkText = By.xpath("//a[contains(text(),'Incoming work')]");
		By freqReadText = By.xpath("//a[contains(text(),'Frequently read')]");
		By newDocText = By.xpath("//a[contains(text(),'New Documents')]");
		By myFavDocText = By.xpath("//a[contains(text(),'My favorite documents')]");
		By notReadText = By.xpath("//a[contains(text(),'Not read')]");
		By toAckText = By.xpath("//a[contains(text(),'To acknowledge')]");
		
		public WebElement myWorkText() {
			return driver.findElement(myWorkText);
		}
		public WebElement othersWaitingText() {
			return driver.findElement(othersWaitingText);
		}
		public WebElement myDeadlinesText() {
			return driver.findElement(myDeadlinesText);
		}
		public WebElement recentlyReadText() {
			return driver.findElement(recentlyReadText);
		}
		public WebElement incomingWorkText() {
			return driver.findElement(incomingWorkText);
		}
		public WebElement freqReadText() {
			return driver.findElement(freqReadText);
		}
		public WebElement newDocText() {
			return driver.findElement(newDocText);
		}
		public WebElement myFavDocText() {
			return driver.findElement(myFavDocText);
		}
		public WebElement notReadText() {
			return driver.findElement(notReadText);
		}
		public WebElement toAckText() {
			return driver.findElement(toAckText);
		}
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
}
