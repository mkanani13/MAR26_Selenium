package riteshMali.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import riteshMali.base.BrowserActions;

public class PaymentPage extends BrowserActions {

    WebElement payPlaceOrderBtn;

    public void waitForPageLoad(){
        payPlaceOrderBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='pay-btn']")));
    }

    public void clickOnPayPlaceOrderBtn(){
        payPlaceOrderBtn.click();
    }

    public String getTotalPayable(){
        WebElement totalPayable  = driver.findElement(By.xpath("//span[@data-testid='payment-total']"));
        return totalPayable.getText();
    }

    public boolean isErrorCaptaDisplayed(){
        WebElement errorConfirmCapta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Please confirm the captcha before paying']")));
        return errorConfirmCapta.isDisplayed();
    }

    public void clickOnCaptaCheckbox(){
        driver.findElement(By.xpath("//input[@id='pay-captcha']")).click();
    }

//    public boolean isUPIIdErrorNotificationDisplayed(){
//        WebElement upiErrorNotification  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Enter a valid UPI ID (name@bank)']")));
//        return upiErrorNotification.isDisplayed();
//    }

    public void setUPIId(String upiId){
        driver.findElement(By.xpath("//input[@id='f-upi']")).sendKeys(upiId);
    }
}
