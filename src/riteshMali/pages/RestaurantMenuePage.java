package riteshMali.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import riteshMali.base.BrowserActions;

public class RestaurantMenuePage extends BrowserActions {

    private WebElement proceedToCheckout_Btn;

    public void waitPageLoad() {
        proceedToCheckout_Btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='proceed-checkout-btn']")));
    }

    public void clickOnProceedToCheckout() {
        proceedToCheckout_Btn.click();
    }

    public String getRestaurantName() {
        String restaurantMenu_RestaurantName = driver.findElement(By.xpath("//h2[@data-testid='restaurant-name']")).getText();
        return restaurantMenu_RestaurantName;
    }


}
