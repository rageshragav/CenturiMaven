package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CenturiToDoPage {
	WebDriver driver;
	private WebDriverWait webDriverWait;

	//private FluentWait webDriverWait;
	public CenturiToDoPage(WebDriver driver,WebDriverWait webDriverWait) {
		this.driver = driver;	
		this.webDriverWait = webDriverWait;
	}
	
//-----------------------------------------------------------------------------------------------------------------
	
	//Elements for creating NEW Document, Cases, Contracts, Form, Task
	By todoText = By.xpath("//div[@class='ng-isolate-scope']//menu");
	By newDocumentInList = By.xpath("//*[@class='list-ctx']//li//div//c-workflow-list-item//h3//span[contains(text(),'Automated Document')]");
	By delegatePublicationButton = By.xpath("//span[@class='ng-binding'][contains(text(),'Delegate publication')]");
	By waitdelegatePublicationButton = By.xpath("//span[@class='ng-binding'][contains(text(),'Delegate publication')]");
	By searchRecipient = By.xpath("//div[@class='selected']//input");
	By selectRecipient = By.xpath("//div[@class='container']//span[contains(text(),'James Bond (james)')]");
	By sendButton = By.xpath("//li[@class='ng-scope']//span[contains(text(),'Send')]");
	By selectDocumentCheckBox = By.xpath("//li[1]//c-checkbox[1]//*[local-name()='svg']");
	By publishButton = By.xpath("//ul[@class='ng-scope']//*[contains(text(),'Publish')]");
	By cancelSend = By.xpath("//li[@class='ng-scope']//span[contains(text(),'Cancel')]");
	public WebElement todoText() {
		return driver.findElement(todoText);
	}
	public WebElement newDocumentInList() {
		return driver.findElement(newDocumentInList);
	}
	public WebElement delegatePublicationButton() {
		return driver.findElement(delegatePublicationButton);
	}
	public WebElement searchRecipient() {
		return driver.findElement(searchRecipient);
	}
	public WebElement waitForVisibilityOfElementselectRecipient() {
		  return webDriverWait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(selectRecipient));
		  }
	public WebElement waitdelegatePublicationButton() {
		 return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(waitdelegatePublicationButton));
		  }
	/*public WebElement selectRecipient() {
		return driver.findElement(selectRecipient);
	}*/
	public WebElement sendButton() {
		return driver.findElement(sendButton);
	}
	public WebElement selectDocumentCheckBox() {
		return driver.findElement(selectDocumentCheckBox);
	}
	public WebElement publishButton() {
		return driver.findElement(publishButton);
	}
	public WebElement cancelSend() {
		return driver.findElement(cancelSend);
	}
}
