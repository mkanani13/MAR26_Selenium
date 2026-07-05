package vishwajeetLoni.TCs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import vishwajeetLoni.base.ActionOnBrowser;

public class OrderPlacedPage extends ActionOnBrowser {

    public void waitForPageLoad(){
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-testid='success-track-order']")));
    }

    public String orderNumber(){
       return driver.findElement(By.xpath("//span[text()= 'Order number']/following-sibling::span[1]")).getText();
    }

    public boolean isOrderPlacedDisplayed(){
        return driver.findElement(By.xpath("//h1[text()= 'Order placed!']")).isDisplayed();
    }
    public String getRestaurantName(){
        return driver.findElement(By.xpath("//strong")).getText();
    }

    public String getAmtPaid(){
        return driver.findElement(By.xpath("//span[@data-testid='success-amount']")).getText();
    }

    public String getOrderNumber(){
        return driver.findElement(By.xpath("//span[@data-testid='success-order-number']")).getText();
    }

    public String getPaymentMode(){
        return driver.findElement(By.xpath("//span[text()='Paid via']/following-sibling::span")).getText();
    }

    public void clickOnViewMyOrder(){
        driver.findElement(By.xpath("//a[@data-testid='success-view-orders']")).click();
    }

    FindFoodPage findFoodPage = new FindFoodPage();
    public void VerifyRestaurantName(){
        String findFppfpageResName = findFoodPage.RestaurantHavingDishes();

    }

    public void clickOnTrackOrder(){
        driver.findElement(By.xpath("//a[@data-testid = 'success-track-order']")).click();
    }
}
