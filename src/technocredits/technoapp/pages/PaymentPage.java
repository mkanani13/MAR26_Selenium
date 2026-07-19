package technocredits.technoapp.pages;

import org.openqa.selenium.By;


/**
 * OOPS: Method overriding concept is used here to implement waitForPageLoad method in FindFoodPage class.
 * OOPS: Encapsulation concept is used here to keep the locators private and provide public methods to interact with the elements on the page.
 * OOPS: Inheritance concept is used here to extend the CommonPage class and inherit its methods and properties.
 * OOPS: Method overloading concept is used here to provide multiple methods with the same name but different parameters to interact with the elements on the page.
 */
public class PaymentPage extends CommonPage {

    private final String PAY_PLACE_ORDER_BTN = "//button[@id='pay-btn']";
    private final String TOTAL_PAYABLE = "//span[@data-testid='payment-total']";
    private final String ERROR_CAPTCHA_MSG = "//div[text()='Please confirm the captcha before paying']";
    private final String CAPTCHA_CHECKBOX = "//input[@id='pay-captcha']";
    private final String UPI_ID_ERROR_MSG = "//div[text()='Enter a valid UPI ID (name@bank)']";
    private final String UPI_ID_INPUT = "//input[@id='f-upi']";

    public void waitForPageLoad() {
        waitForElementVisibility(By.xpath(PAY_PLACE_ORDER_BTN));
    }

    public void clickOnPayPlaceOrderBtn() {
        clickOnElement(By.xpath(PAY_PLACE_ORDER_BTN));
    }

    public String getTotalPayable() {
        return getTextFromElement(By.xpath(TOTAL_PAYABLE));
    }

    public boolean isErrorCaptaDisplayed() {
        return isElementDisplayed(By.xpath(ERROR_CAPTCHA_MSG));
    }

    public void clickOnCaptaCheckbox() {
        clickOnElement(By.xpath(CAPTCHA_CHECKBOX));
    }

    public boolean isUPIIdErrorNotificationDisplayed() {
        return isElementDisplayed(By.xpath(UPI_ID_ERROR_MSG));
    }

    public void setUPIId(String upiId) {
        setTextOnElement(By.xpath(UPI_ID_INPUT), upiId);
    }
}
