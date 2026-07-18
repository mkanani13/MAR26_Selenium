package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.base.BrowserActions;
import org.openqa.selenium.By;

public class SignInPage extends BrowserActions {

    public final String LOGINBUTTONXPATH = "//button[@data-testid='login-submit-btn']";

    public void waitForPageLoad(){
        BrowserActions.visibilityOfElementLocated(By.xpath(LOGINBUTTONXPATH));
    }

    public void doSignIn(String email, String password){
        System.out.println("STEP - Enter Email ID");
        driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys(email);

        System.out.println("STEP - Enter Password");
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys(password);

        System.out.println("STEP - Click Sign in to Food app");
        driver.findElement(By.xpath(LOGINBUTTONXPATH)).click();
    }
}
