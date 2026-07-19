package smratiGarg.PageFactory.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import smratiGarg.PageFactory.base.BrowserAction;

public class  LoginPage extends BrowserAction {
    @FindBy(xpath = "//input[@id='access-student-id']")
    WebElement studentIdElement;

    @FindBy(xpath = "//input[@id='access-code']")
    WebElement accessCodeElement;

    @FindBy(xpath ="//form[@id='access-form']/button")
    WebElement clickButton;

    @FindBy(xpath = "//button[@data-testid='choose-food']")
    WebElement foodapp;

    @FindBy(xpath ="//input[@id='login-email']" )
    WebElement studentid;

    @FindBy(xpath = "//input[@id='login-password']")
    WebElement studentPassword;

    @FindBy(xpath = "//button[@data-testid='login-submit-btn']")
    WebElement submitButton;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public void doLogin(){
        // -------> LoginPage
        System.out.println("enter access id and password and click");
        setText(studentIdElement,"39WJAEGT2P",true);

        System.out.println("enter Access code");
        setText(accessCodeElement,"ZJ9KCRZQ");

        System.out.println("click on continue button");
        clickOnElement(clickButton);

        // -------> AppSelectingPage
        System.out.println("enter food app");
        clickOnElement(foodapp, true);

        // -------> FoodAppLoginPage
        System.out.println("customer id and password");
        setText(studentid,"smrati@technocredits.com");
        setText(studentPassword,"pass@123");
        clickOnElement(submitButton);

    }
}


