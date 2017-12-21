package automationPractice.automationPractice.customlistener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import automationPractice.automationPractice.testscript.TestBase;

public class Listener extends TestBase implements ITestListener{
    Logger logger;
	public void onTestStart(ITestResult result) {
	 logger =Logger.getLogger(result.getMethod().getMethodName());
		Reporter.log(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		logger.info("entered screen shot func");
		logger.info(result.getStatus());
		File screenShotName;
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.info("entered screen shot func if");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// File scrFile = ((TakesScreenshot)driver).getScreenshotAs(arg0)
			// Now you can do whatever you need to do with it, for example copy
			// somewhere
			String faliureImageName =System.getProperty("user.dir")+"\\src\\test\\java\\automationPractice\\automationPractice\\screenshot\\" + 
					 " _ " + result.getMethod().getMethodName()+ "-" + System.currentTimeMillis()+ ".png";
			screenShotName=new File(faliureImageName);
			try {
				FileUtils.copyFile(scrFile,
						screenShotName);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String filePath = screenShotName.toString();
			String path = "<img src=\"file://" + filePath + " alt=image\"\"" + "height='100' width='100'/>";
			Reporter.log(path);
			 
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
