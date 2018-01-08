package automationPractice.automationPractice.testscript;

import automationPractice.automationPractice.pageobjects.Contact;
import automationPractice.automationPractice.pageobjects.MainHomePageobject;
import automationPractice.automationPractice.pageobjects.SignInObj;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by remya on 1/7/2018.
 */
public class TC_ContactUs extends TestBase {
    MainHomePageobject mainHomePageobject;
    SignInObj signInObj;
    Contact contact;
    WebDriverWait wait;
    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {
        super.init();
        mainHomePageobject = PageFactory.initElements(driver, MainHomePageobject.class);
        signInObj = PageFactory.initElements(driver, SignInObj.class);
        contact = PageFactory.initElements(driver, Contact.class);
    }
    @Test(testName ="sendMessage")
    public void sendMessage(){
        mainHomePageobject.contactLinkClick();
        contact.submitMessage("Webmaster", "remy@gmail.com", "first", "To check text area working");
        Assert.assertEquals("Message is successfully send","Your message has been successfully sent to our team.", contact.getSuccesMessage().getText());
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf((WebElement) contact.getHomeButton()));
        contact.homeButtonClick();
    }

    @Test(testName ="sendMessageEmailBlank")
    public void sendMessageEmailBlank(){
        mainHomePageobject.contactLinkClick();
        contact.submitMessage("Webmaster", "", "first", "To check text area working");
        Assert.assertEquals("invalid email Address","Invalid email address.", contact.getErrorParacontent().getText());
        WebDriverWait wait = new WebDriverWait(driver, 20);
       mainHomePageobject.returnHomeLink();
    }

}
