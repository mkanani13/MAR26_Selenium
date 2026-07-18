package riteshMali.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import riteshMali.base.BrowserActions;

public class OrderSuccessPage extends BrowserActions {
    private WebElement orderPlacedHeaderElement;

    private final String ORDER_PLACED_HEADER = "//h1[text()='Order placed!']";
    private final String RESTAURANT_NAME= "//strong";
    private final String AMOUNT_PAID = "//span[@data-testid='success-amount']";
    private final String ORDER_NUMBER = "//span[@data-testid='success-order-number']";
    private final String PAYMENT_MODE = "//span[text()='Paid via']/following-sibling::span";
    private final String VIEW_MY_ORDER_LINK = "//a[@data-testid='success-view-orders']";
    private final String TRACK_ORDER_LINK = "Track order";



    public void waitForPageLoad() {
        waitForAllElementsVisibility(By.xpath(ORDER_PLACED_HEADER));
    }

    public boolean isOrderPlacedDisplayed() {
        return isElementDisplayed(By.xpath(ORDER_PLACED_HEADER));
    }

    public String getRestaurantName() {
        return getTextFromElement(By.xpath(RESTAURANT_NAME));
    }

    public String getAmtPaid() {
        return getTextFromElement(By.xpath(AMOUNT_PAID));
    }

    public String getOrderNumber() {
        return getTextFromElement(By.xpath(ORDER_NUMBER));
    }

    public String getPaymentMode() {
        return getTextFromElement(By.xpath(PAYMENT_MODE));
    }

    public void clickOnViewMyOrder() {
        clickOnElement(By.xpath(VIEW_MY_ORDER_LINK));
    }

    public void clickOnTrackOrder() {
        clickOnElement(By.xpath(TRACK_ORDER_LINK));
    }


}
