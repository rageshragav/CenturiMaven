package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CenturiReadPage {
	WebDriver driver;
	private WebDriverWait webDriverWait;

	//private FluentWait webDriverWait;
	public CenturiReadPage(WebDriver driver,WebDriverWait webDriverWait) {
		this.driver = driver;	
		this.webDriverWait = webDriverWait;
	}
	By subMenuButton = By.xpath("//span[@class='submenu']");
	By archiveButton = By.xpath("//li[contains(text(),'Archive')]");
	public WebElement subMenuButton() {
		return driver.findElement(subMenuButton);
	}
	public WebElement archiveButton() {
		return driver.findElement(archiveButton);
	}
}
