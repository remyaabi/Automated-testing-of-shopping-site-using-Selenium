package automationPractice.automationPractice.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import automationPractice.automationPractice.configuration.Elements;

public class CreateAccount {

	static Logger logger = Logger.getLogger(CreateAccount.class);
	@FindBy(name = "id_gender")
	private List<WebElement> idgender;
	@FindBy(id = "customer_firstname")
	private WebElement customerfirstname;
	
	
	@FindBy(id = "customer_lastname")
	private WebElement customerlastname;
	@FindBy(xpath = "//div[@class='required form-group form-ok']//input[@id='email']")
	private WebElement createemail;
	@FindBy(id = "passwd")
	private WebElement createpasswd;
	@FindBy(xpath = "//select[@id='days']")
	private WebElement days;
	@FindBy(xpath = "//select[@id='months']")
	private WebElement months;
	@FindBy(xpath = "//select[@id='years']")
	private WebElement years;
	@FindBy(id = "newsletter")
	private WebElement newsletter;
	@FindBy(id = "optin")
	private WebElement optin;
	@FindBy(id = "firstname")
	private WebElement firstname;
	@FindBy(id = "lastname")
	private WebElement lastname;
	@FindBy(id = "company")
	private WebElement company;
	@FindBy(id = "address1")
	private WebElement address1;
	@FindBy(id = "address2")
	private WebElement address2;
	@FindBy(id = "city")
	private WebElement city;
	@FindBy(xpath = "//select[@id='id_state']")
	private WebElement idstate;
	@FindBy(id = "postcode")
	private WebElement postcode;
	@FindBy(xpath = "//select[@id='id_country']")
	private WebElement id_country;
	@FindBy(id = "other")
	private WebElement other;
	@FindBy(id = "phone")
	private WebElement phone;
	@FindBy(id = "phone_mobile")
	private WebElement phonemobile;
	@FindBy(id = "alias")
	private WebElement alias;
	@FindBy(id = "submitAccount")
	private WebElement submitAccount;
	@FindBy(xpath = "//div[@id='center_column']//div[@id='noSlide']//h1[@class='page-heading']")
	private WebElement createAccAssertion;
	@FindBy(xpath = "//h3[@class='page-subheading']")
	private List<WebElement> SubheadingAssertion;
	@FindBy(xpath = "//div[@class='account_creation']//h3[@class='page-subheading']")
	private WebElement personalSubHeader;
	@FindBy(xpath = Elements.updateAddress)
	private WebElement updateAddress;
	@FindBy(xpath = Elements.backAddress)
	private WebElement backAddress;
	
	public WebElement getUpdateAddress() {
		return updateAddress;
	}
	public void updateAddressClick() {
		 updateAddress.click();
	}

