package automationPractice.automationPractice.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import automationPractice.automationPractice.configuration.Elements;

public class DepartmentsObj {
	 static Logger logger = Logger.getLogger(DepartmentsObj.class.getName());
	@FindBy(xpath=Elements.womenLink)
	private WebElement womenLink;
	@FindBy(xpath=Elements.tshirtLink)
	private WebElement tshirtLink;
	@FindBy(xpath=Elements.dressLink)
	private WebElement dressLink;
	@FindBy(xpath=Elements.womenAssertionCheck)
	private WebElement womenAssertionCheck;
	
	
   
    public WebElement womenLinkClick(){
    	
    	womenLink.click();
    	logger.info("clicked on Women Link");
    	return womenAssertionCheck;
    }
  
    public WebElement dressLinkClick(){
    	dressLink.click();
    	logger.info("clicked on Dress Link");
    	return womenAssertionCheck;
    }
    
   
    public WebElement tshirtLinkClick(){
    	tshirtLink.click();
    	logger.info("clicked on T-Shirt Link");
    	return womenAssertionCheck;
    }
    }

