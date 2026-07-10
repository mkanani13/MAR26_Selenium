package vishwajeetLoni.TCs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import vishwajeetLoni.base.ActionOnBrowser;

public class PaymentPage extends ActionOnBrowser {

    private WebElement payAndPlaceorderBtn;

    public void waitForPageLoad(){
        payAndPlaceorderBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='pay-place-order']")));
    }

    public void payAndPlaceorderBtnClick () {
        payAndPlaceorderBtn.click();
    }

    public String totalPayableAmt(){
        return driver.findElement(By.xpath("//span[text()='Total payable']/following-sibling::span")).getText();
    }

    public void UPIclick(){
        driver.findElement(By.xpath("//button[@data-testid='pm-tab-UPI']")).click();
    }

    public void enterUpiId(String UPIid){
        driver.findElement(By.xpath("//input[@id='f-upi']")).sendKeys(UPIid);
    }

    public void clearUpiId(){
        driver.findElement(By.xpath("//input[@id='f-upi']")).clear();
    }

    public void selectCaptchaCheckbox() {
        driver.findElement(By.xpath("//input[@id='pay-captcha']")).click();
    }

    public boolean isErrorCaptaDisplayed(){
        WebElement errorConfirmCapta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Please confirm the captcha before paying']")));
        return errorConfirmCapta.isDisplayed();
    }

    public boolean isUPIIdErrorNotificationDisplayed(){
        WebElement upiErrorNotification  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Enter a valid UPI ID (name@bank)']")));
        return upiErrorNotification.isDisplayed();
    }

    public boolean isUPIIdRequiredErrorDisplayed(){
        WebElement upiErrorNotification  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='UPI ID is required']")));
        return upiErrorNotification.isDisplayed();
    }

}
