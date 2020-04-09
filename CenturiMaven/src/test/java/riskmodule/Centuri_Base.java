package riskmodule;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.testng.annotations.AfterTest;
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
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

public void userlogin() throws InterruptedException {
	
	  
	 CenturiLoginPage clp = new CenturiLoginPage(driver, wait);
	 	
	 //clp.user().sendKeys("james");
	// test.log(Status.PASS, "Login test started");
	 //NOT USING THREAD AND WAITING FOR THE VISIBILITY OF ELEMENT
	 clp.waitForVisibilityOfElementuser().sendKeys("james");
	 //NOT USING THREAD AND WAITING FOR THE VISIBILITY OF ELEMENT
	 clp.waitForVisibilityOfElementsignin().click();
	 //test.log(Status.PASS,"Login successfull");
	 
	// clp.signinbutton().click();
	}

	@BeforeTest
	@Parameters({"browser"})
	public void Launch_Browser(@Optional("Chrome")String browser) throws Exception {
		
		
		htmlReporter  = new ExtentHtmlReporter(System.getProperty("user.dir")+"./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Centuri Automation Report");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		
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
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver_80.exe");
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
		 driver.get("http://demo-centuri.conevo.in/");
		 driver.manage().window().maximize();
		
		 wait = new WebDriverWait(driver, 160);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		 userlogin();
		/* wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		  
		 CenturiLoginPage clp = new CenturiLoginPage(driver);
		 	
		 clp.user().sendKeys("james");
		 Thread.sleep(1000);
		 clp.signinbutton().click();*/
		
		 
		 
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
	
	
   
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
