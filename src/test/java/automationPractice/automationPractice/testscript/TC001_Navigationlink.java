package automationPractice.automationPractice.testscript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automationPractice.automationPractice.customlistener.Listener;
import automationPractice.automationPractice.pageobjects.*;

public class TC001_Navigationlink extends Listener{
	MainHomePageobject mainHomePageobject;
	DepartmentsObj departmentsObj;
	SignInObj signInObj;
	CreateAccount createAccount;
	MyAccount myAcccount;
	CartObj cartObj;
	static Logger logger = Logger.getLogger(TC001_Navigationlink.class.getName());

	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {
		super.init();
		logger.info("Invoking browser");
		mainHomePageobject = PageFactory.initElements(driver, MainHomePageobject.class);
		departmentsObj = PageFactory.initElements(driver, DepartmentsObj.class);
		cartObj=PageFactory.initElements(driver, CartObj.class);
	}

	@Test(testName = "tcSub1_SearchValue", description = "Search for a particular items or categories", groups = {
			"TC001_Navigationlink", "1" })
	public void tc1Sub1_SearchValue() {
		logger.debug("In Search Value");
		mainHomePageobject.searchValue();		
	}

	@Test(testName = "tcSub2_ContactLink", description = "The test case to check the contact link redirecting to the apporiate page", groups = {
			"TC001_Navigationlink", "2" })
	public void tc1Sub2_ContactLink() {
		logger.debug("In Contact Link");
		mainHomePageobject.contactLink();		
	}
		

	@Test(testName = "tcSub3_SigninLink", description = "The test case to check the sign link redirecting to the sign in page", groups = {
			"TC001_Navigationlink", "3" })
	public void tc1Sub3_SigninLink() {
		logger.debug("In signIn Link");
		mainHomePageobject.signinLink();		
	}

	@Test(testName = "tcSub4_DealLink", description = "he test case to check the deal link redirecting to the deal page", groups = {
			"TC001_Navigationlink", "4" })
	public void tc1Sub4_DealLink() {
		logger.debug("In Deal Link");
		mainHomePageobject.dealLink();		
	}

	@Test(testName = "tcSub5_CartLink", description = "he test case to check the cart link redirecting to the cart page", groups = {
			"TC001_Navigationlink", "5" })
	public void tc1Sub5_CartLink() {
		logger.debug("In cart Link");
		cartObj.cartClick();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		mainHomePageobject.returnHomeLink();		
	}

	@Test(testName = "tcSub6_WomenLinkClickCheck", description = "The test case to check the women  link redirecting to the women page", groups = {
			"TC001_Navigationlink", "6" })
	public void tc1Sub6_WomenLinkClickCheck() {
		WebElement expectedLinkResult = departmentsObj.womenLinkClick();
		String linkresult = "Women";
		Assert.assertEquals(expectedLinkResult.getText().trim().toUpperCase(), linkresult.toUpperCase());		
	}

	@Test(testName = "tcSub7_DressLinkClickCheck", description = "The test case to check the dress  link redirecting to the dress page", groups = {
			"TC001_Navigationlink", "7" })
	public void tc1Sub7_DressLinkClickCheck() {
		WebElement expectedLinkResult = departmentsObj.dressLinkClick();
		String linkresult = "Dresses";
		Assert.assertEquals(expectedLinkResult.getText().trim().toUpperCase(), linkresult.toUpperCase());		
	}

	@Test(testName = "tcSub8_TshirtLinkClickCheck", description = "The test case to check the t-shirt  link redirecting to the t-shirt page", groups = {
			"TC001_Navigationlink", "8" })
	public void tc1Sub8_TshirtLinkClickCheck() {
		logger.debug("not working");
		WebElement expectedLinkResult = departmentsObj.tshirtLinkClick();
		String linkresult = "T-shirts";
		Assert.assertEquals(expectedLinkResult.getText().trim().toUpperCase(), linkresult.toUpperCase());		
	}

}
