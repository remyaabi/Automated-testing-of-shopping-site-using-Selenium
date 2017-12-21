package automationPractice.automationPractice.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationPractice.automationPractice.configuration.Elements;

public class BuyProduct {
	static Logger logger = Logger.getLogger(CreateAccount.class);
	@FindBy(xpath = Elements.productQuantity)
	private WebElement productQuantity;
	@FindBy(xpath = Elements.productColorAndsize)
	private WebElement productColorAndsize;
	@FindBy(xpath = Elements.prroductTitle)
	private WebElement prroductTitle;
	@FindBy(xpath = Elements.prroductTotal)
	private WebElement prroductTotal;
	@FindBy(xpath = Elements.proceedCheckout)
	private WebElement proceedCheckout;
	@FindBy(xpath = Elements.proceedCheckoutDiv)
	private WebElement proceedCheckoutDiv;
	@FindBy(xpath = Elements.continueShopping)
	private WebElement continueShopping;
	
	@FindBy(xpath = Elements.proceedCheckoutLink2)
	private WebElement proceedCheckoutLink2;
	
	public void proceedCheckoutLink2Click() {
		proceedCheckoutLink2.click();
	}
	public WebElement getproceedCheckoutLink2() {
		return proceedCheckoutLink2;
	}
	
	public void continueShoppingClick() {
		continueShopping.click();
	}
	public WebElement getcontinueShopping() {
		return continueShopping;
	}
	public void proceedCheckoutClick() {
		proceedCheckout.click();
	}
	public WebElement getproceedCheckoutButton() {
		return proceedCheckout;
	}
	public WebElement getProceedCheckoutDiv() {
		return proceedCheckoutDiv;
	}

	public String productTitle() {
		return prroductTitle.getText().trim();
	}

	public int productQuantity() {
		System.out.println("actualProductQuant" + productQuantity.getText());
		try {
			Integer actualProductQuant = Integer.parseInt(productQuantity.getText());
			System.out.println("actualProductQuant" + actualProductQuant.intValue());
			return actualProductQuant.intValue();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public float productTotal() {
		String priceValue=prroductTotal.getText().trim();
		String prodTotal = priceValue.replaceAll("[^0-9]","");
		Float prodTotal11=Float.parseFloat(prodTotal);
		return prodTotal11.floatValue();
	}

	public String[] productSizeAndColor() {
		String actProductColorAndsize = productColorAndsize.getText().trim();
		System.out.println("actProductColorAndsize" + actProductColorAndsize);
		String[] actProductColorAndsizeArray = actProductColorAndsize.split(",");
		return actProductColorAndsizeArray;
	}

	public boolean assertProductQuantity(int prodQuantity, float productPrice) {
		
		float productTotal = prodQuantity * productPrice;
		if (prodQuantity == productQuantity() && productTotal == productTotal()) {
			System.out.println("assertProductQuantity" + true);
			return true;
		} else {
			System.out.println("assertProductQuantity" + false);
			return false;
		}

	}

	public boolean assertProductTitle(String prodTitle) {

		String actualProductTitle = productTitle();
		System.out.println("actualProductTitle" + actualProductTitle);
		System.out.println("prodTitle" + prodTitle);
		if (actualProductTitle.trim().equalsIgnoreCase(prodTitle)) {
			System.out.println("assertProductTitle" + true);
			return true;
		} else {
			System.out.println("assertProductTitle" + false);
			return false;
		}

	}

	public boolean assertProductSizeAndcolor(String color, String size) {
		String[] actSizeAndcolor = productSizeAndColor();
		System.out.println("actSizeAndcolor[0]" + actSizeAndcolor[0]);
		System.out.println("actSizeAndcolor[1]" + actSizeAndcolor[1]);
		
		if (actSizeAndcolor[0].trim().equalsIgnoreCase(color) && actSizeAndcolor[1].trim().equalsIgnoreCase(size)) {
			System.out.println("assertProductSizeAndcolor" + true);
			return true;
		} else {
			System.out.println("assertProductSizeAndcolor" + false);
			return false;
		}
	}
}
