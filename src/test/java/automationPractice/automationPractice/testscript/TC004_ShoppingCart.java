package automationPractice.automationPractice.testscript;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import automationPractice.automationPractice.pageobjects.Address;
import automationPractice.automationPractice.pageobjects.BuyProduct;
import automationPractice.automationPractice.pageobjects.CartObj;
import automationPractice.automationPractice.pageobjects.CreateAccount;
import automationPractice.automationPractice.pageobjects.MainHomePageobject;
import automationPractice.automationPractice.pageobjects.MyAccount;
import automationPractice.automationPractice.pageobjects.Payment;
import automationPractice.automationPractice.pageobjects.Shipping;
import automationPractice.automationPractice.pageobjects.ShoppingCartSummary;
import automationPractice.automationPractice.pageobjects.SignInObj;
import automationPractice.automationPractice.pageobjects.Women;

public class TC004_ShoppingCart extends TestBase {
	Women womenObj;
	BuyProduct buyProduct;
	ShoppingCartSummary shoppingCartSummary;
	MainHomePageobject mainHomePageobject;
	SignInObj signInObj;
	CartObj cartObj;
	Address addressObj;
	Shipping shippingObj;
	Payment paymentObj;
	CreateAccount createAccount;
	MyAccount myAccount;

	static Logger logger = Logger.getLogger(TC001_Navigationlink.class.getName());
    /***
     * To setup the driver and invoke the url
     * @throws IOException
     */
	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {
		super.init();
		womenObj = PageFactory.initElements(driver, Women.class);
		buyProduct = PageFactory.initElements(driver, BuyProduct.class);
		mainHomePageobject = PageFactory.initElements(driver, MainHomePageobject.class);
		cartObj = PageFactory.initElements(driver, CartObj.class);
		signInObj = PageFactory.initElements(driver, SignInObj.class);
		addressObj = PageFactory.initElements(driver, Address.class);
		shippingObj = PageFactory.initElements(driver, Shipping.class);
		paymentObj = PageFactory.initElements(driver, Payment.class);
		shoppingCartSummary = PageFactory.initElements(driver, ShoppingCartSummary.class);
		createAccount = PageFactory.initElements(driver, CreateAccount.class);
		myAccount = PageFactory.initElements(driver, MyAccount.class);

	}

