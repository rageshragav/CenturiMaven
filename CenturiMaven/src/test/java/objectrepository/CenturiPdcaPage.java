package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CenturiPdcaPage {
	WebDriver driver;
	private WebDriverWait webDriverWait;

	//private FluentWait webDriverWait;
	public CenturiPdcaPage(WebDriver driver,WebDriverWait webDriverWait) {
		this.driver = driver;	
		this.webDriverWait = webDriverWait;
	}
	
	
	By addrisk = By.xpath("//*[text()='_Add_']|//*[text()='Add']"); 
	By risktitle = By.xpath("//*[text()='Title']"); 
	//By riskTitleField = By.xpath("//div/section[input][1]"); 
	By riskTitleField = By.xpath("//*[@id='textField-ef9b34d1-c4ea-45fa-95b7-84909f2ebe63']");
	By descriptionField = By.xpath("//*/section/textarea");
	By ProbabilityField = By.xpath("//*[@id='integerField-c8b4e748-c9ca-422a-ba3c-696e9334dea4']");
	By ConsequenceField = By.xpath("//*[@id='integerField-0e6eba56-fe12-43cd-9846-286f1ccad7d2']");
	By AttachRegisterField = By.xpath("//*[@type='search']");
	By SelectRegister = By.xpath("//c-dropdown-table-select//tr[1]//td[1]");
	By SaveRisk = By.xpath("//*[text()='_Save_']|//*[text()='Save']");
	//By CloseRisk = By.xpath("//*[contains(text()='_Close_')]|//*[contains(text()='Close')]");
	By CloseRisk = By.xpath("//*[contains(text(),'Close')]");
	By SuccessMessage = By.xpath("//*[text()='Spara slutförd']|//*[text()='Saved succesfully']");
	By RiskListingWithNewAddedRisk = By.xpath("//ul/li/h3[contains(.,'Automated Risk')]"); 
	public WebElement waitForVisibilityOfElementaddriskbutton() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(addrisk));
	}
	public WebElement waitForVisibilityOfElementrisktitle() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(risktitle));
	}
	public WebElement riskTitleField() {
		return driver.findElement(riskTitleField);
	}
	public WebElement descriptionField() {
		return driver.findElement(descriptionField);
	}
	public WebElement ProbabilityField() {
		return driver.findElement(ProbabilityField);
	}
	public WebElement ConsequenceField() {
		return driver.findElement(ConsequenceField);
	}
	public WebElement AttachRegisterField() {
		return driver.findElement(AttachRegisterField);
	}
	public WebElement SelectRegister() {
		return driver.findElement(SelectRegister);
	}
	public WebElement SaveRiskButton() {
		return driver.findElement(SaveRisk);
	}
	public WebElement CloseRiskButton() {
		return driver.findElement(CloseRisk);
	}
	public WebElement SuccessMessage() {
		return driver.findElement(SuccessMessage);
	}
	public WebElement NewaddedRisk() {
		return driver.findElement(RiskListingWithNewAddedRisk);
	}
	
}
