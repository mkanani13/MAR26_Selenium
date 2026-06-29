package jayeshSonawane.technocreditsFoodAppWithFramework.pages;

import jayeshSonawane.technocreditsFoodAppWithFramework.base.BrowserActions;
import org.openqa.selenium.By;

public class FindFoodPaymentPage extends BrowserActions {

    public final String PAYANDPLACEORDERBUTTONXPATH = "//button[@id='pay-btn']";

    public void waitForPageLoad(){
        BrowserActions.visibilityOfElementLocated(By.xpath(PAYANDPLACEORDERBUTTONXPATH));
    }

    public void clickOnPlaceOrderButton(){
        driver.findElement(By.xpath(PAYANDPLACEORDERBUTTONXPATH)).click();
    }

    public void payUsingUPI(){
        clickOnPlaceOrderButton();
        driver.findElement(By.id("pay-captcha")).click();
        clickOnPlaceOrderButton();
        System.out.println("Enter UPI ID");
        driver.findElement(By.id("f-upi")).sendKeys("jayesh@hdfc");
    }
}
