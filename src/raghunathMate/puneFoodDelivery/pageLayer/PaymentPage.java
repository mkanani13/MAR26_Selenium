package raghunathMate.puneFoodDelivery.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import raghunathMate.puneFoodDelivery.testBase.BrowserAction;

public class PaymentPage extends BrowserAction {
    private WebElement payAndPlaceOrderButton;

    public void waitForPageLoad() {
        payAndPlaceOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='pay-place-order']")));
    }

    public void clickOnPayAndPlaceOrderButton() {
        payAndPlaceOrderButton.click();
    }

    public void enterUPIId(String upiId) {
        driver.findElement(By.xpath("//input[@id='f-upi']")).sendKeys(upiId);
    }

    public void clickingCheckBoxOfIAmNotRobot() {
        driver.findElement(By.xpath("//input[@data-testid='payment-captcha']")).click();
    }

    public String getPayableAmtFromBillSection() {
        return driver.findElement(By.xpath("//span[@data-testid='payment-total']")).getText();
    }

    public boolean isErrorMsgNotificationForWithoutClickingIamNotRobotCheckBoxProceed(){
        WebElement errorMsgNotificationForIamNotRomotCheckBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Please confirm the captcha before paying']")));
        boolean errorMsgNotificationForIamNotRomotCheckBoxFlag = errorMsgNotificationForIamNotRomotCheckBox.isDisplayed();
        return errorMsgNotificationForIamNotRomotCheckBoxFlag;
    }

    public boolean isErrorMsgForWithoutEnterUIPIdProceed(){
        WebElement ErrorMsgForWithoutEnterUIPIdProceed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='fd-toast-error']")));
        boolean ErrorMsgForWithoutEnterUIPIdProceedFlag = ErrorMsgForWithoutEnterUIPIdProceed.isDisplayed();
        return ErrorMsgForWithoutEnterUIPIdProceedFlag;
    }
}
