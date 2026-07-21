package raghunathMate.puneFoodDelivery.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import raghunathMate.puneFoodDelivery.testBase.BrowserAction;

public class OrderSuccessPage extends BrowserAction {
    private WebElement viewMyOrderButton;

    public void waitForPageLoad(){
        viewMyOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='View my orders']")));
    }

    public String getOrderId() {
        return driver.findElement(By.xpath("//span[@data-testid = 'success-order-number']")).getText();
    }
    public void clickOnViewMyOrderButton(){
        viewMyOrderButton.click();
    }

    public void getOrderDetailsFromOrderSuccessPage() {
       String orderCard =  driver.findElement(By.xpath("//div[@class='inline-block text-left bg-slate-50 border rounded-xl px-6 py-4 space-y-1 text-sm']")).getText();
    }

    public void clickOnTrackOrderButton(){
        driver.findElement(By.xpath("//a[@data-testid='success-track-order']")).click();
    }

    public String getRestroNameFromOrderSuccessPage(){
        return driver.findElement(By.xpath("//strong[text()='Balance Brew Cafe']")).getText();
    }

    public String getPaidAmtFromOrderSuccessPage(){
        return driver.findElement(By.xpath("//span[@data-testid='success-amount']")).getText();
    }
}