	@Test(testName = "tc4sub1_shoppingCartOnWomenMouseOver", description = "The test case to add item to the cart page", groups = {
			" TC004_ShoppingCart", "1" })
	@Parameters({ "categoryname", "subCatNameInWomen", "itemName", "quantity", "size" })
	public void tc4sub1_shoppingCartOnWomenMouseOver(String categoryname, String subCatNameInWomen, String itemName,
			int quantity, String size) throws InterruptedException {
		dataSetUp();
		commonMethodMouseOver(categoryname, subCatNameInWomen, itemName, quantity, size);
		buyProduct.proceedCheckoutClick();
		Thread.sleep(1000);
		tableManipulation();
		// shoppingCartSummary.deleteProduct(itemName);
		scrollDown();
		explicitwaitMouseOver(shoppingCartSummary.getProceedCheckOutSummary());
		// wait.until(ExpectedConditions.visibilityOf((WebElement)
		// shoppingCartSummary.getProceedCheckOutSummary()));
		Reporter.log("shoppingCartSummary.getProceedCheckOutSummary() ExpectedConditions");
		if ((CommonUtil.webElementDisplayedorNot(shoppingCartSummary.getProceedCheckOutSummary()))) {
			Reporter.log("webElementDisplayedorNotshoppingCartSummary.getProceedCheckOutSummary() ");
			shoppingCartSummary.proceedCheckOutSummaryClick();
			Reporter.log("webElementDisplayedorNotshoppingCartSummary.getProceedCheckOutSummary()After click() ");
		}
		 if (mainHomePageobject.getSignInsignOutText("Sign in")) { 
			Reporter.log("Eneted sign in condition");
			String userName="remy@gmail.com";
			String password="tttti";
			CommonUtil.signinAlreadyRegUser(mainHomePageobject, signInObj,userName,password);
		}
		actionMouseOver(cartObj.getCart());

		Reporter.log("performed action on cart link");
		scrollDown();
		explicitwaitMouseOver(cartObj.getCartCheckoutLink());
		// wait.until(ExpectedConditions.visibilityOf(cartObj.getCartCheckoutLink()));
		if ((CommonUtil.webElementDisplayedorNot(cartObj.getCartCheckoutLink()))) {
			cartObj.cartCheckoutLinkClick();
		}

	

		explicitwaitMouseOver(buyProduct.getproceedCheckoutLink2());
		
		// wait.until(ExpectedConditions.visibilityOf(buyProduct.getproceedCheckoutLink2()));
		if ((CommonUtil.webElementDisplayedorNot(buyProduct.getproceedCheckoutLink2()))) {
		scrollDownToElement(buyProduct.getproceedCheckoutLink2());
			buyProduct.proceedCheckoutLink2Click();
		}

		scrollDown();
		explicitwaitMouseOver(addressObj.getProceedCheckoutButton());
		// wait.until(ExpectedConditions.visibilityOf(addressObj.getProceedCheckoutButton()));
		if ((CommonUtil.webElementDisplayedorNot(addressObj.getProceedCheckoutButton()))) {
			addressObj.proceedCheckoutButtonClick();
		}
		shippingObj.agreeTermCheckboxClick();
		shippingObj.shippingProceedCheckoutClick();
		scrollDown();
		String payMode = "cheque";
		paymentObj.bankpaymethod(payMode);
		scrollDown();
		explicitwaitMouseOver(paymentObj.getConfirmOrder());
		// wait.until(ExpectedConditions.visibilityOf(paymentObj.getConfirmOrder()));
		paymentObj.confirmOrderClick();
		mainHomePageobject.returnHomeLink();
	}

	@Test(testName = "tc4sub2_OnWomenMouseOverDeleteAll", description = "The test case to add item to the cart page", groups = {
			" TC004_ShoppingCart", "2" })

