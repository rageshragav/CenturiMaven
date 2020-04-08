package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CenturiNewDocuemntPage {
	WebDriver driver;
	private WebDriverWait webDriverWait;

	//private FluentWait webDriverWait;
	public CenturiNewDocuemntPage(WebDriver driver,WebDriverWait webDriverWait) {
		this.driver = driver;	
		this.webDriverWait = webDriverWait;
	}
	
	By selectWorkUnitCenturi = By.xpath("//a[contains(text(),'Centuri')]");
	By createDocument = By.xpath("//a[contains(text(),'Create document')]"); 
	By selectDocType = By.linkText("Checklist");
	By selectDocTemplate = By.xpath("//a[contains(text(),'Excel')]");
	By docTitleField = By.xpath("//input[@id='textField-30339f3e-2d71-4ba3-afee-e9f781be4d23']");
	By titleNext = By.xpath("//li[@class='ng-scope']//*[contains(text(),'Next')]");
	By selectDocTag = By.xpath("//*[@class='treeview-checkbox ng-scope ng-isolate-scope']//*[local-name()='svg']");
	By completeDocCreationButton = By.xpath("//li[@class='ng-scope']//*[contains(text(),'Complete')]");
	By downloadDocumentButton = By.xpath("//button[@id='action']");
	By todoNavigation = By.xpath("//*[contains(text(),'Yes')]");
	public WebElement selectWorkUnitCenturi() {
		return driver.findElement(selectWorkUnitCenturi);
	}
	
	public WebElement waitForVisibilityOfElementWorkUnitCenturi() {
		  return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(selectWorkUnitCenturi));
	}
	public WebElement waitForVisibilityOfElementCreateDoc() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(createDocument));
        }
    public WebElement waitForVisibilityOfElementDocType() {
            return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(selectDocType));
        }
    public WebElement waitForVisibilityOfElementDocTemplate() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(selectDocTemplate));
    }
    public WebElement waitForVisibilityOfElementDocTitleField() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(docTitleField));
    }
    public WebElement waitForVisibilityOfElementDocTitleNextButton() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(titleNext));
    }
    public WebElement waitForVisibilityOfElementDocTag() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(selectDocTag));
    }
    public WebElement waitForVisibilityOfElementDocCompletButton() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(completeDocCreationButton));
    }
    public WebElement waitForVisibilityOfElementdownloadDocButton() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(downloadDocumentButton));
    }
    public WebElement waitForVisibilityOfElementtodoNavigation() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(todoNavigation));
    }
}
