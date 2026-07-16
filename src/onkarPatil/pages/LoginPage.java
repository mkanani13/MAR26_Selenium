package onkarPatil.pages;

import onkarPatil.base.BrowserActions;
import onkarPatil.utility.PropFileOperations;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BrowserActions {

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='access-student-id']")
    WebElement studentIdElement;

    @FindBy(xpath = "//input[@id='access-code']")
    WebElement accessCodeElement;

    @FindBy(xpath = "//button[@data-testid='access-submit-btn']")
    WebElement continueBtnElement;

    @FindBy(xpath = "//button[@data-testid='choose-food']")
    WebElement chooseFoodElement;

    @FindBy(id = "login-email")
    WebElement emailInputElement;

    @FindBy(id = "login-password")
    WebElement passwordInputElement;

    @FindBy(xpath = "//button[@data-testid='login-submit-btn']")
    WebElement loginSubmitBtnElement;

    PropFileOperations propFile = new PropFileOperations("src/onkarPatil/resources/credentials.Properties");

    public void doLogin(){
        setText(studentIdElement, propFile.getValue("STUDENT_ID"), true);
        setText(accessCodeElement, propFile.getValue("ACCESS_CODE"), false);
        clickOnElement(continueBtnElement, false);

        clickOnElement(chooseFoodElement, true);

        setText(emailInputElement, propFile.getValue("EMAIL"), true);
        setText(passwordInputElement, propFile.getValue("PASSWORD"), false);
        clickOnElement(loginSubmitBtnElement, false);
    }
}