	@Parameters({"categoryname", "subCatNameInWomen", "itemName", "quantity", "size"})
	public void tc4sub2_OnWomenMouseOverDeleteAll(String categoryname, String subCatNameInWomen, String itemName,
			int quantity, String size) throws InterruptedException {
		commonMethodMouseOver(categoryname, subCatNameInWomen, itemName, quantity, size);
		buyProduct.proceedCheckoutClick();
		Thread.sleep(1000);
		tableManipulation();
		shoppingCartSummary.deleteProduct(itemName);
		scrollDown();
		explicitwaitMouseOver(shoppingCartSummary.getShoppingCartEmpty());
		// wait.until(ExpectedConditions.visibilityOf((WebElement)
		// shoppingCartSummary.getShoppingCartEmpty()));
		Assert.assertEquals(shoppingCartSummary.getShoppingCartEmpty().getText().trim(),
				"Your shopping cart is empty.");
		mainHomePageobject.returnHomeLink();
	}
	
	
	@Test(testName = "tc4sub3_shoppingCartOnWomenMouseOverAndChooseBillingAdd", description = "The test case to add item to the cart page", groups = {
			" TC004_ShoppingCart", "3" })
	@Parameters({ "categoryname", "subCatNameInWomen", "itemName", "quantity", "size" })
	public void tc4sub3_shoppingCartOnWomenMouseOverAndChooseBillingAdd(String categoryname, String subCatNameInWomen, String itemName,
			int quantity, String size) throws InterruptedException {
		commonMethodMouseOver(categoryname, subCatNameInWomen,itemName,
				quantity, size);

		buyProduct.proceedCheckoutClick();
		Thread.sleep(1000);
		tableManipulation();
		// shoppingCartSummary.deleteProduct(itemName);
		scrollDown();
		explicitwaitMouseOver(shoppingCartSummary.getProceedCheckOutSummary());
		//wait.until(ExpectedConditions.visibilityOf((WebElement) shoppingCartSummary.getProceedCheckOutSummary()));
		Reporter.log("shoppingCartSummary.getProceedCheckOutSummary() ExpectedConditions");
		if ((CommonUtil.webElementDisplayedorNot(shoppingCartSummary.getProceedCheckOutSummary()))) {
			Reporter.log("webElementDisplayedorNotshoppingCartSummary.getProceedCheckOutSummary() ");
			shoppingCartSummary.proceedCheckOutSummaryClick();
			Reporter.log("webElementDisplayedorNotshoppingCartSummary.getProceedCheckOutSummary()After click() ");
		}
		// mainHomePageobject.returnHomeLink();
        
			if (mainHomePageobject.getSignInsignOutText("Sign in")) {
				Reporter.log("Eneted sign in condition");
				String userName = "remy@gmail.com";
				String password = "tttti";
				CommonUtil.signinAlreadyRegUser(mainHomePageobject, signInObj, userName, password);
			}
        
		boolean useDelAddressAsBillingAddChecked = false;
		addressObj.addressUseCheckboxClick(useDelAddressAsBillingAddChecked);
		if (! addressObj.getAddressUseCheckbox().isSelected()){
			if (addressObj.addNewAddressOnSelectUncheckDisplayed()) {
				addressObj.addNewAddressOnSelectUncheckClick();
				String custName = "custName";
				String custLastName = "custLastName";

				
				String company = "companyName";
				String address1 = "123 fjej kgokh kgofkbl djmkfbhkg";
				String address2 = "";
				String city = "santideago";
				String state = "iowa";
				String phNo = "62654375";
				String moblieNo = "5735978607";
				String  zipCode =" 98433";
				String aliasVal = "gh";
				Thread.sleep(1000);
				createAccount.updateAddress(custName, custLastName, company, address1, address2, city, state, phNo,
						moblieNo, zipCode, aliasVal);
			} else {
				addressObj.setvalueBillingAddressSelectBox("GFHHVH");
			}
		}
		
		explicitwaitMouseOver(addressObj.getProceedCheckoutButton());
		if ((CommonUtil.webElementDisplayedorNot(addressObj.getProceedCheckoutButton()))) {
			scrollDownToElement(addressObj.getProceedCheckoutButton());
			addressObj.proceedCheckoutButtonClick();
		}
		
		explicitwaitMouseOver(shippingObj.getShippingProceedCheckout());
		// wait.until(ExpectedConditions.visibilityOf(buyProduct.getproceedCheckoutLink2()));
		if ((CommonUtil.webElementDisplayedorNot(shippingObj.getShippingProceedCheckout()))) {
			
			scrollDownToElement(shippingObj.getShippingProceedCheckout());
			shippingObj.getShippingProceedCheckout();
		}

		shippingObj.agreeTermCheckboxClick();
		shippingObj.shippingProceedCheckoutClick();
		scrollDown();
		String payMode = "cheque";
		paymentObj.bankpaymethod(payMode);
		scrollDown();
		explicitwaitMouseOver(paymentObj.getConfirmOrder());
		// wait.until(ExpectedConditions.visibilityOf(paymentObj.getConfirmOrder()));
		paymentObj.confirmOrderClick();
		mainHomePageobject.returnHomeLink();
	}


