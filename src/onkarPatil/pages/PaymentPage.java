package onkarPatil.pages;

import onkarPatil.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v146.audits.model.SRIMessageSignatureError;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.PrivilegedAction;


public class PaymentPage extends BrowserActions {

    private static String CAPTCHA_CHECKBOX_ID = "pay-captcha";
    private static String PAYABLE_TOTAL_LOCATOR = "//span[@data-testid='payment-total']";
    private static String PAY_BTN_ID = "pay-btn";
    private static String TOAST_MESSAGE_LOCATOR = "//div[@data-testid='fd-toast-error']";
    private static String UPI_ID = "f-upi";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id(CAPTCHA_CHECKBOX_ID)));
    }

    public double getPayableAmt(){
        String finalPayableAmtText = driver.findElement(By.xpath(PAYABLE_TOTAL_LOCATOR)).getText().substring(1);
        return Double.parseDouble(finalPayableAmtText);
    }

    public void clickOnPayBtn(){
        driver.findElement(By.id(PAY_BTN_ID)).click();
    }

    public String getErrorMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TOAST_MESSAGE_LOCATOR)));
        return driver.findElement(By.xpath(TOAST_MESSAGE_LOCATOR)).getText();
    }

    public void addUpiId(String upiId){
        driver.findElement(By.id(UPI_ID)).sendKeys(upiId);
    }

    public void selectCheckboxForCaptcha(){
        driver.findElement(By.id(CAPTCHA_CHECKBOX_ID)).click();
    }
}
