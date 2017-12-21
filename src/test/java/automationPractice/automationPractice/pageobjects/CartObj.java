package automationPractice.automationPractice.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import automationPractice.automationPractice.configuration.Elements;

public class CartObj {
	static Logger logger = Logger.getLogger(MainHomePageobject.class);
	@FindBy(xpath=Elements.cart)
	private WebElement cart;
	@FindBy(xpath=Elements.cartCheckoutLink)
	private WebElement cartCheckoutLink;
	@FindBy(xpath=Elements.cartEmptyText)
	private WebElement cartEmptyText;
	
	
	  public void cartCheckoutLinkClick(){
	    	cartCheckoutLink.click();
	    }
	    public WebElement getCartCheckoutLink(){
	    	return cartCheckoutLink;
	    }
	    public WebElement getCart(){
	    	return cart;
	    }
	    public void cartClick(){
	    	cart.click();
	    }
	    public String emptyCart(){
	    	
	    	return cartEmptyText.getText().trim();
	    }
	    public WebElement getcartEmptyText(){
	    	return cartEmptyText;
	    }
	    
	    public boolean checkCheckOutLinkDisplayedorNot(){
	    	boolean flag=false;
	    	try{
	    	if(getCartCheckoutLink().isDisplayed()) {
	    		System.out.println(" entered checkCheckOutLinkDisplayedorNot : "+ flag);
	    		 flag=true;;
	    	}
	    	}catch (Exception e) {
				e.printStackTrace();
				
	    	}
			return flag;
	    }
	    
	    public boolean checkCartEmptyOrNot(){
	    	
	    	if(emptyCart().equalsIgnoreCase("empty")) {
	    		return false;
	    	}else{
	    		return true;
	    	}
	    	
	    }
}