	@Test(testName = "tc4sub4_shoppingCartOnWomenMouseOverAndAddDelAddress", description = "The test case to add item to the cart page", groups = {
			" TC004_ShoppingCart", "4" })
	@Parameters({ "categoryname", "subCatNameInWomen", "itemName", "quantity", "size" })
	public void tc4sub4_shoppingCartOnWomenMouseOverAndAddDelAddress(String categoryname, String subCatNameInWomen, String itemName,
			int quantity, String size) throws InterruptedException {
		commonMethodMouseOver(categoryname, subCatNameInWomen,itemName,quantity, size);

		buyProduct.proceedCheckoutClick();
		Thread.sleep(1000);
		tableManipulation();
		// shoppingCartSummary.deleteProduct(itemName);
		
		explicitwaitMouseOver(shoppingCartSummary.getProceedCheckOutSummary());
		//wait.until(ExpectedConditions.visibilityOf((WebElement) shoppingCartSummary.getProceedCheckOutSummary()));
		Reporter.log("shoppingCartSummary.getProceedCheckOutSummary() ExpectedConditions");
		if ((CommonUtil.webElementDisplayedorNot(shoppingCartSummary.getProceedCheckOutSummary()))) {
			scrollDownToElement(shoppingCartSummary.getProceedCheckOutSummary());
			Reporter.log("webElementDisplayedorNotshoppingCartSummary.getProceedCheckOutSummary() ");
			shoppingCartSummary.proceedCheckOutSummaryClick();
			Reporter.log("webElementDisplayedorNotshoppingCartSummary.getProceedCheckOutSummary()After click() ");
		}
		// mainHomePageobject.returnHomeLink();

		if (mainHomePageobject.getSignInsignOutText("Sign in")) { 
			Reporter.log("Eneted sign in condition");
			String userName="remy@gmail.com";
			String password="tttti";
			CommonUtil.signinAlreadyRegUser(mainHomePageobject, signInObj,userName,password);
		}
		
		boolean deliveryAddressUpdate = true;
		if (deliveryAddressUpdate) {
			Reporter.log("deliveryAddressUpdate" + deliveryAddressUpdate);
			if ((CommonUtil.webElementDisplayedorNot(addressObj.getDeliveryAddressUpdate()))) {
			scrollDownToElement(addressObj.getDeliveryAddressUpdate());
			
			addressObj.deliveryAddressUpdateClick();
			String custName = "custName";
			String custLastName = "custLastName";

			String company = "companyName";
			String address1 = "123 fjej kgokh kgofkbl djmkfbhkg";
			String address2 = "";
			String city = "santideago";
			String state = "iowa";
			String phNo = "62654375";
			String moblieNo = "5735978607";
			String  zipCode = "98433";
			String aliasVal = "gfhvj";
			createAccount.updateAddress(custName, custLastName, company, address1, address2, city, state, phNo,
					moblieNo, zipCode, aliasVal);
			}
			explicitwaitMouseOver(addressObj.getCheckoutLinkAfterDelAddressUpdate());
			//wait.until(ExpectedConditions.visibilityOf(addressObj.getCheckoutLinkAfterDelAddressUpdate()));
			if ((CommonUtil.webElementDisplayedorNot(addressObj.getCheckoutLinkAfterDelAddressUpdate()))) {
				addressObj.CheckoutLinkAfterDelAddressUpdateClick();
			}
		} 
			
		
		explicitwaitMouseOver(shippingObj.getShippingProceedCheckout());
		// wait.until(ExpectedConditions.visibilityOf(buyProduct.getproceedCheckoutLink2()));
		if ((CommonUtil.webElementDisplayedorNot(shippingObj.getShippingProceedCheckout()))) {
			scrollDown();
			scrollDownToElement(shippingObj.getShippingProceedCheckout());
			shippingObj.getShippingProceedCheckout();
		}

		shippingObj.agreeTermCheckboxClick();
		shippingObj.shippingProceedCheckoutClick();
		scrollDown();
		String payMode = "cheque";
		paymentObj.bankpaymethod(payMode);
		scrollDown();
		explicitwaitMouseOver(paymentObj.getConfirmOrder());
		// wait.until(ExpectedConditions.visibilityOf(paymentObj.getConfirmOrder()));
		paymentObj.confirmOrderClick();
		mainHomePageobject.returnHomeLink();
	}

@Test(testName = "tc4sub5_shoppingCartOnWomenMouseOverAndAddDelAddress", description = "The test case to add item to the cart page", groups = {
	" TC004_ShoppingCart", "5" })
@Parameters({ "categoryname", "subCatNameInWomen", "itemName", "quantity", "size" })
public void tc4sub5_shoppingCartOnWomenMouseOverAndAddBillAddress(String categoryname, String subCatNameInWomen, String itemName,
	int quantity, String size) throws InterruptedException {
commonMethodMouseOver(categoryname, subCatNameInWomen,itemName,quantity, size);

buyProduct.proceedCheckoutClick();
Thread.sleep(1000);
tableManipulation();
// shoppingCartSummary.deleteProduct(itemName);

explicitwaitMouseOver(shoppingCartSummary.getProceedCheckOutSummary());
//wait.until(ExpectedConditions.visibilityOf((WebElement) shoppingCartSummary.getProceedCheckOutSummary()));
Reporter.log("shoppingCartSummary.getProceedCheckOutSummary() ExpectedConditions");
if ((CommonUtil.webElementDisplayedorNot(shoppingCartSummary.getProceedCheckOutSummary()))) {
	scrollDownToElement(shoppingCartSummary.getProceedCheckOutSummary());
	Reporter.log("webElementDisplayedorNotshoppingCartSummary.getProceedCheckOutSummary() ");
	shoppingCartSummary.proceedCheckOutSummaryClick();
	Reporter.log("webElementDisplayedorNotshoppingCartSummary.getProceedCheckOutSummary()After click() ");
}
// mainHomePageobject.returnHomeLink();

if  (mainHomePageobject.getSignInsignOutText("Sign in")) { 
	Reporter.log("Eneted sign in condition");
	String userName="remy@gmail.com";
	String password="tttti";
	CommonUtil.signinAlreadyRegUser(mainHomePageobject, signInObj,userName,password);
}

boolean billingAddressUpdate = true;
if (billingAddressUpdate) {
	Reporter.log("deliveryAddressUpdate" + billingAddressUpdate);
	if ((CommonUtil.webElementDisplayedorNot(addressObj.getBillingAddressUpdate()))) {
	scrollDownToElement(addressObj.getBillingAddressUpdate());
	
	addressObj.billingAddressUpdateClick();
	String custName = "custName";
	String custLastName = "custLastName";

	String company = "companyName";
	String address1 = "123 fjej kgokh kgofkbl djmkfbhkg";
	String address2 = "";
	String city = "santideago";
	String state = "iowa";
	String phNo = "62654375";
	String moblieNo = "5735978607";
	String  zipCode = "98433";
	String aliasVal = "gfhvghjjjhg";
	createAccount.updateAddress(custName, custLastName, company, address1, address2, city, state, phNo,
			moblieNo, zipCode, aliasVal);
	}
	explicitwaitMouseOver(addressObj.getCheckoutLinkAfterDelAddressUpdate());
	//wait.until(ExpectedConditions.visibilityOf(addressObj.getCheckoutLinkAfterDelAddressUpdate()));
	if ((CommonUtil.webElementDisplayedorNot(addressObj.getCheckoutLinkAfterDelAddressUpdate()))) {
		addressObj.CheckoutLinkAfterDelAddressUpdateClick();
	}
} 
	

explicitwaitMouseOver(shippingObj.getShippingProceedCheckout());
// wait.until(ExpectedConditions.visibilityOf(buyProduct.getproceedCheckoutLink2()));
if ((CommonUtil.webElementDisplayedorNot(shippingObj.getShippingProceedCheckout()))) {
	scrollDown();
	scrollDownToElement(shippingObj.getShippingProceedCheckout());
	shippingObj.getShippingProceedCheckout();
}

shippingObj.agreeTermCheckboxClick();
shippingObj.shippingProceedCheckoutClick();
scrollDown();
String payMode = "cheque";
paymentObj.bankpaymethod(payMode);
scrollDown();
explicitwaitMouseOver(paymentObj.getConfirmOrder());
// wait.until(ExpectedConditions.visibilityOf(paymentObj.getConfirmOrder()));
paymentObj.confirmOrderClick();
mainHomePageobject.returnHomeLink();
}
@Test(testName = "tc4sub6_shoppingCartOnWomenMouseOverAndDeleteAllAddress", description = "The test case to add item to the cart page", groups = {
		" TC004_ShoppingCart", "1" })
	@Parameters({ "categoryname", "subCatNameInWomen", "itemName", "quantity", "size" })
	public void tc4sub6_shoppingCartOnWomenMouseOverAndDeleteAllAddress(String categoryname, String subCatNameInWomen, String itemName,
		int quantity, String size) throws InterruptedException {
	
	commonMethodMouseOver(categoryname, subCatNameInWomen,itemName,quantity, size);

	buyProduct.proceedCheckoutClick();
	Thread.sleep(1000);
	tableManipulation();
	// shoppingCartSummary.deleteProduct(itemName);

	explicitwaitMouseOver(shoppingCartSummary.getProceedCheckOutSummary());
	//wait.until(ExpectedConditions.visibilityOf((WebElement) shoppingCartSummary.getProceedCheckOutSummary()));
	Reporter.log("shoppingCartSummary.getProceedCheckOutSummary() ExpectedConditions");
	if ((CommonUtil.webElementDisplayedorNot(shoppingCartSummary.getProceedCheckOutSummary()))) {
		scrollDownToElement(shoppingCartSummary.getProceedCheckOutSummary());
		Reporter.log("webElementDisplayedorNotshoppingCartSummary.getProceedCheckOutSummary() ");
		shoppingCartSummary.proceedCheckOutSummaryClick();
		Reporter.log("webElementDisplayedorNotshoppingCartSummary.getProceedCheckOutSummary()After click() ");
	}
	// mainHomePageobject.returnHomeLink();

	if  (mainHomePageobject.getSignInsignOutText("Sign in")) {
		Reporter.log("Eneted sign in condition");
		String userName="remy2gmail.com";
		String password="tttti";
		CommonUtil.signinAlreadyRegUser(mainHomePageobject, signInObj,userName,password);
	}

	boolean deliveryAddressUpdate = true;
	if (deliveryAddressUpdate) {
		Reporter.log("deliveryAddressUpdate" + deliveryAddressUpdate);
		//Assert.assertTrue(addressObj.getDeliveryAddressUpdate().isDisplayed());
		if ((CommonUtil.webElementDisplayedorNot(addressObj.getDeliveryAddressUpdate()))) {
		scrollDownToElement(addressObj.getDeliveryAddressUpdate());
		
		addressObj.deliveryAddressUpdateClick();
		explicitwaitMouseOver(addressObj.getBackToAddressPage());
		//wait.until(ExpectedConditions.visibilityOf((WebElement) shoppingCartSummary.getProceedCheckOutSummary()));
		Reporter.log("shoppingCartSummary.getProceedCheckOutSummary() ExpectedConditions");
		if ((CommonUtil.webElementDisplayedorNot(addressObj.getBackToAddressPage()))) {
			scrollDownToElement(addressObj.getBackToAddressPage());
			addressObj.backToAddressPageClick();
		}
		}
		}
		if (addressObj.getDeleteButtonInBackToAddressPage().size()!=0){
			Reporter.log("getDeleteButtonInBackToAddressPage().size() :" + addressObj.getDeleteButtonInBackToAddressPage().size());
			List<WebElement> deleteButtonList=addressObj.getDeleteButtonInBackToAddressPage();
			while(! deleteButtonList.isEmpty()){
				deleteButtonList.get(0).click();
				alertOkHandle();
				deleteButtonList.clear();
			    deleteButtonList=addressObj.getDeleteButtonInBackToAddressPage();
				Reporter.log("Inside while loop getDeleteButtonInBackToAddressPage().size() :" + addressObj.getDeleteButtonInBackToAddressPage().size());
			}
			
		   Assert.assertTrue(addressObj.textAssertCheck(addressObj.getAddressnotAvailableText(), "No addresses are available"));
			actionMouseOver(cartObj.getCart());

			Reporter.log("performed action on cart link");
			scrollDown();
			explicitwaitMouseOver(cartObj.getCartCheckoutLink());
			// wait.until(ExpectedConditions.visibilityOf(cartObj.getCartCheckoutLink()));
			if ((CommonUtil.webElementDisplayedorNot(cartObj.getCartCheckoutLink()))) {
				cartObj.cartCheckoutLinkClick();
			}
	}
		explicitwaitMouseOver(buyProduct.getproceedCheckoutLink2());
		
		// wait.until(ExpectedConditions.visibilityOf(buyProduct.getproceedCheckoutLink2()));
		if ((CommonUtil.webElementDisplayedorNot(buyProduct.getproceedCheckoutLink2()))) {
		scrollDownToElement(buyProduct.getproceedCheckoutLink2());
			buyProduct.proceedCheckoutLink2Click();
		}
		
		Assert.assertTrue(addressObj.textAssertCheck(addressObj.getYourAddressText(), "YOUR ADDRESSES"));
		String custName = "custName";
		String custLastName = "custLastName";

		String company = "companyName";
		String address1 = "123 fjej kgokh kgofkbl djmkfbhkg";
		String address2 = "";
		String city = "santideago";
		String state = "iowa";
		String phNo = "62654375";
		String moblieNo = "5735978607";
		String  zipCode = "98433";
		String aliasVal = "gfhvghjjjhg";
		createAccount.updateAddress(custName, custLastName, company, address1, address2, city, state, phNo,
				moblieNo, zipCode, aliasVal);

		explicitwaitMouseOver(addressObj.getCheckoutLinkAfterDelAddressUpdate());
		//wait.until(ExpectedConditions.visibilityOf(addressObj.getCheckoutLinkAfterDelAddressUpdate()));
		if ((CommonUtil.webElementDisplayedorNot(addressObj.getCheckoutLinkAfterDelAddressUpdate()))) {
			addressObj.CheckoutLinkAfterDelAddressUpdateClick();
		}
	
		

	explicitwaitMouseOver(shippingObj.getShippingProceedCheckout());
	// wait.until(ExpectedConditions.visibilityOf(buyProduct.getproceedCheckoutLink2()));
	if ((CommonUtil.webElementDisplayedorNot(shippingObj.getShippingProceedCheckout()))) {
		scrollDown();
		scrollDownToElement(shippingObj.getShippingProceedCheckout());
		shippingObj.getShippingProceedCheckout();
	}

	shippingObj.agreeTermCheckboxClick();
	shippingObj.shippingProceedCheckoutClick();
	scrollDown();
	String payMode = "cheque";
	paymentObj.bankpaymethod(payMode);
	scrollDown();
	explicitwaitMouseOver(paymentObj.getConfirmOrder());
	// wait.until(ExpectedConditions.visibilityOf(paymentObj.getConfirmOrder()));
	paymentObj.confirmOrderClick();
	mainHomePageobject.returnHomeLink();
		
}


