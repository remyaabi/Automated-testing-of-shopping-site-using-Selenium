package automationPractice.automationPractice.pageobjects;

import java.sql.Driver;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import automationPractice.automationPractice.configuration.Elements;

public class Address {
	static Logger logger = Logger.getLogger(CreateAccount.class);
	@FindBy(xpath = Elements.proceedCheckoutButton)
	private WebElement proceedCheckoutButton;
	@FindBy(xpath = Elements.addressSelectBox)
	private WebElement addressSelectBox;
	@FindBy(xpath = Elements.billingAddressUpdate)
	private WebElement billingAddressUpdate;
	@FindBy(xpath = Elements.deliveryAddressUpdate)
	private WebElement deliveryAddressUpdate;
	@FindBy(xpath = Elements.addNewAddress)
	private WebElement addNewAddress;
	@FindBy(xpath = Elements.addNewAddressOnSelectUncheck)
	private WebElement addNewAddressOnSelectUncheck;
	@FindBy(xpath = Elements.comments)
	private WebElement comments;
	@FindBy(xpath = Elements.addressUseCheckbox)
	private WebElement addressUseCheckbox;
	@FindBy(xpath = Elements.billingAddressSelectBox)
	private WebElement billingAddressSelectBox;
	@FindBy(xpath = Elements.CheckoutLinkAfterDelAddressUpdate)
	private WebElement CheckoutLinkAfterDelAddressUpdate;
	@FindBy(xpath = Elements.backToAddressPage)
	private WebElement backToAddressPage;
	@FindBy(xpath = Elements.deleteButtonInBackToAddressPage)
	private List<WebElement>  deleteButtonInBackToAddressPage;
	@FindBy(xpath = Elements.addressnotAvailableText)
	private WebElement  addressnotAvailableText;
	@FindBy(xpath = Elements.yourAddressText)
	private WebElement  yourAddressText;
	
	
	public WebElement getAddressnotAvailableText() {
		return addressnotAvailableText;
	}
	public WebElement getYourAddressText() {
		return yourAddressText;
	}
	public boolean textAssertCheck(WebElement we,String value ){
		boolean AssertFlag=false;
		System.out.println("we.getText().trim()    "+ we.getText().trim());
		if(we.getText().trim().contains(value)){
			AssertFlag=true;
		}
		return AssertFlag;
	}
	public List<WebElement> getDeleteButtonInBackToAddressPage() {
		return deleteButtonInBackToAddressPage;
	}
	
	public WebElement getBackToAddressPage() {
		return backToAddressPage;
	}
	public void backToAddressPageClick() {
		backToAddressPage.click();
	}
	
	
	public WebElement getCheckoutLinkAfterDelAddressUpdate() {
		return CheckoutLinkAfterDelAddressUpdate;
	}
	public void CheckoutLinkAfterDelAddressUpdateClick() {
		CheckoutLinkAfterDelAddressUpdate.click();
	}
	
	public void billingAddressUpdateClick() {
		billingAddressUpdate.click();
	}
	public void addressUseCheckboxClick(boolean selectFlag) {
		if(selectFlag && getAddressUseCheckbox().isSelected()==false){
		addressUseCheckbox.click();
		}else if(! selectFlag && getAddressUseCheckbox().isSelected()==true){ 
			addressUseCheckbox.click();
		}
	}
	public WebElement getDeliveryAddressUpdate() {
		return deliveryAddressUpdate;
	}
	public WebElement getAddressUseCheckbox() {
		return addressUseCheckbox;
	}
	public void sendComments(String commentsVal) {
		comments.sendKeys(commentsVal);
	}

	public WebElement getCommentsTextarea() {
		return comments;
	}

	public void addNewAddressOnSelectUncheckClick() {
		
			addNewAddressOnSelectUncheck.click();
		
	}

	public WebElement getAddNewAddressOnSelectUncheck() {
		return addNewAddressOnSelectUncheck;
	}
	public void deliveryAddressUpdateClick() {
		deliveryAddressUpdate.click();
	}
	public WebElement getAddNewAddress() {
		return addNewAddress;
	}
	public void addNewAddressClick() {
		addNewAddress.click();
	}

	public WebElement getBillingAddressUpdate() {
		return billingAddressUpdate;
	}
	public void proceedCheckoutButtonClick() {
		proceedCheckoutButton.click();
	}

	public WebElement getProceedCheckoutButton() {
		return proceedCheckoutButton;
	}
	public WebElement getAddressSelectBox() {
		return addressSelectBox;
	}
	public boolean addNewAddressOnSelectUncheckDisplayed(){
		
		 try {
			    return getAddNewAddressOnSelectUncheck().isDisplayed();
			  } catch (NoSuchElementException e) {
			    return false;
			  }
		
	}
	public void setvalueBillingAddressSelectBox(String value){
		Select select=new Select((WebElement)billingAddressSelectBox);
		List<WebElement> billingAddressSelectboxList=select.getOptions();
		for(WebElement billingAddress:billingAddressSelectboxList ){
			System.out.println("billingAddress.getText().trim()"+ billingAddress.getText().trim());
			if(billingAddress.getText().trim().equalsIgnoreCase(value.trim())){
				select.selectByVisibleText((billingAddress.getText()));
			}
		}
	}
	
}
