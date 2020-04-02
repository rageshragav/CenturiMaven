package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CenturiNewDocuemnt {
	WebDriver driver;
	private WebDriverWait webDriverWait;

	//private FluentWait webDriverWait;
	public CenturiNewDocuemnt(WebDriver driver,WebDriverWait webDriverWait) {
		this.driver = driver;	
		this.webDriverWait = webDriverWait;
	}
	
	By username = By.id("username");
	//By signin = By.xpath("//*[contains(text(),'Logga in')][1]"); 
	By signin = By.xpath("//*[text()='Logga in']|//*[text()='Sign in']"); 
	
	public WebElement user() {
		return driver.findElement(username);
	}
	public WebElement signinbutton() {
		return driver.findElement(signin);
	}
	public WebElement waitForVisibilityOfElementuser() {
		  return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(username));
	}
	public WebElement waitForVisibilityOfElementsignin() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(signin));
	
}
}
