package automationPractice.automationPractice.testscript;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	static Logger logger = Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	public static Properties configprop;

	public void loadData() throws IOException {
		if (configprop == null) {
		configprop = new Properties();
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		FileReader filereader = new FileReader(file);
		configprop.load(filereader);
		}
	}

	
	public static void actionMouseOver(WebElement we){
			Actions actObj=new Actions(driver);
			actObj.moveToElement(we).build().perform();
			}
	 public static void explicitwaitMouseOver(WebElement we){
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(we));
	 }
	
	 
	public WebDriver setBrowser(String browserName) {
		logger.info("browserName " + browserName);
		if (browserName.equalsIgnoreCase("firefox")) {
			if (driver == null) {
				System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"\\driver\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				
			}
			return driver;
		} else if (browserName.equalsIgnoreCase("chrome")) {
			if (driver == null) {
				ChromeOptions options= new ChromeOptions();
				options.addArguments("disable-infobars");
				options.addArguments("--start-maximized");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
				driver = new ChromeDriver(options);
				logger.info("driver created " + driver.getClass().getName());
				//driver.manage().window().maximize();
				
			}
			logger.info("driver " + driver);
			return driver;
		} else {
			return driver;
		}
	}

	@BeforeClass(alwaysRun = true)
	public void init() throws IOException {
		logger.info("entered init");
		loadData();
		setBrowser(configprop.getProperty("browserName"));
		driver.get(configprop.getProperty("baseUrl"));

	}

	@AfterMethod
	public void Screenshot(ITestResult testResult) throws IOException {
		logger.info("entered screen shot func");
		logger.info(testResult.getStatus());
		if (testResult.getStatus() == ITestResult.FAILURE) {
			logger.info("entered screen shot func if");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// File scrFile = ((TakesScreenshot)driver).getScreenshotAs(arg0)
			// Now you can do whatever you need to do with it, for example copy
			// somewhere
			try {
				FileUtils.copyFile(scrFile,
						new File(System.getProperty("user.dir")+"\\src\\test\\java\\automationPractice\\automationPractice\\screenshot\\" + 
								 " _ " + testResult.getMethod().getMethodName()+ "-" + System.currentTimeMillis() + ".png"));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*@AfterSuite
	public void closeDriver(){
		driver.close();
	}*/
	
	public void scrollDown(){
	JavascriptExecutor js = (JavascriptExecutor) driver;  
	js.executeScript("scroll(0, 730);");
	}
	
	
	public void scrollDownToElement(WebElement we){
		 if (driver instanceof JavascriptExecutor) {
		  ((JavascriptExecutor) driver)
          .executeScript("arguments[0].scrollIntoView(true);", we);
	}
	}
	
	 public static void alertOkHandle(){
		 driver.switchTo().alert().accept();
	 }
	
}