	public WebElement getBackAddress() {
		return backAddress;
	}
	public void backAddressClick() {
		backAddress.click();
	}
	
	
	public boolean verifyCreateAccountLabel() {
		try {
			createAccAssertion.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public WebElement getPersonalSubHeader() {
		return personalSubHeader;
	}
	public WebElement createAccWebElement() {
		return createAccAssertion;
	}

	public boolean verifySubheadingAssertion() {
		boolean flag = false;
		try {
			if (SubheadingAssertion.size() >= 1) {
				flag = true;

			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public void radioIdGenderString(String genderValue) {
		logger.info(idgender.size());
		for (WebElement gender : idgender) {
			logger.info(gender.getAttribute("value").toString());
			if (gender.getAttribute("value").equals(genderValue)) {
				gender.click();
			}
		}
	}

	public void enterFirstName(String firstNameVal) {
		firstname.clear(); 
		firstname.sendKeys(firstNameVal);
	}

	public void enterLastName(String lastNameVal) {
		lastname.clear();;
		lastname.sendKeys(lastNameVal);
	}

	public void enterCompany(String companyName) {
		company.clear();
		company.sendKeys(companyName);
	}

	public void enterAddress1(String address1Value) {
		address1.clear();
		address1.sendKeys(address1Value);
	}

	public void enterAddress2(String address2Value) {
		address2.clear();
		address2.sendKeys(address2Value);
	}

	public void enterOther(String otherValue) {
		other.sendKeys(otherValue);
	}

	public void enterphone(String phoneValue) {
		phone.clear();
		phone.sendKeys(phoneValue.toString());
	}

	public void enterPostCode(Integer postValue) {
		postcode.clear();
		postcode.sendKeys(postValue.toString());
	}

	public void enterPhoneMobileValue(String phonemobileValue) {
		phonemobile.clear();
		phonemobile.sendKeys(phonemobileValue.toString());
	}

	public void enterAlias(String aliasValue) {
		alias.clear();
		alias.sendKeys(aliasValue);
	}

	public void enterCity(String cityValue) {
		city.clear();
		city.sendKeys(cityValue);
	}

	public void enterCustomerFirstName(String customerFirstName) {
		customerfirstname.sendKeys(customerFirstName);
	}

	public void enterCustomerLastName(String customerLastNameValue) {
		customerlastname.sendKeys(customerLastNameValue);
	}

	public void enterEmail(String emailValue) {
		createemail.sendKeys(emailValue);
	}

	public void enterPasswd(String passwdValue) {
		
		createpasswd.sendKeys(passwdValue);
	}

	public void selectDayDOB(String dayValue) {
		Select select = new Select((WebElement) days);
		List<WebElement> dayList = select.getOptions();
		for (WebElement day : dayList) {
			if (day.getText().trim().equalsIgnoreCase(dayValue.toString())) {
				select.selectByVisibleText(day.getText());
			}
		}
	}

	public void selectMonthDOB(String monthValue) {
		Select select = new Select((WebElement) months);
		List<WebElement> monthList = select.getOptions();
		for (WebElement month : monthList) {
			if (month.getText().trim().equalsIgnoreCase(monthValue)) {
				select.selectByVisibleText(month.getText());
			}
		}
	}

	public void selectYearDOB(String yearValue) {
		Select select = new Select((WebElement) years);
		List<WebElement> yearList = select.getOptions();
		for (WebElement year : yearList) {
			if (year.getText().trim().equalsIgnoreCase(yearValue)) {
				select.selectByVisibleText(year.getText());
			}
		}
	}

	public void checkNewsletter(boolean flag) {
		boolean newsletterChbxSelected = newsletter.isSelected();
		if (flag == true && newsletterChbxSelected == false) {
			newsletter.click();
		} else if (flag == false && newsletterChbxSelected == true) {
			newsletter.click();
		}
	}

	public void checkOption(boolean flag) {
		boolean optinChbxSelected = optin.isSelected();
		if (flag == true && optinChbxSelected == false) {
			optin.click();
		} else if (flag == false && optinChbxSelected == true) {
			optin.click();
		}
	}

	public void selectIdState(String stateValue) {
		Select select = new Select((WebElement) idstate);
		List<WebElement> stateList = select.getOptions();
		for (WebElement state : stateList) {
			if (state.getText().trim().equalsIgnoreCase(stateValue)) {
				select.selectByVisibleText(state.getText());
			}
		}
	}

	public void selectCountry(String countryValue) {
		Select select = new Select((WebElement) idstate);
		List<WebElement> countryList = select.getOptions();
		for (WebElement country : countryList) {
			if (country.getText().trim().equalsIgnoreCase(countryValue)) {
				select.selectByVisibleText(country.getText());
			}
		}
	}

	public void clickRegisterAccount() {
		submitAccount.click();
	}

	public String createAccAssertionLabel() {
		logger.info(createAccAssertion.getText().toString().trim());
		return createAccAssertion.getText().toString().trim();
	}

	public void registerAccount(String gender,String custName,String custLastName,String password,String day, 
			String month,String year,boolean newsletter, boolean option,String company,String address1,String address2,
			String city,String state,String phNo,String moblieNo,int zipCode,String aliasValue) {
		radioIdGenderString(gender);
		enterCustomerFirstName(custName);
		enterCustomerLastName(custLastName);
		enterPasswd(password);
		selectDayDOB(day);
		selectMonthDOB(month);
		selectYearDOB(year);
		checkNewsletter(newsletter);
		checkOption(option);
		/*enterFirstName(custName);
		enterLastName(custLastName);*/
		enterCompany(company);
		enterAddress1(address1);
		enterAddress2(address2);
		enterCity(city);
		selectIdState(state);
		selectCountry("United States");
		enterphone(phNo);
		enterPhoneMobileValue(moblieNo);
		enterPostCode(zipCode);
		enterAlias(aliasValue);
		clickRegisterAccount();
	}
	
	public void updateAddress(String custName,String custLastName, 
			String company,String address1,String address2,
			String city,String state,String phNo,String moblieNo,int zipCode,String aliasVal) {
	
			
		enterFirstName(custName);
		enterLastName(custLastName);
		enterCompany(company);
		enterAddress1(address1);
		enterAddress2(address2);
		enterCity(city);
		selectIdState(state);
		selectCountry("United States");
		enterphone(phNo);
		enterPhoneMobileValue(moblieNo);
		enterPostCode(zipCode);
		enterAlias(aliasVal);
		updateAddressClick();
	}
}