	public void tableManipulation() throws InterruptedException {
		List<WebElement> tableRowsvalue = shoppingCartSummary.tableRows();
		SoftAssert softAssert = new SoftAssert();
		Reporter.log("tableRowsvalue" + tableRowsvalue.size());
		for (WebElement row : tableRowsvalue) {
			List<WebElement> colValue = row.findElements(By.tagName("td"));
			Thread.sleep(1000);
			Reporter.log("colValue" + colValue.size());
			Reporter.log("colValue.get(4).getText()" + colValue.get(4).getText());
			softAssert.assertTrue(shoppingCartSummary.assertTotalQuantityAndPrice(colValue),
					"The total price does not match with the quantiy and price of the item selected");
			softAssert.assertAll();

		}

	}

	public void commonMethodMouseOver(String categoryname, String subCatNameInWomen, String itemName, int quantity,
			String size) {
		// Actions action = new Actions(driver);
		// String categoryname = "Women";
		actionMouseOver(womenObj.mouseOverMainCategory(categoryname));
		// action.moveToElement((WebElement)
		// womenObj.mouseOverMainCategory(categoryname)).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// String subCatNameInWomen = "Tops";
		explicitwaitMouseOver(womenObj.mouseOverSubCategoryInWomen(subCatNameInWomen));
		// wait.until( xpectedConditions.visibilityOf((WebElement)
		// womenObj.mouseOverSubCategoryInWomen(subCatNameInWomen)));
		womenObj.clickSubCategoryInWomen(subCatNameInWomen);
		String expected = subCatNameInWomen;
		String labelText = womenObj.getAssertLabel(expected);

		Assert.assertEquals(labelText.toLowerCase(), expected.toLowerCase());
		// String itemName = "Blouse";
		// action.moveToElement((WebElement)womenObj.getTshirtShop()).build().perform();
		Reporter.log("Action product img link");
		scrollDown();
		actionMouseOver(womenObj.selectItem(itemName));
		// action.moveToElement((WebElement)
		// womenObj.selectItem(itemName)).build().perform();

		Reporter.log("Action product img link scrolldown");
		WebElement moreVisibleLink = womenObj.visibleMoreLink(womenObj.getMoreLink());
		wait.until(ExpectedConditions.visibilityOf(moreVisibleLink));

		if ((CommonUtil.webElementDisplayedorNot(moreVisibleLink))) {
			moreVisibleLink.click();
		}

		String productTitle = womenObj.getProductTitle();
		// int quantity = 3;
		logger.info("Enetred While in tc3sub1_shoopingCartTShirt" + womenObj.getQuantitywanted().intValue());
		while (womenObj.getQuantitywanted().intValue() < quantity) {

			womenObj.quantityPlusClick();
		}
		while (womenObj.getQuantitywanted().intValue() > quantity && womenObj.getQuantitywanted().intValue() > 1) {

			womenObj.quantityDownClick();
		}
		List<WebElement> colorList = womenObj.getSelectedProductColorList();
		Reporter.log("colorList.size" + colorList.size());
		Random random = new Random();
		String color = colorList.get(random.nextInt(colorList.size())).getAttribute("name");
		Reporter.log("color" + color);
		// String size = "M";
		float productPrice = womenObj.getItemPrice();
		womenObj.selectSize(size);
		womenObj.selectColor(color);
		womenObj.addToCartClick();

		wait.until(ExpectedConditions.visibilityOf((WebElement) buyProduct.getProceedCheckoutDiv()));
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(buyProduct.assertProductQuantity(quantity, productPrice),
				"Check the product quant and price");
		softAssertion.assertTrue(buyProduct.assertProductSizeAndcolor(color, size), "Check the product size and color");
		softAssertion.assertTrue(buyProduct.assertProductTitle(productTitle), "Check the product Title");
		softAssertion.assertAll();
		// Hard Assertion
		// Assert.assertTrue(buyProduct.assertProductQuantity(quantity,
		// productPrice) && buyProduct.assertProductSizeAndcolor(color, size) &&
		// buyProduct.assertProductTitle(productTitle));
	}

	public void dataSetUp(){
		if  (mainHomePageobject.getSignInsignOutText("Sign in")) {
			
			Reporter.log("Eneted sign in condition");
			String userName="remy@gmail.com";
			String password="tttti";
			CommonUtil.signinAlreadyRegUser(mainHomePageobject, signInObj,userName,password);
		}
		myAccount.myAddresslinkClick();
		Assert.assertTrue(addressObj.textAssertCheck(addressObj.getAddressnotAvailableText(), "No addresses are available"));
		myAccount.addNewAddressButtonClick();
		Assert.assertTrue(addressObj.textAssertCheck(addressObj.getYourAddressText(), "YOUR ADDRESSES"));
		String custName = "custName";
		String custLastName = "custLastName";

		String company = "companyName";
		String address1 = "123 fjej kgokh kgofkbl djmkfbhkg";
		String address2 = "";
		String city = "santideago";
		String state = "iowa";
		String phNo = "62654375";
		String moblieNo = "5735978607";
		String  zipCode = "98433";
		String aliasVal = "gfhvghjjjhg";
		createAccount.updateAddress(custName, custLastName, company, address1, address2, city, state, phNo,
				moblieNo, zipCode, aliasVal);
		
	}

	
}
