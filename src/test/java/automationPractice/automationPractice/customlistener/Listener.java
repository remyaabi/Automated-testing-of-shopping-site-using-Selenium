package automationPractice.automationPractice.customlistener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

import automationPractice.automationPractice.testscript.TestBase;

public class Listener  extends TestBase implements ITestListener{
    
	public void onTestStart(ITestResult result) {
	
		Reporter.log(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@AfterMethod
	public void onTestFailure(ITestResult result) {
		/*logger.info("entered screen shot func");
		logger.info(result.getStatus());
		
		if (!result.isSuccess()){
			Calendar calendar=Calendar.getInstance();
			SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		}*/
		
		
	
		File screenShotName;
		if (!result.isSuccess()) {
		
			
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// File scrFile = ((TakesScreenshot)driver).getScreenshotAs(arg0)
			// Now you can do whatever you need to do with it, for example copy
			// somewhere
			
			
			String faliureImageName =System.getProperty("user.dir")+"\\src\\test\\java\\automationPractice\\automationPractice\\screenshot\\" + 
					 result.getMethod().getMethodName()+ "-" + System.currentTimeMillis()+ ".png";
			System.out.println(faliureImageName +"faliureImageName");
			screenShotName=new File(faliureImageName);
			try {
				String filePath = screenShotName.toString();
				System.out.println("filePath"+filePath);
				/*String path = "<img src=\"file://" + filePath + "\" alt=image height='100' width='100'/>";
				System.out.println("repoert image path" + path);
				Reporter.log(path);*/
				String path = "<a href=\"file://" + filePath + "\"><img src=\"file://" + filePath + "\" alt=image height='100' width='100'/> </a>";
				System.out.println("repoert image path" + path);
				Reporter.log(path);

				FileUtils.copyFile(scrFile,
						screenShotName);
				
			} catch (IOException e) {
				 System.err.println("Unable to capture screenshot...");
				e.printStackTrace();
			}
			
			 
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
