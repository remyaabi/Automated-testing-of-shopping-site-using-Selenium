package automationPractice.automationPractice.pageobjects;



import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationPractice.automationPractice.configuration.Elements;

/**
 * Hello world!
 *
 */
public class MainHomePageobject 
{
	static Logger logger = Logger.getLogger(MainHomePageobject.class);
	
	@FindBy(id=Elements.searchText)
	private WebElement searchText;
	
	@FindBy(name=Elements.searchButton)
	private WebElement searchButton;
    
	/*@FindBy(xpath=Elements.cart)
	private WebElement cart;*/
	
	@FindBy(xpath=Elements.contactLink)
	private WebElement contactLink;
	
	@FindBy(xpath=Elements.signInLink)
	private WebElement signInLink;
	
	@FindBy(xpath=Elements.dealLink)
	private WebElement dealLink;
	
	@FindBy(xpath=Elements.returnHomeLink)
	private WebElement returnHomeLink;
	/* used in Tc004 file*/
	@FindBy(xpath=Elements.signInsignOut)
	private List<WebElement> signInsignOut;
	/*@FindBy(xpath=Elements.cartCheckoutLink)
	private WebElement cartCheckoutLink;*/
	
    public void searchText(String searchValue){
    	searchText.sendKeys(searchValue);
    }
   /* public void cartCheckoutLinkClick(){
    	cartCheckoutLink.click();
    }
    
    public WebElement getCart(){
    	return cart;
    }
     public void cartClick(){
    	cart.click();
    }*/
    public void searchButtonClick(){
    	searchButton.click();
    }
   
    public boolean getSignInsignOutText(String siginVal){
    	boolean flag=false;
    	List<WebElement> signInSignOutList=getSignInsignOut();
    	for(WebElement signInSignOut :signInSignOutList ){
    		if(signInSignOut.getText().trim().equalsIgnoreCase(siginVal)){
    			flag=true;
    		}
    	}
    	return flag;
    	
    }
   
    public void contactLinkClick(){
    	contactLink.click();
    }
    public void signInLinkClick(){
    	signInLink.click();
    }
    public void dealLinkClicK(){
    	dealLink.click(); 
    }
    public void returnHomeLink(){
    	returnHomeLink.click(); 
    }
    public void searchValue(){
    	String category = "women";
    	searchText(category);
    	searchButtonClick();
    	returnHomeLink();
    }
    public void contactLink(){
    	contactLinkClick();
		returnHomeLink();
	}
    public void signinLink(){
    	signInLinkClick();
    	returnHomeLink();
	}
    public void dealLink(){
    	dealLinkClicK();
    	returnHomeLink();
	}
    public List<WebElement> getSignInsignOut(){
    	return signInsignOut;
    }
    }

