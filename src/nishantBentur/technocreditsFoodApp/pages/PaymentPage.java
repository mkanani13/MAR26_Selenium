package nishantBentur.technocreditsFoodApp.pages;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends BrowserActions {

    private String payAndPlaceOrder_xpath = "//button[@id='pay-btn']";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(payAndPlaceOrder_xpath)));
    }

    public void setUPIid(String upi){
        driver.findElement(By.xpath("//input[@id='f-upi']")).sendKeys(upi);
    }

    public void selectCaptchaCheckbox(){
        driver.findElement(By.xpath("//input[@id='pay-captcha']")).click();
    }

    public void clickPayAndPlaceOrderBtn(){
        driver.findElement(By.xpath(payAndPlaceOrder_xpath)).click();
    }

    public String getTotalPayable(){
        return driver.findElement(By.xpath("//span[@data-testid='payment-total']")).getText();
    }

    public boolean isErrorCaptaDisplayed(){
        WebElement errorConfirmCapta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Please confirm the captcha before paying']")));
        return errorConfirmCapta.isDisplayed();
    }

    public boolean isUPIIdErrorNotificationDisplayed(){
        WebElement upiErrorNotification  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Enter a valid UPI ID (name@bank)']")));
        return upiErrorNotification.isDisplayed();
    }


}
