package automationPractice.automationPractice.testscript;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import automationPractice.automationPractice.pageobjects.CreateAccount;
import automationPractice.automationPractice.pageobjects.MainHomePageobject;
import automationPractice.automationPractice.pageobjects.MyAccount;
import automationPractice.automationPractice.pageobjects.SignInObj;

public class TC002_SignInAndRegister extends TestBase {
	MainHomePageobject mainHomePageobject;
	SignInObj signInObj;
	MyAccount myAcccount;
	CreateAccount createAccount;
	static Logger logger = Logger.getLogger(TC001_Navigationlink.class.getName());

	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {
		super.init();
		mainHomePageobject = PageFactory.initElements(driver, MainHomePageobject.class);
		createAccount = PageFactory.initElements(driver, CreateAccount.class);
		signInObj = PageFactory.initElements(driver, SignInObj.class);
		myAcccount = PageFactory.initElements(driver, MyAccount.class);
	}

	@Test(testName = "tcSub1_CreateNewACC", description = "To create a new account by entering the valid email address", groups = {
			"TC002_SignIn" }, priority = 3)
	public void tc2Sub1_CreateNewACC() throws InterruptedException {
		mainHomePageobject.signInLinkClick();
		String email = "email" + System.currentTimeMillis() + "@gmail.com";
		signInObj.emailcreateTextClick(email);
		signInObj.SubmitCreateButtonClick();
		/*WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.textToBePresentInElementValue((WebElement)createAccount.createAccWebElement(),"create an account"));*/// visibilityOfElementLocated(By.xpath("");
		Thread.sleep(2000);
		String excepted = "create an account";
		logger.info(createAccount.createAccAssertionLabel().toLowerCase());
		Assert.assertEquals(createAccount.createAccAssertionLabel().toLowerCase(), excepted.toLowerCase());
		mainHomePageobject.signInLinkClick();
	}

	@Test(dataProvider ="signIn", testName = "tc2Sub2_SignInAlreadyRegisteredUser", description = "testcase to validate existing user email and password", groups = {
			"TC002_SignIn" }, priority = 2)
	public void tc2Sub2_SignInAlreadyRegisteredUser(String userName, String password) {
		mainHomePageobject.signInLinkClick();
		CommonUtil.signinAlreadyRegUser(mainHomePageobject,signInObj, userName, password);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf((WebElement) myAcccount.getMyAccHeaderlabel()));
		Assert.assertEquals(myAcccount.verifyMyAccHeaderlabel().trim().toLowerCase(), "my account");
		wait.until(ExpectedConditions.visibilityOf((WebElement) signInObj.getSignOutLink()));
		signInObj.signOutClick();
	}
	@DataProvider(name="signIn")
	public Object[][] signIn(){
		Object[][] usernameAndPass=new Object[5][2];
		usernameAndPass[0][0]="remy@gmail.com";
		usernameAndPass[0][1]="tttti";
		usernameAndPass[1][0]="remy1@gmail.com";
		usernameAndPass[1][1]="tttti";
		usernameAndPass[2][0]="remy1@gmail.com";
		usernameAndPass[2][1]="tttti";
		usernameAndPass[3][0]="remy3@gmail.com";
		usernameAndPass[3][1]="tttti";
		usernameAndPass[4][0]="remy6@gmail.com";
		usernameAndPass[4][1]="tttti";
		return usernameAndPass;
	}

	@Test(testName = "tc2Sub3_RegisterAccount", description = "test case to register a new account", groups = {
			"TC002_SignIn" }, priority = 1)
	public void tc2Sub3_RegisterAccount() {
		String email = "email" + System.currentTimeMillis() + "@gmail.com";
		String gender = "1";
		String custName = "custName";
		String custLastName = "custLastName";
		String password = "password";
		String day = "5";
		String month = "July";
		String year = "2000";
		boolean newsletter = true;
		boolean option = false;
		/*
		 * String firstName = "firstName"; String lastName = "lastName";
		 */
		String company = "companyName";
		String address1 = "123 fjej kgokh kgofkbl djmkfbhkg";
		String address2 = "";
		String city = "santideago";
		String state = "iowa";
		String phNo = "62654375";
		String moblieNo = "5735978607";
		int zipCode = 98433;
		String aliasVal="jkdjvk";
		mainHomePageobject.signInLinkClick();
		signInObj.emailcreateTextClick(email);
		signInObj.SubmitCreateButtonClick();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf((WebElement) createAccount.getPersonalSubHeader()));
		createAccount.registerAccount(gender, custName, custLastName, password, day, month, year, newsletter, option,
				company, address1, address2, city, state, phNo, moblieNo, zipCode,aliasVal);

		wait.until(ExpectedConditions.visibilityOf((WebElement) myAcccount.getMySubAccHeaderlabel()));
		boolean isAccSubheaderPresent = myAcccount.checkMyAccSubHeaderLabel();
		logger.info("My Account header" + isAccSubheaderPresent);
		if (isAccSubheaderPresent) {
			Assert.assertTrue(true, "registration test case pass");
		} else {
			Assert.assertTrue(false, "registration test case fail");

		}
		wait.until(ExpectedConditions.visibilityOf((WebElement) signInObj.getSignOutLink()));
		signInObj.signOutClick();

	}
	
}
