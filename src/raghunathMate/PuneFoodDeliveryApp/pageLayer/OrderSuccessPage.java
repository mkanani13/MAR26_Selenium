package raghunathMate.PuneFoodDeliveryApp.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import raghunathMate.PuneFoodDeliveryApp.testBase.BrowserAction;

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
}
