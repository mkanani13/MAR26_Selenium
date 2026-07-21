package technocredits.technoapp.pages;

import org.openqa.selenium.By;

/**
 * OOPS: Method overriding concept is used here to implement waitForPageLoad method in FindFoodPage class.
 * OOPS: Encapsulation concept is used here to keep the locators private and provide public methods to interact with the elements on the page.
 * OOPS: Inheritance concept is used here to extend the CommonPage class and inherit its methods and properties.
 * OOPS: Method overloading concept is used here to provide multiple methods with the same name but different parameters to interact with the elements on the page.
 */
public class OrderSuccessPage extends CommonPage {

    private final String ORDER_PLACED_HEADER = "//h1[text()='Order placed!']";
    private final String RESTAURANT_NAME = "//strong";
    private final String AMOUNT_PAID = "//span[@data-testid='success-amount']";
    private final String ORDER_NUMBER = "//span[@data-testid='success-order-number']";
    private final String PAYMENT_MODE = "//span[text()='Paid via']/following-sibling::span";
    private final String VIEW_MY_ORDER_LINK = "//a[@data-testid='success-view-orders']";
    private final String TRACK_ORDER_LINK = "Track order";

    public void waitForPageLoad() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ORDER_PLACED_HEADER)));
        waitForElementVisibility(By.xpath(ORDER_PLACED_HEADER));
    }

    public boolean isOrderPlacedDisplayed() {
//        return driver.findElement(By.xpath(ORDER_PLACED_HEADER)).isDisplayed();
        return isElementDisplayed(By.xpath(ORDER_PLACED_HEADER), true);
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
        clickOnElement(By.linkText(TRACK_ORDER_LINK));
    }

}
