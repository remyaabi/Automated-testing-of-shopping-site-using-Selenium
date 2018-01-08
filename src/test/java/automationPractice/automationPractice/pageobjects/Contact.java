package automationPractice.automationPractice.pageobjects;


import automationPractice.automationPractice.configuration.Elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Remya on 1/7/2018.
 */
public class Contact{

    @FindBy(xpath = Elements.subjectHeading)
    private WebElement subjectHeading;
    @FindBy(xpath = Elements.contactEmail)
    private WebElement contactEmail;
    @FindBy(xpath = Elements.contactOrderreference)
    private WebElement contactOrderreference;
    @FindBy(xpath = Elements.fileUploadText)
    private WebElement fileUploadText;
    @FindBy(xpath = Elements.fileUploadButton)
    private WebElement fileUploadButton;
    @FindBy(xpath = Elements.sendButton)
    private WebElement sendButton;
    @FindBy(xpath = Elements.Homelink)
    private WebElement HomeButton;
    @FindBy(xpath = Elements.errorParagraph)
    private WebElement errorParagraph;
    @FindBy(xpath = Elements.errorParacontent)
    private WebElement errorParacontent;

    @FindBy(xpath = Elements.messageTextarea)
    private WebElement messageTextarea;
    @FindBy(xpath = Elements.succesMessage)
    private WebElement succesMessage;
    public WebElement getErrorParacontent(){
        return errorParacontent;
    }
    public WebElement getErrorParagraph(){
        return errorParagraph;
    }
    public WebElement getSuccesMessage(){
        return succesMessage;
    }
    public WebElement getSubjectHeading(){
        return subjectHeading;
    }
    public WebElement getHomeButton(){
        return HomeButton;
    }
    public void homeButtonClick()
    {
        getHomeButton().click();
    }
    public WebElement getContactEmail(){
        return contactEmail;
    }
    public WebElement getContactOrderreference(){
        return contactOrderreference;
    }
    public WebElement getFileUploadText(){
        return fileUploadText;
    }
    public WebElement getFileUploadButton(){
        return fileUploadButton;
    }
    public WebElement getMessageTextarea(){
        return messageTextarea;
    }
    public WebElement getSendButton(){
        return sendButton;
    }
public void selectSubjectHeading(String sublectHeading){
    Select selectHeading= new Select(getSubjectHeading());
    List<WebElement> selectHeadingList = selectHeading.getOptions();
    for (WebElement selectHeadingVal : selectHeadingList) {
        if (selectHeadingVal.getText().trim().equalsIgnoreCase(sublectHeading)) {
            selectHeading.selectByVisibleText(selectHeadingVal.getText());
        }
    }
}
    public void sendContactEmail(String contactEmail){
        getContactEmail().sendKeys(contactEmail);
    }
    public void sendContactOrderreferenc(String orderRefeernce){
        getContactOrderreference().sendKeys(orderRefeernce);
    }
    public void sendFileUploadText(String fileUploadText){
        getFileUploadText().sendKeys(fileUploadText);
    }
    public void fileUploadButtonClick(){
        getFileUploadButton().click();
    }
    public void sendMessageTextarea(String message){
        getMessageTextarea().sendKeys(message);
    }

    public void sendButtonClick(){
        getSendButton().click();

    }
    public void submitMessage(String subjectHeading,String email, String orderReference,String textmessage){
        selectSubjectHeading(subjectHeading);
        sendContactEmail(email);
        sendContactOrderreferenc(orderReference);
        sendMessageTextarea(textmessage);
        sendButtonClick();

    }
}


