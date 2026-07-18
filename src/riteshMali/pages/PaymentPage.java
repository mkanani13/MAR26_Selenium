package riteshMali.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import riteshMali.base.BrowserActions;

public class PaymentPage extends BrowserActions {
    private final String PAY_PLACE_ORDER_BTN = "//button[@id='pay-btn']";
    private final String TOTAL_PAYABLE = "//span[@data-testid='payment-total']";
    private final String ERROR_CAPTCHA_MSG = "//div[text()='Please confirm the captcha before paying']";
    WebElement checkbox = waitForElementVisibility(By.xpath("//input[@id='pay-captcha']"));
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
        markCheckbox(checkbox);
    }

    public boolean isUPIIdErrorNotificationDisplayed() {
        return isElementDisplayed(By.xpath(UPI_ID_ERROR_MSG));
    }

    public void setUPIId(String upiId) {
        setTextOnElement(By.xpath(UPI_ID_INPUT), upiId);
    }
}
