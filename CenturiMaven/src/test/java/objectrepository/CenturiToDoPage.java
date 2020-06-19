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
	By subMenuThreeDotsIcon = By.className("submenu");
	By saveDocumentButton = By.xpath("//li[contains(text(),'Save')]");
	By delegatePublicationButton = By.xpath("//span[@class='ng-binding'][contains(text(),'Delegate publication')]");
	
	By waitdelegatePublicationButton = By.xpath("//span[@class='ng-binding'][contains(text(),'Delegate publication')]");
	By recipientText = By.xpath("//h2[contains(text(),'Recipients')]");
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
	public WebElement waitForVisibilityOfElementpublishButton() {
		//return driver.findElement(subMenuThreeDotsIcon);
		return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(publishButton));
	}
	public WebElement subMenuThreeDotsIcon() {
		//return driver.findElement(subMenuThreeDotsIcon);
		return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(subMenuThreeDotsIcon));
	}
	public WebElement delegatePublicationButton() {
		return driver.findElement(delegatePublicationButton);
	}
	public WebElement saveDocumentButton() {
		return driver.findElement(saveDocumentButton);
	}
	public WebElement waitForVisibilityOfElementrecipientText() {
		return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(recipientText));
	}
	public WebElement searchRecipient() {
		return driver.findElement(searchRecipient);
	}
	public WebElement waitForVisibilityOfElementsearchRecipient() {
		  return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(searchRecipient));
		  }
	public WebElement waitForVisibilityOfElementselectRecipient() {
		  return webDriverWait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(selectRecipient));
		  }
	public WebElement waitForVisibilityOfElementDelegatePublicationButton() {
		 return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(waitdelegatePublicationButton));
		  }
	/*public WebElement selectRecipient() {
		return driver.findElement(selectRecipient);
	}*/
	public WebElement sendButton() {
		return driver.findElement(sendButton);
	}
	public WebElement selectDocumentCheckBox() {
		 return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(selectDocumentCheckBox));
		//return driver.findElement(selectDocumentCheckBox);
	}
	public WebElement publishButton() {
		return driver.findElement(publishButton);
	}
	public WebElement cancelSend() {
		return driver.findElement(cancelSend);
	}
}
