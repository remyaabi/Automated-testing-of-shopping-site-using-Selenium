package automationPractice.automationPractice.pageobjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import automationPractice.automationPractice.configuration.Elements;
public class SignInObj {
	static Logger logger = Logger.getLogger(SignInObj.class.getName());
	@FindBy(xpath = Elements.signInEmailText)
	private WebElement signInEmailText;
	@FindBy(id = Elements.signInPasswdText)
	private WebElement signInPasswdText;
	@FindBy(xpath = Elements.forgotPaswdLink)
	private WebElement forgotPaswdLink;
	@FindBy(xpath = Elements.SubmitLoginButton)
	private WebElement SubmitLoginButton;
	@FindBy(id = Elements.emailcreateText)
	private WebElement emailcreateText;
	@FindBy(id = Elements.SubmitCreateButton)
	private WebElement SubmitCreateButton;
	@FindBy(xpath = Elements.signOut)
	private WebElement signOut;
	@FindBy(xpath = Elements.invalidSignIn)
	private WebElement invalidSignIn;
	@FindBy(xpath = Elements.invalidSignInText)
	private WebElement invalidSignInText;


	public WebElement getInvalidSignInText() {
		return invalidSignInText;
	}

	public String getInvalidSignInTextValue() {
		System.out.print(" getInvalidSignInText().getText().trim() : " + getInvalidSignInText().getText().trim());
		return getInvalidSignInText().getText().trim();
	}

	public String assertInvalidSignInText() {
		System.out.print(" getInvalidSignInText().getText().trim() : " + getInvalidSignInText().getText().trim());
		String assertvalue = "Test Passed";
		if ((getInvalidSignInTextValue().toLowerCase()).contains("An email address required.".toLowerCase())) {
			assertvalue = "Blank email";
		} else if ((getInvalidSignInTextValue().toLowerCase()).contains("Invalid email address.".toLowerCase())) {
			assertvalue = "Invalid email";
		} else if ((getInvalidSignInTextValue().toLowerCase()).contains("Password is required.".toLowerCase())) {
			assertvalue = "Blank Password";
		}else if(((getInvalidSignInTextValue().toLowerCase()).contains("Authentication failed.".toLowerCase()))){
			assertvalue="Wrong Username/Password";
		}else if(((getInvalidSignInTextValue().toLowerCase()).contains("Invalid password.".toLowerCase()))){
			assertvalue="Invalid password";
		}
		return assertvalue;
	}


	public WebElement getInvalidSignIn(){
		return invalidSignIn;
	}

	public boolean invalidSignInDisplayed(){
		boolean flag=false;
		try{
			if (getInvalidSignIn().isDisplayed()) {
				flag = true;
			}

		}catch(Exception e){
			System.err.println("Error occured when invalidSignIn is displayed is checked");
			e.printStackTrace();
		}
			return flag;
	}
	
	public WebElement getSignOutLink(){
		return signOut;
	}
	public void signOutClick(){
		signOut.click();
	}
	
	public void entersignInEmailClick(String email){
		logger.info("Entering existing Email");
		signInEmailText.sendKeys(email);		
	}
	public void emailcreateTextClick(String email){
		logger.info("Entering new email ");
		emailcreateText.sendKeys(email);
		
	}
	public void enterPasswdTextClick(String password){
		logger.info("Entering existing password");
		signInPasswdText.sendKeys(password);
	}
	
	public void SubmitCreateButtonClick(){
		logger.info("click on create an account button");
		SubmitCreateButton.click();
	}
	public void SubmitLoginButtonClick(){
		logger.info("click on sign in button");
		SubmitLoginButton.click();
	}
	public void forgotPaswdLinkClick(){
		logger.info("click on forgot password link");
		forgotPaswdLink.click();
	}
	public void createNewaccount(String email)
	{
		emailcreateTextClick(email);
		SubmitCreateButtonClick();
	}
	
}
