package technocredits.technoapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
<<<<<<< HEAD
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import technocredits.technoapp.base.BrowserActions;

public class RestauarantMenuPage extends BrowserActions {
    private WebElement proceedToCheckoutBtn;

    public void waitForPage(){
        proceedToCheckoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='proceed-checkout-btn']")));
    }

    public void clickOnProceedToCheckout(){
        proceedToCheckoutBtn.click();
    }

    public String getRestaurantName(){
        String restaurantMenu_RestaurantName = driver.findElement(By.xpath("//h2[@data-testid='restaurant-name']")).getText();
        return restaurantMenu_RestaurantName;
    }

    public String getFirstAvailableDish(){
        String dish = driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/preceding-sibling::td[3]/div/div/div[1]")).getText();
        return dish;
    }

    public void setQuantityOfGivenDish(String dish, int quantity){
        driver.findElement(By.xpath("//div[text()='"+dish+"']/following::input[@type='number'][1]")).click();
        for(int count=1;count<=quantity;count++){
=======

/**
 * OOPS: Method overriding concept is used here to implement waitForPageLoad method in FindFoodPage class.
 * OOPS: Encapsulation concept is used here to keep the locators private and provide public methods to interact with the elements on the page.
 * OOPS: Inheritance concept is used here to extend the CommonPage class and inherit its methods and properties.
 * OOPS: Method overloading concept is used here to provide multiple methods with the same name but different parameters to interact with the elements on the page.
 */
public class RestauarantMenuPage extends CommonPage {

    private final String PROCEED_TO_CHECKOUT_BTN = "//button[@data-testid='proceed-checkout-btn']";
    private final String RESTAURANT_NAME = "//h2[@data-testid='restaurant-name']";
    private final String FIRST_AVAILABLE_DISH = "(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/preceding-sibling::td[3]/div/div/div[1]";
    private final String DISH_QUANTITY_INPUT = "//div[text()='%s']/following::input[@type='number'][1]";
    private final String SUB_TOTAL = "//strong[@id='ot-subtotal']";

    public void waitForPage() {
        waitForElementVisibility(By.xpath(PROCEED_TO_CHECKOUT_BTN));
    }

    public void clickOnProceedToCheckout() {
        clickOnElement(By.xpath(PROCEED_TO_CHECKOUT_BTN));
    }

    public String getRestaurantName() {
        return getTextFromElement(By.xpath(RESTAURANT_NAME));
    }

    public String getFirstAvailableDish() {
        return getTextFromElement(By.xpath(FIRST_AVAILABLE_DISH));
    }

    public void setQuantityOfGivenDish(String dish, int quantity) {
        clickOnElement(By.xpath(String.format(DISH_QUANTITY_INPUT, dish)));
        for (int count = 1; count <= quantity; count++) {
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
            actions.sendKeys(Keys.ARROW_UP).perform();
        }
    }

<<<<<<< HEAD
    public String getSubTotal(){
        String subTotalText = driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText();
        return subTotalText;
=======
    public String getSubTotal() {
        return getTextFromElement(By.xpath(SUB_TOTAL));
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
    }
}
