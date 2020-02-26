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
	
	By pdcaicon = By.xpath("//*[text()='PDCA']");
	
	public WebElement waitForVisibilityOfElementpdcaicon() {
		  return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(pdcaicon));
	}
	
	public WebElement pdcaicon() {
		return driver.findElement(pdcaicon);
	}

	
}
