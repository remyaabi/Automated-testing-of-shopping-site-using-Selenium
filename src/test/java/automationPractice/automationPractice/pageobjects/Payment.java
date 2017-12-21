package automationPractice.automationPractice.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationPractice.automationPractice.configuration.Elements;

public class Payment {
	static Logger logger = Logger.getLogger(CreateAccount.class);
	@FindBy(xpath = Elements.bankWirePayment)
	private WebElement bankWirePayment;
	@FindBy(xpath = Elements.cheque)
	private WebElement cheque;
	@FindBy(xpath = Elements.confirmOrder)
	private WebElement confirmOrder;
	@FindBy(linkText = Elements.otherPaymethods)
	private WebElement otherPaymethods;
	
	public void otherPaymethodsClick() {
		otherPaymethods.click();
	}
	
	public WebElement getOtherPaymethods() {
		return otherPaymethods;
	}
	
	public void confirmOrderClick() {
		confirmOrder.click();
	}
	
	public WebElement getConfirmOrder() {
		return confirmOrder;
	}
	
	
	public void bankWirePaymentClick() {
		bankWirePayment.click();
	}
	public void chequeClick() {
		cheque.click();
	}
	
	public WebElement getCheque() {
		return cheque;
	}
	public WebElement getBankWirePayment() {
		return bankWirePayment;
	}
	
	public void bankpaymethod(String payMode){
		if(payMode.trim().equalsIgnoreCase("cheque")){
			chequeClick();
		}else{
			bankWirePaymentClick();
		}
	}
}
