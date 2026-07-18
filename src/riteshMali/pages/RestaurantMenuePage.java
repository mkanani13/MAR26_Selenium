package riteshMali.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import riteshMali.base.BrowserActions;

public class RestaurantMenuePage extends BrowserActions {

    private final String PROCEED_TO_CHECKOUT_BTN = "//button[@id='proceed-checkout-btn']";
    private final String RESTAURANT_NAME = "//h2[@data-testid='restaurant-name']";
    private final String FIRST_AVAILABLE_DISH = "//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0']/preceding-sibling::td[3]/div/div/div[1]";
    private final String DISH_QUANTITY_INPUT = "//div[text()='%s']/following::input[@type='number'][1]";
    private final String SUB_TOTAL = "//strong[@id='ot-subtotal']";

    public void waitPageLoad() {
       waitForElementVisibility(By.xpath(PROCEED_TO_CHECKOUT_BTN));
    }

    public void clickOnProceedToCheckout() {
        clickOnElement(By.xpath(PROCEED_TO_CHECKOUT_BTN));
    }

    public String getRestaurantName() {
        String restaurantMenu_RestaurantName = getTextFromElement(By.xpath(RESTAURANT_NAME));
        return restaurantMenu_RestaurantName;
    }

    public String getFirstAvailableDish() {
        String dish = getTextFromElement(By.xpath(FIRST_AVAILABLE_DISH));
        return dish;
    }

    public void setQuantityOfGivenDish(String dish, int quantity) {
        clickOnElement(By.xpath(DISH_QUANTITY_INPUT));
        for (int count = 1; count <= quantity; count++) {
            actions.sendKeys(Keys.ARROW_UP).perform();
        }
    }

    public String getSubTotal() {

        return getTextFromElement(By.xpath(SUB_TOTAL));
    }


}
