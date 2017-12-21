package automationPractice.automationPractice.testscript;

import java.io.IOException;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automationPractice.automationPractice.pageobjects.DepartmentsObj;
import automationPractice.automationPractice.pageobjects.MainHomePageobject;
import automationPractice.automationPractice.pageobjects.Women;

public class TC003_NavigationSubLink extends TestBase {
	DepartmentsObj departmentsObj;
	Women womenObj;
	MainHomePageobject mainHomePageobject;
	static Logger logger = Logger.getLogger(TC001_Navigationlink.class.getName());

	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {
		super.init();
		womenObj = PageFactory.initElements(driver, Women.class);
		mainHomePageobject = PageFactory.initElements(driver, MainHomePageobject.class);
		departmentsObj = PageFactory.initElements(driver, DepartmentsObj.class);
	}

	@Test(testName = "tc3Sub2_TshirtMouseOverClick", description = "To check whetehr the on mouse over women navigational link , T-shirt is clickable", groups = {
			"TC003_ShopingCart" })
	public void tc3Sub1_TshirtMouseOverClick() {
		Actions action = new Actions(driver);
		action.moveToElement((WebElement) womenObj.getWomenLink()).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf((WebElement) womenObj.getTshirtLinkInWomen()));
		womenObj.tshirtMouseOverInWomenClick();
		String expected = "T-shirts";
		Assert.assertEquals(womenObj.getTshirtMouseOverClickAssert().getText().trim().toLowerCase(),
				expected.toLowerCase());
		mainHomePageobject.returnHomeLink();
	}

	@Test(testName = "tc3Sub2_blouseMouseOverClick()", description = "To check whetehr the on mouse over women navigational link , T-shirt is clickable", groups = {
			"TC003_ShopingCart" })
	public void tc3Sub2_blouseMouseOverClick() {
		Actions action = new Actions(driver);
		action.moveToElement((WebElement) womenObj.getWomenLink()).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf((WebElement) womenObj.getBlouseInWomenLink()));
		womenObj.blouseMouseOverInWomenClick();
		String expected = "Blouses";
		Assert.assertEquals(womenObj.getBlouseMouseOverClickAssert().getText().trim().toLowerCase(),
				expected.toLowerCase());
		mainHomePageobject.returnHomeLink();
	}

	@Test(testName = "tc3Sub3_CasualDressMouseOverClick", description = "To check whetehr the on mouse over women navigational link , T-shirt is clickable", groups = {
			"TC003_ShopingCart" })
	public void tc3Sub3_CasualDressMouseOverClick() {
		Actions action = new Actions(driver);
		action.moveToElement((WebElement) womenObj.getDressLink()).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf((WebElement) womenObj.getCasualDressInDress()));
		womenObj.casualDressInDressClick();
		String expected = "Casual Dresses";
		Assert.assertEquals(womenObj.getCasualDressClickAssert().getText().trim().toLowerCase(),
				expected.toLowerCase());
		mainHomePageobject.returnHomeLink();
	}
}
