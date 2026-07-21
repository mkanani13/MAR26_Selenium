package onkarPatil.pages;

import onkarPatil.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderSummary_CheckoutPage extends BrowserActions {

    private static String PAYABLE_AMT_LOCATOR = "//span[@data-testid='checkout-payable']";
    private static String ADDRESS_ID = "co-address";
    private static String MOBILE_ID = "co-mobile";
    private static String CONTINUE_BTN_ID = "co-continue";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PAYABLE_AMT_LOCATOR)));
    }

    public double getPayableAmt(){
        String payebleAmtText = driver.findElement(By.xpath(PAYABLE_AMT_LOCATOR)).getText().substring(1);
        return Double.parseDouble(payebleAmtText);
    }

    public void enterDeliveryAddress(String address){
        driver.findElement(By.id(ADDRESS_ID)).sendKeys(address);
    }

    public void enterMobileNumber(String mobileNum){
        driver.findElement(By.id(MOBILE_ID)).sendKeys(mobileNum);
    }

    public void clickOnContinueOutBtn(){
        driver.findElement(By.id(CONTINUE_BTN_ID)).click();
    }
}
