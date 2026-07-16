package technocredits.technoapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import technocredits.technoapp.base.BrowserActions;

public class LoginPage extends BrowserActions {
    @FindBy(xpath = "//input[@data-testid='access-student-id']")
    WebElement studentIdElement;

    @FindBy(xpath = "//input[@data-testid='access-code']")
    WebElement accessCodeElement;

    @FindBy(xpath = "//button[@data-testid='choose-food']")
    WebElement signInFoodElement;

    @FindBy(xpath = "//button[text()= 'Continue']")
    WebElement continueBtnElement;

    @FindBy(xpath = "//button[@data-email='user@technocredits.com']")
    WebElement autoFillBtn;

    @FindBy(xpath = "//button[@data-testid='login-submit-btn']")
    WebElement loginBtn;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void doLogin(){
        System.out.println("STEP - Enter Student id");
        setText(studentIdElement, "35EGM7D45W", false);

        System.out.println("STEP - Enter Access code");
        setText(accessCodeElement, "7MNT2R2F", false);
        
        System.out.println("STEP - Click on continue button");
        driver.findElement(By.xpath("//button[text()= 'Continue']")).click();

        System.out.println("STEP - Click on Sign In Food link");
        clickOnElement(signInFoodElement, true);

        System.out.println("STEP - Click on AutoFill & SignIn as customer");
        clickOnElement(autoFillBtn, false);

        System.out.println("STEP - click on login button");
        clickOnElement(loginBtn, false);
    }
}
