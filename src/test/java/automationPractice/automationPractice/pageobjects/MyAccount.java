package automationPractice.automationPractice.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import automationPractice.automationPractice.configuration.Elements;

public class MyAccount {
	static Logger logger = Logger.getLogger(MyAccount.class.getName());
	@FindBy(xpath = Elements.myAccSubHeaderlabel)
	private WebElement myAccSubHeaderlabel;

	@FindBy(xpath = Elements.myAccHeaderlabel)
	private WebElement myAccHeaderlabel;

	public boolean checkMyAccSubHeaderLabel() {
		logger.info(myAccSubHeaderlabel.getText().toString());
		if (myAccSubHeaderlabel.getText().trim().toLowerCase().contains(
				"Welcome to your account. Here you can manage all of your personal information and orders.".toLowerCase())) {
			return true;
		} else {
			return false;
		}

	}
	public String verifyMyAccHeaderlabel(){
		return myAccHeaderlabel.getText();
	}
	public WebElement getMyAccHeaderlabel(){
		return myAccHeaderlabel;
	}
	public WebElement getMySubAccHeaderlabel(){
		return myAccSubHeaderlabel;
	}
}
