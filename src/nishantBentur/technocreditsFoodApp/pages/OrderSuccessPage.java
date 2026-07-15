package nishantBentur.technocreditsFoodApp.pages;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderSuccessPage extends BrowserActions {
    private String viewMyOrders_xpath = "//a[@data-testid='success-view-orders']";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewMyOrders_xpath)));
    }

    public boolean isOrderPlacedDisplayed(){
        return driver.findElement(By.xpath("//h1[text()='Order placed!']")).isDisplayed();
    }

    public String getRestaurantName(){
        return driver.findElement(By.xpath("//strong")).getText();
    }

    public String getAmountPaid(){
        return driver.findElement(By.xpath("//span[@data-testid='success-amount']")).getText();
    }

    public String getPaymentMethod(){
        return driver.findElement(By.xpath("//span[text()='Paid via']/following-sibling::span")).getText();
    }

    public void clickViewMyOrdersBtn(){
        driver.findElement(By.xpath("//a[@data-testid='success-view-orders']")).click();
    }

    public String getOrderID(){
        return driver.findElement(By.xpath("//span[@data-testid='success-order-number']")).getText();
    }

}
