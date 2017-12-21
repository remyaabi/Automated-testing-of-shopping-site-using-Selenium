package automationPractice.automationPractice.testscript;

import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import automationPractice.automationPractice.pageobjects.MainHomePageobject;
import automationPractice.automationPractice.pageobjects.SignInObj;

public class CommonUtil {
	public static void signinAlreadyRegUser(MainHomePageobject mainHomePageobject,SignInObj signInObj, String userName,String password){
		mainHomePageobject.signInLinkClick();
		System.out.println("signinAlreadyRegUser()");
		signInObj.entersignInEmailClick(userName);
		signInObj.enterPasswdTextClick(password);
		// driver.manage().timeouts().implicitlyWait(1000,
		// TimeUnit.MILLISECONDS);
		signInObj.SubmitLoginButtonClick();
	}
	 public static boolean webElementDisplayedorNot(WebElement Element){
	    	boolean flag=false;
	    	try{
	    	if(Element.isDisplayed()) {
	    		System.out.println(" entered webElementDisplayedorNot : "+ flag);
	    		 flag=true;;
	    	}
	    	}catch (Exception e) {
				e.printStackTrace();
				
	    	}
	    	System.out.println(" entered webElementDisplayedorNot : "+ flag);     
			return flag;
	    }
	 
       
}
