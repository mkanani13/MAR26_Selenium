package riteshMali.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import riteshMali.base.BrowserActions;

public class OrderSuccessPage extends BrowserActions {
    private WebElement orderPlacedHeaderElement;

    public void waitForPageLoad() {
        orderPlacedHeaderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Order placed!']")));
    }

    public boolean isOrderPlacedDisplayed() {
        return orderPlacedHeaderElement.isDisplayed();
    }

    public String getRestaurantName() {
        return driver.findElement(By.xpath("//strong")).getText();
    }

    public String getAmtPaid() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='success-amount']"))).getText();
    }

    public String getOrderNumber() {
        return driver.findElement(By.xpath("//span[@data-testid='success-order-number']")).getText();
    }

    public String getPaymentMode() {
        return driver.findElement(By.xpath("//span[text()='Paid via']/following-sibling::span")).getText();
    }

    public void clickOnViewMyOrder() {
        driver.findElement(By.xpath("//a[@data-testid='success-view-orders']")).click();
    }

    public void clickOnTrackOrder() {
        driver.findElement(By.linkText("Track order")).click();
    }


}
