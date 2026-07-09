package onkarPatil.pages;

import onkarPatil.base.BrowserActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RestarantMenuPage extends BrowserActions {

    private static String RESTAURANT_NAME_LOCATOR = "//h2[@data-testid='restaurant-name']";
    private static String INPUT_QUANTITY_FOR_FIRST_AVAILABLE_DISH_LOCATOR = "(//tr[contains(@data-testid,'menu-row-dish')]/td[4][text()!='0'])[1]/following-sibling::td/input";
    private static String COUPAN_CODE_LOCATOR = "coupon-code";
    private static String CHECKOUT_BTN_ID = "proceed-checkout-btn";
    private static String SUBTOTAL_ID = "ot-subtotal";
    private static String DISCOUNT_ID = "ot-discount";
    private static String TOTAL_AMOUNT_ID = "ot-total";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RESTAURANT_NAME_LOCATOR)));
    }

    public String getRestaurantName(){
        return driver.findElement(By.xpath(RESTAURANT_NAME_LOCATOR)).getText();
    }

    public void addFirstAvailableDishInCart(int quantity){
        WebElement addToCart = driver.findElement(By.xpath(INPUT_QUANTITY_FOR_FIRST_AVAILABLE_DISH_LOCATOR));
        addToCart.click();
        for(int i=1; i<=quantity; i++){
            actions.sendKeys(Keys.ARROW_UP).perform();
        }
    }

    public int getAvailbleQuantity(){
        WebElement addToCart = driver.findElement(By.xpath(INPUT_QUANTITY_FOR_FIRST_AVAILABLE_DISH_LOCATOR));
        String value = addToCart.getAttribute("value");
        return Integer.parseInt(value);
    }

    public void selectCoupanFromDropdown(){
        WebElement selectDropdown = driver.findElement(By.id(COUPAN_CODE_LOCATOR));
        Select select = new Select(selectDropdown);
        select.selectByValue("PUNE50");
    }

    public double getSubTotalAmount(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id(CHECKOUT_BTN_ID)));
        String subTotalAmtText = driver.findElement(By.id(SUBTOTAL_ID)).getText().substring(1);
        return Double.parseDouble(subTotalAmtText);
    }

    public double getDiscountAmt(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id(CHECKOUT_BTN_ID)));
        String discountAmtText = driver.findElement(By.id(DISCOUNT_ID)).getText().substring(1);
        return Double.parseDouble(discountAmtText);
    }

    public double getTotalPayableAmt(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id(CHECKOUT_BTN_ID)));
        String totalAmtText = driver.findElement(By.id(TOTAL_AMOUNT_ID)).getText().substring(1);
        return Double.parseDouble(totalAmtText);
    }

    public void clickOnCheckoutBtn(){
        driver.findElement(By.id(CHECKOUT_BTN_ID)).click();
    }
}
