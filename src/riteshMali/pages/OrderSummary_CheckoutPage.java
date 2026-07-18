package riteshMali.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import riteshMali.base.BrowserActions;

public class OrderSummary_CheckoutPage extends BrowserActions {
    private final String CONTINUE_TO_PAYMENT_BTN = "//button[@id='co-continue']";
    private final String DELIVERY_ADDRESS_INPUT = "//textarea[@id='co-address']";
    private final String PHONE_NO_INPUT= "//input[@id='co-mobile']";
    private final String TOTAL_PAYABLE_AMOUNT = "//span[@data-testId='checkout-payable']";

    public void waitForPAgeLoad(){
       waitForElementVisibility(By.xpath(CONTINUE_TO_PAYMENT_BTN));
    }

    public void clickOnContinueToPaymentBtn(){
       clickOnElement(By.xpath(CONTINUE_TO_PAYMENT_BTN));
    }

    public void setDeliveryAddress(String address){
     setTextOnElement(By.xpath(DELIVERY_ADDRESS_INPUT), address);
    }

    public void setPhoneNo(String phNo){
        setTextOnElement(By.xpath(PHONE_NO_INPUT), phNo);
    }

    public String getTotalPayableAmount(){
      return  getTextFromElement(By.xpath(TOTAL_PAYABLE_AMOUNT));
    }

}
