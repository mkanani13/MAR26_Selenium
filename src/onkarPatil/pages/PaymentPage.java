package onkarPatil.pages;

import onkarPatil.base.BrowserActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PaymentPage extends BrowserActions {

    public PaymentPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "pay-captcha")
    WebElement capthaCheckboxElement;

    @FindBy(xpath = "//span[@data-testid='payment-total']")
    WebElement payableTotalElement;

    @FindBy(id = "pay-btn")
    WebElement payBtnElement;

    @FindBy(xpath = "//p[@id='err-pay-captcha']")
    WebElement toastMessageElement;

    @FindBy(id = "f-upi")
    WebElement upiIdElement;


    public void waitForPageLoad(){
        waitUntilElementIsClickable(capthaCheckboxElement);
    }

    public double getPayableAmt(){
        String finalPayableAmtText = getTextOfElement(payableTotalElement, false).substring(1);
        return Double.parseDouble(finalPayableAmtText);
    }

    public void clickOnPayBtn(){
        clickOnElement(payBtnElement, false);
    }

    public String getErrorMsg(){
        return getTextOfElement(toastMessageElement, true);
    }

    public void addUpiId(String upiId){
        setText(upiIdElement, upiId, false);
    }

    public void selectCheckboxForCaptcha(){
        clickOnElement(capthaCheckboxElement, false);
    }
}
