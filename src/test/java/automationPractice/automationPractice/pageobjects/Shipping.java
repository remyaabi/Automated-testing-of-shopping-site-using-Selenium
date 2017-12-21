package automationPractice.automationPractice.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationPractice.automationPractice.configuration.Elements;

public class Shipping {
	static Logger logger = Logger.getLogger(CreateAccount.class);
	@FindBy(xpath = Elements.agreeTermCheckbox)
	private WebElement agreeTermCheckbox;
	@FindBy(xpath = Elements.shippingProceedCheckout)
	private WebElement shippingProceedCheckout;
	
	@FindBy(xpath = Elements.readAgreement)
	private WebElement readAgreement;
	
	
	
	@FindBy(xpath = Elements.closeButtonAlertBox)
	private WebElement closeButtonAlertBox;
	

	public void closeButtonAlertBoxClick() {
		closeButtonAlertBox.click();
	}

	public WebElement getCloseButtonAlertBox() {
		return closeButtonAlertBox;
	}
	
	public void agreeTermCheckboxClick() {
		if(!agreeTermCheckbox.isSelected()){
		  agreeTermCheckbox.click();
		}
	}

	public WebElement getReadAgreement() {
		return readAgreement;
	}
	public void readAgreementClick() {
		readAgreement.click();
	}
	public WebElement getAgreeTermCheckbox() {
		return agreeTermCheckbox;
	}
	public void shippingProceedCheckoutClick() {
		shippingProceedCheckout.click();
	}

	public WebElement getShippingProceedCheckout() {
		return shippingProceedCheckout;	
}
}
