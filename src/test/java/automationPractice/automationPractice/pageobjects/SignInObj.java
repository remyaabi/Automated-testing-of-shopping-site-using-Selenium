package automationPractice.automationPractice.pageobjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import automationPractice.automationPractice.configuration.Elements;
public class SignInObj {
	static Logger logger = Logger.getLogger(SignInObj.class.getName());
	@FindBy(xpath=Elements.signInEmailText) 
	private WebElement signInEmailText;
	@FindBy(id=Elements.signInPasswdText)
	private WebElement signInPasswdText;
	@FindBy(xpath=Elements.forgotPaswdLink)
	private WebElement forgotPaswdLink;
	@FindBy(xpath=Elements.SubmitLoginButton)
	private WebElement SubmitLoginButton;	
	@FindBy(id=Elements.emailcreateText)
	private WebElement emailcreateText;
	@FindBy(id=Elements.SubmitCreateButton)
	private WebElement SubmitCreateButton;	
	@FindBy(xpath=Elements.signOut)
	private WebElement signOut;
	
	
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
	
}
