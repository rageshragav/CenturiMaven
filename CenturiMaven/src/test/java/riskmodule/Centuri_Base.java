package riskmodule;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import objectrepository.CenturiAdminPage;
import objectrepository.CenturiLoginPage;
/*import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;*/


public class Centuri_Base {
	public static  WebDriver driver;
	public WebDriverWait wait ;
	public WebDriverWait wait1 ;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public Properties obj;
	public DateTimeFormatter dtf;

public void WaitForTwoSeconds() throws InterruptedException {
	Thread.sleep(2000);
}
	@BeforeTest
//	@BeforeSuite
	@Parameters({"browser"})
	public void Launch_Browser(@Optional("Chrome")String browser) throws Exception {
		//Load the properties File		
	    obj = new Properties();					
	    FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");									
	    obj.load(objfile);	
		htmlReporter  = new ExtentHtmlReporter(System.getProperty("user.dir")+"./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Centuri Automation Report");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().enableTimeline(true);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Test Enngineer", "Ragesh RB");
		extent.setSystemInfo("Enviroment", "Chrome");
		extent.setSystemInfo("Centuri Build","9.0");
		//System.setProperty("webdriver.chrome.driver","D:\\chromedriver_80.exe");
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver_80.exe");
		
		 
		//driver = new ChromeDriver();
		
		if(browser.equalsIgnoreCase("firefox")){
			//create firefox instance
				System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("Chrome")){
				//set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver_83.exe");
				//create chrome instance
				driver = new ChromeDriver(); 
				//test.log(Status.PASS, "Chrome browser launchd and centuri regression test started");
			}
			//Check if parameter passed as 'Edge'
					else if(browser.equalsIgnoreCase("Edge")){
						//set path to Edge.exe
						System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
						//create Edge instance
						driver = new EdgeDriver();
					}
			else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
		 driver.get(obj.getProperty("URL"));
		 driver.manage().window().maximize();
		 wait = new WebDriverWait(driver, 20);
		 wait1 = new WebDriverWait(driver, 160);
		 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		 userlogin();
		/* wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		  
		 CenturiLoginPage clp = new CenturiLoginPage(driver);
		 	
		 clp.user().sendKeys("james");
		 Thread.sleep(1000);
		 clp.signinbutton().click();*/
		
		 
		 
	}
	
public void userlogin() throws InterruptedException {
	
	 CenturiLoginPage clp = new CenturiLoginPage(driver, wait);
	 //NOT USING THREAD AND WAITING FOR THE VISIBILITY OF ELEMENT
	 clp.waitForVisibilityOfElementuser().sendKeys(obj.getProperty("Username"));
	 //NOT USING THREAD AND WAITING FOR THE VISIBILITY OF ELEMENT
	 clp.waitForVisibilityOfElementsignin().click();
	}

	
	@AfterTest
	public void endReport() throws AWTException {
		extent.flush();
	}
	//@AfterTest
	//@AfterSuite
	/*public void endReport() throws AWTException {
		extent.flush();
		   Robot r = new Robot();        
           r.keyPress(KeyEvent.VK_CONTROL);
           r.keyPress(KeyEvent.VK_T);
           r.keyRelease(KeyEvent.VK_CONTROL);
           r.keyRelease(KeyEvent.VK_T);
           WebDriverWait wait = new WebDriverWait(driver, 20);
           wait.until(ExpectedConditions.numberOfWindowsToBe(2));
           //To switch to the new tab
           ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
           driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
           driver.switchTo().window(tabs.get(1));
           //driver.get("file:///E:/Ragesh Automation/RF_Automation/test-output/STMExtentReport.html#!");
           driver.get("file:///C:/Users/BALAJI/git/CenturiMaven/CenturiMaven/reports/extent.html");
	}*/
	
	
   
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
			
			String screenshotPath = Centuri_Base.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
			
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "TEST CASE SKIPPED IS " + result.getName());
		}else if (result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "TEST CASE PASSED IS " + result.getName());
		}
		
		
		/*if(result.getStatus()==ITestResult.FAILURE) {
			String methodname = result.getMethod().getMethodName();
			String logText = "<b>" + "TEST CASE: - " + methodname.toUpperCase() + "FAILED" + "</b>";	
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			test.fail(m);
		}else if (result.getStatus()==ITestResult.SKIP) {
			String methodname = result.getMethod().getMethodName();
			String logText = "<b>" + "TEST CASE: - " + methodname.toUpperCase() + "SKIPPED" + "</b>";	
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
			test.skip(m);
		}else if (result.getStatus()==ITestResult.SUCCESS) {
			String methodname = result.getMethod().getMethodName();
			String logText = "<b>" + "TEST CASE: - " + methodname.toUpperCase() +  "PASSED" + "</b>";	
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			test.pass(m);
		}*/
		
	}
	public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
	} 
	
	protected void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
		// TODO Auto-generated method stub
		if(!filePath.exists())
	        throw new WebDriverException("File not found: " + filePath.toString());

	     driver = ((RemoteWebElement)target).getWrappedDriver();
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    WebDriverWait wait = new WebDriverWait(driver, 30);

	    String JS_DROP_FILE =
	        "var target = arguments[0]," +
	        "    offsetX = arguments[1]," +
	        "    offsetY = arguments[2]," +
	        "    document = target.ownerDocument || document," +
	        "    window = document.defaultView || window;" +
	        "" +
	        "var input = document.createElement('INPUT');" +
	        "input.type = 'file';" +
	        "input.style.display = 'none';" +
	        "input.onchange = function () {" +
	        "  var rect = target.getBoundingClientRect()," +
	        "      x = rect.left + (offsetX || (rect.width >> 1))," +
	        "      y = rect.top + (offsetY || (rect.height >> 1))," +
	        "      dataTransfer = { files: this.files };" +
	        "" +
	        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
	        "    var evt = document.createEvent('MouseEvent');" +
	        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
	        "    evt.dataTransfer = dataTransfer;" +
	        "    target.dispatchEvent(evt);" +
	        "  });" +
	        "" +
	        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
	        "};" +
	        "document.body.appendChild(input);" +
	        "return input;";

	    WebElement input =  (WebElement)jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
	    input.sendKeys(filePath.getAbsoluteFile().toString());
	    wait.until(ExpectedConditions.stalenessOf(input));
	}

/*@Test(description ="Verify whether user can able to login into the application",priority=1)
@Description("Verify whether user can able to login into the application")
@Epic("Sprint 84")
@Feature("UserLogin")
@Story("1234")
@Step("Verify User Login")
@Severity(SeverityLevel.NORMAL)
public void User_login() throws InterruptedException {
	 userlogin();
}*/

}
