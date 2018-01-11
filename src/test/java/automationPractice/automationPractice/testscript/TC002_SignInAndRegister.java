package automationPractice.automationPractice.testscript;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
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
	WebDriverWait wait;
	static Logger logger = Logger.getLogger(TC001_Navigationlink.class.getName());

	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {
		super.init();
		mainHomePageobject = PageFactory.initElements(driver, MainHomePageobject.class);
		createAccount = PageFactory.initElements(driver, CreateAccount.class);
		signInObj = PageFactory.initElements(driver, SignInObj.class);
		myAcccount = PageFactory.initElements(driver, MyAccount.class);
		 wait = new WebDriverWait(driver, 20);
	}

	@Test(enabled=true)
	public void tc2Sub1_CreateNewACC() throws InterruptedException {
		mainHomePageobject.signInLinkClick();
		String email = "email" + System.currentTimeMillis() + "@gmail.com";
         signInObj.createNewaccount(email);
		/*WebDriverWait wait = new WebDriverWait(driver, 70);
		wait.until(ExpectedConditions.textToBePresentInElement(createAccount.createAccWebElement(),"Create an account"));*/
		Thread.sleep(2000);
		String excepted = "create an account";
		logger.info(createAccount.createAccAssertionLabel().toLowerCase());
		Reporter.log(createAccount.createAccAssertionLabel().toLowerCase());
		Assert.assertEquals(createAccount.createAccAssertionLabel().toLowerCase(), excepted.toLowerCase(), "new account created");
		mainHomePageobject.returnHomeLink();
	}
	
	@Test(dataProvider="GetExcelDataSignIn" ,testName = "tc2Sub2_SignInAlreadyRegisteredUser", description = "testcase to validate existing user email and password", groups = {
			"TC002_SignIn" }, priority = 2)
	public void tc2Sub2_SignInAlreadyRegisteredUser(String userName, String password ) {
		mainHomePageobject.signInLinkClick();
		CommonUtil.signinAlreadyRegUser(mainHomePageobject, signInObj, userName, password);
		wait.until(ExpectedConditions.visibilityOf((WebElement) myAcccount.getMyAccHeaderlabel()));
		Assert.assertEquals(myAcccount.verifyMyAccHeaderlabel().trim().toLowerCase(), "my account", "Valid user able to signin");
		wait.until(ExpectedConditions.visibilityOf((WebElement) signInObj.getSignOutLink()));
		signInObj.signOutClick();
	}

	@Test(dataProvider="GetExcelDataSignInEmailInvalid" ,testName = "tc2Sub2_SignInAlreadyRegisteredUserNegative", description = "testcase to validate existing user email and password", groups = {
			"TC002_SignIn" }, priority = 3)
	public void tc2Sub2_SignInAlreadyRegisteredUserNegative(String userName, String password ) {
		mainHomePageobject.signInLinkClick();
		CommonUtil.signinAlreadyRegUser(mainHomePageobject, signInObj, userName, password);
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf((WebElement) signInObj.getInvalidSignIn()));
		Assert.assertEquals("Wrong Username/Password", signInObj.assertInvalidSignInText(), "Email Invalid");
		mainHomePageobject.returnHomeLink();

	}
	@Test(dataProvider="GetExcelDataSignInEmailBlank" ,testName = "tc2Sub2_SignInAlreadyRegisteredUserEmailBlank", description = "testcase to validate existing user email and password", groups = {
			"TC002_SignIn" }, priority = 4)
	public void tc2Sub2_SignInAlreadyRegisteredUserEmailBlank(String userName, String password ) {
		mainHomePageobject.signInLinkClick();
		CommonUtil.signinAlreadyRegUser(mainHomePageobject, signInObj, userName, password);
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf((WebElement) signInObj.getInvalidSignIn()));
		Assert.assertEquals("Blank email", signInObj.assertInvalidSignInText(),"Email is required");
		mainHomePageobject.returnHomeLink();

	}
	@Test(dataProvider="GetExcelDataSignInPasswordBlank" ,testName = "tc2Sub2_SignInAlreadyRegisteredUserEmailBlank", description = "testcase to validate existing user email and password", groups = {
			"TC002_SignIn" }, priority = 5)
	public void tc2Sub2_SignInAlreadyRegisteredUserPasswordBlank(String userName, String password ) {
		mainHomePageobject.signInLinkClick();
		CommonUtil.signinAlreadyRegUser(mainHomePageobject, signInObj, userName, password);
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf((WebElement) signInObj.getInvalidSignIn()));

		Assert.assertEquals("Blank Password", signInObj.assertInvalidSignInText(),"password is required");
		mainHomePageobject.returnHomeLink();

	}
	@Test(dataProvider="GetExcelDataSignInPasswordLenLessThan5" ,testName = "tc2Sub2_SignInAlreadyRegisteredUserEmailBlank", description = "testcase to validate existing user email and password", groups = {
			"TC002_SignIn" }, priority = 6)
	public void tc2Sub2_SignInAlreadyRegisteredUserPasswordLenLessThan5(String userName, String password ) {
		mainHomePageobject.signInLinkClick();
		CommonUtil.signinAlreadyRegUser(mainHomePageobject, signInObj, userName, password);
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf((WebElement) signInObj.getInvalidSignIn()));
		Assert.assertEquals("Invalid password", signInObj.assertInvalidSignInText(),"Invalid password.");
		mainHomePageobject.returnHomeLink();
	}

	@Test(dataProvider="GetExcelDataSignInPasswordInvalid" ,testName = "tc2Sub2_SignInAlreadyRegisteredUserEmailBlank", description = "testcase to validate existing user email and password", groups = {
			"TC002_SignIn" }, priority = 7)
	public void tc2Sub2_SignInAlreadyRegisteredUserPasswordInvalid(String userName, String password ) {
		mainHomePageobject.signInLinkClick();
		CommonUtil.signinAlreadyRegUser(mainHomePageobject, signInObj, userName, password);
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf((WebElement) signInObj.getInvalidSignIn()));

		Assert.assertEquals("Wrong Username/Password", signInObj.assertInvalidSignInText(), "Wrong  password ");
		mainHomePageobject.returnHomeLink();

	}
	
	@Test(enabled=true,dataProvider="GetExcelRegisterAccount" ,testName = "tc2Sub3_RegisterAccount", description = "testcase to validate existing user email and password", groups = {
			"TC002_SignIn" }, priority = 7)
	public void tc2Sub3_RegisterAccount(String email,String gender,String custName,String custLastName,String password,String day,
										String month,String year,boolean newsletter, boolean option,String company,String address1,String address2,
										String city,String state,String phNo,String moblieNo,String zipCode,String aliasValue) {
		String emailSend = email + System.currentTimeMillis() + "@gmail.com";
		/*String gender = "1";
		String custName = "custName";
		String custLastName = "custLastName";
		String password = "password";
		String day = "5";
		String month = "July";
		String year = "2000";
		boolean newsletter = true;
		boolean option = false;
		String company = "companyName";
		String address1 = "123 fjej kgokh kgofkbl djmkfbhkg";
		String address2 = "";
		String city = "santideago";
		String state = "iowa";
		String phNo = "62654375";
		String moblieNo = "5735978607";
		int zipCode = 98433;
		String aliasVal="jkdjvk";*/
		mainHomePageobject.signInLinkClick();
		signInObj.createNewaccount(emailSend);
		WebDriverWait wait = new WebDriverWait(driver, 40);
       		wait.until(ExpectedConditions.visibilityOf((WebElement) createAccount.getPersonalSubHeader()));
		createAccount.registerAccount(gender, custName, custLastName, password, day, month, year, newsletter, option,
				company, address1, address2, city, state, phNo, moblieNo, zipCode, aliasValue);

		wait.until(ExpectedConditions.visibilityOf((WebElement) myAcccount.getMySubAccHeaderlabel()));
		boolean isAccSubheaderPresent = myAcccount.checkMyAccSubHeaderLabel();
		logger.info("My Account header" + isAccSubheaderPresent);
		if (isAccSubheaderPresent) {
			Assert.assertTrue(true, "Sucessfully registered new user");
		}
		wait.until(ExpectedConditions.visibilityOf((WebElement) signInObj.getSignOutLink()));
		signInObj.signOutClick();
	}

	@DataProvider(name="GetExcelDataSignIn")
	public Object[][] GetExcelDataSignIn() throws EncryptedDocumentException, InvalidFormatException, IOException{
		ReadExcel readExcel=new ReadExcel();	
		String sheetName="SignIn";
		String path=System.getProperty("user.dir")+ "/src/test/resources/testdata.xlsx";
		return readExcel.excelReader(path,sheetName);
	}
	@DataProvider(name="GetExcelDataSignInEmailInvalid")
	 public Object[][] GetExcelDataSignInEmailInvalid() throws EncryptedDocumentException, InvalidFormatException, IOException{
		ReadExcel readExcel=new ReadExcel();
		String sheetName="EmailInvalid";
		String path=System.getProperty("user.dir")+ "/src/test/resources/testdata.xlsx";
		return readExcel.excelReader(path,sheetName);
	}

	@DataProvider(name="GetExcelRegisterAccount")
	public Object[][] GetExcelRegisterAccount() throws EncryptedDocumentException, InvalidFormatException, IOException{
		ReadExcel readExcel=new ReadExcel();
		String sheetName="CreateAccount";
		String path=System.getProperty("user.dir")+ "/src/test/resources/testdata.xlsx";
		return readExcel.excelReader(path,sheetName);
	}
	@DataProvider(name="GetExcelDataSignInEmailBlank")
	public Object[][] GetExcelDataSignInEmailBlank() throws EncryptedDocumentException, InvalidFormatException, IOException{
		ReadExcel readExcel=new ReadExcel();
		String sheetName="emailBlank";
		String path=System.getProperty("user.dir")+ "/src/test/resources/testdata.xlsx";
		return readExcel.excelReader(path,sheetName);
	}
	@DataProvider(name="GetExcelDataSignInPasswordBlank")
	public Object[][] GetExcelDataSignInPasswordBlank() throws EncryptedDocumentException, InvalidFormatException, IOException{
		ReadExcel readExcel=new ReadExcel();
		String sheetName="BlankPassword";
		String path=System.getProperty("user.dir")+ "/src/test/resources/testdata.xlsx";
		return readExcel.excelReader(path,sheetName);
	}

	@DataProvider(name="GetExcelDataSignInPasswordInvalid")
	public Object[][] GetExcelDataSignInPasswordInvalid() throws EncryptedDocumentException, InvalidFormatException, IOException{
		ReadExcel readExcel=new ReadExcel();
		String sheetName="WrongPassword";
		String path=System.getProperty("user.dir")+ "/src/test/resources/testdata.xlsx";
		return readExcel.excelReader(path,sheetName);
	}
	@DataProvider(name="GetExcelDataSignInPasswordLenLessThan5")
	public Object[][] GetExcelDataSignInPasswordLenLessThan5() throws EncryptedDocumentException, InvalidFormatException, IOException{
		ReadExcel readExcel=new ReadExcel();
		String sheetName="InvalidPassword";
		String path=System.getProperty("user.dir")+ "/src/test/resources/testdata.xlsx";
		return readExcel.excelReader(path,sheetName);
	}
	/*@DataProvider(name="signIn")
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
	}*/


}
