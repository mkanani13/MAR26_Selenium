package nishantBentur.technocreditsFoodApp.pages;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderSummary_CheckoutPage extends BrowserActions {

    private String continueToPaymentBtn_xpath = "//button[@id='co-continue']";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(continueToPaymentBtn_xpath)));
    }

    public void setDeliveryAddress(String address){
        driver.findElement(By.xpath("//textarea[@id='co-address']")).sendKeys(address);
    }

    public void setContactNumber(String contactNumber){
        driver.findElement(By.xpath("//input[@id='co-mobile']")).sendKeys(contactNumber);
    }

    public String getTotalPayableAmount(){
        String orderSummaryPage_TotalPayableAmt = driver.findElement(By.xpath("//span[@data-testid='checkout-payable']")).getText();
        return orderSummaryPage_TotalPayableAmt;
    }

    public void clickContinueToPaymentBtn(){
        driver.findElement(By.xpath(continueToPaymentBtn_xpath)).click();
    }
}
