package onkarPatil.pages;

import onkarPatil.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderSummary_CheckoutPage extends BrowserActions {

    public OrderSummary_CheckoutPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@data-testid='checkout-payable']")
    WebElement paymentAmtElement;

    @FindBy(id = "co-address")
    WebElement addressElement;

    @FindBy(id = "co-mobile")
    WebElement mobileElement;

    @FindBy(id = "co-continue")
    WebElement continueBtnElement;


    public void waitForPageLoad(){
        waitUntilElementIsVisible(paymentAmtElement);
    }

    public double getPayableAmt(){
        String payebleAmtText = getTextOfElement(paymentAmtElement, false).substring(1);
        return Double.parseDouble(payebleAmtText);
    }

    public void enterDeliveryAddress(String address){
        setText(addressElement, address, false);
    }

    public void enterMobileNumber(String mobileNum){
        setText(mobileElement, mobileNum, false);
    }

    public void clickOnContinueOutBtn(){
        clickOnElement(continueBtnElement, false);
    }
}
