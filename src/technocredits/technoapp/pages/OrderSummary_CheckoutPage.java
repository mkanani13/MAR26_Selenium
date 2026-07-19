package technocredits.technoapp.pages;

import org.openqa.selenium.By;


/**
 * OOPS: Method overriding concept is used here to implement waitForPageLoad method in FindFoodPage class.
 * OOPS: Encapsulation concept is used here to keep the locators private and provide public methods to interact with the elements on the page.
 * OOPS: Inheritance concept is used here to extend the CommonPage class and inherit its methods and properties.
 * OOPS: Method overloading concept is used here to provide multiple methods with the same name but different parameters to interact with the elements on the page.
 */
public class OrderSummary_CheckoutPage extends CommonPage {

    private final String CONTINUE_TO_PAYMENT_BTN = "//button[@data-testid='checkout-continue']";
    private final String DELIVERY_ADDRESS_INPUT = "//textarea[@id='co-address']";
    private final String PHONE_NUMBER_INPUT = "//input[@id='co-mobile']";
    private final String TOTAL_PAYABLE_AMOUNT = "//span[@data-testid='checkout-payable']";

    public void waitForPageLoad() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CONTINUE_TO_PAYMENT_BTN)));
        waitForElementVisibility(By.xpath(CONTINUE_TO_PAYMENT_BTN));
    }

    public void clickOnContinueToPaymentBtn() {
        clickOnElement(By.xpath(CONTINUE_TO_PAYMENT_BTN));
    }

    public void setDeliveryAddress(String address) {
        setTextOnElement(By.xpath(DELIVERY_ADDRESS_INPUT), address);
    }

    public void setPhoneNum(String phNum) {
        setTextOnElement(By.xpath(PHONE_NUMBER_INPUT), phNum);
    }

    public String getTotalPayableAmt() {
        return getTextFromElement(By.xpath(TOTAL_PAYABLE_AMOUNT));
    }
}
