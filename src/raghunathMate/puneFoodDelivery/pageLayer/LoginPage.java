package raghunathMate.puneFoodDelivery.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import raghunathMate.puneFoodDelivery.testBase.BrowserAction;

public class LoginPage extends BrowserAction {
    private WebElement signInButton;
    public void waitForPageLoad(){
        signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
    }

    public void loginToApplication() {
        System.out.println("Entering customer mail and password and logged in");
        driver.findElement(By.xpath("//input[@data-testid='login-email']")).sendKeys("raghu.customer@technocredits.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("raghuCust@12345");
        signInButton.click();
        WebElement invalidCredentialsMsg  = driver.findElement(By.xpath("//p[@data-testid='fd-error']"));
        boolean msgDisplayedFlag = invalidCredentialsMsg.isDisplayed();
        Assert.assertFalse(msgDisplayedFlag,"Invalid credential not able to sign in");
        System.out.println("logged in successfully");
    }

}
